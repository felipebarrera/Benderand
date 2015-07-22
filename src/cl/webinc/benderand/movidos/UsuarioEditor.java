package cl.webinc.benderand.movidos;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import cl.webinc.benderand.R;
import cl.webinc.benderand.provider.Base.usuario;
import cl.webinc.benderand.provider.Base.empresa;
import cl.webinc.benderand.sync.WebSender;
import cl.webinc.benderand.util.ProjectionCreater;

public class UsuarioEditor extends Activity {
    private static final String TAG = "hello EDITOR USUARIO";
    private Long ID = (long) 0;

    private static final int COLUMN_INDEX_id_usuario = 0;
    private static final int COLUMN_INDEX_id_cliente = 1;
    private static final int COLUMN_INDEX_nom_usuario = 2;
    private static final int COLUMN_INDEX_tipo_usuario = 3;
    private static final int COLUMN_INDEX_id_empre = 4;
    private static final int COLUMN_INDEX_clave = 5;
    
    // Identifiers for our menu items.
    private static final int ADD_ID = Menu.FIRST;
    private static final int DISCARD_ID = Menu.FIRST + 1;
    private static final int DELETE_ID = Menu.FIRST + 2;
    private static final int EDIT_ID = Menu.FIRST + 3;

    // The different distinct states the activity can be run in.
    private static final int STATE_EDIT = 1;
    private static final int STATE_INSERT = 0;

    private int mState;
    private boolean mNoteOnly = false;
    private Uri mUri = usuario.CONTENT_URI;
    private Cursor mCursor;
    private EditText mid_usuario;
    private EditText mid_cliente;
    private EditText mnom_usuario;
    private EditText mtipo_usuario;
    private Spinner mid_empre;
    private EditText mclave;
	protected String FORMAT;
 
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
    	mid_usuario = (EditText) findViewById(R.id.editid_usuariouser);
    	mid_cliente = (EditText) findViewById(R.id.editid_cliente);
        mnom_usuario = (EditText) findViewById(R.id.editnom_usuario);
        mtipo_usuario = (EditText) findViewById(R.id.edittipo_usuario);
        mid_empre = (Spinner) findViewById(R.id.editid_empre);
        mclave = (EditText) findViewById(R.id.editclave);
    }
    public void limpiarPantalla()
    {
    	Log.e("limpiapantalla", "limpio___________________");
    	 // asigno textbox a variable corta
    	mid_usuario.setText("");
    	mid_cliente.setText("");
        mnom_usuario.setText("");
        mtipo_usuario.setText("");
        mclave.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("ONCREATE", "start ");
        super.onCreate(savedInstanceState);
        int def = 0;
		ID = getIntent().getLongExtra("id", def);
		
        Log.e("ONCREATE", "get id intent " + ID);
        setContentView(R.layout.usereditor);
        
        Cursor cursorSpinnerEmpre = managedQuery(empresa.CONTENT_URI , ProjectionCreater.pccaracteristica, null, null,
        		empresa.DEFAULT_ORDEN);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursorSpinnerEmpre,
                new String[] { empresa.nombre_empresa}, new int[] { android.R.id.text1 });
        asignarCamposvariableCorta();
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mid_empre.setAdapter(adapter);
        if(ID != 0)
        {        	
			Log.e("ONCREATE query  ", "ID != 0" + ID );
        	limpiarPantalla();
        	managedQuery();
        	mState = STATE_EDIT;
        }
        else
        {
        	limpiarPantalla();
        	mState = STATE_INSERT;
        }        
    }
	private void managedQuery()
    {
        Uri uri = ContentUris.withAppendedId(mUri, ID);
        Log.e("ContentUris______", "uri " + uri + " id " + ID);
        mCursor = managedQuery(uri, ProjectionCreater.pcusuario, null, null, null); 
        if (mCursor.moveToFirst())
        {
            Log.e("STATE_EDIT", "STATE_EDIT " + mCursor.getString(COLUMN_INDEX_id_usuario));
            mState = STATE_EDIT;
            mid_usuario.setTextKeepState(mCursor.getString(COLUMN_INDEX_id_usuario));
            mid_cliente.setTextKeepState(mCursor.getString(COLUMN_INDEX_id_cliente));
            mnom_usuario.setTextKeepState(mCursor.getString(COLUMN_INDEX_nom_usuario));
            mtipo_usuario.setTextKeepState(mCursor.getString(COLUMN_INDEX_tipo_usuario));
            mid_empre.setSelection(mCursor.getInt(COLUMN_INDEX_id_empre));
            mclave.setTextKeepState(mCursor.getString(COLUMN_INDEX_clave));
            /*for(int i=0; i<=30; i++)
            {
            	Log.e("valores", "i " + i + " " + mCursor.getString(i));
            }*/
        }
        else
        {
        	mState = STATE_INSERT;
        }
    	Log.e("mState", "mState" + mState);
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
        if (mState == STATE_EDIT) {
            menu.add(0, ADD_ID, 0, R.string.menu_insert)
                    .setShortcut('0', 'r')
                    .setIcon(android.R.drawable.ic_menu_add);
            if (!mNoteOnly) {
                menu.add(0, DELETE_ID, 0, R.string.menu_delete)
                        .setShortcut('1', 'd')
                        .setIcon(android.R.drawable.ic_menu_delete);
            }
        } else {
            menu.add(0, ADD_ID, 0, R.string.menu_insert)
            .setShortcut('0', 'r')
            .setIcon(android.R.drawable.ic_menu_add);
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
        	delUser();
            finish();
            break;
        case EDIT_ID:
        	addUser();
            finish();
            break;
        case ADD_ID:
        	addUser();
            finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void delUser() {
    	Uri prodUri = ContentUris.withAppendedId(mUri, ID);
    	Log.w(" uri del ",  getIntent().getData() + "___" + prodUri);
    	getContentResolver().delete(prodUri, null, null);
	}

    private final void addUser() {
        Log.e("addUser", "addaddUser.............");
        Uri qUri;
        long inID = (long) 0;
        ContentValues values = new ContentValues();
        values.put(usuario.cliente_id_cliente, mid_cliente.getText().toString());
        values.put(usuario.nombre_usuario, mnom_usuario.getText().toString());
        values.put(usuario.tipo_usuario, mtipo_usuario.getText().toString());
        values.put(usuario.cliente_empresa_id_cliente_empresa, mid_empre.getItemIdAtPosition((int) mid_empre.getSelectedItemId()));
        values.put(usuario.clave, mclave.getText().toString());
        WebSender.sender(values);

    	Log.e("if (mState == STATE_INSERT)", "mState" + mState);
		
        if (mState == STATE_INSERT) {
        	Log.e("______________-", "uri " + mUri);
        	qUri = getContentResolver().insert(mUri, values);
	        inID = ContentUris.parseId(qUri);
	        
	        Log.e("ID _______ producto insertado", " prodid uri " + inID);
        	Log.e("______________-", "uri " + mUri);
        }
        else
        {
	        inID = Long.parseLong(mid_usuario.getText().toString());
        	Log.e("______________-", "uri " + mUri);
        	qUri = ContentUris.withAppendedId(mUri, ID);
        	getContentResolver().update(qUri,values,null,null);
        	
        }
    }
}

