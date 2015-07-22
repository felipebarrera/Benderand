
package cl.webinc.benderand.entidad;
									
public class Ubicacion
{
	private String id_ubicacion = "";
	private String numero_ubicacion = "";
	private String numero_interior = "";
	private String telefono_ubicacion = "";
	private String default_ubicacion = "";
	private String calle_id_calle = "";
	private String empresa_id_empresa = "";
	private String usuario_id_usuario = "";
	
	
	public Ubicacion(String id_ubicacion, String numero_ubicacion, String numero_interior, String telefono_ubicacion, String default_ubicacion, String calle_id_calle, String empresa_id_empresa, String usuario_id_usuario)
	{
		this.id_ubicacion = id_ubicacion;
		this.numero_ubicacion = numero_ubicacion;
		this.numero_interior = numero_interior;
		this.telefono_ubicacion = telefono_ubicacion;
		this.default_ubicacion = default_ubicacion;
		this.calle_id_calle = calle_id_calle;
		this.empresa_id_empresa = empresa_id_empresa;
		this.usuario_id_usuario = usuario_id_usuario;
		
	}
	public Ubicacion(){}
	public String getId_ubicacion() 
	{
		return id_ubicacion;
	}
	public String getNumero_ubicacion() 
	{
		return numero_ubicacion;
	}
	public String getNumero_interior() 
	{
		return numero_interior;
	}
	public String getTelefono_ubicacion() 
	{
		return telefono_ubicacion;
	}
	public String getDefault_ubicacion() 
	{
		return default_ubicacion;
	}
	public String getCalle_id_calle() 
	{
		return calle_id_calle;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public String getUsuario_id_usuario() 
	{
		return usuario_id_usuario;
	}
	public void setId_ubicacion(String id_ubicacion) 
	{
		this.id_ubicacion = id_ubicacion;
	}
	public void setNumero_ubicacion(String numero_ubicacion) 
	{
		this.numero_ubicacion = numero_ubicacion;
	}
	public void setNumero_interior(String numero_interior) 
	{
		this.numero_interior = numero_interior;
	}
	public void setTelefono_ubicacion(String telefono_ubicacion) 
	{
		this.telefono_ubicacion = telefono_ubicacion;
	}
	public void setDefault_ubicacion(String default_ubicacion) 
	{
		this.default_ubicacion = default_ubicacion;
	}
	public void setCalle_id_calle(String calle_id_calle) 
	{
		this.calle_id_calle = calle_id_calle;
	}
	public void setEmpresa_id_empresa(String empresa_id_empresa) 
	{
		this.empresa_id_empresa = empresa_id_empresa;
	}
	public void setUsuario_id_usuario(String usuario_id_usuario) 
	{
		this.usuario_id_usuario = usuario_id_usuario;
	}
	
}