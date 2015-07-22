
package cl.webinc.benderand.entidad;
									
public class Envio
{
	private String id_envio = "";
	private String direccion_alternativa = "";
	private String fecha_entrega = "";
	private String hora_entrega = "";
	private String venta_id_venta = "";
	private String enviado = "";
	
	
	public Envio(String id_envio, String direccion_alternativa, String fecha_entrega, String hora_entrega, String venta_id_venta, String enviado)
	{
		this.id_envio = id_envio;
		this.direccion_alternativa = direccion_alternativa;
		this.fecha_entrega = fecha_entrega;
		this.hora_entrega = hora_entrega;
		this.venta_id_venta = venta_id_venta;
		this.enviado = enviado;
		
	}
	public Envio(){}
	public String getId_envio() 
	{
		return id_envio;
	}
	public String getDireccion_alternativa() 
	{
		return direccion_alternativa;
	}
	public String getFecha_entrega() 
	{
		return fecha_entrega;
	}
	public String getHora_entrega() 
	{
		return hora_entrega;
	}
	public String getVenta_id_venta() 
	{
		return venta_id_venta;
	}
	public String getEnviado() 
	{
		return enviado;
	}
	public void setId_envio(String id_envio) 
	{
		this.id_envio = id_envio;
	}
	public void setDireccion_alternativa(String direccion_alternativa) 
	{
		this.direccion_alternativa = direccion_alternativa;
	}
	public void setFecha_entrega(String fecha_entrega) 
	{
		this.fecha_entrega = fecha_entrega;
	}
	public void setHora_entrega(String hora_entrega) 
	{
		this.hora_entrega = hora_entrega;
	}
	public void setVenta_id_venta(String venta_id_venta) 
	{
		this.venta_id_venta = venta_id_venta;
	}
	public void setEnviado(String enviado) 
	{
		this.enviado = enviado;
	}
	
}