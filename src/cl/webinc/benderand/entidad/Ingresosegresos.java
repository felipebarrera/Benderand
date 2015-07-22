
package cl.webinc.benderand.entidad;
									
public class Ingresosegresos
{
	private String dia = "";
	private String mes = "";
	private String anno = "";
	private String fecha = "";
	private String totalingreso = "";
	private String totalgasto = "";
	private String impuestoegreso = "";
	private String impuestoingreso = "";
	
	
	public Ingresosegresos(String dia, String mes, String anno, String fecha, String totalingreso, String totalgasto, String impuestoegreso, String impuestoingreso)
	{
		this.dia = dia;
		this.mes = mes;
		this.anno = anno;
		this.fecha = fecha;
		this.totalingreso = totalingreso;
		this.totalgasto = totalgasto;
		this.impuestoegreso = impuestoegreso;
		this.impuestoingreso = impuestoingreso;
		
	}
	public Ingresosegresos(){}
	public String getDia() 
	{
		return dia;
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
	public String getTotalingreso() 
	{
		return totalingreso;
	}
	public String getTotalgasto() 
	{
		return totalgasto;
	}
	public String getImpuestoegreso() 
	{
		return impuestoegreso;
	}
	public String getImpuestoingreso() 
	{
		return impuestoingreso;
	}
	public void setDia(String dia) 
	{
		this.dia = dia;
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
	public void setTotalingreso(String totalingreso) 
	{
		this.totalingreso = totalingreso;
	}
	public void setTotalgasto(String totalgasto) 
	{
		this.totalgasto = totalgasto;
	}
	public void setImpuestoegreso(String impuestoegreso) 
	{
		this.impuestoegreso = impuestoegreso;
	}
	public void setImpuestoingreso(String impuestoingreso) 
	{
		this.impuestoingreso = impuestoingreso;
	}
	
}