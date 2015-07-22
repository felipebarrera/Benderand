package cl.webinc.benderand;

import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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

import cl.webinc.benderand.provider.Base.carro_compras;
import cl.webinc.benderand.provider.Base.producto;
import cl.webinc.benderand.provider.Base.productoprecio;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;


public class ListaProductos extends AppCompatActivity {
	private static final String TAG = "ListaProductos";
	protected ArrayList<HashMap<String, String>> mylist;
	private HashMap<String, String> map = new HashMap<>();

	private static AppMy app = AppMy.getinstance();
	private EditText mcant;
	protected String cantidad;
	private ListView lv;
	protected int TYPEBTN;

	// Menu item ids
	public static final int MENU_ITEM_MOD = Menu.FIRST;
	public static final int MENU_ITEM_DELETE = Menu.FIRST + 1;
	private EditText inputSearch;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
		setContentView(R.layout.listatienda);
		setTitle(R.string.stringproductos);
		lv = (ListView) findViewById(R.id.listaproductos);
		lv.setOnCreateContextMenuListener(this);
		registerForContextMenu(lv);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
				final Dialog dialog = new Dialog(ListaProductos.this);
				dialog.setContentView(R.layout.dialognumberpicker);
				dialog.setTitle(R.string.lblagregueunacantidad);

				// set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(R.string.lblseleccioneunacantidad);
				mcant = (EditText) dialog.findViewById(R.id.editcant);
				mcant.setText("1");

				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						if (mcant.getText().toString().isEmpty()) {
							Toast.makeText(ListaProductos.this, R.string.lbldebesingresarunnumero, Toast.LENGTH_LONG).show();
						} else {
							cantidad = mcant.getText().toString();
							Log.e("position", "" + position + " mylist size " + mylist.size() + "cantidad " + cantidad);
							HashMap<String, String> producto = mylist.get(position);
                            map.put(carro_compras.producto_id_producto, producto.get(productoprecio.id_producto));
                            map.put(carro_compras.usado, "0");
                            map.put(carro_compras.tienda, "1");
                            map.put(carro_compras.mayor, "0");
                            map.put(carro_compras.cantidad_carro, cantidad);
                            map.put(carro_compras.carne_empresa_id_carne_empresa, app.getCarneEmpresa().getId_carne_empresa());
                            map.put(carro_compras.empresa_id_empresa, producto.get(productoprecio.empresa_id_empresa));
                            map.put(productoprecio.precio_mayor_CLP, producto.get(productoprecio.precio_mayor_CLP));
                            map.put(productoprecio.precio_CLP, producto.get(productoprecio.precio_CLP));
                            map.put(productoprecio.cantidad_mayor, producto.get(productoprecio.cantidad_mayor));
                            //stock
                            if(Long.valueOf(cantidad) > Long.valueOf(producto.get(productoprecio.stock_tienda))){
                                Toast.makeText(ListaProductos.this, R.string.lbllacantidadexcedeelinventarioregistrado, Toast.LENGTH_LONG).show();
                            }
							dialog.dismiss();
                            new addprod().execute();
						}
					}
				});
				dialog.show();
			}
		});
		lv.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
			public void onCreateContextMenu(ContextMenu menu, View v,
											ContextMenuInfo menuInfo) {
				AdapterView.AdapterContextMenuInfo info;
				try {
					info = (AdapterView.AdapterContextMenuInfo) menuInfo;
					Log.e(TAG, "bad menuInfo" + info.position);
				} catch (ClassCastException e) {
					Log.e(TAG, "bad menuInfo", e);
					return;
				}
				// Setup the menu header
				menu.setHeaderTitle(R.string.lblopciones);
				// Add a menu item to delete the note
				menu.add(0, MENU_ITEM_MOD, 0, R.string.menu_modificar);
				menu.add(0, MENU_ITEM_DELETE, 0, R.string.menu_delete);

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
		btnscan.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				TYPEBTN = 0;
				Log.e("1", "TYPEBTN0 " + TYPEBTN);
				final Intent intent = new Intent("com.google.zxing.client.android.SCAN");
				intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "ONE_D_MODE");
				//intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);
			}
		});
		Intent intent = getIntent();
		if (intent.getData() == null) {
			intent.setData(producto.CONTENT_URI);
		}
		new sincTask().execute();
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK)
		{
			if(data != null)
			{
				inputSearch.setText(data.getStringExtra("SCAN_RESULT"));
			}
		}
		else
		{
			new sincTask().execute();
		}
	}
	private class addprod extends AsyncTask<String, Void, Boolean>
	{
		private boolean login;
		private Double cant;
		private Double cantidad_mayor;
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(ListaProductos.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(ListaProductos.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(Boolean result)
		{
			//Toast.makeText(getApplicationContext(), "actualizado", Toast.LENGTH_SHORT).show();
			dialog.dismiss();
			finish();
		}
		@Override
		protected Boolean doInBackground(
				String... params) {
			app = AppMy.getinstance();
			if(!app.isExternal()){
				Cursor cursor = getContentResolver().query(
						carro_compras.CONTENT_URI, ProjectionCreater.pccarro_compras,
						carro_compras.producto_id_producto + " = ? and "+ carro_compras.empresa_id_empresa + " = ? and " + carro_compras.carne_empresa_id_carne_empresa + " = ? and usado = 0",
						new String[]{map.get(carro_compras.producto_id_producto),map.get(carro_compras.empresa_id_empresa), map.get(carro_compras.carne_empresa_id_carne_empresa)},
						carro_compras.DEFAULT_ORDEN);
				Log.e("addcarro_compras  ", "busca articulos en carro " + cursor.getCount());
				if(cursor.getCount() == 0)
				{
					Log.e(TAG, "" + Double.valueOf(map.get(productoprecio.cantidad_mayor)));
					cant = Double.valueOf(map.get(carro_compras.cantidad_carro));
					cantidad_mayor = Double.valueOf(map.get(productoprecio.cantidad_mayor));
					if(cant >= cantidad_mayor)
					{
						map.put(carro_compras.precio_carro, map.get(productoprecio.precio_mayor_CLP));
						map.put(carro_compras.mayor, "1");
					}
					else
					{
						map.put(carro_compras.precio_carro, map.get(productoprecio.precio_CLP));
						map.put(carro_compras.mayor, "0");
					}
					String idcarro = String.valueOf(getContentResolver().insert(
							carro_compras.CONTENT_URI, PostData.getinstance().postdataready(map, Constantes.CARRO_COMPRAS_TABLE_NAME)).getLastPathSegment());
					Log.e("Carro insertado", "" + idcarro + " precio" + map.get(carro_compras.mayor) + " " + map.get(carro_compras.precio_carro));
				}
				else
				{
					cursor.moveToFirst();
					ContentValues values = new ContentValues();
					cant = Double.valueOf(cursor.getString(cursor.getColumnIndex(carro_compras.cantidad_carro))) + Double.valueOf(map.get(carro_compras.cantidad_carro));
					cantidad_mayor = Double.valueOf(map.get(productoprecio.cantidad_mayor));
					Log.e("cantidad carro up ", "" + cant + cantidad_mayor);
					if(cant >= cantidad_mayor)
					{
						values.put(carro_compras.precio_carro, map.get(productoprecio.precio_mayor_CLP));
						values.put(carro_compras.mayor, "1");
					}
					else
					{
						values.put(carro_compras.precio_carro, map.get(productoprecio.precio_CLP));
						values.put(carro_compras.mayor, "0");
					}
					values.put(carro_compras.cantidad_carro, cant);
					String idcarro = String.valueOf(getContentResolver().update(
							carro_compras.CONTENT_URI, values,
							carro_compras.id_carro_compras + " = ?",
							new String[]{cursor.getString(cursor.getColumnIndex(carro_compras.id_carro_compras))}));
					Log.e("Carro actualizado", "" + idcarro);
				}
				cursor.close();
			}
			else
			{
				if(app.isOnline(ListaProductos.this))
				{
					login = WebConector.sendData("http://" + app.getUrl() +"/index.php/androidtienda/savecarrodroid/" , map, "prodcarro");
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
				}
			}
			return login;
		}
	}
	private class sincTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(ListaProductos.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(ListaProductos.this.getResources().getString(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
		}
		@Override
		protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
			if(result != null) {
				ListAdapter adapter = new SimpleAdapter(ListaProductos.this, result, R.layout.listitem,
						new String[] { productoprecio.stock_tienda, productoprecio.codigo_producto, productoprecio.precio_CLP , productoprecio.descripcion_producto },
						new int[] { R.id.text1, R.id.text2, R.id.text4, R.id.text3 });
				lv.setAdapter(adapter);
				Log.e("Lista productos sinc", " not null");
			}else {
				Log.e("terrible null", " return");
			}
			dialog.dismiss();
		}
		@Override
		protected ArrayList<HashMap<String, String>> doInBackground(
				String... params) {
			app = AppMy.getinstance();
			if(!app.isExternal()){
				mylist = CursortoArrayhash.getinstance().ahProductoprecio(getContentResolver().query(
                        productoprecio.CONTENT_URI,
                        ProjectionCreater.pcproductoprecio,
                        productoprecio.stock_tienda + " > 0 ",
                        null,
                        productoprecio.DEFAULT_ORDEN));
			}
			else
			{
				if(app.isOnline(ListaProductos.this))
				{
					try {
						mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/sincronize/productocompleto/get_Producto/", "productocompleto");
					} catch (JSONException e) {
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
}
