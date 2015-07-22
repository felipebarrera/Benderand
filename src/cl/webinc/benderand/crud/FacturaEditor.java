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
import cl.webinc.benderand.provider.Base.empresa;
import cl.webinc.benderand.provider.Base.factura;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class FacturaEditor extends Activity {
    private static final String TAG = "EDITOR factura";
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
    private EditText mid_factura;
    private EditText mrol_factura;
    private EditText mdia_factura;
    private EditText mmes_factura;
    private EditText mano_factura;
    
    private Spinner mempresa_id_empresa;
    private Spinner mcarne_empresa_id_carne_empresa;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorfactura);
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
            dialog = new ProgressDialog(FacturaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc factura ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc factura ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc factura", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc factura");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addfactura  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idfactura = String.valueOf(Integer.valueOf(getContentResolver().insert(factura.CONTENT_URI, PostData.getinstance().postdataready(map, "factura")).getLastPathSegment()));
                    login = Integer.valueOf(idfactura) > 0;
                    Log.e("addfactura  ", " do in background " + idfactura);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "factura").toString());
                        String idfactura = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(factura.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "factura"),null,null)));
                        login = Integer.valueOf(idfactura) > 0;
                        Log.e("updatefactura ", " do in background " + idfactura);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(FacturaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savefactura";
                    }
                    else
                    {
                        action = "updatefactura";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "factura");
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
            dialog = new ProgressDialog(FacturaEditor.this);
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
                Log.e("facturaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra factura, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahFactura(getContentResolver().query(
                        ContentUris.withAppendedId(factura.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcfactura, null, null, factura.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(FacturaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "factura");
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
            dialog = new ProgressDialog(FacturaEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterempresa = new SimpleAdapter(FacturaEditor.this, result.get("mylistempresa"), android.R.layout.simple_spinner_item,
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
                SimpleAdapter adapterempresa1 = new SimpleAdapter(FacturaEditor.this, result.get("mylistempresa"), android.R.layout.simple_spinner_item,
                        new String[] {empresa.nombre_empresa}, new int[] {android.R.id.text1 });
                adapterempresa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mcarne_empresa_id_carne_empresa.setAdapter(adapterempresa1);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(empresa.id_empresa))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mcarne_empresa_id_carne_empresa.setSelection(compareValue);
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
arraylist.put("mylistempresa" , CursortoArrayhash.getinstance().ahEmpresa(getContentResolver().query(
                        empresa.CONTENT_URI, ProjectionCreater.pcempresa, null , null, empresa.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(FacturaEditor.this))
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
        mid_factura.setTextKeepState(mylist.get(mylist.size()-1).get(factura.id_factura));
        mrol_factura.setTextKeepState(mylist.get(mylist.size()-1).get(factura.rol_factura));
        mdia_factura.setTextKeepState(mylist.get(mylist.size()-1).get(factura.dia_factura));
        mmes_factura.setTextKeepState(mylist.get(mylist.size()-1).get(factura.mes_factura));
        mano_factura.setTextKeepState(mylist.get(mylist.size()-1).get(factura.ano_factura));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_factura = (EditText) findViewById(R.id.etid_factura);
        mrol_factura = (EditText) findViewById(R.id.etrol_factura);
        mdia_factura = (EditText) findViewById(R.id.etdia_factura);
        mmes_factura = (EditText) findViewById(R.id.etmes_factura);
        mano_factura = (EditText) findViewById(R.id.etano_factura);
        
        mempresa_id_empresa = (Spinner) findViewById(R.id.spempresa_id_empresa);
        mcarne_empresa_id_carne_empresa = (Spinner) findViewById(R.id.spempresa_id_empresa1);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_factura.setText("");
        mrol_factura.setText("");
        mdia_factura.setText("");
        mmes_factura.setText("");
        mano_factura.setText("");
        
    }

    private void addFactura() {
        Log.e("add", "add Factura");
        map.put(factura.id_factura, mid_factura.getText().toString());
        map.put(factura.rol_factura, mrol_factura.getText().toString());
        map.put(factura.dia_factura, mdia_factura.getText().toString());
        map.put(factura.mes_factura, mmes_factura.getText().toString());
        map.put(factura.ano_factura, mano_factura.getText().toString());
        
        
        map.put(factura.empresa_id_empresa, arraylist.get("mylistempresa").get(mempresa_id_empresa.getSelectedItemPosition()).get("_id"));

        map.put(factura.carne_empresa_id_carne_empresa, arraylist.get("mylistempresa").get(mcarne_empresa_id_carne_empresa.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delFactura() {
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
            delFactura();
            finish();
            break;
        case EDIT_ID:
            addFactura();
            break;
        case ADD_ID:
            addFactura();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}