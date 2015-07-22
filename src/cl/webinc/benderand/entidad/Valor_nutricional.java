
package cl.webinc.benderand.entidad;
									
public class Valor_nutricional
{
	private String id_valor_nutricional = "";
	private String nombre_valor = "";
	private String cantidad = "";
	private String valor_diario_total = "";
	private String porcentaje_requerimientos = "";
	private String producto_id_producto = "";
	
	
	public Valor_nutricional(String id_valor_nutricional, String nombre_valor, String cantidad, String valor_diario_total, String porcentaje_requerimientos, String producto_id_producto)
	{
		this.id_valor_nutricional = id_valor_nutricional;
		this.nombre_valor = nombre_valor;
		this.cantidad = cantidad;
		this.valor_diario_total = valor_diario_total;
		this.porcentaje_requerimientos = porcentaje_requerimientos;
		this.producto_id_producto = producto_id_producto;
		
	}
	public Valor_nutricional(){}
	public String getId_valor_nutricional() 
	{
		return id_valor_nutricional;
	}
	public String getNombre_valor() 
	{
		return nombre_valor;
	}
	public String getCantidad() 
	{
		return cantidad;
	}
	public String getValor_diario_total() 
	{
		return valor_diario_total;
	}
	public String getPorcentaje_requerimientos() 
	{
		return porcentaje_requerimientos;
	}
	public String getProducto_id_producto() 
	{
		return producto_id_producto;
	}
	public void setId_valor_nutricional(String id_valor_nutricional) 
	{
		this.id_valor_nutricional = id_valor_nutricional;
	}
	public void setNombre_valor(String nombre_valor) 
	{
		this.nombre_valor = nombre_valor;
	}
	public void setCantidad(String cantidad) 
	{
		this.cantidad = cantidad;
	}
	public void setValor_diario_total(String valor_diario_total) 
	{
		this.valor_diario_total = valor_diario_total;
	}
	public void setPorcentaje_requerimientos(String porcentaje_requerimientos) 
	{
		this.porcentaje_requerimientos = porcentaje_requerimientos;
	}
	public void setProducto_id_producto(String producto_id_producto) 
	{
		this.producto_id_producto = producto_id_producto;
	}
	
}