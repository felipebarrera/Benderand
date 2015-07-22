package cl.webinc.benderand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DashboardAdministracion extends AppCompatActivity
{
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        Log.w("POS ONCREATE", "start ");
        setContentView(R.layout.dashboardadministracion);
        setTitle(R.string.adminitracion);
        Button btnListaVentas = (Button) findViewById(R.id.btnListaVentas);
        Button btnListaCompras = (Button) findViewById(R.id.btnListaCompras);
        Button btnUsuarios = (Button) findViewById(R.id.btnUsuarios);
        Button btnBodega = (Button) findViewById(R.id.btnBodega);
        Button btnProductos = (Button) findViewById(R.id.btnProductos);
        btnListaVentas.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(DashboardAdministracion.this, IngresoList.class);
                startActivity(i);
                Log.e("ONCREATE click ", "" + i);
            }
        });
        btnListaCompras.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(DashboardAdministracion.this, EgresoList.class);
                startActivity(i);
                Log.e("ONCREATE click ", "" + i);
            }
        });
        btnUsuarios.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(DashboardAdministracion.this, Usuario.class);
                startActivity(i);
                Log.e("ONCREATE click ", "" + i);
            }
        });
        btnProductos.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardAdministracion.this, ProductoList.class);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
        btnBodega.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardAdministracion.this, Bodega.class);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }        
        });
	}
}
