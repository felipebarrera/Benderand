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

public class ActividadEditor extends Activity {
    private static final String TAG = "EDITOR actividad";
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
    private EditText mid_actividad;
    private EditText mnombre_actividad;
    private EditText mcodigo_actividad;
    private EditText mcategoria_actividad;
    private EditText mafectoiva_actividad;
    private EditText mdisponible_internet_actividad;
    
    private Spinner msubrubro_id_subrubro;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editoractividad);
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
            dialog = new ProgressDialog(ActividadEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc actividad ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc actividad ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc actividad", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc actividad");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addactividad  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idactividad = String.valueOf(Integer.valueOf(getContentResolver().insert(actividad.CONTENT_URI, PostData.getinstance().postdataready(map, "actividad")).getLastPathSegment()));
                    login = Integer.valueOf(idactividad) > 0;
                    Log.e("addactividad  ", " do in background " + idactividad);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "actividad").toString());
                        String idactividad = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(actividad.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "actividad"),null,null)));
                        login = Integer.valueOf(idactividad) > 0;
                        Log.e("updateactividad ", " do in background " + idactividad);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(ActividadEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "saveactividad";
                    }
                    else
                    {
                        action = "updateactividad";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "actividad");
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
            dialog = new ProgressDialog(ActividadEditor.this);
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
                Log.e("actividadeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra actividad, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahActividad(getContentResolver().query(
                        ContentUris.withAppendedId(actividad.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcactividad, null, null, actividad.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(ActividadEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "actividad");
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
            dialog = new ProgressDialog(ActividadEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adaptersubrubro = new SimpleAdapter(ActividadEditor.this, result.get("mylistsubrubro"), android.R.layout.simple_spinner_item,
                        new String[] {subrubro.nombre_subrubro}, new int[] {android.R.id.text1 });
                adaptersubrubro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                msubrubro_id_subrubro.setAdapter(adaptersubrubro);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(subrubro.id_subrubro))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        msubrubro_id_subrubro.setSelection(compareValue);
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
                arraylist.put("mylistsubrubro" , CursortoArrayhash.getinstance().ahSubrubro(getContentResolver().query(
                        subrubro.CONTENT_URI, ProjectionCreater.pcsubrubro, null , null, subrubro.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(ActividadEditor.this))
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
        mid_actividad.setTextKeepState(mylist.get(mylist.size()-1).get(actividad.id_actividad));
        mnombre_actividad.setTextKeepState(mylist.get(mylist.size()-1).get(actividad.nombre_actividad));
        mcodigo_actividad.setTextKeepState(mylist.get(mylist.size()-1).get(actividad.codigo_actividad));
        mcategoria_actividad.setTextKeepState(mylist.get(mylist.size()-1).get(actividad.categoria_actividad));
        mafectoiva_actividad.setTextKeepState(mylist.get(mylist.size()-1).get(actividad.afectoiva_actividad));
        mdisponible_internet_actividad.setTextKeepState(mylist.get(mylist.size()-1).get(actividad.disponible_internet_actividad));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_actividad = (EditText) findViewById(R.id.etid_actividad);
        mnombre_actividad = (EditText) findViewById(R.id.etnombre_actividad);
        mcodigo_actividad = (EditText) findViewById(R.id.etcodigo_actividad);
        mcategoria_actividad = (EditText) findViewById(R.id.etcategoria_actividad);
        mafectoiva_actividad = (EditText) findViewById(R.id.etafectoiva_actividad);
        mdisponible_internet_actividad = (EditText) findViewById(R.id.etdisponible_internet_actividad);
        
        msubrubro_id_subrubro = (Spinner) findViewById(R.id.spsubrubro_id_subrubro);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_actividad.setText("");
        mnombre_actividad.setText("");
        mcodigo_actividad.setText("");
        mcategoria_actividad.setText("");
        mafectoiva_actividad.setText("");
        mdisponible_internet_actividad.setText("");
        
    }

    private void addActividad() {
        Log.e("add", "add Actividad");
        map.put(actividad.id_actividad, mid_actividad.getText().toString());
        map.put(actividad.nombre_actividad, mnombre_actividad.getText().toString());
        map.put(actividad.codigo_actividad, mcodigo_actividad.getText().toString());
        map.put(actividad.categoria_actividad, mcategoria_actividad.getText().toString());
        map.put(actividad.afectoiva_actividad, mafectoiva_actividad.getText().toString());
        map.put(actividad.disponible_internet_actividad, mdisponible_internet_actividad.getText().toString());
        
        
        map.put(actividad.subrubro_id_subrubro, arraylist.get("mylistsubrubro").get(msubrubro_id_subrubro.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delActividad() {
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
            delActividad();
            finish();
            break;
        case EDIT_ID:
            addActividad();
            break;
        case ADD_ID:
            addActividad();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}