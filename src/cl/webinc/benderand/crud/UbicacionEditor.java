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

public class UbicacionEditor extends Activity {
    private static final String TAG = "EDITOR ubicacion";
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
    private EditText mid_ubicacion;
    private EditText mnumero_ubicacion;
    private EditText mnumero_interior;
    private EditText mtelefono_ubicacion;
    private EditText mdefault_ubicacion;
    
    private Spinner mcalle_id_calle;
    private Spinner mempresa_id_empresa;
    private Spinner musuario_id_usuario;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorubicacion);
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
            dialog = new ProgressDialog(UbicacionEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc ubicacion ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc ubicacion ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc ubicacion", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc ubicacion");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addubicacion  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idubicacion = String.valueOf(Integer.valueOf(getContentResolver().insert(ubicacion.CONTENT_URI, PostData.getinstance().postdataready(map, "ubicacion")).getLastPathSegment()));
                    login = Integer.valueOf(idubicacion) > 0;
                    Log.e("addubicacion  ", " do in background " + idubicacion);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "ubicacion").toString());
                        String idubicacion = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(ubicacion.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "ubicacion"),null,null)));
                        login = Integer.valueOf(idubicacion) > 0;
                        Log.e("updateubicacion ", " do in background " + idubicacion);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(UbicacionEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "saveubicacion";
                    }
                    else
                    {
                        action = "updateubicacion";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "ubicacion");
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
            dialog = new ProgressDialog(UbicacionEditor.this);
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
                Log.e("ubicacioneditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra ubicacion, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahUbicacion(getContentResolver().query(
                        ContentUris.withAppendedId(ubicacion.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcubicacion, null, null, ubicacion.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(UbicacionEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "ubicacion");
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
            dialog = new ProgressDialog(UbicacionEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adaptercalle = new SimpleAdapter(UbicacionEditor.this, result.get("mylistcalle"), android.R.layout.simple_spinner_item,
                        new String[] {calle.nombre_calle}, new int[] {android.R.id.text1 });
                adaptercalle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mcalle_id_calle.setAdapter(adaptercalle);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(calle.id_calle))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mcalle_id_calle.setSelection(compareValue);
                    }
                }
SimpleAdapter adapterempresa = new SimpleAdapter(UbicacionEditor.this, result.get("mylistempresa"), android.R.layout.simple_spinner_item,
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
SimpleAdapter adapterusuario = new SimpleAdapter(UbicacionEditor.this, result.get("mylistusuario"), android.R.layout.simple_spinner_item,
                        new String[] {usuario.nombre_usuario}, new int[] {android.R.id.text1 });
                adapterusuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                musuario_id_usuario.setAdapter(adapterusuario);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(usuario.id_usuario))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        musuario_id_usuario.setSelection(compareValue);
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
                arraylist.put("mylistcalle" , CursortoArrayhash.getinstance().ahCalle(getContentResolver().query(
                        calle.CONTENT_URI, ProjectionCreater.pccalle, null , null, calle.DEFAULT_ORDEN)));
arraylist.put("mylistempresa" , CursortoArrayhash.getinstance().ahEmpresa(getContentResolver().query(
                        empresa.CONTENT_URI, ProjectionCreater.pcempresa, null , null, empresa.DEFAULT_ORDEN)));
arraylist.put("mylistusuario" , CursortoArrayhash.getinstance().ahUsuario(getContentResolver().query(
                        usuario.CONTENT_URI, ProjectionCreater.pcusuario, null , null, usuario.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(UbicacionEditor.this))
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
        mid_ubicacion.setTextKeepState(mylist.get(mylist.size()-1).get(ubicacion.id_ubicacion));
        mnumero_ubicacion.setTextKeepState(mylist.get(mylist.size()-1).get(ubicacion.numero_ubicacion));
        mnumero_interior.setTextKeepState(mylist.get(mylist.size()-1).get(ubicacion.numero_interior));
        mtelefono_ubicacion.setTextKeepState(mylist.get(mylist.size()-1).get(ubicacion.telefono_ubicacion));
        mdefault_ubicacion.setTextKeepState(mylist.get(mylist.size()-1).get(ubicacion.default_ubicacion));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_ubicacion = (EditText) findViewById(R.id.etid_ubicacion);
        mnumero_ubicacion = (EditText) findViewById(R.id.etnumero_ubicacion);
        mnumero_interior = (EditText) findViewById(R.id.etnumero_interior);
        mtelefono_ubicacion = (EditText) findViewById(R.id.ettelefono_ubicacion);
        mdefault_ubicacion = (EditText) findViewById(R.id.etdefault_ubicacion);
        
        mcalle_id_calle = (Spinner) findViewById(R.id.spcalle_id_calle);
        mempresa_id_empresa = (Spinner) findViewById(R.id.spempresa_id_empresa);
        musuario_id_usuario = (Spinner) findViewById(R.id.spusuario_id_usuario);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_ubicacion.setText("");
        mnumero_ubicacion.setText("");
        mnumero_interior.setText("");
        mtelefono_ubicacion.setText("");
        mdefault_ubicacion.setText("");
        
    }

    private void addUbicacion() {
        Log.e("add", "add Ubicacion");
        map.put(ubicacion.id_ubicacion, mid_ubicacion.getText().toString());
        map.put(ubicacion.numero_ubicacion, mnumero_ubicacion.getText().toString());
        map.put(ubicacion.numero_interior, mnumero_interior.getText().toString());
        map.put(ubicacion.telefono_ubicacion, mtelefono_ubicacion.getText().toString());
        map.put(ubicacion.default_ubicacion, mdefault_ubicacion.getText().toString());
        
        
        map.put(ubicacion.calle_id_calle, arraylist.get("mylistcalle").get(mcalle_id_calle.getSelectedItemPosition()).get("_id"));

        map.put(ubicacion.empresa_id_empresa, arraylist.get("mylistempresa").get(mempresa_id_empresa.getSelectedItemPosition()).get("_id"));

        map.put(ubicacion.usuario_id_usuario, arraylist.get("mylistusuario").get(musuario_id_usuario.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delUbicacion() {
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
            delUbicacion();
            finish();
            break;
        case EDIT_ID:
            addUbicacion();
            break;
        case ADD_ID:
            addUbicacion();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}