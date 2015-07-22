package cl.webinc.benderand.movidos;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import cl.webinc.benderand.R;
import cl.webinc.benderand.provider.Base.gasto;

public class Gastoeditor extends Activity {
    private static final String TAG = "hello EDITOR GASTO";
    private Long ID = (long) 0;

    /**
     * Standard projection for the interesting columns of a normal note.
     */
    private static final String[] PROJECTION = new String[] {
    	gasto.id_gasto, // 0
    	gasto.fecha_gasto, // 2
    	gasto.id_usuario, // 3
    	gasto.monto_gasto, // 4
    	gasto.nombre_gasto, // 5
    };
    /** The index of the note column */
    private static final int COLUMN_INDEX_id_gasto = 0;
    private static final int COLUMN_INDEX_id_usuario = 2;
    private static final int COLUMN_INDEX_monto_gasto = 3;
    private static final int COLUMN_INDEX_nombre_gasto = 4;
    
    // Identifiers for our menu items.
    private static final int ADD_ID = Menu.FIRST;
    private static final int DISCARD_ID = Menu.FIRST + 1;
    private static final int DELETE_ID = Menu.FIRST + 2;

    // The different distinct states the activity can be run in.
    private static final int STATE_EDIT = 0;

    private int mState;
    private boolean mNoteOnly = false;
    private Uri mUri = gasto.CONTENT_URI;
    private Cursor mCursor;
    private EditText mid_gasto;
    private EditText mid_usuario;
    private EditText mmonto_gasto;
    private EditText mnombre_gasto;
 
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
    	mid_gasto = (EditText) findViewById(R.id.editid_gasto);
    	mid_usuario = (EditText) findViewById(R.id.editid_usuario);
    	mmonto_gasto = (EditText) findViewById(R.id.editmonto_gasto);
    	mnombre_gasto = (EditText) findViewById(R.id.editnombre_gasto);
    }
    public void limpiarPantalla()
    {
    	Log.e("limpiapantalla", "limpio___________________");
    	 // asigno textbox a variable corta
    	mid_gasto.setText("");
    	mid_usuario.setText("");
    	mmonto_gasto.setText("");
    	mnombre_gasto.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("ONCREATE", "start ");
        super.onCreate(savedInstanceState);
        int def = 0;
		ID = getIntent().getLongExtra("id", def);
		
        Log.e("ONCREATE", "get id intent " + ID);
        setContentView(R.layout.gastoeditor);
        
        asignarCamposvariableCorta();
        if(ID != 0)
        {        	
			Log.e("ONCREATE query  ", "ID != 0" );
        	managedQuery();
        }
        else
        {
        	limpiarPantalla();
        }
        
    } 
    
	private void managedQuery()
    {
        Log.e("managedquey", "SERIAL " + mUri);
    	
        mCursor = managedQuery(mUri, PROJECTION,"_id=?",new String[] {ID.toString()},null); 
        if (mCursor.moveToFirst())
        {
        	mid_gasto.setTextKeepState(mCursor.getString(COLUMN_INDEX_id_gasto));
        	mid_usuario.setTextKeepState(mCursor.getString(COLUMN_INDEX_id_usuario));
        	mmonto_gasto.setTextKeepState(mCursor.getString(COLUMN_INDEX_monto_gasto));
        	mnombre_gasto.setTextKeepState(mCursor.getString(COLUMN_INDEX_nombre_gasto));
        }
	}

  @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onresume.............");
  }
    

    /**/
  @Override
    protected void onPause() {
        Log.e(TAG, "pause.............");
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.e("onCreateOptionsMenu", "menuoptions.............");
        super.onCreateOptionsMenu(menu);

        // Build the menus that are shown when editing.
        if (mState == STATE_EDIT) {
            menu.add(0, ADD_ID, 0, R.string.menu_insert)
                    .setShortcut('0', 'r')
                    .setIcon(android.R.drawable.ic_menu_add);
            if (!mNoteOnly) {
                menu.add(0, DELETE_ID, 0, R.string.menu_delete)
                        .setShortcut('1', 'd')
                        .setIcon(android.R.drawable.ic_menu_delete);
            }

        // Build the menus that are shown when inserting.
        } else {
            menu.add(0, DISCARD_ID, 0, R.string.menu_discard)
                    .setShortcut('0', 'd')
                    .setIcon(android.R.drawable.ic_menu_delete);
        }

        // If we are working on a full note, then append to the
        // menu items for any other activities that can do stuff with it
        // as well.  This does a query on the system for any activities that
        // implement the ALTERNATIVE_ACTION for our data, adding a menu item
        // for each one that is found.
        if (!mNoteOnly) {
            Intent intent = new Intent(null, getIntent().getData());
            intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
            menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
                    new ComponentName(this, Gastoeditor.class), null, intent, 0, null);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(TAG, "itemselected.............");
        // Handle all of the possible menu actions.
        switch (item.getItemId()) {
        case DELETE_ID:
        	delGasto();
            finish();
            break;
        case ADD_ID:
        	addGasto();
            finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void delGasto() {
    	Uri gastoUri = ContentUris.withAppendedId(mUri, ID);
    	Log.w(" uri del ",  getIntent().getData() + "___" + gastoUri);
    	getContentResolver().delete(gastoUri, null, null);
	}

    private final void addGasto() {
        Log.e("addGasto", "add gasto.............");
        ContentValues values;
        values = new ContentValues();
        values.put(gasto.id_usuario, mid_usuario.getText().toString());
        values.put(gasto.monto_gasto, mmonto_gasto.getText().toString());
        values.put(gasto.nombre_gasto, mnombre_gasto.getText().toString());
    }
}

