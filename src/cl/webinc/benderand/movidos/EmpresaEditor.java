package cl.webinc.benderand.movidos;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;

import cl.webinc.benderand.AppMy;
import cl.webinc.benderand.R;
import cl.webinc.benderand.provider.Base.empresa;
import cl.webinc.benderand.sync.WebConector;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class EmpresaEditor  extends Activity {
    private static final String TAG = "hello EDITOR USUARIO";
    private String ID = "0";
    
    // Identifiers for our menu items.
    private static final int ADD_ID = Menu.FIRST;
    private static final int DISCARD_ID = Menu.FIRST + 1;
    private static final int DELETE_ID = Menu.FIRST + 2;
    private static final int EDIT_ID = Menu.FIRST + 3;

    // The different distinct states the activity can be run in.
    private static final int STATE_EDIT = 1;
    private static final int STATE_INSERT = 0;

    private int mState;
    private boolean mNoteOnly = false;
    private EditText mrut_empre;
    private EditText mnombre_empre;
    private EditText malcance_empre;
    private EditText mcargo_cont_empre;
    private EditText memail_empre;
    private EditText mnom_cont_empre;
    private EditText mtelefono_empre;
    private Spinner spinneractividad_id_actividad;
	protected String FORMAT;
	private HashMap<String, String> map = new HashMap<String, String>();
	public String action;
	private ArrayList<HashMap<String, String>> mylist;
	private static AppMy app = AppMy.getinstance();
	private HashMap<String, String> extra = new HashMap<String, String>();
	public ArrayList<HashMap<String, String>> mylist2;
	public String actividad = "1";
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("ONCREATE", "start ");
        super.onCreate(savedInstanceState);
        
        extra = app.getExtra();
		ID = extra.get("id");
		
        Log.e("ONCREATE", "get id intent " + getIntent().hasExtra("id") + " id " + ID);
        setContentView(R.layout.empresaeditor);
        
        asignarCamposvariableCorta();
        if(!ID.equals("0"))
        {        	
			Log.e("ONCREATE query  ", "ID != 0" + ID );
        	limpiarPantalla();
        	new sincTaskbuscarid().execute();
        	mState = STATE_EDIT;
        }
        else
        {
        	limpiarPantalla();
        	mState = STATE_INSERT;
        }

        new sincTaskactividad().execute();
    }

    
    private class sincTaskactividad extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>  
    {
		@Override
    	 protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
    		if(result != null) {
    	        Log.e(TAG , " actividad task size " + result.size());
                String[] subcat = new String[result.size()];     
                for (int i=0; i<result.size(); i++){
                	subcat[i] = result.get(i).get("codigo_actividad") + " " + result.get(i).get("nombre_actividad");
        	        Log.e(TAG + " actividad task", result.get(i).get("nombre_actividad") + " " + result.get(i).get("id_actividad"));
                }
                spinneractividad_id_actividad(subcat);
	        }else {
	            Log.e("producto editor categoria task", "onpost execute result null");
	        }
    	 }
    	@Override
    	protected ArrayList<HashMap<String, String>> doInBackground(
    			String... params) {
    		AppMy app = AppMy.getinstance();
    		Log.e("thread end", " thread end");
             try {
    			mylist2 = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/getactividadesdroid", "spinneractividad");
    		} catch (JSONException e) {
    			mylist2 = new ArrayList<HashMap<String, String>>();
    			Log.e("json", " array list" + e);
    		}
             return mylist2;
    	}
     }/**/

	public void spinneractividad_id_actividad(String[] act){

        ArrayAdapter<String> adapter = 
            new ArrayAdapter<String> (EmpresaEditor.this, android.R.layout.simple_spinner_item, act);      
        adapter.setDropDownViewResource(R.layout.multi_line_spinner_dropdown_item);
        spinneractividad_id_actividad.setAdapter(adapter);
        OnItemSelectedListener spinnerListener = new myOnItemSelectedListener(EmpresaEditor.this);
        spinneractividad_id_actividad.setOnItemSelectedListener(spinnerListener);
    }   
	 
    public class myOnItemSelectedListener implements OnItemSelectedListener {
 
        Context mContext;
 
        public myOnItemSelectedListener(Context context){
            this.mContext = context;
        }
 
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			actividad = mylist2.get(position).get("id_subcat");			
		}

		public void onNothingSelected(AdapterView<?> parent) {
			
		}
	}
	
    private class sincTask extends AsyncTask<String, Void, Boolean>  
	{
		private boolean login;
		@Override
		protected void onPostExecute(Boolean result) 
		{
			if(login)
			{
				Toast.makeText(getApplicationContext(), "Sinc empresa ok", Toast.LENGTH_SHORT).show();
			}
			else 
			{
				Toast.makeText(getApplicationContext(), "Error en sinc empresa", Toast.LENGTH_SHORT).show();
			}
		}
		@Override
		protected Boolean doInBackground(
				String... params) {
    		AppMy app = AppMy.getinstance();
			Log.e("addprod  ", " do in background");
	        login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "empresa");
	         return login;
		}
	 }
    private class sincTaskbuscarid extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>  
    {
    	@Override
    	 protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
    		if(result != null) {
    			mrut_empre.setTextKeepState(result.get(result.size()-1).get("rut_empre"));
    	        mnombre_empre.setTextKeepState(result.get(result.size()-1).get("nombre_empre"));
    	        malcance_empre.setTextKeepState(result.get(result.size()-1).get("alcance_empre"));
    	        mcargo_cont_empre.setTextKeepState(result.get(result.size()-1).get("cargo_cont_empre"));
    	        memail_empre.setTextKeepState(result.get(result.size()-1).get("email_empre"));
    	        mnom_cont_empre.setTextKeepState(result.get(result.size()-1).get("nom_cont_empre"));
    	        mtelefono_empre.setTextKeepState(result.get(result.size()-1).get("telefono_empre"));
    	        Log.e("productoweb 205", " not null");
    	        }else {
    	            Log.e("terrible null", " return");
    	        }
    	        //m_ProgressDialog.dismiss();
    	 }
    	@Override
    	protected ArrayList<HashMap<String, String>> doInBackground(
    			String... params) {
    		AppMy app = AppMy.getinstance();
    		Log.e("thread end", " thread end");
             try {
    			mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_empresa_by_id/" + ID, "empresa");
    		} catch (JSONException e) {
    			mylist = new ArrayList<HashMap<String, String>>();
    			Log.e("json", " array list" + e);
    		}
             return mylist;
    	}
     }
	
	@Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onresume.............");
  }

    @Override
    protected void onPause() {
        Log.e(TAG, "pause.............");
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Log.e("onCreateOptionsMenu", "menuoptions.............");

        // Build the menus that are shown when editing.
        if (mState == STATE_EDIT) {
            menu.add(0, ADD_ID, 0, R.string.menu_insert)
                    .setShortcut('0', 'r')
                    .setIcon(android.R.drawable.ic_menu_add);
            if (!mNoteOnly) {
                menu.add(0, DELETE_ID, 0, R.string.menu_delete)
                        .setShortcut('1', 'd')
                        .setIcon(android.R.drawable.ic_menu_delete);
            }
        } else {
            menu.add(0, ADD_ID, 0, R.string.menu_insert)
            .setShortcut('0', 'r')
            .setIcon(android.R.drawable.ic_menu_add);
            menu.add(0, DISCARD_ID, 0, R.string.menu_discard)
                    .setShortcut('0', 'd')
                    .setIcon(android.R.drawable.ic_menu_delete);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(TAG, "itemselected.............");
        // Handle all of the possible menu actions.
        switch (item.getItemId()) {
        case DELETE_ID:
        	delEmpresa();
            finish();
            break;
        case EDIT_ID:
        	addEmpresa();
            finish();
            break;
        case ADD_ID:
        	addEmpresa();
            finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void delEmpresa() {
    	Log.e(" uri del ",  getIntent().getData() + "___");
	}

    private final void addEmpresa() {
        Log.e("addEmpresa", "addEmpresa.............");
        map.put(empresa.rut_empresa, mrut_empre.getText().toString());
        map.put(empresa.nombre_empresa, mnombre_empre.getText().toString());
        map.put(empresa.alcance_empresa, malcance_empre.getText().toString());
        map.put(empresa.cargo_contacto_empresa, mcargo_cont_empre.getText().toString());
        map.put(empresa.email_empresa, memail_empre.getText().toString());
        map.put(empresa.nombre_contacto_empresa, mnom_cont_empre.getText().toString());
        map.put(empresa.telefono_empresa, mtelefono_empre.getText().toString());
        map.put("actividad_id_actividad", mylist2.get(spinneractividad_id_actividad.getSelectedItemPosition()).get("id_actividad"));

    	Log.e("map actividad_id_actividad", "" + map.get("actividad_id_actividad"));
		
        if (mState == STATE_INSERT) {
        	action = "saveempresa";
        	new sincTask().execute();
        }
        else
        {
            map.put(empresa.id_empresa, ID.toString());
        	action = "updateempresa";
        	new sincTask().execute();
        	
        }
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
    	mrut_empre = (EditText) findViewById(R.id.editrut_empre);
        mnombre_empre = (EditText) findViewById(R.id.editnombre_empre);
        malcance_empre = (EditText) findViewById(R.id.editalcance_empre);
        mcargo_cont_empre = (EditText) findViewById(R.id.editcargo_cont_empre);
        memail_empre = (EditText) findViewById(R.id.editemail_empre);
        mnom_cont_empre = (EditText) findViewById(R.id.editnom_cont_empre);
        mtelefono_empre = (EditText) findViewById(R.id.edittelefono_empre);
        spinneractividad_id_actividad = (Spinner) findViewById(R.id.spinneractividad_id_actividad);
    }
    public void limpiarPantalla()
    {
    	Log.e("limpiapantalla", "limpio___________________");
    	 // asigno textbox a variable corta
    	mrut_empre.setText("");
        mnombre_empre.setText("");
        malcance_empre.setText("");
        mcargo_cont_empre.setText("");
        memail_empre.setText("");
        mnom_cont_empre.setText("");
        mtelefono_empre.setText("");
    }
}

