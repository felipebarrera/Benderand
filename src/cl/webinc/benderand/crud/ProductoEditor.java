package cl.webinc.benderand.crud;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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
import java.util.HashMap;

import cl.webinc.benderand.R;
import cl.webinc.benderand.AppMy;
import cl.webinc.benderand.provider.Base.*;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class ProductoEditor extends Activity {
    private static final String TAG = "EDITOR producto";
    private String ID = "0";
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
    private EditText mid_producto;
    private EditText mcodigo_producto;
    private EditText mnumero_serie;
    private EditText mdescripcion_producto;
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
    private EditText mclase_producto;
    private EditText mlinea_producto;
    private EditText mhot;
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
        
        setContentView(R.layout.editorproducto);
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
        
    }
    
    private class sincTask extends AsyncTask<String, Void, Boolean>  
    {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(ProductoEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
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
            Log.e("addproducto  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idproducto = String.valueOf(Integer.valueOf(getContentResolver().insert(producto.CONTENT_URI, PostData.getinstance().postdataready(map, "producto")).getLastPathSegment()));
                    login = Integer.valueOf(idproducto) > 0;
                    Log.e("addproducto  ", " do in background " + idproducto);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "producto").toString());
                        String idproducto = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(producto.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "producto"),null,null)));
                        login = Integer.valueOf(idproducto) > 0;
                        Log.e("updateproducto ", " do in background " + idproducto);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(ProductoEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "saveproducto";
                    }
                    else
                    {
                        action = "updateproducto";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "producto");
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
            dialog = new ProgressDialog(ProductoEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
            if(result.size() != 0) 
            {
                asignarCamposvariableCorta();
                muestraeditor();
                Log.e("productoeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra producto, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahProducto(getContentResolver().query(
                        ContentUris.withAppendedId(producto.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcproducto, null, null, producto.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(ProductoEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "producto");
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
            dialog = new ProgressDialog(ProductoEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adaptercontenido_unidad_medida = new SimpleAdapter(ProductoEditor.this, result.get("mylistcontenido_unidad_medida"), android.R.layout.simple_spinner_item,
                        new String[] {contenido_unidad_medida.nombre_contenido_unidad_medida}, new int[] {android.R.id.text1 });
                adaptercontenido_unidad_medida.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mcontenido_unidad_medida_id_contenido_unidad_medida.setAdapter(adaptercontenido_unidad_medida);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(contenido_unidad_medida.id_contenido_unidad_medida))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mcontenido_unidad_medida_id_contenido_unidad_medida.setSelection(compareValue);
                    }
                }
SimpleAdapter adaptersubcategoria = new SimpleAdapter(ProductoEditor.this, result.get("mylistsubcategoria"), android.R.layout.simple_spinner_item,
                        new String[] {subcategoria.nombre_subcategoria}, new int[] {android.R.id.text1 });
                adaptersubcategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                msubcategoria_id_subcategoria.setAdapter(adaptersubcategoria);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(subcategoria.id_subcategoria))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        msubcategoria_id_subcategoria.setSelection(compareValue);
                    }
                }
SimpleAdapter adaptertipo_producto = new SimpleAdapter(ProductoEditor.this, result.get("mylisttipo_producto"), android.R.layout.simple_spinner_item,
                        new String[] {tipo_producto.nombre_tipo_producto}, new int[] {android.R.id.text1 });
                adaptertipo_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mtipo_producto_id_tipo_producto.setAdapter(adaptertipo_producto);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(tipo_producto.id_tipo_producto))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mtipo_producto_id_tipo_producto.setSelection(compareValue);
                    }
                }
SimpleAdapter adapterformato_producto = new SimpleAdapter(ProductoEditor.this, result.get("mylistformato_producto"), android.R.layout.simple_spinner_item,
                        new String[] {formato_producto.nombre_formato_producto}, new int[] {android.R.id.text1 });
                adapterformato_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mformato_producto_id_formato_producto.setAdapter(adapterformato_producto);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(formato_producto.id_formato_producto))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mformato_producto_id_formato_producto.setSelection(compareValue);
                    }
                }
SimpleAdapter adapterfamilia_necesidad = new SimpleAdapter(ProductoEditor.this, result.get("mylistfamilia_necesidad"), android.R.layout.simple_spinner_item,
                        new String[] {familia_necesidad.nombre_familia_necesidad}, new int[] {android.R.id.text1 });
                adapterfamilia_necesidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mfamilia_necesidad_id_familia_necesidad.setAdapter(adapterfamilia_necesidad);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(familia_necesidad.id_familia_necesidad))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mfamilia_necesidad_id_familia_necesidad.setSelection(compareValue);
                    }
                }
SimpleAdapter adapterfamilia_producto = new SimpleAdapter(ProductoEditor.this, result.get("mylistfamilia_producto"), android.R.layout.simple_spinner_item,
                        new String[] {familia_producto.nombre_familia_producto}, new int[] {android.R.id.text1 });
                adapterfamilia_producto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mfamilia_producto_id_familia_producto.setAdapter(adapterfamilia_producto);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(familia_producto.id_familia_producto))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mfamilia_producto_id_familia_producto.setSelection(compareValue);
                    }
                }

            }else {
                Log.e("categoria task", "onpost execute result null");
            }
            //m_ProgressDialog.dismiss();
         }
        @Override
        protected HashMap<String, ArrayList<HashMap<String, String>>> doInBackground(String... params) {
            Log.e("thread end", " thread end");
            app = AppMy.getinstance();
            arraylist = new HashMap<String, ArrayList<HashMap<String, String>>>();
            if(!app.isExternal()){
                arraylist.put("mylistcontenido_unidad_medida" , CursortoArrayhash.getinstance().ahContenido_unidad_medida(getContentResolver().query(
                        contenido_unidad_medida.CONTENT_URI, ProjectionCreater.pccontenido_unidad_medida, null , null, contenido_unidad_medida.DEFAULT_ORDEN)));
arraylist.put("mylistsubcategoria" , CursortoArrayhash.getinstance().ahSubcategoria(getContentResolver().query(
                        subcategoria.CONTENT_URI, ProjectionCreater.pcsubcategoria, null , null, subcategoria.DEFAULT_ORDEN)));
arraylist.put("mylisttipo_producto" , CursortoArrayhash.getinstance().ahTipo_producto(getContentResolver().query(
                        tipo_producto.CONTENT_URI, ProjectionCreater.pctipo_producto, null , null, tipo_producto.DEFAULT_ORDEN)));
arraylist.put("mylistformato_producto" , CursortoArrayhash.getinstance().ahFormato_producto(getContentResolver().query(
                        formato_producto.CONTENT_URI, ProjectionCreater.pcformato_producto, null , null, formato_producto.DEFAULT_ORDEN)));
arraylist.put("mylistfamilia_necesidad" , CursortoArrayhash.getinstance().ahFamilia_necesidad(getContentResolver().query(
                        familia_necesidad.CONTENT_URI, ProjectionCreater.pcfamilia_necesidad, null , null, familia_necesidad.DEFAULT_ORDEN)));
arraylist.put("mylistfamilia_producto" , CursortoArrayhash.getinstance().ahFamilia_producto(getContentResolver().query(
                        familia_producto.CONTENT_URI, ProjectionCreater.pcfamilia_producto, null , null, familia_producto.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(ProductoEditor.this))
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
        mid_producto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.id_producto));
        mcodigo_producto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.codigo_producto));
        mnumero_serie.setTextKeepState(mylist.get(mylist.size()-1).get(producto.numero_serie));
        mdescripcion_producto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.descripcion_producto));
        mnombre_producto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.nombre_producto));
        mmarca_producto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.marca_producto));
        mmodelo_producto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.modelo_producto));
        mcontenido_unidad.setTextKeepState(mylist.get(mylist.size()-1).get(producto.contenido_unidad));
        munidad_minima.setTextKeepState(mylist.get(mylist.size()-1).get(producto.unidad_minima));
        mcontenido.setTextKeepState(mylist.get(mylist.size()-1).get(producto.contenido));
        mpeso_neto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.peso_neto));
        malto_cm.setTextKeepState(mylist.get(mylist.size()-1).get(producto.alto_cm));
        mancho_cm.setTextKeepState(mylist.get(mylist.size()-1).get(producto.ancho_cm));
        mfondo_cm.setTextKeepState(mylist.get(mylist.size()-1).get(producto.fondo_cm));
        mfabricante.setTextKeepState(mylist.get(mylist.size()-1).get(producto.fabricante));
        mclase_producto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.clase_producto));
        mlinea_producto.setTextKeepState(mylist.get(mylist.size()-1).get(producto.linea_producto));
        mhot.setTextKeepState(mylist.get(mylist.size()-1).get(producto.hot));
        mSKU.setTextKeepState(mylist.get(mylist.size()-1).get(producto.SKU));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_producto = (EditText) findViewById(R.id.etid_producto);
        mcodigo_producto = (EditText) findViewById(R.id.etcodigo_producto);
        mnumero_serie = (EditText) findViewById(R.id.etnumero_serie);
        mdescripcion_producto = (EditText) findViewById(R.id.etdescripcion_producto);
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
        mclase_producto = (EditText) findViewById(R.id.etclase_producto);
        mlinea_producto = (EditText) findViewById(R.id.etlinea_producto);
        mhot = (EditText) findViewById(R.id.ethot);
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
        mid_producto.setText("");
        mcodigo_producto.setText("");
        mnumero_serie.setText("");
        mdescripcion_producto.setText("");
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
        mclase_producto.setText("");
        mlinea_producto.setText("");
        mhot.setText("");
        mSKU.setText("");
        
    }

    private void addProducto() {
        Log.e("add", "add Producto");
        map.put(producto.id_producto, mid_producto.getText().toString());
        map.put(producto.codigo_producto, mcodigo_producto.getText().toString());
        map.put(producto.numero_serie, mnumero_serie.getText().toString());
        map.put(producto.descripcion_producto, mdescripcion_producto.getText().toString());
        map.put(producto.nombre_producto, mnombre_producto.getText().toString());
        map.put(producto.marca_producto, mmarca_producto.getText().toString());
        map.put(producto.modelo_producto, mmodelo_producto.getText().toString());
        map.put(producto.contenido_unidad, mcontenido_unidad.getText().toString());
        map.put(producto.unidad_minima, munidad_minima.getText().toString());
        map.put(producto.contenido, mcontenido.getText().toString());
        map.put(producto.peso_neto, mpeso_neto.getText().toString());
        map.put(producto.alto_cm, malto_cm.getText().toString());
        map.put(producto.ancho_cm, mancho_cm.getText().toString());
        map.put(producto.fondo_cm, mfondo_cm.getText().toString());
        map.put(producto.fabricante, mfabricante.getText().toString());
        map.put(producto.clase_producto, mclase_producto.getText().toString());
        map.put(producto.linea_producto, mlinea_producto.getText().toString());
        map.put(producto.hot, mhot.getText().toString());
        map.put(producto.SKU, mSKU.getText().toString());
        
        
        map.put(producto.contenido_unidad_medida_id_contenido_unidad_medida, arraylist.get("mylistcontenido_unidad_medida").get(mcontenido_unidad_medida_id_contenido_unidad_medida.getSelectedItemPosition()).get("_id"));

        map.put(producto.subcategoria_id_subcategoria, arraylist.get("mylistsubcategoria").get(msubcategoria_id_subcategoria.getSelectedItemPosition()).get("_id"));

        map.put(producto.tipo_producto_id_tipo_producto, arraylist.get("mylisttipo_producto").get(mtipo_producto_id_tipo_producto.getSelectedItemPosition()).get("_id"));

        map.put(producto.formato_producto_id_formato_producto, arraylist.get("mylistformato_producto").get(mformato_producto_id_formato_producto.getSelectedItemPosition()).get("_id"));

        map.put(producto.familia_necesidad_id_familia_necesidad, arraylist.get("mylistfamilia_necesidad").get(mfamilia_necesidad_id_familia_necesidad.getSelectedItemPosition()).get("_id"));

        map.put(producto.familia_producto_id_familia_producto, arraylist.get("mylistfamilia_producto").get(mfamilia_producto_id_familia_producto.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delProducto() {
        //BORRA PROD POR ID
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Log.e("onCreateOptionsMenu", "menuoptions.............");

        // Build the menus that are shown when editing.
        Log.e("estado mennu ", "mState " + mState);
        if (mState == STATE_EDIT) {
            menu.add(0, ADD_ID, 0, R.string.menu_update)
                    .setShortcut('0', 'r')
                    .setIcon(android.R.drawable.ic_menu_save);
            menu.add(0, DELETE_ID, 0, R.string.menu_delete)
                    .setShortcut('1', 'd')
                    .setIcon(android.R.drawable.ic_menu_delete);
        } else {
            menu.add(0, ADD_ID, 0, R.string.menu_insert)
            .setShortcut('0', 'r')
            .setIcon(android.R.drawable.ic_menu_save);
            menu.add(0, DISCARD_ID, 0, R.string.menu_discard)
                    .setShortcut('0', 'd')
                    .setIcon(android.R.drawable.ic_menu_delete);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(TAG, "itemselected.............");
        // Handle all of the possible menu actions.
        switch (item.getItemId()) {
        case DELETE_ID:
            delProducto();
            finish();
            break;
        case EDIT_ID:
            addProducto();
            break;
        case ADD_ID:
            addProducto();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}