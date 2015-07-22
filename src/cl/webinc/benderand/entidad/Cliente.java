
package cl.webinc.benderand.entidad;
									
public class Cliente
{
	private String id_cliente = "";
	private String rut_cliente = "";
	private String digito_verificador = "";
	private String nombre_cliente = "";
	private String segundo_nombre_cliente = "";
	private String apellido_cliente = "";
	private String segundo_apellido_cliente = "";
	private String actividad = "";
	private String area_actividad = "";
	private String dia_fecha_nacimiento = "";
	private String mes_fecha_nacimiento = "";
	private String ano_fecha_nacimiento = "";
	private String edad = "";
	private String email = "";
	private String celular = "";
	private String telefono = "";
	
	
	public Cliente(String id_cliente, String rut_cliente, String digito_verificador, String nombre_cliente, String segundo_nombre_cliente, String apellido_cliente, String segundo_apellido_cliente, String actividad, String area_actividad, String dia_fecha_nacimiento, String mes_fecha_nacimiento, String ano_fecha_nacimiento, String edad, String email, String celular, String telefono)
	{
		this.id_cliente = id_cliente;
		this.rut_cliente = rut_cliente;
		this.digito_verificador = digito_verificador;
		this.nombre_cliente = nombre_cliente;
		this.segundo_nombre_cliente = segundo_nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.segundo_apellido_cliente = segundo_apellido_cliente;
		this.actividad = actividad;
		this.area_actividad = area_actividad;
		this.dia_fecha_nacimiento = dia_fecha_nacimiento;
		this.mes_fecha_nacimiento = mes_fecha_nacimiento;
		this.ano_fecha_nacimiento = ano_fecha_nacimiento;
		this.edad = edad;
		this.email = email;
		this.celular = celular;
		this.telefono = telefono;
		
	}
	public Cliente(){}
	public String getId_cliente() 
	{
		return id_cliente;
	}
	public String getRut_cliente() 
	{
		return rut_cliente;
	}
	public String getDigito_verificador() 
	{
		return digito_verificador;
	}
	public String getNombre_cliente() 
	{
		return nombre_cliente;
	}
	public String getSegundo_nombre_cliente() 
	{
		return segundo_nombre_cliente;
	}
	public String getApellido_cliente() 
	{
		return apellido_cliente;
	}
	public String getSegundo_apellido_cliente() 
	{
		return segundo_apellido_cliente;
	}
	public String getActividad() 
	{
		return actividad;
	}
	public String getArea_actividad() 
	{
		return area_actividad;
	}
	public String getDia_fecha_nacimiento() 
	{
		return dia_fecha_nacimiento;
	}
	public String getMes_fecha_nacimiento() 
	{
		return mes_fecha_nacimiento;
	}
	public String getAno_fecha_nacimiento() 
	{
		return ano_fecha_nacimiento;
	}
	public String getEdad() 
	{
		return edad;
	}
	public String getEmail() 
	{
		return email;
	}
	public String getCelular() 
	{
		return celular;
	}
	public String getTelefono() 
	{
		return telefono;
	}
	public void setId_cliente(String id_cliente) 
	{
		this.id_cliente = id_cliente;
	}
	public void setRut_cliente(String rut_cliente) 
	{
		this.rut_cliente = rut_cliente;
	}
	public void setDigito_verificador(String digito_verificador) 
	{
		this.digito_verificador = digito_verificador;
	}
	public void setNombre_cliente(String nombre_cliente) 
	{
		this.nombre_cliente = nombre_cliente;
	}
	public void setSegundo_nombre_cliente(String segundo_nombre_cliente) 
	{
		this.segundo_nombre_cliente = segundo_nombre_cliente;
	}
	public void setApellido_cliente(String apellido_cliente) 
	{
		this.apellido_cliente = apellido_cliente;
	}
	public void setSegundo_apellido_cliente(String segundo_apellido_cliente) 
	{
		this.segundo_apellido_cliente = segundo_apellido_cliente;
	}
	public void setActividad(String actividad) 
	{
		this.actividad = actividad;
	}
	public void setArea_actividad(String area_actividad) 
	{
		this.area_actividad = area_actividad;
	}
	public void setDia_fecha_nacimiento(String dia_fecha_nacimiento) 
	{
		this.dia_fecha_nacimiento = dia_fecha_nacimiento;
	}
	public void setMes_fecha_nacimiento(String mes_fecha_nacimiento) 
	{
		this.mes_fecha_nacimiento = mes_fecha_nacimiento;
	}
	public void setAno_fecha_nacimiento(String ano_fecha_nacimiento) 
	{
		this.ano_fecha_nacimiento = ano_fecha_nacimiento;
	}
	public void setEdad(String edad) 
	{
		this.edad = edad;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public void setCelular(String celular) 
	{
		this.celular = celular;
	}
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
}