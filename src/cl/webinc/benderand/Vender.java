package cl.webinc.benderand;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import cl.webinc.benderand.entidad.Carro_comprascompleto;
import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.provider.Base.carro_compras;
import cl.webinc.benderand.provider.Base.carro_comprascompleto;
import cl.webinc.benderand.provider.Base.carro_venta;
import cl.webinc.benderand.provider.Base.productoprecio;
import cl.webinc.benderand.provider.Base.venta;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.util.CurrencyFormatter;
import cl.webinc.benderand.util.CursortoArrayEntidad;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.CustomAdaptervender;
import cl.webinc.benderand.util.ProjectionCreater;

public class Vender extends AppCompatActivity
{
    private ListView lv;
    private TextView txtvalortotal;
	protected ArrayList<Carro_comprascompleto> mylist;
	protected ListAdapter adapter;
	private String TAG = "dashboardtienda";
	private HashMap<String, String> map = new HashMap<>();
	private HashMap<String, String> hash;
	private Spinner spid_tipo_pago;
	private Spinner spid_tipo_documento;
	private Button btnCobrar;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboardtienda2);
		setTitle(R.string.estaventa);
        lv = (ListView) findViewById(R.id.listViewCarro);
		lv.setHeaderDividersEnabled(true);
		LayoutInflater inflater = getLayoutInflater();
		View header = inflater.inflate(R.layout.header, lv, false);
		lv.addHeaderView(header, null, false);
        txtvalortotal = (TextView) findViewById(R.id.txtvalortotal);
	}
    
    @Override
    protected void onResume ()
    {
    	super.onResume();
        Log.e(TAG, "onResume");
        Button btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Vender.this, ListaProductos.class);
				startActivityForResult(i, 0);
				Log.e("btnAgregar  ", "" + i);
			}
		});
        Button btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(Vender.this);
            	 myAlertDialog.setTitle(R.string.lblcancelarventa);
            	 myAlertDialog.setMessage(R.string.lblestasegurodecancelarestaventa);
            	 myAlertDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            		 public void onClick(DialogInterface arg0, int arg1) {
                     	new sincTaskEliminar().execute();
         		        Log.e("btnLimpiar ", "");
		        	  }});
            	 myAlertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {            	       
					public void onClick(DialogInterface arg0, int arg1) {
					}});
            	 myAlertDialog.show();
            }        
        });
        btnCobrar = (Button) findViewById(R.id.btnCobrar);
        btnCobrar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final Dialog dialog = new Dialog(Vender.this);
				dialog.setContentView(R.layout.dialogtipoventa);
				dialog.setTitle(R.string.lblopciones);
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				spid_tipo_pago = (Spinner) dialog.findViewById(R.id.spdtvtipo_pago_id_tipo_pago);
				spid_tipo_documento = (Spinner) dialog.findViewById(R.id.spdtvtipo_documento_id_tipo_documento);
				final EditText etapagocon = (EditText) dialog.findViewById(R.id.etapagocon);
				final EditText etvuelto = (EditText) dialog.findViewById(R.id.etvuelto);
				etapagocon.addTextChangedListener(new TextWatcher() {
					public void beforeTextChanged(CharSequence s, int start, int count, int after) {
					}

					public void onTextChanged(CharSequence s, int start, int before, int count) {
						Log.e("valor pago", "" + etapagocon.getText().toString());
						if (!etapagocon.getText().toString().isEmpty()) {
							Double pago = Double.valueOf(etapagocon.getText().toString()) - Double.valueOf(hash.get(venta.total));
							etvuelto.setText(String.valueOf(CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", pago)));
						} else {
							etvuelto.setText(String.valueOf(CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", 0)));
						}
					}

					public void afterTextChanged(Editable s) {
					}
				});

				new sincTaskcargaspinners().execute();
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						//@SuppressWarnings("unchecked")
						//HashMap<String, String> o = (HashMap<String, String>) l.getItemAtPosition(position);
						map.put(venta.tipo_pago_id_tipo_pago, String.valueOf(spid_tipo_pago.getSelectedItemPosition() + 1));
						map.put(venta.tipo_documento_id_tipo_documento, String.valueOf(spid_tipo_documento.getSelectedItemPosition() + 1));
						Log.e("btnpagar spinner", "sppago spdocu " + String.valueOf(spid_tipo_pago.getSelectedItemPosition()) + " "
								+ String.valueOf(spid_tipo_documento.getSelectedItemPosition()));
						new sincTaskPagar().execute();
						dialog.dismiss();
					}
				});
				dialog.show();
				Log.e("btnCobrar ", "");
			}
		});
		new sincTask().execute();
	}
    
    
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	    final AdapterView.AdapterContextMenuInfo info;
	    try {
	         info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
	         Log.e(TAG, "menuInfo" + info.position);
	    } catch (ClassCastException e) {
	        Log.e(TAG, "bad menuInfo", e);
	        return false;
	    }
	    switch (item.getItemId()) {
	        case Menu.FIRST: {
	        	final Dialog dialog = new Dialog(Vender.this);
	    		dialog.setContentView(R.layout.dialognumberpicker);
	    		dialog.setTitle(R.string.lblagregueunacantidad);
				TextView text = (TextView) dialog.findViewById(R.id.text);
	    		text.setText(R.string.lblseleccioneunacantidad);
	    		final EditText mcant = (EditText) dialog.findViewById(R.id.editcant);
	    		mcant.setText("1");
	
	    		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
	    		// if button is clicked, close the custom dialog
	    		dialogButton.setOnClickListener(new View.OnClickListener() { 
	    			public void onClick(View v) 
	                {
	    				if(mcant.getText().toString().isEmpty())
	    				{
	    					Toast.makeText(Vender.this, R.string.lbldebesingresarunnumero, Toast.LENGTH_LONG).show();
	    				}
	    				else
	    				{
	    	            	String cantidad = mcant.getText().toString();
	    					dialog.dismiss();
							Carro_comprascompleto producto = mylist.get(info.position);
	    			    	map.put(carro_compras.producto_id_producto, producto.getId_producto());
	    			    	map.put(carro_compras.usado, "0");
	    			    	map.put(carro_compras.tienda, "1");
	    			    	map.put(carro_compras.cantidad_carro, cantidad);
	    			    	map.put(carro_compras.carne_empresa_id_carne_empresa, AppMy.getinstance().getCarneEmpresa().getId_carne_empresa());
	    			    	map.put(carro_compras.empresa_id_empresa, AppMy.getinstance().getCarneEmpresa().getId_empresa());
	    			    	map.put(carro_compras.mayor, "0");
	    			    	map.put(productoprecio.precio_mayor_CLP, producto.getPrecio_mayor_CLP());
	    			    	map.put(productoprecio.precio_CLP, producto.getPrecio_CLP());
	    			    	map.put(productoprecio.cantidad_mayor, producto.getCantidad_mayor());
	    			    	new addprod().execute();
	    				}
	    			}
	    		});
	    		dialog.show();
	        	Log.e("posicion ","" +info.position + " " + info.toString());
	            return true;
	        }
	        case Menu.FIRST + 1: {
	        	Log.e("posicion ", "" + info.position + " " + info.toString());
				Carro_comprascompleto producto = mylist.get(info.position-1);
				new sincTaskEliminar().execute(producto.getId_carro_compras());
	            return true;
	        }
	    }
	    return false;
	}

	public void onItemClick(int mPosition) {
		Log.e(TAG,"" + mPosition);
		Carro_comprascompleto carro = mylist.get(mPosition - 1);
		Toast.makeText(Vender.this, "ID '" + carro.getId_carro_compras() + "' was clicked.", Toast.LENGTH_SHORT).show();
		Log.e(TAG, " ");
	}

	private class sincTaskcargaspinners extends AsyncTask<String, Void, HashMap<String, ArrayList<HashMap<String, String>>>>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Vender.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Vender.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
			if(result != null) {
				SimpleAdapter adaptertipo_pago = new SimpleAdapter(Vender.this, result.get("mylisttipo_pago"), android.R.layout.simple_spinner_dropdown_item,
						new String[] {Base.tipo_pago.nombre_tipo_pago}, new int[] {android.R.id.text1 });
				spid_tipo_pago.setAdapter(adaptertipo_pago);
				SimpleAdapter adaptertipo_documento = new SimpleAdapter(Vender.this, result.get("mylisttipo_documento"), android.R.layout.simple_spinner_dropdown_item,
						new String[] {Base.tipo_documento.nombre_tipo_documento}, new int[] {android.R.id.text1 });
				spid_tipo_documento.setAdapter(adaptertipo_documento);
			}else {
				Log.e("terrible null", " return");
			}
			dialog.dismiss();
		}
		@Override
		protected HashMap<String, ArrayList<HashMap<String, String>>> doInBackground(String... params) {
			Log.e("thread end", " thread end");
			AppMy app = AppMy.getinstance();
			HashMap<String, ArrayList<HashMap<String, String>>> arraylistspinners = new HashMap<>();
			if(!app.isExternal()){
				arraylistspinners.put("mylisttipo_pago" , CursortoArrayhash.getinstance().ahTipo_pago(getContentResolver().query(
						Base.tipo_pago.CONTENT_URI, ProjectionCreater.pctipo_pago, null, null, Base.tipo_pago.DEFAULT_ORDEN)));
				arraylistspinners.put("mylisttipo_documento" , CursortoArrayhash.getinstance().ahTipo_documento(getContentResolver().query(
						Base.tipo_documento.CONTENT_URI, ProjectionCreater.pctipo_documento, null, null, Base.tipo_documento.DEFAULT_ORDEN)));
			}
			else
			{
				if(app.isOnline(Vender.this))
				{
					try {
						arraylistspinners.put("mylistsubcategoria", WebConector.getJSONfromURL("http://" + app.getUrl() + "/index.php/androidtienda//getsubcategoriasdroid", "subcategoriaspinner"));
					} catch (JSONException e) {
						arraylistspinners.put("mylistsubcategoria", new ArrayList<HashMap<String, String>>());
						Log.e("json", " array list" + e);
					}
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
				}
			}
			return arraylistspinners;
		}
	}
	private class sincTask extends AsyncTask<String, Void, ArrayList<Carro_comprascompleto>>
    {
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Vender.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Vender.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
    	@Override
    	 protected void onPostExecute(ArrayList<Carro_comprascompleto> result) {
    		if(result != null) {
    			Log.e("", "");
				adapter = new CustomAdaptervender(Vender.this, result);
				lv.setAdapter(adapter);
				if(!result.isEmpty())
    			{
    	    		setTotal();
    				txtvalortotal.setText(CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", Double.valueOf(hash.get("total"))));
    				Log.e(TAG, " result" + result.get(0).getNombre_producto() + " " + result.get(0).getId_carro_compras());
    			}
				else
				{
					btnCobrar.setEnabled(false);
				}
    		}else {
    			Log.e("terrible null", " return");
    		}
    		dialog.dismiss();
    	 }
    	@Override
    	protected ArrayList<Carro_comprascompleto> doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
    		if(!app.isExternal()){
				mylist = CursortoArrayEntidad.getinstance().aeCarro_comprascompleto(getContentResolver().query(
						carro_comprascompleto.CONTENT_URI,
						ProjectionCreater.pccarro_comprascompleto,
						carro_compras.carne_empresa_id_carne_empresa + " = ? and usado = 0",
						new String[]{app.getCarneEmpresa().getId_carne_empresa()},
						carro_compras.DEFAULT_ORDEN));
        	}
        	else
        	{
				if(app.isOnline(Vender.this))
            	{
		            try {
		    			//mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/" + app.getCarneEmpresa().getId_carne_empresa(), "carro_compras");
						mylist = new ArrayList<>();
		    		Log.e("doinbackground", " thread end");
		    		} catch (Exception e) {
		    			mylist = new ArrayList<>();
		    			Log.e("json", " array list" + e);
		    		}
            	}
            	else
            	{
            		Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
            	}
        	}
             return mylist;
    	}
     }

    private class sincTaskEliminar extends AsyncTask<String, Void, Void>  
    {
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Vender.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Vender.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
    	@Override
    	protected void onPostExecute(Void result) 
    	{
    	        dialog.dismiss();
                txtvalortotal.setText("0");
                new sincTask().execute();
    	}
    	@Override
    	protected Void doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
    		if(!app.isExternal()){
				if(params.length >= 1)
				{
					getContentResolver().delete(carro_compras.CONTENT_URI, carro_compras.id_carro_compras + " = ? and usado = 0",new String[]{params[0]});
				}
				else
				{
					getContentResolver().delete(carro_compras.CONTENT_URI, carro_compras.carne_empresa_id_carne_empresa + " = ? and usado = 0",new String[]{app.getCarneEmpresa().getId_carne_empresa()});
				}
        	}
        	else
        	{
				if(app.isOnline(Vender.this))
            	{
					WebConector.delete("http://"+ app.getUrl() +"/index.php/androidtienda/del_carro_compra/" + app.getCarneEmpresa().getId_carne_empresa());
		    		Log.e("eliminar doinbackground", " thread end");
            	}
            	else
            	{
            		Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
            	}
        	}			
			return null;
    	}
     }

	private class sincTaskPagar extends AsyncTask<String, Void, Void>  
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Vender.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Vender.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
    	@Override
    	protected void onPostExecute(Void result) 
    	{
			dialog.dismiss();
			txtvalortotal.setText("0");
			finish();
    	}
    	@Override
    	protected Void doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
    		if(!app.isExternal()){
				Calendar rightNow = Calendar.getInstance();
        		Cursor c = getContentResolver().query(carro_comprascompleto.CONTENT_URI, ProjectionCreater.pccarro_comprascompleto,
						carro_comprascompleto.carne_empresa_id_carne_empresa + " = ?", new String[]{app.getCarneEmpresa().getId_carne_empresa()}, carro_comprascompleto.DEFAULT_ORDEN);
				ContentValues vVenta = new ContentValues();
				vVenta.put(venta.numero_articulos, hash.get(venta.numero_articulos));
				vVenta.put(venta.carne_empresa_id_carne_empresa, app.getCarneEmpresa().getId_carne_empresa());
				vVenta.put(venta.anno_fecha_venta, rightNow.get(Calendar.YEAR));
				vVenta.put(venta.mes_fecha_venta, rightNow.get(Calendar.MONTH));
				vVenta.put(venta.dia_fecha_venta, rightNow.get(Calendar.DAY_OF_MONTH));
				vVenta.put(venta.hora_fecha_venta, String.valueOf(rightNow.getTimeInMillis()));
				vVenta.put(venta.tipo_pago_id_tipo_pago, map.get(venta.tipo_pago_id_tipo_pago));
				vVenta.put(venta.tipo_documento_id_tipo_documento, map.get(venta.tipo_documento_id_tipo_documento));
				vVenta.put(venta.total, hash.get(venta.total));
				String idventa = getContentResolver().insert(venta.CONTENT_URI, vVenta).getLastPathSegment();
				Log.e(" idventa inserted", "" + idventa);
                Log.e("cursor count ", "" + c.getCount());
				c.moveToFirst();
				while(!c.isAfterLast()) {
					ContentValues vCarroVenta = new ContentValues();
					vCarroVenta.put(carro_venta.venta_id_venta, idventa);
					vCarroVenta.put(carro_venta.carro_compras_id_carro_compras, c.getString(c.getColumnIndex(carro_compras.id_carro_compras)));
					vCarroVenta.put(carro_venta.cantidad, c.getString(c.getColumnIndex(carro_compras.cantidad_carro)));
					vCarroVenta.put(carro_venta.precio, c.getString(c.getColumnIndex(carro_compras.precio_carro)));
					String idcarro = getContentResolver().insert(carro_venta.CONTENT_URI, vCarroVenta).getLastPathSegment();
					Log.e(" idcarroventa inserted", "" + idcarro);
//Stock
					ContentValues stockcambio = new ContentValues();
					stockcambio.put(Base.stock.last_update, String.valueOf(Calendar.getInstance().getTimeInMillis()));
					stockcambio.put(Base.stock.stock_tienda,
							String.valueOf(c.getLong(c.getColumnIndex(carro_comprascompleto.stock_tienda)) - c.getLong(c.getColumnIndex(carro_comprascompleto.cantidad_carro))));
                    Log.e("vender","s " + String.valueOf(c.getLong(c.getColumnIndex(carro_comprascompleto.stock_tienda)) + " c " +  c.getLong(c.getColumnIndex(carro_comprascompleto.cantidad_carro))));
					String idstock = String.valueOf(getContentResolver().update(
							Base.stock.CONTENT_URI,
							stockcambio,
							Base.stock.producto_id_producto + " = ? and " + Base.stock.empresa_id_empresa + " = ?",
							new String[]{c.getString(c.getColumnIndex(carro_comprascompleto.id_producto)), app.getCarneEmpresa().getId_carne_empresa()}));
					Log.e("idstock", " idstock " + idstock);
					c.moveToNext();
				}
//carrousado
				ContentValues carrousado = new ContentValues();
				carrousado.put(carro_compras.usado, 1);
				String idcarrou = String.valueOf(getContentResolver().update(
						carro_compras.CONTENT_URI,
						carrousado,
						carro_compras.carne_empresa_id_carne_empresa + " = ? and " + carro_compras.usado + " = 0",
						new String[]{app.getCarneEmpresa().getId_carne_empresa()}));
				Log.e(" idcarrocompras updated", "" + idcarrou);
//archivo
				ContentValues vDia = new ContentValues();
				vDia.put(Base.dia.dia,rightNow.get(Calendar.DAY_OF_MONTH));
				vDia.put(Base.dia.mes,rightNow.get(Calendar.MONTH));
				vDia.put(Base.dia.anno,rightNow.get(Calendar.YEAR));
				vDia.put(Base.dia.fecha, rightNow.getTimeInMillis());
				vDia.put(Base.dia.ingreso, hash.get(venta.total));
				vDia.put(Base.dia.impuesto, hash.get("impuesto"));
				vDia.put(Base.dia.egreso, "0");
				String iddia = getContentResolver().insert(Base.dia.CONTENT_URI, vDia).getLastPathSegment();
				Log.e("iddia", " iddia " + iddia);
				c.close();
        	}
        	else
        	{
				if(app.isOnline(Vender.this))
            	{
					WebConector.delete("http://"+ app.getUrl() +"/index.php/androidtienda/pagar_carro_compras/" + app.getCarneEmpresa().getId_carne_empresa());
		    		Log.e("eliminar doinbackground", " thread end");
            	}
            	else
            	{
            		Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
            	}
        	}
			return null;
    	}
    }
	private class addprod extends AsyncTask<String, Void, Boolean>  
	{
		private boolean login;
		private Integer cant;
		private Integer cantidad_mayor;
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Vender.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Vender.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(Boolean result) 
		{
			Toast.makeText(getApplicationContext(), "actualizado", Toast.LENGTH_SHORT).show();
			new sincTask().execute();
		}
		@Override
		protected Boolean doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
	     	if(!app.isExternal()){
	     		Cursor cursor = getContentResolver().query(
	     				carro_compras.CONTENT_URI, ProjectionCreater.pccarro_compras, 
	     				carro_compras.producto_id_producto + " = ? and "+ carro_compras.empresa_id_empresa + " = ? and " + carro_compras.carne_empresa_id_carne_empresa + " = ?", 
	     				new String[]{map.get(carro_compras.producto_id_producto), map.get(carro_compras.empresa_id_empresa), map.get(carro_compras.carne_empresa_id_carne_empresa)}, 
	     				carro_compras.DEFAULT_ORDEN);
				Log.e("addcarro_compras  ", "busca articulos en carro " + cursor.getCount());
	     		if(cursor.getCount() == 0)
	     		{
	     			cant = Integer.valueOf(map.get(carro_compras.cantidad_carro));
	     			cantidad_mayor = Integer.valueOf(map.get(productoprecio.cantidad_mayor));
	     			Log.e("cantidad carro in ", "" + cant + cantidad_mayor);
	     			if(cant >= cantidad_mayor)
	     			{
	     				map.put(carro_compras.precio_carro, map.get(productoprecio.precio_mayor_CLP));
						map.put(carro_compras.mayor, "1");
	     			}
	     			else 
	     			{
	     				map.put(carro_compras.precio_carro, map.get(productoprecio.precio_CLP));
						map.put(carro_compras.mayor, "0");
	     			}
	     			String idcarro = String.valueOf(getContentResolver().insert(
							carro_compras.CONTENT_URI, PostData.getinstance().postdataready(map, Constantes.CARRO_COMPRAS_TABLE_NAME)).getLastPathSegment());
					Log.e("Carro insertado", "" + idcarro + " precio" + map.get(carro_compras.mayor) + " " + map.get(carro_compras.precio_carro));
	     		}
	     		else
	     		{
	     			cursor.moveToFirst();
	     			ContentValues values = new ContentValues();
	     			cant = Integer.valueOf(cursor.getString(cursor.getColumnIndex(carro_compras.cantidad_carro))) + Integer.valueOf(map.get(carro_compras.cantidad_carro));
	     			cantidad_mayor = Integer.valueOf(map.get(productoprecio.cantidad_mayor));
	     			Log.e("cantidad carro up ", "" + cant + cantidad_mayor);
	     			if(cant >= cantidad_mayor)
	     			{
	     				values.put(carro_compras.precio_carro, map.get(productoprecio.precio_mayor_CLP));
						values.put(carro_compras.mayor, "1");
	     			}
	     			else
	     			{
	     				values.put(carro_compras.precio_carro, map.get(productoprecio.precio_CLP));
						values.put(carro_compras.mayor, "0");
	     			}
	     			values.put(carro_compras.cantidad_carro, cant);
	     			String idcarro = String.valueOf(getContentResolver().update(
							carro_compras.CONTENT_URI, values, 
							carro_compras.id_carro_compras + " = ?",
							new String[]{cursor.getString(cursor.getColumnIndex(carro_compras.id_carro_compras))}));
	     			Log.e("Carro actualizado", "" + idcarro);
	     		}
				cursor.close();
	     	}
	     	else
	     	{
				if(app.isOnline(Vender.this))
	         	{
					login = WebConector.sendData("http://" + app.getUrl() +"/index.php/androidtienda/savecarrodroid/" , map, "prodcarro");
	         	}
	         	else
	         	{
	         		Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
	         	}
	     	}
	        return login;
		}
	 }

	public void setTotal() {
		Long cant, precio, bruto, br, subt, subtotal, total, articulos;
		Double impuesto, imp;
		bruto = (long) 0;
		impuesto = 0.0;
		subtotal = (long) 0;
		articulos = (long) 0;
		for(int i = 0; i < mylist.size(); i++)
		{
			cant = Long.valueOf(mylist.get(i).getCantidad_carro());
			precio = Long.valueOf(mylist.get(i).getPrecio_carro());
			br = cant * precio;
			imp = br * 0.19;
			subt = br;
			subtotal = subtotal + subt;
			bruto = bruto + br;
			impuesto = impuesto + imp;
			articulos += cant;
			Log.e("total for ", "" + " " + impuesto + " " + bruto + subtotal + " " + subt + " " + br + " " + imp);
		}
		total = subtotal;
		Log.e("resultados","" + total + " " + subtotal+ " " + bruto + " " + impuesto);
		hash = new HashMap<>();
		hash.put("total", String.valueOf(total));
		hash.put("subtotal", String.valueOf(subtotal));
		hash.put("bruto", String.valueOf(bruto));
		hash.put("impuesto", String.valueOf(impuesto));
		hash.put("numero_articulos", String.valueOf(articulos));
	}
}
