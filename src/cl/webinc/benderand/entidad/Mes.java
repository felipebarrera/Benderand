
package cl.webinc.benderand.entidad;
									
public class Mes
{
	private String idmes = "";
	private String numeromes = "";
	private String mes = "";
	private String anno = "";
	private String fecha = "";
	private String gastos = "";
	private String ingresos = "";
	private String impuestos = "";
	
	
	public Mes(String idmes, String numeromes, String mes, String anno, String fecha, String gastos, String ingresos, String impuestos)
	{
		this.idmes = idmes;
		this.numeromes = numeromes;
		this.mes = mes;
		this.anno = anno;
		this.fecha = fecha;
		this.gastos = gastos;
		this.ingresos = ingresos;
		this.impuestos = impuestos;
		
	}
	public Mes(){}
	public String getIdmes() 
	{
		return idmes;
	}
	public String getNumeromes() 
	{
		return numeromes;
	}
	public String getMes() 
	{
		return mes;
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
	public void setIdmes(String idmes) 
	{
		this.idmes = idmes;
	}
	public void setNumeromes(String numeromes) 
	{
		this.numeromes = numeromes;
	}
	public void setMes(String mes) 
	{
		this.mes = mes;
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