
package cl.webinc.benderand.entidad;
									
public class Pais
{
	private String id_pais = "";
	private String nombre_pais = "";
	private String iso_code_2_pais = "";
	private String iso_code_3_pais = "";
	private String address_format = "";
	private String iso_code_number = "";
	
	
	public Pais(String id_pais, String nombre_pais, String iso_code_2_pais, String iso_code_3_pais, String address_format, String iso_code_number)
	{
		this.id_pais = id_pais;
		this.nombre_pais = nombre_pais;
		this.iso_code_2_pais = iso_code_2_pais;
		this.iso_code_3_pais = iso_code_3_pais;
		this.address_format = address_format;
		this.iso_code_number = iso_code_number;
		
	}
	public Pais(){}
	public String getId_pais() 
	{
		return id_pais;
	}
	public String getNombre_pais() 
	{
		return nombre_pais;
	}
	public String getIso_code_2_pais() 
	{
		return iso_code_2_pais;
	}
	public String getIso_code_3_pais() 
	{
		return iso_code_3_pais;
	}
	public String getAddress_format() 
	{
		return address_format;
	}
	public String getIso_code_number() 
	{
		return iso_code_number;
	}
	public void setId_pais(String id_pais) 
	{
		this.id_pais = id_pais;
	}
	public void setNombre_pais(String nombre_pais) 
	{
		this.nombre_pais = nombre_pais;
	}
	public void setIso_code_2_pais(String iso_code_2_pais) 
	{
		this.iso_code_2_pais = iso_code_2_pais;
	}
	public void setIso_code_3_pais(String iso_code_3_pais) 
	{
		this.iso_code_3_pais = iso_code_3_pais;
	}
	public void setAddress_format(String address_format) 
	{
		this.address_format = address_format;
	}
	public void setIso_code_number(String iso_code_number) 
	{
		this.iso_code_number = iso_code_number;
	}
	
}