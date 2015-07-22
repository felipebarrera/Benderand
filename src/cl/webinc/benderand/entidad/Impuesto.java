
package cl.webinc.benderand.entidad;
									
public class Impuesto
{
	private String id_impuesto = "";
	private String nombre_impuesto = "";
	private String valor_impuesto = "";
	
	
	public Impuesto(String id_impuesto, String nombre_impuesto, String valor_impuesto)
	{
		this.id_impuesto = id_impuesto;
		this.nombre_impuesto = nombre_impuesto;
		this.valor_impuesto = valor_impuesto;
		
	}
	public Impuesto(){}
	public String getId_impuesto() 
	{
		return id_impuesto;
	}
	public String getNombre_impuesto() 
	{
		return nombre_impuesto;
	}
	public String getValor_impuesto() 
	{
		return valor_impuesto;
	}
	public void setId_impuesto(String id_impuesto) 
	{
		this.id_impuesto = id_impuesto;
	}
	public void setNombre_impuesto(String nombre_impuesto) 
	{
		this.nombre_impuesto = nombre_impuesto;
	}
	public void setValor_impuesto(String valor_impuesto) 
	{
		this.valor_impuesto = valor_impuesto;
	}
	
}