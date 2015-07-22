
package cl.webinc.benderand.entidad;
									
public class Contenido_unidad_medida
{
	private String id_contenido_unidad_medida = "";
	private String nombre_contenido_unidad_medida = "";
	
	
	public Contenido_unidad_medida(String id_contenido_unidad_medida, String nombre_contenido_unidad_medida)
	{
		this.id_contenido_unidad_medida = id_contenido_unidad_medida;
		this.nombre_contenido_unidad_medida = nombre_contenido_unidad_medida;
		
	}
	public Contenido_unidad_medida(){}
	public String getId_contenido_unidad_medida() 
	{
		return id_contenido_unidad_medida;
	}
	public String getNombre_contenido_unidad_medida() 
	{
		return nombre_contenido_unidad_medida;
	}
	public void setId_contenido_unidad_medida(String id_contenido_unidad_medida) 
	{
		this.id_contenido_unidad_medida = id_contenido_unidad_medida;
	}
	public void setNombre_contenido_unidad_medida(String nombre_contenido_unidad_medida) 
	{
		this.nombre_contenido_unidad_medida = nombre_contenido_unidad_medida;
	}
	
}