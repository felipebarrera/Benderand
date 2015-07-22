package cl.webinc.benderand;

import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import cl.webinc.benderand.provider.Base.contenido_unidad_medida;
import cl.webinc.benderand.provider.Base.familia_necesidad;
import cl.webinc.benderand.provider.Base.familia_producto;
import cl.webinc.benderand.provider.Base.formato_producto;
import cl.webinc.benderand.provider.Base.precio;
import cl.webinc.benderand.provider.Base.producto;
import cl.webinc.benderand.provider.Base.productocompleto;
import cl.webinc.benderand.provider.Base.productoprecio;
import cl.webinc.benderand.provider.Base.stock;
import cl.webinc.benderand.provider.Base.subcategoria;
import cl.webinc.benderand.provider.Base.tipo_producto;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class Productoeditor extends AppCompatActivity {
    private static final String TAG = "EDITOR PRODUCTO";
    private String ID = "0";
	private String SERIAL = "0";
	private int TYPEBTN = 0;
	protected String FORMAT;
	private File storageDir ;
	private Uri prodFotoUri;
	private HashMap<String, String> map = new HashMap<String, String>();
	public String action;
	private ArrayList<HashMap<String, String>> mylist;
	private static AppMy app = AppMy.getinstance();
	public HashMap<String, ArrayList<HashMap<String, String>>>  arraylist;
    private static final int ADD_ID = Menu.FIRST;
    private static final int DISCARD_ID = Menu.FIRST + 1;
    private static final int DELETE_ID = Menu.FIRST + 2;
    private static final int EDIT_ID = Menu.FIRST + 3;
    private static final int STATE_EDIT = 1;
    private static final int STATE_INSERT = 0;
    private int mState;
    private EditText mcodigo_producto;
    private EditText mnumero_serie;
    private EditText mnombre_producto;
    private EditText mmarca_producto;
    private EditText mmodelo_producto;
    private EditText mcontenido_unidad;
    private EditText munidad_minima;
    private EditText mcontenido;
    private EditText mpeso_neto;
    private EditText malto_cm;
    private EditText mancho_cm;
    private EditText mfondo_cm;
    private EditText mfabricante;
    private EditText mSKU;
    private EditText mcantidad_mayor;
	private EditText mdescuento_promocion;
    private EditText mprecio_CLP;
    private EditText mprecio_mayor_CLP;
    private EditText mstock_tienda;
    private Spinner msubcategoria_id_subcategoria;
    private Spinner mcontenido_unidad_medida_id_contenido_unidad_medida;
    private Spinner mfamilia_necesidad_id_familia_necesidad;
    private Spinner mfamilia_producto_id_familia_producto;
    private Spinner mtipo_producto_id_tipo_producto;
    private Spinner mformato_producto_id_formato_producto;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("ONCREATE", "start ");
        super.onCreate(savedInstanceState);
		setContentView(R.layout.editorproductopreciomod);
		setTitle(R.string.editordeproducto);
		ID = app.getExtra().get("id");
		Log.e("ID para buscar  ", "!ID.equals(\"0\") " + ID.equals("0") + " id " + ID);
        asignarCamposvariableCorta();
        if(ID.equals("0"))
        {
            limpiarPantalla();
            mState = STATE_INSERT;
            Log.e("igual 0  ", "" + mState );
        }
        else
        {
            limpiarPantalla();
            mState = STATE_EDIT;
            Log.e("distinto 0  ", "" + mState );
            new sincTaskbuscarid().execute();
        }
        //Buscar categorias
    	
		new sincTaskcargaspinners().execute();
		
        Button scanbtn = (Button) findViewById(R.id.buttonnum_serie);
        scanbtn.setOnClickListener(new View.OnClickListener() {
        	
            public void onClick(View c) {
            	TYPEBTN = 0;
                Log.e("1", "TYPEBTN0 " + TYPEBTN);
				final Intent intent = new Intent("com.google.zxing.client.android.SCAN");
				intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "ONE_D_MODE");
				//intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);
		        Log.e("2", "" + intent);
		        SERIAL = intent.getStringExtra("SCAN_RESULT");
    			FORMAT = intent.getStringExtra("SCAN_RESULT_FORMAT");
            }
            
        });  

        Button fotobtn = (Button) findViewById(R.id.buttonFoto);
        fotobtn.setOnClickListener(new View.OnClickListener() {
        	
			public void onClick(View v) {
            	TYPEBTN = 1;
                Log.e("5", "TYPEBTN1 " + TYPEBTN);
		        Log.e("mcod_prod ", " aca " + mcodigo_producto.getText().length());
            	storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), mcodigo_producto.getText() +".jpg");
				prodFotoUri = Uri.fromFile(storageDir);
				final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, prodFotoUri);
		        //mimagen.setText(prodFotoUri.toString());
            	if(mcodigo_producto.getText().length() > 0) 
            	{
					startActivityForResult(intent, 0);
			        Log.e("6", "prodFotoUri" + prodFotoUri);
            	}
            	else
            	{
            		Toast.makeText(getBaseContext(), "Se necesita un numero de serie", Toast.LENGTH_LONG).show();
            	}
            }
            
        });  
        
        mcodigo_producto.setOnFocusChangeListener(new OnFocusChangeListener() {          

               public void onFocusChange(View v, boolean hasFocus) {
                   if(!hasFocus){
                	   mSKU.setText("SKU" + mcodigo_producto.getText().toString());
                   }
               }
           });
        
        
    }
    private class sincTask extends AsyncTask<String, Void, Boolean>  
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Productoeditor.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Productoeditor.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		private boolean login = false;
		@Override
		protected void onPostExecute(Boolean result) 
		{
			if(login)
			{
				Toast.makeText(getApplicationContext(), "Sinc producto ok", Toast.LENGTH_SHORT).show();
	        	Log.e("sincTask " + mState, "Sinc producto ok");
			}
			else 
			{
				Toast.makeText(getApplicationContext(), "Error en sinc producto", Toast.LENGTH_SHORT).show();
				Log.e("sincTask " + mState, "Error en sinc producto");
			}
	        dialog.dismiss();
	        finish();//vuelvo a la lista
		}
		@Override
		protected Boolean doInBackground(
				String... params) {
			app = AppMy.getinstance();
        	if(!app.isExternal()){
                Log.e("" + mState, "mState" + mState);
    			if (mState == STATE_INSERT) {
					String idproducto = String.valueOf(Integer.valueOf(getContentResolver().insert(
							producto.CONTENT_URI,
							PostData.getinstance().postdataready(map, "producto")).getLastPathSegment()));
					map.put(precio.producto_id_producto, idproducto);
					map.put(stock.producto_id_producto, idproducto);
                    map.put(precio.empresa_id_empresa, app.getCarneEmpresa().getId_empresa());
                    map.put(stock.empresa_id_empresa, app.getCarneEmpresa().getId_empresa());
					getContentResolver().insert(precio.CONTENT_URI, PostData.getinstance().postdataready(map, "precio")).getLastPathSegment();
					getContentResolver().insert(stock.CONTENT_URI, PostData.getinstance().postdataready(map, "stock")).getLastPathSegment();
					login = Integer.valueOf(idproducto) > 0;
					Log.e("addprod  ", " do in background " + idproducto);
    			}
    			else
    			{
    	        	try{
    	        		Log.e("values update", "" + PostData.getinstance().postdataready(map, "producto").toString());
                        Log.e("values update", "" + PostData.getinstance().postdataready(map, "precio").toString());
                        Log.e("values update", "" + PostData.getinstance().postdataready(map, "stock").toString());
    	        		String idproducto = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(producto.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "producto"), null, null)));
                        map.put(precio.producto_id_producto, ID);
                        map.put(stock.producto_id_producto, ID);
                        map.put(precio.empresa_id_empresa, app.getCarneEmpresa().getId_empresa());
                        map.put(stock.empresa_id_empresa, app.getCarneEmpresa().getId_empresa());
                        getContentResolver().update(ContentUris.withAppendedId(precio.CONTENT_URI, Long.parseLong(map.get(productoprecio.id_precio))),
                                PostData.getinstance().postdataready(map, "precio"), null, null);
        	        	getContentResolver().update(ContentUris.withAppendedId(stock.CONTENT_URI, Long.parseLong(map.get(productoprecio.id_stock))),
                                PostData.getinstance().postdataready(map, "stock"), null, null);

						login = Integer.valueOf(idproducto) > 0;
    					Log.e("updateprod ", " do in background " + idproducto);
    	        	}
    					catch (SQLException e) {e.printStackTrace(); Log.e("catch update", "" + e);}
	        		
    			}
        	}
        	else
        	{
				if(app.isOnline(Productoeditor.this))
            	{
					if (mState == STATE_INSERT) {
						action = "saveprod";
					}
					else
					{
						action = "updateprod";
					}
					login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "productoprecio");
            	}
            	else
            	{
            		Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
            	}
        	}
	        return login;
		}
	 }
    
    
    private class sincTaskbuscarid extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>  
    {
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Productoeditor.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Productoeditor.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
    	@Override
    	 protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
    		if(result.size() != 0) 
    		{
    			asignarCamposvariableCorta();
    			muestraeditor();
    	        Log.e("sincTaskbuscarid", " not null");
	        }else {
	        	Toast.makeText(getApplicationContext(), "No se encuentra el producto, error de sincronizacion", Toast.LENGTH_SHORT).show();
	            Log.e("terrible null", " return");
	        }
    	    dialog.dismiss();
    	 }
		@Override
    	protected ArrayList<HashMap<String, String>> doInBackground(
    			String... params) {
    		Log.e("sincTaskbuscarid", " thread end");
			app = AppMy.getinstance();
    		if(!app.isExternal()){
        		mylist = CursortoArrayhash.getinstance().ahProductoprecio(getContentResolver().query(
        				ContentUris.withAppendedId(productoprecio.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcproductoprecio, null, null, productoprecio.DEFAULT_ORDEN));
        	}
        	else
        	{
				if(app.isOnline(Productoeditor.this))
            	{
					try {
		    			mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "productocompleto");
		    		} catch (JSONException e) {
		    			mylist = new ArrayList<HashMap<String, String>>();
		    			Log.e("sincTaskbuscarid", " array list" + e);
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
    private class sincTaskcargaspinners extends AsyncTask<String, Void, HashMap<String, ArrayList<HashMap<String, String>>>> 
    {
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Productoeditor.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Productoeditor.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
    	 protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
    		if(result != null) {
    	        Log.e(TAG, " onpost execute");
    	        Log.e(TAG,  "" + result.size());
    	        SimpleAdapter adaptersubcategoria = new SimpleAdapter(Productoeditor.this, result.get("mylistsubcategoria"), android.R.layout.simple_spinner_item,
    	                new String[] {subcategoria.nombre_subcategoria}, new int[] {android.R.id.text1 });
    	        adaptersubcategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	        msubcategoria_id_subcategoria.setAdapter(adaptersubcategoria);
    	        if (mState == STATE_EDIT) {
        	        Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(productoprecio.subcategoria_id_subcategoria))-1;
        	        Log.e("sincTaskcargaspinners", "compareValue" + compareValue);
        	        if (!compareValue.equals(null)) {
        	            //int spinnerPostion = (Integer) adapter.getItem(compareValue);
        	            msubcategoria_id_subcategoria.setSelection(compareValue);
        	            //spinnerPostion = 0;
        	        }
    	        }
    	        SimpleAdapter adaptercontenido_unidad_medida = new SimpleAdapter(Productoeditor.this, result.get("mylistcontenido_unidad_medida"), android.R.layout.simple_spinner_item,
    	                new String[] {contenido_unidad_medida.nombre_contenido_unidad_medida}, new int[] {android.R.id.text1 });
    	        adaptercontenido_unidad_medida.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	        mcontenido_unidad_medida_id_contenido_unidad_medida.setAdapter(adaptercontenido_unidad_medida);
    	        if (mState == STATE_EDIT) {
        	        Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida))-1;
					Log.e("sincTaskcargaspinners", "compareValue" + compareValue);
        	        if (!compareValue.equals(null)) {
        	            //int spinnerPostion = (Integer) adapter.getItem(compareValue);
        	        	mcontenido_unidad_medida_id_contenido_unidad_medida.setSelection(compareValue);
        	            //spinnerPostion = 0;
        	        }
    	        }
    	        SimpleAdapter adapterfamilia_producto = new SimpleAdapter(Productoeditor.this, result.get("mylistfamilia_producto"), android.R.layout.simple_spinner_item,
    	                new String[] {familia_producto.nombre_familia_producto}, new int[] {android.R.id.text1 });
    	        adapterfamilia_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	        mfamilia_producto_id_familia_producto.setAdapter(adapterfamilia_producto);
    	        if (mState == STATE_EDIT) {
        	        Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(productoprecio.familia_producto_id_familia_producto))-1;
					Log.e("sincTaskcargaspinners", "compareValue" + compareValue);
        	        if (!compareValue.equals(null)) {
        	            //int spinnerPostion = (Integer) adapter.getItem(compareValue);
        	        	mfamilia_producto_id_familia_producto.setSelection(compareValue);
        	            //spinnerPostion = 0;
        	        }
    	        }
    	        SimpleAdapter adapterfamilia_necesidad = new SimpleAdapter(Productoeditor.this, result.get("mylistfamilia_necesidad"), android.R.layout.simple_spinner_item,
    	                new String[] {familia_necesidad.nombre_familia_necesidad}, new int[] {android.R.id.text1 });
    	        adapterfamilia_necesidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	        mfamilia_necesidad_id_familia_necesidad.setAdapter(adapterfamilia_necesidad);
    	        if (mState == STATE_EDIT) {
        	        Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(productoprecio.familia_necesidad_id_familia_necesidad))-1;
					Log.e("sincTaskcargaspinners", "compareValue" + compareValue);
        	        if (!compareValue.equals(null)) {
        	            //int spinnerPostion = (Integer) adapter.getItem(compareValue);
        	        	mfamilia_necesidad_id_familia_necesidad.setSelection(compareValue);
        	            //spinnerPostion = 0;
        	        }
    	        }
    	        SimpleAdapter adapterformato_producto = new SimpleAdapter(Productoeditor.this, result.get("mylistformato_producto"), android.R.layout.simple_spinner_item,
    	                new String[] {formato_producto.nombre_formato_producto}, new int[] {android.R.id.text1 });
    	        adapterformato_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	        mformato_producto_id_formato_producto.setAdapter(adapterformato_producto);
    	        if (mState == STATE_EDIT) {
        	        Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(productoprecio.formato_producto_id_formato_producto))-1;
					Log.e("sincTaskcargaspinners", "compareValue" + compareValue);
        	        if (!compareValue.equals(null)) {
        	            //int spinnerPostion = (Integer) adapter.getItem(compareValue);
        	        	mformato_producto_id_formato_producto.setSelection(compareValue);
        	            //spinnerPostion = 0;
        	        }
    	        }
    	        SimpleAdapter adaptertipo_producto = new SimpleAdapter(Productoeditor.this, result.get("mylisttipo_producto"), android.R.layout.simple_spinner_item,
    	                new String[] {tipo_producto.nombre_tipo_producto}, new int[] {android.R.id.text1 });
    	        adaptertipo_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	        mtipo_producto_id_tipo_producto.setAdapter(adaptertipo_producto);
    	        if (mState == STATE_EDIT) {
        	        Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(productoprecio.tipo_producto_id_tipo_producto))-1;
					Log.e("sincTaskcargaspinners", "compareValue" + compareValue);
        	        if (!compareValue.equals(null)) {
        	            //int spinnerPostion = (Integer) adapter.getItem(compareValue);
        	        	mtipo_producto_id_tipo_producto.setSelection(compareValue);
        	            //spinnerPostion = 0;
        	        }
    	        }
	        }else {
	            Log.e("categoria task", "onpost execute result null");
	        }
    	    dialog.dismiss();
    	 }
    	@Override
    	protected HashMap<String, ArrayList<HashMap<String, String>>> doInBackground(String... params) {
    		Log.e("thread end", " thread end");
			app = AppMy.getinstance();
			arraylist = new HashMap<String, ArrayList<HashMap<String, String>>>();
    		if(!app.isExternal()){
    			arraylist.put("mylistsubcategoria" , CursortoArrayhash.getinstance().ahSubcategoria(getContentResolver().query(
        				subcategoria.CONTENT_URI, ProjectionCreater.pcsubcategoria, null , null, subcategoria.DEFAULT_ORDEN)));
    			arraylist.put("mylistcontenido_unidad_medida" , CursortoArrayhash.getinstance().ahContenido_unidad_medida(getContentResolver().query(
        				contenido_unidad_medida.CONTENT_URI, ProjectionCreater.pccontenido_unidad_medida, null , null, contenido_unidad_medida.DEFAULT_ORDEN)));
        		arraylist.put("mylistformato_producto" , CursortoArrayhash.getinstance().ahFormato_producto(getContentResolver().query(
        				formato_producto.CONTENT_URI, ProjectionCreater.pcformato_producto, null , null, formato_producto.DEFAULT_ORDEN)));
        		arraylist.put("mylistfamilia_necesidad" , CursortoArrayhash.getinstance().ahFamilia_necesidad(getContentResolver().query(
        				familia_necesidad.CONTENT_URI, ProjectionCreater.pcfamilia_necesidad, null , null, familia_necesidad.DEFAULT_ORDEN)));
        		arraylist.put("mylistfamilia_producto" , CursortoArrayhash.getinstance().ahFamilia_producto(getContentResolver().query(
        				familia_producto.CONTENT_URI, ProjectionCreater.pcfamilia_producto, null , null, familia_producto.DEFAULT_ORDEN)));
        		arraylist.put("mylisttipo_producto" , CursortoArrayhash.getinstance().ahTipo_producto(getContentResolver().query(
        				tipo_producto.CONTENT_URI, ProjectionCreater.pctipo_producto, null , null, tipo_producto.DEFAULT_ORDEN)));
        	}
        	else
        	{
    			if(app.isOnline(Productoeditor.this))
            	{
    				try {
    					arraylist.put("mylistsubcategoria", WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda//getsubcategoriasdroid", "subcategoriaspinner"));
    	    		} catch (JSONException e) {
    	    			arraylist.put("mylistsubcategoria", new ArrayList<HashMap<String, String>>());
    	    			Log.e("json", " array list" + e);
    	    		}
            	}
            	else
            	{
            		Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
            	}
        	}
             return arraylist;
    	}
    }
	private void muestraeditor() 
	{
		Log.e("muestraeditor", " result.size() " + mylist.size() + " " + mylist.toString());
		//mid_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.id_producto));
		mcodigo_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.codigo_producto));
		mnumero_serie.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.numero_serie));
		mnombre_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.nombre_producto));
		mmarca_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.marca_producto));
		mmodelo_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.modelo_producto));
		mcontenido_unidad.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.contenido_unidad));
		munidad_minima.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.unidad_minima));
		mcontenido.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.contenido));
		mpeso_neto.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.peso_neto));
		malto_cm.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.alto_cm));
		mancho_cm.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.ancho_cm));
		mfondo_cm.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.fondo_cm));
		mfabricante.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.fabricante));
		mSKU.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.SKU));
		mprecio_CLP.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.precio_CLP));
		//mprecio_us.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.precio_us));
		mprecio_mayor_CLP.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.precio_mayor_CLP));
		//mprecio_mayor_us.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.precio_mayor_us));
		//mprecio_actual.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.precio_actual));
		mdescuento_promocion.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.descuento_promocion));
		mcantidad_mayor.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.cantidad_mayor));

		//mid_stock.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.id_stock));
		//mstock_real.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.stock_real));
		//mstock_minimo.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.stock_minimo));
		//mstock_ideal.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.stock_ideal));
		mstock_tienda.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.stock_tienda));
		//mstock_virtual.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.stock_virtual));
		//mstock_vendido.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.stock_vendido));
		//mlast_update.setTextKeepState(mylist.get(mylist.size()-1).get(productoprecio.last_update));
        map.put(stock.last_update, String.valueOf(Calendar.getInstance().getTimeInMillis()));

        if(mState == STATE_EDIT){
            map.put(productocompleto.id_precio, mylist.get(mylist.size()-1).get(productoprecio.id_precio));
            map.put(productocompleto.id_stock, mylist.get(mylist.size()-1).get(productoprecio.id_stock));
            Log.e("muestraeditor", "id_precio " + map.get(productocompleto.id_precio) + " id_stock " + map.get(productocompleto.id_stock));
        }
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Build the menus that are shown when editing.
        Log.e("estado mennu ", "mState " + mState);
        if (mState == STATE_EDIT) {
            menu.add(0, ADD_ID, 0, R.string.menu_update)
                    .setShortcut('0', 'r')
                    .setIcon(android.R.drawable.ic_menu_save)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
			menu.add(0, DELETE_ID, 0, R.string.menu_delete)
					.setShortcut('1', 'd')
					.setIcon(android.R.drawable.ic_menu_delete)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        } else {
            menu.add(0, ADD_ID, 0, R.string.menu_update)
					.setShortcut('0', 'r')
					.setIcon(android.R.drawable.ic_menu_save)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            menu.add(0, DISCARD_ID, 0, R.string.menu_discard)
                    .setShortcut('0', 'd')
                    .setIcon(android.R.drawable.ic_menu_delete)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(TAG, "itemselected.............");
        // Handle all of the possible menu actions.
        switch (item.getItemId()) {
        case DELETE_ID:
        	delProd();
            finish();
            break;
        case EDIT_ID:
        	addProd();
            break;
        case ADD_ID:
        	addProd();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

  	@Override
      protected void onActivityResult(int requestCode, int resultCode, Intent data)
      {
      	super.onActivityResult(requestCode, resultCode, data);
  		if(resultCode == RESULT_OK)
  		{
  			if(data != null)
  			{
  				SERIAL = data.getStringExtra("SCAN_RESULT");
				mcodigo_producto.setText(SERIAL);
  			}
  			else
  			{
  		        Log.e("14", "FOTO result" + prodFotoUri);
  			}
  		}
  	}
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
    	mcodigo_producto = (EditText) findViewById(R.id.etcodigo_producto);
        mnumero_serie = (EditText) findViewById(R.id.etnumero_serie);
        mnombre_producto = (EditText) findViewById(R.id.etnombre_producto);
        mmarca_producto = (EditText) findViewById(R.id.etmarca_producto);
        mmodelo_producto = (EditText) findViewById(R.id.etmodelo_producto);
        mcontenido_unidad = (EditText) findViewById(R.id.etcontenido_unidad);
        munidad_minima = (EditText) findViewById(R.id.etunidad_minima);
        mcontenido = (EditText) findViewById(R.id.etcontenido);
        mpeso_neto = (EditText) findViewById(R.id.etpeso_neto);
        malto_cm = (EditText) findViewById(R.id.etalto_cm);
        mancho_cm = (EditText) findViewById(R.id.etancho_cm);
        mfondo_cm = (EditText) findViewById(R.id.etfondo_cm);
        mfabricante = (EditText) findViewById(R.id.etfabricante);
        //mimagen = (EditText) findViewById(R.id.etimagen);
        mSKU = (EditText) findViewById(R.id.etSKU);
        mcantidad_mayor = (EditText) findViewById(R.id.etcantidad_mayor);
		mdescuento_promocion = (EditText) findViewById(R.id.etdescuento_promocion);
        mprecio_CLP = (EditText) findViewById(R.id.etprecio_CLP);
        mprecio_mayor_CLP = (EditText) findViewById(R.id.etprecio_mayor_CLP);
        mstock_tienda = (EditText) findViewById(R.id.etstock_tienda);
        msubcategoria_id_subcategoria = (Spinner)findViewById(R.id.spsubcategoria_id_subcategoria);
        mcontenido_unidad_medida_id_contenido_unidad_medida = (Spinner) findViewById(R.id.spcontenido_unidad_medida_id_contenido_unidad_medida);
        mfamilia_necesidad_id_familia_necesidad = (Spinner) findViewById(R.id.spfamilia_necesidad_id_familia_necesidad);
        mfamilia_producto_id_familia_producto = (Spinner) findViewById(R.id.spfamilia_producto_id_familia_producto);
        mtipo_producto_id_tipo_producto = (Spinner) findViewById(R.id.sptipo_producto_id_tipo_producto);
        mformato_producto_id_formato_producto = (Spinner) findViewById(R.id.spformato_producto_id_formato_producto);
    }
    
    public void limpiarPantalla()
    {
    	Log.e("limpiapantalla", "limpio___________________");
    	 // asigno textbox a variable corta
    	mcodigo_producto.setText("");
        mnumero_serie.setText("");
        mnombre_producto.setText("");
        mmarca_producto.setText("");
        mmodelo_producto.setText("");
        mcontenido_unidad.setText("");
        munidad_minima.setText("");
        //mcontenido_unidad_medida_id_contenido_unidad_medida.setText("");
        mcontenido.setText("");
        mpeso_neto.setText("");
        malto_cm.setText("");
        mancho_cm.setText("");
        mfondo_cm.setText("");
        mfabricante.setText("");
        //mfamilia_necesidad_id_familia_necesidad.setText("");
        //mfamilia_producto_id_familia_producto.setText("");
        //mtipo_producto_id_tipo_producto.setText("");
        mSKU.setText("");
        //mimagen.setText("");
        mcantidad_mayor.setText("");
		mdescuento_promocion.setText("");
        //mformato_producto_id_formato_producto.setText("");
        mprecio_CLP.setText("");
        mprecio_mayor_CLP.setText("");
        mstock_tienda.setText("");
    }

    private void delProd() {
    	//BORRA PROD POR ID
	}

    private void addProd() {
        Log.e("addProd", "add producto.............");

		map.put(productocompleto.codigo_producto, mcodigo_producto.getText().toString());
		map.put(productocompleto.numero_serie, mnumero_serie.getText().toString());
		map.put(productocompleto.nombre_producto, mnombre_producto.getText().toString());
		map.put(productocompleto.marca_producto, mmarca_producto.getText().toString());
		map.put(productocompleto.modelo_producto, mmodelo_producto.getText().toString());
		map.put(productocompleto.contenido_unidad, mcontenido_unidad.getText().toString());
		map.put(productocompleto.unidad_minima, munidad_minima.getText().toString());
		map.put(productocompleto.contenido, mcontenido.getText().toString());
		map.put(productocompleto.peso_neto, mpeso_neto.getText().toString());
		map.put(productocompleto.alto_cm, malto_cm.getText().toString());
		map.put(productocompleto.ancho_cm, mancho_cm.getText().toString());
		map.put(productocompleto.fondo_cm, mfondo_cm.getText().toString());
		map.put(productocompleto.fabricante, mfabricante.getText().toString());
		map.put(productocompleto.SKU, mSKU.getText().toString());
		map.put(productocompleto.precio_actual, "1");
		map.put(productocompleto.precio_CLP, mprecio_CLP.getText().toString());
		map.put(productocompleto.precio_mayor_CLP, mprecio_mayor_CLP.getText().toString());
		map.put(productocompleto.cantidad_mayor, mcantidad_mayor.getText().toString());
		map.put(productocompleto.descuento_promocion, mdescuento_promocion.getText().toString());
		map.put(productocompleto.stock_real, "0");
		map.put(productocompleto.stock_minimo, "0");
		map.put(productocompleto.stock_ideal, "0");
		map.put(productocompleto.stock_tienda, mstock_tienda.getText().toString());
		map.put(productocompleto.stock_virtual, "0");
		map.put(productocompleto.stock_vendido, "0");
		map.put(productocompleto.subcategoria_id_subcategoria, arraylist.get("mylistsubcategoria").get(msubcategoria_id_subcategoria.getSelectedItemPosition()).get("_id"));
		map.put(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida, arraylist.get("mylistcontenido_unidad_medida").get(mcontenido_unidad_medida_id_contenido_unidad_medida.getSelectedItemPosition()).get("_id"));
		map.put(productocompleto.familia_necesidad_id_familia_necesidad, arraylist.get("mylistfamilia_necesidad").get(mfamilia_necesidad_id_familia_necesidad.getSelectedItemPosition()).get("_id"));
		map.put(productocompleto.familia_producto_id_familia_producto, arraylist.get("mylistfamilia_producto").get(mfamilia_producto_id_familia_producto.getSelectedItemPosition()).get("_id"));
		map.put(productocompleto.tipo_producto_id_tipo_producto, arraylist.get("mylisttipo_producto").get(mtipo_producto_id_tipo_producto.getSelectedItemPosition()).get("_id"));
		map.put(productocompleto.formato_producto_id_formato_producto, arraylist.get("mylistformato_producto").get(mformato_producto_id_formato_producto.getSelectedItemPosition()).get("_id"));

		String descripcion = mmarca_producto.getText().toString() + " " +
				mnombre_producto.getText().toString() + " " +
				mmodelo_producto.getText().toString() + " " +
				mcontenido.getText().toString() + " " +
				mcontenido_unidad.getText().toString() + " " +
				arraylist.get("mylistcontenido_unidad_medida").get(mcontenido_unidad_medida_id_contenido_unidad_medida.getSelectedItemPosition()).get(contenido_unidad_medida.nombre_contenido_unidad_medida) + " " +
				mfabricante.getText().toString();
		map.put(productocompleto.descripcion_producto, descripcion);

    	Log.e("if (mState", "mState " + mState);
    	new sincTask().execute();
    }
    
	@Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onresume.............");
  }

    @Override
    protected void onPause() {
        Log.e(TAG, "pause.............");
        super.onPause();
    }
}

