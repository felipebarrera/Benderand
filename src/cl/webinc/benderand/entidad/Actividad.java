
package cl.webinc.benderand.entidad;
									
public class Actividad
{
	private String id_actividad = "";
	private String nombre_actividad = "";
	private String codigo_actividad = "";
	private String categoria_actividad = "";
	private String afectoiva_actividad = "";
	private String disponible_internet_actividad = "";
	private String subrubro_id_subrubro = "";
	
	
	public Actividad(String id_actividad, String nombre_actividad, String codigo_actividad, String categoria_actividad, String afectoiva_actividad, String disponible_internet_actividad, String subrubro_id_subrubro)
	{
		this.id_actividad = id_actividad;
		this.nombre_actividad = nombre_actividad;
		this.codigo_actividad = codigo_actividad;
		this.categoria_actividad = categoria_actividad;
		this.afectoiva_actividad = afectoiva_actividad;
		this.disponible_internet_actividad = disponible_internet_actividad;
		this.subrubro_id_subrubro = subrubro_id_subrubro;
		
	}
	public Actividad(){}
	public String getId_actividad() 
	{
		return id_actividad;
	}
	public String getNombre_actividad() 
	{
		return nombre_actividad;
	}
	public String getCodigo_actividad() 
	{
		return codigo_actividad;
	}
	public String getCategoria_actividad() 
	{
		return categoria_actividad;
	}
	public String getAfectoiva_actividad() 
	{
		return afectoiva_actividad;
	}
	public String getDisponible_internet_actividad() 
	{
		return disponible_internet_actividad;
	}
	public String getSubrubro_id_subrubro() 
	{
		return subrubro_id_subrubro;
	}
	public void setId_actividad(String id_actividad) 
	{
		this.id_actividad = id_actividad;
	}
	public void setNombre_actividad(String nombre_actividad) 
	{
		this.nombre_actividad = nombre_actividad;
	}
	public void setCodigo_actividad(String codigo_actividad) 
	{
		this.codigo_actividad = codigo_actividad;
	}
	public void setCategoria_actividad(String categoria_actividad) 
	{
		this.categoria_actividad = categoria_actividad;
	}
	public void setAfectoiva_actividad(String afectoiva_actividad) 
	{
		this.afectoiva_actividad = afectoiva_actividad;
	}
	public void setDisponible_internet_actividad(String disponible_internet_actividad) 
	{
		this.disponible_internet_actividad = disponible_internet_actividad;
	}
	public void setSubrubro_id_subrubro(String subrubro_id_subrubro) 
	{
		this.subrubro_id_subrubro = subrubro_id_subrubro;
	}
	
}