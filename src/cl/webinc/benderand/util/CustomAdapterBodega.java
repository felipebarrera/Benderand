package cl.webinc.benderand.util;

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

import cl.webinc.benderand.Bodega;
import cl.webinc.benderand.R;
import cl.webinc.benderand.entidad.Stockcompleto;

/**
 * Created by FelipeBarrera on 06-07-2015. custom adapeter egresolist
 */
public class CustomAdapterBodega extends BaseAdapter implements View.OnClickListener {
    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    Stockcompleto tempValues=null;
    /*************  CAdapter Constructor *****************/
    public CustomAdapterBodega(Activity a, ArrayList d) {
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
        public TextView stock_tienda;
        public TextView descripcion;
        public TextView last_update;
    }
    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;
        if(convertView==null){
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.bodegalist, null);
            /****** View Holder Object to contain tabitem.xml file elements ******/
            holder = new ViewHolder();
            holder.stock_tienda=(TextView)vi.findViewById(R.id.twstock_tienda);
            holder.descripcion=(TextView)vi.findViewById(R.id.twdescripcion);
            holder.last_update=(TextView)vi.findViewById(R.id.twlast_update);
            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();
        if(data.size()<=0)
        {
            holder.descripcion.setText(R.string.lblNoExistenItems);
        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = (Stockcompleto) data.get( position );
            /************  Set Model values in Holder elements ***********/
            Calendar rightNow = Calendar.getInstance(new Locale("es", "CL"));
            rightNow.setTimeInMillis(Long.valueOf(tempValues.getLast_update()));
            holder.stock_tienda.setText( tempValues.getStock_tienda());
            holder.descripcion.setText( tempValues.getDescripcion_producto());
            holder.last_update.setText( "Actualizado " + rightNow.get(Calendar.DAY_OF_MONTH) + "/" + rightNow.get(Calendar.MONTH) + "/" + rightNow.get(Calendar.YEAR) + " " + rightNow.get(Calendar.HOUR) + ":"
                    + rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND));
            /******** Set Item Click Listner for LayoutInflater for each row *******/
            vi.setOnClickListener(new OnItemClickListener( position ));
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
            Bodega sct = (Bodega)activity;
            if(data.size()<=0){
                Toast.makeText(sct.getBaseContext(), R.string.lblNoExistenItems, Toast.LENGTH_LONG).show();
            }else{
                sct.onItemClick(mPosition);
            }
        }
    }
}
