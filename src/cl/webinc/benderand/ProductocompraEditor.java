package cl.webinc.benderand;

/**
 * Created by Felipe on 15-06-2015.
 * ingresar o actualizar un producto desde el menu de compras
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.provider.Base.productocompra;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class ProductocompraEditor extends AppCompatActivity {
	private static final String TAG = "EDITOR productocompra";
	private String ID = "0";
	private String SERIAL = "0";
	private int TYPEBTN = 0;
	protected String FORMAT;
	private File storageDir ;
	private Uri prodFotoUri;
	private static final int ADD_ID = Menu.FIRST;
	private static final int DISCARD_ID = Menu.FIRST + 1;
	private static final int DELETE_ID = Menu.FIRST + 2;
	private static final int EDIT_ID = Menu.FIRST + 3;
	private static final int STATE_EDIT = 1;
	private static final int STATE_INSERT = 0;
	private int mState;
	private HashMap<String, String> map = new HashMap<String, String>();
	public String action;
	private ArrayList<HashMap<String, String>> mylist;
	private static AppMy app = AppMy.getinstance();
	public HashMap<String, ArrayList<HashMap<String, String>>>  arraylist;
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
    
    private Spinner mcontenido_unidad_medida_id_contenido_unidad_medida;
    private Spinner msubcategoria_id_subcategoria;
    private Spinner mtipo_producto_id_tipo_producto;
    private Spinner mformato_producto_id_formato_producto;
    private Spinner mfamilia_necesidad_id_familia_necesidad;
    private Spinner mfamilia_producto_id_familia_producto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e(TAG, "ONCREATE ");
		super.onCreate(savedInstanceState);
		ID = app.getExtra().get("id");
		setContentView(R.layout.editorproductocompramod);
		setTitle(R.string.editordeproducto);
		asignarCamposvariableCorta();
		if(!ID.equals("0"))
		{
			Log.e("ONCREATE query  ", "ID != 0" + ID );
			limpiarPantalla();
			mState = STATE_EDIT;

			new sincTaskbuscarid().execute();
		}
		else
		{
			limpiarPantalla();
			mState = STATE_INSERT;
		}

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

		mcodigo_producto.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
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
			dialog = new ProgressDialog(ProductocompraEditor.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(ProductocompraEditor.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		private boolean login = false;
		@Override
		protected void onPostExecute(Boolean result)
		{
			if(login)
			{
				Toast.makeText(getApplicationContext(), "Sinc productocompra ok", Toast.LENGTH_SHORT).show();
				Log.e("sincTask " + mState, "Sinc productocompra ok");
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Error en sinc productocompra", Toast.LENGTH_SHORT).show();
				Log.e("sincTask " + mState, "Error en sinc productocompra");
			}
			dialog.dismiss();
			finish();//vuelvo a la lista
		}
		@Override
		protected Boolean doInBackground(
				String... params) {
			app = AppMy.getinstance();
			Log.e("addproductocompra  ", " do in background");
			if(!app.isExternal()){
				if (mState == STATE_INSERT) {
					String idproductocompra = String.valueOf(Integer.valueOf(getContentResolver().insert(Base.producto.CONTENT_URI, PostData.getinstance().postdataready(map, "producto")).getLastPathSegment()));
					login = Integer.valueOf(idproductocompra) > 0;
					Log.e("addproductocompra  ", " do in background " + idproductocompra);
				}
				else
				{
					Log.e("" + mState, "mState" + mState);
					try{
						Log.e("values", "" + PostData.getinstance().postdataready(map, "productocompra").toString());
						String idproductocompra = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(productocompra.CONTENT_URI, Long.parseLong(ID)),
								PostData.getinstance().postdataready(map, "productocompra"),null,null)));
						login = Integer.valueOf(idproductocompra) > 0;
						Log.e("updateproductocompra ", " do in background " + idproductocompra);
					}
					catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}

				}
			}
			else
			{
				if(app.isOnline(ProductocompraEditor.this))
				{
					if (mState == STATE_INSERT) {
						action = "saveproductocompra";
					}
					else
					{
						action = "updateproductocompra";
					}
					login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "productocompra");
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
			dialog = new ProgressDialog(ProductocompraEditor.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(ProductocompraEditor.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
			if(result.size() != 0)
			{
				asignarCamposvariableCorta();
				muestraeditor();
				Log.e("productocompraeditor", " not null");
			}else {
				Toast.makeText(getApplicationContext(), "No se encuentra productocompra, error de sincronizacion", Toast.LENGTH_SHORT).show();
				Log.e("terrible null", " return");
			}
			dialog.dismiss();
		}
		@Override
		protected ArrayList<HashMap<String, String>> doInBackground(
				String... params) {
			Log.e("thread end", " thread end");
			app = AppMy.getinstance();
			if(!app.isExternal()){
				mylist = CursortoArrayhash.getinstance().ahProductocompra(getContentResolver().query(
						ContentUris.withAppendedId(productocompra.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcproductocompra, null, null, productocompra.id_producto));
			}
			else
			{
				if(app.isOnline(ProductocompraEditor.this))
				{
					try {
						mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "productocompra");
					} catch (JSONException e) {
						mylist = new ArrayList<HashMap<String, String>>();
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
	private class sincTaskcargaspinners extends AsyncTask<String, Void, HashMap<String, ArrayList<HashMap<String, String>>>>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(ProductocompraEditor.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(ProductocompraEditor.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
			if(result != null) {
				Log.e(TAG,  "" + result.size());
                SimpleAdapter adaptercontenido_unidad_medida = new SimpleAdapter(ProductocompraEditor.this, result.get("mylistcontenido_unidad_medida"), android.R.layout.simple_spinner_item,
                        new String[] {Base.contenido_unidad_medida.nombre_contenido_unidad_medida}, new int[] {android.R.id.text1 });
                adaptercontenido_unidad_medida.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mcontenido_unidad_medida_id_contenido_unidad_medida.setAdapter(adaptercontenido_unidad_medida);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.contenido_unidad_medida.id_contenido_unidad_medida))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mcontenido_unidad_medida_id_contenido_unidad_medida.setSelection(compareValue);
                    }
                }
				SimpleAdapter adaptersubcategoria = new SimpleAdapter(ProductocompraEditor.this, result.get("mylistsubcategoria"), android.R.layout.simple_spinner_item,
                        new String[] {Base.subcategoria.nombre_subcategoria}, new int[] {android.R.id.text1 });
                adaptersubcategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                msubcategoria_id_subcategoria.setAdapter(adaptersubcategoria);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.subcategoria.id_subcategoria))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        msubcategoria_id_subcategoria.setSelection(compareValue);
                    }
                }
				SimpleAdapter adaptertipo_producto = new SimpleAdapter(ProductocompraEditor.this, result.get("mylisttipo_producto"), android.R.layout.simple_spinner_item,
                        new String[] {Base.tipo_producto.nombre_tipo_producto}, new int[] {android.R.id.text1 });
                adaptertipo_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mtipo_producto_id_tipo_producto.setAdapter(adaptertipo_producto);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.tipo_producto.id_tipo_producto))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mtipo_producto_id_tipo_producto.setSelection(compareValue);
                    }
                }
				SimpleAdapter adapterformato_producto = new SimpleAdapter(ProductocompraEditor.this, result.get("mylistformato_producto"), android.R.layout.simple_spinner_item,
                        new String[] {Base.formato_producto.nombre_formato_producto}, new int[] {android.R.id.text1 });
                adapterformato_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mformato_producto_id_formato_producto.setAdapter(adapterformato_producto);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.formato_producto.id_formato_producto))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mformato_producto_id_formato_producto.setSelection(compareValue);
                    }
                }
				SimpleAdapter adapterfamilia_necesidad = new SimpleAdapter(ProductocompraEditor.this, result.get("mylistfamilia_necesidad"), android.R.layout.simple_spinner_item,
                        new String[] {Base.familia_necesidad.nombre_familia_necesidad}, new int[] {android.R.id.text1 });
                adapterfamilia_necesidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mfamilia_necesidad_id_familia_necesidad.setAdapter(adapterfamilia_necesidad);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.familia_necesidad.id_familia_necesidad))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mfamilia_necesidad_id_familia_necesidad.setSelection(compareValue);
                    }
                }
				SimpleAdapter adapterfamilia_producto = new SimpleAdapter(ProductocompraEditor.this, result.get("mylistfamilia_producto"), android.R.layout.simple_spinner_item,
                        new String[] {Base.familia_producto.nombre_familia_producto}, new int[] {android.R.id.text1 });
                adapterfamilia_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mfamilia_producto_id_familia_producto.setAdapter(adapterfamilia_producto);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.familia_producto.id_familia_producto))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mfamilia_producto_id_familia_producto.setSelection(compareValue);
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
                arraylist.put("mylistcontenido_unidad_medida" , CursortoArrayhash.getinstance().ahContenido_unidad_medida(getContentResolver().query(
						Base.contenido_unidad_medida.CONTENT_URI, ProjectionCreater.pccontenido_unidad_medida, null , null, Base.contenido_unidad_medida.DEFAULT_ORDEN)));
				arraylist.put("mylistsubcategoria" , CursortoArrayhash.getinstance().ahSubcategoria(getContentResolver().query(
						Base.subcategoria.CONTENT_URI, ProjectionCreater.pcsubcategoria, null , null, Base.subcategoria.DEFAULT_ORDEN)));
				arraylist.put("mylisttipo_producto" , CursortoArrayhash.getinstance().ahTipo_producto(getContentResolver().query(
						Base.tipo_producto.CONTENT_URI, ProjectionCreater.pctipo_producto, null , null, Base.tipo_producto.DEFAULT_ORDEN)));
				arraylist.put("mylistformato_producto" , CursortoArrayhash.getinstance().ahFormato_producto(getContentResolver().query(
						Base.formato_producto.CONTENT_URI, ProjectionCreater.pcformato_producto, null , null, Base.formato_producto.DEFAULT_ORDEN)));
				arraylist.put("mylistfamilia_necesidad" , CursortoArrayhash.getinstance().ahFamilia_necesidad(getContentResolver().query(
						Base.familia_necesidad.CONTENT_URI, ProjectionCreater.pcfamilia_necesidad, null , null, Base.familia_necesidad.DEFAULT_ORDEN)));
				arraylist.put("mylistfamilia_producto" , CursortoArrayhash.getinstance().ahFamilia_producto(getContentResolver().query(
						Base.familia_producto.CONTENT_URI, ProjectionCreater.pcfamilia_producto, null , null, Base.familia_producto.DEFAULT_ORDEN)));
			}
			else
			{
				if(app.isOnline(ProductocompraEditor.this))
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
		Log.e("json", " result.size() " + mylist.size() + " " + mylist.toString());
        mcodigo_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.codigo_producto));
        mnumero_serie.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.numero_serie));
        mnombre_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.nombre_producto));
        mmarca_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.marca_producto));
        mmodelo_producto.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.modelo_producto));
        mcontenido_unidad.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.contenido_unidad));
        munidad_minima.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.unidad_minima));
        mcontenido.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.contenido));
        mpeso_neto.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.peso_neto));
        malto_cm.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.alto_cm));
        mancho_cm.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.ancho_cm));
        mfondo_cm.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.fondo_cm));
        mfabricante.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.fabricante));
        mSKU.setTextKeepState(mylist.get(mylist.size()-1).get(productocompra.SKU));
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
        mSKU = (EditText) findViewById(R.id.etSKU);
        
        mcontenido_unidad_medida_id_contenido_unidad_medida = (Spinner) findViewById(R.id.spcontenido_unidad_medida_id_contenido_unidad_medida);
        msubcategoria_id_subcategoria = (Spinner) findViewById(R.id.spsubcategoria_id_subcategoria);
        mtipo_producto_id_tipo_producto = (Spinner) findViewById(R.id.sptipo_producto_id_tipo_producto);
        mformato_producto_id_formato_producto = (Spinner) findViewById(R.id.spformato_producto_id_formato_producto);
        mfamilia_necesidad_id_familia_necesidad = (Spinner) findViewById(R.id.spfamilia_necesidad_id_familia_necesidad);
        mfamilia_producto_id_familia_producto = (Spinner) findViewById(R.id.spfamilia_producto_id_familia_producto);
	}

	public void limpiarPantalla()
	{
		Log.e("limpiapantalla", "limpio___________________");
        mcodigo_producto.setText("");
        mnumero_serie.setText("");
        mnombre_producto.setText("");
        mmarca_producto.setText("");
        mmodelo_producto.setText("");
        mcontenido_unidad.setText("");
        munidad_minima.setText("");
        mcontenido.setText("");
        mpeso_neto.setText("");
        malto_cm.setText("");
        mancho_cm.setText("");
        mfondo_cm.setText("");
        mfabricante.setText("");
        mSKU.setText("");
	}

	private void addProductocompra() {
		Log.e("add", "add Productocompra");
        map.put(productocompra.codigo_producto, mcodigo_producto.getText().toString());
        map.put(productocompra.numero_serie, mnumero_serie.getText().toString());
        //map.put(productocompra.descripcion_producto, mdescripcion_producto.getText().toString());
        map.put(productocompra.nombre_producto, mnombre_producto.getText().toString());
        map.put(productocompra.marca_producto, mmarca_producto.getText().toString());
        map.put(productocompra.modelo_producto, mmodelo_producto.getText().toString());
        map.put(productocompra.contenido_unidad, mcontenido_unidad.getText().toString());
        map.put(productocompra.unidad_minima, munidad_minima.getText().toString());
        map.put(productocompra.contenido, mcontenido.getText().toString());
        map.put(productocompra.peso_neto, mpeso_neto.getText().toString());
        map.put(productocompra.alto_cm, malto_cm.getText().toString());
        map.put(productocompra.ancho_cm, mancho_cm.getText().toString());
        map.put(productocompra.fondo_cm, mfondo_cm.getText().toString());
        map.put(productocompra.fabricante, mfabricante.getText().toString());
        map.put(productocompra.SKU, mSKU.getText().toString());

        map.put(productocompra.contenido_unidad_medida_id_contenido_unidad_medida, arraylist.get("mylistcontenido_unidad_medida").get(mcontenido_unidad_medida_id_contenido_unidad_medida.getSelectedItemPosition()).get("_id"));

        map.put(productocompra.subcategoria_id_subcategoria, arraylist.get("mylistsubcategoria").get(msubcategoria_id_subcategoria.getSelectedItemPosition()).get("_id"));

        map.put(productocompra.tipo_producto_id_tipo_producto, arraylist.get("mylisttipo_producto").get(mtipo_producto_id_tipo_producto.getSelectedItemPosition()).get("_id"));

        map.put(productocompra.formato_producto_id_formato_producto, arraylist.get("mylistformato_producto").get(mformato_producto_id_formato_producto.getSelectedItemPosition()).get("_id"));

        map.put(productocompra.familia_necesidad_id_familia_necesidad, arraylist.get("mylistfamilia_necesidad").get(mfamilia_necesidad_id_familia_necesidad.getSelectedItemPosition()).get("_id"));

        map.put(productocompra.familia_producto_id_familia_producto, arraylist.get("mylistfamilia_producto").get(mfamilia_producto_id_familia_producto.getSelectedItemPosition()).get("_id"));

		String descripcion = mmarca_producto.getText().toString() + " " +
				mnombre_producto.getText().toString() + " " +
				mmodelo_producto.getText().toString() + " " +
				mcontenido.getText().toString() + " " +
				mcontenido_unidad.getText().toString() + " " +
				arraylist.get("mylistcontenido_unidad_medida").get(mcontenido_unidad_medida_id_contenido_unidad_medida.getSelectedItemPosition()).get(Base.contenido_unidad_medida.nombre_contenido_unidad_medida) + " " +
				mfabricante.getText().toString();
		map.put(productocompra.descripcion_producto, descripcion);


		Log.e("if (mState", "mState" + mState);
		new sincTask().execute();
	}

	private void delProductocompra() {
		//BORRA PROD POR ID
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e("onResume", "onresume.............");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		Log.e("9", "prodFotoUri " + prodFotoUri);
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

	@Override
	protected void onPause() {
		Log.e(TAG, "pause.............");
		super.onPause();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		Log.e("onCreateOptionsMenu", "menuoptions.............");

		// Build the menus that are shown when editing.
		Log.e("estado mennu ", "mState " + mState);
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
				delProductocompra();
				finish();
				break;
			case EDIT_ID:
				addProductocompra();
				break;
			case ADD_ID:
				addProductocompra();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}