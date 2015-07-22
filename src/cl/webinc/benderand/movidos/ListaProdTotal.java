package cl.webinc.benderand.movidos;

import cl.webinc.benderand.ProductoList;
import cl.webinc.benderand.Productoeditor;
import cl.webinc.benderand.R;
import cl.webinc.benderand.provider.Base.producto;
import cl.webinc.benderand.util.ProjectionCreater;
import android.app.ListActivity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


	public class ListaProdTotal extends ListActivity {
	    private static final String TAG = "ListaProdTotal";

	    // Menu item ids
	    public static final int MENU_ITEM_DELETE = Menu.FIRST;
	    public static final int MENU_ITEM_INSERT = Menu.FIRST + 1;

	    /**
	     * The columns we are interested in from the database
	     */

	    /** The index of the title column */
	    private static final int COLUMN_INDEX_TITLE = 5;
	    
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);

	        // If no data was given in the intent (because we were started
	        // as a MAIN activity), then use our default content provider.
	        Intent intent = getIntent();
	        if (intent.getData() == null) {
	            intent.setData(producto.CONTENT_URI);
	        }

	        // Inform the list we provide context menus for items
	        getListView().setOnCreateContextMenuListener(this);
	        
	        // Perform a managed query. The Activity will handle closing and requerying the cursor
	        // when needed.
	        Cursor cursor = managedQuery(getIntent().getData(), ProjectionCreater.pcproducto, null, null,
	        		producto.DEFAULT_ORDEN);

	        // Used to map notes entries from the database to views
	        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listitem, cursor,
	                new String[] { producto.nombre_producto, producto.peso_neto }, new int[] { android.R.id.text1, android.R.id.text2 });
	        setListAdapter(adapter);
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
	        final boolean haveItems = getListAdapter().getCount() > 0;

	        // If there are any notes in the list (which implies that one of
	        // them is selected), then we need to generate the actions that
	        // can be performed on the current selection.  This will be a combination
	        // of our own specific actions along with any extensions that can be
	        // found.
	        if (haveItems) {
	            // This is the selected item.
	            Uri uri = ContentUris.withAppendedId(getIntent().getData(), getSelectedItemId());

	            // Build menu...  always starts with the EDIT action...
	            Intent[] specifics = new Intent[1];
	            specifics[0] = new Intent(Intent.ACTION_EDIT, uri);
	            MenuItem[] items = new MenuItem[1];

	            // ... is followed by whatever other actions are available...
	            Intent intent = new Intent(null, uri);
	            intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
	            menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0, null, specifics, intent, 0,
	                    items);

	            // Give a shortcut to the edit action.
	            if (items[0] != null) {
	                items[0].setShortcut('1', 'e');
	            }
	        } else {
	            menu.removeGroup(Menu.CATEGORY_ALTERNATIVE);
	        }

	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case MENU_ITEM_INSERT:
	        	//String actionName= "android.intent.action.INSERT_PRODUCTO"; 
	            // Launch activity to insert a new item
	        	Intent i = new Intent(this, Productoeditor.class);
	            i.putExtra("id", 0);
	        	startActivity(i);
	            //startActivity(new Intent(actionName));
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
	            Log.e(TAG, "bad menuInfo", e);
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
	            Log.e(TAG, "bad menuInfo", e);
	            return false;
	        }

	        switch (item.getItemId()) {
	            case MENU_ITEM_DELETE: {
	                // Delete the note that the context menu is for
	                Uri prodUri = ContentUris.withAppendedId(getIntent().getData(), info.id);
	                Log.w(" uri del ", "___________________________________" + prodUri);
	                getContentResolver().delete(prodUri, null, null);
	                return true;
	            }
	        }
	        return false;
	    }

	    @Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        //Uri uri = ContentUris.withAppendedId(getIntent().getData(), id);
	        Log.e("onListItemClick intent ", "" + getIntent().resolveActivity(getPackageManager()));
	        Intent intent = new Intent(this, Productoeditor.class);
	        intent.putExtra("id", id);
	        startActivity(intent);
	    }
	    
	
}
