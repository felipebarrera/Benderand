
package cl.webinc.benderand.entidad;
									
public class Tipo_usuario
{
	private String id_tipo_usuario = "";
	private String nombre_tipo_usuario = "";
	
	
	public Tipo_usuario(String id_tipo_usuario, String nombre_tipo_usuario)
	{
		this.id_tipo_usuario = id_tipo_usuario;
		this.nombre_tipo_usuario = nombre_tipo_usuario;
		
	}
	public Tipo_usuario(){}
	public String getId_tipo_usuario() 
	{
		return id_tipo_usuario;
	}
	public String getNombre_tipo_usuario() 
	{
		return nombre_tipo_usuario;
	}
	public void setId_tipo_usuario(String id_tipo_usuario) 
	{
		this.id_tipo_usuario = id_tipo_usuario;
	}
	public void setNombre_tipo_usuario(String nombre_tipo_usuario) 
	{
		this.nombre_tipo_usuario = nombre_tipo_usuario;
	}
	
}