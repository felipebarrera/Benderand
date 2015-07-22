
package cl.webinc.benderand.entidad;
									
public class Usuario
{
	private String id_usuario = "";
	private String tipo_usuario = "";
	private String nombre_usuario = "";
	private String clave = "";
	private String cliente_id_cliente = "";
	private String cliente_empresa_id_cliente_empresa = "";
	
	
	public Usuario(String id_usuario, String tipo_usuario, String nombre_usuario, String clave, String cliente_id_cliente, String cliente_empresa_id_cliente_empresa)
	{
		this.id_usuario = id_usuario;
		this.tipo_usuario = tipo_usuario;
		this.nombre_usuario = nombre_usuario;
		this.clave = clave;
		this.cliente_id_cliente = cliente_id_cliente;
		this.cliente_empresa_id_cliente_empresa = cliente_empresa_id_cliente_empresa;
		
	}
	public Usuario(){}
	public String getId_usuario() 
	{
		return id_usuario;
	}
	public String getTipo_usuario() 
	{
		return tipo_usuario;
	}
	public String getNombre_usuario() 
	{
		return nombre_usuario;
	}
	public String getClave() 
	{
		return clave;
	}
	public String getCliente_id_cliente() 
	{
		return cliente_id_cliente;
	}
	public String getCliente_empresa_id_cliente_empresa() 
	{
		return cliente_empresa_id_cliente_empresa;
	}
	public void setId_usuario(String id_usuario) 
	{
		this.id_usuario = id_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) 
	{
		this.tipo_usuario = tipo_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) 
	{
		this.nombre_usuario = nombre_usuario;
	}
	public void setClave(String clave) 
	{
		this.clave = clave;
	}
	public void setCliente_id_cliente(String cliente_id_cliente) 
	{
		this.cliente_id_cliente = cliente_id_cliente;
	}
	public void setCliente_empresa_id_cliente_empresa(String cliente_empresa_id_cliente_empresa) 
	{
		this.cliente_empresa_id_cliente_empresa = cliente_empresa_id_cliente_empresa;
	}
	
}