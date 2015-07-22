
package cl.webinc.benderand.entidad;
									
public class Familia_producto
{
	private String id_familia_producto = "";
	private String nombre_familia_producto = "";
	
	
	public Familia_producto(String id_familia_producto, String nombre_familia_producto)
	{
		this.id_familia_producto = id_familia_producto;
		this.nombre_familia_producto = nombre_familia_producto;
		
	}
	public Familia_producto(){}
	public String getId_familia_producto() 
	{
		return id_familia_producto;
	}
	public String getNombre_familia_producto() 
	{
		return nombre_familia_producto;
	}
	public void setId_familia_producto(String id_familia_producto) 
	{
		this.id_familia_producto = id_familia_producto;
	}
	public void setNombre_familia_producto(String nombre_familia_producto) 
	{
		this.nombre_familia_producto = nombre_familia_producto;
	}
	
}