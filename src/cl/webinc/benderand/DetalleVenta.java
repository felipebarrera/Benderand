package cl.webinc.benderand;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import cl.webinc.benderand.entidad.VentaConArticulos;
import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.util.CurrencyFormatter;
import cl.webinc.benderand.util.CustomAdapterDetalleVenta;
import cl.webinc.benderand.util.ProjectionCreater;

/**
 * Created by FelipeBarrera on 07-07-2015. detalle venta
 */
public class DetalleVenta extends Activity{
    private ListView lv;
    private TextView txthorafechaventa;
    private TextView txttipodocumento;
    private TextView txttipopago;
    private TextView txtnarticulos;
    private TextView txttotal;
    private VentaConArticulos mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalleventa);
        setTitle(R.string.detalledeventa);
        lv = (ListView) findViewById(R.id.listadetalleventa);
        txthorafechaventa = (TextView) findViewById(R.id.txthorafechaventa);
        txttipodocumento = (TextView) findViewById(R.id.txttipodocumento);
        txttipopago = (TextView) findViewById(R.id.txttipopago);
        txtnarticulos = (TextView) findViewById(R.id.txtnarticulos);
        txttotal = (TextView) findViewById(R.id.txttotal);
        new sincTask().execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    private class sincTask extends AsyncTask<String, Void, VentaConArticulos>
    {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(DetalleVenta.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(DetalleVenta.this.getResources().getString(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
        protected void onPostExecute(VentaConArticulos result) {
            if(result != null) {
                Log.e("", "");
                CustomAdapterDetalleVenta adapter = new CustomAdapterDetalleVenta(DetalleVenta.this, result.getArticulos());
                lv.setHeaderDividersEnabled(true);
                lv.setAdapter(adapter);
                Calendar rightNow = Calendar.getInstance(new Locale("es", "CL"));
                rightNow.setTimeInMillis(Long.valueOf(result.getHora_fecha_venta()));
                txthorafechaventa.setText( rightNow.get(Calendar.DAY_OF_MONTH) + "/" + rightNow.get(Calendar.MONTH) + "/" + rightNow.get(Calendar.YEAR) + " " + rightNow.get(Calendar.HOUR) + ":"
                        + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND));
                txttipodocumento.setText(result.getNombre_tipo_documento());
                txttipopago.setText(result.getNombre_tipo_pago());
                txtnarticulos.setText(result.getNumero_articulos());
                txttotal.setText(CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", Double.valueOf(result.getTotal())));
            }else {
                finish();
            }
            dialog.dismiss();
        }
        @Override
        protected VentaConArticulos doInBackground(String... params) {
            AppMy app = AppMy.getinstance();
            Log.e("Params _____", "" );
            if(!app.isExternal()){
                mylist = new VentaConArticulos();
                mylist.VentaConArticulos(getContentResolver().query(
                        Base.ventacompleta.CONTENT_URI,
                        ProjectionCreater.pcventacompleta,
                        Base.ventacompleta.id_venta + " = ?",
                        new String[]{getIntent().getExtras().getString("id", "0")},
                        null));
                mylist.carro_ventacompleto(getContentResolver().query(
                        Base.carro_ventacompleto.CONTENT_URI,
                        ProjectionCreater.pccarro_ventacompleto,
                        Base.carro_ventacompleto.venta_id_venta + " = ?",
                        new String[]{getIntent().getExtras().getString("id","0")},
                        null));
            }
            else
            {
                if(app.isOnline(DetalleVenta.this))
                {
                    try {
                        //mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/" + app.getCarneEmpresa().getId_carne_empresa(), "carro_compras");
                        mylist =  new VentaConArticulos();
                        Log.e("doinbackground", " thread end");
                    } catch (Exception e) {
                        mylist =  new VentaConArticulos();
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
