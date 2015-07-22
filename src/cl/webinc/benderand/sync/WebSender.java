package cl.webinc.benderand.sync;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.util.Log;

public class WebSender
{
	private static WebSender WebSender = null;
	private static String web;
	private static String lista;
	private WebSender()
	{
		
	}
	public static WebSender getInstance()
	{
		if(WebSender == null)
		{
			WebSender = new WebSender();
		}
		return WebSender;		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sender(ContentValues values)
	{
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://"+ web +"/index.php/sincronizepost/"+ lista +"/get_Producto//7/7/7/7/7/0");
		try 
		{
			JSONObject json = new JSONObject();
			json.put("alto_cm", values.get("alto_cm"));
			json.put("ancho_cm", values.get("ancho_cm"));
			json.put("clase_prod", values.get("clase_prod"));
			json.put("cod_prod", values.get("cod_prod"));
			json.put("contenido", values.get("contenido"));
			json.put("cont_uni", values.get("cont_uni"));
			json.put("cont_uni_med", values.get("cont_uni_med"));
			json.put("descrip_prod", values.get("descrip_prod"));
			json.put("fabr", values.get("fabr"));
			json.put("fam_nec", values.get("fam_nec"));
			json.put("fam_prod", values.get("fam_prod"));
			json.put("fondo_cm", values.get("fondo_cm"));
			json.put("id_prod", values.get("id_prod"));
			json.put("id_subcat", values.get("subcategoria_id_subcat"));
			json.put("linea_prod", values.get("linea_prod"));
			json.put("marca_prod", values.get("marca_prod"));
			json.put("mod_prod", values.get("mod_prod"));
			json.put("nom_prod", values.get("nom_prod"));
			json.put("num_serie", values.get("num_serie"));
			json.put("peso_neto", values.get("peso_neto"));
			json.put("tipo_prod", values.get("tipo_prod"));
			json.put("uni_min", values.get("uni_min"));
			Log.e("", "json ok" + json.toString());
			List nameValuePair = new ArrayList(1);
			nameValuePair.add(new BasicNameValuePair("json", json.toString()));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
			HttpResponse response = httpClient.execute(httpPost);
			String responseBody = EntityUtils.toString(response.getEntity());
			Log.e("json", "respose " + responseBody);
		}catch (ClientProtocolException e) 
		{
			Log.e("json", "ClientProtocolException " + e);
		}
		catch (IOException e) 
		{
			Log.e("json", "IOException " + e);
		}
		catch (JSONException e) 
		{
			Log.e("json", "JSONException " + e);
		}
	}
}
