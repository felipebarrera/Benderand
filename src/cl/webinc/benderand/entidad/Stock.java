
package cl.webinc.benderand.entidad;
									
public class Stock
{
	private String id_stock = "";
	private String stock_real = "";
	private String stock_minimo = "";
	private String stock_ideal = "";
	private String stock_tienda = "";
	private String stock_virtual = "";
	private String stock_vendido = "";
	private String last_update = "";
	private String producto_id_producto = "";
	private String empresa_id_empresa = "";
	
	
	public Stock(String id_stock, String stock_real, String stock_minimo, String stock_ideal, String stock_tienda, String stock_virtual, String stock_vendido, String last_update, String producto_id_producto, String empresa_id_empresa)
	{
		this.id_stock = id_stock;
		this.stock_real = stock_real;
		this.stock_minimo = stock_minimo;
		this.stock_ideal = stock_ideal;
		this.stock_tienda = stock_tienda;
		this.stock_virtual = stock_virtual;
		this.stock_vendido = stock_vendido;
		this.last_update = last_update;
		this.producto_id_producto = producto_id_producto;
		this.empresa_id_empresa = empresa_id_empresa;
		
	}
	public Stock(){}
	public String getId_stock() 
	{
		return id_stock;
	}
	public String getStock_real() 
	{
		return stock_real;
	}
	public String getStock_minimo() 
	{
		return stock_minimo;
	}
	public String getStock_ideal() 
	{
		return stock_ideal;
	}
	public String getStock_tienda() 
	{
		return stock_tienda;
	}
	public String getStock_virtual() 
	{
		return stock_virtual;
	}
	public String getStock_vendido() 
	{
		return stock_vendido;
	}
	public String getLast_update() 
	{
		return last_update;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public void setId_stock(String id_stock) 
	{
		this.id_stock = id_stock;
	}
	public void setStock_real(String stock_real) 
	{
		this.stock_real = stock_real;
	}
	public void setStock_minimo(String stock_minimo) 
	{
		this.stock_minimo = stock_minimo;
	}
	public void setStock_ideal(String stock_ideal) 
	{
		this.stock_ideal = stock_ideal;
	}
	public void setStock_tienda(String stock_tienda) 
	{
		this.stock_tienda = stock_tienda;
	}
	public void setStock_virtual(String stock_virtual) 
	{
		this.stock_virtual = stock_virtual;
	}
	public void setStock_vendido(String stock_vendido) 
	{
		this.stock_vendido = stock_vendido;
	}
	public void setLast_update(String last_update) 
	{
		this.last_update = last_update;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	public void setEmpresa_id_empresa(String empresa_id_empresa) 
	{
		this.empresa_id_empresa = empresa_id_empresa;
	}
	
}