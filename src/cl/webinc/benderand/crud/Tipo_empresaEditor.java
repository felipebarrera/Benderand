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

public class Tipo_empresaEditor extends Activity {
    private static final String TAG = "EDITOR tipo_empresa";
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
    private EditText mid_tipo_empresa;
    private EditText mnombre_tipo_empresa;
    
    private Spinner mcategoria_empresa_id_categoria_empresa;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editortipo_empresa);
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
            dialog = new ProgressDialog(Tipo_empresaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc tipo_empresa ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc tipo_empresa ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc tipo_empresa", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc tipo_empresa");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addtipo_empresa  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idtipo_empresa = String.valueOf(Integer.valueOf(getContentResolver().insert(tipo_empresa.CONTENT_URI, PostData.getinstance().postdataready(map, "tipo_empresa")).getLastPathSegment()));
                    login = Integer.valueOf(idtipo_empresa) > 0;
                    Log.e("addtipo_empresa  ", " do in background " + idtipo_empresa);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "tipo_empresa").toString());
                        String idtipo_empresa = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(tipo_empresa.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "tipo_empresa"),null,null)));
                        login = Integer.valueOf(idtipo_empresa) > 0;
                        Log.e("updatetipo_empresa ", " do in background " + idtipo_empresa);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(Tipo_empresaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savetipo_empresa";
                    }
                    else
                    {
                        action = "updatetipo_empresa";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "tipo_empresa");
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
            dialog = new ProgressDialog(Tipo_empresaEditor.this);
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
                Log.e("tipo_empresaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra tipo_empresa, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahTipo_empresa(getContentResolver().query(
                        ContentUris.withAppendedId(tipo_empresa.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pctipo_empresa, null, null, tipo_empresa.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(Tipo_empresaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "tipo_empresa");
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
            dialog = new ProgressDialog(Tipo_empresaEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adaptercategoria_empresa = new SimpleAdapter(Tipo_empresaEditor.this, result.get("mylistcategoria_empresa"), android.R.layout.simple_spinner_item,
                        new String[] {categoria_empresa.nombre_categoria_empresa}, new int[] {android.R.id.text1 });
                adaptercategoria_empresa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mcategoria_empresa_id_categoria_empresa.setAdapter(adaptercategoria_empresa);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(categoria_empresa.id_categoria_empresa))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mcategoria_empresa_id_categoria_empresa.setSelection(compareValue);
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
                arraylist.put("mylistcategoria_empresa" , CursortoArrayhash.getinstance().ahCategoria_empresa(getContentResolver().query(
                        categoria_empresa.CONTENT_URI, ProjectionCreater.pccategoria_empresa, null , null, categoria_empresa.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(Tipo_empresaEditor.this))
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
        mid_tipo_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(tipo_empresa.id_tipo_empresa));
        mnombre_tipo_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(tipo_empresa.nombre_tipo_empresa));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_tipo_empresa = (EditText) findViewById(R.id.etid_tipo_empresa);
        mnombre_tipo_empresa = (EditText) findViewById(R.id.etnombre_tipo_empresa);
        
        mcategoria_empresa_id_categoria_empresa = (Spinner) findViewById(R.id.spcategoria_empresa_id_categoria_empresa);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_tipo_empresa.setText("");
        mnombre_tipo_empresa.setText("");
        
    }

    private void addTipo_empresa() {
        Log.e("add", "add Tipo_empresa");
        map.put(tipo_empresa.id_tipo_empresa, mid_tipo_empresa.getText().toString());
        map.put(tipo_empresa.nombre_tipo_empresa, mnombre_tipo_empresa.getText().toString());
        
        
        map.put(tipo_empresa.categoria_empresa_id_categoria_empresa, arraylist.get("mylistcategoria_empresa").get(mcategoria_empresa_id_categoria_empresa.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delTipo_empresa() {
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
            delTipo_empresa();
            finish();
            break;
        case EDIT_ID:
            addTipo_empresa();
            break;
        case ADD_ID:
            addTipo_empresa();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}