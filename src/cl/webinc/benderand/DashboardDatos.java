package cl.webinc.benderand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import cl.webinc.benderand.movidos.EmpresaWeb;
import cl.webinc.benderand.movidos.ProductoWeb;

public class DashboardDatos extends Activity
{
	private EditText editIp;
	private Spinner spinner;
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        Log.e("dashboarddatos", "start ");
        setContentView(R.layout.dashboarddatos);
		Button btnSinc = (Button) findViewById(R.id.btnSinc);
        editIp = (EditText) findViewById(R.id.editIp);
        AppMy app = AppMy.getinstance();
        editIp.setText(app.getUrl());
        spinner = (Spinner) findViewById(R.id.spinLista);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sinclist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnSinc.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(DashboardDatos.this, getActivity());
            	Toast.makeText(DashboardDatos.this, spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString(), Toast.LENGTH_SHORT).show();
                i.putExtra("ip", editIp.getText().toString());
                i.putExtra("lista", spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString());
            	startActivity(i);
            }        
        });
	}
	public Class<?> getActivity()
	{
		if(spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString().equalsIgnoreCase("producto"))
		{
			return ProductoWeb.class;
		}
		else if(spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString().equalsIgnoreCase("empresa"))
		{
			return EmpresaWeb.class;
		}
		return null;
	}
}
