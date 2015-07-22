
package cl.webinc.benderand.entidad;
									
public class Precio
{
	private String id_precio = "";
	private String precio_CLP = "";
	private String precio_us = "";
	private String precio_mayor_CLP = "";
	private String precio_mayor_us = "";
	private String precio_actual = "";
	private String descuento_promocion = "";
	private String cantidad_mayor = "";
	private String empresa_id_empresa = "";
	private String producto_id_producto = "";
	
	
	public Precio(String id_precio, String precio_CLP, String precio_us, String precio_mayor_CLP, String precio_mayor_us, String precio_actual, String descuento_promocion, String cantidad_mayor, String empresa_id_empresa, String producto_id_producto)
	{
		this.id_precio = id_precio;
		this.precio_CLP = precio_CLP;
		this.precio_us = precio_us;
		this.precio_mayor_CLP = precio_mayor_CLP;
		this.precio_mayor_us = precio_mayor_us;
		this.precio_actual = precio_actual;
		this.descuento_promocion = descuento_promocion;
		this.cantidad_mayor = cantidad_mayor;
		this.empresa_id_empresa = empresa_id_empresa;
		this.producto_id_producto = producto_id_producto;
		
	}
	public Precio(){}
	public String getId_precio() 
	{
		return id_precio;
	}
	public String getPrecio_CLP() 
	{
		return precio_CLP;
	}
	public String getPrecio_us() 
	{
		return precio_us;
	}
	public String getPrecio_mayor_CLP() 
	{
		return precio_mayor_CLP;
	}
	public String getPrecio_mayor_us() 
	{
		return precio_mayor_us;
	}
	public String getPrecio_actual() 
	{
		return precio_actual;
	}
	public String getDescuento_promocion() 
	{
		return descuento_promocion;
	}
	public String getCantidad_mayor() 
	{
		return cantidad_mayor;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public void setId_precio(String id_precio) 
	{
		this.id_precio = id_precio;
	}
	public void setPrecio_CLP(String precio_CLP) 
	{
		this.precio_CLP = precio_CLP;
	}
	public void setPrecio_us(String precio_us) 
	{
		this.precio_us = precio_us;
	}
	public void setPrecio_mayor_CLP(String precio_mayor_CLP) 
	{
		this.precio_mayor_CLP = precio_mayor_CLP;
	}
	public void setPrecio_mayor_us(String precio_mayor_us) 
	{
		this.precio_mayor_us = precio_mayor_us;
	}
	public void setPrecio_actual(String precio_actual) 
	{
		this.precio_actual = precio_actual;
	}
	public void setDescuento_promocion(String descuento_promocion) 
	{
		this.descuento_promocion = descuento_promocion;
	}
	public void setCantidad_mayor(String cantidad_mayor) 
	{
		this.cantidad_mayor = cantidad_mayor;
	}
	public void setEmpresa_id_empresa(String empresa_id_empresa) 
	{
		this.empresa_id_empresa = empresa_id_empresa;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	
}