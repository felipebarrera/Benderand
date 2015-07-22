package cl.webinc.benderand.util;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import cl.webinc.benderand.Comprar;
import cl.webinc.benderand.R;
import cl.webinc.benderand.Vender;
import cl.webinc.benderand.entidad.Carro_ventacompleto;

public class CustomAdapterDetalleVenta extends BaseAdapter implements OnClickListener {
    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    Carro_ventacompleto tempValues=null;
    /*************  cadapter Constructor *****************/
    public CustomAdapterDetalleVenta(Activity a, ArrayList d) {
        /********** Take passed values **********/
        activity = a;
        data=d;
        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {
        if(data.size()<=0)
            return 1;
        return data.size();
    }
    public Object getItem(int position) {
        return data.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{
        public TextView text1;
        public TextView text2;
        public TextView text3;
        public TextView text4;
        public TextView text5;
    }
    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;
        if(convertView==null){
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.listaitemproducto, null);
            /****** View Holder Object to contain tabitem.xml file elements ******/
            holder = new ViewHolder();
            holder.text1=(TextView)vi.findViewById(R.id.tcantidadcarro);
            holder.text2=(TextView)vi.findViewById(R.id.tdescripcioncarro);
            holder.text3=(TextView)vi.findViewById(R.id.tbruto);
            holder.text4=(TextView)vi.findViewById(R.id.timpuesto);
            holder.text5=(TextView)vi.findViewById(R.id.ttotal);
            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();
        if(data.size()<=0)
        {
            holder.text2.setText(R.string.lblNoExistenItems);
        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = ( Carro_ventacompleto ) data.get( position );
            /************  Set Model values in Holder elements ***********/
            holder.text1.setText( tempValues.getCantidad_carro());
            holder.text2.setText( tempValues.getDescripcion_producto());
            double cant = Double.valueOf(tempValues.getCantidad_carro());
            double br = Double.valueOf(tempValues.getPrecio_carro());
            Double impuesto = br * 0.19 * cant;
            double total = (br * cant);
            holder.text3.setText( CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", br) );
            holder.text4.setText( CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", impuesto) );
            holder.text5.setText( CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", total) );
            /******** Set Item Click Listner for LayoutInflater for each row *******/
            vi.setOnClickListener(new OnItemClickListener( position ));
        }
        return vi;
    }
    @Override
    public void onClick(View v) {
        Log.v("Cadapterventas", "=====Row button clicked=====");
    }
    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements OnClickListener{
        private int mPosition;
        OnItemClickListener(int position){
            mPosition = position;
        }
        @Override
        public void onClick(View arg0) {
            Vender sct = (Vender)activity;
            if(data.size()<=0){
                Toast.makeText(activity.getBaseContext(), R.string.lblNoExistenItems, Toast.LENGTH_LONG).show();
            }else{
                sct.onItemClick(mPosition);
            }
        }
    }
}