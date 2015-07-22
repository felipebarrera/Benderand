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

public class Cliente_empresaEditor extends Activity {
    private static final String TAG = "EDITOR cliente_empresa";
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
    private EditText mid_cliente_empresa;
    private EditText mrut_cliente_empresa;
    private EditText mdigito_verificador;
    private EditText mnombre;
    private EditText memail_cliente_empresa;
    
    private Spinner mactividad_id_actividad;
    private Spinner mempresa_id_empresa;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorcliente_empresa);
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
            dialog = new ProgressDialog(Cliente_empresaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc cliente_empresa ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc cliente_empresa ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc cliente_empresa", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc cliente_empresa");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addcliente_empresa  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idcliente_empresa = String.valueOf(Integer.valueOf(getContentResolver().insert(cliente_empresa.CONTENT_URI, PostData.getinstance().postdataready(map, "cliente_empresa")).getLastPathSegment()));
                    login = Integer.valueOf(idcliente_empresa) > 0;
                    Log.e("addcliente_empresa  ", " do in background " + idcliente_empresa);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "cliente_empresa").toString());
                        String idcliente_empresa = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(cliente_empresa.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "cliente_empresa"),null,null)));
                        login = Integer.valueOf(idcliente_empresa) > 0;
                        Log.e("updatecliente_empresa ", " do in background " + idcliente_empresa);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(Cliente_empresaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savecliente_empresa";
                    }
                    else
                    {
                        action = "updatecliente_empresa";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "cliente_empresa");
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
            dialog = new ProgressDialog(Cliente_empresaEditor.this);
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
                Log.e("cliente_empresaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra cliente_empresa, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahCliente_empresa(getContentResolver().query(
                        ContentUris.withAppendedId(cliente_empresa.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pccliente_empresa, null, null, cliente_empresa.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(Cliente_empresaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "cliente_empresa");
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
            dialog = new ProgressDialog(Cliente_empresaEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapteractividad = new SimpleAdapter(Cliente_empresaEditor.this, result.get("mylistactividad"), android.R.layout.simple_spinner_item,
                        new String[] {actividad.nombre_actividad}, new int[] {android.R.id.text1 });
                adapteractividad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mactividad_id_actividad.setAdapter(adapteractividad);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(actividad.id_actividad))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mactividad_id_actividad.setSelection(compareValue);
                    }
                }
SimpleAdapter adapterempresa = new SimpleAdapter(Cliente_empresaEditor.this, result.get("mylistempresa"), android.R.layout.simple_spinner_item,
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
                arraylist.put("mylistactividad" , CursortoArrayhash.getinstance().ahActividad(getContentResolver().query(
                        actividad.CONTENT_URI, ProjectionCreater.pcactividad, null , null, actividad.DEFAULT_ORDEN)));
arraylist.put("mylistempresa" , CursortoArrayhash.getinstance().ahEmpresa(getContentResolver().query(
                        empresa.CONTENT_URI, ProjectionCreater.pcempresa, null , null, empresa.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(Cliente_empresaEditor.this))
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
        mid_cliente_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(cliente_empresa.id_cliente_empresa));
        mrut_cliente_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(cliente_empresa.rut_cliente_empresa));
        mdigito_verificador.setTextKeepState(mylist.get(mylist.size()-1).get(cliente_empresa.digito_verificador));
        mnombre.setTextKeepState(mylist.get(mylist.size()-1).get(cliente_empresa.nombre));
        memail_cliente_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(cliente_empresa.email_cliente_empresa));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_cliente_empresa = (EditText) findViewById(R.id.etid_cliente_empresa);
        mrut_cliente_empresa = (EditText) findViewById(R.id.etrut_cliente_empresa);
        mdigito_verificador = (EditText) findViewById(R.id.etdigito_verificador);
        mnombre = (EditText) findViewById(R.id.etnombre);
        memail_cliente_empresa = (EditText) findViewById(R.id.etemail_cliente_empresa);
        
        mactividad_id_actividad = (Spinner) findViewById(R.id.spactividad_id_actividad);
        mempresa_id_empresa = (Spinner) findViewById(R.id.spempresa_id_empresa);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_cliente_empresa.setText("");
        mrut_cliente_empresa.setText("");
        mdigito_verificador.setText("");
        mnombre.setText("");
        memail_cliente_empresa.setText("");
        
    }

    private void addCliente_empresa() {
        Log.e("add", "add Cliente_empresa");
        map.put(cliente_empresa.id_cliente_empresa, mid_cliente_empresa.getText().toString());
        map.put(cliente_empresa.rut_cliente_empresa, mrut_cliente_empresa.getText().toString());
        map.put(cliente_empresa.digito_verificador, mdigito_verificador.getText().toString());
        map.put(cliente_empresa.nombre, mnombre.getText().toString());
        map.put(cliente_empresa.email_cliente_empresa, memail_cliente_empresa.getText().toString());
        
        
        map.put(cliente_empresa.actividad_id_actividad, arraylist.get("mylistactividad").get(mactividad_id_actividad.getSelectedItemPosition()).get("_id"));

        map.put(cliente_empresa.empresa_id_empresa, arraylist.get("mylistempresa").get(mempresa_id_empresa.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delCliente_empresa() {
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
            delCliente_empresa();
            finish();
            break;
        case EDIT_ID:
            addCliente_empresa();
            break;
        case ADD_ID:
            addCliente_empresa();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}