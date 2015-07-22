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

import cl.webinc.benderand.entidad.Stockcompleto;
import cl.webinc.benderand.provider.Base.stock;
import cl.webinc.benderand.provider.Base.stockcompleto;
import cl.webinc.benderand.util.CursortoArrayEntidad;
import cl.webinc.benderand.util.CustomAdapterBodega;
import cl.webinc.benderand.util.ProjectionCreater;

public class Bodega extends AppCompatActivity {
    private static final String TAG = "Bodegalist";
    protected ArrayList<Stockcompleto> mylist;
    private static AppMy app = AppMy.getinstance();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
        setContentView(R.layout.listatienda);
        setTitle(R.string.inventario);
        lv = (ListView) findViewById(R.id.listaproductos);
        registerForContextMenu(lv);
        lv.setOnCreateContextMenuListener(this);
        lv.setTextFilterEnabled(true);
        new sincTask().execute();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult", "" + requestCode);
        new sincTask().execute();
    }
    public void onItemClick(int mPosition) {
        Log.e(TAG,"" + mPosition);
    }
    private class sincTask extends AsyncTask<String, Void, ArrayList<Stockcompleto>>
    {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Bodega.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
        protected void onPostExecute(ArrayList<Stockcompleto> result) {
            if(result != null) {
               lv. setAdapter(new CustomAdapterBodega(Bodega.this, result));
            }else {
                Toast.makeText(getApplicationContext(), "Fallo la sincronizacion", Toast.LENGTH_SHORT).show();
                Log.e("sinctask stocklista", " Fallo la sincronizacion");
            }
            dialog.dismiss();
        }
        @Override
        protected ArrayList<Stockcompleto> doInBackground(
                String... params) {
            Log.e("thread end", " thread end");
            if(!app.isExternal()){
                ProjectionCreater.getinstance();
                mylist =  CursortoArrayEntidad.getinstance().aeStockcompleto(getContentResolver().query(
                        stockcompleto.CONTENT_URI,
                        ProjectionCreater.pcstockcompleto,
                        null,
                        null,
                        stock.stock_real + " ASC"));
            }
            else
            {
                if(app.isOnline(Bodega.this))
                {
                    try {
                        //mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/sincronize/productocompleto/get_productodroid/" + app.getCarneEmpresa().getId_empresa(), "productocompleto");
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
