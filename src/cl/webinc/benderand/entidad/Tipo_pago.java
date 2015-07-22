
package cl.webinc.benderand.entidad;
									
public class Tipo_pago
{
	private String id_tipo_pago = "";
	private String nombre_tipo_pago = "";
	private String comision_tipo_pago = "";
	
	
	public Tipo_pago(String id_tipo_pago, String nombre_tipo_pago, String comision_tipo_pago)
	{
		this.id_tipo_pago = id_tipo_pago;
		this.nombre_tipo_pago = nombre_tipo_pago;
		this.comision_tipo_pago = comision_tipo_pago;
		
	}
	public Tipo_pago(){}
	public String getId_tipo_pago() 
	{
		return id_tipo_pago;
	}
	public String getNombre_tipo_pago() 
	{
		return nombre_tipo_pago;
	}
	public String getComision_tipo_pago() 
	{
		return comision_tipo_pago;
	}
	public void setId_tipo_pago(String id_tipo_pago) 
	{
		this.id_tipo_pago = id_tipo_pago;
	}
	public void setNombre_tipo_pago(String nombre_tipo_pago) 
	{
		this.nombre_tipo_pago = nombre_tipo_pago;
	}
	public void setComision_tipo_pago(String comision_tipo_pago) 
	{
		this.comision_tipo_pago = comision_tipo_pago;
	}
	
}