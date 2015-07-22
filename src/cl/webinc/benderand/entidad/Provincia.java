
package cl.webinc.benderand.entidad;
									
public class Provincia
{
	private String id_provincia = "";
	private String nombre_provincia = "";
	private String codigo_provincia = "";
	private String region_id_region = "";
	
	
	public Provincia(String id_provincia, String nombre_provincia, String codigo_provincia, String region_id_region)
	{
		this.id_provincia = id_provincia;
		this.nombre_provincia = nombre_provincia;
		this.codigo_provincia = codigo_provincia;
		this.region_id_region = region_id_region;
		
	}
	public Provincia(){}
	public String getId_provincia() 
	{
		return id_provincia;
	}
	public String getNombre_provincia() 
	{
		return nombre_provincia;
	}
	public String getCodigo_provincia() 
	{
		return codigo_provincia;
	}
	public String getRegion_id_region() 
	{
		return region_id_region;
	}
	public void setId_provincia(String id_provincia) 
	{
		this.id_provincia = id_provincia;
	}
	public void setNombre_provincia(String nombre_provincia) 
	{
		this.nombre_provincia = nombre_provincia;
	}
	public void setCodigo_provincia(String codigo_provincia) 
	{
		this.codigo_provincia = codigo_provincia;
	}
	public void setRegion_id_region(String region_id_region) 
	{
		this.region_id_region = region_id_region;
	}
	
}