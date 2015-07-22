
package cl.webinc.benderand.entidad;
									
public class Rubro
{
	private String id_rubro = "";
	private String nombre_rubro = "";
	
	
	public Rubro(String id_rubro, String nombre_rubro)
	{
		this.id_rubro = id_rubro;
		this.nombre_rubro = nombre_rubro;
		
	}
	public Rubro(){}
	public String getId_rubro() 
	{
		return id_rubro;
	}
	public String getNombre_rubro() 
	{
		return nombre_rubro;
	}
	public void setId_rubro(String id_rubro) 
	{
		this.id_rubro = id_rubro;
	}
	public void setNombre_rubro(String nombre_rubro) 
	{
		this.nombre_rubro = nombre_rubro;
	}
	
}