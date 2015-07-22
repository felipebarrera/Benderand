
package cl.webinc.benderand.entidad;
									
public class Formato_producto
{
	private String id_formato_producto = "";
	private String nombre_formato_producto = "";
	
	
	public Formato_producto(String id_formato_producto, String nombre_formato_producto)
	{
		this.id_formato_producto = id_formato_producto;
		this.nombre_formato_producto = nombre_formato_producto;
		
	}
	public Formato_producto(){}
	public String getId_formato_producto() 
	{
		return id_formato_producto;
	}
	public String getNombre_formato_producto() 
	{
		return nombre_formato_producto;
	}
	public void setId_formato_producto(String id_formato_producto) 
	{
		this.id_formato_producto = id_formato_producto;
	}
	public void setNombre_formato_producto(String nombre_formato_producto) 
	{
		this.nombre_formato_producto = nombre_formato_producto;
	}
	
}