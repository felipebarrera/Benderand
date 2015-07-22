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

public class ClienteEditor extends Activity {
    private static final String TAG = "EDITOR cliente";
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
    private EditText mid_cliente;
    private EditText mrut_cliente;
    private EditText mdigito_verificador;
    private EditText mnombre_cliente;
    private EditText msegundo_nombre_cliente;
    private EditText mapellido_cliente;
    private EditText msegundo_apellido_cliente;
    private EditText mactividad;
    private EditText marea_actividad;
    private EditText mdia_fecha_nacimiento;
    private EditText mmes_fecha_nacimiento;
    private EditText mano_fecha_nacimiento;
    private EditText medad;
    private EditText memail;
    private EditText mcelular;
    private EditText mtelefono;
    
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorcliente);
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
            dialog = new ProgressDialog(ClienteEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc cliente ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc cliente ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc cliente", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc cliente");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addcliente  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idcliente = String.valueOf(Integer.valueOf(getContentResolver().insert(cliente.CONTENT_URI, PostData.getinstance().postdataready(map, "cliente")).getLastPathSegment()));
                    login = Integer.valueOf(idcliente) > 0;
                    Log.e("addcliente  ", " do in background " + idcliente);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "cliente").toString());
                        String idcliente = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(cliente.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "cliente"),null,null)));
                        login = Integer.valueOf(idcliente) > 0;
                        Log.e("updatecliente ", " do in background " + idcliente);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(ClienteEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savecliente";
                    }
                    else
                    {
                        action = "updatecliente";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "cliente");
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
            dialog = new ProgressDialog(ClienteEditor.this);
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
                Log.e("clienteeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra cliente, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahCliente(getContentResolver().query(
                        ContentUris.withAppendedId(cliente.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pccliente, null, null, cliente.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(ClienteEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "cliente");
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
            dialog = new ProgressDialog(ClienteEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                
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
                
            }
            else
            {
                if(app.isOnline(ClienteEditor.this))
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
        mid_cliente.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.id_cliente));
        mrut_cliente.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.rut_cliente));
        mdigito_verificador.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.digito_verificador));
        mnombre_cliente.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.nombre_cliente));
        msegundo_nombre_cliente.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.segundo_nombre_cliente));
        mapellido_cliente.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.apellido_cliente));
        msegundo_apellido_cliente.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.segundo_apellido_cliente));
        mactividad.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.actividad));
        marea_actividad.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.area_actividad));
        mdia_fecha_nacimiento.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.dia_fecha_nacimiento));
        mmes_fecha_nacimiento.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.mes_fecha_nacimiento));
        mano_fecha_nacimiento.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.ano_fecha_nacimiento));
        medad.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.edad));
        memail.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.email));
        mcelular.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.celular));
        mtelefono.setTextKeepState(mylist.get(mylist.size()-1).get(cliente.telefono));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_cliente = (EditText) findViewById(R.id.etid_cliente);
        mrut_cliente = (EditText) findViewById(R.id.etrut_cliente);
        mdigito_verificador = (EditText) findViewById(R.id.etdigito_verificador);
        mnombre_cliente = (EditText) findViewById(R.id.etnombre_cliente);
        msegundo_nombre_cliente = (EditText) findViewById(R.id.etsegundo_nombre_cliente);
        mapellido_cliente = (EditText) findViewById(R.id.etapellido_cliente);
        msegundo_apellido_cliente = (EditText) findViewById(R.id.etsegundo_apellido_cliente);
        mactividad = (EditText) findViewById(R.id.etactividad);
        marea_actividad = (EditText) findViewById(R.id.etarea_actividad);
        mdia_fecha_nacimiento = (EditText) findViewById(R.id.etdia_fecha_nacimiento);
        mmes_fecha_nacimiento = (EditText) findViewById(R.id.etmes_fecha_nacimiento);
        mano_fecha_nacimiento = (EditText) findViewById(R.id.etano_fecha_nacimiento);
        medad = (EditText) findViewById(R.id.etedad);
        memail = (EditText) findViewById(R.id.etemail);
        mcelular = (EditText) findViewById(R.id.etcelular);
        mtelefono = (EditText) findViewById(R.id.ettelefono);
        
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_cliente.setText("");
        mrut_cliente.setText("");
        mdigito_verificador.setText("");
        mnombre_cliente.setText("");
        msegundo_nombre_cliente.setText("");
        mapellido_cliente.setText("");
        msegundo_apellido_cliente.setText("");
        mactividad.setText("");
        marea_actividad.setText("");
        mdia_fecha_nacimiento.setText("");
        mmes_fecha_nacimiento.setText("");
        mano_fecha_nacimiento.setText("");
        medad.setText("");
        memail.setText("");
        mcelular.setText("");
        mtelefono.setText("");
        
    }

    private void addCliente() {
        Log.e("add", "add Cliente");
        map.put(cliente.id_cliente, mid_cliente.getText().toString());
        map.put(cliente.rut_cliente, mrut_cliente.getText().toString());
        map.put(cliente.digito_verificador, mdigito_verificador.getText().toString());
        map.put(cliente.nombre_cliente, mnombre_cliente.getText().toString());
        map.put(cliente.segundo_nombre_cliente, msegundo_nombre_cliente.getText().toString());
        map.put(cliente.apellido_cliente, mapellido_cliente.getText().toString());
        map.put(cliente.segundo_apellido_cliente, msegundo_apellido_cliente.getText().toString());
        map.put(cliente.actividad, mactividad.getText().toString());
        map.put(cliente.area_actividad, marea_actividad.getText().toString());
        map.put(cliente.dia_fecha_nacimiento, mdia_fecha_nacimiento.getText().toString());
        map.put(cliente.mes_fecha_nacimiento, mmes_fecha_nacimiento.getText().toString());
        map.put(cliente.ano_fecha_nacimiento, mano_fecha_nacimiento.getText().toString());
        map.put(cliente.edad, medad.getText().toString());
        map.put(cliente.email, memail.getText().toString());
        map.put(cliente.celular, mcelular.getText().toString());
        map.put(cliente.telefono, mtelefono.getText().toString());
        
        

        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delCliente() {
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
            delCliente();
            finish();
            break;
        case EDIT_ID:
            addCliente();
            break;
        case ADD_ID:
            addCliente();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}