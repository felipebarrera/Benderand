
package cl.webinc.benderand.entidad;
									
public class Mapa
{
	private String id = "";
	private String name = "";
	private String direccion = "";
	private String lat = "";
	private String lng = "";
	private String tipo = "";
	private String imagen = "";
	
	
	public Mapa(String id, String name, String direccion, String lat, String lng, String tipo, String imagen)
	{
		this.id = id;
		this.name = name;
		this.direccion = direccion;
		this.lat = lat;
		this.lng = lng;
		this.tipo = tipo;
		this.imagen = imagen;
		
	}
	public Mapa(){}
	public String getId() 
	{
		return id;
	}
	public String getName() 
	{
		return name;
	}
	public String getDireccion() 
	{
		return direccion;
	}
	public String getLat() 
	{
		return lat;
	}
	public String getLng() 
	{
		return lng;
	}
	public String getTipo() 
	{
		return tipo;
	}
	public String getImagen() 
	{
		return imagen;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}
	public void setLat(String lat) 
	{
		this.lat = lat;
	}
	public void setLng(String lng) 
	{
		this.lng = lng;
	}
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	public void setImagen(String imagen) 
	{
		this.imagen = imagen;
	}
	
}