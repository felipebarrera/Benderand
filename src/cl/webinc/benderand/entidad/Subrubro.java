
package cl.webinc.benderand.entidad;
									
public class Subrubro
{
	private String id_subrubro = "";
	private String nombre_subrubro = "";
	private String rubro_id_rubro = "";
	
	
	public Subrubro(String id_subrubro, String nombre_subrubro, String rubro_id_rubro)
	{
		this.id_subrubro = id_subrubro;
		this.nombre_subrubro = nombre_subrubro;
		this.rubro_id_rubro = rubro_id_rubro;
		
	}
	public Subrubro(){}
	public String getId_subrubro() 
	{
		return id_subrubro;
	}
	public String getNombre_subrubro() 
	{
		return nombre_subrubro;
	}
	public String getRubro_id_rubro() 
	{
		return rubro_id_rubro;
	}
	public void setId_subrubro(String id_subrubro) 
	{
		this.id_subrubro = id_subrubro;
	}
	public void setNombre_subrubro(String nombre_subrubro) 
	{
		this.nombre_subrubro = nombre_subrubro;
	}
	public void setRubro_id_rubro(String rubro_id_rubro) 
	{
		this.rubro_id_rubro = rubro_id_rubro;
	}
	
}