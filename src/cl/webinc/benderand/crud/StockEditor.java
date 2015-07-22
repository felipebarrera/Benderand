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

public class StockEditor extends Activity {
    private static final String TAG = "EDITOR stock";
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
    private EditText mid_stock;
    private EditText mstock_real;
    private EditText mstock_minimo;
    private EditText mstock_ideal;
    private EditText mstock_tienda;
    private EditText mstock_virtual;
    private EditText mstock_vendido;
    private EditText mlast_update;
    
    private Spinner mproducto_id_producto;
    private Spinner mempresa_id_empresa;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorstock);
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
            dialog = new ProgressDialog(StockEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc stock ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc stock ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc stock", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc stock");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addstock  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idstock = String.valueOf(Integer.valueOf(getContentResolver().insert(stock.CONTENT_URI, PostData.getinstance().postdataready(map, "stock")).getLastPathSegment()));
                    login = Integer.valueOf(idstock) > 0;
                    Log.e("addstock  ", " do in background " + idstock);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "stock").toString());
                        String idstock = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(stock.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "stock"),null,null)));
                        login = Integer.valueOf(idstock) > 0;
                        Log.e("updatestock ", " do in background " + idstock);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(StockEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savestock";
                    }
                    else
                    {
                        action = "updatestock";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "stock");
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
            dialog = new ProgressDialog(StockEditor.this);
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
                Log.e("stockeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra stock, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahStock(getContentResolver().query(
                        ContentUris.withAppendedId(stock.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcstock, null, null, stock.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(StockEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "stock");
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
            dialog = new ProgressDialog(StockEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterproducto = new SimpleAdapter(StockEditor.this, result.get("mylistproducto"), android.R.layout.simple_spinner_item,
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
SimpleAdapter adapterempresa = new SimpleAdapter(StockEditor.this, result.get("mylistempresa"), android.R.layout.simple_spinner_item,
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
                arraylist.put("mylistproducto" , CursortoArrayhash.getinstance().ahProducto(getContentResolver().query(
                        producto.CONTENT_URI, ProjectionCreater.pcproducto, null , null, producto.DEFAULT_ORDEN)));
arraylist.put("mylistempresa" , CursortoArrayhash.getinstance().ahEmpresa(getContentResolver().query(
                        empresa.CONTENT_URI, ProjectionCreater.pcempresa, null , null, empresa.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(StockEditor.this))
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
        mid_stock.setTextKeepState(mylist.get(mylist.size()-1).get(stock.id_stock));
        mstock_real.setTextKeepState(mylist.get(mylist.size()-1).get(stock.stock_real));
        mstock_minimo.setTextKeepState(mylist.get(mylist.size()-1).get(stock.stock_minimo));
        mstock_ideal.setTextKeepState(mylist.get(mylist.size()-1).get(stock.stock_ideal));
        mstock_tienda.setTextKeepState(mylist.get(mylist.size()-1).get(stock.stock_tienda));
        mstock_virtual.setTextKeepState(mylist.get(mylist.size()-1).get(stock.stock_virtual));
        mstock_vendido.setTextKeepState(mylist.get(mylist.size()-1).get(stock.stock_vendido));
        mlast_update.setTextKeepState(mylist.get(mylist.size()-1).get(stock.last_update));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_stock = (EditText) findViewById(R.id.etid_stock);
        mstock_real = (EditText) findViewById(R.id.etstock_real);
        mstock_minimo = (EditText) findViewById(R.id.etstock_minimo);
        mstock_ideal = (EditText) findViewById(R.id.etstock_ideal);
        mstock_tienda = (EditText) findViewById(R.id.etstock_tienda);
        mstock_virtual = (EditText) findViewById(R.id.etstock_virtual);
        mstock_vendido = (EditText) findViewById(R.id.etstock_vendido);
        mlast_update = (EditText) findViewById(R.id.etlast_update);
        
        mproducto_id_producto = (Spinner) findViewById(R.id.spproducto_id_producto);
        mempresa_id_empresa = (Spinner) findViewById(R.id.spempresa_id_empresa);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_stock.setText("");
        mstock_real.setText("");
        mstock_minimo.setText("");
        mstock_ideal.setText("");
        mstock_tienda.setText("");
        mstock_virtual.setText("");
        mstock_vendido.setText("");
        mlast_update.setText("");
        
    }

    private void addStock() {
        Log.e("add", "add Stock");
        map.put(stock.id_stock, mid_stock.getText().toString());
        map.put(stock.stock_real, mstock_real.getText().toString());
        map.put(stock.stock_minimo, mstock_minimo.getText().toString());
        map.put(stock.stock_ideal, mstock_ideal.getText().toString());
        map.put(stock.stock_tienda, mstock_tienda.getText().toString());
        map.put(stock.stock_virtual, mstock_virtual.getText().toString());
        map.put(stock.stock_vendido, mstock_vendido.getText().toString());
        map.put(stock.last_update, mlast_update.getText().toString());
        
        
        map.put(stock.producto_id_producto, arraylist.get("mylistproducto").get(mproducto_id_producto.getSelectedItemPosition()).get("_id"));

        map.put(stock.empresa_id_empresa, arraylist.get("mylistempresa").get(mempresa_id_empresa.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delStock() {
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
            delStock();
            finish();
            break;
        case EDIT_ID:
            addStock();
            break;
        case ADD_ID:
            addStock();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}