package cl.webinc.benderand;

import android.content.Context;
import android.net.ConnectivityManager;

import java.util.HashMap;

import cl.webinc.benderand.entidad.Carne_empresa;
import cl.webinc.benderand.entidad.Carne_empresacompleto;

public class AppMy
{
	private Carne_empresacompleto carneEmpresa;
	private Carne_empresa carneEmpresaProd;
    private static AppMy app;
    private Boolean resultado = Boolean.FALSE;
    private HashMap<String, String> resultadovalor = new HashMap<String, String>();
	private HashMap<String, String> extra = new HashMap<String, String>();
    private String url = "192.168.1.103/webinc";
    private boolean external = false;
    //private String url = "www.webinc.cl";

    private AppMy() {
        super();
    }
    public static AppMy getinstance() 
    {
    	if(app == null)
    	{
    		app = new AppMy();
    	}
		return app;       	
    }
	public boolean isOnline(Context context) {
	    ConnectivityManager cm =
	        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

	    return cm.getActiveNetworkInfo() != null && 
	       cm.getActiveNetworkInfo().isConnected();
	}
	public Carne_empresacompleto getCarneEmpresa()
	{		
		return carneEmpresa;
	}
	public void setCarneEmpresa(Carne_empresacompleto carneEmpresa)
	{		
		this.carneEmpresa = carneEmpresa;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HashMap<String, String> getExtra() {
		return extra;
	}
	public void setExtra(HashMap<String, String> extra) {
		this.extra = extra;
	}
	public Carne_empresa getCarneEmpresaProd() {
		return carneEmpresaProd;
	}
	public void setCarneEmpresaProd(Carne_empresa carneEmpresaProd) {
		this.carneEmpresaProd = carneEmpresaProd;
	}
	public Boolean getResultado() {
		return resultado;
	}
	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}
	public HashMap<String, String> getResultadovalor() {
		return resultadovalor;
	}
	public void setResultadovalor(HashMap<String, String> resultadovalor) {
		this.resultadovalor = resultadovalor;
	}
	public boolean isExternal() {
		return external;
	}
	public void setExternal(boolean external) {
		this.external = external;
	}
}
