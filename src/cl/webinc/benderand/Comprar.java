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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
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

import cl.webinc.benderand.entidad.Carro_egresoscompleto;
import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.provider.Base.carro_egresos;
import cl.webinc.benderand.provider.Base.carro_egresoscompleto;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.util.CurrencyFormatter;
import cl.webinc.benderand.util.CursortoArrayEntidad;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.CustomAdapterComprar;
import cl.webinc.benderand.util.ProjectionCreater;

public class Comprar extends AppCompatActivity
{
	private ListView lv;
	private TextView txtcbruto;
	private TextView txtcimpuesto;
	private TextView txtcvalortotal;
	protected ArrayList<Carro_egresoscompleto> mylist;
	protected ListAdapter adapter;
	private String TAG = "comprar";
	private HashMap<String, String> map = new HashMap<>();
	private HashMap<String, String> hash;
	private Spinner spid_tipo_pago;
	private Spinner spid_tipo_documento;
    private Button btnPagar;

    @Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comprar);
		setTitle(R.string.estacomprar);
		lv = (ListView) findViewById(R.id.listViewcCarro);
		txtcbruto = (TextView) findViewById(R.id.txtcbruto);
		txtcimpuesto = (TextView) findViewById(R.id.txtcimpuesto);
		txtcvalortotal = (TextView) findViewById(R.id.txtcvalortotal);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG, "onResume");
		Button btnAgregar = (Button) findViewById(R.id.btncAgregar);
		btnAgregar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Comprar.this, ListaProductosCompra.class);
				startActivityForResult(i, 0);
				Log.e("btnAgregar  ", "" + i);
			}
		});
		Button btnLimpiar = (Button) findViewById(R.id.btncLimpiar);
		btnLimpiar.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(Comprar.this);
				myAlertDialog.setTitle(R.string.lblcancelarcompra);
				myAlertDialog.setMessage(R.string.lblestasegurodecancelarestacompra);
				myAlertDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
						new sincTaskEliminar().execute();
						Log.e("btnLimpiar ", "");
					}
				});
				myAlertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
					}
				});
				myAlertDialog.show();
			}
		});
		btnPagar = (Button) findViewById(R.id.btncPagar);
		btnPagar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final Dialog dialog = new Dialog(Comprar.this);
				dialog.setContentView(R.layout.dialogtipocompra);
				dialog.setTitle(R.string.lbltitulofactura);
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				spid_tipo_pago = (Spinner) dialog.findViewById(R.id.spdtvtipo_pago_id_tipo_pago);
				spid_tipo_documento = (Spinner) dialog.findViewById(R.id.spdtvtipo_documento_id_tipo_documento);
				final EditText etarutproveedor = (EditText) dialog.findViewById(R.id.etarutproveedor);
				final EditText etarolfactura = (EditText) dialog.findViewById(R.id.etarolfactura);
				final EditText etanombreproveedor = (EditText) dialog.findViewById(R.id.etanombreproveedor);
				final EditText etatelefonoproveedor = (EditText) dialog.findViewById(R.id.etatelefonoproveedor);
				final DatePicker fechafactura = (DatePicker) dialog.findViewById(R.id.datePicker2);
				dialogButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						if (etarutproveedor.getText().toString().isEmpty()) {
							Toast.makeText(Comprar.this, R.string.lbldebesingresarunrut, Toast.LENGTH_LONG).show();
						} else if (etarolfactura.getText().toString().isEmpty()) {
							Toast.makeText(Comprar.this, R.string.lbldebesingresarunrol, Toast.LENGTH_LONG).show();
						} else if (etanombreproveedor.getText().toString().isEmpty()) {
							Toast.makeText(Comprar.this, R.string.lbldebesingresarunnombre, Toast.LENGTH_LONG).show();
						} else {
							map.put(Base.venta.tipo_pago_id_tipo_pago, String.valueOf(spid_tipo_pago.getSelectedItemPosition() + 1));
							map.put(Base.venta.tipo_documento_id_tipo_documento, String.valueOf(spid_tipo_documento.getSelectedItemPosition() + 1));
							map.put(Base.factura.rut_proveedor, etarutproveedor.getText().toString());
							map.put(Base.factura.nombre_proveedor, etanombreproveedor.getText().toString());
							map.put(Base.factura.telefono_proveedor, etatelefonoproveedor.getText().toString());
							map.put(Base.factura.total_factura, hash.get("total"));
							map.put(Base.factura.rol_factura, etarolfactura.getText().toString());
							map.put(Base.factura.dia_factura, String.valueOf(fechafactura.getDayOfMonth()));
							map.put(Base.factura.mes_factura, String.valueOf(fechafactura.getMonth()));
							map.put(Base.factura.ano_factura, String.valueOf(fechafactura.getYear()));
							Log.e("btnpagar spinner", "sppago spdocu " + String.valueOf(spid_tipo_pago.getSelectedItemPosition()) + " " + String.valueOf(spid_tipo_documento.getSelectedItemPosition()));
							new sincTaskDocumento().execute();
							dialog.dismiss();
						}
					}
				});
				new sincTaskcargaspinners().execute();
				dialog.show();
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
				final Dialog dialog = new Dialog(Comprar.this);
				dialog.setContentView(R.layout.dialognumberpreciopicker);
				dialog.setTitle(R.string.lblAgreguedatosdeitem);

				// set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(R.string.lblagregueunacantidad);
				TextView text2 = (TextView) dialog.findViewById(R.id.text2);
				text2.setText(R.string.lblIngresepreciobruto);
				final EditText mcant = (EditText) dialog.findViewById(R.id.editcant);
				final EditText mprecio = (EditText) dialog.findViewById(R.id.editprecio);

				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						if (mcant.getText().toString().isEmpty()) {
							Toast.makeText(Comprar.this, R.string.lbldebesingresarunnumero, Toast.LENGTH_LONG).show();
						}
						else if (mprecio.getText().toString().isEmpty()) {
							Toast.makeText(Comprar.this, R.string.lbldebesingresarunprecio, Toast.LENGTH_LONG).show();
						} else {
							dialog.dismiss();
							String cantidad = mcant.getText().toString();
							String precio = mprecio.getText().toString();
                            Carro_egresoscompleto producto = mylist.get(info.position);
							map.put(Base.item_factura.producto_id_producto, producto.getId_producto());
							map.put(Base.item_factura.precio, precio);
							map.put(Base.item_factura.cantidad, cantidad);
							map.put(Base.item_factura.factura_id_factura, "1");
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
                Carro_egresoscompleto producto = mylist.get(info.position-1);
				new sincTaskEliminar().execute(producto.getId_carro_egresos());
				return true;
			}
		}
		return false;
	}

	public void onItemClick(int mPosition) {
		Log.e(TAG,"" + mPosition);
		Carro_egresoscompleto carro = mylist.get(mPosition - 1);
		Toast.makeText(Comprar.this, "ID '" + carro.getId_carro_egresos() + "' was clicked.", Toast.LENGTH_SHORT).show();
		Log.e(TAG, " ");
	}

	private class sincTaskcargaspinners extends AsyncTask<String, Void, HashMap<String, ArrayList<HashMap<String, String>>>>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Comprar.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Comprar.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
			if(result != null) {
				SimpleAdapter adaptertipo_pago = new SimpleAdapter(Comprar.this, result.get("mylisttipo_pago"), android.R.layout.simple_spinner_dropdown_item,
						new String[] {Base.tipo_pago.nombre_tipo_pago}, new int[] {android.R.id.text1 });
				spid_tipo_pago.setAdapter(adaptertipo_pago);
				SimpleAdapter adaptertipo_documento = new SimpleAdapter(Comprar.this, result.get("mylisttipo_documento"), android.R.layout.simple_spinner_dropdown_item,
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
				if(app.isOnline(Comprar.this))
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
	private class sincTask extends AsyncTask<String, Void, ArrayList<Carro_egresoscompleto>>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Comprar.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Comprar.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(ArrayList<Carro_egresoscompleto> result) {
			if(result != null) {
				Log.e("", "");
				adapter = new CustomAdapterComprar(Comprar.this, result);
				lv.setHeaderDividersEnabled(true);
				lv.setAdapter(adapter);
				if(!result.isEmpty())
				{
					setTotal();
					txtcvalortotal.setText(CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", Double.valueOf(hash.get("total"))));
					txtcimpuesto.setText(CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", Double.valueOf(hash.get("impuesto"))));
					txtcbruto.setText(CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", Double.valueOf(hash.get("bruto"))));
					Log.e(TAG, " result" + result.get(0).getNombre_producto() + " " + result.get(0).getId_carro_egresos());
					btnPagar.setEnabled(true);
				}
                else
                {
                    btnPagar.setEnabled(false);
                }
			}else {
				Log.e("terrible null", " return");
			}
			dialog.dismiss();
		}
		@Override
		protected ArrayList<Carro_egresoscompleto> doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
			Log.e("Params _____", "" );
			if(!app.isExternal()){
				mylist = CursortoArrayEntidad.getinstance().aeCarro_egresoscompleto(getContentResolver().query(
                        carro_egresoscompleto.CONTENT_URI,
                        ProjectionCreater.pccarro_egresoscompleto,
                        carro_egresoscompleto.usado + " = 0 and " + carro_egresoscompleto.carne_empresa_id_carne_empresa + " = ?",
                        new String[]{app.getCarneEmpresa().getId_carne_empresa()},
                        null));
			}
			else
			{
				if(app.isOnline(Comprar.this))
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
			dialog = new ProgressDialog(Comprar.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Comprar.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(Void result)
		{
			dialog.dismiss();
			txtcvalortotal.setText("0");
			txtcimpuesto.setText("0");
			txtcbruto.setText("0");
			new sincTask().execute();
		}
		@Override
		protected Void doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
			if(!app.isExternal()){
				if(params.length >= 1)
				{
					getContentResolver().delete(carro_egresos.CONTENT_URI, carro_egresos.id_carro_egresos + " = ? and usado = 0",new String[]{params[0]});
				}
				else
				{
					getContentResolver().delete(carro_egresos.CONTENT_URI, carro_egresos.carne_empresa_id_carne_empresa + " = ? and usado = 0",new String[]{app.getCarneEmpresa().getId_carne_empresa()});
				}
			}
			else
			{
				if(app.isOnline(Comprar.this))
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

	private class sincTaskDocumento extends AsyncTask<String, Void, Void>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Comprar.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Comprar.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(Void result)
		{
			txtcvalortotal.setText("0");
			txtcimpuesto.setText("0");
			txtcbruto.setText("0");
			dialog.dismiss();
            finish();
		}
		@Override
		protected Void doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
			if(!app.isExternal()){
				Calendar rightNow = Calendar.getInstance(new Locale("es", "CL"));
				Cursor c = getContentResolver().query(carro_egresoscompleto.CONTENT_URI, ProjectionCreater.pccarro_egresoscompleto,
						carro_egresoscompleto.carne_empresa_id_carne_empresa + " = ?", new String[]{app.getCarneEmpresa().getId_carne_empresa()}, carro_egresoscompleto.DEFAULT_ORDEN);
				ContentValues vFactura = new ContentValues();
				vFactura.put(Base.factura.tipo_pago_id_tipo_pago, map.get(Base.factura.tipo_pago_id_tipo_pago));
				vFactura.put(Base.factura.tipo_documento_id_tipo_documento, map.get(Base.factura.tipo_documento_id_tipo_documento));
				vFactura.put(Base.factura.empresa_id_empresa, app.getCarneEmpresa().getId_empresa());
				vFactura.put(Base.factura.rut_proveedor, map.get(Base.factura.rut_proveedor));
				vFactura.put(Base.factura.nombre_proveedor, map.get(Base.factura.nombre_proveedor));
				vFactura.put(Base.factura.telefono_proveedor, map.get(Base.factura.telefono_proveedor));
				vFactura.put(Base.factura.total_factura, map.get(Base.factura.total_factura));
				vFactura.put(Base.factura.rol_factura, map.get(Base.factura.rol_factura));
				vFactura.put(Base.factura.dia_factura, map.get(Base.factura.dia_factura));
				vFactura.put(Base.factura.mes_factura, map.get(Base.factura.mes_factura));
				vFactura.put(Base.factura.ano_factura, map.get(Base.factura.ano_factura));
				vFactura.put(Base.factura.fecha_factura, rightNow.getTimeInMillis());
				vFactura.put(Base.factura.carne_empresa_id_carne_empresa, app.getCarneEmpresa().getId_carne_empresa());
				String idfactura = getContentResolver().insert(Base.factura.CONTENT_URI, vFactura).getLastPathSegment();
				Log.e(" idfactura inserted", "" + idfactura);
                Log.e("cursor count ", "" + c.getCount());
				c.moveToFirst();
				while(!c.isAfterLast()) {
					ContentValues vitem_factura = new ContentValues();
					vitem_factura.put(Base.item_factura.factura_id_factura, idfactura);
					vitem_factura.put(Base.item_factura.carro_egresos_id_carro_egresos, c.getString(c.getColumnIndex(carro_egresoscompleto.id_carro_egresos)));
					vitem_factura.put(Base.item_factura.cantidad, c.getString(c.getColumnIndex(carro_egresoscompleto.cantidad_carro)));
					vitem_factura.put(Base.item_factura.precio, c.getString(c.getColumnIndex(carro_egresoscompleto.precio_carro)));
                    vitem_factura.put(Base.item_factura.producto_id_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.id_producto)));
                    String iditem_factura = getContentResolver().insert(Base.item_factura.CONTENT_URI, vitem_factura).getLastPathSegment();
                    Log.e(" idcarroventa inserted",""	+ iditem_factura);
                    Log.e(" idstock ",c.getColumnIndex(carro_egresoscompleto.stock_tienda) + " a "	+ c.getString(c.getColumnIndex(carro_egresoscompleto.stock_tienda)));
//Stock
					ContentValues stockcambio = new ContentValues();
					stockcambio.put(Base.stock.last_update, String.valueOf(Calendar.getInstance().getTimeInMillis()));
                    stockcambio.put(Base.stock.stock_tienda,
                            String.valueOf(c.getLong(c.getColumnIndex(carro_egresoscompleto.stock_tienda))
                                    + c.getLong(c.getColumnIndex(carro_egresoscompleto.cantidad_carro))));

                    Log.e("vender", "s " + String.valueOf(c.getLong(c.getColumnIndex(carro_egresoscompleto.stock_tienda)) + " c " +  c.getLong(c.getColumnIndex(carro_egresoscompleto.cantidad_carro))));
                    if(c.getString(c.getColumnIndex(carro_egresoscompleto.stock_tienda)) != null)
                    {
					    String idstock = String.valueOf(getContentResolver().update(
							Base.stock.CONTENT_URI,
							stockcambio,
							Base.stock.producto_id_producto + " = ? and " + Base.stock.empresa_id_empresa + " = ?",
							new String[]{c.getString(c.getColumnIndex(carro_egresoscompleto.id_producto)), app.getCarneEmpresa().getId_carne_empresa()})
                        );
                        Log.e(" idstock updated", "" + idstock);
                    }
                    else
                    {
                        stockcambio.put(Base.stock.producto_id_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.id_producto)));
                        stockcambio.put(Base.stock.empresa_id_empresa, app.getCarneEmpresa().getId_empresa());
                        String idstock = String.valueOf(getContentResolver().insert(Base.stock.CONTENT_URI, stockcambio));
                        Log.e(" idstock inserted", "" + idstock);
                    }
                    ContentValues preciocambio = new ContentValues();
                    if(c.getString(c.getColumnIndex(carro_egresoscompleto.precio_CLP)) == null)
                    {
                        preciocambio.put(Base.precio.producto_id_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.id_producto)));
                        preciocambio.put(Base.precio.empresa_id_empresa, app.getCarneEmpresa().getId_empresa());
                        preciocambio.put(Base.precio.precio_CLP, c.getString(c.getColumnIndex(carro_egresoscompleto.precio_carro)));
                        preciocambio.put(Base.precio.precio_mayor_CLP, c.getString(c.getColumnIndex(carro_egresoscompleto.precio_carro)));
                        preciocambio.put(Base.precio.cantidad_mayor, "6");
						preciocambio.put(Base.precio.precio_actual, "1");
                        preciocambio.put(Base.precio.descuento_promocion, "0");
                        String isprecio = String.valueOf(getContentResolver().insert(Base.precio.CONTENT_URI, preciocambio));
                        Log.e(" isprecio inserted", "" + isprecio);
                    }
					c.moveToNext();
				}

				ContentValues carrousado = new ContentValues();
				carrousado.put(carro_egresos.usado, 1);
				String idcarrou = String.valueOf(getContentResolver().update(
						carro_egresos.CONTENT_URI,
						carrousado,
						carro_egresos.carne_empresa_id_carne_empresa + " = ? and " + carro_egresos.usado + " = 0",
						new String[]{app.getCarneEmpresa().getId_carne_empresa()}));
				Log.e(" idcarrocompras updated", "" + idcarrou);

				ContentValues vDia = new ContentValues();
				vDia.put(Base.dia.dia, rightNow.get(Calendar.DAY_OF_MONTH));
				vDia.put(Base.dia.mes,rightNow.get(Calendar.MONTH));
				vDia.put(Base.dia.anno,rightNow.get(Calendar.YEAR));
				vDia.put(Base.dia.fecha, rightNow.getTimeInMillis());
				vDia.put(Base.dia.ingreso, "0");
				vDia.put(Base.dia.impuesto, hash.get("impuesto"));
				vDia.put(Base.dia.egreso, hash.get(Base.venta.total));
				String iddia = getContentResolver().insert(Base.dia.CONTENT_URI, vDia).getLastPathSegment();
				c.close();
				Log.e(" idfactura inserted", "" + idfactura + " " + iddia);
			}
			else
			{
				if (app.isOnline(Comprar.this))
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
		private Double cant;
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Comprar.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Comprar.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(Boolean result)
		{
			//Toast.makeText(getApplicationContext(), "actualizado", Toast.LENGTH_SHORT).show();
			dialog.dismiss();
			new sincTask().execute();
		}
		@Override
		protected Boolean doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
			if(!app.isExternal()){
				Cursor cursor = getContentResolver().query(
						carro_egresos.CONTENT_URI, ProjectionCreater.pccarro_egresos,
						carro_egresos.producto_id_producto + " = ? and "+ carro_egresos.empresa_id_empresa + " = ? and " + carro_egresos.carne_empresa_id_carne_empresa + " = ? and usado_carro_egresos = 0",
						new String[]{map.get(carro_egresos.producto_id_producto),map.get(carro_egresos.empresa_id_empresa), map.get(carro_egresos.carne_empresa_id_carne_empresa)},
						carro_egresos.DEFAULT_ORDEN);
				Log.e("addcarro_compras  ", "busca articulos en carro " + cursor.getCount());
				if(cursor.getCount() == 0)
				{
					cant = Double.valueOf(map.get(carro_egresos.cantidad_carro));
					Log.e("cantidad carro in ", "" + cant);
					map.put(carro_egresos.precio_carro, map.get(carro_egresos.precio_carro));
					String idcarro = String.valueOf(getContentResolver().insert(
							carro_egresos.CONTENT_URI, PostData.getinstance().postdataready(map, Constantes.CARRO_EGRESOS_TABLE_NAME)).getLastPathSegment());
					Log.e("Carro insertado", "" + idcarro);
				}
				else
				{
					cursor.moveToFirst();
					ContentValues values = new ContentValues();
					cant = Double.valueOf(cursor.getString(cursor.getColumnIndex(carro_egresos.cantidad_carro))) + Double.valueOf(map.get(carro_egresos.cantidad_carro));
					Log.e("cantidad carro up ", "" + cant);
					values.put(carro_egresos.precio_carro, map.get(carro_egresos.precio_carro));
					values.put(carro_egresos.mayor, "0");
					values.put(carro_egresos.cantidad_carro, cant);
					String idcarro = String.valueOf(getContentResolver().update(
							carro_egresos.CONTENT_URI, values,
							carro_egresos.id_carro_egresos + " = ?",
							new String[]{cursor.getString(cursor.getColumnIndex(carro_egresos.id_carro_egresos))}));
					Log.e("Carro actualizado", "" + idcarro);
				}
				cursor.close();
			}
			else
			{
				if(app.isOnline(Comprar.this))
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
			subt = imp.intValue() + br;
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
