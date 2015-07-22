
package cl.webinc.benderand.entidad;
									
public class Carne_empresa
{
	private String id_carne_empresa = "";
	private String nombre_usuario = "";
	private String clave_usuario = "";
	private String empresa_id_empresa = "";
	private String persona_id_persona = "";
	private String tipo_usuario_id_tipo_usuario = "";
	
	
	public Carne_empresa(String id_carne_empresa, String nombre_usuario, String clave_usuario, String empresa_id_empresa, String persona_id_persona, String tipo_usuario_id_tipo_usuario)
	{
		this.id_carne_empresa = id_carne_empresa;
		this.nombre_usuario = nombre_usuario;
		this.clave_usuario = clave_usuario;
		this.empresa_id_empresa = empresa_id_empresa;
		this.persona_id_persona = persona_id_persona;
		this.tipo_usuario_id_tipo_usuario = tipo_usuario_id_tipo_usuario;
		
	}
	public Carne_empresa(){}
	public String getId_carne_empresa() 
	{
		return id_carne_empresa;
	}
	public String getNombre_usuario() 
	{
		return nombre_usuario;
	}
	public String getClave_usuario() 
	{
		return clave_usuario;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public String getPersona_id_persona() 
	{
		return persona_id_persona;
	}
	public String getTipo_usuario_id_tipo_usuario() 
	{
		return tipo_usuario_id_tipo_usuario;
	}
	public void setId_carne_empresa(String id_carne_empresa) 
	{
		this.id_carne_empresa = id_carne_empresa;
	}
	public void setNombre_usuario(String nombre_usuario) 
	{
		this.nombre_usuario = nombre_usuario;
	}
	public void setClave_usuario(String clave_usuario) 
	{
		this.clave_usuario = clave_usuario;
	}
	public void setEmpresa_id_empresa(String empresa_id_empresa) 
	{
		this.empresa_id_empresa = empresa_id_empresa;
	}
	public void setPersona_id_persona(String persona_id_persona) 
	{
		this.persona_id_persona = persona_id_persona;
	}
	public void setTipo_usuario_id_tipo_usuario(String tipo_usuario_id_tipo_usuario) 
	{
		this.tipo_usuario_id_tipo_usuario = tipo_usuario_id_tipo_usuario;
	}
	
}