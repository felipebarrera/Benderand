
package cl.webinc.benderand.entidad;
									
public class Caracteristica
{
	private String id_caracteristica = "";
	private String numero_caracteristica = "";
	private String caracteristica = "";
	private String valor_caracteristica = "";
	private String producto_id_producto = "";
	
	
	public Caracteristica(String id_caracteristica, String numero_caracteristica, String caracteristica, String valor_caracteristica, String producto_id_producto)
	{
		this.id_caracteristica = id_caracteristica;
		this.numero_caracteristica = numero_caracteristica;
		this.caracteristica = caracteristica;
		this.valor_caracteristica = valor_caracteristica;
		this.producto_id_producto = producto_id_producto;
		
	}
	public Caracteristica(){}
	public String getId_caracteristica() 
	{
		return id_caracteristica;
	}
	public String getNumero_caracteristica() 
	{
		return numero_caracteristica;
	}
	public String getCaracteristica() 
	{
		return caracteristica;
	}
	public String getValor_caracteristica() 
	{
		return valor_caracteristica;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public void setId_caracteristica(String id_caracteristica) 
	{
		this.id_caracteristica = id_caracteristica;
	}
	public void setNumero_caracteristica(String numero_caracteristica) 
	{
		this.numero_caracteristica = numero_caracteristica;
	}
	public void setCaracteristica(String caracteristica) 
	{
		this.caracteristica = caracteristica;
	}
	public void setValor_caracteristica(String valor_caracteristica) 
	{
		this.valor_caracteristica = valor_caracteristica;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	
}