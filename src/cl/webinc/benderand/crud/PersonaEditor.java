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

public class PersonaEditor extends Activity {
    private static final String TAG = "EDITOR persona";
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
    private EditText mid_persona;
    private EditText mrut_persona;
    private EditText mdigito_verificador;
    private EditText mnombre_persona;
    private EditText msegundo_nombre_persona;
    private EditText mapellido_persona;
    private EditText msegundo_apellido_persona;
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
        
        setContentView(R.layout.editorpersona);
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
            dialog = new ProgressDialog(PersonaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc persona ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc persona ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc persona", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc persona");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addpersona  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idpersona = String.valueOf(Integer.valueOf(getContentResolver().insert(persona.CONTENT_URI, PostData.getinstance().postdataready(map, "persona")).getLastPathSegment()));
                    login = Integer.valueOf(idpersona) > 0;
                    Log.e("addpersona  ", " do in background " + idpersona);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "persona").toString());
                        String idpersona = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(persona.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "persona"),null,null)));
                        login = Integer.valueOf(idpersona) > 0;
                        Log.e("updatepersona ", " do in background " + idpersona);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(PersonaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savepersona";
                    }
                    else
                    {
                        action = "updatepersona";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "persona");
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
            dialog = new ProgressDialog(PersonaEditor.this);
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
                Log.e("personaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra persona, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahPersona(getContentResolver().query(
                        ContentUris.withAppendedId(persona.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcpersona, null, null, persona.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(PersonaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "persona");
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
            dialog = new ProgressDialog(PersonaEditor.this);
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
                if(app.isOnline(PersonaEditor.this))
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
        mid_persona.setTextKeepState(mylist.get(mylist.size()-1).get(persona.id_persona));
        mrut_persona.setTextKeepState(mylist.get(mylist.size()-1).get(persona.rut_persona));
        mdigito_verificador.setTextKeepState(mylist.get(mylist.size()-1).get(persona.digito_verificador));
        mnombre_persona.setTextKeepState(mylist.get(mylist.size()-1).get(persona.nombre_persona));
        msegundo_nombre_persona.setTextKeepState(mylist.get(mylist.size()-1).get(persona.segundo_nombre_persona));
        mapellido_persona.setTextKeepState(mylist.get(mylist.size()-1).get(persona.apellido_persona));
        msegundo_apellido_persona.setTextKeepState(mylist.get(mylist.size()-1).get(persona.segundo_apellido_persona));
        mactividad.setTextKeepState(mylist.get(mylist.size()-1).get(persona.actividad));
        marea_actividad.setTextKeepState(mylist.get(mylist.size()-1).get(persona.area_actividad));
        mdia_fecha_nacimiento.setTextKeepState(mylist.get(mylist.size()-1).get(persona.dia_fecha_nacimiento));
        mmes_fecha_nacimiento.setTextKeepState(mylist.get(mylist.size()-1).get(persona.mes_fecha_nacimiento));
        mano_fecha_nacimiento.setTextKeepState(mylist.get(mylist.size()-1).get(persona.ano_fecha_nacimiento));
        medad.setTextKeepState(mylist.get(mylist.size()-1).get(persona.edad));
        memail.setTextKeepState(mylist.get(mylist.size()-1).get(persona.email));
        mcelular.setTextKeepState(mylist.get(mylist.size()-1).get(persona.celular));
        mtelefono.setTextKeepState(mylist.get(mylist.size()-1).get(persona.telefono));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_persona = (EditText) findViewById(R.id.etid_persona);
        mrut_persona = (EditText) findViewById(R.id.etrut_persona);
        mdigito_verificador = (EditText) findViewById(R.id.etdigito_verificador);
        mnombre_persona = (EditText) findViewById(R.id.etnombre_persona);
        msegundo_nombre_persona = (EditText) findViewById(R.id.etsegundo_nombre_persona);
        mapellido_persona = (EditText) findViewById(R.id.etapellido_persona);
        msegundo_apellido_persona = (EditText) findViewById(R.id.etsegundo_apellido_persona);
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
        mid_persona.setText("");
        mrut_persona.setText("");
        mdigito_verificador.setText("");
        mnombre_persona.setText("");
        msegundo_nombre_persona.setText("");
        mapellido_persona.setText("");
        msegundo_apellido_persona.setText("");
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

    private void addPersona() {
        Log.e("add", "add Persona");
        map.put(persona.id_persona, mid_persona.getText().toString());
        map.put(persona.rut_persona, mrut_persona.getText().toString());
        map.put(persona.digito_verificador, mdigito_verificador.getText().toString());
        map.put(persona.nombre_persona, mnombre_persona.getText().toString());
        map.put(persona.segundo_nombre_persona, msegundo_nombre_persona.getText().toString());
        map.put(persona.apellido_persona, mapellido_persona.getText().toString());
        map.put(persona.segundo_apellido_persona, msegundo_apellido_persona.getText().toString());
        map.put(persona.actividad, mactividad.getText().toString());
        map.put(persona.area_actividad, marea_actividad.getText().toString());
        map.put(persona.dia_fecha_nacimiento, mdia_fecha_nacimiento.getText().toString());
        map.put(persona.mes_fecha_nacimiento, mmes_fecha_nacimiento.getText().toString());
        map.put(persona.ano_fecha_nacimiento, mano_fecha_nacimiento.getText().toString());
        map.put(persona.edad, medad.getText().toString());
        map.put(persona.email, memail.getText().toString());
        map.put(persona.celular, mcelular.getText().toString());
        map.put(persona.telefono, mtelefono.getText().toString());
        
        

        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delPersona() {
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
            delPersona();
            finish();
            break;
        case EDIT_ID:
            addPersona();
            break;
        case ADD_ID:
            addPersona();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}