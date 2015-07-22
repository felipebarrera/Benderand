
package cl.webinc.benderand.entidad;
									
public class Carro_venta
{
	private String id_carro_venta = "";
	private String cantidad = "";
	private String precio = "";
	private String carro_compras_id_carro_compras = "";
	private String venta_id_venta = "";
	
	
	public Carro_venta(String id_carro_venta, String cantidad, String precio, String carro_compras_id_carro_compras, String venta_id_venta)
	{
		this.id_carro_venta = id_carro_venta;
		this.cantidad = cantidad;
		this.precio = precio;
		this.carro_compras_id_carro_compras = carro_compras_id_carro_compras;
		this.venta_id_venta = venta_id_venta;
		
	}
	public Carro_venta(){}
	public String getId_carro_venta() 
	{
		return id_carro_venta;
	}
	public String getCantidad() 
	{
		return cantidad;
	}
	public String getPrecio() 
	{
		return precio;
	}
	public String getCarro_compras_id_carro_compras() 
	{
		return carro_compras_id_carro_compras;
	}
	public String getVenta_id_venta() 
	{
		return venta_id_venta;
	}
	public void setId_carro_venta(String id_carro_venta) 
	{
		this.id_carro_venta = id_carro_venta;
	}
	public void setCantidad(String cantidad) 
	{
		this.cantidad = cantidad;
	}
	public void setPrecio(String precio) 
	{
		this.precio = precio;
	}
	public void setCarro_compras_id_carro_compras(String carro_compras_id_carro_compras) 
	{
		this.carro_compras_id_carro_compras = carro_compras_id_carro_compras;
	}
	public void setVenta_id_venta(String venta_id_venta) 
	{
		this.venta_id_venta = venta_id_venta;
	}
	
}