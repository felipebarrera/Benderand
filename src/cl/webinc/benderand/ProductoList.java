package cl.webinc.benderand;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.entidad.Productoprecio;
import cl.webinc.benderand.provider.Base.productoprecio;
import cl.webinc.benderand.util.CursortoArrayEntidad;
import cl.webinc.benderand.util.CustomAdapterProductosPrecio;
import cl.webinc.benderand.util.ProjectionCreater;

public class ProductoList extends AppCompatActivity {
    private static final String TAG = "productolist";
    // Menu item ids
    public static final int MENU_ITEM_DELETE = Menu.FIRST;
    public static final int MENU_ITEM_INSERT = Menu.FIRST + 1;
	protected ArrayList<Productoprecio> mylist;
	private static AppMy app = AppMy.getinstance();
	private HashMap<String, String> extra = app.getExtra();
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
        setContentView(R.layout.listatienda);
        setTitle(R.string.stringproductos);
        lv = (ListView) findViewById(R.id.listaproductos);
        lv.setOnCreateContextMenuListener(this);
        lv.setTextFilterEnabled(true);
        new sincTask().execute();
    }
    public void onItemClick(int mPosition) {
        Log.e(TAG,"" + mPosition);
        @SuppressWarnings("unchecked")
        Productoprecio o = (Productoprecio) lv.getItemAtPosition(mPosition);
        Toast.makeText(ProductoList.this, "ID '" + o.getId_producto() + "' was clicked.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ProductoList.this, Productoeditor.class);
        intent.putExtra("id", o.getId_producto());
        extra.put("id", o.getId_producto());
        app.setExtra(extra);
        Log.e(TAG, "" + app.getExtra().get("_id"));
        startActivityForResult(intent, 1);
    }
    private class sincTask extends AsyncTask<String, Void, ArrayList<Productoprecio>>
    {
    	ProgressDialog dialog;
	    @Override
	    protected void onPreExecute() {
	        dialog = new ProgressDialog(ProductoList.this);
	        dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(ProductoList.this.getResources().getString(R.string.lblPorfavorespere));
	        dialog.setIndeterminate(true);
	        dialog.show();
	    }
    	@Override
    	 protected void onPostExecute(ArrayList<Productoprecio> result) {
    		if(result != null) {
                lv.setAdapter(new CustomAdapterProductosPrecio(ProductoList.this, result));
    	        }else {
                    Toast.makeText(getApplicationContext(), "Fallo la sincronizacion", Toast.LENGTH_SHORT).show();
    	            Log.e("sinctask productolista", " Fallo la sincronizacion");
    	        }
    	    	dialog.dismiss();
    	 }
    	@Override
    	protected ArrayList<Productoprecio> doInBackground(String... params) {
    		Log.e("thread end", " thread end");
    		if(!app.isExternal()){
    		    ProjectionCreater.getinstance();
        		mylist = CursortoArrayEntidad.getinstance().aeProductoprecio(getContentResolver().query(productoprecio.CONTENT_URI, ProjectionCreater.pcproductoprecio, null, null, productoprecio.DEFAULT_ORDEN));
        	}
            else
            {
            	if(app.isOnline(ProductoList.this))
            	{
            		try {
            			//mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/sincronize/productocompleto/get_productodroid/" + app.getCarneEmpresa().getId_empresa(),"productocompleto");
                        Log.e("","");
            		} catch (Exception e) {
            			mylist = new ArrayList<>();
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult", "onActivityResult");
        new sincTask().execute();
        Log.e("Productolist", "onResume");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_ITEM_INSERT, 0, R.string.menu_insert)
                .setShortcut('3', 'a')
                .setIcon(android.R.drawable.ic_input_add)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        Intent intent = new Intent(null, getIntent().getData());
        intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
        menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
                new ComponentName(this, ProductoList.class), null, intent, 0, null);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return true;
    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_ITEM_INSERT:
        	Intent i = new Intent(this, Productoeditor.class);
            extra.put("id", "0");
            app.setExtra(extra);
            startActivityForResult(i,1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info;
        try {
             info = (AdapterView.AdapterContextMenuInfo) menuInfo;
             Log.e(TAG, "bad menuInfo" + info.position);
        } catch (ClassCastException e) {
            Log.e(TAG, "bad menuInfo", e);
            return;
        }
        // Setup the menu header
        menu.setHeaderTitle("Opciones");
        // Add a menu item to delete the note
        menu.add(0, MENU_ITEM_DELETE, 0, R.string.menu_delete);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info;
        try {
             info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
             Log.e(TAG, "bad menuInfo" + info.position);
        } catch (ClassCastException e) {
            Log.e(TAG, "bad menuInfo", e);
            return false;
        }
        switch (item.getItemId()) {
            case MENU_ITEM_DELETE: {
                return true;
            }
        }
        return false;
    }    
}