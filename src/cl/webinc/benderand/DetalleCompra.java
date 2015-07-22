package cl.webinc.benderand;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import cl.webinc.benderand.entidad.CompraConArticulos;
import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.util.CurrencyFormatter;
import cl.webinc.benderand.util.CustomAdapterDetalleCompra;
import cl.webinc.benderand.util.ProjectionCreater;

/**
 * Created by FelipeBarrera on 07-07-2015. detalle venta
 */
public class DetalleCompra extends AppCompatActivity {
    private ListView lv;
    private TextView txtfecha_factura;
    private TextView txttipodocumento;
    private TextView txttipopago;
    private TextView txtrutproveedor;
    private TextView txttelefonoproveedor;
    private TextView txtnombreproveedor;
    private TextView txttotalcompra;
    private CompraConArticulos mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallecompra);
        setTitle(R.string.detalledecompra);
        lv = (ListView) findViewById(R.id.listadetallecompra);
        txtfecha_factura = (TextView) findViewById(R.id.txtfecha_factura);
        txttipodocumento = (TextView) findViewById(R.id.txtnombredocumento);
        txttipopago = (TextView) findViewById(R.id.txtnombrepago);
        txtrutproveedor = (TextView) findViewById(R.id.txtrutproveedor);
        txtnombreproveedor = (TextView) findViewById(R.id.txtnombreproveedor);
        txttelefonoproveedor = (TextView) findViewById(R.id.txttelefonoproveedor);
        txttotalcompra = (TextView) findViewById(R.id.txttotalcompra);
        new sincTask().execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    private class sincTask extends AsyncTask<String, Void, CompraConArticulos>
    {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(DetalleCompra.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(DetalleCompra.this.getResources().getString(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
        protected void onPostExecute(CompraConArticulos result) {
            if(result != null) {
                Log.e("a", "a");
                CustomAdapterDetalleCompra adapter = new CustomAdapterDetalleCompra(DetalleCompra.this, result.getArticulos());
                lv.setHeaderDividersEnabled(true);
                lv.setAdapter(adapter);
                Calendar rightNow = Calendar.getInstance(new Locale("es", "CL"));
                rightNow.setTimeInMillis(Long.valueOf(result.getFecha_factura()));
                txtfecha_factura.setText(rightNow.get(Calendar.DAY_OF_MONTH) + "/" + rightNow.get(Calendar.MONTH) + "/" + rightNow.get(Calendar.YEAR) + " " + rightNow.get(Calendar.HOUR) + ":"
                        + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND));
                txttipodocumento.setText(result.getNombre_tipo_documento());
                txttipopago.setText(result.getNombre_tipo_pago());
                txtrutproveedor.setText(result.getRut_proveedor());
                txtnombreproveedor.setText(result.getNombre_proveedor());
                txttelefonoproveedor.setText(result.getTelefono_proveedor());
                txttotalcompra.setText(CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", Double.valueOf(result.getTotal_factura())));
            }else {
                finish();
            }
            dialog.dismiss();
        }
        @Override
        protected CompraConArticulos doInBackground(String... params) {
            AppMy app = AppMy.getinstance();
            Log.e("Params _____", "" );
            if(!app.isExternal()){
                mylist = new CompraConArticulos();
                mylist.CompraConArticulos(getContentResolver().query(
                        Base.compracompleta.CONTENT_URI,
                        ProjectionCreater.pccompracompleta,
                        Base.compracompleta.id_factura + " = ?",
                        new String[]{getIntent().getExtras().getString("id", "0")},
                        null));
                mylist.item_facturacompleto(getContentResolver().query(
                        Base.item_facturacompleto.CONTENT_URI,
                        ProjectionCreater.pcitem_facturacompleto,
                        Base.item_facturacompleto.factura_id_factura + " = ?",
                        new String[]{getIntent().getExtras().getString("id", "0")},
                        null));
            }
            else
            {
                if(app.isOnline(DetalleCompra.this))
                {
                    try {
                        //mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/" + app.getCarneEmpresa().getId_carne_empresa(), "carro_compras");
                        mylist =  new CompraConArticulos();
                        Log.e("doinbackground", " thread end");
                    } catch (Exception e) {
                        mylist =  new CompraConArticulos();
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
