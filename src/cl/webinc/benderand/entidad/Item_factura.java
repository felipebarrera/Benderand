
package cl.webinc.benderand.entidad;
									
public class Item_factura
{
	private String id_itemfactura = "";
	private String cantidad = "";
	private String precio = "";
	private String producto_id_producto = "";
	private String factura_id_factura = "";
	private String carro_egresos_id_carro_egresos = "";
	
	
	public Item_factura(String id_itemfactura, String cantidad, String precio, String producto_id_producto, String factura_id_factura, String carro_egresos_id_carro_egresos)
	{
		this.id_itemfactura = id_itemfactura;
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto_id_producto = producto_id_producto;
		this.factura_id_factura = factura_id_factura;
		this.carro_egresos_id_carro_egresos = carro_egresos_id_carro_egresos;
		
	}
	public Item_factura(){}
	public String getId_itemfactura() 
	{
		return id_itemfactura;
	}
	public String getCantidad() 
	{
		return cantidad;
	}
	public String getPrecio() 
	{
		return precio;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public String getFactura_id_factura() 
	{
		return factura_id_factura;
	}
	public String getCarro_egresos_id_carro_egresos() 
	{
		return carro_egresos_id_carro_egresos;
	}
	public void setId_itemfactura(String id_itemfactura) 
	{
		this.id_itemfactura = id_itemfactura;
	}
	public void setCantidad(String cantidad) 
	{
		this.cantidad = cantidad;
	}
	public void setPrecio(String precio) 
	{
		this.precio = precio;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	public void setFactura_id_factura(String factura_id_factura) 
	{
		this.factura_id_factura = factura_id_factura;
	}
	public void setCarro_egresos_id_carro_egresos(String carro_egresos_id_carro_egresos) 
	{
		this.carro_egresos_id_carro_egresos = carro_egresos_id_carro_egresos;
	}
	
}