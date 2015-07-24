package cl.webinc.benderand;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.provider.Base.carro_egresos;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class ListaProductosCompra extends AppCompatActivity {
	private static final String TAG = "ListaProductosCompra";
	protected ArrayList<HashMap<String, String>> mylist;
	private HashMap<String, String> map = new HashMap<String, String>();
	private static AppMy app = AppMy.getinstance();
	private HashMap<String, String> extra = app.getExtra();
	private ListView lv;
	protected int TYPEBTN;
	public static final int MENU_ITEM_DELETE = Menu.FIRST + 1;
	public static final int MENU_ITEM_INSERT = Menu.FIRST + 2;
	private EditText inputSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
		setContentView(R.layout.listatienda);
		setTitle(R.string.stringproductos);
		lv = (ListView) findViewById(R.id.listaproductos);
		registerForContextMenu(lv);
		lv.setOnCreateContextMenuListener(this);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
				final Dialog dialog = new Dialog(ListaProductosCompra.this);
				dialog.setContentView(R.layout.dialognumberpreciopicker);
				dialog.setTitle(R.string.lblAgreguedatosdeitem);
				// set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(R.string.lblagregueunacantidad);
				TextView text2 = (TextView) dialog.findViewById(R.id.text2);
				text2.setText(R.string.lblIngresepreciobruto);
				final EditText mcant = (EditText) dialog.findViewById(R.id.editcant);
				final EditText mprecio = (EditText) dialog.findViewById(R.id.editprecio);
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						if (mcant.getText().toString().isEmpty()) {
							Toast.makeText(ListaProductosCompra.this, R.string.lbldebesingresarunnumero, Toast.LENGTH_LONG).show();
						}
						else if (mprecio.getText().toString().isEmpty()) {
							Toast.makeText(ListaProductosCompra.this, R.string.lbldebesingresarunprecio, Toast.LENGTH_LONG).show();
						} else {
							dialog.dismiss();
							String cantidad = mcant.getText().toString();
							HashMap<String, String> producto = mylist.get(position);
							Log.e("Log_____", " " + producto.get(Base.productocompra.id_producto) + " " + producto.get(Base.productocompra.id_producto));
							map.put(carro_egresos.producto_id_producto, producto.get(Base.productocompra.id_producto));
							map.put(carro_egresos.usado, "0");
							map.put(carro_egresos.tienda, "1");
							map.put(carro_egresos.cantidad_carro, cantidad);
							map.put(carro_egresos.carne_empresa_id_carne_empresa, app.getCarneEmpresa().getId_carne_empresa());
							map.put(carro_egresos.empresa_id_empresa, app.getCarneEmpresa().getId_empresa());
							map.put(carro_egresos.mayor, "0");
							map.put(carro_egresos.precio_carro, mprecio.getText().toString());
							new addprod().execute();
						}
					}
				});
				dialog.show();
			}
		});
		inputSearch = (EditText) findViewById(R.id.etfiltroProductostienda);
		inputSearch.addTextChangedListener(new TextWatcher() {
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(!inputSearch.getText().toString().isEmpty()){
					((SimpleAdapter) lv.getAdapter()).getFilter().filter(s);
				}
			}
			public void afterTextChanged(Editable s) {
			}
		});
		Button btnscan = (Button) findViewById(R.id.btnscan);
		btnscan.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				TYPEBTN = 0;
				Log.e("1", "TYPEBTN0 " + TYPEBTN);
				final Intent intent = new Intent("com.google.zxing.client.android.SCAN");
				intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "ONE_D_MODE");
				startActivityForResult(intent, 0);
			}
		});
		Intent intent = getIntent();
		if (intent.getData() == null) {
			intent.setData(carro_egresos.CONTENT_URI);
		}
		new sincTask().execute();
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			if(data != null){
				inputSearch.setText(data.getStringExtra("SCAN_RESULT"));
			}
		}
		else{
			new sincTask().execute();
		}
	}

	private class addprod extends AsyncTask<String, Void, Boolean>{
		private boolean login;
		private Double cant;
		ProgressDialog dialog;
		@Override
		protected void onPreExecute(){
			dialog = new ProgressDialog(ListaProductosCompra.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(ListaProductosCompra.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(Boolean result){
			//Toast.makeText(getApplicationContext(), "actualizado", Toast.LENGTH_SHORT).show();
			dialog.dismiss();
			finish();
		}
		@Override
		protected Boolean doInBackground(String... params){
			app = AppMy.getinstance();
			if(!app.isExternal()){
				Cursor cursor = getContentResolver().query(
						carro_egresos.CONTENT_URI, ProjectionCreater.pccarro_egresos,
						carro_egresos.producto_id_producto + " = ? and " + carro_egresos.empresa_id_empresa + " = ? and " + carro_egresos.carne_empresa_id_carne_empresa + " = ? and usado = 0",
						new String[]{map.get(carro_egresos.producto_id_producto), map.get(carro_egresos.empresa_id_empresa), map.get(carro_egresos.carne_empresa_id_carne_empresa)},
						carro_egresos.DEFAULT_ORDEN);
				Log.e("addcarro_compras  ", "busca articulos en carro " + cursor.getCount());
				if(cursor.getCount() == 0){
					cant = Double.valueOf(map.get(carro_egresos.cantidad_carro));
					Log.e("cantidad carro in ", "" + cant);
					map.put(carro_egresos.precio_carro, map.get(carro_egresos.precio_carro));
					String idcarro = String.valueOf(getContentResolver().insert(
							carro_egresos.CONTENT_URI, PostData.getinstance().postdataready(map, Constantes.CARRO_EGRESOS_TABLE_NAME)).getLastPathSegment());
					Log.e("Carro insertado", "" + idcarro);
				}
				else{
					cursor.moveToFirst();
					ContentValues values = new ContentValues();
					cant = Double.valueOf(cursor.getString(cursor.getColumnIndex(carro_egresos.cantidad_carro))) + Double.valueOf(map.get(carro_egresos.cantidad_carro));
					Log.e("cantidad carro up ", "" + cant);
					values.put(carro_egresos.precio_carro, map.get(carro_egresos.precio_carro));
					values.put(carro_egresos.mayor, "0");
					values.put(carro_egresos.cantidad_carro, cant);
					String idcarro = String.valueOf(getContentResolver().update(
							carro_egresos.CONTENT_URI, values,
							carro_egresos.id_carro_egresos + " = ?",
							new String[]{cursor.getString(cursor.getColumnIndex(carro_egresos.id_carro_egresos))}));
					Log.e("Carro actualizado", "" + idcarro);
				}
				cursor.close();
			}
			else{
				if(app.isOnline(ListaProductosCompra.this)){
					login = WebConector.sendData("http://" + app.getUrl() +"/index.php/androidtienda/savecarrodroid/" , map, "prodcarro");
				}
				else{
					Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
				}
			}
			return login;
		}
	}
	private class sincTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(ListaProductosCompra.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(ListaProductosCompra.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
			if(result != null) {
				ListAdapter adapter = new SimpleAdapter(ListaProductosCompra.this, result, R.layout.listitem,
						new String[] { Base.productocompra.codigo_producto, Base.productocompra.descripcion_producto},
						new int[] { R.id.text1, R.id.text2});
				lv.setAdapter(adapter);
				Log.e("Lista productos sinc", " not null");
			}else {
				Log.e("terrible null", " return");
			}
			dialog.dismiss();
		}
		@Override
		protected ArrayList<HashMap<String, String>> doInBackground(String... params) {
			app = AppMy.getinstance();
			if(!app.isExternal()){
				Cursor cursor = getContentResolver().query(Base.productocompra.CONTENT_URI, ProjectionCreater.pcproductocompra, null, null, Base.productocompra.id_producto + " ASC");
				mylist = CursortoArrayhash.getinstance().ahProductocompra(cursor);
			}
			else{
				if(app.isOnline(ListaProductosCompra.this))	{
					try {
						mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/sincronize/productocompleto/get_Producto/", "productocompleto");
					} catch (JSONException e) {
						mylist = new ArrayList<HashMap<String, String>>();
						Log.e("json", " array list" + e);
					}
				}
				else{
					Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
				}
			}
			return mylist;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_ITEM_INSERT, 0, R.string.menu_insert)
				.setShortcut('3', 'a')
				.setIcon(android.R.drawable.ic_menu_add)
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
				Intent i = new Intent(this, ProductocompraEditor.class);
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
