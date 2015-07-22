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

public class RecicladoEditor extends Activity {
    private static final String TAG = "EDITOR reciclado";
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
    private EditText mid_reciclado;
    private EditText mreciclable;
    private EditText mreciclado;
    private EditText mvalor_reciclaje;
    
    private Spinner mempresa_id_empresa;
    private Spinner mproducto_id_producto;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorreciclado);
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
            dialog = new ProgressDialog(RecicladoEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc reciclado ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc reciclado ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc reciclado", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc reciclado");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addreciclado  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idreciclado = String.valueOf(Integer.valueOf(getContentResolver().insert(reciclado.CONTENT_URI, PostData.getinstance().postdataready(map, "reciclado")).getLastPathSegment()));
                    login = Integer.valueOf(idreciclado) > 0;
                    Log.e("addreciclado  ", " do in background " + idreciclado);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "reciclado").toString());
                        String idreciclado = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(reciclado.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "reciclado"),null,null)));
                        login = Integer.valueOf(idreciclado) > 0;
                        Log.e("updatereciclado ", " do in background " + idreciclado);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(RecicladoEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savereciclado";
                    }
                    else
                    {
                        action = "updatereciclado";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "reciclado");
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
            dialog = new ProgressDialog(RecicladoEditor.this);
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
                Log.e("recicladoeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra reciclado, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahReciclado(getContentResolver().query(
                        ContentUris.withAppendedId(reciclado.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcreciclado, null, null, reciclado.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(RecicladoEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "reciclado");
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
            dialog = new ProgressDialog(RecicladoEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterempresa = new SimpleAdapter(RecicladoEditor.this, result.get("mylistempresa"), android.R.layout.simple_spinner_item,
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
SimpleAdapter adapterproducto = new SimpleAdapter(RecicladoEditor.this, result.get("mylistproducto"), android.R.layout.simple_spinner_item,
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
                if(app.isOnline(RecicladoEditor.this))
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
        mid_reciclado.setTextKeepState(mylist.get(mylist.size()-1).get(reciclado.id_reciclado));
        mreciclable.setTextKeepState(mylist.get(mylist.size()-1).get(reciclado.reciclable));
        mreciclado.setTextKeepState(mylist.get(mylist.size()-1).get(reciclado.reciclado));
        mvalor_reciclaje.setTextKeepState(mylist.get(mylist.size()-1).get(reciclado.valor_reciclaje));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_reciclado = (EditText) findViewById(R.id.etid_reciclado);
        mreciclable = (EditText) findViewById(R.id.etreciclable);
        mreciclado = (EditText) findViewById(R.id.etreciclado);
        mvalor_reciclaje = (EditText) findViewById(R.id.etvalor_reciclaje);
        
        mempresa_id_empresa = (Spinner) findViewById(R.id.spempresa_id_empresa);
        mproducto_id_producto = (Spinner) findViewById(R.id.spproducto_id_producto);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_reciclado.setText("");
        mreciclable.setText("");
        mreciclado.setText("");
        mvalor_reciclaje.setText("");
        
    }

    private void addReciclado() {
        Log.e("add", "add Reciclado");
        map.put(reciclado.id_reciclado, mid_reciclado.getText().toString());
        map.put(reciclado.reciclable, mreciclable.getText().toString());
        map.put(reciclado.reciclado, mreciclado.getText().toString());
        map.put(reciclado.valor_reciclaje, mvalor_reciclaje.getText().toString());
        
        
        map.put(reciclado.empresa_id_empresa, arraylist.get("mylistempresa").get(mempresa_id_empresa.getSelectedItemPosition()).get("_id"));

        map.put(reciclado.producto_id_producto, arraylist.get("mylistproducto").get(mproducto_id_producto.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delReciclado() {
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
            delReciclado();
            finish();
            break;
        case EDIT_ID:
            addReciclado();
            break;
        case ADD_ID:
            addReciclado();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}