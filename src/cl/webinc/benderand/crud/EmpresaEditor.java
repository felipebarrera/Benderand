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

public class EmpresaEditor extends Activity {
    private static final String TAG = "EDITOR empresa";
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
    private EditText mid_empresa;
    private EditText mrut_empresa;
    private EditText mdigito_verificador_empresa;
    private EditText mnombre_empresa;
    private EditText mnombre_contacto_empresa;
    private EditText mcargo_contacto_empresa;
    private EditText memail_empresa;
    private EditText malcance_empresa;
    private EditText mtelefono_empresa;
    
    private Spinner mactividad_id_actividad;
    private Spinner mtipo_empresa_id_tipo_empresa;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorempresa);
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
            dialog = new ProgressDialog(EmpresaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc empresa ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc empresa ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc empresa", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc empresa");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addempresa  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idempresa = String.valueOf(Integer.valueOf(getContentResolver().insert(empresa.CONTENT_URI, PostData.getinstance().postdataready(map, "empresa")).getLastPathSegment()));
                    login = Integer.valueOf(idempresa) > 0;
                    Log.e("addempresa  ", " do in background " + idempresa);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "empresa").toString());
                        String idempresa = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(empresa.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "empresa"),null,null)));
                        login = Integer.valueOf(idempresa) > 0;
                        Log.e("updateempresa ", " do in background " + idempresa);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(EmpresaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "saveempresa";
                    }
                    else
                    {
                        action = "updateempresa";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "empresa");
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
            dialog = new ProgressDialog(EmpresaEditor.this);
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
                Log.e("empresaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra empresa, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahEmpresa(getContentResolver().query(
                        ContentUris.withAppendedId(empresa.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcempresa, null, null, empresa.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(EmpresaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "empresa");
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
            dialog = new ProgressDialog(EmpresaEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapteractividad = new SimpleAdapter(EmpresaEditor.this, result.get("mylistactividad"), android.R.layout.simple_spinner_item,
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
SimpleAdapter adaptertipo_empresa = new SimpleAdapter(EmpresaEditor.this, result.get("mylisttipo_empresa"), android.R.layout.simple_spinner_item,
                        new String[] {tipo_empresa.nombre_tipo_empresa}, new int[] {android.R.id.text1 });
                adaptertipo_empresa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mtipo_empresa_id_tipo_empresa.setAdapter(adaptertipo_empresa);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(tipo_empresa.id_tipo_empresa))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mtipo_empresa_id_tipo_empresa.setSelection(compareValue);
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
arraylist.put("mylisttipo_empresa" , CursortoArrayhash.getinstance().ahTipo_empresa(getContentResolver().query(
                        tipo_empresa.CONTENT_URI, ProjectionCreater.pctipo_empresa, null , null, tipo_empresa.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(EmpresaEditor.this))
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
        mid_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.id_empresa));
        mrut_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.rut_empresa));
        mdigito_verificador_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.digito_verificador_empresa));
        mnombre_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.nombre_empresa));
        mnombre_contacto_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.nombre_contacto_empresa));
        mcargo_contacto_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.cargo_contacto_empresa));
        memail_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.email_empresa));
        malcance_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.alcance_empresa));
        mtelefono_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(empresa.telefono_empresa));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_empresa = (EditText) findViewById(R.id.etid_empresa);
        mrut_empresa = (EditText) findViewById(R.id.etrut_empresa);
        mdigito_verificador_empresa = (EditText) findViewById(R.id.etdigito_verificador_empresa);
        mnombre_empresa = (EditText) findViewById(R.id.etnombre_empresa);
        mnombre_contacto_empresa = (EditText) findViewById(R.id.etnombre_contacto_empresa);
        mcargo_contacto_empresa = (EditText) findViewById(R.id.etcargo_contacto_empresa);
        memail_empresa = (EditText) findViewById(R.id.etemail_empresa);
        malcance_empresa = (EditText) findViewById(R.id.etalcance_empresa);
        mtelefono_empresa = (EditText) findViewById(R.id.ettelefono_empresa);
        
        mactividad_id_actividad = (Spinner) findViewById(R.id.spactividad_id_actividad);
        mtipo_empresa_id_tipo_empresa = (Spinner) findViewById(R.id.sptipo_empresa_id_tipo_empresa);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_empresa.setText("");
        mrut_empresa.setText("");
        mdigito_verificador_empresa.setText("");
        mnombre_empresa.setText("");
        mnombre_contacto_empresa.setText("");
        mcargo_contacto_empresa.setText("");
        memail_empresa.setText("");
        malcance_empresa.setText("");
        mtelefono_empresa.setText("");
        
    }

    private void addEmpresa() {
        Log.e("add", "add Empresa");
        map.put(empresa.id_empresa, mid_empresa.getText().toString());
        map.put(empresa.rut_empresa, mrut_empresa.getText().toString());
        map.put(empresa.digito_verificador_empresa, mdigito_verificador_empresa.getText().toString());
        map.put(empresa.nombre_empresa, mnombre_empresa.getText().toString());
        map.put(empresa.nombre_contacto_empresa, mnombre_contacto_empresa.getText().toString());
        map.put(empresa.cargo_contacto_empresa, mcargo_contacto_empresa.getText().toString());
        map.put(empresa.email_empresa, memail_empresa.getText().toString());
        map.put(empresa.alcance_empresa, malcance_empresa.getText().toString());
        map.put(empresa.telefono_empresa, mtelefono_empresa.getText().toString());
        
        
        map.put(empresa.actividad_id_actividad, arraylist.get("mylistactividad").get(mactividad_id_actividad.getSelectedItemPosition()).get("_id"));

        map.put(empresa.tipo_empresa_id_tipo_empresa, arraylist.get("mylisttipo_empresa").get(mtipo_empresa_id_tipo_empresa.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delEmpresa() {
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
            delEmpresa();
            finish();
            break;
        case EDIT_ID:
            addEmpresa();
            break;
        case ADD_ID:
            addEmpresa();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}