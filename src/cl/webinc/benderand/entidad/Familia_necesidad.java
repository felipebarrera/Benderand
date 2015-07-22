
package cl.webinc.benderand.entidad;
									
public class Familia_necesidad
{
	private String id_familia_necesidad = "";
	private String nombre_familia_necesidad = "";
	
	
	public Familia_necesidad(String id_familia_necesidad, String nombre_familia_necesidad)
	{
		this.id_familia_necesidad = id_familia_necesidad;
		this.nombre_familia_necesidad = nombre_familia_necesidad;
		
	}
	public Familia_necesidad(){}
	public String getId_familia_necesidad() 
	{
		return id_familia_necesidad;
	}
	public String getNombre_familia_necesidad() 
	{
		return nombre_familia_necesidad;
	}
	public void setId_familia_necesidad(String id_familia_necesidad) 
	{
		this.id_familia_necesidad = id_familia_necesidad;
	}
	public void setNombre_familia_necesidad(String nombre_familia_necesidad) 
	{
		this.nombre_familia_necesidad = nombre_familia_necesidad;
	}
	
}