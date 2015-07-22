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
import cl.webinc.benderand.provider.Base.carne_empresa;
import cl.webinc.benderand.provider.Base.tipo_documento;
import cl.webinc.benderand.provider.Base.tipo_pago;
import cl.webinc.benderand.provider.Base.usuario;
import cl.webinc.benderand.provider.Base.venta;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class VentaEditor extends Activity {
    private static final String TAG = "EDITOR venta";
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
    private EditText mid_venta;
    private EditText mnumero_articulos;
    private EditText mtotal;
    private EditText mdia_fecha_venta;
    private EditText mmes_fecha_venta;
    private EditText manno_fecha_venta;
    private EditText mhora_fecha_venta;
    
    private Spinner musuario_id_usuario;
    private Spinner mcarne_empresa_id_carne_empresa;
    private Spinner mtipo_pago_id_tipo_pago;
    private Spinner mtipo_documento_id_tipo_documento;
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editorventa);
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
            dialog = new ProgressDialog(VentaEditor.this);
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
                Toast.makeText(getApplicationContext(), "Sinc venta ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc venta ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc venta", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc venta");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addventa  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idventa = String.valueOf(Integer.valueOf(getContentResolver().insert(venta.CONTENT_URI, PostData.getinstance().postdataready(map, "venta")).getLastPathSegment()));
                    login = Integer.valueOf(idventa) > 0;
                    Log.e("addventa  ", " do in background " + idventa);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "venta").toString());
                        String idventa = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(venta.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "venta"),null,null)));
                        login = Integer.valueOf(idventa) > 0;
                        Log.e("updateventa ", " do in background " + idventa);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(VentaEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "saveventa";
                    }
                    else
                    {
                        action = "updateventa";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "venta");
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
            dialog = new ProgressDialog(VentaEditor.this);
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
                Log.e("ventaeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra venta, error de sincronizacion", Toast.LENGTH_SHORT).show();
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
                mylist = CursortoArrayhash.getinstance().ahVenta(getContentResolver().query(
                        ContentUris.withAppendedId(venta.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pcventa, null, null, venta.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(VentaEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "venta");
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
            dialog = new ProgressDialog(VentaEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                SimpleAdapter adapterusuario = new SimpleAdapter(VentaEditor.this, result.get("mylistusuario"), android.R.layout.simple_spinner_item,
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
SimpleAdapter adaptercarne_empresa = new SimpleAdapter(VentaEditor.this, result.get("mylistcarne_empresa"), android.R.layout.simple_spinner_item,
                        new String[] {carne_empresa.nombre_usuario}, new int[] {android.R.id.text1 });
                adaptercarne_empresa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mcarne_empresa_id_carne_empresa.setAdapter(adaptercarne_empresa);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(carne_empresa.id_carne_empresa))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mcarne_empresa_id_carne_empresa.setSelection(compareValue);
                    }
                }
SimpleAdapter adaptertipo_pago = new SimpleAdapter(VentaEditor.this, result.get("mylisttipo_pago"), android.R.layout.simple_spinner_item,
                        new String[] {tipo_pago.nombre_tipo_pago}, new int[] {android.R.id.text1 });
                adaptertipo_pago.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mtipo_pago_id_tipo_pago.setAdapter(adaptertipo_pago);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(tipo_pago.id_tipo_pago))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mtipo_pago_id_tipo_pago.setSelection(compareValue);
                    }
                }
SimpleAdapter adaptertipo_documento = new SimpleAdapter(VentaEditor.this, result.get("mylisttipo_documento"), android.R.layout.simple_spinner_item,
                        new String[] {tipo_documento.nombre_tipo_documento}, new int[] {android.R.id.text1 });
                adaptertipo_documento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mtipo_documento_id_tipo_documento.setAdapter(adaptertipo_documento);
                if (mState == STATE_EDIT) {
                    Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(tipo_documento.id_tipo_documento))-1;
                    Log.e("compareValue", "" + compareValue);
                    if (!compareValue.equals(null)) {
                        mtipo_documento_id_tipo_documento.setSelection(compareValue);
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
                arraylist.put("mylistusuario" , CursortoArrayhash.getinstance().ahUsuario(getContentResolver().query(
                        usuario.CONTENT_URI, ProjectionCreater.pcusuario, null , null, usuario.DEFAULT_ORDEN)));
arraylist.put("mylistcarne_empresa" , CursortoArrayhash.getinstance().ahCarne_empresa(getContentResolver().query(
                        carne_empresa.CONTENT_URI, ProjectionCreater.pccarne_empresa, null , null, carne_empresa.DEFAULT_ORDEN)));
arraylist.put("mylisttipo_pago" , CursortoArrayhash.getinstance().ahTipo_pago(getContentResolver().query(
                        tipo_pago.CONTENT_URI, ProjectionCreater.pctipo_pago, null , null, tipo_pago.DEFAULT_ORDEN)));
arraylist.put("mylisttipo_documento" , CursortoArrayhash.getinstance().ahTipo_documento(getContentResolver().query(
                        tipo_documento.CONTENT_URI, ProjectionCreater.pctipo_documento, null , null, tipo_documento.DEFAULT_ORDEN)));

            }
            else
            {
                if(app.isOnline(VentaEditor.this))
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
        mid_venta.setTextKeepState(mylist.get(mylist.size()-1).get(venta.id_venta));
        mnumero_articulos.setTextKeepState(mylist.get(mylist.size()-1).get(venta.numero_articulos));
        mtotal.setTextKeepState(mylist.get(mylist.size()-1).get(venta.total));
        mdia_fecha_venta.setTextKeepState(mylist.get(mylist.size()-1).get(venta.dia_fecha_venta));
        mmes_fecha_venta.setTextKeepState(mylist.get(mylist.size()-1).get(venta.mes_fecha_venta));
        manno_fecha_venta.setTextKeepState(mylist.get(mylist.size()-1).get(venta.anno_fecha_venta));
        mhora_fecha_venta.setTextKeepState(mylist.get(mylist.size()-1).get(venta.hora_fecha_venta));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_venta = (EditText) findViewById(R.id.etid_venta);
        mnumero_articulos = (EditText) findViewById(R.id.etnumero_articulos);
        mtotal = (EditText) findViewById(R.id.ettotal);
        mdia_fecha_venta = (EditText) findViewById(R.id.etdia_fecha_venta);
        mmes_fecha_venta = (EditText) findViewById(R.id.etmes_fecha_venta);
        manno_fecha_venta = (EditText) findViewById(R.id.etanno_fecha_venta);
        mhora_fecha_venta = (EditText) findViewById(R.id.ethora_fecha_venta);
        
        musuario_id_usuario = (Spinner) findViewById(R.id.spusuario_id_usuario);
        mcarne_empresa_id_carne_empresa = (Spinner) findViewById(R.id.spcarne_empresa_id_carne_empresa);
        mtipo_pago_id_tipo_pago = (Spinner) findViewById(R.id.sptipo_pago_id_tipo_pago);
        mtipo_documento_id_tipo_documento = (Spinner) findViewById(R.id.sptipo_documento_id_tipo_documento);
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_venta.setText("");
        mnumero_articulos.setText("");
        mtotal.setText("");
        mdia_fecha_venta.setText("");
        mmes_fecha_venta.setText("");
        manno_fecha_venta.setText("");
        mhora_fecha_venta.setText("");
        
    }

    private void addVenta() {
        Log.e("add", "add Venta");
        map.put(venta.id_venta, mid_venta.getText().toString());
        map.put(venta.numero_articulos, mnumero_articulos.getText().toString());
        map.put(venta.total, mtotal.getText().toString());
        map.put(venta.dia_fecha_venta, mdia_fecha_venta.getText().toString());
        map.put(venta.mes_fecha_venta, mmes_fecha_venta.getText().toString());
        map.put(venta.anno_fecha_venta, manno_fecha_venta.getText().toString());
        map.put(venta.hora_fecha_venta, mhora_fecha_venta.getText().toString());
        
        
        map.put(venta.usuario_id_usuario, arraylist.get("mylistusuario").get(musuario_id_usuario.getSelectedItemPosition()).get("_id"));

        map.put(venta.carne_empresa_id_carne_empresa, arraylist.get("mylistcarne_empresa").get(mcarne_empresa_id_carne_empresa.getSelectedItemPosition()).get("_id"));

        map.put(venta.tipo_pago_id_tipo_pago, arraylist.get("mylisttipo_pago").get(mtipo_pago_id_tipo_pago.getSelectedItemPosition()).get("_id"));

        map.put(venta.tipo_documento_id_tipo_documento, arraylist.get("mylisttipo_documento").get(mtipo_documento_id_tipo_documento.getSelectedItemPosition()).get("_id"));


        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delVenta() {
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
            delVenta();
            finish();
            break;
        case EDIT_ID:
            addVenta();
            break;
        case ADD_ID:
            addVenta();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}