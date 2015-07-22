
package cl.webinc.benderand.entidad;
									
public class Dia
{
	private String iddia = "";
	private String dia = "";
	private String mes = "";
	private String anno = "";
	private String fecha = "";
	private String egreso = "";
	private String ingreso = "";
	private String impuesto = "";
	
	
	public Dia(String iddia, String dia, String mes, String anno, String fecha, String egreso, String ingreso, String impuesto)
	{
		this.iddia = iddia;
		this.dia = dia;
		this.mes = mes;
		this.anno = anno;
		this.fecha = fecha;
		this.egreso = egreso;
		this.ingreso = ingreso;
		this.impuesto = impuesto;
		
	}
	public Dia(){}
	public String getIddia() 
	{
		return iddia;
	}
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
	public String getEgreso() 
	{
		return egreso;
	}
	public String getIngreso() 
	{
		return ingreso;
	}
	public String getImpuesto() 
	{
		return impuesto;
	}
	public void setIddia(String iddia) 
	{
		this.iddia = iddia;
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
	public void setEgreso(String egreso) 
	{
		this.egreso = egreso;
	}
	public void setIngreso(String ingreso) 
	{
		this.ingreso = ingreso;
	}
	public void setImpuesto(String impuesto) 
	{
		this.impuesto = impuesto;
	}
	
}