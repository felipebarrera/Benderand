
package cl.webinc.benderand.entidad;
									
public class Tipo_documento
{
	private String id_tipo_documento = "";
	private String nombre_tipo_documento = "";
	
	
	public Tipo_documento(String id_tipo_documento, String nombre_tipo_documento)
	{
		this.id_tipo_documento = id_tipo_documento;
		this.nombre_tipo_documento = nombre_tipo_documento;
		
	}
	public Tipo_documento(){}
	public String getId_tipo_documento() 
	{
		return id_tipo_documento;
	}
	public String getNombre_tipo_documento() 
	{
		return nombre_tipo_documento;
	}
	public void setId_tipo_documento(String id_tipo_documento) 
	{
		this.id_tipo_documento = id_tipo_documento;
	}
	public void setNombre_tipo_documento(String nombre_tipo_documento) 
	{
		this.nombre_tipo_documento = nombre_tipo_documento;
	}
	
}