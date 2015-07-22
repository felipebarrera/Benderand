
package cl.webinc.benderand.entidad;
									
public class Gasto
{
	private String id_gasto = "";
	private String nombre_gasto = "";
	private String id_usuario = "";
	private String monto_gasto = "";
	private String fecha_gasto = "";
	private String empresa_id_empre = "";
	
	
	public Gasto(String id_gasto, String nombre_gasto, String id_usuario, String monto_gasto, String fecha_gasto, String empresa_id_empre)
	{
		this.id_gasto = id_gasto;
		this.nombre_gasto = nombre_gasto;
		this.id_usuario = id_usuario;
		this.monto_gasto = monto_gasto;
		this.fecha_gasto = fecha_gasto;
		this.empresa_id_empre = empresa_id_empre;
		
	}
	public Gasto(){}
	public String getId_gasto() 
	{
		return id_gasto;
	}
	public String getNombre_gasto() 
	{
		return nombre_gasto;
	}
	public String getId_usuario() 
	{
		return id_usuario;
	}
	public String getMonto_gasto() 
	{
		return monto_gasto;
	}
	public String getFecha_gasto() 
	{
		return fecha_gasto;
	}
	public String getEmpresa_id_empre() 
	{
		return empresa_id_empre;
	}
	public void setId_gasto(String id_gasto) 
	{
		this.id_gasto = id_gasto;
	}
	public void setNombre_gasto(String nombre_gasto) 
	{
		this.nombre_gasto = nombre_gasto;
	}
	public void setId_usuario(String id_usuario) 
	{
		this.id_usuario = id_usuario;
	}
	public void setMonto_gasto(String monto_gasto) 
	{
		this.monto_gasto = monto_gasto;
	}
	public void setFecha_gasto(String fecha_gasto) 
	{
		this.fecha_gasto = fecha_gasto;
	}
	public void setEmpresa_id_empre(String empresa_id_empre) 
	{
		this.empresa_id_empre = empresa_id_empre;
	}
	
}