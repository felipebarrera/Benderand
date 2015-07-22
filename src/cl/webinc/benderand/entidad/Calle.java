
package cl.webinc.benderand.entidad;
									
public class Calle
{
	private String id_calle = "";
	private String nombre_calle = "";
	private String comuna_id_comuna = "";
	
	
	public Calle(String id_calle, String nombre_calle, String comuna_id_comuna)
	{
		this.id_calle = id_calle;
		this.nombre_calle = nombre_calle;
		this.comuna_id_comuna = comuna_id_comuna;
		
	}
	public Calle(){}
	public String getId_calle() 
	{
		return id_calle;
	}
	public String getNombre_calle() 
	{
		return nombre_calle;
	}
	public String getComuna_id_comuna() 
	{
		return comuna_id_comuna;
	}
	public void setId_calle(String id_calle) 
	{
		this.id_calle = id_calle;
	}
	public void setNombre_calle(String nombre_calle) 
	{
		this.nombre_calle = nombre_calle;
	}
	public void setComuna_id_comuna(String comuna_id_comuna) 
	{
		this.comuna_id_comuna = comuna_id_comuna;
	}
	
}