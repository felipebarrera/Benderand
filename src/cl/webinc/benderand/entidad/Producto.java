
package cl.webinc.benderand.entidad;
									
public class Producto
{
	private String id_producto = "";
	private String codigo_producto = "";
	private String numero_serie = "";
	private String descripcion_producto = "";
	private String nombre_producto = "";
	private String marca_producto = "";
	private String modelo_producto = "";
	private String contenido_unidad = "";
	private String contenido_unidad_medida_id_contenido_unidad_medida = "";
	private String unidad_minima = "";
	private String contenido = "";
	private String peso_neto = "";
	private String alto_cm = "";
	private String ancho_cm = "";
	private String fondo_cm = "";
	private String fabricante = "";
	private String clase_producto = "";
	private String linea_producto = "";
	private String hot = "";
	private String SKU = "";
	private String subcategoria_id_subcategoria = "";
	private String tipo_producto_id_tipo_producto = "";
	private String formato_producto_id_formato_producto = "";
	private String familia_necesidad_id_familia_necesidad = "";
	private String familia_producto_id_familia_producto = "";
	
	
	public Producto(String id_producto, String codigo_producto, String numero_serie, String descripcion_producto, String nombre_producto, String marca_producto, String modelo_producto, String contenido_unidad, String contenido_unidad_medida_id_contenido_unidad_medida, String unidad_minima, String contenido, String peso_neto, String alto_cm, String ancho_cm, String fondo_cm, String fabricante, String clase_producto, String linea_producto, String hot, String SKU, String subcategoria_id_subcategoria, String tipo_producto_id_tipo_producto, String formato_producto_id_formato_producto, String familia_necesidad_id_familia_necesidad, String familia_producto_id_familia_producto)
	{
		this.id_producto = id_producto;
		this.codigo_producto = codigo_producto;
		this.numero_serie = numero_serie;
		this.descripcion_producto = descripcion_producto;
		this.nombre_producto = nombre_producto;
		this.marca_producto = marca_producto;
		this.modelo_producto = modelo_producto;
		this.contenido_unidad = contenido_unidad;
		this.contenido_unidad_medida_id_contenido_unidad_medida = contenido_unidad_medida_id_contenido_unidad_medida;
		this.unidad_minima = unidad_minima;
		this.contenido = contenido;
		this.peso_neto = peso_neto;
		this.alto_cm = alto_cm;
		this.ancho_cm = ancho_cm;
		this.fondo_cm = fondo_cm;
		this.fabricante = fabricante;
		this.clase_producto = clase_producto;
		this.linea_producto = linea_producto;
		this.hot = hot;
		this.SKU = SKU;
		this.subcategoria_id_subcategoria = subcategoria_id_subcategoria;
		this.tipo_producto_id_tipo_producto = tipo_producto_id_tipo_producto;
		this.formato_producto_id_formato_producto = formato_producto_id_formato_producto;
		this.familia_necesidad_id_familia_necesidad = familia_necesidad_id_familia_necesidad;
		this.familia_producto_id_familia_producto = familia_producto_id_familia_producto;
		
	}
	public Producto(){}
	public String getId_producto() 
	{
		return id_producto;
	}
	public String getCodigo_producto() 
	{
		return codigo_producto;
	}
	public String getNumero_serie() 
	{
		return numero_serie;
	}
	public String getDescripcion_producto() 
	{
		return descripcion_producto;
	}
	public String getNombre_producto() 
	{
		return nombre_producto;
	}
	public String getMarca_producto() 
	{
		return marca_producto;
	}
	public String getModelo_producto() 
	{
		return modelo_producto;
	}
	public String getContenido_unidad() 
	{
		return contenido_unidad;
	}
	public String getContenido_unidad_medida_id_contenido_unidad_medida() 
	{
		return contenido_unidad_medida_id_contenido_unidad_medida;
	}
	public String getUnidad_minima() 
	{
		return unidad_minima;
	}
	public String getContenido() 
	{
		return contenido;
	}
	public String getPeso_neto() 
	{
		return peso_neto;
	}
	public String getAlto_cm() 
	{
		return alto_cm;
	}
	public String getAncho_cm() 
	{
		return ancho_cm;
	}
	public String getFondo_cm() 
	{
		return fondo_cm;
	}
	public String getFabricante() 
	{
		return fabricante;
	}
	public String getClase_producto() 
	{
		return clase_producto;
	}
	public String getLinea_producto() 
	{
		return linea_producto;
	}
	public String getHot() 
	{
		return hot;
	}
	public String getSKU() 
	{
		return SKU;
	}
	public String getSubcategoria_id_subcategoria() 
	{
		return subcategoria_id_subcategoria;
	}
	public String getTipo_producto_id_tipo_producto() 
	{
		return tipo_producto_id_tipo_producto;
	}
	public String getFormato_producto_id_formato_producto() 
	{
		return formato_producto_id_formato_producto;
	}
	public String getFamilia_necesidad_id_familia_necesidad() 
	{
		return familia_necesidad_id_familia_necesidad;
	}
	public String getFamilia_producto_id_familia_producto() 
	{
		return familia_producto_id_familia_producto;
	}
	public void setId_producto(String id_producto) 
	{
		this.id_producto = id_producto;
	}
	public void setCodigo_producto(String codigo_producto) 
	{
		this.codigo_producto = codigo_producto;
	}
	public void setNumero_serie(String numero_serie) 
	{
		this.numero_serie = numero_serie;
	}
	public void setDescripcion_producto(String descripcion_producto) 
	{
		this.descripcion_producto = descripcion_producto;
	}
	public void setNombre_producto(String nombre_producto) 
	{
		this.nombre_producto = nombre_producto;
	}
	public void setMarca_producto(String marca_producto) 
	{
		this.marca_producto = marca_producto;
	}
	public void setModelo_producto(String modelo_producto) 
	{
		this.modelo_producto = modelo_producto;
	}
	public void setContenido_unidad(String contenido_unidad) 
	{
		this.contenido_unidad = contenido_unidad;
	}
	public void setContenido_unidad_medida_id_contenido_unidad_medida(String contenido_unidad_medida_id_contenido_unidad_medida) 
	{
		this.contenido_unidad_medida_id_contenido_unidad_medida = contenido_unidad_medida_id_contenido_unidad_medida;
	}
	public void setUnidad_minima(String unidad_minima) 
	{
		this.unidad_minima = unidad_minima;
	}
	public void setContenido(String contenido) 
	{
		this.contenido = contenido;
	}
	public void setPeso_neto(String peso_neto) 
	{
		this.peso_neto = peso_neto;
	}
	public void setAlto_cm(String alto_cm) 
	{
		this.alto_cm = alto_cm;
	}
	public void setAncho_cm(String ancho_cm) 
	{
		this.ancho_cm = ancho_cm;
	}
	public void setFondo_cm(String fondo_cm) 
	{
		this.fondo_cm = fondo_cm;
	}
	public void setFabricante(String fabricante) 
	{
		this.fabricante = fabricante;
	}
	public void setClase_producto(String clase_producto) 
	{
		this.clase_producto = clase_producto;
	}
	public void setLinea_producto(String linea_producto) 
	{
		this.linea_producto = linea_producto;
	}
	public void setHot(String hot) 
	{
		this.hot = hot;
	}
	public void setSKU(String SKU) 
	{
		this.SKU = SKU;
	}
	public void setSubcategoria_id_subcategoria(String subcategoria_id_subcategoria) 
	{
		this.subcategoria_id_subcategoria = subcategoria_id_subcategoria;
	}
	public void setTipo_producto_id_tipo_producto(String tipo_producto_id_tipo_producto) 
	{
		this.tipo_producto_id_tipo_producto = tipo_producto_id_tipo_producto;
	}
	public void setFormato_producto_id_formato_producto(String formato_producto_id_formato_producto) 
	{
		this.formato_producto_id_formato_producto = formato_producto_id_formato_producto;
	}
	public void setFamilia_necesidad_id_familia_necesidad(String familia_necesidad_id_familia_necesidad) 
	{
		this.familia_necesidad_id_familia_necesidad = familia_necesidad_id_familia_necesidad;
	}
	public void setFamilia_producto_id_familia_producto(String familia_producto_id_familia_producto) 
	{
		this.familia_producto_id_familia_producto = familia_producto_id_familia_producto;
	}
	
}