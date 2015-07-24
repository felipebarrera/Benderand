package cl.webinc.benderand;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.entidad.Ventacompleta;
import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.util.CursortoArrayEntidad;
import cl.webinc.benderand.util.CustomAdapterIngresoList;
import cl.webinc.benderand.util.ProjectionCreater;

/**
 * Created by Felipe on 10-06-2015. Lista de ingresos
 */
public class IngresoList extends AppCompatActivity {
	private static final String TAG = "ventalist";
	protected ArrayList<Ventacompleta> mylist;
	private static AppMy app = AppMy.getinstance();
	private HashMap<String, String> extra = new HashMap<>();
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("ventalist", "onCreate");
		setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
		setTitle(R.string.ingresos);
		setContentView(R.layout.listatienda);
		setTitle(R.string.inventario);
		lv = (ListView) findViewById(R.id.listaproductos);
		registerForContextMenu(lv);
		lv.setOnCreateContextMenuListener(this);
		lv.setTextFilterEnabled(true);
		new sincTask().execute();
	}
	public void onItemClick(int mPosition) {
		Ventacompleta o = (Ventacompleta) lv.getItemAtPosition(mPosition);
		Intent intent = new Intent(IngresoList.this, DetalleVenta.class);
		intent.putExtra("id", o.getId_venta());
		extra.put("id", o.getId_venta());
		app.setExtra(extra);
		Log.e(TAG, "" + app.getExtra().get("_id"));
		startActivityForResult(intent, 1);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		Log.e("onActivityResult", "" + requestCode);
		new sincTask().execute();
	}
	private class sincTask extends AsyncTask<String, Void, ArrayList<Ventacompleta>>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(IngresoList.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(IngresoList.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(ArrayList<Ventacompleta> result) {
			if(result != null) {
				lv.setAdapter(new CustomAdapterIngresoList(IngresoList.this, result));
			}else {
				Toast.makeText(getApplicationContext(), "Fallo la sincronizacion", Toast.LENGTH_SHORT).show();
				Log.e("sinctask ventalista", " Fallo la sincronizacion");
			}
			dialog.dismiss();
		}
		@Override
		protected ArrayList<Ventacompleta> doInBackground(
				String... params) {
			Log.e("thread end", " thread end");
			if(!app.isExternal()){
				mylist = CursortoArrayEntidad.getinstance().aeVentacompleta(getContentResolver().query(
						Base.ventacompleta.CONTENT_URI, ProjectionCreater.pcventacompleta, null, null, Base.ventacompleta.hora_fecha_venta + " DESC"));
			}
			else
			{
				if(app.isOnline(IngresoList.this))
				{
					try {
						//mylist = WebConector.getJSONfromURL("http://" + app.getUrl() + "/index.php/sincronize/productocompleto/get_productodroid/" + app.getCarneEmpresa().getId_empresa(), "productocompleto");
						mylist = new ArrayList<>();
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
}