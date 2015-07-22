
package cl.webinc.benderand.entidad;
									
public class Factura
{
	private String id_factura = "";
	private String rol_factura = "";
	private String dia_factura = "";
	private String mes_factura = "";
	private String ano_factura = "";
	private String fecha_factura = "";
	private String empresa_id_empresa = "";
	private String carne_empresa_id_carne_empresa = "";
	private String rut_proveedor = "";
	private String nombre_proveedor = "";
	private String telefono_proveedor = "";
	private String tipo_documento_id_tipo_documento = "";
	private String tipo_pago_id_tipo_pago = "";
	private String total_factura = "";
	
	
	public Factura(String id_factura, String rol_factura, String dia_factura, String mes_factura, String ano_factura, String fecha_factura, String empresa_id_empresa, String carne_empresa_id_carne_empresa, String rut_proveedor, String nombre_proveedor, String telefono_proveedor, String tipo_documento_id_tipo_documento, String tipo_pago_id_tipo_pago, String total_factura)
	{
		this.id_factura = id_factura;
		this.rol_factura = rol_factura;
		this.dia_factura = dia_factura;
		this.mes_factura = mes_factura;
		this.ano_factura = ano_factura;
		this.fecha_factura = fecha_factura;
		this.empresa_id_empresa = empresa_id_empresa;
		this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
		this.rut_proveedor = rut_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.telefono_proveedor = telefono_proveedor;
		this.tipo_documento_id_tipo_documento = tipo_documento_id_tipo_documento;
		this.tipo_pago_id_tipo_pago = tipo_pago_id_tipo_pago;
		this.total_factura = total_factura;
		
	}
	public Factura(){}
	public String getId_factura() 
	{
		return id_factura;
	}
	public String getRol_factura() 
	{
		return rol_factura;
	}
	public String getDia_factura() 
	{
		return dia_factura;
	}
	public String getMes_factura() 
	{
		return mes_factura;
	}
	public String getAno_factura() 
	{
		return ano_factura;
	}
	public String getFecha_factura() 
	{
		return fecha_factura;
	}
	public String getEmpresa_id_empresa() 
	{
		return empresa_id_empresa;
	}
	public String getCarne_empresa_id_carne_empresa() 
	{
		return carne_empresa_id_carne_empresa;
	}
	public String getRut_proveedor() 
	{
		return rut_proveedor;
	}
	public String getNombre_proveedor() 
	{
		return nombre_proveedor;
	}
	public String getTelefono_proveedor() 
	{
		return telefono_proveedor;
	}
	public String getTipo_documento_id_tipo_documento() 
	{
		return tipo_documento_id_tipo_documento;
	}
	public String getTipo_pago_id_tipo_pago() 
	{
		return tipo_pago_id_tipo_pago;
	}
	public String getTotal_factura() 
	{
		return total_factura;
	}
	public void setId_factura(String id_factura) 
	{
		this.id_factura = id_factura;
	}
	public void setRol_factura(String rol_factura) 
	{
		this.rol_factura = rol_factura;
	}
	public void setDia_factura(String dia_factura) 
	{
		this.dia_factura = dia_factura;
	}
	public void setMes_factura(String mes_factura) 
	{
		this.mes_factura = mes_factura;
	}
	public void setAno_factura(String ano_factura) 
	{
		this.ano_factura = ano_factura;
	}
	public void setFecha_factura(String fecha_factura) 
	{
		this.fecha_factura = fecha_factura;
	}
	public void setEmpresa_id_empresa(String empresa_id_empresa) 
	{
		this.empresa_id_empresa = empresa_id_empresa;
	}
	public void setCarne_empresa_id_carne_empresa(String carne_empresa_id_carne_empresa) 
	{
		this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
	}
	public void setRut_proveedor(String rut_proveedor) 
	{
		this.rut_proveedor = rut_proveedor;
	}
	public void setNombre_proveedor(String nombre_proveedor) 
	{
		this.nombre_proveedor = nombre_proveedor;
	}
	public void setTelefono_proveedor(String telefono_proveedor) 
	{
		this.telefono_proveedor = telefono_proveedor;
	}
	public void setTipo_documento_id_tipo_documento(String tipo_documento_id_tipo_documento) 
	{
		this.tipo_documento_id_tipo_documento = tipo_documento_id_tipo_documento;
	}
	public void setTipo_pago_id_tipo_pago(String tipo_pago_id_tipo_pago) 
	{
		this.tipo_pago_id_tipo_pago = tipo_pago_id_tipo_pago;
	}
	public void setTotal_factura(String total_factura) 
	{
		this.total_factura = total_factura;
	}
	
}