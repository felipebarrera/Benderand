
package cl.webinc.benderand.entidad;
									
public class Subcategoria
{
	private String id_subcategoria = "";
	private String nombre_subcategoria = "";
	private String descripcion_subcategoria = "";
	private String categoria_id_categoria = "";
	
	
	public Subcategoria(String id_subcategoria, String nombre_subcategoria, String descripcion_subcategoria, String categoria_id_categoria)
	{
		this.id_subcategoria = id_subcategoria;
		this.nombre_subcategoria = nombre_subcategoria;
		this.descripcion_subcategoria = descripcion_subcategoria;
		this.categoria_id_categoria = categoria_id_categoria;
		
	}
	public Subcategoria(){}
	public String getId_subcategoria() 
	{
		return id_subcategoria;
	}
	public String getNombre_subcategoria() 
	{
		return nombre_subcategoria;
	}
	public String getDescripcion_subcategoria() 
	{
		return descripcion_subcategoria;
	}
	public String getCategoria_id_categoria() 
	{
		return categoria_id_categoria;
	}
	public void setId_subcategoria(String id_subcategoria) 
	{
		this.id_subcategoria = id_subcategoria;
	}
	public void setNombre_subcategoria(String nombre_subcategoria) 
	{
		this.nombre_subcategoria = nombre_subcategoria;
	}
	public void setDescripcion_subcategoria(String descripcion_subcategoria) 
	{
		this.descripcion_subcategoria = descripcion_subcategoria;
	}
	public void setCategoria_id_categoria(String categoria_id_categoria) 
	{
		this.categoria_id_categoria = categoria_id_categoria;
	}
	
}