
package cl.webinc.benderand.entidad;
									
public class Reciclado
{
	private String id_reciclado = "";
	private String reciclable = "";
	private String reciclado = "";
	private String valor_reciclaje = "";
	private String empresa_id_empresa = "";
	private String producto_id_producto = "";
	
	
	public Reciclado(String id_reciclado, String reciclable, String reciclado, String valor_reciclaje, String empresa_id_empresa, String producto_id_producto)
	{
		this.id_reciclado = id_reciclado;
		this.reciclable = reciclable;
		this.reciclado = reciclado;
		this.valor_reciclaje = valor_reciclaje;
		this.empresa_id_empresa = empresa_id_empresa;
		this.producto_id_producto = producto_id_producto;
		
	}
	public Reciclado(){}
	public String getId_reciclado() 
	{
		return id_reciclado;
	}
	public String getReciclable() 
	{
		return reciclable;
	}
	public String getReciclado() 
	{
		return reciclado;
	}
	public String getValor_reciclaje() 
	{
		return valor_reciclaje;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public void setId_reciclado(String id_reciclado) 
	{
		this.id_reciclado = id_reciclado;
	}
	public void setReciclable(String reciclable) 
	{
		this.reciclable = reciclable;
	}
	public void setReciclado(String reciclado) 
	{
		this.reciclado = reciclado;
	}
	public void setValor_reciclaje(String valor_reciclaje) 
	{
		this.valor_reciclaje = valor_reciclaje;
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