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
import java.util.Locale;

import cl.webinc.benderand.ProductoList;
import cl.webinc.benderand.R;
import cl.webinc.benderand.entidad.Productoprecio;

/**
 * Created by FelipeBarrera on 06-07-2015. custom adapeter egresolist
 */
public class CustomAdapterProductosPrecio extends BaseAdapter implements View.OnClickListener {
    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    Productoprecio tempValues=null;
    /*************  CAdapter Constructor *****************/
    public CustomAdapterProductosPrecio(Activity a, ArrayList d) {
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
        public TextView precio_CLP;
        public TextView descripcion;
    }
    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;
        if(convertView==null){
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.productopreciolist, null);
            /****** View Holder Object to contain tabitem.xml file elements ******/
            holder = new ViewHolder();
            holder.precio_CLP=(TextView)vi.findViewById(R.id.twprecio_clp);
            holder.descripcion=(TextView)vi.findViewById(R.id.twdescripcion);
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
            tempValues = (Productoprecio) data.get( position );
            /************  Set Model values in Holder elements ***********/
            holder.precio_CLP.setText( CurrencyFormatter.getFormattedCurrencyStringForLocale(new Locale("es", "CL"), "CLP", Double.valueOf(tempValues.getPrecio_CLP())));
            holder.descripcion.setText( tempValues.getDescripcion_producto());
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
            ProductoList sct = (ProductoList)activity;
            if(data.size()<=0){
                Toast.makeText(sct.getBaseContext(), R.string.lblNoExistenItems, Toast.LENGTH_LONG).show();
            }else{
                sct.onItemClick(mPosition);
            }
        }
    }
}
