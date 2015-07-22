package cl.webinc.benderand.movidos;

import java.util.HashMap;

import cl.webinc.benderand.provider.Base.precio;
import cl.webinc.benderand.provider.Base.producto;

public class ProjectionMaperRaw 

{
	public HashMap<String, String> Producto2Map(){
		HashMap<String, String> sproductoProjectionMap = new HashMap<String, String>();
	    sproductoProjectionMap.put(producto.id_producto, producto.id_producto);
	    sproductoProjectionMap.put(producto.codigo_producto, producto.codigo_producto);
	    sproductoProjectionMap.put(producto.numero_serie, producto.numero_serie);
	    sproductoProjectionMap.put(producto.descripcion_producto, producto.descripcion_producto);
	    sproductoProjectionMap.put(producto.subcategoria_id_subcategoria, producto.subcategoria_id_subcategoria);
	    sproductoProjectionMap.put(producto.nombre_producto, producto.nombre_producto);
	    sproductoProjectionMap.put(producto.marca_producto, producto.marca_producto);
	    sproductoProjectionMap.put(producto.modelo_producto, producto.modelo_producto);
	    sproductoProjectionMap.put(producto.contenido_unidad, producto.contenido_unidad);
	    sproductoProjectionMap.put(producto.unidad_minima, producto.unidad_minima);
	    sproductoProjectionMap.put(producto.contenido, producto.contenido);
	    sproductoProjectionMap.put(producto.peso_neto, producto.contenido);
	    sproductoProjectionMap.put(producto.alto_cm, producto.alto_cm);
	    sproductoProjectionMap.put(producto.ancho_cm, producto.ancho_cm);
	    sproductoProjectionMap.put(producto.fondo_cm, producto.fondo_cm);
	    sproductoProjectionMap.put(producto.fabricante, producto.fabricante);
	    sproductoProjectionMap.put(producto.clase_producto, producto.clase_producto);
	    sproductoProjectionMap.put(producto.linea_producto, producto.linea_producto);
	    sproductoProjectionMap.put(producto.SKU, producto.SKU);
	    sproductoProjectionMap.put(producto.hot, producto.hot);
	    sproductoProjectionMap.put(precio.precio_CLP, precio.precio_CLP);
		return sproductoProjectionMap;
	}
}
