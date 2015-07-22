package cl.webinc.benderand.movidos;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.AppMy;
import cl.webinc.benderand.ProductoList;
import cl.webinc.benderand.Productoeditor;
import cl.webinc.benderand.R;
import cl.webinc.benderand.provider.Base.precio;
import cl.webinc.benderand.provider.Base.producto;
import cl.webinc.benderand.sync.WebConector;


public class ProductoWeb extends ListActivity {


	private String web;
	private ProgressDialog m_ProgressDialog = null ;
	protected ArrayList<HashMap<String, String>> mylist;
    public static final int MENU_ITEM_DELETE = Menu.FIRST;
    public static final int MENU_ITEM_INSERT = Menu.FIRST + 1;
    private static final int COLUMN_INDEX_TITLE = 5;
	private static AppMy app = AppMy.getinstance();
	private HashMap<String, String> extra = new HashMap<String, String>();

	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        web = getIntent().getStringExtra("ip");
        new sincTask().execute();
        m_ProgressDialog = ProgressDialog.show(ProductoWeb.this,    
                "Please wait...", "Retrieving data ...", true);
        
        final ListView lv = getListView();
        Log.e("ListView", " return");
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                @SuppressWarnings("unchecked")
                HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);
                Toast.makeText(ProductoWeb.this, "ID '" + o.get("id_prod") + "' was clicked.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProductoWeb.this, Productoeditor.class);
                intent.putExtra("id", o.get("id_prod"));
                extra.put("id", o.get("id_prod"));
                Log.e("ListView", " return" + o.get("id_prod"));
                app.setExtra(extra);
                startActivityForResult(intent, 1);
            }
        });
    }
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
		super.onActivityResult(requestCode, resultCode, data);
		Log.e("onActivityResult", "onActivityResult");
		 new sincTask().execute();
	        m_ProgressDialog = ProgressDialog.show(ProductoWeb.this,    
	                "Please wait...", "Retrieving data ...", true);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // This is our one standard application action -- inserting a
        // new note into the list.
        menu.add(0, MENU_ITEM_INSERT, 0, R.string.menu_insert)
                .setShortcut('3', 'a')
                .setIcon(android.R.drawable.ic_menu_add);

        // Generate any additional actions that can be performed on the
        // overall list.  In a normal install, there are no additional
        // actions found here, but this allows other applications to extend
        // our menu with their own actions.
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
        	//String actionName= "android.intent.action.INSERT_PRODUCTO"; 
            // Launch activity to insert a new item
        	Intent i = new Intent(this, Productoeditor.class);
            extra.put("id", "0");
            app.setExtra(extra);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info;
        try {
             info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        } catch (ClassCastException e) {
            Log.e("productoweblist", "bad menuInfo", e);
            return;
        }

        Cursor cursor = (Cursor) getListAdapter().getItem(info.position);
        if (cursor == null) {
            // For some reason the requested item isn't available, do nothing
            return;
        }

        // Setup the menu header
        menu.setHeaderTitle(cursor.getString(COLUMN_INDEX_TITLE));

        // Add a menu item to delete the note
        menu.add(0, MENU_ITEM_DELETE, 0, R.string.menu_delete);
    }
        
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info;
        try {
             info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        } catch (ClassCastException e) {
            Log.e("productoweblist", "bad menuInfo", e);
            return false;
        }
        switch (item.getItemId()) {
            case MENU_ITEM_DELETE: {
                // Delete the note that the context menu is for
                Uri prodUri = ContentUris.withAppendedId(getIntent().getData(), info.id);
                Log.e(" id del ", "___________________________________" + info.id);
                getContentResolver().delete(prodUri, null, null);
                return true;
            }
        }
        return false;
    }
private class sincTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>  
{
	@Override
	 protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
		if(result != null) {
	        ListAdapter adapter = new SimpleAdapter(ProductoWeb.this, result, R.layout.listitem,
	                new String[] { producto.nombre_producto, precio.precio_CLP }, new int[] { android.R.id.text1, android.R.id.text2 });
	        setListAdapter(adapter);
	        Log.e("productoweb 205", " not null");
	        }else {
	            Log.e("terrible null", " return");
	        }
	        m_ProgressDialog.dismiss();
	 }
	@Override
	protected ArrayList<HashMap<String, String>> doInBackground(
			String... params) {
		Log.e("thread end", " thread end");
         try {
			mylist = WebConector.getJSONfromURL("http://"+ web +"/index.php/sincronize/productocompleto/get_Producto/", "productocompleto");
		} catch (JSONException e) {
			mylist = new ArrayList<HashMap<String, String>>();
			Log.e("json", " array list" + e);
		}
         return mylist;
	}
 }

}