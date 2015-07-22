
package cl.webinc.benderand.entidad;
									
public class Empresa
{
	private String id_empresa = "";
	private String rut_empresa = "";
	private String digito_verificador_empresa = "";
	private String nombre_empresa = "";
	private String nombre_contacto_empresa = "";
	private String cargo_contacto_empresa = "";
	private String email_empresa = "";
	private String alcance_empresa = "";
	private String telefono_empresa = "";
	private String actividad_id_actividad = "";
	private String tipo_empresa_id_tipo_empresa = "";
	
	
	public Empresa(String id_empresa, String rut_empresa, String digito_verificador_empresa, String nombre_empresa, String nombre_contacto_empresa, String cargo_contacto_empresa, String email_empresa, String alcance_empresa, String telefono_empresa, String actividad_id_actividad, String tipo_empresa_id_tipo_empresa)
	{
		this.id_empresa = id_empresa;
		this.rut_empresa = rut_empresa;
		this.digito_verificador_empresa = digito_verificador_empresa;
		this.nombre_empresa = nombre_empresa;
		this.nombre_contacto_empresa = nombre_contacto_empresa;
		this.cargo_contacto_empresa = cargo_contacto_empresa;
		this.email_empresa = email_empresa;
		this.alcance_empresa = alcance_empresa;
		this.telefono_empresa = telefono_empresa;
		this.actividad_id_actividad = actividad_id_actividad;
		this.tipo_empresa_id_tipo_empresa = tipo_empresa_id_tipo_empresa;
		
	}
	public Empresa(){}
	public String getId_empresa() 
	{
		return id_empresa;
	}
	public String getRut_empresa() 
	{
		return rut_empresa;
	}
	public String getDigito_verificador_empresa() 
	{
		return digito_verificador_empresa;
	}
	public String getNombre_empresa() 
	{
		return nombre_empresa;
	}
	public String getNombre_contacto_empresa() 
	{
		return nombre_contacto_empresa;
	}
	public String getCargo_contacto_empresa() 
	{
		return cargo_contacto_empresa;
	}
	public String getEmail_empresa() 
	{
		return email_empresa;
	}
	public String getAlcance_empresa() 
	{
		return alcance_empresa;
	}
	public String getTelefono_empresa() 
	{
		return telefono_empresa;
	}
	public String getActividad_id_actividad() 
	{
		return actividad_id_actividad;
	}
	public String getTipo_empresa_id_tipo_empresa() 
	{
		return tipo_empresa_id_tipo_empresa;
	}
	public void setId_empresa(String id_empresa) 
	{
		this.id_empresa = id_empresa;
	}
	public void setRut_empresa(String rut_empresa) 
	{
		this.rut_empresa = rut_empresa;
	}
	public void setDigito_verificador_empresa(String digito_verificador_empresa) 
	{
		this.digito_verificador_empresa = digito_verificador_empresa;
	}
	public void setNombre_empresa(String nombre_empresa) 
	{
		this.nombre_empresa = nombre_empresa;
	}
	public void setNombre_contacto_empresa(String nombre_contacto_empresa) 
	{
		this.nombre_contacto_empresa = nombre_contacto_empresa;
	}
	public void setCargo_contacto_empresa(String cargo_contacto_empresa) 
	{
		this.cargo_contacto_empresa = cargo_contacto_empresa;
	}
	public void setEmail_empresa(String email_empresa) 
	{
		this.email_empresa = email_empresa;
	}
	public void setAlcance_empresa(String alcance_empresa) 
	{
		this.alcance_empresa = alcance_empresa;
	}
	public void setTelefono_empresa(String telefono_empresa) 
	{
		this.telefono_empresa = telefono_empresa;
	}
	public void setActividad_id_actividad(String actividad_id_actividad) 
	{
		this.actividad_id_actividad = actividad_id_actividad;
	}
	public void setTipo_empresa_id_tipo_empresa(String tipo_empresa_id_tipo_empresa) 
	{
		this.tipo_empresa_id_tipo_empresa = tipo_empresa_id_tipo_empresa;
	}
	
}