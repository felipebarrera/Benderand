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

public class TallaEditor extends Activity {
    private static final String TAG = "EDITOR talla";
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
    private EditText mid_talla;
    private EditText mam_largo;
    private EditText mam_ancho;
    private EditText mam_fondo;
    private EditText meu_largo;
    private EditText meu_ancho;
    private EditText meu_fondo;
    private EditText mnum_largo;
    private EditText mnum_ancho;
    private EditText mnum_fondo;
    
    private Spinner mproducto_id_producto;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editortalla);
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
            dialog = new ProgressDialog(TallaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc talla ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc talla ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc talla", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc talla");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addtalla  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idtalla = String.valueOf(Integer.valueOf(getContentResolver().insert(talla.CONTENT_URI, PostData.getinstance().postdataready(map, "talla")).getLastPathSegment()));
                    login = Integer.valueOf(idtalla) > 0;
                    Log.e("addtalla  ", " do in background " + idtalla);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "talla").toString());
                        String idtalla = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(talla.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "talla"),null,null)));
                        login = Integer.valueOf(idtalla) > 0;
                        Log.e("updatetalla ", " do in background " + idtalla);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(TallaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savetalla";
                    }
                    else
                    {
                        action = "updatetalla";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "talla");
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
            dialog = new ProgressDialog(TallaEditor.this);
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
                Log.e("tallaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra talla, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahTalla(getContentResolver().query(
                        ContentUris.withAppendedId(talla.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pctalla, null, null, talla.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(TallaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "talla");
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
            dialog = new ProgressDialog(TallaEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterproducto = new SimpleAdapter(TallaEditor.this, result.get("mylistproducto"), android.R.layout.simple_spinner_item,
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
                arraylist.put("mylistproducto" , CursortoArrayhash.getinstance().ahProducto(getContentResolver().query(
                        producto.CONTENT_URI, ProjectionCreater.pcproducto, null , null, producto.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(TallaEditor.this))
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
        mid_talla.setTextKeepState(mylist.get(mylist.size()-1).get(talla.id_talla));
        mam_largo.setTextKeepState(mylist.get(mylist.size()-1).get(talla.am_largo));
        mam_ancho.setTextKeepState(mylist.get(mylist.size()-1).get(talla.am_ancho));
        mam_fondo.setTextKeepState(mylist.get(mylist.size()-1).get(talla.am_fondo));
        meu_largo.setTextKeepState(mylist.get(mylist.size()-1).get(talla.eu_largo));
        meu_ancho.setTextKeepState(mylist.get(mylist.size()-1).get(talla.eu_ancho));
        meu_fondo.setTextKeepState(mylist.get(mylist.size()-1).get(talla.eu_fondo));
        mnum_largo.setTextKeepState(mylist.get(mylist.size()-1).get(talla.num_largo));
        mnum_ancho.setTextKeepState(mylist.get(mylist.size()-1).get(talla.num_ancho));
        mnum_fondo.setTextKeepState(mylist.get(mylist.size()-1).get(talla.num_fondo));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_talla = (EditText) findViewById(R.id.etid_talla);
        mam_largo = (EditText) findViewById(R.id.etam_largo);
        mam_ancho = (EditText) findViewById(R.id.etam_ancho);
        mam_fondo = (EditText) findViewById(R.id.etam_fondo);
        meu_largo = (EditText) findViewById(R.id.eteu_largo);
        meu_ancho = (EditText) findViewById(R.id.eteu_ancho);
        meu_fondo = (EditText) findViewById(R.id.eteu_fondo);
        mnum_largo = (EditText) findViewById(R.id.etnum_largo);
        mnum_ancho = (EditText) findViewById(R.id.etnum_ancho);
        mnum_fondo = (EditText) findViewById(R.id.etnum_fondo);
        
        mproducto_id_producto = (Spinner) findViewById(R.id.spproducto_id_producto);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_talla.setText("");
        mam_largo.setText("");
        mam_ancho.setText("");
        mam_fondo.setText("");
        meu_largo.setText("");
        meu_ancho.setText("");
        meu_fondo.setText("");
        mnum_largo.setText("");
        mnum_ancho.setText("");
        mnum_fondo.setText("");
        
    }

    private void addTalla() {
        Log.e("add", "add Talla");
        map.put(talla.id_talla, mid_talla.getText().toString());
        map.put(talla.am_largo, mam_largo.getText().toString());
        map.put(talla.am_ancho, mam_ancho.getText().toString());
        map.put(talla.am_fondo, mam_fondo.getText().toString());
        map.put(talla.eu_largo, meu_largo.getText().toString());
        map.put(talla.eu_ancho, meu_ancho.getText().toString());
        map.put(talla.eu_fondo, meu_fondo.getText().toString());
        map.put(talla.num_largo, mnum_largo.getText().toString());
        map.put(talla.num_ancho, mnum_ancho.getText().toString());
        map.put(talla.num_fondo, mnum_fondo.getText().toString());
        
        
        map.put(talla.producto_id_producto, arraylist.get("mylistproducto").get(mproducto_id_producto.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delTalla() {
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
            delTalla();
            finish();
            break;
        case EDIT_ID:
            addTalla();
            break;
        case ADD_ID:
            addTalla();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}