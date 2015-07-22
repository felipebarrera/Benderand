package cl.webinc.benderand;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

/**
 * Created by FelipeBarrera on 09-07-2015. Lista de usuarios
 */
public class Usuario extends AppCompatActivity {
    private static final String TAG = "Bodegalist";
    protected ArrayList<HashMap<String, String>> mylist;
    private static AppMy app = AppMy.getinstance();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("stocklist", "onCreate");
        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
        setTitle(R.string.usuarios);
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
    private class sincTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>
    {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Usuario.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
            if(result != null) {
                ListAdapter adapter = new SimpleAdapter(Usuario.this, result, R.layout.listitem,
                        new String[] { Base.usuariocompleto.nombre_persona, Base.usuariocompleto.apellido_persona, Base.usuariocompleto.segundo_apellido_persona ,
                                Base.usuariocompleto.segundo_nombre_persona },
                        new int[] { R.id.text1, R.id.text2, R.id.text4, R.id.text3 });
                lv.setAdapter(adapter);
            }else {
                Toast.makeText(getApplicationContext(), "Fallo la sincronizacion", Toast.LENGTH_SHORT).show();
                Log.e("sinctask stocklista", " Fallo la sincronizacion");
            }
            dialog.dismiss();
        }
        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(
                String... params) {
            Log.e("thread end", " thread end");
            if(!app.isExternal()){
                ProjectionCreater.getinstance();
                mylist =  CursortoArrayhash.getinstance().ahUsuariocompleto(getContentResolver().query(
                        Base.usuariocompleto.CONTENT_URI,
                        ProjectionCreater.pcusuariocompleto,
                        null,
                        null,
                        Base.usuariocompleto.apellido_persona + " ASC"));
            }
            else
            {
                if(app.isOnline(Usuario.this))
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
