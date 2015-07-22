package cl.webinc.benderand.crud;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.database.SQLException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.AppMy;
import cl.webinc.benderand.R;
import cl.webinc.benderand.provider.Base.factura;
import cl.webinc.benderand.provider.Base.item_factura;
import cl.webinc.benderand.provider.Base.producto;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class Item_facturaEditor extends Activity {
    private static final String TAG = "EDITOR item_factura";
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
    private EditText mid_itemfactura;
    private EditText mcantidad;
    private EditText mprecio;
    
    private Spinner mproducto_id_producto;
    private Spinner mfactura_id_factura;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editoritem_factura);
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
            dialog = new ProgressDialog(Item_facturaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc item_factura ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc item_factura ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc item_factura", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc item_factura");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("additem_factura  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String iditem_factura = String.valueOf(Integer.valueOf(getContentResolver().insert(item_factura.CONTENT_URI, PostData.getinstance().postdataready(map, "item_factura")).getLastPathSegment()));
                    login = Integer.valueOf(iditem_factura) > 0;
                    Log.e("additem_factura  ", " do in background " + iditem_factura);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "item_factura").toString());
                        String iditem_factura = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(item_factura.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "item_factura"),null,null)));
                        login = Integer.valueOf(iditem_factura) > 0;
                        Log.e("updateitem_factura ", " do in background " + iditem_factura);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(Item_facturaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "saveitem_factura";
                    }
                    else
                    {
                        action = "updateitem_factura";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "item_factura");
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
            dialog = new ProgressDialog(Item_facturaEditor.this);
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
                Log.e("item_facturaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra item_factura, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahItem_factura(getContentResolver().query(
                        ContentUris.withAppendedId(item_factura.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcitem_factura, null, null, item_factura.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(Item_facturaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "item_factura");
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
            dialog = new ProgressDialog(Item_facturaEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterproducto = new SimpleAdapter(Item_facturaEditor.this, result.get("mylistproducto"), android.R.layout.simple_spinner_item,
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
SimpleAdapter adapterfactura = new SimpleAdapter(Item_facturaEditor.this, result.get("mylistfactura"), android.R.layout.simple_spinner_item,
                        new String[] {factura.rol_factura}, new int[] {android.R.id.text1 });
                adapterfactura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mfactura_id_factura.setAdapter(adapterfactura);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(factura.id_factura))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mfactura_id_factura.setSelection(compareValue);
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
arraylist.put("mylistfactura" , CursortoArrayhash.getinstance().ahFactura(getContentResolver().query(
                        factura.CONTENT_URI, ProjectionCreater.pcfactura, null , null, factura.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(Item_facturaEditor.this))
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
        mid_itemfactura.setTextKeepState(mylist.get(mylist.size()-1).get(item_factura.id_itemfactura));
        mcantidad.setTextKeepState(mylist.get(mylist.size()-1).get(item_factura.cantidad));
        mprecio.setTextKeepState(mylist.get(mylist.size()-1).get(item_factura.precio));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_itemfactura = (EditText) findViewById(R.id.etid_itemfactura);
        mcantidad = (EditText) findViewById(R.id.etcantidad);
        mprecio = (EditText) findViewById(R.id.etprecio);
        
        mproducto_id_producto = (Spinner) findViewById(R.id.spproducto_id_producto);
        mfactura_id_factura = (Spinner) findViewById(R.id.spfactura_id_factura);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_itemfactura.setText("");
        mcantidad.setText("");
        mprecio.setText("");
        
    }

    private void addItem_factura() {
        Log.e("add", "add Item_factura");
        map.put(item_factura.id_itemfactura, mid_itemfactura.getText().toString());
        map.put(item_factura.cantidad, mcantidad.getText().toString());
        map.put(item_factura.precio, mprecio.getText().toString());
        
        
        map.put(item_factura.producto_id_producto, arraylist.get("mylistproducto").get(mproducto_id_producto.getSelectedItemPosition()).get("_id"));

        map.put(item_factura.factura_id_factura, arraylist.get("mylistfactura").get(mfactura_id_factura.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delItem_factura() {
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
            delItem_factura();
            finish();
            break;
        case EDIT_ID:
            addItem_factura();
            break;
        case ADD_ID:
            addItem_factura();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}