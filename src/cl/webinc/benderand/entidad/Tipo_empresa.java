
package cl.webinc.benderand.entidad;
									
public class Tipo_empresa
{
	private String id_tipo_empresa = "";
	private String nombre_tipo_empresa = "";
	private String categoria_empresa_id_categoria_empresa = "";
	
	
	public Tipo_empresa(String id_tipo_empresa, String nombre_tipo_empresa, String categoria_empresa_id_categoria_empresa)
	{
		this.id_tipo_empresa = id_tipo_empresa;
		this.nombre_tipo_empresa = nombre_tipo_empresa;
		this.categoria_empresa_id_categoria_empresa = categoria_empresa_id_categoria_empresa;
		
	}
	public Tipo_empresa(){}
	public String getId_tipo_empresa() 
	{
		return id_tipo_empresa;
	}
	public String getNombre_tipo_empresa() 
	{
		return nombre_tipo_empresa;
	}
	public String getCategoria_empresa_id_categoria_empresa() 
	{
		return categoria_empresa_id_categoria_empresa;
	}
	public void setId_tipo_empresa(String id_tipo_empresa) 
	{
		this.id_tipo_empresa = id_tipo_empresa;
	}
	public void setNombre_tipo_empresa(String nombre_tipo_empresa) 
	{
		this.nombre_tipo_empresa = nombre_tipo_empresa;
	}
	public void setCategoria_empresa_id_categoria_empresa(String categoria_empresa_id_categoria_empresa) 
	{
		this.categoria_empresa_id_categoria_empresa = categoria_empresa_id_categoria_empresa;
	}
	
}