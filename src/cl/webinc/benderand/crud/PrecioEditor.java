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

public class PrecioEditor extends Activity {
    private static final String TAG = "EDITOR precio";
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
    private EditText mid_precio;
    private EditText mprecio_CLP;
    private EditText mprecio_us;
    private EditText mprecio_mayor_CLP;
    private EditText mprecio_mayor_us;
    private EditText mprecio_actual;
    private EditText mdescuento_promocion;
    private EditText mcantidad_mayor;
    
    private Spinner mempresa_id_empresa;
    private Spinner mproducto_id_producto;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorprecio);
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
            dialog = new ProgressDialog(PrecioEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc precio ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc precio ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc precio", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc precio");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addprecio  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idprecio = String.valueOf(Integer.valueOf(getContentResolver().insert(precio.CONTENT_URI, PostData.getinstance().postdataready(map, "precio")).getLastPathSegment()));
                    login = Integer.valueOf(idprecio) > 0;
                    Log.e("addprecio  ", " do in background " + idprecio);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "precio").toString());
                        String idprecio = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(precio.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "precio"),null,null)));
                        login = Integer.valueOf(idprecio) > 0;
                        Log.e("updateprecio ", " do in background " + idprecio);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(PrecioEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "saveprecio";
                    }
                    else
                    {
                        action = "updateprecio";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "precio");
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
            dialog = new ProgressDialog(PrecioEditor.this);
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
                Log.e("precioeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra precio, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahPrecio(getContentResolver().query(
                        ContentUris.withAppendedId(precio.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcprecio, null, null, precio.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(PrecioEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "precio");
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
            dialog = new ProgressDialog(PrecioEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterempresa = new SimpleAdapter(PrecioEditor.this, result.get("mylistempresa"), android.R.layout.simple_spinner_item,
                        new String[] {empresa.nombre_empresa}, new int[] {android.R.id.text1 });
                adapterempresa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mempresa_id_empresa.setAdapter(adapterempresa);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(empresa.id_empresa))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mempresa_id_empresa.setSelection(compareValue);
                    }
                }
SimpleAdapter adapterproducto = new SimpleAdapter(PrecioEditor.this, result.get("mylistproducto"), android.R.layout.simple_spinner_item,
                        new String[] {producto.nombre_producto}, new int[] {android.R.id.text1 });
                adapterproducto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mproducto_id_producto.setAdapter(adapterproducto);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(producto.id_producto))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mproducto_id_producto.setSelection(compareValue);
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
                arraylist.put("mylistempresa" , CursortoArrayhash.getinstance().ahEmpresa(getContentResolver().query(
                        empresa.CONTENT_URI, ProjectionCreater.pcempresa, null , null, empresa.DEFAULT_ORDEN)));
arraylist.put("mylistproducto" , CursortoArrayhash.getinstance().ahProducto(getContentResolver().query(
                        producto.CONTENT_URI, ProjectionCreater.pcproducto, null , null, producto.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(PrecioEditor.this))
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
        mid_precio.setTextKeepState(mylist.get(mylist.size()-1).get(precio.id_precio));
        mprecio_CLP.setTextKeepState(mylist.get(mylist.size()-1).get(precio.precio_CLP));
        mprecio_us.setTextKeepState(mylist.get(mylist.size()-1).get(precio.precio_us));
        mprecio_mayor_CLP.setTextKeepState(mylist.get(mylist.size()-1).get(precio.precio_mayor_CLP));
        mprecio_mayor_us.setTextKeepState(mylist.get(mylist.size()-1).get(precio.precio_mayor_us));
        mprecio_actual.setTextKeepState(mylist.get(mylist.size()-1).get(precio.precio_actual));
        mdescuento_promocion.setTextKeepState(mylist.get(mylist.size()-1).get(precio.descuento_promocion));
        mcantidad_mayor.setTextKeepState(mylist.get(mylist.size()-1).get(precio.cantidad_mayor));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_precio = (EditText) findViewById(R.id.etid_precio);
        mprecio_CLP = (EditText) findViewById(R.id.etprecio_CLP);
        mprecio_us = (EditText) findViewById(R.id.etprecio_us);
        mprecio_mayor_CLP = (EditText) findViewById(R.id.etprecio_mayor_CLP);
        mprecio_mayor_us = (EditText) findViewById(R.id.etprecio_mayor_us);
        mprecio_actual = (EditText) findViewById(R.id.etprecio_actual);
        mdescuento_promocion = (EditText) findViewById(R.id.etdescuento_promocion);
        mcantidad_mayor = (EditText) findViewById(R.id.etcantidad_mayor);
        
        mempresa_id_empresa = (Spinner) findViewById(R.id.spempresa_id_empresa);
        mproducto_id_producto = (Spinner) findViewById(R.id.spproducto_id_producto);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_precio.setText("");
        mprecio_CLP.setText("");
        mprecio_us.setText("");
        mprecio_mayor_CLP.setText("");
        mprecio_mayor_us.setText("");
        mprecio_actual.setText("");
        mdescuento_promocion.setText("");
        mcantidad_mayor.setText("");
        
    }

    private void addPrecio() {
        Log.e("add", "add Precio");
        map.put(precio.id_precio, mid_precio.getText().toString());
        map.put(precio.precio_CLP, mprecio_CLP.getText().toString());
        map.put(precio.precio_us, mprecio_us.getText().toString());
        map.put(precio.precio_mayor_CLP, mprecio_mayor_CLP.getText().toString());
        map.put(precio.precio_mayor_us, mprecio_mayor_us.getText().toString());
        map.put(precio.precio_actual, mprecio_actual.getText().toString());
        map.put(precio.descuento_promocion, mdescuento_promocion.getText().toString());
        map.put(precio.cantidad_mayor, mcantidad_mayor.getText().toString());
        
        
        map.put(precio.empresa_id_empresa, arraylist.get("mylistempresa").get(mempresa_id_empresa.getSelectedItemPosition()).get("_id"));

        map.put(precio.producto_id_producto, arraylist.get("mylistproducto").get(mproducto_id_producto.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delPrecio() {
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
            delPrecio();
            finish();
            break;
        case EDIT_ID:
            addPrecio();
            break;
        case ADD_ID:
            addPrecio();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}