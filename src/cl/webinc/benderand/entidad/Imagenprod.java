
package cl.webinc.benderand.entidad;
									
public class Imagenprod
{
	private String id_imagenprod = "";
	private String urlimagenprod = "";
	private String producto_id_producto = "";
	
	
	public Imagenprod(String id_imagenprod, String urlimagenprod, String producto_id_producto)
	{
		this.id_imagenprod = id_imagenprod;
		this.urlimagenprod = urlimagenprod;
		this.producto_id_producto = producto_id_producto;
		
	}
	public Imagenprod(){}
	public String getId_imagenprod() 
	{
		return id_imagenprod;
	}
	public String getUrlimagenprod() 
	{
		return urlimagenprod;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public void setId_imagenprod(String id_imagenprod) 
	{
		this.id_imagenprod = id_imagenprod;
	}
	public void setUrlimagenprod(String urlimagenprod) 
	{
		this.urlimagenprod = urlimagenprod;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	
}