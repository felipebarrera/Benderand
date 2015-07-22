
package cl.webinc.benderand.entidad;
									
public class Region
{
	private String id_region = "";
	private String nombre_region = "";
	private String codigo_region = "";
	private String pais_id_pais = "";
	
	
	public Region(String id_region, String nombre_region, String codigo_region, String pais_id_pais)
	{
		this.id_region = id_region;
		this.nombre_region = nombre_region;
		this.codigo_region = codigo_region;
		this.pais_id_pais = pais_id_pais;
		
	}
	public Region(){}
	public String getId_region() 
	{
		return id_region;
	}
	public String getNombre_region() 
	{
		return nombre_region;
	}
	public String getCodigo_region() 
	{
		return codigo_region;
	}
	public String getPais_id_pais() 
	{
		return pais_id_pais;
	}
	public void setId_region(String id_region) 
	{
		this.id_region = id_region;
	}
	public void setNombre_region(String nombre_region) 
	{
		this.nombre_region = nombre_region;
	}
	public void setCodigo_region(String codigo_region) 
	{
		this.codigo_region = codigo_region;
	}
	public void setPais_id_pais(String pais_id_pais) 
	{
		this.pais_id_pais = pais_id_pais;
	}
	
}