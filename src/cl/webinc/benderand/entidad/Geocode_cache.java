
package cl.webinc.benderand.entidad;
									
public class Geocode_cache
{
	private String id = "";
	private String lng = "";
	private String lat = "";
	private String query = "";
	
	
	public Geocode_cache(String id, String lng, String lat, String query)
	{
		this.id = id;
		this.lng = lng;
		this.lat = lat;
		this.query = query;
		
	}
	public Geocode_cache(){}
	public String getId() 
	{
		return id;
	}
	public String getLng() 
	{
		return lng;
	}
	public String getLat() 
	{
		return lat;
	}
	public String getQuery() 
	{
		return query;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public void setLng(String lng) 
	{
		this.lng = lng;
	}
	public void setLat(String lat) 
	{
		this.lat = lat;
	}
	public void setQuery(String query) 
	{
		this.query = query;
	}
	
}