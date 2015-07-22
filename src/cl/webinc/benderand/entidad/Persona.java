
package cl.webinc.benderand.entidad;
									
public class Persona
{
	private String id_persona = "";
	private String rut_persona = "";
	private String digito_verificador = "";
	private String nombre_persona = "";
	private String segundo_nombre_persona = "";
	private String apellido_persona = "";
	private String segundo_apellido_persona = "";
	private String actividad = "";
	private String area_actividad = "";
	private String dia_fecha_nacimiento = "";
	private String mes_fecha_nacimiento = "";
	private String ano_fecha_nacimiento = "";
	private String edad = "";
	private String email = "";
	private String celular = "";
	private String telefono = "";
	
	
	public Persona(String id_persona, String rut_persona, String digito_verificador, String nombre_persona, String segundo_nombre_persona, String apellido_persona, String segundo_apellido_persona, String actividad, String area_actividad, String dia_fecha_nacimiento, String mes_fecha_nacimiento, String ano_fecha_nacimiento, String edad, String email, String celular, String telefono)
	{
		this.id_persona = id_persona;
		this.rut_persona = rut_persona;
		this.digito_verificador = digito_verificador;
		this.nombre_persona = nombre_persona;
		this.segundo_nombre_persona = segundo_nombre_persona;
		this.apellido_persona = apellido_persona;
		this.segundo_apellido_persona = segundo_apellido_persona;
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
	public Persona(){}
	public String getId_persona() 
	{
		return id_persona;
	}
	public String getRut_persona() 
	{
		return rut_persona;
	}
	public String getDigito_verificador() 
	{
		return digito_verificador;
	}
	public String getNombre_persona() 
	{
		return nombre_persona;
	}
	public String getSegundo_nombre_persona() 
	{
		return segundo_nombre_persona;
	}
	public String getApellido_persona() 
	{
		return apellido_persona;
	}
	public String getSegundo_apellido_persona() 
	{
		return segundo_apellido_persona;
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
	public void setId_persona(String id_persona) 
	{
		this.id_persona = id_persona;
	}
	public void setRut_persona(String rut_persona) 
	{
		this.rut_persona = rut_persona;
	}
	public void setDigito_verificador(String digito_verificador) 
	{
		this.digito_verificador = digito_verificador;
	}
	public void setNombre_persona(String nombre_persona) 
	{
		this.nombre_persona = nombre_persona;
	}
	public void setSegundo_nombre_persona(String segundo_nombre_persona) 
	{
		this.segundo_nombre_persona = segundo_nombre_persona;
	}
	public void setApellido_persona(String apellido_persona) 
	{
		this.apellido_persona = apellido_persona;
	}
	public void setSegundo_apellido_persona(String segundo_apellido_persona) 
	{
		this.segundo_apellido_persona = segundo_apellido_persona;
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