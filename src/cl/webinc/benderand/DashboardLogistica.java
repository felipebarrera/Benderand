package cl.webinc.benderand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cl.webinc.benderand.crud.EmpresaList;
import cl.webinc.benderand.movidos.DespachoList;
import cl.webinc.benderand.movidos.FacturaList;

public class DashboardLogistica extends Activity
{
    private Button btnProveedor;
    private Button btnFactura;
    private Button btnDespacho;
    private Button btnBodega;
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        Log.w("POS ONCREATE", "start ");
        setContentView(R.layout.dashboardlogistica);
        btnProveedor = (Button) findViewById(R.id.btnProveedor);
        btnFactura = (Button) findViewById(R.id.btnFactura);
        btnDespacho = (Button) findViewById(R.id.btnDespacho);
        btnBodega = (Button) findViewById(R.id.btnBodega);
        btnProveedor.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardLogistica.this, EmpresaList.class);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnFactura.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardLogistica.this, FacturaList.class);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnDespacho.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardLogistica.this, DespachoList.class);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnBodega.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardLogistica.this, Bodega.class);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
	}
}
