
package cl.webinc.benderand.entidad;
									
public class Sincrodate
{
	private String id_sincrodate = "";
	private String date = "";
	
	
	public Sincrodate(String id_sincrodate, String date)
	{
		this.id_sincrodate = id_sincrodate;
		this.date = date;
		
	}
	public Sincrodate(){}
	public String getId_sincrodate() 
	{
		return id_sincrodate;
	}
	public String getDate() 
	{
		return date;
	}
	public void setId_sincrodate(String id_sincrodate) 
	{
		this.id_sincrodate = id_sincrodate;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	
}