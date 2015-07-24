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

import cl.webinc.benderand.entidad.Compracompleta;
import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.util.CursortoArrayEntidad;
import cl.webinc.benderand.util.CustomAdapterEgresoList;
import cl.webinc.benderand.util.ProjectionCreater;

/**
 * Created by Felipe on 25-06-2015. lista de egresos
 */
public class EgresoList extends AppCompatActivity {
	private static final String TAG = "EgresoList";
	protected ArrayList<Compracompleta> mylist;
	private static AppMy app = AppMy.getinstance();
	private HashMap<String, String> extra = new HashMap<>();
    private ListView lv;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("ListaCompras", "onCreate");
		setTitle(R.string.egresos);
		setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
		setContentView(R.layout.listatienda);
		setTitle(R.string.inventario);
		lv = (ListView) findViewById(R.id.listaproductos);
		registerForContextMenu(lv);
		lv.setOnCreateContextMenuListener(this);
		lv.setTextFilterEnabled(true);
		new sincTask().execute();
	}
    public void onItemClick(int mPosition) {
        Compracompleta o = (Compracompleta) lv.getItemAtPosition(mPosition);
        Intent intent = new Intent(EgresoList.this, DetalleCompra.class);
        intent.putExtra("id", o.getId_factura());
        extra.put("id", o.getId_factura());
        app.setExtra(extra);
        Log.e(TAG, "" + app.getExtra().get("_id"));
        startActivityForResult(intent, 1);
    }
	private class sincTask extends AsyncTask<String, Void, ArrayList<Compracompleta>>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(EgresoList.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(EgresoList.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(ArrayList<Compracompleta> result) {
			if(result != null) {
				lv.setAdapter(new CustomAdapterEgresoList(EgresoList.this, result));
			}else {
				Toast.makeText(getApplicationContext(), "Fallo la sincronizacion", Toast.LENGTH_SHORT).show();
				Log.e("sinctask ventalista", " Fallo la sincronizacion");
			}
			dialog.dismiss();
		}
		@Override
		protected ArrayList<Compracompleta> doInBackground(
				String... params) {
			Log.e("thread end", " thread end");
			if(!app.isExternal()){
				mylist = CursortoArrayEntidad.getinstance().aeCompracompleta(getContentResolver().query(
                        Base.compracompleta.CONTENT_URI, ProjectionCreater.pccompracompleta, null, null, Base.compracompleta.fecha_factura + " DESC"));
			}
			else
			{
				if(app.isOnline(EgresoList.this))
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

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		Log.e("onActivityResult", "" + requestCode);
		new sincTask().execute();
	}
}