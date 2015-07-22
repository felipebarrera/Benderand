
package cl.webinc.benderand.entidad;
									
public class Comuna
{
	private String id_comuna = "";
	private String codigo_comuna = "";
	private String nombre_comuna = "";
	private String provincia_id_provincia = "";
	
	
	public Comuna(String id_comuna, String codigo_comuna, String nombre_comuna, String provincia_id_provincia)
	{
		this.id_comuna = id_comuna;
		this.codigo_comuna = codigo_comuna;
		this.nombre_comuna = nombre_comuna;
		this.provincia_id_provincia = provincia_id_provincia;
		
	}
	public Comuna(){}
	public String getId_comuna() 
	{
		return id_comuna;
	}
	public String getCodigo_comuna() 
	{
		return codigo_comuna;
	}
	public String getNombre_comuna() 
	{
		return nombre_comuna;
	}
	public String getProvincia_id_provincia() 
	{
		return provincia_id_provincia;
	}
	public void setId_comuna(String id_comuna) 
	{
		this.id_comuna = id_comuna;
	}
	public void setCodigo_comuna(String codigo_comuna) 
	{
		this.codigo_comuna = codigo_comuna;
	}
	public void setNombre_comuna(String nombre_comuna) 
	{
		this.nombre_comuna = nombre_comuna;
	}
	public void setProvincia_id_provincia(String provincia_id_provincia) 
	{
		this.provincia_id_provincia = provincia_id_provincia;
	}
	
}