
package cl.webinc.benderand.entidad;
									
public class Cliente_empresa
{
	private String id_cliente_empresa = "";
	private String rut_cliente_empresa = "";
	private String digito_verificador = "";
	private String nombre = "";
	private String email_cliente_empresa = "";
	private String actividad_id_actividad = "";
	private String empresa_id_empresa = "";
	
	
	public Cliente_empresa(String id_cliente_empresa, String rut_cliente_empresa, String digito_verificador, String nombre, String email_cliente_empresa, String actividad_id_actividad, String empresa_id_empresa)
	{
		this.id_cliente_empresa = id_cliente_empresa;
		this.rut_cliente_empresa = rut_cliente_empresa;
		this.digito_verificador = digito_verificador;
		this.nombre = nombre;
		this.email_cliente_empresa = email_cliente_empresa;
		this.actividad_id_actividad = actividad_id_actividad;
		this.empresa_id_empresa = empresa_id_empresa;
		
	}
	public Cliente_empresa(){}
	public String getId_cliente_empresa() 
	{
		return id_cliente_empresa;
	}
	public String getRut_cliente_empresa() 
	{
		return rut_cliente_empresa;
	}
	public String getDigito_verificador() 
	{
		return digito_verificador;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public String getEmail_cliente_empresa() 
	{
		return email_cliente_empresa;
	}
	public String getActividad_id_actividad() 
	{
		return actividad_id_actividad;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public void setId_cliente_empresa(String id_cliente_empresa) 
	{
		this.id_cliente_empresa = id_cliente_empresa;
	}
	public void setRut_cliente_empresa(String rut_cliente_empresa) 
	{
		this.rut_cliente_empresa = rut_cliente_empresa;
	}
	public void setDigito_verificador(String digito_verificador) 
	{
		this.digito_verificador = digito_verificador;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public void setEmail_cliente_empresa(String email_cliente_empresa) 
	{
		this.email_cliente_empresa = email_cliente_empresa;
	}
	public void setActividad_id_actividad(String actividad_id_actividad) 
	{
		this.actividad_id_actividad = actividad_id_actividad;
	}
	public void setEmpresa_id_empresa(String empresa_id_empresa) 
	{
		this.empresa_id_empresa = empresa_id_empresa;
	}
	
}