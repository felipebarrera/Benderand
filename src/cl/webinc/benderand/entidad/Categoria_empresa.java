
package cl.webinc.benderand.entidad;
									
public class Categoria_empresa
{
	private String id_categoria_empresa = "";
	private String nombre_categoria_empresa = "";
	
	
	public Categoria_empresa(String id_categoria_empresa, String nombre_categoria_empresa)
	{
		this.id_categoria_empresa = id_categoria_empresa;
		this.nombre_categoria_empresa = nombre_categoria_empresa;
		
	}
	public Categoria_empresa(){}
	public String getId_categoria_empresa() 
	{
		return id_categoria_empresa;
	}
	public String getNombre_categoria_empresa() 
	{
		return nombre_categoria_empresa;
	}
	public void setId_categoria_empresa(String id_categoria_empresa) 
	{
		this.id_categoria_empresa = id_categoria_empresa;
	}
	public void setNombre_categoria_empresa(String nombre_categoria_empresa) 
	{
		this.nombre_categoria_empresa = nombre_categoria_empresa;
	}
	
}