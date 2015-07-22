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

public class Valor_nutricionalEditor extends Activity {
    private static final String TAG = "EDITOR valor_nutricional";
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
    private EditText mid_valor_nutricional;
    private EditText mnombre_valor;
    private EditText mcantidad;
    private EditText mvalor_diario_total;
    private EditText mporcentaje_requerimientos;
    
    private Spinner mproducto_id_producto;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorvalor_nutricional);
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
            dialog = new ProgressDialog(Valor_nutricionalEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc valor_nutricional ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc valor_nutricional ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc valor_nutricional", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc valor_nutricional");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addvalor_nutricional  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idvalor_nutricional = String.valueOf(Integer.valueOf(getContentResolver().insert(valor_nutricional.CONTENT_URI, PostData.getinstance().postdataready(map, "valor_nutricional")).getLastPathSegment()));
                    login = Integer.valueOf(idvalor_nutricional) > 0;
                    Log.e("addvalor_nutricional  ", " do in background " + idvalor_nutricional);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "valor_nutricional").toString());
                        String idvalor_nutricional = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(valor_nutricional.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "valor_nutricional"),null,null)));
                        login = Integer.valueOf(idvalor_nutricional) > 0;
                        Log.e("updatevalor_nutricional ", " do in background " + idvalor_nutricional);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(Valor_nutricionalEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savevalor_nutricional";
                    }
                    else
                    {
                        action = "updatevalor_nutricional";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "valor_nutricional");
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
            dialog = new ProgressDialog(Valor_nutricionalEditor.this);
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
                Log.e("valor_nutricionaleditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra valor_nutricional, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahValor_nutricional(getContentResolver().query(
                        ContentUris.withAppendedId(valor_nutricional.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcvalor_nutricional, null, null, valor_nutricional.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(Valor_nutricionalEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "valor_nutricional");
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
            dialog = new ProgressDialog(Valor_nutricionalEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterproducto = new SimpleAdapter(Valor_nutricionalEditor.this, result.get("mylistproducto"), android.R.layout.simple_spinner_item,
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
                if(app.isOnline(Valor_nutricionalEditor.this))
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
        mid_valor_nutricional.setTextKeepState(mylist.get(mylist.size()-1).get(valor_nutricional.id_valor_nutricional));
        mnombre_valor.setTextKeepState(mylist.get(mylist.size()-1).get(valor_nutricional.nombre_valor));
        mcantidad.setTextKeepState(mylist.get(mylist.size()-1).get(valor_nutricional.cantidad));
        mvalor_diario_total.setTextKeepState(mylist.get(mylist.size()-1).get(valor_nutricional.valor_diario_total));
        mporcentaje_requerimientos.setTextKeepState(mylist.get(mylist.size()-1).get(valor_nutricional.porcentaje_requerimientos));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_valor_nutricional = (EditText) findViewById(R.id.etid_valor_nutricional);
        mnombre_valor = (EditText) findViewById(R.id.etnombre_valor);
        mcantidad = (EditText) findViewById(R.id.etcantidad);
        mvalor_diario_total = (EditText) findViewById(R.id.etvalor_diario_total);
        mporcentaje_requerimientos = (EditText) findViewById(R.id.etporcentaje_requerimientos);
        
        mproducto_id_producto = (Spinner) findViewById(R.id.spproducto_id_producto);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_valor_nutricional.setText("");
        mnombre_valor.setText("");
        mcantidad.setText("");
        mvalor_diario_total.setText("");
        mporcentaje_requerimientos.setText("");
        
    }

    private void addValor_nutricional() {
        Log.e("add", "add Valor_nutricional");
        map.put(valor_nutricional.id_valor_nutricional, mid_valor_nutricional.getText().toString());
        map.put(valor_nutricional.nombre_valor, mnombre_valor.getText().toString());
        map.put(valor_nutricional.cantidad, mcantidad.getText().toString());
        map.put(valor_nutricional.valor_diario_total, mvalor_diario_total.getText().toString());
        map.put(valor_nutricional.porcentaje_requerimientos, mporcentaje_requerimientos.getText().toString());
        
        
        map.put(valor_nutricional.producto_id_producto, arraylist.get("mylistproducto").get(mproducto_id_producto.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delValor_nutricional() {
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
            delValor_nutricional();
            finish();
            break;
        case EDIT_ID:
            addValor_nutricional();
            break;
        case ADD_ID:
            addValor_nutricional();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}