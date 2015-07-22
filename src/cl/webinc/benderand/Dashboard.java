package cl.webinc.benderand;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;

import java.util.ArrayList;
import java.util.Calendar;

import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.ProjectionCreater;

public class Dashboard extends AppCompatActivity
{
    private BarGraph grafico;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        Log.w("POS ONCREATE", "start ");
        setContentView(R.layout.dashboard);
        //Button btnFinanzas = (Button) findViewById(R.id.btnFinanzas);
        Button btnAdministracion = (Button) findViewById(R.id.btnAdministracion);
        Button btnLogistica = (Button) findViewById(R.id.btnComprar);
        Button btnTienda = (Button) findViewById(R.id.btnVender);
        //Button btnDatos = (Button) findViewById(R.id.btnDatos);
        btnAdministracion.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(Dashboard.this, DashboardAdministracion.class);
            	startActivity(i);
		        Log.e("dashboard click ", "" + i);
            }        
        });
        btnLogistica.setOnClickListener(new View.OnClickListener() 
        {        	
            public void onClick(View v) 
            {
            	Intent i = new Intent(Dashboard.this, Comprar.class);
            	startActivity(i);
		        Log.e("dashboard click ", "" + i);
            }        
        });
        btnTienda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, Vender.class);
                startActivity(i);
                Log.e("dashboard click ", "" + i);
            }
        });

        grafico = (BarGraph) findViewById(R.id.graph);
        grafico.setOnBarClickedListener(new BarGraph.OnBarClickedListener() {
            @Override
            public void onClick(int index) {
                Intent i;
                switch (index) {
                    case 0:
                        i = new Intent(Dashboard.this, IngresoList.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Dashboard.this, EgresoList.class);
                        startActivity(i);
                        break;
                }
            }
        });

        Spinner spperiodo = (Spinner) findViewById(R.id.spPeriodo);
        spperiodo.setAdapter(ArrayAdapter.createFromResource(getBaseContext(), R.array.periodos_array, android.R.layout.simple_spinner_dropdown_item));
        spperiodo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("onItemSelected","graph");
                new sincTaskGrafica().execute(String.valueOf(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*
        btnLogistica.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
            	Intent i = new Intent(Dashboard.this, DashboardLogistica.class);
            	startActivity(i);
		        Log.e("ONCREATE click ", "" + i);
            }
        });
        btnDatos.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(Dashboard.this, DashboardDatos.class);
                startActivity(i);
                Log.e("ONCREATE click ", "" + i);
            }
        });
        btnFinanzas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, DashboardFinanzas.class);
                startActivity(i);
                Log.e("ONCREATE click ", "" + i);
            }
        });*/
	}

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume ", "graph");
        new sincTaskGrafica().execute(String.valueOf(0));
    }

    private class sincTaskGrafica extends AsyncTask<String, Void, Void>
    {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Dashboard.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(Dashboard.this.getResources().getString(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
        protected void onPostExecute(Void result)
        {
            Log.e("onPostExecute", " _________");
            dialog.dismiss();
        }
        @Override
        protected Void doInBackground(String... params) {
            AppMy app = AppMy.getinstance();
            Calendar rightNow = Calendar.getInstance();
            String sWhere = "";
            String[] args;
            Log.e("params stgrafica", " _________" + params[0]);
            if(!app.isExternal()){
                switch (params[0]) {
                    default:
                        sWhere = sWhere + Base.dia.dia + " = ? and " + Base.dia.mes + " = ? and " + Base.dia.anno + " = ?";
                        args = new String[]{String.valueOf(rightNow.get(Calendar.DAY_OF_MONTH)), String.valueOf(rightNow.get(Calendar.MONTH)), String.valueOf(rightNow.get(Calendar.YEAR))};
                        break;
                    case "0":
                        sWhere = sWhere + Base.dia.dia + " = ? and " + Base.dia.mes + " = ? and " + Base.dia.anno + " = ?";
                        args = new String[]{String.valueOf(rightNow.get(Calendar.DAY_OF_MONTH)), String.valueOf(rightNow.get(Calendar.MONTH)), String.valueOf(rightNow.get(Calendar.YEAR))};
                        break;
                    case "1":
                        sWhere = sWhere + Base.dia.mes + " = ? and " + Base.dia.anno + " = ?";
                        args = new String[]{String.valueOf(rightNow.get(Calendar.MONTH)), String.valueOf(rightNow.get(Calendar.YEAR))};
                        break;
                    case "2":
                        sWhere = sWhere + Base.dia.anno + " = ?";
                        args = new String[]{String.valueOf(rightNow.get(Calendar.YEAR))};
                        break;
                }
                Cursor c = getContentResolver().query(Base.ingresosegresos.CONTENT_URI, ProjectionCreater.pcingresosegresos,
                        sWhere, args, Base.ingresosegresos.fecha + " ASC");
                Log.e("inicio grafico", " _________" + c.getCount());
                if(c.moveToFirst()) {
                    grafico.setBars(damepuntos(c.getInt(c.getColumnIndex(Base.ingresosegresos.totalingreso)), c.getInt(c.getColumnIndex(Base.ingresosegresos.totalgasto))));
                }
                else
                {
                    grafico.setBars(damepuntos(0, 0));
                }
                c.close();
            }
            else
            {
                if(app.isOnline(Dashboard.this))
                {
                    WebConector.delete("http://" + app.getUrl() + "/index.php/androidtienda/del_carro_compra/" + app.getCarneEmpresa().getId_carne_empresa());
                    Log.e("eliminar doinbackground", " thread end");
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
                }
            }
            return null;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
            menu.add(0, Menu.FIRST, 0, R.string.cerrarsesion)
                    .setShortcut('0', 'r')
                    .setIcon(android.R.drawable.presence_offline)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("Dashboard", "onOptionsItemSelected item " + item);
        switch (item.getItemId()) {
            case Menu.FIRST:
                startActivity(new Intent(getBaseContext(), Login.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Bar> damepuntos(int ingresos, int gastos) {
        ArrayList<Bar> points = new ArrayList<>();
        Bar d = new Bar();
        d.setColor(Color.parseColor("#99CC00"));
        d.setName("Ingresos");
        d.setValue(ingresos);
        points.add(d);
        Bar d2 = new Bar();
        d2.setColor(Color.parseColor("#CC0000"));
        d2.setName("Egresos");
        d2.setValue(gastos);
        points.add(d2);
        return points;
    }

}
