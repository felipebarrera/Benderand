
package cl.webinc.benderand.entidad;
									
public class Talla
{
	private String id_talla = "";
	private String am_largo = "";
	private String am_ancho = "";
	private String am_fondo = "";
	private String eu_largo = "";
	private String eu_ancho = "";
	private String eu_fondo = "";
	private String num_largo = "";
	private String num_ancho = "";
	private String num_fondo = "";
	private String producto_id_producto = "";
	
	
	public Talla(String id_talla, String am_largo, String am_ancho, String am_fondo, String eu_largo, String eu_ancho, String eu_fondo, String num_largo, String num_ancho, String num_fondo, String producto_id_producto)
	{
		this.id_talla = id_talla;
		this.am_largo = am_largo;
		this.am_ancho = am_ancho;
		this.am_fondo = am_fondo;
		this.eu_largo = eu_largo;
		this.eu_ancho = eu_ancho;
		this.eu_fondo = eu_fondo;
		this.num_largo = num_largo;
		this.num_ancho = num_ancho;
		this.num_fondo = num_fondo;
		this.producto_id_producto = producto_id_producto;
		
	}
	public Talla(){}
	public String getId_talla() 
	{
		return id_talla;
	}
	public String getAm_largo() 
	{
		return am_largo;
	}
	public String getAm_ancho() 
	{
		return am_ancho;
	}
	public String getAm_fondo() 
	{
		return am_fondo;
	}
	public String getEu_largo() 
	{
		return eu_largo;
	}
	public String getEu_ancho() 
	{
		return eu_ancho;
	}
	public String getEu_fondo() 
	{
		return eu_fondo;
	}
	public String getNum_largo() 
	{
		return num_largo;
	}
	public String getNum_ancho() 
	{
		return num_ancho;
	}
	public String getNum_fondo() 
	{
		return num_fondo;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public void setId_talla(String id_talla) 
	{
		this.id_talla = id_talla;
	}
	public void setAm_largo(String am_largo) 
	{
		this.am_largo = am_largo;
	}
	public void setAm_ancho(String am_ancho) 
	{
		this.am_ancho = am_ancho;
	}
	public void setAm_fondo(String am_fondo) 
	{
		this.am_fondo = am_fondo;
	}
	public void setEu_largo(String eu_largo) 
	{
		this.eu_largo = eu_largo;
	}
	public void setEu_ancho(String eu_ancho) 
	{
		this.eu_ancho = eu_ancho;
	}
	public void setEu_fondo(String eu_fondo) 
	{
		this.eu_fondo = eu_fondo;
	}
	public void setNum_largo(String num_largo) 
	{
		this.num_largo = num_largo;
	}
	public void setNum_ancho(String num_ancho) 
	{
		this.num_ancho = num_ancho;
	}
	public void setNum_fondo(String num_fondo) 
	{
		this.num_fondo = num_fondo;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	
}