package cl.webinc.benderand.movidos;

import cl.webinc.benderand.ListaProductos;
import cl.webinc.benderand.R;
import cl.webinc.benderand.provider.Base.carro_compras;
import cl.webinc.benderand.provider.Base.producto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class CarroCompraList extends Activity
{
    private Button btnAgregar;
    private ListView lv;
    private TextView txtvalortotal;
	private static final String[] PROJECTION = new String[] {
		carro_compras.id_carro_compras, // 0
		carro_compras.empresa_id_empresa, // 2
		carro_compras.producto_id_producto, // 3
		carro_compras.cantidad_carro, // 4
		carro_compras.usuario_id_usuario, // 5
		carro_compras.precio_carro, // 6
};

    @Override
	protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrocompralist);
        lv = (ListView) findViewById(R.id.listViewCarro);
        txtvalortotal = (TextView) findViewById(R.id.txtvalortotal);
        Intent intent = getIntent();
        intent.setData(carro_compras.CONTENT_URI);
	}
    @Override
    protected void onResume ()
    {
    	super.onResume();
        Log.e("getIntent().getData() ", "" + getIntent().getData());
        // Inform the list we provide context menus for items
        
        // Perform a managed query. The Activity will handle closing and requerying the cursor
        // when needed.
        final Cursor cursor = managedQuery(getIntent().getData(), PROJECTION, null, null,
        		carro_compras.DEFAULT_ORDEN);

        // Used to map notes entries from the database to views
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.listacompras, cursor,
                new String[] { producto.nombre_producto, carro_compras.cantidad_carro, carro_compras.precio_carro}, 
                new int[] { R.id.text4, R.id.text5, R.id.text6, R.id.txttotal });
        if(cursor.moveToFirst())
        {
        	Log.w("0", "" + cursor.getString(0));
        	Log.w("1", "" + cursor.getString(1));
        	Log.w("2", "" + cursor.getString(2));
        	txtvalortotal.setText(cursor.getString(0));
        }
        Log.w("", "" + adapter);
		Log.w("lv", "lv" + lv);
        if(adapter != null)
        {
            Log.w("adapter", "adapter" + adapter);
        	if(lv == null)
        	{
        		Log.w("lv", "lv" + lv);
        	}
        }
        lv.setAdapter(adapter);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(CarroCompraList.this, ListaProductos.class);
                i.putExtra("id", 0);
                cursor.close();
            	startActivityForResult(i, 0);
		        Log.e("CarroCompraList ONCREATE click ", "" + i);
            }        
        });
	}

}
