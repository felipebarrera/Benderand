package cl.webinc.benderand.sync;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import cl.webinc.benderand.AppMy;
import cl.webinc.benderand.entidad.Carne_empresacompleto;
import cl.webinc.benderand.provider.Base.carne_empresa;
import cl.webinc.benderand.provider.Base.empresa;
import android.util.Log;

public class WebConector {
	private static WebConector webConector = null;
	private static JSONObject json = null;
	private static ArrayList<HashMap<String, String>> mylist = null;
	private static Carne_empresacompleto entempresa;
	private static WebListMap weblistmap;
	private static boolean ok;
	private WebConector()
	{
		
	}
	public static WebConector getInstance()
	{
		if(webConector == null)
		{
			webConector = new WebConector();
		}
		return webConector;		
	}

	public static Boolean sendData(String url, HashMap<String, String> map, String type){
		Log.e("sendData url ", url);
	     InputStream is = null;
		try{
	         /*HttpClient httpclient = new DefaultHttpClient();
	         HttpPost httppost = new HttpPost(url);
	         PostData postdata = new PostData();
	         httppost.setEntity(new UrlEncodedFormEntity(postdata.postdataready(map, type)));

	         // Execute HTTP Post Request
	         HttpResponse response = httpclient.execute(httppost);
	         HttpEntity entity = response.getEntity();
	            Log.e("webconector", " " + url);
	         is = entity.getContent();
	            Log.e("webconector", " get content " + is);
	         Log.e("sendData httppost", " " + httppost.getURI());*/
	     }catch(Exception e)
	     {
	    	 Log.e("sendData Error1", "" + e.getMessage());
	    	 Log.e("sendData Error2", "" + e.getStackTrace());
	    	 Log.e("sendData Error3", "" + e.toString());
	    	 e.printStackTrace();
	     }
		try{
	         BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	         StringBuilder sb = new StringBuilder();
	         String line = null;
	         while ((line = reader.readLine()) != null) {
	             sb.append(line + "\n");
	             Log.e("WebConector line", "" + line);
	         }
	         is.close();
	         ok = true;
	     } catch(Exception e){ok = false;}
		return ok;
	}
	public static ArrayList<HashMap<String, String>> getJSONfromURL(String url, String type) throws JSONException{
	     InputStream is = null;
	     String result = "";
	     json = null;
	      try{
	         HttpClient httpclient = new DefaultHttpClient();
	         HttpPost httppost = new HttpPost(url);
	         HttpResponse response = httpclient.execute(httppost);
	         HttpEntity entity = response.getEntity();
	         Log.e("webconector", " " + url);
	         is = entity.getContent();
	         Log.e("webconector", " get content " + is);
	     }catch(Exception e)
	     {
	    	 Log.e("WebConector Error", "" + e.getMessage());
	    	 Log.e("WebConector Error", "" + e.getStackTrace());
	    	 Log.e("WebConector Error", "" + e.toString());
	    	 e.printStackTrace();
	     }

	      try{
	         BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	         StringBuilder sb = new StringBuilder();
	         String line = null;
	         while ((line = reader.readLine()) != null) {
	             sb.append(line + "\n");
	             Log.e("WebConector line", "" + line);
	         }
	         is.close();
	         result=sb.toString();
	     } catch(Exception e){}

	     try{
	         json = new JSONObject(result);
	     }catch(JSONException e)
	     {
	    	 Log.e("WebConector Error2", "" + e.getMessage());
	    	 Log.e("WebConector Error2", "" + e.getStackTrace());
	     }

         if(json != null)
 		{
        	 Log.e("webconector", " json != null 161");
        	 weblistmap = new WebListMap();
	         mylist = new ArrayList<HashMap<String, String>>();
	         mylist = weblistmap.jsonToHashMap(json, type);
 		}
         Log.e("webconector", "return mylist");
         return mylist;
 		}
         
	public static boolean login(String url, HashMap<String, String> map) throws JSONException{
	     InputStream is = null;
	     String result = "";
	     AppMy app = AppMy.getinstance();
	     json = null;
	      try{
	    	 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			 nameValuePairs.add(new BasicNameValuePair("usuario", map.get("usuario")));		
			 nameValuePairs.add(new BasicNameValuePair("shaclave", map.get("shaclave")));
	         HttpClient httpclient = new DefaultHttpClient();
	         HttpPost httppost = new HttpPost(url);
	         httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	         HttpResponse response = httpclient.execute(httppost);
	         HttpEntity entity = response.getEntity();
	         Log.e("webconector", " " + url);
	         is = entity.getContent();
	         Log.e("webconector", " get content " + is);
	     }catch(Exception e)
	     {
	    	 Log.e("WebConector Error", "" + e.getMessage());
	    	 Log.e("WebConector Error", "" + e.getStackTrace());
	    	 Log.e("WebConector Error", "" + e.toString());
	    	 e.printStackTrace();
	     }

	      try{
	         BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	         StringBuilder sb = new StringBuilder();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             sb.append(line + "\n");
	             Log.e("WebConector line", "" + line);
	         }
	         is.close();
	         result=sb.toString();
	     } catch(Exception e){}

	     try{
	         json = new JSONObject(result);
	         Log.e("WebConector jsonobject", "ok");
	     }catch(JSONException e)
	     {
	    	 Log.e("WebConector jsonobject", "" + e.getMessage());
	    	 Log.e("WebConector jsonobject", "" + e.getStackTrace());
	     }

        if(json != null)
		{
        	Log.e("webconectorlogin", " getjsonarray");
    		JSONObject e = json.getJSONObject("carneempresa");
    	    entempresa = new Carne_empresacompleto();
    	    entempresa.setClave_usuario(e.getString(carne_empresa.clave_usuario));
    	    entempresa.setId_empresa(e.getString(carne_empresa.empresa_id_empresa));
    	    entempresa.setId_carne_empresa( e.getString(carne_empresa.id_carne_empresa));
    	    entempresa.setNombre_usuario( e.getString(carne_empresa.nombre_usuario));
    	    entempresa.setTipo_usuario_id_tipo_usuario( e.getString(carne_empresa.tipo_usuario_id_tipo_usuario));
			entempresa.setAlcance_empresa( e.getString(empresa.alcance_empresa));
			entempresa.setCargo_contacto_empresa( e.getString(empresa.cargo_contacto_empresa));
			entempresa.setDigito_verificador_empresa( e.getString(empresa.digito_verificador_empresa));
			entempresa.setEmail_empresa( e.getString(empresa.email_empresa));
			entempresa.setActividad_id_actividad( e.getString(empresa.actividad_id_actividad));
			entempresa.setId_empresa( e.getString(empresa.id_empresa));
			entempresa.setNombre_empresa( e.getString(empresa.nombre_empresa));
			entempresa.setNombre_contacto_empresa( e.getString(empresa.nombre_contacto_empresa));
			entempresa.setRut_empresa( e.getString(empresa.rut_empresa));
			app.setCarneEmpresa(entempresa);
			return true;
		}
        else
        {
        	return false;
        }
	 }
	public static void delete(String url) 
	{
	     InputStream is = null;
	      try{
	         HttpClient httpclient = new DefaultHttpClient();
	         HttpPost httppost = new HttpPost(url);
	         HttpResponse response = httpclient.execute(httppost);
	         HttpEntity entity = response.getEntity();
	         Log.e("webconector", " " + url);
	         is = entity.getContent();
	         Log.e("webconector", " get content " + is);
	     }catch(Exception e)
	     {
	    	 Log.e("WebConector Error", "" + e.getMessage());
	    	 Log.e("WebConector Error", "" + e.getStackTrace());
	    	 Log.e("WebConector Error", "" + e.toString());
	    	 e.printStackTrace();
	     }

	      try{
	         BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	         StringBuilder sb = new StringBuilder();
	         String line = null;
	         while ((line = reader.readLine()) != null) {
	             sb.append(line + "\n");
	             Log.e("WebConector line", "" + line);
	         }
	         is.close();
	     } catch(Exception e){}
		}
}
