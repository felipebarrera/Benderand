
package cl.webinc.benderand.entidad;
									
public class Anno
{
	private String idanno = "";
	private String anno = "";
	private String fecha = "";
	private String gastos = "";
	private String ingresos = "";
	private String impuestos = "";
	
	
	public Anno(String idanno, String anno, String fecha, String gastos, String ingresos, String impuestos)
	{
		this.idanno = idanno;
		this.anno = anno;
		this.fecha = fecha;
		this.gastos = gastos;
		this.ingresos = ingresos;
		this.impuestos = impuestos;
		
	}
	public Anno(){}
	public String getIdanno() 
	{
		return idanno;
	}
	public String getAnno() 
	{
		return anno;
	}
	public String getFecha() 
	{
		return fecha;
	}
	public String getGastos() 
	{
		return gastos;
	}
	public String getIngresos() 
	{
		return ingresos;
	}
	public String getImpuestos() 
	{
		return impuestos;
	}
	public void setIdanno(String idanno) 
	{
		this.idanno = idanno;
	}
	public void setAnno(String anno) 
	{
		this.anno = anno;
	}
	public void setFecha(String fecha) 
	{
		this.fecha = fecha;
	}
	public void setGastos(String gastos) 
	{
		this.gastos = gastos;
	}
	public void setIngresos(String ingresos) 
	{
		this.ingresos = ingresos;
	}
	public void setImpuestos(String impuestos) 
	{
		this.impuestos = impuestos;
	}
	
}