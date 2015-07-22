package cl.webinc.benderand.sync;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import cl.webinc.benderand.util.Constantes;

public class CursorWeb 
{
	private static JSONObject json = null;
	private static ArrayList<HashMap<String, String>> mylist = null;
	private static WebListMap weblistmap;
	private static String url;
	private static String type;
	public ArrayList<HashMap<String, String>> cursor(int match, String Order) throws JSONException 
	{
		switch (match)
		{
			case Constantes.PRODUCTOCOMPLETO:
			break;	
			default:
			Log.e("Cursor web", "no se encontro la tabla");				
		}

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
	        	 Log.e("webconector", " json != null 164");
	        	 weblistmap = new WebListMap();
		         mylist = new ArrayList<HashMap<String, String>>();
		         mylist = weblistmap.jsonToHashMap(json, type);
	 		}
         Log.e("webconector", "return mylist");
         return mylist;
 		}
}

