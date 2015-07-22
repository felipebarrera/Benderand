
package cl.webinc.benderand.entidad;
									
public class Ci_sessions
{
	private String session_id = "";
	private String ip_address = "";
	private String user_agent = "";
	private String id_user = "";
	private String nombre_apellido = "";
	private String email_user = "";
	private String last_activity = "";
	private String user_data = "";
	
	
	public Ci_sessions(String session_id, String ip_address, String user_agent, String id_user, String nombre_apellido, String email_user, String last_activity, String user_data)
	{
		this.session_id = session_id;
		this.ip_address = ip_address;
		this.user_agent = user_agent;
		this.id_user = id_user;
		this.nombre_apellido = nombre_apellido;
		this.email_user = email_user;
		this.last_activity = last_activity;
		this.user_data = user_data;
		
	}
	public Ci_sessions(){}
	public String getSession_id() 
	{
		return session_id;
	}
	public String getIp_address() 
	{
		return ip_address;
	}
	public String getUser_agent() 
	{
		return user_agent;
	}
	public String getId_user() 
	{
		return id_user;
	}
	public String getNombre_apellido() 
	{
		return nombre_apellido;
	}
	public String getEmail_user() 
	{
		return email_user;
	}
	public String getLast_activity() 
	{
		return last_activity;
	}
	public String getUser_data() 
	{
		return user_data;
	}
	public void setSession_id(String session_id) 
	{
		this.session_id = session_id;
	}
	public void setIp_address(String ip_address) 
	{
		this.ip_address = ip_address;
	}
	public void setUser_agent(String user_agent) 
	{
		this.user_agent = user_agent;
	}
	public void setId_user(String id_user) 
	{
		this.id_user = id_user;
	}
	public void setNombre_apellido(String nombre_apellido) 
	{
		this.nombre_apellido = nombre_apellido;
	}
	public void setEmail_user(String email_user) 
	{
		this.email_user = email_user;
	}
	public void setLast_activity(String last_activity) 
	{
		this.last_activity = last_activity;
	}
	public void setUser_data(String user_data) 
	{
		this.user_data = user_data;
	}
	
}