
package cl.webinc.benderand.entidad;
									
public class Ventacompleta
{
	private String id_venta = "";
	private String numero_articulos = "";
	private String total = "";
	private String dia_fecha_venta = "";
	private String mes_fecha_venta = "";
	private String anno_fecha_venta = "";
	private String hora_fecha_venta = "";
	private String usuario_id_usuario = "";
	private String carne_empresa_id_carne_empresa = "";
	private String tipo_pago_id_tipo_pago = "";
	private String tipo_documento_id_tipo_documento = "";
	private String id_tipo_pago = "";
	private String nombre_tipo_pago = "";
	private String comision_tipo_pago = "";
	private String id_tipo_documento = "";
	private String nombre_tipo_documento = "";
	
	
	public Ventacompleta(String id_venta, String numero_articulos, String total, String dia_fecha_venta, String mes_fecha_venta, String anno_fecha_venta, String hora_fecha_venta, String usuario_id_usuario, String carne_empresa_id_carne_empresa, String tipo_pago_id_tipo_pago, String tipo_documento_id_tipo_documento, String id_tipo_pago, String nombre_tipo_pago, String comision_tipo_pago, String id_tipo_documento, String nombre_tipo_documento)
	{
		this.id_venta = id_venta;
		this.numero_articulos = numero_articulos;
		this.total = total;
		this.dia_fecha_venta = dia_fecha_venta;
		this.mes_fecha_venta = mes_fecha_venta;
		this.anno_fecha_venta = anno_fecha_venta;
		this.hora_fecha_venta = hora_fecha_venta;
		this.usuario_id_usuario = usuario_id_usuario;
		this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
		this.tipo_pago_id_tipo_pago = tipo_pago_id_tipo_pago;
		this.tipo_documento_id_tipo_documento = tipo_documento_id_tipo_documento;
		this.id_tipo_pago = id_tipo_pago;
		this.nombre_tipo_pago = nombre_tipo_pago;
		this.comision_tipo_pago = comision_tipo_pago;
		this.id_tipo_documento = id_tipo_documento;
		this.nombre_tipo_documento = nombre_tipo_documento;
		
	}
	public Ventacompleta(){}
	public String getId_venta() 
	{
		return id_venta;
	}
	public String getNumero_articulos() 
	{
		return numero_articulos;
	}
	public String getTotal() 
	{
		return total;
	}
	public String getDia_fecha_venta() 
	{
		return dia_fecha_venta;
	}
	public String getMes_fecha_venta() 
	{
		return mes_fecha_venta;
	}
	public String getAnno_fecha_venta() 
	{
		return anno_fecha_venta;
	}
	public String getHora_fecha_venta() 
	{
		return hora_fecha_venta;
	}
	public String getUsuario_id_usuario() 
	{
		return usuario_id_usuario;
	}
	public String getCarne_empresa_id_carne_empresa() 
	{
		return carne_empresa_id_carne_empresa;
	}
	public String getTipo_pago_id_tipo_pago() 
	{
		return tipo_pago_id_tipo_pago;
	}
	public String getTipo_documento_id_tipo_documento() 
	{
		return tipo_documento_id_tipo_documento;
	}
	public String getId_tipo_pago() 
	{
		return id_tipo_pago;
	}
	public String getNombre_tipo_pago() 
	{
		return nombre_tipo_pago;
	}
	public String getComision_tipo_pago() 
	{
		return comision_tipo_pago;
	}
	public String getId_tipo_documento() 
	{
		return id_tipo_documento;
	}
	public String getNombre_tipo_documento() 
	{
		return nombre_tipo_documento;
	}
	public void setId_venta(String id_venta) 
	{
		this.id_venta = id_venta;
	}
	public void setNumero_articulos(String numero_articulos) 
	{
		this.numero_articulos = numero_articulos;
	}
	public void setTotal(String total) 
	{
		this.total = total;
	}
	public void setDia_fecha_venta(String dia_fecha_venta) 
	{
		this.dia_fecha_venta = dia_fecha_venta;
	}
	public void setMes_fecha_venta(String mes_fecha_venta) 
	{
		this.mes_fecha_venta = mes_fecha_venta;
	}
	public void setAnno_fecha_venta(String anno_fecha_venta) 
	{
		this.anno_fecha_venta = anno_fecha_venta;
	}
	public void setHora_fecha_venta(String hora_fecha_venta) 
	{
		this.hora_fecha_venta = hora_fecha_venta;
	}
	public void setUsuario_id_usuario(String usuario_id_usuario) 
	{
		this.usuario_id_usuario = usuario_id_usuario;
	}
	public void setCarne_empresa_id_carne_empresa(String carne_empresa_id_carne_empresa) 
	{
		this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
	}
	public void setTipo_pago_id_tipo_pago(String tipo_pago_id_tipo_pago) 
	{
		this.tipo_pago_id_tipo_pago = tipo_pago_id_tipo_pago;
	}
	public void setTipo_documento_id_tipo_documento(String tipo_documento_id_tipo_documento) 
	{
		this.tipo_documento_id_tipo_documento = tipo_documento_id_tipo_documento;
	}
	public void setId_tipo_pago(String id_tipo_pago) 
	{
		this.id_tipo_pago = id_tipo_pago;
	}
	public void setNombre_tipo_pago(String nombre_tipo_pago) 
	{
		this.nombre_tipo_pago = nombre_tipo_pago;
	}
	public void setComision_tipo_pago(String comision_tipo_pago) 
	{
		this.comision_tipo_pago = comision_tipo_pago;
	}
	public void setId_tipo_documento(String id_tipo_documento) 
	{
		this.id_tipo_documento = id_tipo_documento;
	}
	public void setNombre_tipo_documento(String nombre_tipo_documento) 
	{
		this.nombre_tipo_documento = nombre_tipo_documento;
	}
	
}