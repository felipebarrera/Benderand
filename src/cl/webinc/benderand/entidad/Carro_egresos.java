
package cl.webinc.benderand.entidad;
									
public class Carro_egresos
{
	private String id_carro_egresos = "";
	private String cantidad_carro = "";
	private String precio_carro = "";
	private String mayor = "";
	private String tienda = "";
	private String usado = "";
	private String producto_id_producto = "";
	private String usuario_id_usuario = "";
	private String empresa_id_empresa = "";
	private String carne_empresa_id_carne_empresa = "";
	
	
	public Carro_egresos(String id_carro_egresos, String cantidad_carro, String precio_carro, String mayor, String tienda, String usado, String producto_id_producto, String usuario_id_usuario, String empresa_id_empresa, String carne_empresa_id_carne_empresa)
	{
		this.id_carro_egresos = id_carro_egresos;
		this.cantidad_carro = cantidad_carro;
		this.precio_carro = precio_carro;
		this.mayor = mayor;
		this.tienda = tienda;
		this.usado = usado;
		this.producto_id_producto = producto_id_producto;
		this.usuario_id_usuario = usuario_id_usuario;
		this.empresa_id_empresa = empresa_id_empresa;
		this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
		
	}
	public Carro_egresos(){}
	public String getId_carro_egresos() 
	{
		return id_carro_egresos;
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
	public String getUsado() 
	{
		return usado;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public String getUsuario_id_usuario() 
	{
		return usuario_id_usuario;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public String getCarne_empresa_id_carne_empresa() 
	{
		return carne_empresa_id_carne_empresa;
	}
	public void setId_carro_egresos(String id_carro_egresos) 
	{
		this.id_carro_egresos = id_carro_egresos;
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
	public void setUsado(String usado) 
	{
		this.usado = usado;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	public void setUsuario_id_usuario(String usuario_id_usuario) 
	{
		this.usuario_id_usuario = usuario_id_usuario;
	}
	public void setEmpresa_id_empresa(String empresa_id_empresa) 
	{
		this.empresa_id_empresa = empresa_id_empresa;
	}
	public void setCarne_empresa_id_carne_empresa(String carne_empresa_id_carne_empresa) 
	{
		this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
	}
	
}