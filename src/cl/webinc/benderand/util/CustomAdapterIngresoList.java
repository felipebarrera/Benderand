package cl.webinc.benderand.util;

/**
 * Created by FelipeBarrera on 06-07-2015.
 * egresolist custom adapter
 */

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import cl.webinc.benderand.IngresoList;
import cl.webinc.benderand.R;
import cl.webinc.benderand.entidad.Ventacompleta;

public class CustomAdapterIngresoList extends BaseAdapter implements View.OnClickListener {
    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    Ventacompleta tempValues=null;
    /*************  CAdapter Constructor *****************/
    public CustomAdapterIngresoList(Activity a, ArrayList d) {
        /********** Take passed values **********/
        activity = a;
        data=d;
        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {
        if(data.size()<=0)
            return 1;
        return data.size();
    }
    public Object getItem(int position) {
        if(data.size()>0) {
            return data.get(position);
        }
    }
    public long getItemId(int position) {
        return position;
    }
    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{
        public TextView fecha;
        public TextView tdocumento;
        public TextView tpago;
        public TextView narticulos;
        public TextView total;
    }
    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;
        if(convertView==null){
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.ingresolist, null);
            /****** View Holder Object to contain tabitem.xml file elements ******/
            holder = new ViewHolder();
            holder.fecha=(TextView)vi.findViewById(R.id.twhora_fecha_venta);
            holder.tdocumento=(TextView)vi.findViewById(R.id.twtipo_documento);
            holder.tpago=(TextView)vi.findViewById(R.id.twtipo_pago);
            holder.narticulos=(TextView)vi.findViewById(R.id.twnumero_articulos);
            holder.total=(TextView)vi.findViewById(R.id.twtotal);
            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();
        if(data.size()<=0)
        {
            holder.fecha.setText(R.string.lblNoExistenItems);
        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = (Ventacompleta) data.get( position );

            /************  Set Model values in Holder elements ***********/

            Calendar rightNow = Calendar.getInstance(new Locale("es", "CL"));
            rightNow.setTimeInMillis(Long.valueOf(tempValues.getHora_fecha_venta()));
            holder.fecha.setText( rightNow.get(Calendar.DAY_OF_MONTH) + "/" + rightNow.get(Calendar.MONTH) + "/" + rightNow.get(Calendar.YEAR) + " " + rightNow.get(Calendar.HOUR) + ":"
                    + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND));
            holder.tdocumento.setText( tempValues.getNombre_tipo_documento() );
            holder.tpago.setText( tempValues.getNombre_tipo_pago() );
            holder.narticulos.setText( "N° Articulos " + tempValues.getNumero_articulos());
            holder.total.setText( "Total Venta " + CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", Double.valueOf(tempValues.getTotal())) );

            /******** Set Item Click Listner for LayoutInflater for each row *******/

            vi.setOnClickListener(new OnItemClickListener(position));
        }
        return vi;
    }
    @Override
    public void onClick(View v) {
        Log.e("cadapteringresolist", "=====Row button clicked=====");
    }
    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;
        OnItemClickListener(int position){
            mPosition = position;
        }
        @Override
        public void onClick(View arg0) {
            IngresoList sct = (IngresoList)activity;
            if(data.size()<=0){
                Toast.makeText(activity.getBaseContext(), R.string.lblNoExistenItems, Toast.LENGTH_LONG).show();
            }else{
                sct.onItemClick(mPosition);
            }
        }
    }
}