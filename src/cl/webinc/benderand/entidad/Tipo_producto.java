
package cl.webinc.benderand.entidad;
									
public class Tipo_producto
{
	private String id_tipo_producto = "";
	private String nombre_tipo_producto = "";
	
	
	public Tipo_producto(String id_tipo_producto, String nombre_tipo_producto)
	{
		this.id_tipo_producto = id_tipo_producto;
		this.nombre_tipo_producto = nombre_tipo_producto;
		
	}
	public Tipo_producto(){}
	public String getId_tipo_producto() 
	{
		return id_tipo_producto;
	}
	public String getNombre_tipo_producto() 
	{
		return nombre_tipo_producto;
	}
	public void setId_tipo_producto(String id_tipo_producto) 
	{
		this.id_tipo_producto = id_tipo_producto;
	}
	public void setNombre_tipo_producto(String nombre_tipo_producto) 
	{
		this.nombre_tipo_producto = nombre_tipo_producto;
	}
	
}