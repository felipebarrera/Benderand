
package cl.webinc.benderand.entidad;
									
public class Carro_compras
{
	private String id_carro_compras = "";
	private String cantidad_carro = "";
	private String precio_carro = "";
	private String mayor = "";
	private String tienda = "";
	private String usuario_id_usuario = "";
	private String producto_id_producto = "";
	private String empresa_id_empresa = "";
	private String usado = "";
	private String carne_empresa_id_carne_empresa = "";
	
	
	public Carro_compras(String id_carro_compras, String cantidad_carro, String precio_carro, String mayor, String tienda, String usuario_id_usuario, String producto_id_producto, String empresa_id_empresa, String usado, String carne_empresa_id_carne_empresa)
	{
		this.id_carro_compras = id_carro_compras;
		this.cantidad_carro = cantidad_carro;
		this.precio_carro = precio_carro;
		this.mayor = mayor;
		this.tienda = tienda;
		this.usuario_id_usuario = usuario_id_usuario;
		this.producto_id_producto = producto_id_producto;
		this.empresa_id_empresa = empresa_id_empresa;
		this.usado = usado;
		this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
		
	}
	public Carro_compras(){}
	public String getId_carro_compras() 
	{
		return id_carro_compras;
	}
	public String getCantidad_carro() 
	{
		return cantidad_carro;
	}
	public String getPrecio_carro() 
	{
		return precio_carro;
	}
	public String getMayor() 
	{
		return mayor;
	}
	public String getTienda() 
	{
		return tienda;
	}
	public String getUsuario_id_usuario() 
	{
		return usuario_id_usuario;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public String getUsado() 
	{
		return usado;
	}
	public String getCarne_empresa_id_carne_empresa() 
	{
		return carne_empresa_id_carne_empresa;
	}
	public void setId_carro_compras(String id_carro_compras) 
	{
		this.id_carro_compras = id_carro_compras;
	}
	public void setCantidad_carro(String cantidad_carro) 
	{
		this.cantidad_carro = cantidad_carro;
	}
	public void setPrecio_carro(String precio_carro) 
	{
		this.precio_carro = precio_carro;
	}
	public void setMayor(String mayor) 
	{
		this.mayor = mayor;
	}
	public void setTienda(String tienda) 
	{
		this.tienda = tienda;
	}
	public void setUsuario_id_usuario(String usuario_id_usuario) 
	{
		this.usuario_id_usuario = usuario_id_usuario;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	public void setEmpresa_id_empresa(String empresa_id_empresa) 
	{
		this.empresa_id_empresa = empresa_id_empresa;
	}
	public void setUsado(String usado) 
	{
		this.usado = usado;
	}
	public void setCarne_empresa_id_carne_empresa(String carne_empresa_id_carne_empresa) 
	{
		this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
	}
	
}