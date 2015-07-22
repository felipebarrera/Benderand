package cl.webinc.benderand;

import android.app.ProgressDialog;
import android.content.ContentUris;
import android.database.SQLException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import org.json.JSONException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

/**
 * Created by Felipe on 07-06-2015.
 */
public class Registro extends AppCompatActivity {
	private static final String TAG = "EDITOR empresa";
	private String ID = "0";
	private static final int ADD_ID = Menu.FIRST;
	private static final int DISCARD_ID = Menu.FIRST + 1;
	private static final int DELETE_ID = Menu.FIRST + 2;
	private static final int EDIT_ID = Menu.FIRST + 3;
	private static final int STATE_EDIT = 1;
	private static final int STATE_INSERT = 0;
	private int mState;
	private HashMap<String, String> map = new HashMap<String, String>();
	public String action;
	private ArrayList<HashMap<String, String>> mylist;
	private static AppMy app = AppMy.getinstance();
	public HashMap<String, ArrayList<HashMap<String, String>>>  arraylist;
	private EditText mrut_empresa;
	private EditText mnombre_empresa;
	private EditText mnombre_contacto_empresa;
	private EditText mcargo_contacto_empresa;
	private EditText memail_empresa;
	private EditText malcance_empresa;
	private EditText mtelefono_empresa;
	private EditText mnombre_usuario;
	private EditText mclave_usuario;
	private EditText mrut_persona;
	private EditText mnombre_persona;
	private EditText msegundo_nombre_persona;
	private EditText mapellido_persona;
	private EditText msegundo_apellido_persona;
	private DatePicker mdia_fecha_nacimiento;
	private EditText memail;
	private EditText mcelular;
	private EditText mtelefono;

	private Spinner mactividad_id_actividad;
	private Spinner mtipo_empresa_id_tipo_empresa;
	private Spinner mcategoria_empresa_id_categoria_empresa;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e(TAG, "ONCREATE ");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registroempresausuario);
		setTitle(R.string.registrese);
		TableLayout mTableLayout = (TableLayout) findViewById(R.id.tablelayout);
		mTableLayout.setShrinkAllColumns(true);
		asignarCamposvariableCorta();
		Button btnGuardarempresa = (Button) findViewById(R.id.btnGuardarempresa);
		btnGuardarempresa.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//FUNCIONA DESCOMENTAR PARA LOGIN
				Log.e("Login", "is external " + app.isExternal());
				addEmpresa();
			}
		});
		limpiarPantalla();

		new sincTaskcargaspinners().execute();

	}

	private class sincTask extends AsyncTask<String, Void, HashMap<String, ArrayList<HashMap<String, String>>>>
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Registro.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Registro.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result)
		{
			SimpleAdapter adaptertipo_empresa = new SimpleAdapter(Registro.this, result.get("mylisttipo_empresa"), android.R.layout.simple_spinner_item,
					new String[] {Base.tipo_empresa.nombre_tipo_empresa}, new int[] {android.R.id.text1 });
			adaptertipo_empresa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			mtipo_empresa_id_tipo_empresa.setAdapter(adaptertipo_empresa);
			dialog.dismiss();
		}
		@Override
		protected HashMap<String, ArrayList<HashMap<String, String>>> doInBackground(String... params) {
			app = AppMy.getinstance();
			if(!app.isExternal()){
				if (mState == STATE_INSERT) {
					arraylist.put("mylisttipo_empresa", CursortoArrayhash.getinstance().ahTipo_empresa(getContentResolver().query(
							Base.tipo_empresa.CONTENT_URI, ProjectionCreater.pctipo_empresa, Base.tipo_empresa.categoria_empresa_id_categoria_empresa + " = ?",
							new String[]{arraylist.get("mylistcategoria_empresa").get(mcategoria_empresa_id_categoria_empresa.getSelectedItemPosition()).get("_id")},
							Base.tipo_empresa.DEFAULT_ORDEN)));
				}
				else
				{
					Log.e("" + mState, "mState" + mState);
					try{
						Log.e("values", "" + PostData.getinstance().postdataready(map, "empresa").toString());
						String idempresa = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(Base.empresa.CONTENT_URI, Long.parseLong(ID)),
								PostData.getinstance().postdataready(map, "empresa"),null,null)));
						Log.e("updateempresa ", " do in background " + idempresa);
					}
					catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}

				}
			}
			else
			{
				if(app.isOnline(Registro.this))
				{
					if (mState == STATE_INSERT) {
						action = "saveempresa";
					}
					else
					{
						action = "updateempresa";
					}
					WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "empresa");
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
				}
			}
			return arraylist;
		}
	}


	private class sincTaskGuardar extends AsyncTask<String, Void, Boolean>
	{
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Registro.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Registro.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		private boolean login = false;
		@Override
		protected void onPostExecute(Boolean result)
		{
			if(login)
			{
				Toast.makeText(getApplicationContext(), "Sinc empresa ok", Toast.LENGTH_SHORT).show();
				Log.e("sincTask " + mState, "Sinc empresa ok");
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Error en sinc empresa", Toast.LENGTH_SHORT).show();
				Log.e("sincTask " + mState, "Error en sinc empresa");
			}
			dialog.dismiss();
			finish();//vuelvo a la lista
		}
		@Override
		protected Boolean doInBackground(String... params) {
			app = AppMy.getinstance();
			String idempresa = "0";
			Log.e("addempresa  ", " do in background");
			if(!app.isExternal()){
				if (mState == STATE_INSERT) {
					idempresa = String.valueOf(Integer.valueOf(getContentResolver().insert(Base.empresa.CONTENT_URI, PostData.getinstance().postdataready(map, "empresa")).getLastPathSegment()));
					String idpersona = String.valueOf(getContentResolver().insert(Base.persona.CONTENT_URI, PostData.getinstance().postdataready(map, "persona")).getLastPathSegment());
					map.put(Base.carne_empresa.persona_id_persona, idpersona);
					map.put(Base.carne_empresa.empresa_id_empresa, idempresa);
					getContentResolver().insert(Base.carne_empresa.CONTENT_URI, PostData.getinstance().postdataready(map, "carne_empresa")).getLastPathSegment();
					login = Integer.valueOf(idempresa) > 0;
					Log.e("addempresa  ", " do in background " + idempresa);
					login = Integer.valueOf(idempresa) > 0;
				}
				else
				{
					Log.e("" + mState, "mState" + mState);
					try{
						Log.e("values", "" + PostData.getinstance().postdataready(map, "empresa").toString());
						idempresa = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(Base.empresa.CONTENT_URI, Long.parseLong(ID)),
								PostData.getinstance().postdataready(map, "empresa"),null,null)));
						login = Integer.valueOf(idempresa) > 0;
						Log.e("updateempresa ", " do in background " + idempresa);
					}
					catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
					login = Integer.valueOf(idempresa) > 0;

				}
			}
			else
			{
				if(app.isOnline(Registro.this))
				{
					if (mState == STATE_INSERT) {
						action = "saveempresa";
					}
					else
					{
						action = "updateempresa";
					}
					login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "empresa");
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
				}
			}
			return login;
		}
	}
	private class sincTaskcargaspinners extends AsyncTask<String, Void, HashMap<String, ArrayList<HashMap<String, String>>>>
	{
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Registro.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Registro.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
			if(result != null) {
				Log.e(TAG, "" + result.size());
				SimpleAdapter adapteractividad = new SimpleAdapter(Registro.this, result.get("mylistactividad"), android.R.layout.simple_spinner_item,
						new String[] {Base.actividad.nombre_actividad}, new int[] {android.R.id.text1 });
				adapteractividad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				mactividad_id_actividad.setAdapter(adapteractividad);
				if (mState == STATE_EDIT) {
					Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.actividad.id_actividad))-1;
					Log.e("compareValue", "" + compareValue);
					if (!compareValue.equals(null)) {
						mactividad_id_actividad.setSelection(compareValue);
					}
				}
				SimpleAdapter adaptertipo_empresa = new SimpleAdapter(Registro.this, result.get("mylisttipo_empresa"), android.R.layout.simple_spinner_item,
						new String[] {Base.tipo_empresa.nombre_tipo_empresa}, new int[] {android.R.id.text1 });
				adaptertipo_empresa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				mtipo_empresa_id_tipo_empresa.setAdapter(adaptertipo_empresa);
				if (mState == STATE_EDIT) {
					Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.tipo_empresa.id_tipo_empresa))-1;
					Log.e("compareValue", "" + compareValue);
					if (!compareValue.equals(null)) {
						mtipo_empresa_id_tipo_empresa.setSelection(compareValue);
					}
				}
				SimpleAdapter adaptercategoria_empresa_id_categoria_empresa = new SimpleAdapter(Registro.this, result.get("mylistcategoria_empresa"), android.R.layout.simple_spinner_item,
						new String[] {Base.categoria_empresa.nombre_categoria_empresa}, new int[] {android.R.id.text1 });
				adaptercategoria_empresa_id_categoria_empresa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				mcategoria_empresa_id_categoria_empresa.setAdapter(adaptercategoria_empresa_id_categoria_empresa);
				if (mState == STATE_EDIT) {
					Integer compareValue = Integer.valueOf(mylist.get(mylist.size()-1).get(Base.categoria_empresa.id_categoria_empresa))-1;
					Log.e("compareValue", "" + compareValue);
					if (!compareValue.equals(null)) {
						mcategoria_empresa_id_categoria_empresa.setSelection(compareValue);
					}
				}

				mcategoria_empresa_id_categoria_empresa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						new sincTask().execute();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {

					}
				});
			}else {
				Log.e("categoria task", "onpost execute result null");
			}
			dialog.dismiss();
		}
		@Override
		protected HashMap<String, ArrayList<HashMap<String, String>>> doInBackground(String... params) {
			Log.e("thread end", " thread end");
			app = AppMy.getinstance();
			arraylist = new HashMap<String, ArrayList<HashMap<String, String>>>();
			if(!app.isExternal()){
				arraylist.put("mylistactividad" , CursortoArrayhash.getinstance().ahActividad(getContentResolver().query(
						Base.actividad.CONTENT_URI, ProjectionCreater.pcactividad, null, null, Base.actividad.nombre_actividad + " ASC")));
				arraylist.put("mylisttipo_empresa" , CursortoArrayhash.getinstance().ahTipo_empresa(getContentResolver().query(
						Base.tipo_empresa.CONTENT_URI, ProjectionCreater.pctipo_empresa, null, null, Base.tipo_empresa.DEFAULT_ORDEN)));
				arraylist.put("mylistcategoria_empresa" , CursortoArrayhash.getinstance().ahCategoria_empresa(getContentResolver().query(
						Base.categoria_empresa.CONTENT_URI, ProjectionCreater.pccategoria_empresa, null, null, Base.categoria_empresa.DEFAULT_ORDEN)));
			}
			else
			{
				if(app.isOnline(Registro.this))
				{
					try {
						arraylist.put("mylistsubcategoria", WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda//getsubcategoriasdroid", "subcategoriaspinner"));
					} catch (JSONException e) {
						arraylist.put("mylistsubcategoria", new ArrayList<HashMap<String, String>>());
						Log.e("json", " array list" + e);
					}
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
				}
			}
			return arraylist;
		}
	}
	private void muestraeditor()
	{
		Log.e("json", " result.size() " + mylist.size() + " " + mylist.toString());
		mrut_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(Base.empresa.rut_empresa));
		mnombre_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(Base.empresa.nombre_empresa));
		mnombre_contacto_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(Base.empresa.nombre_contacto_empresa));
		mcargo_contacto_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(Base.empresa.cargo_contacto_empresa));
		memail_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(Base.empresa.email_empresa));
		malcance_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(Base.empresa.alcance_empresa));
		mtelefono_empresa.setTextKeepState(mylist.get(mylist.size()-1).get(Base.empresa.telefono_empresa));
		mnombre_usuario.setTextKeepState(mylist.get(mylist.size()-1).get(Base.carne_empresa.nombre_usuario));
		mclave_usuario.setTextKeepState(mylist.get(mylist.size()-1).get(Base.carne_empresa.clave_usuario));
		mrut_persona.setTextKeepState(mylist.get(mylist.size()-1).get(Base.persona.rut_persona));
		mnombre_persona.setTextKeepState(mylist.get(mylist.size()-1).get(Base.persona.nombre_persona));
		msegundo_nombre_persona.setTextKeepState(mylist.get(mylist.size()-1).get(Base.persona.segundo_nombre_persona));
		mapellido_persona.setTextKeepState(mylist.get(mylist.size()-1).get(Base.persona.apellido_persona));
		msegundo_apellido_persona.setTextKeepState(mylist.get(mylist.size()-1).get(Base.persona.segundo_apellido_persona));
		mdia_fecha_nacimiento.updateDate(Integer.valueOf(mylist.get(mylist.size() - 1).get(Base.persona.ano_fecha_nacimiento)),
				Integer.valueOf(mylist.get(mylist.size() - 1).get(Base.persona.mes_fecha_nacimiento)),
				Integer.valueOf(mylist.get(mylist.size()-1).get(Base.persona.dia_fecha_nacimiento)));
		memail.setTextKeepState(mylist.get(mylist.size()-1).get(Base.persona.email));
		mcelular.setTextKeepState(mylist.get(mylist.size()-1).get(Base.persona.celular));
		mtelefono.setTextKeepState(mylist.get(mylist.size()-1).get(Base.persona.telefono));


	}
	public void asignarCamposvariableCorta()
	{
		// asigno textbox a variable corta
		mrut_empresa = (EditText) findViewById(R.id.etrut_empresa);
		mnombre_empresa = (EditText) findViewById(R.id.etnombre_empresa);
		mnombre_contacto_empresa = (EditText) findViewById(R.id.etnombre_contacto_empresa);
		mcargo_contacto_empresa = (EditText) findViewById(R.id.etcargo_contacto_empresa);
		memail_empresa = (EditText) findViewById(R.id.etemail_empresa);
		malcance_empresa = (EditText) findViewById(R.id.etalcance_empresa);
		mtelefono_empresa = (EditText) findViewById(R.id.ettelefono_empresa);
		mnombre_usuario = (EditText) findViewById(R.id.etnombre_usuario);
		mclave_usuario = (EditText) findViewById(R.id.etclave_usuario);
		mrut_persona = (EditText) findViewById(R.id.etrut_persona);
		mnombre_persona = (EditText) findViewById(R.id.etnombre_persona);
		msegundo_nombre_persona = (EditText) findViewById(R.id.etsegundo_nombre_persona);
		mapellido_persona = (EditText) findViewById(R.id.etapellido_persona);
		msegundo_apellido_persona = (EditText) findViewById(R.id.etsegundo_apellido_persona);
		mdia_fecha_nacimiento = (DatePicker) findViewById(R.id.datePicker);
		memail = (EditText) findViewById(R.id.etemail);
		mcelular = (EditText) findViewById(R.id.etcelular);
		mtelefono = (EditText) findViewById(R.id.ettelefono);

		mactividad_id_actividad = (Spinner) findViewById(R.id.spactividad_id_actividad);
		mtipo_empresa_id_tipo_empresa = (Spinner) findViewById(R.id.sptipo_empresa_id_tipo_empresa);
		mcategoria_empresa_id_categoria_empresa = (Spinner) findViewById(R.id.spcategoria_empresa_id_categoria_empresa);

	}

	public void limpiarPantalla()
	{
		Log.e("limpiapantalla", "limpio___________________");
		mrut_empresa.setText("");
		mnombre_empresa.setText("");
		mnombre_contacto_empresa.setText("");
		mcargo_contacto_empresa.setText("");
		memail_empresa.setText("");
		malcance_empresa.setText("");
		mtelefono_empresa.setText("");
		mnombre_usuario.setText("");
		mclave_usuario.setText("");
		mrut_persona.setText("");
		mnombre_persona.setText("");
		msegundo_nombre_persona.setText("");
		mapellido_persona.setText("");
		msegundo_apellido_persona.setText("");
		memail.setText("");
		mcelular.setText("");
		mtelefono.setText("");

	}

	private void addEmpresa() {
		Log.e("add", "add Empresa");
		map.put(Base.empresa.rut_empresa, mrut_empresa.getText().toString());
		map.put(Base.empresa.nombre_empresa, mnombre_empresa.getText().toString());
		map.put(Base.empresa.nombre_contacto_empresa, mnombre_contacto_empresa.getText().toString());
		map.put(Base.empresa.cargo_contacto_empresa, mcargo_contacto_empresa.getText().toString());
		map.put(Base.empresa.email_empresa, memail_empresa.getText().toString());
		map.put(Base.empresa.alcance_empresa, malcance_empresa.getText().toString());
		map.put(Base.empresa.telefono_empresa, mtelefono_empresa.getText().toString());
		map.put(Base.carne_empresa.nombre_usuario, mnombre_usuario.getText().toString());
		map.put(Base.carne_empresa.clave_usuario, sha1(mclave_usuario.getText().toString()));
		map.put(Base.persona.rut_persona, mrut_persona.getText().toString());
		map.put(Base.persona.nombre_persona, mnombre_persona.getText().toString());
		map.put(Base.persona.segundo_nombre_persona, msegundo_nombre_persona.getText().toString());
		map.put(Base.persona.apellido_persona, mapellido_persona.getText().toString());
		map.put(Base.persona.segundo_apellido_persona, msegundo_apellido_persona.getText().toString());
		map.put(Base.persona.dia_fecha_nacimiento, String.valueOf(mdia_fecha_nacimiento.getDayOfMonth()));
		map.put(Base.persona.mes_fecha_nacimiento, String.valueOf(mdia_fecha_nacimiento.getMonth()));
		map.put(Base.persona.ano_fecha_nacimiento, String.valueOf(mdia_fecha_nacimiento.getYear()));
		map.put(Base.persona.email, memail.getText().toString());
		map.put(Base.persona.celular, mcelular.getText().toString());
		map.put(Base.persona.telefono, mtelefono.getText().toString());

		map.put(Base.empresa.actividad_id_actividad, arraylist.get("mylistactividad").get(mactividad_id_actividad.getSelectedItemPosition()).get("_id"));

		map.put(Base.empresa.tipo_empresa_id_tipo_empresa, arraylist.get("mylisttipo_empresa").get(mtipo_empresa_id_tipo_empresa.getSelectedItemPosition()).get("_id"));

		map.put(Base.tipo_empresa.categoria_empresa_id_categoria_empresa, arraylist.get("mylistcategoria_empresa").get(mcategoria_empresa_id_categoria_empresa.getSelectedItemPosition()).get("_id"));
		Log.e("if (mState", "mState" + mState);
		new sincTaskGuardar().execute();
	}


	public String sha1(String s)
	{
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		digest.reset();
		byte[] data = digest.digest(s.getBytes());
		return String.format("%0" + (data.length*2) + "X", new BigInteger(1, data));
	}

	private void delEmpresa() {
		//BORRA PROD POR ID
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
		Log.e("estado mennu ", "mState " + mState);
		if (mState == STATE_EDIT) {
			menu.add(0, ADD_ID, 0, R.string.menu_update)
					.setShortcut('0', 'r')
					.setIcon(android.R.drawable.ic_menu_save);
			menu.add(0, DELETE_ID, 0, R.string.menu_delete)
					.setShortcut('1', 'd')
					.setIcon(android.R.drawable.ic_menu_delete);
		} else {
			menu.add(0, ADD_ID, 0, R.string.menu_insert)
					.setShortcut('0', 'r')
					.setIcon(android.R.drawable.ic_menu_save);
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
				break;
			case ADD_ID:
				addEmpresa();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}