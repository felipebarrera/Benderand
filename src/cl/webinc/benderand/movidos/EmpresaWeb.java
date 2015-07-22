package cl.webinc.benderand.movidos;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;

import cl.webinc.benderand.R;
import cl.webinc.benderand.provider.Base.empresa;
import cl.webinc.benderand.sync.WebConector;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class EmpresaWeb extends ListActivity {


	protected ArrayList<HashMap<String, String>> mylist;
	private String web;
	private String lista;

	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        web = getIntent().getStringExtra("ip");
        lista = getIntent().getStringExtra("lista");
        new sincTask().execute();
        
        final ListView lv = getListView();
        Log.e("ListView", " return");
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                @SuppressWarnings("unchecked")
                HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);
                Toast.makeText(EmpresaWeb.this, "ID '" + o.get("id") + "' was clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

private class sincTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>  
{
	@Override
	 protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
		if(result != null) {
	        ListAdapter adapter = new SimpleAdapter(EmpresaWeb.this, result, R.layout.listitem,
	                new String[] { empresa.nombre_empresa, empresa.rut_empresa }, new int[] { android.R.id.text1, android.R.id.text2 });
	        setListAdapter(adapter);
	        Log.e("not null", " not null");
	        }else {
	            Log.e("terrible null", " return");
	        }
	 }

	@Override
	protected ArrayList<HashMap<String, String>> doInBackground(
			String... params) {
		Log.e("thread end", " thread end");
         try {
			mylist = WebConector.getJSONfromURL("http://"+ web +"/index.php/sincronize/"+ lista +"/get_Producto/", "productocompleto");
		} catch (JSONException e) {
			mylist = new ArrayList<HashMap<String, String>>();
			Log.e("json", " array list" + e);
		}
         return mylist;
	}
 }
}