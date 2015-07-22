package cl.webinc.benderand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cl.webinc.benderand.movidos.CarroCompraList;
import cl.webinc.benderand.movidos.GastosList;

public class DashboardFinanzas extends Activity
{
    private Button btnVentas;
    private Button btnGastos;
    private Button btnUtilidad;
    private Button btnFacturas;
    private Button btnBoletas;
    private Button btnContabilidad;
    private Button btnConfiguracion;
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        Log.w("POS ONCREATE", "start ");
        setContentView(R.layout.dashboardfinanzas);
        btnVentas = (Button) findViewById(R.id.btnVentas);
        btnGastos = (Button) findViewById(R.id.btnGastos);
        btnUtilidad = (Button) findViewById(R.id.btnUtilidad);
        btnFacturas = (Button) findViewById(R.id.btnFacturas);
        btnBoletas = (Button) findViewById(R.id.btnBoletas);
        btnContabilidad = (Button) findViewById(R.id.btnContabilidad);
        btnConfiguracion = (Button) findViewById(R.id.btnConfiguracion);
        btnVentas.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardFinanzas.this, CarroCompraList.class);
                i.putExtra("id", 0);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnGastos.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardFinanzas.this, GastosList.class);
                i.putExtra("id", 0);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnUtilidad.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardFinanzas.this, CarroCompraList.class);
                i.putExtra("id", 0);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnFacturas.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardFinanzas.this, CarroCompraList.class);
                i.putExtra("id", 0);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnBoletas.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardFinanzas.this, CarroCompraList.class);
                i.putExtra("id", 0);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnContabilidad.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardFinanzas.this, CarroCompraList.class);
                i.putExtra("id", 0);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnConfiguracion.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardFinanzas.this, CarroCompraList.class);
                i.putExtra("id", 0);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
	}
}
