package cl.webinc.benderand.sync;

import java.util.HashMap;

import android.content.ContentValues;
import android.util.Log;
import cl.webinc.benderand.provider.Base.*;

public class PostData 
{
	private static PostData cta;
	private PostData() {
		super();
	}
	public static PostData getinstance() 
	{
		if(cta == null)
		{
			cta = new PostData();
		}
		return cta;
	}
	public ContentValues postdataready(HashMap<String, String> map, String type)
	{
		Log.e("postdata", "" + type);
		ContentValues values = new ContentValues();
		if(type.equals("actividad"))
		{
			//values.put(actividad.id_actividad, map.get(actividad.id_actividad));
			values.put(actividad.nombre_actividad, map.get(actividad.nombre_actividad));
			values.put(actividad.codigo_actividad, map.get(actividad.codigo_actividad));
			values.put(actividad.categoria_actividad, map.get(actividad.categoria_actividad));
			values.put(actividad.afectoiva_actividad, map.get(actividad.afectoiva_actividad));
			values.put(actividad.disponible_internet_actividad, map.get(actividad.disponible_internet_actividad));
			values.put(actividad.subrubro_id_subrubro, map.get(actividad.subrubro_id_subrubro));
		}
		if(type.equals("calle"))
		{
			//values.put(calle.id_calle, map.get(calle.id_calle));
			values.put(calle.nombre_calle, map.get(calle.nombre_calle));
			values.put(calle.comuna_id_comuna, map.get(calle.comuna_id_comuna));
		}
		if(type.equals("caracteristica"))
		{
			//values.put(caracteristica.id_caracteristica, map.get(caracteristica.id_caracteristica));
			values.put(caracteristica.numero_caracteristica, map.get(caracteristica.numero_caracteristica));
			values.put(caracteristica.caracteristica, map.get(caracteristica.caracteristica));
			values.put(caracteristica.valor_caracteristica, map.get(caracteristica.valor_caracteristica));
			values.put(caracteristica.producto_id_producto, map.get(caracteristica.producto_id_producto));
		}
		if(type.equals("carne_empresa"))
		{
			//values.put(carne_empresa.id_carne_empresa, map.get(carne_empresa.id_carne_empresa));
			values.put(carne_empresa.nombre_usuario, map.get(carne_empresa.nombre_usuario));
			values.put(carne_empresa.clave_usuario, map.get(carne_empresa.clave_usuario));
			values.put(carne_empresa.empresa_id_empresa, map.get(carne_empresa.empresa_id_empresa));
			values.put(carne_empresa.persona_id_persona, map.get(carne_empresa.persona_id_persona));
			values.put(carne_empresa.tipo_usuario_id_tipo_usuario, map.get(carne_empresa.tipo_usuario_id_tipo_usuario));
		}
		if(type.equals("carne_empresacompleto"))
		{
			//values.put(carne_empresacompleto.id_carne_empresa, map.get(carne_empresacompleto.id_carne_empresa));
			values.put(carne_empresacompleto.nombre_usuario, map.get(carne_empresacompleto.nombre_usuario));
			values.put(carne_empresacompleto.clave_usuario, map.get(carne_empresacompleto.clave_usuario));
			values.put(carne_empresacompleto.tipo_usuario_id_tipo_usuario, map.get(carne_empresacompleto.tipo_usuario_id_tipo_usuario));
			//values.put(carne_empresacompleto.id_empresa, map.get(carne_empresacompleto.id_empresa));
			values.put(carne_empresacompleto.rut_empresa, map.get(carne_empresacompleto.rut_empresa));
			values.put(carne_empresacompleto.digito_verificador_empresa, map.get(carne_empresacompleto.digito_verificador_empresa));
			values.put(carne_empresacompleto.nombre_empresa, map.get(carne_empresacompleto.nombre_empresa));
			values.put(carne_empresacompleto.nombre_contacto_empresa, map.get(carne_empresacompleto.nombre_contacto_empresa));
			values.put(carne_empresacompleto.cargo_contacto_empresa, map.get(carne_empresacompleto.cargo_contacto_empresa));
			values.put(carne_empresacompleto.email_empresa, map.get(carne_empresacompleto.email_empresa));
			values.put(carne_empresacompleto.alcance_empresa, map.get(carne_empresacompleto.alcance_empresa));
			values.put(carne_empresacompleto.telefono_empresa, map.get(carne_empresacompleto.telefono_empresa));
			values.put(carne_empresacompleto.actividad_id_actividad, map.get(carne_empresacompleto.actividad_id_actividad));
			//values.put(carne_empresacompleto.id_persona, map.get(carne_empresacompleto.id_persona));
			values.put(carne_empresacompleto.rut_persona, map.get(carne_empresacompleto.rut_persona));
			values.put(carne_empresacompleto.digito_verificador, map.get(carne_empresacompleto.digito_verificador));
			values.put(carne_empresacompleto.nombre_persona, map.get(carne_empresacompleto.nombre_persona));
			values.put(carne_empresacompleto.segundo_nombre_persona, map.get(carne_empresacompleto.segundo_nombre_persona));
			values.put(carne_empresacompleto.apellido_persona, map.get(carne_empresacompleto.apellido_persona));
			values.put(carne_empresacompleto.segundo_apellido_persona, map.get(carne_empresacompleto.segundo_apellido_persona));
			values.put(carne_empresacompleto.actividad, map.get(carne_empresacompleto.actividad));
			values.put(carne_empresacompleto.area_actividad, map.get(carne_empresacompleto.area_actividad));
			values.put(carne_empresacompleto.dia_fecha_nacimiento, map.get(carne_empresacompleto.dia_fecha_nacimiento));
			values.put(carne_empresacompleto.mes_fecha_nacimiento, map.get(carne_empresacompleto.mes_fecha_nacimiento));
			values.put(carne_empresacompleto.ano_fecha_nacimiento, map.get(carne_empresacompleto.ano_fecha_nacimiento));
			values.put(carne_empresacompleto.edad, map.get(carne_empresacompleto.edad));
			values.put(carne_empresacompleto.email, map.get(carne_empresacompleto.email));
			values.put(carne_empresacompleto.celular, map.get(carne_empresacompleto.celular));
			values.put(carne_empresacompleto.telefono, map.get(carne_empresacompleto.telefono));
		}
		if(type.equals("carro_compras"))
		{
			//values.put(carro_compras.id_carro_compras, map.get(carro_compras.id_carro_compras));
			values.put(carro_compras.cantidad_carro, map.get(carro_compras.cantidad_carro));
			values.put(carro_compras.precio_carro, map.get(carro_compras.precio_carro));
			values.put(carro_compras.mayor, map.get(carro_compras.mayor));
			values.put(carro_compras.tienda, map.get(carro_compras.tienda));
			values.put(carro_compras.usuario_id_usuario, map.get(carro_compras.usuario_id_usuario));
			values.put(carro_compras.producto_id_producto, map.get(carro_compras.producto_id_producto));
			values.put(carro_compras.empresa_id_empresa, map.get(carro_compras.empresa_id_empresa));
			values.put(carro_compras.usado, map.get(carro_compras.usado));
			values.put(carro_compras.carne_empresa_id_carne_empresa, map.get(carro_compras.carne_empresa_id_carne_empresa));
		}
		if(type.equals("carro_comprascompleto"))
		{
			//values.put(carro_comprascompleto.id_carro_compras, map.get(carro_comprascompleto.id_carro_compras));
			values.put(carro_comprascompleto.cantidad_carro, map.get(carro_comprascompleto.cantidad_carro));
			values.put(carro_comprascompleto.precio_carro, map.get(carro_comprascompleto.precio_carro));
			values.put(carro_comprascompleto.mayor, map.get(carro_comprascompleto.mayor));
			values.put(carro_comprascompleto.tienda, map.get(carro_comprascompleto.tienda));
			values.put(carro_comprascompleto.usuario_id_usuario, map.get(carro_comprascompleto.usuario_id_usuario));
			values.put(carro_comprascompleto.usado, map.get(carro_comprascompleto.usado));
			values.put(carro_comprascompleto.carne_empresa_id_carne_empresa, map.get(carro_comprascompleto.carne_empresa_id_carne_empresa));
			//values.put(carro_comprascompleto.id_precio, map.get(carro_comprascompleto.id_precio));
			values.put(carro_comprascompleto.precio_CLP, map.get(carro_comprascompleto.precio_CLP));
			values.put(carro_comprascompleto.precio_us, map.get(carro_comprascompleto.precio_us));
			values.put(carro_comprascompleto.precio_mayor_CLP, map.get(carro_comprascompleto.precio_mayor_CLP));
			values.put(carro_comprascompleto.precio_mayor_us, map.get(carro_comprascompleto.precio_mayor_us));
			values.put(carro_comprascompleto.precio_actual, map.get(carro_comprascompleto.precio_actual));
			values.put(carro_comprascompleto.descuento_promocion, map.get(carro_comprascompleto.descuento_promocion));
			values.put(carro_comprascompleto.cantidad_mayor, map.get(carro_comprascompleto.cantidad_mayor));
			//values.put(carro_comprascompleto.id_producto, map.get(carro_comprascompleto.id_producto));
			values.put(carro_comprascompleto.codigo_producto, map.get(carro_comprascompleto.codigo_producto));
			values.put(carro_comprascompleto.numero_serie, map.get(carro_comprascompleto.numero_serie));
			values.put(carro_comprascompleto.descripcion_producto, map.get(carro_comprascompleto.descripcion_producto));
			values.put(carro_comprascompleto.nombre_producto, map.get(carro_comprascompleto.nombre_producto));
			values.put(carro_comprascompleto.marca_producto, map.get(carro_comprascompleto.marca_producto));
			values.put(carro_comprascompleto.modelo_producto, map.get(carro_comprascompleto.modelo_producto));
			values.put(carro_comprascompleto.contenido_unidad, map.get(carro_comprascompleto.contenido_unidad));
			values.put(carro_comprascompleto.unidad_minima, map.get(carro_comprascompleto.unidad_minima));
			values.put(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida, map.get(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(carro_comprascompleto.contenido, map.get(carro_comprascompleto.contenido));
			values.put(carro_comprascompleto.peso_neto, map.get(carro_comprascompleto.peso_neto));
			values.put(carro_comprascompleto.alto_cm, map.get(carro_comprascompleto.alto_cm));
			values.put(carro_comprascompleto.ancho_cm, map.get(carro_comprascompleto.ancho_cm));
			values.put(carro_comprascompleto.fondo_cm, map.get(carro_comprascompleto.fondo_cm));
			values.put(carro_comprascompleto.fabricante, map.get(carro_comprascompleto.fabricante));
			values.put(carro_comprascompleto.familia_necesidad_id_familia_necesidad, map.get(carro_comprascompleto.familia_necesidad_id_familia_necesidad));
			values.put(carro_comprascompleto.familia_producto_id_familia_producto, map.get(carro_comprascompleto.familia_producto_id_familia_producto));
			values.put(carro_comprascompleto.clase_producto, map.get(carro_comprascompleto.clase_producto));
			values.put(carro_comprascompleto.linea_producto, map.get(carro_comprascompleto.linea_producto));
			values.put(carro_comprascompleto.tipo_producto_id_tipo_producto, map.get(carro_comprascompleto.tipo_producto_id_tipo_producto));
			values.put(carro_comprascompleto.hot, map.get(carro_comprascompleto.hot));
			values.put(carro_comprascompleto.subcategoria_id_subcategoria, map.get(carro_comprascompleto.subcategoria_id_subcategoria));
			values.put(carro_comprascompleto.SKU, map.get(carro_comprascompleto.SKU));
			values.put(carro_comprascompleto.formato_producto_id_formato_producto, map.get(carro_comprascompleto.formato_producto_id_formato_producto));
			values.put(carro_comprascompleto.stock_tienda, map.get(carro_comprascompleto.stock_tienda));
		}
		if(type.equals("carro_egresos"))
		{
			//values.put(carro_egresos.id_carro_egresos, map.get(carro_egresos.id_carro_egresos));
			values.put(carro_egresos.cantidad_carro, map.get(carro_egresos.cantidad_carro));
			values.put(carro_egresos.precio_carro, map.get(carro_egresos.precio_carro));
			values.put(carro_egresos.mayor, map.get(carro_egresos.mayor));
			values.put(carro_egresos.tienda, map.get(carro_egresos.tienda));
			values.put(carro_egresos.usado, map.get(carro_egresos.usado));
			values.put(carro_egresos.producto_id_producto, map.get(carro_egresos.producto_id_producto));
			values.put(carro_egresos.usuario_id_usuario, map.get(carro_egresos.usuario_id_usuario));
			values.put(carro_egresos.empresa_id_empresa, map.get(carro_egresos.empresa_id_empresa));
			values.put(carro_egresos.carne_empresa_id_carne_empresa, map.get(carro_egresos.carne_empresa_id_carne_empresa));
		}
		if(type.equals("carro_egresoscompleto"))
		{
			//values.put(carro_egresoscompleto.id_carro_egresos, map.get(carro_egresoscompleto.id_carro_egresos));
			values.put(carro_egresoscompleto.cantidad_carro, map.get(carro_egresoscompleto.cantidad_carro));
			values.put(carro_egresoscompleto.precio_carro, map.get(carro_egresoscompleto.precio_carro));
			values.put(carro_egresoscompleto.mayor, map.get(carro_egresoscompleto.mayor));
			values.put(carro_egresoscompleto.tienda, map.get(carro_egresoscompleto.tienda));
			values.put(carro_egresoscompleto.usuario_id_usuario, map.get(carro_egresoscompleto.usuario_id_usuario));
			values.put(carro_egresoscompleto.usado, map.get(carro_egresoscompleto.usado));
			values.put(carro_egresoscompleto.carne_empresa_id_carne_empresa, map.get(carro_egresoscompleto.carne_empresa_id_carne_empresa));
			//values.put(carro_egresoscompleto.id_producto, map.get(carro_egresoscompleto.id_producto));
			values.put(carro_egresoscompleto.codigo_producto, map.get(carro_egresoscompleto.codigo_producto));
			values.put(carro_egresoscompleto.numero_serie, map.get(carro_egresoscompleto.numero_serie));
			values.put(carro_egresoscompleto.descripcion_producto, map.get(carro_egresoscompleto.descripcion_producto));
			values.put(carro_egresoscompleto.nombre_producto, map.get(carro_egresoscompleto.nombre_producto));
			values.put(carro_egresoscompleto.marca_producto, map.get(carro_egresoscompleto.marca_producto));
			values.put(carro_egresoscompleto.modelo_producto, map.get(carro_egresoscompleto.modelo_producto));
			values.put(carro_egresoscompleto.contenido_unidad, map.get(carro_egresoscompleto.contenido_unidad));
			values.put(carro_egresoscompleto.unidad_minima, map.get(carro_egresoscompleto.unidad_minima));
			values.put(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida, map.get(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(carro_egresoscompleto.contenido, map.get(carro_egresoscompleto.contenido));
			values.put(carro_egresoscompleto.peso_neto, map.get(carro_egresoscompleto.peso_neto));
			values.put(carro_egresoscompleto.alto_cm, map.get(carro_egresoscompleto.alto_cm));
			values.put(carro_egresoscompleto.ancho_cm, map.get(carro_egresoscompleto.ancho_cm));
			values.put(carro_egresoscompleto.fondo_cm, map.get(carro_egresoscompleto.fondo_cm));
			values.put(carro_egresoscompleto.fabricante, map.get(carro_egresoscompleto.fabricante));
			values.put(carro_egresoscompleto.familia_necesidad_id_familia_necesidad, map.get(carro_egresoscompleto.familia_necesidad_id_familia_necesidad));
			values.put(carro_egresoscompleto.familia_producto_id_familia_producto, map.get(carro_egresoscompleto.familia_producto_id_familia_producto));
			values.put(carro_egresoscompleto.clase_producto, map.get(carro_egresoscompleto.clase_producto));
			values.put(carro_egresoscompleto.linea_producto, map.get(carro_egresoscompleto.linea_producto));
			values.put(carro_egresoscompleto.tipo_producto_id_tipo_producto, map.get(carro_egresoscompleto.tipo_producto_id_tipo_producto));
			values.put(carro_egresoscompleto.hot, map.get(carro_egresoscompleto.hot));
			values.put(carro_egresoscompleto.subcategoria_id_subcategoria, map.get(carro_egresoscompleto.subcategoria_id_subcategoria));
			values.put(carro_egresoscompleto.SKU, map.get(carro_egresoscompleto.SKU));
			values.put(carro_egresoscompleto.formato_producto_id_formato_producto, map.get(carro_egresoscompleto.formato_producto_id_formato_producto));
			values.put(carro_egresoscompleto.stock_tienda, map.get(carro_egresoscompleto.stock_tienda));
			values.put(carro_egresoscompleto.precio_CLP, map.get(carro_egresoscompleto.precio_CLP));
		}
		if(type.equals("carro_egresosproducto"))
		{
			//values.put(carro_egresosproducto.id_carro_egresos, map.get(carro_egresosproducto.id_carro_egresos));
			values.put(carro_egresosproducto.cantidad_carro, map.get(carro_egresosproducto.cantidad_carro));
			values.put(carro_egresosproducto.precio_carro, map.get(carro_egresosproducto.precio_carro));
			values.put(carro_egresosproducto.mayor, map.get(carro_egresosproducto.mayor));
			values.put(carro_egresosproducto.tienda, map.get(carro_egresosproducto.tienda));
			values.put(carro_egresosproducto.usuario_id_usuario, map.get(carro_egresosproducto.usuario_id_usuario));
			values.put(carro_egresosproducto.usado, map.get(carro_egresosproducto.usado));
			values.put(carro_egresosproducto.carne_empresa_id_carne_empresa, map.get(carro_egresosproducto.carne_empresa_id_carne_empresa));
			//values.put(carro_egresosproducto.id_producto, map.get(carro_egresosproducto.id_producto));
			values.put(carro_egresosproducto.codigo_producto, map.get(carro_egresosproducto.codigo_producto));
			values.put(carro_egresosproducto.numero_serie, map.get(carro_egresosproducto.numero_serie));
			values.put(carro_egresosproducto.descripcion_producto, map.get(carro_egresosproducto.descripcion_producto));
			values.put(carro_egresosproducto.nombre_producto, map.get(carro_egresosproducto.nombre_producto));
			values.put(carro_egresosproducto.marca_producto, map.get(carro_egresosproducto.marca_producto));
			values.put(carro_egresosproducto.modelo_producto, map.get(carro_egresosproducto.modelo_producto));
			values.put(carro_egresosproducto.contenido_unidad, map.get(carro_egresosproducto.contenido_unidad));
			values.put(carro_egresosproducto.unidad_minima, map.get(carro_egresosproducto.unidad_minima));
			values.put(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida, map.get(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(carro_egresosproducto.contenido, map.get(carro_egresosproducto.contenido));
			values.put(carro_egresosproducto.peso_neto, map.get(carro_egresosproducto.peso_neto));
			values.put(carro_egresosproducto.alto_cm, map.get(carro_egresosproducto.alto_cm));
			values.put(carro_egresosproducto.ancho_cm, map.get(carro_egresosproducto.ancho_cm));
			values.put(carro_egresosproducto.fondo_cm, map.get(carro_egresosproducto.fondo_cm));
			values.put(carro_egresosproducto.fabricante, map.get(carro_egresosproducto.fabricante));
			values.put(carro_egresosproducto.familia_necesidad_id_familia_necesidad, map.get(carro_egresosproducto.familia_necesidad_id_familia_necesidad));
			values.put(carro_egresosproducto.familia_producto_id_familia_producto, map.get(carro_egresosproducto.familia_producto_id_familia_producto));
			values.put(carro_egresosproducto.clase_producto, map.get(carro_egresosproducto.clase_producto));
			values.put(carro_egresosproducto.linea_producto, map.get(carro_egresosproducto.linea_producto));
			values.put(carro_egresosproducto.tipo_producto_id_tipo_producto, map.get(carro_egresosproducto.tipo_producto_id_tipo_producto));
			values.put(carro_egresosproducto.hot, map.get(carro_egresosproducto.hot));
			values.put(carro_egresosproducto.subcategoria_id_subcategoria, map.get(carro_egresosproducto.subcategoria_id_subcategoria));
			values.put(carro_egresosproducto.SKU, map.get(carro_egresosproducto.SKU));
			values.put(carro_egresosproducto.formato_producto_id_formato_producto, map.get(carro_egresosproducto.formato_producto_id_formato_producto));
		}
		if(type.equals("carro_venta"))
		{
			//values.put(carro_venta.id_carro_venta, map.get(carro_venta.id_carro_venta));
			values.put(carro_venta.cantidad, map.get(carro_venta.cantidad));
			values.put(carro_venta.precio, map.get(carro_venta.precio));
			values.put(carro_venta.carro_compras_id_carro_compras, map.get(carro_venta.carro_compras_id_carro_compras));
			values.put(carro_venta.venta_id_venta, map.get(carro_venta.venta_id_venta));
		}
		if(type.equals("carro_ventacompleto"))
		{
			//values.put(carro_ventacompleto.id_carro_venta, map.get(carro_ventacompleto.id_carro_venta));
			values.put(carro_ventacompleto.cantidad, map.get(carro_ventacompleto.cantidad));
			values.put(carro_ventacompleto.precio, map.get(carro_ventacompleto.precio));
			values.put(carro_ventacompleto.venta_id_venta, map.get(carro_ventacompleto.venta_id_venta));
			//values.put(carro_ventacompleto.id_carro_compras, map.get(carro_ventacompleto.id_carro_compras));
			values.put(carro_ventacompleto.cantidad_carro, map.get(carro_ventacompleto.cantidad_carro));
			values.put(carro_ventacompleto.precio_carro, map.get(carro_ventacompleto.precio_carro));
			values.put(carro_ventacompleto.mayor, map.get(carro_ventacompleto.mayor));
			values.put(carro_ventacompleto.tienda, map.get(carro_ventacompleto.tienda));
			values.put(carro_ventacompleto.usuario_id_usuario, map.get(carro_ventacompleto.usuario_id_usuario));
			values.put(carro_ventacompleto.usado, map.get(carro_ventacompleto.usado));
			values.put(carro_ventacompleto.carne_empresa_id_carne_empresa, map.get(carro_ventacompleto.carne_empresa_id_carne_empresa));
			//values.put(carro_ventacompleto.id_precio, map.get(carro_ventacompleto.id_precio));
			values.put(carro_ventacompleto.precio_CLP, map.get(carro_ventacompleto.precio_CLP));
			values.put(carro_ventacompleto.precio_us, map.get(carro_ventacompleto.precio_us));
			values.put(carro_ventacompleto.precio_mayor_CLP, map.get(carro_ventacompleto.precio_mayor_CLP));
			values.put(carro_ventacompleto.precio_mayor_us, map.get(carro_ventacompleto.precio_mayor_us));
			values.put(carro_ventacompleto.precio_actual, map.get(carro_ventacompleto.precio_actual));
			values.put(carro_ventacompleto.descuento_promocion, map.get(carro_ventacompleto.descuento_promocion));
			values.put(carro_ventacompleto.cantidad_mayor, map.get(carro_ventacompleto.cantidad_mayor));
			//values.put(carro_ventacompleto.id_producto, map.get(carro_ventacompleto.id_producto));
			values.put(carro_ventacompleto.codigo_producto, map.get(carro_ventacompleto.codigo_producto));
			values.put(carro_ventacompleto.numero_serie, map.get(carro_ventacompleto.numero_serie));
			values.put(carro_ventacompleto.descripcion_producto, map.get(carro_ventacompleto.descripcion_producto));
			values.put(carro_ventacompleto.nombre_producto, map.get(carro_ventacompleto.nombre_producto));
			values.put(carro_ventacompleto.marca_producto, map.get(carro_ventacompleto.marca_producto));
			values.put(carro_ventacompleto.modelo_producto, map.get(carro_ventacompleto.modelo_producto));
			values.put(carro_ventacompleto.contenido_unidad, map.get(carro_ventacompleto.contenido_unidad));
			values.put(carro_ventacompleto.unidad_minima, map.get(carro_ventacompleto.unidad_minima));
			values.put(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida, map.get(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(carro_ventacompleto.contenido, map.get(carro_ventacompleto.contenido));
			values.put(carro_ventacompleto.peso_neto, map.get(carro_ventacompleto.peso_neto));
			values.put(carro_ventacompleto.alto_cm, map.get(carro_ventacompleto.alto_cm));
			values.put(carro_ventacompleto.ancho_cm, map.get(carro_ventacompleto.ancho_cm));
			values.put(carro_ventacompleto.fondo_cm, map.get(carro_ventacompleto.fondo_cm));
			values.put(carro_ventacompleto.fabricante, map.get(carro_ventacompleto.fabricante));
			values.put(carro_ventacompleto.familia_necesidad_id_familia_necesidad, map.get(carro_ventacompleto.familia_necesidad_id_familia_necesidad));
			values.put(carro_ventacompleto.familia_producto_id_familia_producto, map.get(carro_ventacompleto.familia_producto_id_familia_producto));
			values.put(carro_ventacompleto.clase_producto, map.get(carro_ventacompleto.clase_producto));
			values.put(carro_ventacompleto.linea_producto, map.get(carro_ventacompleto.linea_producto));
			values.put(carro_ventacompleto.tipo_producto_id_tipo_producto, map.get(carro_ventacompleto.tipo_producto_id_tipo_producto));
			values.put(carro_ventacompleto.hot, map.get(carro_ventacompleto.hot));
			values.put(carro_ventacompleto.subcategoria_id_subcategoria, map.get(carro_ventacompleto.subcategoria_id_subcategoria));
			values.put(carro_ventacompleto.SKU, map.get(carro_ventacompleto.SKU));
			values.put(carro_ventacompleto.formato_producto_id_formato_producto, map.get(carro_ventacompleto.formato_producto_id_formato_producto));
		}
		if(type.equals("categoria"))
		{
			//values.put(categoria.id_categoria, map.get(categoria.id_categoria));
			values.put(categoria.nombre_categoria, map.get(categoria.nombre_categoria));
		}
		if(type.equals("categoria_empresa"))
		{
			//values.put(categoria_empresa.id_categoria_empresa, map.get(categoria_empresa.id_categoria_empresa));
			values.put(categoria_empresa.nombre_categoria_empresa, map.get(categoria_empresa.nombre_categoria_empresa));
		}
		if(type.equals("ci_sessions"))
		{
			values.put(ci_sessions.session_id, map.get(ci_sessions.session_id));
			values.put(ci_sessions.ip_address, map.get(ci_sessions.ip_address));
			values.put(ci_sessions.user_agent, map.get(ci_sessions.user_agent));
			//values.put(ci_sessions.id_user, map.get(ci_sessions.id_user));
			values.put(ci_sessions.nombre_apellido, map.get(ci_sessions.nombre_apellido));
			values.put(ci_sessions.email_user, map.get(ci_sessions.email_user));
			values.put(ci_sessions.last_activity, map.get(ci_sessions.last_activity));
			values.put(ci_sessions.user_data, map.get(ci_sessions.user_data));
		}
		if(type.equals("cliente"))
		{
			//values.put(cliente.id_cliente, map.get(cliente.id_cliente));
			values.put(cliente.rut_cliente, map.get(cliente.rut_cliente));
			values.put(cliente.digito_verificador, map.get(cliente.digito_verificador));
			values.put(cliente.nombre_cliente, map.get(cliente.nombre_cliente));
			values.put(cliente.segundo_nombre_cliente, map.get(cliente.segundo_nombre_cliente));
			values.put(cliente.apellido_cliente, map.get(cliente.apellido_cliente));
			values.put(cliente.segundo_apellido_cliente, map.get(cliente.segundo_apellido_cliente));
			values.put(cliente.actividad, map.get(cliente.actividad));
			values.put(cliente.area_actividad, map.get(cliente.area_actividad));
			values.put(cliente.dia_fecha_nacimiento, map.get(cliente.dia_fecha_nacimiento));
			values.put(cliente.mes_fecha_nacimiento, map.get(cliente.mes_fecha_nacimiento));
			values.put(cliente.ano_fecha_nacimiento, map.get(cliente.ano_fecha_nacimiento));
			values.put(cliente.edad, map.get(cliente.edad));
			values.put(cliente.email, map.get(cliente.email));
			values.put(cliente.celular, map.get(cliente.celular));
			values.put(cliente.telefono, map.get(cliente.telefono));
		}
		if(type.equals("cliente_empresa"))
		{
			//values.put(cliente_empresa.id_cliente_empresa, map.get(cliente_empresa.id_cliente_empresa));
			values.put(cliente_empresa.rut_cliente_empresa, map.get(cliente_empresa.rut_cliente_empresa));
			values.put(cliente_empresa.digito_verificador, map.get(cliente_empresa.digito_verificador));
			values.put(cliente_empresa.nombre, map.get(cliente_empresa.nombre));
			values.put(cliente_empresa.email_cliente_empresa, map.get(cliente_empresa.email_cliente_empresa));
			values.put(cliente_empresa.actividad_id_actividad, map.get(cliente_empresa.actividad_id_actividad));
			values.put(cliente_empresa.empresa_id_empresa, map.get(cliente_empresa.empresa_id_empresa));
		}
		if(type.equals("compracompleta"))
		{
			//values.put(compracompleta.id_factura, map.get(compracompleta.id_factura));
			values.put(compracompleta.rol_factura, map.get(compracompleta.rol_factura));
			values.put(compracompleta.dia_factura, map.get(compracompleta.dia_factura));
			values.put(compracompleta.mes_factura, map.get(compracompleta.mes_factura));
			values.put(compracompleta.ano_factura, map.get(compracompleta.ano_factura));
			values.put(compracompleta.fecha_factura, map.get(compracompleta.fecha_factura));
			values.put(compracompleta.empresa_id_empresa, map.get(compracompleta.empresa_id_empresa));
			values.put(compracompleta.carne_empresa_id_carne_empresa, map.get(compracompleta.carne_empresa_id_carne_empresa));
			values.put(compracompleta.rut_proveedor, map.get(compracompleta.rut_proveedor));
			values.put(compracompleta.nombre_proveedor, map.get(compracompleta.nombre_proveedor));
			values.put(compracompleta.telefono_proveedor, map.get(compracompleta.telefono_proveedor));
			values.put(compracompleta.tipo_documento_id_tipo_documento, map.get(compracompleta.tipo_documento_id_tipo_documento));
			values.put(compracompleta.tipo_pago_id_tipo_pago, map.get(compracompleta.tipo_pago_id_tipo_pago));
			values.put(compracompleta.total_factura, map.get(compracompleta.total_factura));
			//values.put(compracompleta.id_tipo_pago, map.get(compracompleta.id_tipo_pago));
			values.put(compracompleta.nombre_tipo_pago, map.get(compracompleta.nombre_tipo_pago));
			values.put(compracompleta.comision_tipo_pago, map.get(compracompleta.comision_tipo_pago));
			//values.put(compracompleta.id_tipo_documento, map.get(compracompleta.id_tipo_documento));
			values.put(compracompleta.nombre_tipo_documento, map.get(compracompleta.nombre_tipo_documento));
		}
		if(type.equals("comuna"))
		{
			//values.put(comuna.id_comuna, map.get(comuna.id_comuna));
			values.put(comuna.codigo_comuna, map.get(comuna.codigo_comuna));
			values.put(comuna.nombre_comuna, map.get(comuna.nombre_comuna));
			values.put(comuna.provincia_id_provincia, map.get(comuna.provincia_id_provincia));
		}
		if(type.equals("contenido_unidad_medida"))
		{
			//values.put(contenido_unidad_medida.id_contenido_unidad_medida, map.get(contenido_unidad_medida.id_contenido_unidad_medida));
			values.put(contenido_unidad_medida.nombre_contenido_unidad_medida, map.get(contenido_unidad_medida.nombre_contenido_unidad_medida));
		}
		if(type.equals("dia"))
		{
			values.put(dia.iddia, map.get(dia.iddia));
			values.put(dia.dia, map.get(dia.dia));
			values.put(dia.mes, map.get(dia.mes));
			values.put(dia.anno, map.get(dia.anno));
			values.put(dia.fecha, map.get(dia.fecha));
			values.put(dia.egreso, map.get(dia.egreso));
			values.put(dia.ingreso, map.get(dia.ingreso));
			values.put(dia.impuesto, map.get(dia.impuesto));
		}
		if(type.equals("empresa"))
		{
			//values.put(empresa.id_empresa, map.get(empresa.id_empresa));
			values.put(empresa.rut_empresa, map.get(empresa.rut_empresa));
			values.put(empresa.digito_verificador_empresa, map.get(empresa.digito_verificador_empresa));
			values.put(empresa.nombre_empresa, map.get(empresa.nombre_empresa));
			values.put(empresa.nombre_contacto_empresa, map.get(empresa.nombre_contacto_empresa));
			values.put(empresa.cargo_contacto_empresa, map.get(empresa.cargo_contacto_empresa));
			values.put(empresa.email_empresa, map.get(empresa.email_empresa));
			values.put(empresa.alcance_empresa, map.get(empresa.alcance_empresa));
			values.put(empresa.telefono_empresa, map.get(empresa.telefono_empresa));
			values.put(empresa.actividad_id_actividad, map.get(empresa.actividad_id_actividad));
			values.put(empresa.tipo_empresa_id_tipo_empresa, map.get(empresa.tipo_empresa_id_tipo_empresa));
		}
		if(type.equals("envio"))
		{
			//values.put(envio.id_envio, map.get(envio.id_envio));
			values.put(envio.direccion_alternativa, map.get(envio.direccion_alternativa));
			values.put(envio.fecha_entrega, map.get(envio.fecha_entrega));
			values.put(envio.hora_entrega, map.get(envio.hora_entrega));
			values.put(envio.venta_id_venta, map.get(envio.venta_id_venta));
			values.put(envio.enviado, map.get(envio.enviado));
		}
		if(type.equals("factura"))
		{
			//values.put(factura.id_factura, map.get(factura.id_factura));
			values.put(factura.rol_factura, map.get(factura.rol_factura));
			values.put(factura.dia_factura, map.get(factura.dia_factura));
			values.put(factura.mes_factura, map.get(factura.mes_factura));
			values.put(factura.ano_factura, map.get(factura.ano_factura));
			values.put(factura.fecha_factura, map.get(factura.fecha_factura));
			values.put(factura.empresa_id_empresa, map.get(factura.empresa_id_empresa));
			values.put(factura.carne_empresa_id_carne_empresa, map.get(factura.carne_empresa_id_carne_empresa));
			values.put(factura.rut_proveedor, map.get(factura.rut_proveedor));
			values.put(factura.nombre_proveedor, map.get(factura.nombre_proveedor));
			values.put(factura.telefono_proveedor, map.get(factura.telefono_proveedor));
			values.put(factura.tipo_documento_id_tipo_documento, map.get(factura.tipo_documento_id_tipo_documento));
			values.put(factura.tipo_pago_id_tipo_pago, map.get(factura.tipo_pago_id_tipo_pago));
			values.put(factura.total_factura, map.get(factura.total_factura));
		}
		if(type.equals("familia_necesidad"))
		{
			//values.put(familia_necesidad.id_familia_necesidad, map.get(familia_necesidad.id_familia_necesidad));
			values.put(familia_necesidad.nombre_familia_necesidad, map.get(familia_necesidad.nombre_familia_necesidad));
		}
		if(type.equals("familia_producto"))
		{
			//values.put(familia_producto.id_familia_producto, map.get(familia_producto.id_familia_producto));
			values.put(familia_producto.nombre_familia_producto, map.get(familia_producto.nombre_familia_producto));
		}
		if(type.equals("formato_producto"))
		{
			//values.put(formato_producto.id_formato_producto, map.get(formato_producto.id_formato_producto));
			values.put(formato_producto.nombre_formato_producto, map.get(formato_producto.nombre_formato_producto));
		}
		if(type.equals("gasto"))
		{
			//values.put(gasto.id_gasto, map.get(gasto.id_gasto));
			values.put(gasto.nombre_gasto, map.get(gasto.nombre_gasto));
			//values.put(gasto.id_usuario, map.get(gasto.id_usuario));
			values.put(gasto.monto_gasto, map.get(gasto.monto_gasto));
			values.put(gasto.fecha_gasto, map.get(gasto.fecha_gasto));
			values.put(gasto.empresa_id_empre, map.get(gasto.empresa_id_empre));
		}
		if(type.equals("geocode_cache"))
		{
			values.put(geocode_cache.id, map.get(geocode_cache.id));
			values.put(geocode_cache.lng, map.get(geocode_cache.lng));
			values.put(geocode_cache.lat, map.get(geocode_cache.lat));
			values.put(geocode_cache.query, map.get(geocode_cache.query));
		}
		if(type.equals("imagenprod"))
		{
			//values.put(imagenprod.id_imagenprod, map.get(imagenprod.id_imagenprod));
			values.put(imagenprod.urlimagenprod, map.get(imagenprod.urlimagenprod));
			values.put(imagenprod.producto_id_producto, map.get(imagenprod.producto_id_producto));
		}
		if(type.equals("impuesto"))
		{
			//values.put(impuesto.id_impuesto, map.get(impuesto.id_impuesto));
			values.put(impuesto.nombre_impuesto, map.get(impuesto.nombre_impuesto));
			values.put(impuesto.valor_impuesto, map.get(impuesto.valor_impuesto));
		}
		if(type.equals("ingresosegresos"))
		{
			values.put(ingresosegresos.dia, map.get(ingresosegresos.dia));
			values.put(ingresosegresos.mes, map.get(ingresosegresos.mes));
			values.put(ingresosegresos.anno, map.get(ingresosegresos.anno));
			values.put(ingresosegresos.fecha, map.get(ingresosegresos.fecha));
			values.put(ingresosegresos.totalingreso, map.get(ingresosegresos.totalingreso));
			values.put(ingresosegresos.totalgasto, map.get(ingresosegresos.totalgasto));
			values.put(ingresosegresos.impuestoegreso, map.get(ingresosegresos.impuestoegreso));
			values.put(ingresosegresos.impuestoingreso, map.get(ingresosegresos.impuestoingreso));
		}
		if(type.equals("item_factura"))
		{
			//values.put(item_factura.id_itemfactura, map.get(item_factura.id_itemfactura));
			values.put(item_factura.cantidad, map.get(item_factura.cantidad));
			values.put(item_factura.precio, map.get(item_factura.precio));
			values.put(item_factura.producto_id_producto, map.get(item_factura.producto_id_producto));
			values.put(item_factura.factura_id_factura, map.get(item_factura.factura_id_factura));
			values.put(item_factura.carro_egresos_id_carro_egresos, map.get(item_factura.carro_egresos_id_carro_egresos));
		}
		if(type.equals("item_facturacompleto"))
		{
			//values.put(item_facturacompleto.id_itemfactura, map.get(item_facturacompleto.id_itemfactura));
			values.put(item_facturacompleto.cantidad, map.get(item_facturacompleto.cantidad));
			values.put(item_facturacompleto.precio, map.get(item_facturacompleto.precio));
			values.put(item_facturacompleto.producto_id_producto, map.get(item_facturacompleto.producto_id_producto));
			values.put(item_facturacompleto.factura_id_factura, map.get(item_facturacompleto.factura_id_factura));
			//values.put(item_facturacompleto.id_producto, map.get(item_facturacompleto.id_producto));
			values.put(item_facturacompleto.codigo_producto, map.get(item_facturacompleto.codigo_producto));
			values.put(item_facturacompleto.numero_serie, map.get(item_facturacompleto.numero_serie));
			values.put(item_facturacompleto.descripcion_producto, map.get(item_facturacompleto.descripcion_producto));
			values.put(item_facturacompleto.nombre_producto, map.get(item_facturacompleto.nombre_producto));
			values.put(item_facturacompleto.marca_producto, map.get(item_facturacompleto.marca_producto));
			values.put(item_facturacompleto.modelo_producto, map.get(item_facturacompleto.modelo_producto));
			values.put(item_facturacompleto.contenido_unidad, map.get(item_facturacompleto.contenido_unidad));
			values.put(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida, map.get(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(item_facturacompleto.unidad_minima, map.get(item_facturacompleto.unidad_minima));
			values.put(item_facturacompleto.contenido, map.get(item_facturacompleto.contenido));
			values.put(item_facturacompleto.peso_neto, map.get(item_facturacompleto.peso_neto));
			values.put(item_facturacompleto.alto_cm, map.get(item_facturacompleto.alto_cm));
			values.put(item_facturacompleto.ancho_cm, map.get(item_facturacompleto.ancho_cm));
			values.put(item_facturacompleto.fondo_cm, map.get(item_facturacompleto.fondo_cm));
			values.put(item_facturacompleto.fabricante, map.get(item_facturacompleto.fabricante));
			values.put(item_facturacompleto.clase_producto, map.get(item_facturacompleto.clase_producto));
			values.put(item_facturacompleto.linea_producto, map.get(item_facturacompleto.linea_producto));
			values.put(item_facturacompleto.hot, map.get(item_facturacompleto.hot));
			values.put(item_facturacompleto.SKU, map.get(item_facturacompleto.SKU));
			values.put(item_facturacompleto.subcategoria_id_subcategoria, map.get(item_facturacompleto.subcategoria_id_subcategoria));
			values.put(item_facturacompleto.tipo_producto_id_tipo_producto, map.get(item_facturacompleto.tipo_producto_id_tipo_producto));
			values.put(item_facturacompleto.formato_producto_id_formato_producto, map.get(item_facturacompleto.formato_producto_id_formato_producto));
			values.put(item_facturacompleto.familia_necesidad_id_familia_necesidad, map.get(item_facturacompleto.familia_necesidad_id_familia_necesidad));
			values.put(item_facturacompleto.familia_producto_id_familia_producto, map.get(item_facturacompleto.familia_producto_id_familia_producto));
		}
		if(type.equals("mapa"))
		{
			values.put(mapa.id, map.get(mapa.id));
			values.put(mapa.name, map.get(mapa.name));
			values.put(mapa.direccion, map.get(mapa.direccion));
			values.put(mapa.lat, map.get(mapa.lat));
			values.put(mapa.lng, map.get(mapa.lng));
			values.put(mapa.tipo, map.get(mapa.tipo));
			values.put(mapa.imagen, map.get(mapa.imagen));
		}
		if(type.equals("pais"))
		{
			//values.put(pais.id_pais, map.get(pais.id_pais));
			values.put(pais.nombre_pais, map.get(pais.nombre_pais));
			values.put(pais.iso_code_2_pais, map.get(pais.iso_code_2_pais));
			values.put(pais.iso_code_3_pais, map.get(pais.iso_code_3_pais));
			values.put(pais.address_format, map.get(pais.address_format));
			values.put(pais.iso_code_number, map.get(pais.iso_code_number));
		}
		if(type.equals("persona"))
		{
			//values.put(persona.id_persona, map.get(persona.id_persona));
			values.put(persona.rut_persona, map.get(persona.rut_persona));
			values.put(persona.digito_verificador, map.get(persona.digito_verificador));
			values.put(persona.nombre_persona, map.get(persona.nombre_persona));
			values.put(persona.segundo_nombre_persona, map.get(persona.segundo_nombre_persona));
			values.put(persona.apellido_persona, map.get(persona.apellido_persona));
			values.put(persona.segundo_apellido_persona, map.get(persona.segundo_apellido_persona));
			values.put(persona.actividad, map.get(persona.actividad));
			values.put(persona.area_actividad, map.get(persona.area_actividad));
			values.put(persona.dia_fecha_nacimiento, map.get(persona.dia_fecha_nacimiento));
			values.put(persona.mes_fecha_nacimiento, map.get(persona.mes_fecha_nacimiento));
			values.put(persona.ano_fecha_nacimiento, map.get(persona.ano_fecha_nacimiento));
			values.put(persona.edad, map.get(persona.edad));
			values.put(persona.email, map.get(persona.email));
			values.put(persona.celular, map.get(persona.celular));
			values.put(persona.telefono, map.get(persona.telefono));
		}
		if(type.equals("precio"))
		{
			//values.put(precio.id_precio, map.get(precio.id_precio));
			values.put(precio.precio_CLP, map.get(precio.precio_CLP));
			values.put(precio.precio_us, map.get(precio.precio_us));
			values.put(precio.precio_mayor_CLP, map.get(precio.precio_mayor_CLP));
			values.put(precio.precio_mayor_us, map.get(precio.precio_mayor_us));
			values.put(precio.precio_actual, map.get(precio.precio_actual));
			values.put(precio.descuento_promocion, map.get(precio.descuento_promocion));
			values.put(precio.cantidad_mayor, map.get(precio.cantidad_mayor));
			values.put(precio.empresa_id_empresa, map.get(precio.empresa_id_empresa));
			values.put(precio.producto_id_producto, map.get(precio.producto_id_producto));
		}
		if(type.equals("producto"))
		{
			//values.put(producto.id_producto, map.get(producto.id_producto));
			values.put(producto.codigo_producto, map.get(producto.codigo_producto));
			values.put(producto.numero_serie, map.get(producto.numero_serie));
			values.put(producto.descripcion_producto, map.get(producto.descripcion_producto));
			values.put(producto.nombre_producto, map.get(producto.nombre_producto));
			values.put(producto.marca_producto, map.get(producto.marca_producto));
			values.put(producto.modelo_producto, map.get(producto.modelo_producto));
			values.put(producto.contenido_unidad, map.get(producto.contenido_unidad));
			values.put(producto.contenido_unidad_medida_id_contenido_unidad_medida, map.get(producto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(producto.unidad_minima, map.get(producto.unidad_minima));
			values.put(producto.contenido, map.get(producto.contenido));
			values.put(producto.peso_neto, map.get(producto.peso_neto));
			values.put(producto.alto_cm, map.get(producto.alto_cm));
			values.put(producto.ancho_cm, map.get(producto.ancho_cm));
			values.put(producto.fondo_cm, map.get(producto.fondo_cm));
			values.put(producto.fabricante, map.get(producto.fabricante));
			values.put(producto.clase_producto, map.get(producto.clase_producto));
			values.put(producto.linea_producto, map.get(producto.linea_producto));
			values.put(producto.hot, map.get(producto.hot));
			values.put(producto.SKU, map.get(producto.SKU));
			values.put(producto.subcategoria_id_subcategoria, map.get(producto.subcategoria_id_subcategoria));
			values.put(producto.tipo_producto_id_tipo_producto, map.get(producto.tipo_producto_id_tipo_producto));
			values.put(producto.formato_producto_id_formato_producto, map.get(producto.formato_producto_id_formato_producto));
			values.put(producto.familia_necesidad_id_familia_necesidad, map.get(producto.familia_necesidad_id_familia_necesidad));
			values.put(producto.familia_producto_id_familia_producto, map.get(producto.familia_producto_id_familia_producto));
		}
		if(type.equals("productocompleto"))
		{
			//values.put(productocompleto.id_producto, map.get(productocompleto.id_producto));
			values.put(productocompleto.codigo_producto, map.get(productocompleto.codigo_producto));
			values.put(productocompleto.numero_serie, map.get(productocompleto.numero_serie));
			values.put(productocompleto.descripcion_producto, map.get(productocompleto.descripcion_producto));
			values.put(productocompleto.nombre_producto, map.get(productocompleto.nombre_producto));
			values.put(productocompleto.marca_producto, map.get(productocompleto.marca_producto));
			values.put(productocompleto.modelo_producto, map.get(productocompleto.modelo_producto));
			values.put(productocompleto.contenido_unidad, map.get(productocompleto.contenido_unidad));
			values.put(productocompleto.unidad_minima, map.get(productocompleto.unidad_minima));
			values.put(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida, map.get(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(productocompleto.contenido, map.get(productocompleto.contenido));
			values.put(productocompleto.peso_neto, map.get(productocompleto.peso_neto));
			values.put(productocompleto.alto_cm, map.get(productocompleto.alto_cm));
			values.put(productocompleto.ancho_cm, map.get(productocompleto.ancho_cm));
			values.put(productocompleto.fondo_cm, map.get(productocompleto.fondo_cm));
			values.put(productocompleto.fabricante, map.get(productocompleto.fabricante));
			values.put(productocompleto.familia_necesidad_id_familia_necesidad, map.get(productocompleto.familia_necesidad_id_familia_necesidad));
			values.put(productocompleto.familia_producto_id_familia_producto, map.get(productocompleto.familia_producto_id_familia_producto));
			values.put(productocompleto.clase_producto, map.get(productocompleto.clase_producto));
			values.put(productocompleto.linea_producto, map.get(productocompleto.linea_producto));
			values.put(productocompleto.tipo_producto_id_tipo_producto, map.get(productocompleto.tipo_producto_id_tipo_producto));
			values.put(productocompleto.hot, map.get(productocompleto.hot));
			values.put(productocompleto.subcategoria_id_subcategoria, map.get(productocompleto.subcategoria_id_subcategoria));
			values.put(productocompleto.SKU, map.get(productocompleto.SKU));
			values.put(productocompleto.formato_producto_id_formato_producto, map.get(productocompleto.formato_producto_id_formato_producto));
			//values.put(productocompleto.id_caracteristica, map.get(productocompleto.id_caracteristica));
			values.put(productocompleto.numero_caracteristica, map.get(productocompleto.numero_caracteristica));
			values.put(productocompleto.caracteristica, map.get(productocompleto.caracteristica));
			values.put(productocompleto.valor_caracteristica, map.get(productocompleto.valor_caracteristica));
			//values.put(productocompleto.id_categoria, map.get(productocompleto.id_categoria));
			values.put(productocompleto.nombre_categoria, map.get(productocompleto.nombre_categoria));
			//values.put(productocompleto.id_empresa, map.get(productocompleto.id_empresa));
			values.put(productocompleto.rut_empresa, map.get(productocompleto.rut_empresa));
			values.put(productocompleto.digito_verificador_empresa, map.get(productocompleto.digito_verificador_empresa));
			values.put(productocompleto.nombre_empresa, map.get(productocompleto.nombre_empresa));
			values.put(productocompleto.nombre_contacto_empresa, map.get(productocompleto.nombre_contacto_empresa));
			values.put(productocompleto.cargo_contacto_empresa, map.get(productocompleto.cargo_contacto_empresa));
			values.put(productocompleto.email_empresa, map.get(productocompleto.email_empresa));
			values.put(productocompleto.alcance_empresa, map.get(productocompleto.alcance_empresa));
			values.put(productocompleto.telefono_empresa, map.get(productocompleto.telefono_empresa));
			values.put(productocompleto.actividad_id_actividad, map.get(productocompleto.actividad_id_actividad));
			//values.put(productocompleto.id_imagenprod, map.get(productocompleto.id_imagenprod));
			values.put(productocompleto.urlimagenprod, map.get(productocompleto.urlimagenprod));
			//values.put(productocompleto.id_precio, map.get(productocompleto.id_precio));
			values.put(productocompleto.precio_CLP, map.get(productocompleto.precio_CLP));
			values.put(productocompleto.precio_us, map.get(productocompleto.precio_us));
			values.put(productocompleto.precio_mayor_CLP, map.get(productocompleto.precio_mayor_CLP));
			values.put(productocompleto.precio_mayor_us, map.get(productocompleto.precio_mayor_us));
			values.put(productocompleto.precio_actual, map.get(productocompleto.precio_actual));
			values.put(productocompleto.descuento_promocion, map.get(productocompleto.descuento_promocion));
			values.put(productocompleto.cantidad_mayor, map.get(productocompleto.cantidad_mayor));
			//values.put(productocompleto.id_reciclado, map.get(productocompleto.id_reciclado));
			values.put(productocompleto.reciclable, map.get(productocompleto.reciclable));
			values.put(productocompleto.reciclado, map.get(productocompleto.reciclado));
			values.put(productocompleto.valor_reciclaje, map.get(productocompleto.valor_reciclaje));
			values.put(productocompleto.empresa_id_empresa, map.get(productocompleto.empresa_id_empresa));
			//values.put(productocompleto.id_stock, map.get(productocompleto.id_stock));
			values.put(productocompleto.stock_real, map.get(productocompleto.stock_real));
			values.put(productocompleto.stock_minimo, map.get(productocompleto.stock_minimo));
			values.put(productocompleto.stock_ideal, map.get(productocompleto.stock_ideal));
			values.put(productocompleto.stock_tienda, map.get(productocompleto.stock_tienda));
			values.put(productocompleto.stock_virtual, map.get(productocompleto.stock_virtual));
			values.put(productocompleto.stock_vendido, map.get(productocompleto.stock_vendido));
			values.put(productocompleto.last_update, map.get(productocompleto.last_update));
			//values.put(productocompleto.id_subcategoria, map.get(productocompleto.id_subcategoria));
			values.put(productocompleto.nombre_subcategoria, map.get(productocompleto.nombre_subcategoria));
			values.put(productocompleto.descripcion_subcategoria, map.get(productocompleto.descripcion_subcategoria));
			values.put(productocompleto.categoria_id_categoria, map.get(productocompleto.categoria_id_categoria));
			//values.put(productocompleto.id_talla, map.get(productocompleto.id_talla));
			values.put(productocompleto.am_largo, map.get(productocompleto.am_largo));
			values.put(productocompleto.am_ancho, map.get(productocompleto.am_ancho));
			values.put(productocompleto.am_fondo, map.get(productocompleto.am_fondo));
			values.put(productocompleto.eu_largo, map.get(productocompleto.eu_largo));
			values.put(productocompleto.eu_ancho, map.get(productocompleto.eu_ancho));
			values.put(productocompleto.eu_fondo, map.get(productocompleto.eu_fondo));
			values.put(productocompleto.num_largo, map.get(productocompleto.num_largo));
			values.put(productocompleto.num_ancho, map.get(productocompleto.num_ancho));
			values.put(productocompleto.num_fondo, map.get(productocompleto.num_fondo));
			//values.put(productocompleto.id_valor_nutricional, map.get(productocompleto.id_valor_nutricional));
			values.put(productocompleto.nombre_valor, map.get(productocompleto.nombre_valor));
			values.put(productocompleto.cantidad, map.get(productocompleto.cantidad));
			values.put(productocompleto.valor_diario_total, map.get(productocompleto.valor_diario_total));
			values.put(productocompleto.porcentaje_requerimientos, map.get(productocompleto.porcentaje_requerimientos));
		}
		if(type.equals("productocompra"))
		{
			//values.put(productocompra.id_producto, map.get(productocompra.id_producto));
			values.put(productocompra.codigo_producto, map.get(productocompra.codigo_producto));
			values.put(productocompra.numero_serie, map.get(productocompra.numero_serie));
			values.put(productocompra.descripcion_producto, map.get(productocompra.descripcion_producto));
			values.put(productocompra.nombre_producto, map.get(productocompra.nombre_producto));
			values.put(productocompra.marca_producto, map.get(productocompra.marca_producto));
			values.put(productocompra.modelo_producto, map.get(productocompra.modelo_producto));
			values.put(productocompra.contenido_unidad, map.get(productocompra.contenido_unidad));
			values.put(productocompra.unidad_minima, map.get(productocompra.unidad_minima));
			values.put(productocompra.contenido_unidad_medida_id_contenido_unidad_medida, map.get(productocompra.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(productocompra.contenido, map.get(productocompra.contenido));
			values.put(productocompra.peso_neto, map.get(productocompra.peso_neto));
			values.put(productocompra.alto_cm, map.get(productocompra.alto_cm));
			values.put(productocompra.ancho_cm, map.get(productocompra.ancho_cm));
			values.put(productocompra.fondo_cm, map.get(productocompra.fondo_cm));
			values.put(productocompra.fabricante, map.get(productocompra.fabricante));
			values.put(productocompra.familia_necesidad_id_familia_necesidad, map.get(productocompra.familia_necesidad_id_familia_necesidad));
			values.put(productocompra.familia_producto_id_familia_producto, map.get(productocompra.familia_producto_id_familia_producto));
			values.put(productocompra.clase_producto, map.get(productocompra.clase_producto));
			values.put(productocompra.linea_producto, map.get(productocompra.linea_producto));
			values.put(productocompra.tipo_producto_id_tipo_producto, map.get(productocompra.tipo_producto_id_tipo_producto));
			values.put(productocompra.hot, map.get(productocompra.hot));
			values.put(productocompra.subcategoria_id_subcategoria, map.get(productocompra.subcategoria_id_subcategoria));
			values.put(productocompra.SKU, map.get(productocompra.SKU));
			values.put(productocompra.formato_producto_id_formato_producto, map.get(productocompra.formato_producto_id_formato_producto));
			//values.put(productocompra.id_caracteristica, map.get(productocompra.id_caracteristica));
			values.put(productocompra.numero_caracteristica, map.get(productocompra.numero_caracteristica));
			values.put(productocompra.caracteristica, map.get(productocompra.caracteristica));
			values.put(productocompra.valor_caracteristica, map.get(productocompra.valor_caracteristica));
			//values.put(productocompra.id_categoria, map.get(productocompra.id_categoria));
			values.put(productocompra.nombre_categoria, map.get(productocompra.nombre_categoria));
			//values.put(productocompra.id_reciclado, map.get(productocompra.id_reciclado));
			values.put(productocompra.reciclable, map.get(productocompra.reciclable));
			values.put(productocompra.reciclado, map.get(productocompra.reciclado));
			values.put(productocompra.valor_reciclaje, map.get(productocompra.valor_reciclaje));
			values.put(productocompra.empresa_id_empresa, map.get(productocompra.empresa_id_empresa));
			//values.put(productocompra.id_stock, map.get(productocompra.id_stock));
			values.put(productocompra.stock_real, map.get(productocompra.stock_real));
			values.put(productocompra.stock_minimo, map.get(productocompra.stock_minimo));
			values.put(productocompra.stock_ideal, map.get(productocompra.stock_ideal));
			values.put(productocompra.stock_tienda, map.get(productocompra.stock_tienda));
			values.put(productocompra.stock_virtual, map.get(productocompra.stock_virtual));
			values.put(productocompra.stock_vendido, map.get(productocompra.stock_vendido));
			values.put(productocompra.last_update, map.get(productocompra.last_update));
			//values.put(productocompra.id_subcategoria, map.get(productocompra.id_subcategoria));
			values.put(productocompra.nombre_subcategoria, map.get(productocompra.nombre_subcategoria));
			values.put(productocompra.descripcion_subcategoria, map.get(productocompra.descripcion_subcategoria));
			values.put(productocompra.categoria_id_categoria, map.get(productocompra.categoria_id_categoria));
			//values.put(productocompra.id_talla, map.get(productocompra.id_talla));
			values.put(productocompra.am_largo, map.get(productocompra.am_largo));
			values.put(productocompra.am_ancho, map.get(productocompra.am_ancho));
			values.put(productocompra.am_fondo, map.get(productocompra.am_fondo));
			values.put(productocompra.eu_largo, map.get(productocompra.eu_largo));
			values.put(productocompra.eu_ancho, map.get(productocompra.eu_ancho));
			values.put(productocompra.eu_fondo, map.get(productocompra.eu_fondo));
			values.put(productocompra.num_largo, map.get(productocompra.num_largo));
			values.put(productocompra.num_ancho, map.get(productocompra.num_ancho));
			values.put(productocompra.num_fondo, map.get(productocompra.num_fondo));
			//values.put(productocompra.id_valor_nutricional, map.get(productocompra.id_valor_nutricional));
			values.put(productocompra.nombre_valor, map.get(productocompra.nombre_valor));
			values.put(productocompra.cantidad, map.get(productocompra.cantidad));
			values.put(productocompra.valor_diario_total, map.get(productocompra.valor_diario_total));
			values.put(productocompra.porcentaje_requerimientos, map.get(productocompra.porcentaje_requerimientos));
		}
		if(type.equals("productoprecio"))
		{
			//values.put(productoprecio.id_producto, map.get(productoprecio.id_producto));
			values.put(productoprecio.codigo_producto, map.get(productoprecio.codigo_producto));
			values.put(productoprecio.numero_serie, map.get(productoprecio.numero_serie));
			values.put(productoprecio.descripcion_producto, map.get(productoprecio.descripcion_producto));
			values.put(productoprecio.nombre_producto, map.get(productoprecio.nombre_producto));
			values.put(productoprecio.marca_producto, map.get(productoprecio.marca_producto));
			values.put(productoprecio.modelo_producto, map.get(productoprecio.modelo_producto));
			values.put(productoprecio.contenido_unidad, map.get(productoprecio.contenido_unidad));
			values.put(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida, map.get(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(productoprecio.unidad_minima, map.get(productoprecio.unidad_minima));
			values.put(productoprecio.contenido, map.get(productoprecio.contenido));
			values.put(productoprecio.peso_neto, map.get(productoprecio.peso_neto));
			values.put(productoprecio.alto_cm, map.get(productoprecio.alto_cm));
			values.put(productoprecio.ancho_cm, map.get(productoprecio.ancho_cm));
			values.put(productoprecio.fondo_cm, map.get(productoprecio.fondo_cm));
			values.put(productoprecio.fabricante, map.get(productoprecio.fabricante));
			values.put(productoprecio.clase_producto, map.get(productoprecio.clase_producto));
			values.put(productoprecio.linea_producto, map.get(productoprecio.linea_producto));
			values.put(productoprecio.hot, map.get(productoprecio.hot));
			values.put(productoprecio.SKU, map.get(productoprecio.SKU));
			values.put(productoprecio.subcategoria_id_subcategoria, map.get(productoprecio.subcategoria_id_subcategoria));
			values.put(productoprecio.tipo_producto_id_tipo_producto, map.get(productoprecio.tipo_producto_id_tipo_producto));
			values.put(productoprecio.formato_producto_id_formato_producto, map.get(productoprecio.formato_producto_id_formato_producto));
			values.put(productoprecio.familia_necesidad_id_familia_necesidad, map.get(productoprecio.familia_necesidad_id_familia_necesidad));
			values.put(productoprecio.familia_producto_id_familia_producto, map.get(productoprecio.familia_producto_id_familia_producto));
			//values.put(productoprecio.id_precio, map.get(productoprecio.id_precio));
			values.put(productoprecio.precio_CLP, map.get(productoprecio.precio_CLP));
			values.put(productoprecio.precio_us, map.get(productoprecio.precio_us));
			values.put(productoprecio.precio_mayor_CLP, map.get(productoprecio.precio_mayor_CLP));
			values.put(productoprecio.precio_mayor_us, map.get(productoprecio.precio_mayor_us));
			values.put(productoprecio.precio_actual, map.get(productoprecio.precio_actual));
			values.put(productoprecio.descuento_promocion, map.get(productoprecio.descuento_promocion));
			values.put(productoprecio.cantidad_mayor, map.get(productoprecio.cantidad_mayor));
			//values.put(productoprecio.id_stock, map.get(productoprecio.id_stock));
			values.put(productoprecio.stock_real, map.get(productoprecio.stock_real));
			values.put(productoprecio.stock_minimo, map.get(productoprecio.stock_minimo));
			values.put(productoprecio.stock_ideal, map.get(productoprecio.stock_ideal));
			values.put(productoprecio.stock_tienda, map.get(productoprecio.stock_tienda));
			values.put(productoprecio.stock_virtual, map.get(productoprecio.stock_virtual));
			values.put(productoprecio.stock_vendido, map.get(productoprecio.stock_vendido));
			values.put(productoprecio.last_update, map.get(productoprecio.last_update));
			values.put(productoprecio.empresa_id_empresa, map.get(productoprecio.empresa_id_empresa));
		}
		if(type.equals("provincia"))
		{
			//values.put(provincia.id_provincia, map.get(provincia.id_provincia));
			values.put(provincia.nombre_provincia, map.get(provincia.nombre_provincia));
			values.put(provincia.codigo_provincia, map.get(provincia.codigo_provincia));
			values.put(provincia.region_id_region, map.get(provincia.region_id_region));
		}
		if(type.equals("reciclado"))
		{
			//values.put(reciclado.id_reciclado, map.get(reciclado.id_reciclado));
			values.put(reciclado.reciclable, map.get(reciclado.reciclable));
			values.put(reciclado.reciclado, map.get(reciclado.reciclado));
			values.put(reciclado.valor_reciclaje, map.get(reciclado.valor_reciclaje));
			values.put(reciclado.empresa_id_empresa, map.get(reciclado.empresa_id_empresa));
			values.put(reciclado.producto_id_producto, map.get(reciclado.producto_id_producto));
		}
		if(type.equals("region"))
		{
			//values.put(region.id_region, map.get(region.id_region));
			values.put(region.nombre_region, map.get(region.nombre_region));
			values.put(region.codigo_region, map.get(region.codigo_region));
			values.put(region.pais_id_pais, map.get(region.pais_id_pais));
		}
		if(type.equals("rubro"))
		{
			//values.put(rubro.id_rubro, map.get(rubro.id_rubro));
			values.put(rubro.nombre_rubro, map.get(rubro.nombre_rubro));
		}
		if(type.equals("sincrodate"))
		{
			//values.put(sincrodate.id_sincrodate, map.get(sincrodate.id_sincrodate));
			values.put(sincrodate.date, map.get(sincrodate.date));
		}
		if(type.equals("stock"))
		{
			//values.put(stock.id_stock, map.get(stock.id_stock));
			values.put(stock.stock_real, map.get(stock.stock_real));
			values.put(stock.stock_minimo, map.get(stock.stock_minimo));
			values.put(stock.stock_ideal, map.get(stock.stock_ideal));
			values.put(stock.stock_tienda, map.get(stock.stock_tienda));
			values.put(stock.stock_virtual, map.get(stock.stock_virtual));
			values.put(stock.stock_vendido, map.get(stock.stock_vendido));
			values.put(stock.last_update, map.get(stock.last_update));
			values.put(stock.producto_id_producto, map.get(stock.producto_id_producto));
			values.put(stock.empresa_id_empresa, map.get(stock.empresa_id_empresa));
		}
		if(type.equals("stockcompleto"))
		{
			//values.put(stockcompleto.id_producto, map.get(stockcompleto.id_producto));
			values.put(stockcompleto.codigo_producto, map.get(stockcompleto.codigo_producto));
			values.put(stockcompleto.numero_serie, map.get(stockcompleto.numero_serie));
			values.put(stockcompleto.descripcion_producto, map.get(stockcompleto.descripcion_producto));
			values.put(stockcompleto.nombre_producto, map.get(stockcompleto.nombre_producto));
			values.put(stockcompleto.marca_producto, map.get(stockcompleto.marca_producto));
			values.put(stockcompleto.modelo_producto, map.get(stockcompleto.modelo_producto));
			values.put(stockcompleto.contenido_unidad, map.get(stockcompleto.contenido_unidad));
			values.put(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida, map.get(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(stockcompleto.unidad_minima, map.get(stockcompleto.unidad_minima));
			values.put(stockcompleto.contenido, map.get(stockcompleto.contenido));
			values.put(stockcompleto.peso_neto, map.get(stockcompleto.peso_neto));
			values.put(stockcompleto.alto_cm, map.get(stockcompleto.alto_cm));
			values.put(stockcompleto.ancho_cm, map.get(stockcompleto.ancho_cm));
			values.put(stockcompleto.fondo_cm, map.get(stockcompleto.fondo_cm));
			values.put(stockcompleto.fabricante, map.get(stockcompleto.fabricante));
			values.put(stockcompleto.clase_producto, map.get(stockcompleto.clase_producto));
			values.put(stockcompleto.linea_producto, map.get(stockcompleto.linea_producto));
			values.put(stockcompleto.hot, map.get(stockcompleto.hot));
			values.put(stockcompleto.SKU, map.get(stockcompleto.SKU));
			values.put(stockcompleto.subcategoria_id_subcategoria, map.get(stockcompleto.subcategoria_id_subcategoria));
			values.put(stockcompleto.tipo_producto_id_tipo_producto, map.get(stockcompleto.tipo_producto_id_tipo_producto));
			values.put(stockcompleto.formato_producto_id_formato_producto, map.get(stockcompleto.formato_producto_id_formato_producto));
			values.put(stockcompleto.familia_necesidad_id_familia_necesidad, map.get(stockcompleto.familia_necesidad_id_familia_necesidad));
			values.put(stockcompleto.familia_producto_id_familia_producto, map.get(stockcompleto.familia_producto_id_familia_producto));
			//values.put(stockcompleto.id_stock, map.get(stockcompleto.id_stock));
			values.put(stockcompleto.stock_real, map.get(stockcompleto.stock_real));
			values.put(stockcompleto.stock_minimo, map.get(stockcompleto.stock_minimo));
			values.put(stockcompleto.stock_ideal, map.get(stockcompleto.stock_ideal));
			values.put(stockcompleto.stock_tienda, map.get(stockcompleto.stock_tienda));
			values.put(stockcompleto.stock_virtual, map.get(stockcompleto.stock_virtual));
			values.put(stockcompleto.stock_vendido, map.get(stockcompleto.stock_vendido));
			values.put(stockcompleto.last_update, map.get(stockcompleto.last_update));
			values.put(stockcompleto.producto_id_producto, map.get(stockcompleto.producto_id_producto));
			values.put(stockcompleto.empresa_id_empresa, map.get(stockcompleto.empresa_id_empresa));
		}
		if(type.equals("subcategoria"))
		{
			//values.put(subcategoria.id_subcategoria, map.get(subcategoria.id_subcategoria));
			values.put(subcategoria.nombre_subcategoria, map.get(subcategoria.nombre_subcategoria));
			values.put(subcategoria.descripcion_subcategoria, map.get(subcategoria.descripcion_subcategoria));
			values.put(subcategoria.categoria_id_categoria, map.get(subcategoria.categoria_id_categoria));
		}
		if(type.equals("subrubro"))
		{
			//values.put(subrubro.id_subrubro, map.get(subrubro.id_subrubro));
			values.put(subrubro.nombre_subrubro, map.get(subrubro.nombre_subrubro));
			values.put(subrubro.rubro_id_rubro, map.get(subrubro.rubro_id_rubro));
		}
		if(type.equals("talla"))
		{
			//values.put(talla.id_talla, map.get(talla.id_talla));
			values.put(talla.am_largo, map.get(talla.am_largo));
			values.put(talla.am_ancho, map.get(talla.am_ancho));
			values.put(talla.am_fondo, map.get(talla.am_fondo));
			values.put(talla.eu_largo, map.get(talla.eu_largo));
			values.put(talla.eu_ancho, map.get(talla.eu_ancho));
			values.put(talla.eu_fondo, map.get(talla.eu_fondo));
			values.put(talla.num_largo, map.get(talla.num_largo));
			values.put(talla.num_ancho, map.get(talla.num_ancho));
			values.put(talla.num_fondo, map.get(talla.num_fondo));
			values.put(talla.producto_id_producto, map.get(talla.producto_id_producto));
		}
		if(type.equals("tipo_documento"))
		{
			//values.put(tipo_documento.id_tipo_documento, map.get(tipo_documento.id_tipo_documento));
			values.put(tipo_documento.nombre_tipo_documento, map.get(tipo_documento.nombre_tipo_documento));
		}
		if(type.equals("tipo_empresa"))
		{
			//values.put(tipo_empresa.id_tipo_empresa, map.get(tipo_empresa.id_tipo_empresa));
			values.put(tipo_empresa.nombre_tipo_empresa, map.get(tipo_empresa.nombre_tipo_empresa));
			values.put(tipo_empresa.categoria_empresa_id_categoria_empresa, map.get(tipo_empresa.categoria_empresa_id_categoria_empresa));
		}
		if(type.equals("tipo_pago"))
		{
			//values.put(tipo_pago.id_tipo_pago, map.get(tipo_pago.id_tipo_pago));
			values.put(tipo_pago.nombre_tipo_pago, map.get(tipo_pago.nombre_tipo_pago));
			values.put(tipo_pago.comision_tipo_pago, map.get(tipo_pago.comision_tipo_pago));
		}
		if(type.equals("tipo_producto"))
		{
			//values.put(tipo_producto.id_tipo_producto, map.get(tipo_producto.id_tipo_producto));
			values.put(tipo_producto.nombre_tipo_producto, map.get(tipo_producto.nombre_tipo_producto));
		}
		if(type.equals("tipo_usuario"))
		{
			//values.put(tipo_usuario.id_tipo_usuario, map.get(tipo_usuario.id_tipo_usuario));
			values.put(tipo_usuario.nombre_tipo_usuario, map.get(tipo_usuario.nombre_tipo_usuario));
		}
		if(type.equals("ubicacion"))
		{
			//values.put(ubicacion.id_ubicacion, map.get(ubicacion.id_ubicacion));
			values.put(ubicacion.numero_ubicacion, map.get(ubicacion.numero_ubicacion));
			values.put(ubicacion.numero_interior, map.get(ubicacion.numero_interior));
			values.put(ubicacion.telefono_ubicacion, map.get(ubicacion.telefono_ubicacion));
			values.put(ubicacion.default_ubicacion, map.get(ubicacion.default_ubicacion));
			values.put(ubicacion.calle_id_calle, map.get(ubicacion.calle_id_calle));
			values.put(ubicacion.empresa_id_empresa, map.get(ubicacion.empresa_id_empresa));
			values.put(ubicacion.usuario_id_usuario, map.get(ubicacion.usuario_id_usuario));
		}
		if(type.equals("usuario"))
		{
			//values.put(usuario.id_usuario, map.get(usuario.id_usuario));
			values.put(usuario.tipo_usuario, map.get(usuario.tipo_usuario));
			values.put(usuario.nombre_usuario, map.get(usuario.nombre_usuario));
			values.put(usuario.clave, map.get(usuario.clave));
			values.put(usuario.cliente_id_cliente, map.get(usuario.cliente_id_cliente));
			values.put(usuario.cliente_empresa_id_cliente_empresa, map.get(usuario.cliente_empresa_id_cliente_empresa));
		}
		if(type.equals("usuariocompleto"))
		{
			//values.put(usuariocompleto.id_persona, map.get(usuariocompleto.id_persona));
			values.put(usuariocompleto.rut_persona, map.get(usuariocompleto.rut_persona));
			values.put(usuariocompleto.digito_verificador, map.get(usuariocompleto.digito_verificador));
			values.put(usuariocompleto.nombre_persona, map.get(usuariocompleto.nombre_persona));
			values.put(usuariocompleto.segundo_nombre_persona, map.get(usuariocompleto.segundo_nombre_persona));
			values.put(usuariocompleto.apellido_persona, map.get(usuariocompleto.apellido_persona));
			values.put(usuariocompleto.segundo_apellido_persona, map.get(usuariocompleto.segundo_apellido_persona));
			values.put(usuariocompleto.actividad, map.get(usuariocompleto.actividad));
			values.put(usuariocompleto.area_actividad, map.get(usuariocompleto.area_actividad));
			values.put(usuariocompleto.dia_fecha_nacimiento, map.get(usuariocompleto.dia_fecha_nacimiento));
			values.put(usuariocompleto.mes_fecha_nacimiento, map.get(usuariocompleto.mes_fecha_nacimiento));
			values.put(usuariocompleto.ano_fecha_nacimiento, map.get(usuariocompleto.ano_fecha_nacimiento));
			values.put(usuariocompleto.edad, map.get(usuariocompleto.edad));
			values.put(usuariocompleto.email, map.get(usuariocompleto.email));
			values.put(usuariocompleto.celular, map.get(usuariocompleto.celular));
			values.put(usuariocompleto.telefono, map.get(usuariocompleto.telefono));
			//values.put(usuariocompleto.id_carne_empresa, map.get(usuariocompleto.id_carne_empresa));
			values.put(usuariocompleto.nombre_usuario, map.get(usuariocompleto.nombre_usuario));
			values.put(usuariocompleto.clave_usuario, map.get(usuariocompleto.clave_usuario));
			values.put(usuariocompleto.empresa_id_empresa, map.get(usuariocompleto.empresa_id_empresa));
			values.put(usuariocompleto.persona_id_persona, map.get(usuariocompleto.persona_id_persona));
			values.put(usuariocompleto.tipo_usuario_id_tipo_usuario, map.get(usuariocompleto.tipo_usuario_id_tipo_usuario));
		}
		if(type.equals("valor_nutricional"))
		{
			//values.put(valor_nutricional.id_valor_nutricional, map.get(valor_nutricional.id_valor_nutricional));
			values.put(valor_nutricional.nombre_valor, map.get(valor_nutricional.nombre_valor));
			values.put(valor_nutricional.cantidad, map.get(valor_nutricional.cantidad));
			values.put(valor_nutricional.valor_diario_total, map.get(valor_nutricional.valor_diario_total));
			values.put(valor_nutricional.porcentaje_requerimientos, map.get(valor_nutricional.porcentaje_requerimientos));
			values.put(valor_nutricional.producto_id_producto, map.get(valor_nutricional.producto_id_producto));
		}
		if(type.equals("venta"))
		{
			//values.put(venta.id_venta, map.get(venta.id_venta));
			values.put(venta.numero_articulos, map.get(venta.numero_articulos));
			values.put(venta.total, map.get(venta.total));
			values.put(venta.dia_fecha_venta, map.get(venta.dia_fecha_venta));
			values.put(venta.mes_fecha_venta, map.get(venta.mes_fecha_venta));
			values.put(venta.anno_fecha_venta, map.get(venta.anno_fecha_venta));
			values.put(venta.hora_fecha_venta, map.get(venta.hora_fecha_venta));
			values.put(venta.usuario_id_usuario, map.get(venta.usuario_id_usuario));
			values.put(venta.carne_empresa_id_carne_empresa, map.get(venta.carne_empresa_id_carne_empresa));
			values.put(venta.tipo_pago_id_tipo_pago, map.get(venta.tipo_pago_id_tipo_pago));
			values.put(venta.tipo_documento_id_tipo_documento, map.get(venta.tipo_documento_id_tipo_documento));
		}
		if(type.equals("ventacompleta"))
		{
			//values.put(ventacompleta.id_venta, map.get(ventacompleta.id_venta));
			values.put(ventacompleta.numero_articulos, map.get(ventacompleta.numero_articulos));
			values.put(ventacompleta.total, map.get(ventacompleta.total));
			values.put(ventacompleta.dia_fecha_venta, map.get(ventacompleta.dia_fecha_venta));
			values.put(ventacompleta.mes_fecha_venta, map.get(ventacompleta.mes_fecha_venta));
			values.put(ventacompleta.anno_fecha_venta, map.get(ventacompleta.anno_fecha_venta));
			values.put(ventacompleta.hora_fecha_venta, map.get(ventacompleta.hora_fecha_venta));
			values.put(ventacompleta.usuario_id_usuario, map.get(ventacompleta.usuario_id_usuario));
			values.put(ventacompleta.carne_empresa_id_carne_empresa, map.get(ventacompleta.carne_empresa_id_carne_empresa));
			values.put(ventacompleta.tipo_pago_id_tipo_pago, map.get(ventacompleta.tipo_pago_id_tipo_pago));
			values.put(ventacompleta.tipo_documento_id_tipo_documento, map.get(ventacompleta.tipo_documento_id_tipo_documento));
			//values.put(ventacompleta.id_tipo_pago, map.get(ventacompleta.id_tipo_pago));
			values.put(ventacompleta.nombre_tipo_pago, map.get(ventacompleta.nombre_tipo_pago));
			values.put(ventacompleta.comision_tipo_pago, map.get(ventacompleta.comision_tipo_pago));
			//values.put(ventacompleta.id_tipo_documento, map.get(ventacompleta.id_tipo_documento));
			values.put(ventacompleta.nombre_tipo_documento, map.get(ventacompleta.nombre_tipo_documento));
		}
		return values;	
	}
}
