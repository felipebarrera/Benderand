package cl.webinc.benderand;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import cl.webinc.benderand.entidad.Carne_empresacompleto;
import cl.webinc.benderand.provider.Base;
import cl.webinc.benderand.provider.Base.carne_empresacompleto;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayEntidad;
import cl.webinc.benderand.util.ProjectionCreater;


public class Login extends Activity
{
	private Button btnLogin;
    private EditText usuario;
    private EditText password;
	private HashMap<String, String> map =  new HashMap<String, String>();
	private AppMy app = AppMy.getinstance(); 
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        Log.e("ONCREATE", "crea layout login ");
        setContentView(R.layout.main);
		app.setExternal(false);
        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        usuario.setText("pop");
        password.setText("pop");
		btnLogin = (Button) findViewById(R.id.btnlogin);
        Button btnregistro = (Button) findViewById(R.id.btnregistro);
        /*//BORRAR
        Intent i = new Intent(Login.this, Dashboard.class);
		Log.e("ONCREATE if(app.getUser() != null) ", " abre dashboard");
		startActivity(i);
		Log.e("valid login", " valid login");
		//BORRAR*/
    	Log.e("Login", "is external " + app.isExternal());
        btnLogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				map.put("shaclave", sha1(password.getText().toString().trim()));
				map.put("usuario", usuario.getText().toString().trim());
				//FUNCIONA DESCOMENTAR PARA LOGIN
				Log.e("Login", "is external " + app.isExternal());
				new sincTask().execute();
			}
		});
		btnregistro.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Login.this, Registro.class);
				Log.e("ONCREATE ", " abre dashboard");
				startActivity(i);
				Log.e("valid login", " valid login");
			}
		});
	}

	public boolean loguer()
	{
		boolean success = false;
		Log.e("Loguer", "search loguin ");
	    ProjectionCreater.getinstance();
		Cursor cursor = getContentResolver().query(
				carne_empresacompleto.CONTENT_URI, ProjectionCreater.pccarne_empresacompleto, carne_empresacompleto.nombre_usuario + " = ? and "+ carne_empresacompleto.clave_usuario + " = ?" , 
				new String[]{map.get("usuario"), map.get("shaclave")}, carne_empresacompleto.DEFAULT_ORDEN);
        if (cursor.moveToFirst())
        {
            Log.e(" loguer", "encuentra usuario abre dashboard Usuario = " + cursor.getString(0)+ ' ' + cursor.getString(1)+ ' ' + cursor.getString(2)+ ' ' + cursor.getString(3)+ ' ' + cursor.getString(4)+ ' ' + 
            		cursor.getString(5)+ ' ' + cursor.getString(6)+ ' ' + cursor.getString(7)+ ' ' + cursor.getString(8)+ ' ' + cursor.getString(9)+ ' ' + 
            		cursor.getString(10)+ ' ' + cursor.getString(11)+ ' ' + cursor.getString(12)+ ' ' + cursor.getString(13)+ ' ' + cursor.getString(14)+ ' ' + 
            		cursor.getString(15)+ ' ' + cursor.getString(16)+ ' ' + cursor.getString(17)+ ' ' + cursor.getString(18)+ ' ' + cursor.getString(19)+ ' ' + 
            		cursor.getString(20)+ ' ' + cursor.getString(21)+ ' ' + cursor.getString(22)+ ' ' + cursor.getString(23)+ ' ' + cursor.getString(24)+ ' ' + 
            		cursor.getString(25)+ ' ' + cursor.getString(26)+ ' ' + cursor.getString(27)+ ' ' + cursor.getString(28)+ ' ' + cursor.getString(29));
            app.setCarneEmpresa(CursortoArrayEntidad.getinstance().aeCarne_empresacompleto(cursor).get(0));
            Log.e("CURSORTOARRAYENTIDAD ", "" + app.getCarneEmpresa().getId_empresa());
			success = true;
        }
        else
        {
            Log.e(" loguer", "no encuentra usuario inserta y abre dashboard");
            ContentValues cvPersona = new ContentValues();
            cvPersona.put(Base.persona.nombre_persona, "Felipe");
			cvPersona.put(Base.persona.segundo_nombre_persona, "Andres");
			cvPersona.put(Base.persona.apellido_persona, "Barrera");
			cvPersona.put(Base.persona.segundo_apellido_persona, "Marin");
			cvPersona.put(Base.persona.email, "felipebarreramarin@gmail.com");
			cvPersona.put(Base.persona.celular, "86310619");
			cvPersona.put(Base.persona.rut_persona, "13357290");
			cvPersona.put(Base.persona.digito_verificador, "2");
			cvPersona.put(Base.persona.telefono, "86310619");
			cvPersona.put(Base.persona.actividad, "Analista Programador Computacional");
			cvPersona.put(Base.persona.area_actividad, "Informática");
			cvPersona.put(Base.persona.ano_fecha_nacimiento, "1978");
			cvPersona.put(Base.persona.mes_fecha_nacimiento, "11");
			cvPersona.put(Base.persona.dia_fecha_nacimiento, "21");
			cvPersona.put(Base.persona.edad, "36");
			int idpersona = Integer.valueOf(getContentResolver().insert(Base.persona.CONTENT_URI, cvPersona).getLastPathSegment());
			ContentValues cvEmpresa = new ContentValues();
			cvEmpresa.put(Base.empresa.alcance_empresa, "Malloco");
			cvEmpresa.put(Base.empresa.cargo_contacto_empresa, "Gerente General");
			cvEmpresa.put(Base.empresa.digito_verificador_empresa, "0");
			cvEmpresa.put(Base.empresa.email_empresa, "ventas@webinc.cl");
			cvEmpresa.put(Base.empresa.nombre_empresa, "Webinc Spa");
			cvEmpresa.put(Base.empresa.nombre_contacto_empresa, "Felipe Barrera Marin");
			cvEmpresa.put(Base.empresa.rut_empresa, "763995410");
			cvEmpresa.put(Base.empresa.telefono_empresa, "+56986310619");
			cvEmpresa.put(Base.empresa.actividad_id_actividad, "552");
                int idempresa = Integer.valueOf(getContentResolver().insert(Base.empresa.CONTENT_URI, cvEmpresa).getLastPathSegment());
                Log.e("inserted id login ", "added empresa............." + idempresa + " clavesha1" + sha1("pop"));

            ContentValues cvCarne_empresa = new ContentValues();
            cvCarne_empresa.put(Base.carne_empresa.clave_usuario, sha1("pop"));
            cvCarne_empresa.put(Base.carne_empresa.empresa_id_empresa, idempresa);
            cvCarne_empresa.put(Base.carne_empresa.nombre_usuario, "pop");
            cvCarne_empresa.put(Base.carne_empresa.tipo_usuario_id_tipo_usuario, "3");
            cvCarne_empresa.put(Base.carne_empresa.persona_id_persona, idpersona);
            int idcarne = Integer.valueOf(getContentResolver().insert(Base.carne_empresa.CONTENT_URI, cvCarne_empresa).getLastPathSegment());
            Log.e("inserted id login ", "added carneempresa............." + idcarne);


        	app.setCarneEmpresa(new Carne_empresacompleto(
        			String.valueOf(idcarne), "pop",sha1("pop"), cvCarne_empresa.getAsString(Base.carne_empresa.tipo_usuario_id_tipo_usuario),String.valueOf(idempresa),
        			cvEmpresa.getAsString(Base.empresa.rut_empresa), cvEmpresa.getAsString(Base.empresa.digito_verificador_empresa),
        			cvEmpresa.getAsString(Base.empresa.nombre_empresa), cvEmpresa.getAsString(Base.empresa.nombre_contacto_empresa), cvEmpresa.getAsString(Base.empresa.cargo_contacto_empresa),
        			cvEmpresa.getAsString(Base.empresa.email_empresa), cvEmpresa.getAsString(Base.empresa.alcance_empresa), cvEmpresa.getAsString(Base.empresa.telefono_empresa),
        			cvEmpresa.getAsString(Base.empresa.actividad_id_actividad),String.valueOf(idpersona), cvPersona.getAsString(Base.persona.rut_persona), cvPersona.getAsString(Base.persona.digito_verificador),
        			cvPersona.getAsString(Base.persona.nombre_persona), cvPersona.getAsString(Base.persona.segundo_nombre_persona), cvPersona.getAsString(Base.persona.apellido_persona),
        			cvPersona.getAsString(Base.persona.segundo_apellido_persona), cvPersona.getAsString(Base.persona.actividad), cvPersona.getAsString(Base.persona.area_actividad),
        			cvPersona.getAsString(Base.persona.dia_fecha_nacimiento), cvPersona.getAsString(Base.persona.mes_fecha_nacimiento), cvPersona.getAsString(Base.persona.ano_fecha_nacimiento),
        			cvPersona.getAsString(Base.persona.edad), cvPersona.getAsString(Base.persona.email), cvPersona.getAsString(Base.persona.celular), cvPersona.getAsString(Base.persona.telefono)
        			));
        		Log.e("Login ", " appgetcarne_empresa() " + app.getCarneEmpresa().getId_empresa());
        	/**/
			success = true;//false
        }
		return success;
	}
	public String sha1(String s) 
	{
		byte[] data = null;
        MessageDigest digest = null;
                try {
					digest = MessageDigest.getInstance("SHA-1");
                } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                }
		if (digest != null) {
			digest.reset();
			data = digest.digest(s.getBytes());
		}
		return String.format("%0" + (data.length*2) + "X", new BigInteger(1, data));
	}
	
	private class sincTask extends AsyncTask<String, Void, Boolean>  
	{
		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Login.this);
			dialog.setTitle(R.string.lblObteniendodatos);
			dialog.setMessage(Login.this.getResources().getString(R.string.lblPorfavorespere));
			dialog.setIndeterminate(true);
			dialog.show();
		}
		@Override
		protected void onPostExecute(Boolean result) 
		{
			if(result)
			{
				Intent i = new Intent(Login.this, Dashboard.class);
				Log.e("ONCREATE ", " abre dashboard");
				Log.e("valid login", " valid login");
				Toast.makeText(getApplicationContext(), "Inicio de sesión valido", Toast.LENGTH_SHORT).show();
				startActivity(i);
			}
			else 
			{
				Toast.makeText(getApplicationContext(), "Error en el inicio de sesion", Toast.LENGTH_SHORT).show();
            	btnLogin.setEnabled(true);
			}
			dialog.dismiss();
		}
		@Override
		protected Boolean doInBackground(String... params) {
			AppMy app = AppMy.getinstance();
			Log.e("Login  ", " do in background");
			boolean login = false;
			if(!app.isExternal()){
				login = loguer();
			}
			else {
				if(app.isOnline(Login.this)){
					try {
						login = WebConector.login("http://" + app.getUrl() + "/index.php/adminpos/login/logindroid", map);
						Log.e("Login  USER ", " " + map.get("usuario"));
						Log.e("Login  PASS ", " " + map.get("shaclave"));
					} catch (JSONException e) {
						login = false;
						Log.e("json", " array list" + e);
					}
				}
				else{
					Toast.makeText(getApplicationContext(), "Webinc Problemas de conectividad", Toast.LENGTH_LONG).show();
				}
			}
			return login;
		}
	 }
	@Override
	protected void onResume() {
		super.onResume();
	}
}