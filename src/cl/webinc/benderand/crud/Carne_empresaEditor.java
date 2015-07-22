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

public class Carne_empresaEditor extends Activity {
    private static final String TAG = "EDITOR carne_empresa";
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
    private EditText mid_carne_empresa;
    private EditText mnombre_usuario;
    private EditText mclave_usuario;
    
    private Spinner mempresa_id_empresa;
    private Spinner mpersona_id_persona;
    private Spinner mtipo_usuario_id_tipo_usuario;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorcarne_empresa);
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
            dialog = new ProgressDialog(Carne_empresaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc carne_empresa ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc carne_empresa ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc carne_empresa", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc carne_empresa");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addcarne_empresa  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idcarne_empresa = String.valueOf(Integer.valueOf(getContentResolver().insert(carne_empresa.CONTENT_URI, PostData.getinstance().postdataready(map, "carne_empresa")).getLastPathSegment()));
                    login = Integer.valueOf(idcarne_empresa) > 0;
                    Log.e("addcarne_empresa  ", " do in background " + idcarne_empresa);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "carne_empresa").toString());
                        String idcarne_empresa = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(carne_empresa.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "carne_empresa"),null,null)));
                        login = Integer.valueOf(idcarne_empresa) > 0;
                        Log.e("updatecarne_empresa ", " do in background " + idcarne_empresa);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(Carne_empresaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savecarne_empresa";
                    }
                    else
                    {
                        action = "updatecarne_empresa";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "carne_empresa");
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
            dialog = new ProgressDialog(Carne_empresaEditor.this);
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
                Log.e("carne_empresaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra carne_empresa, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahCarne_empresa(getContentResolver().query(
                        ContentUris.withAppendedId(carne_empresa.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pccarne_empresa, null, null, carne_empresa.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(Carne_empresaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "carne_empresa");
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
            dialog = new ProgressDialog(Carne_empresaEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterempresa = new SimpleAdapter(Carne_empresaEditor.this, result.get("mylistempresa"), android.R.layout.simple_spinner_item,
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
SimpleAdapter adapterpersona = new SimpleAdapter(Carne_empresaEditor.this, result.get("mylistpersona"), android.R.layout.simple_spinner_item,
                        new String[] {persona.nombre_persona}, new int[] {android.R.id.text1 });
                adapterpersona.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mpersona_id_persona.setAdapter(adapterpersona);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(persona.id_persona))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mpersona_id_persona.setSelection(compareValue);
                    }
                }
SimpleAdapter adaptertipo_usuario = new SimpleAdapter(Carne_empresaEditor.this, result.get("mylisttipo_usuario"), android.R.layout.simple_spinner_item,
                        new String[] {tipo_usuario.nombre_tipo_usuario}, new int[] {android.R.id.text1 });
                adaptertipo_usuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mtipo_usuario_id_tipo_usuario.setAdapter(adaptertipo_usuario);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(tipo_usuario.id_tipo_usuario))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mtipo_usuario_id_tipo_usuario.setSelection(compareValue);
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
arraylist.put("mylistpersona" , CursortoArrayhash.getinstance().ahPersona(getContentResolver().query(
                        persona.CONTENT_URI, ProjectionCreater.pcpersona, null , null, persona.DEFAULT_ORDEN)));
arraylist.put("mylisttipo_usuario" , CursortoArrayhash.getinstance().ahTipo_usuario(getContentResolver().query(
                        tipo_usuario.CONTENT_URI, ProjectionCreater.pctipo_usuario, null , null, tipo_usuario.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(Carne_empresaEditor.this))
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
        mid_carne_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(carne_empresa.id_carne_empresa));
        mnombre_usuario.setTextKeepState(mylist.get(mylist.size()-1).get(carne_empresa.nombre_usuario));
        mclave_usuario.setTextKeepState(mylist.get(mylist.size()-1).get(carne_empresa.clave_usuario));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_carne_empresa = (EditText) findViewById(R.id.etid_carne_empresa);
        mnombre_usuario = (EditText) findViewById(R.id.etnombre_usuario);
        mclave_usuario = (EditText) findViewById(R.id.etclave_usuario);
        
        mempresa_id_empresa = (Spinner) findViewById(R.id.spempresa_id_empresa);
        mpersona_id_persona = (Spinner) findViewById(R.id.sppersona_id_persona);
        mtipo_usuario_id_tipo_usuario = (Spinner) findViewById(R.id.sptipo_usuario_id_tipo_usuario);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_carne_empresa.setText("");
        mnombre_usuario.setText("");
        mclave_usuario.setText("");
        
    }

    private void addCarne_empresa() {
        Log.e("add", "add Carne_empresa");
        map.put(carne_empresa.id_carne_empresa, mid_carne_empresa.getText().toString());
        map.put(carne_empresa.nombre_usuario, mnombre_usuario.getText().toString());
        map.put(carne_empresa.clave_usuario, mclave_usuario.getText().toString());
        
        
        map.put(carne_empresa.empresa_id_empresa, arraylist.get("mylistempresa").get(mempresa_id_empresa.getSelectedItemPosition()).get("_id"));

        map.put(carne_empresa.persona_id_persona, arraylist.get("mylistpersona").get(mpersona_id_persona.getSelectedItemPosition()).get("_id"));

        map.put(carne_empresa.tipo_usuario_id_tipo_usuario, arraylist.get("mylisttipo_usuario").get(mtipo_usuario_id_tipo_usuario.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delCarne_empresa() {
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
            delCarne_empresa();
            finish();
            break;
        case EDIT_ID:
            addCarne_empresa();
            break;
        case ADD_ID:
            addCarne_empresa();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}