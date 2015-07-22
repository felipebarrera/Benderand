
package cl.webinc.benderand.sync;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cl.webinc.benderand.provider.Base.*;
import android.content.ContentValues;

public class WebListContentValues 
{
	public ContentValues cvActividad(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("actividad");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(actividad.id_actividad, e.getString(actividad.id_actividad));
			values.put(actividad.nombre_actividad, e.getString(actividad.nombre_actividad));
			values.put(actividad.codigo_actividad, e.getString(actividad.codigo_actividad));
			values.put(actividad.categoria_actividad, e.getString(actividad.categoria_actividad));
			values.put(actividad.afectoiva_actividad, e.getString(actividad.afectoiva_actividad));
			values.put(actividad.disponible_internet_actividad, e.getString(actividad.disponible_internet_actividad));
			values.put(actividad.subrubro_id_subrubro, e.getString(actividad.subrubro_id_subrubro));
		}
		return values;
	}
	public ContentValues cvCalle(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("calle");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(calle.id_calle, e.getString(calle.id_calle));
			values.put(calle.nombre_calle, e.getString(calle.nombre_calle));
			values.put(calle.comuna_id_comuna, e.getString(calle.comuna_id_comuna));
		}
		return values;
	}
	public ContentValues cvCaracteristica(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("caracteristica");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(caracteristica.id_caracteristica, e.getString(caracteristica.id_caracteristica));
			values.put(caracteristica.numero_caracteristica, e.getString(caracteristica.numero_caracteristica));
			values.put(caracteristica.caracteristica, e.getString(caracteristica.caracteristica));
			values.put(caracteristica.valor_caracteristica, e.getString(caracteristica.valor_caracteristica));
			values.put(caracteristica.producto_id_producto, e.getString(caracteristica.producto_id_producto));
		}
		return values;
	}
	public ContentValues cvCarne_empresa(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carne_empresa");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carne_empresa.id_carne_empresa, e.getString(carne_empresa.id_carne_empresa));
			values.put(carne_empresa.nombre_usuario, e.getString(carne_empresa.nombre_usuario));
			values.put(carne_empresa.clave_usuario, e.getString(carne_empresa.clave_usuario));
			values.put(carne_empresa.empresa_id_empresa, e.getString(carne_empresa.empresa_id_empresa));
			values.put(carne_empresa.persona_id_persona, e.getString(carne_empresa.persona_id_persona));
			values.put(carne_empresa.tipo_usuario_id_tipo_usuario, e.getString(carne_empresa.tipo_usuario_id_tipo_usuario));
		}
		return values;
	}
	public ContentValues cvCarne_empresacompleto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carne_empresacompleto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carne_empresacompleto.id_carne_empresa, e.getString(carne_empresacompleto.id_carne_empresa));
			values.put(carne_empresacompleto.nombre_usuario, e.getString(carne_empresacompleto.nombre_usuario));
			values.put(carne_empresacompleto.clave_usuario, e.getString(carne_empresacompleto.clave_usuario));
			values.put(carne_empresacompleto.tipo_usuario_id_tipo_usuario, e.getString(carne_empresacompleto.tipo_usuario_id_tipo_usuario));
			values.put(carne_empresacompleto.id_empresa, e.getString(carne_empresacompleto.id_empresa));
			values.put(carne_empresacompleto.rut_empresa, e.getString(carne_empresacompleto.rut_empresa));
			values.put(carne_empresacompleto.digito_verificador_empresa, e.getString(carne_empresacompleto.digito_verificador_empresa));
			values.put(carne_empresacompleto.nombre_empresa, e.getString(carne_empresacompleto.nombre_empresa));
			values.put(carne_empresacompleto.nombre_contacto_empresa, e.getString(carne_empresacompleto.nombre_contacto_empresa));
			values.put(carne_empresacompleto.cargo_contacto_empresa, e.getString(carne_empresacompleto.cargo_contacto_empresa));
			values.put(carne_empresacompleto.email_empresa, e.getString(carne_empresacompleto.email_empresa));
			values.put(carne_empresacompleto.alcance_empresa, e.getString(carne_empresacompleto.alcance_empresa));
			values.put(carne_empresacompleto.telefono_empresa, e.getString(carne_empresacompleto.telefono_empresa));
			values.put(carne_empresacompleto.actividad_id_actividad, e.getString(carne_empresacompleto.actividad_id_actividad));
			values.put(carne_empresacompleto.id_persona, e.getString(carne_empresacompleto.id_persona));
			values.put(carne_empresacompleto.rut_persona, e.getString(carne_empresacompleto.rut_persona));
			values.put(carne_empresacompleto.digito_verificador, e.getString(carne_empresacompleto.digito_verificador));
			values.put(carne_empresacompleto.nombre_persona, e.getString(carne_empresacompleto.nombre_persona));
			values.put(carne_empresacompleto.segundo_nombre_persona, e.getString(carne_empresacompleto.segundo_nombre_persona));
			values.put(carne_empresacompleto.apellido_persona, e.getString(carne_empresacompleto.apellido_persona));
			values.put(carne_empresacompleto.segundo_apellido_persona, e.getString(carne_empresacompleto.segundo_apellido_persona));
			values.put(carne_empresacompleto.actividad, e.getString(carne_empresacompleto.actividad));
			values.put(carne_empresacompleto.area_actividad, e.getString(carne_empresacompleto.area_actividad));
			values.put(carne_empresacompleto.dia_fecha_nacimiento, e.getString(carne_empresacompleto.dia_fecha_nacimiento));
			values.put(carne_empresacompleto.mes_fecha_nacimiento, e.getString(carne_empresacompleto.mes_fecha_nacimiento));
			values.put(carne_empresacompleto.ano_fecha_nacimiento, e.getString(carne_empresacompleto.ano_fecha_nacimiento));
			values.put(carne_empresacompleto.edad, e.getString(carne_empresacompleto.edad));
			values.put(carne_empresacompleto.email, e.getString(carne_empresacompleto.email));
			values.put(carne_empresacompleto.celular, e.getString(carne_empresacompleto.celular));
			values.put(carne_empresacompleto.telefono, e.getString(carne_empresacompleto.telefono));
		}
		return values;
	}
	public ContentValues cvCarro_compras(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carro_compras");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carro_compras.id_carro_compras, e.getString(carro_compras.id_carro_compras));
			values.put(carro_compras.cantidad_carro, e.getString(carro_compras.cantidad_carro));
			values.put(carro_compras.precio_carro, e.getString(carro_compras.precio_carro));
			values.put(carro_compras.mayor, e.getString(carro_compras.mayor));
			values.put(carro_compras.tienda, e.getString(carro_compras.tienda));
			values.put(carro_compras.usuario_id_usuario, e.getString(carro_compras.usuario_id_usuario));
			values.put(carro_compras.producto_id_producto, e.getString(carro_compras.producto_id_producto));
			values.put(carro_compras.empresa_id_empresa, e.getString(carro_compras.empresa_id_empresa));
			values.put(carro_compras.usado, e.getString(carro_compras.usado));
			values.put(carro_compras.carne_empresa_id_carne_empresa, e.getString(carro_compras.carne_empresa_id_carne_empresa));
		}
		return values;
	}
	public ContentValues cvCarro_comprascompleto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carro_comprascompleto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carro_comprascompleto.id_carro_compras, e.getString(carro_comprascompleto.id_carro_compras));
			values.put(carro_comprascompleto.cantidad_carro, e.getString(carro_comprascompleto.cantidad_carro));
			values.put(carro_comprascompleto.precio_carro, e.getString(carro_comprascompleto.precio_carro));
			values.put(carro_comprascompleto.mayor, e.getString(carro_comprascompleto.mayor));
			values.put(carro_comprascompleto.tienda, e.getString(carro_comprascompleto.tienda));
			values.put(carro_comprascompleto.usuario_id_usuario, e.getString(carro_comprascompleto.usuario_id_usuario));
			values.put(carro_comprascompleto.usado, e.getString(carro_comprascompleto.usado));
			values.put(carro_comprascompleto.carne_empresa_id_carne_empresa, e.getString(carro_comprascompleto.carne_empresa_id_carne_empresa));
			values.put(carro_comprascompleto.id_precio, e.getString(carro_comprascompleto.id_precio));
			values.put(carro_comprascompleto.precio_CLP, e.getString(carro_comprascompleto.precio_CLP));
			values.put(carro_comprascompleto.precio_us, e.getString(carro_comprascompleto.precio_us));
			values.put(carro_comprascompleto.precio_mayor_CLP, e.getString(carro_comprascompleto.precio_mayor_CLP));
			values.put(carro_comprascompleto.precio_mayor_us, e.getString(carro_comprascompleto.precio_mayor_us));
			values.put(carro_comprascompleto.precio_actual, e.getString(carro_comprascompleto.precio_actual));
			values.put(carro_comprascompleto.descuento_promocion, e.getString(carro_comprascompleto.descuento_promocion));
			values.put(carro_comprascompleto.cantidad_mayor, e.getString(carro_comprascompleto.cantidad_mayor));
			values.put(carro_comprascompleto.id_producto, e.getString(carro_comprascompleto.id_producto));
			values.put(carro_comprascompleto.codigo_producto, e.getString(carro_comprascompleto.codigo_producto));
			values.put(carro_comprascompleto.numero_serie, e.getString(carro_comprascompleto.numero_serie));
			values.put(carro_comprascompleto.descripcion_producto, e.getString(carro_comprascompleto.descripcion_producto));
			values.put(carro_comprascompleto.nombre_producto, e.getString(carro_comprascompleto.nombre_producto));
			values.put(carro_comprascompleto.marca_producto, e.getString(carro_comprascompleto.marca_producto));
			values.put(carro_comprascompleto.modelo_producto, e.getString(carro_comprascompleto.modelo_producto));
			values.put(carro_comprascompleto.contenido_unidad, e.getString(carro_comprascompleto.contenido_unidad));
			values.put(carro_comprascompleto.unidad_minima, e.getString(carro_comprascompleto.unidad_minima));
			values.put(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(carro_comprascompleto.contenido, e.getString(carro_comprascompleto.contenido));
			values.put(carro_comprascompleto.peso_neto, e.getString(carro_comprascompleto.peso_neto));
			values.put(carro_comprascompleto.alto_cm, e.getString(carro_comprascompleto.alto_cm));
			values.put(carro_comprascompleto.ancho_cm, e.getString(carro_comprascompleto.ancho_cm));
			values.put(carro_comprascompleto.fondo_cm, e.getString(carro_comprascompleto.fondo_cm));
			values.put(carro_comprascompleto.fabricante, e.getString(carro_comprascompleto.fabricante));
			values.put(carro_comprascompleto.familia_necesidad_id_familia_necesidad, e.getString(carro_comprascompleto.familia_necesidad_id_familia_necesidad));
			values.put(carro_comprascompleto.familia_producto_id_familia_producto, e.getString(carro_comprascompleto.familia_producto_id_familia_producto));
			values.put(carro_comprascompleto.clase_producto, e.getString(carro_comprascompleto.clase_producto));
			values.put(carro_comprascompleto.linea_producto, e.getString(carro_comprascompleto.linea_producto));
			values.put(carro_comprascompleto.tipo_producto_id_tipo_producto, e.getString(carro_comprascompleto.tipo_producto_id_tipo_producto));
			values.put(carro_comprascompleto.hot, e.getString(carro_comprascompleto.hot));
			values.put(carro_comprascompleto.subcategoria_id_subcategoria, e.getString(carro_comprascompleto.subcategoria_id_subcategoria));
			values.put(carro_comprascompleto.SKU, e.getString(carro_comprascompleto.SKU));
			values.put(carro_comprascompleto.formato_producto_id_formato_producto, e.getString(carro_comprascompleto.formato_producto_id_formato_producto));
			values.put(carro_comprascompleto.stock_tienda, e.getString(carro_comprascompleto.stock_tienda));
		}
		return values;
	}
	public ContentValues cvCarro_egresos(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carro_egresos");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carro_egresos.id_carro_egresos, e.getString(carro_egresos.id_carro_egresos));
			values.put(carro_egresos.cantidad_carro, e.getString(carro_egresos.cantidad_carro));
			values.put(carro_egresos.precio_carro, e.getString(carro_egresos.precio_carro));
			values.put(carro_egresos.mayor, e.getString(carro_egresos.mayor));
			values.put(carro_egresos.tienda, e.getString(carro_egresos.tienda));
			values.put(carro_egresos.usado, e.getString(carro_egresos.usado));
			values.put(carro_egresos.producto_id_producto, e.getString(carro_egresos.producto_id_producto));
			values.put(carro_egresos.usuario_id_usuario, e.getString(carro_egresos.usuario_id_usuario));
			values.put(carro_egresos.empresa_id_empresa, e.getString(carro_egresos.empresa_id_empresa));
			values.put(carro_egresos.carne_empresa_id_carne_empresa, e.getString(carro_egresos.carne_empresa_id_carne_empresa));
		}
		return values;
	}
	public ContentValues cvCarro_egresoscompleto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carro_egresoscompleto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carro_egresoscompleto.id_carro_egresos, e.getString(carro_egresoscompleto.id_carro_egresos));
			values.put(carro_egresoscompleto.cantidad_carro, e.getString(carro_egresoscompleto.cantidad_carro));
			values.put(carro_egresoscompleto.precio_carro, e.getString(carro_egresoscompleto.precio_carro));
			values.put(carro_egresoscompleto.mayor, e.getString(carro_egresoscompleto.mayor));
			values.put(carro_egresoscompleto.tienda, e.getString(carro_egresoscompleto.tienda));
			values.put(carro_egresoscompleto.usuario_id_usuario, e.getString(carro_egresoscompleto.usuario_id_usuario));
			values.put(carro_egresoscompleto.usado, e.getString(carro_egresoscompleto.usado));
			values.put(carro_egresoscompleto.carne_empresa_id_carne_empresa, e.getString(carro_egresoscompleto.carne_empresa_id_carne_empresa));
			values.put(carro_egresoscompleto.id_producto, e.getString(carro_egresoscompleto.id_producto));
			values.put(carro_egresoscompleto.codigo_producto, e.getString(carro_egresoscompleto.codigo_producto));
			values.put(carro_egresoscompleto.numero_serie, e.getString(carro_egresoscompleto.numero_serie));
			values.put(carro_egresoscompleto.descripcion_producto, e.getString(carro_egresoscompleto.descripcion_producto));
			values.put(carro_egresoscompleto.nombre_producto, e.getString(carro_egresoscompleto.nombre_producto));
			values.put(carro_egresoscompleto.marca_producto, e.getString(carro_egresoscompleto.marca_producto));
			values.put(carro_egresoscompleto.modelo_producto, e.getString(carro_egresoscompleto.modelo_producto));
			values.put(carro_egresoscompleto.contenido_unidad, e.getString(carro_egresoscompleto.contenido_unidad));
			values.put(carro_egresoscompleto.unidad_minima, e.getString(carro_egresoscompleto.unidad_minima));
			values.put(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(carro_egresoscompleto.contenido, e.getString(carro_egresoscompleto.contenido));
			values.put(carro_egresoscompleto.peso_neto, e.getString(carro_egresoscompleto.peso_neto));
			values.put(carro_egresoscompleto.alto_cm, e.getString(carro_egresoscompleto.alto_cm));
			values.put(carro_egresoscompleto.ancho_cm, e.getString(carro_egresoscompleto.ancho_cm));
			values.put(carro_egresoscompleto.fondo_cm, e.getString(carro_egresoscompleto.fondo_cm));
			values.put(carro_egresoscompleto.fabricante, e.getString(carro_egresoscompleto.fabricante));
			values.put(carro_egresoscompleto.familia_necesidad_id_familia_necesidad, e.getString(carro_egresoscompleto.familia_necesidad_id_familia_necesidad));
			values.put(carro_egresoscompleto.familia_producto_id_familia_producto, e.getString(carro_egresoscompleto.familia_producto_id_familia_producto));
			values.put(carro_egresoscompleto.clase_producto, e.getString(carro_egresoscompleto.clase_producto));
			values.put(carro_egresoscompleto.linea_producto, e.getString(carro_egresoscompleto.linea_producto));
			values.put(carro_egresoscompleto.tipo_producto_id_tipo_producto, e.getString(carro_egresoscompleto.tipo_producto_id_tipo_producto));
			values.put(carro_egresoscompleto.hot, e.getString(carro_egresoscompleto.hot));
			values.put(carro_egresoscompleto.subcategoria_id_subcategoria, e.getString(carro_egresoscompleto.subcategoria_id_subcategoria));
			values.put(carro_egresoscompleto.SKU, e.getString(carro_egresoscompleto.SKU));
			values.put(carro_egresoscompleto.formato_producto_id_formato_producto, e.getString(carro_egresoscompleto.formato_producto_id_formato_producto));
			values.put(carro_egresoscompleto.stock_tienda, e.getString(carro_egresoscompleto.stock_tienda));
			values.put(carro_egresoscompleto.precio_CLP, e.getString(carro_egresoscompleto.precio_CLP));
		}
		return values;
	}
	public ContentValues cvCarro_egresosproducto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carro_egresosproducto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carro_egresosproducto.id_carro_egresos, e.getString(carro_egresosproducto.id_carro_egresos));
			values.put(carro_egresosproducto.cantidad_carro, e.getString(carro_egresosproducto.cantidad_carro));
			values.put(carro_egresosproducto.precio_carro, e.getString(carro_egresosproducto.precio_carro));
			values.put(carro_egresosproducto.mayor, e.getString(carro_egresosproducto.mayor));
			values.put(carro_egresosproducto.tienda, e.getString(carro_egresosproducto.tienda));
			values.put(carro_egresosproducto.usuario_id_usuario, e.getString(carro_egresosproducto.usuario_id_usuario));
			values.put(carro_egresosproducto.usado, e.getString(carro_egresosproducto.usado));
			values.put(carro_egresosproducto.carne_empresa_id_carne_empresa, e.getString(carro_egresosproducto.carne_empresa_id_carne_empresa));
			values.put(carro_egresosproducto.id_producto, e.getString(carro_egresosproducto.id_producto));
			values.put(carro_egresosproducto.codigo_producto, e.getString(carro_egresosproducto.codigo_producto));
			values.put(carro_egresosproducto.numero_serie, e.getString(carro_egresosproducto.numero_serie));
			values.put(carro_egresosproducto.descripcion_producto, e.getString(carro_egresosproducto.descripcion_producto));
			values.put(carro_egresosproducto.nombre_producto, e.getString(carro_egresosproducto.nombre_producto));
			values.put(carro_egresosproducto.marca_producto, e.getString(carro_egresosproducto.marca_producto));
			values.put(carro_egresosproducto.modelo_producto, e.getString(carro_egresosproducto.modelo_producto));
			values.put(carro_egresosproducto.contenido_unidad, e.getString(carro_egresosproducto.contenido_unidad));
			values.put(carro_egresosproducto.unidad_minima, e.getString(carro_egresosproducto.unidad_minima));
			values.put(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(carro_egresosproducto.contenido, e.getString(carro_egresosproducto.contenido));
			values.put(carro_egresosproducto.peso_neto, e.getString(carro_egresosproducto.peso_neto));
			values.put(carro_egresosproducto.alto_cm, e.getString(carro_egresosproducto.alto_cm));
			values.put(carro_egresosproducto.ancho_cm, e.getString(carro_egresosproducto.ancho_cm));
			values.put(carro_egresosproducto.fondo_cm, e.getString(carro_egresosproducto.fondo_cm));
			values.put(carro_egresosproducto.fabricante, e.getString(carro_egresosproducto.fabricante));
			values.put(carro_egresosproducto.familia_necesidad_id_familia_necesidad, e.getString(carro_egresosproducto.familia_necesidad_id_familia_necesidad));
			values.put(carro_egresosproducto.familia_producto_id_familia_producto, e.getString(carro_egresosproducto.familia_producto_id_familia_producto));
			values.put(carro_egresosproducto.clase_producto, e.getString(carro_egresosproducto.clase_producto));
			values.put(carro_egresosproducto.linea_producto, e.getString(carro_egresosproducto.linea_producto));
			values.put(carro_egresosproducto.tipo_producto_id_tipo_producto, e.getString(carro_egresosproducto.tipo_producto_id_tipo_producto));
			values.put(carro_egresosproducto.hot, e.getString(carro_egresosproducto.hot));
			values.put(carro_egresosproducto.subcategoria_id_subcategoria, e.getString(carro_egresosproducto.subcategoria_id_subcategoria));
			values.put(carro_egresosproducto.SKU, e.getString(carro_egresosproducto.SKU));
			values.put(carro_egresosproducto.formato_producto_id_formato_producto, e.getString(carro_egresosproducto.formato_producto_id_formato_producto));
		}
		return values;
	}
	public ContentValues cvCarro_venta(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carro_venta");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carro_venta.id_carro_venta, e.getString(carro_venta.id_carro_venta));
			values.put(carro_venta.cantidad, e.getString(carro_venta.cantidad));
			values.put(carro_venta.precio, e.getString(carro_venta.precio));
			values.put(carro_venta.carro_compras_id_carro_compras, e.getString(carro_venta.carro_compras_id_carro_compras));
			values.put(carro_venta.venta_id_venta, e.getString(carro_venta.venta_id_venta));
		}
		return values;
	}
	public ContentValues cvCarro_ventacompleto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("carro_ventacompleto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(carro_ventacompleto.id_carro_venta, e.getString(carro_ventacompleto.id_carro_venta));
			values.put(carro_ventacompleto.cantidad, e.getString(carro_ventacompleto.cantidad));
			values.put(carro_ventacompleto.precio, e.getString(carro_ventacompleto.precio));
			values.put(carro_ventacompleto.venta_id_venta, e.getString(carro_ventacompleto.venta_id_venta));
			values.put(carro_ventacompleto.id_carro_compras, e.getString(carro_ventacompleto.id_carro_compras));
			values.put(carro_ventacompleto.cantidad_carro, e.getString(carro_ventacompleto.cantidad_carro));
			values.put(carro_ventacompleto.precio_carro, e.getString(carro_ventacompleto.precio_carro));
			values.put(carro_ventacompleto.mayor, e.getString(carro_ventacompleto.mayor));
			values.put(carro_ventacompleto.tienda, e.getString(carro_ventacompleto.tienda));
			values.put(carro_ventacompleto.usuario_id_usuario, e.getString(carro_ventacompleto.usuario_id_usuario));
			values.put(carro_ventacompleto.usado, e.getString(carro_ventacompleto.usado));
			values.put(carro_ventacompleto.carne_empresa_id_carne_empresa, e.getString(carro_ventacompleto.carne_empresa_id_carne_empresa));
			values.put(carro_ventacompleto.id_precio, e.getString(carro_ventacompleto.id_precio));
			values.put(carro_ventacompleto.precio_CLP, e.getString(carro_ventacompleto.precio_CLP));
			values.put(carro_ventacompleto.precio_us, e.getString(carro_ventacompleto.precio_us));
			values.put(carro_ventacompleto.precio_mayor_CLP, e.getString(carro_ventacompleto.precio_mayor_CLP));
			values.put(carro_ventacompleto.precio_mayor_us, e.getString(carro_ventacompleto.precio_mayor_us));
			values.put(carro_ventacompleto.precio_actual, e.getString(carro_ventacompleto.precio_actual));
			values.put(carro_ventacompleto.descuento_promocion, e.getString(carro_ventacompleto.descuento_promocion));
			values.put(carro_ventacompleto.cantidad_mayor, e.getString(carro_ventacompleto.cantidad_mayor));
			values.put(carro_ventacompleto.id_producto, e.getString(carro_ventacompleto.id_producto));
			values.put(carro_ventacompleto.codigo_producto, e.getString(carro_ventacompleto.codigo_producto));
			values.put(carro_ventacompleto.numero_serie, e.getString(carro_ventacompleto.numero_serie));
			values.put(carro_ventacompleto.descripcion_producto, e.getString(carro_ventacompleto.descripcion_producto));
			values.put(carro_ventacompleto.nombre_producto, e.getString(carro_ventacompleto.nombre_producto));
			values.put(carro_ventacompleto.marca_producto, e.getString(carro_ventacompleto.marca_producto));
			values.put(carro_ventacompleto.modelo_producto, e.getString(carro_ventacompleto.modelo_producto));
			values.put(carro_ventacompleto.contenido_unidad, e.getString(carro_ventacompleto.contenido_unidad));
			values.put(carro_ventacompleto.unidad_minima, e.getString(carro_ventacompleto.unidad_minima));
			values.put(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(carro_ventacompleto.contenido, e.getString(carro_ventacompleto.contenido));
			values.put(carro_ventacompleto.peso_neto, e.getString(carro_ventacompleto.peso_neto));
			values.put(carro_ventacompleto.alto_cm, e.getString(carro_ventacompleto.alto_cm));
			values.put(carro_ventacompleto.ancho_cm, e.getString(carro_ventacompleto.ancho_cm));
			values.put(carro_ventacompleto.fondo_cm, e.getString(carro_ventacompleto.fondo_cm));
			values.put(carro_ventacompleto.fabricante, e.getString(carro_ventacompleto.fabricante));
			values.put(carro_ventacompleto.familia_necesidad_id_familia_necesidad, e.getString(carro_ventacompleto.familia_necesidad_id_familia_necesidad));
			values.put(carro_ventacompleto.familia_producto_id_familia_producto, e.getString(carro_ventacompleto.familia_producto_id_familia_producto));
			values.put(carro_ventacompleto.clase_producto, e.getString(carro_ventacompleto.clase_producto));
			values.put(carro_ventacompleto.linea_producto, e.getString(carro_ventacompleto.linea_producto));
			values.put(carro_ventacompleto.tipo_producto_id_tipo_producto, e.getString(carro_ventacompleto.tipo_producto_id_tipo_producto));
			values.put(carro_ventacompleto.hot, e.getString(carro_ventacompleto.hot));
			values.put(carro_ventacompleto.subcategoria_id_subcategoria, e.getString(carro_ventacompleto.subcategoria_id_subcategoria));
			values.put(carro_ventacompleto.SKU, e.getString(carro_ventacompleto.SKU));
			values.put(carro_ventacompleto.formato_producto_id_formato_producto, e.getString(carro_ventacompleto.formato_producto_id_formato_producto));
		}
		return values;
	}
	public ContentValues cvCategoria(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("categoria");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(categoria.id_categoria, e.getString(categoria.id_categoria));
			values.put(categoria.nombre_categoria, e.getString(categoria.nombre_categoria));
		}
		return values;
	}
	public ContentValues cvCategoria_empresa(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("categoria_empresa");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(categoria_empresa.id_categoria_empresa, e.getString(categoria_empresa.id_categoria_empresa));
			values.put(categoria_empresa.nombre_categoria_empresa, e.getString(categoria_empresa.nombre_categoria_empresa));
		}
		return values;
	}
	public ContentValues cvCi_sessions(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("ci_sessions");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(ci_sessions.session_id, e.getString(ci_sessions.session_id));
			values.put(ci_sessions.ip_address, e.getString(ci_sessions.ip_address));
			values.put(ci_sessions.user_agent, e.getString(ci_sessions.user_agent));
			values.put(ci_sessions.id_user, e.getString(ci_sessions.id_user));
			values.put(ci_sessions.nombre_apellido, e.getString(ci_sessions.nombre_apellido));
			values.put(ci_sessions.email_user, e.getString(ci_sessions.email_user));
			values.put(ci_sessions.last_activity, e.getString(ci_sessions.last_activity));
			values.put(ci_sessions.user_data, e.getString(ci_sessions.user_data));
		}
		return values;
	}
	public ContentValues cvCliente(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("cliente");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(cliente.id_cliente, e.getString(cliente.id_cliente));
			values.put(cliente.rut_cliente, e.getString(cliente.rut_cliente));
			values.put(cliente.digito_verificador, e.getString(cliente.digito_verificador));
			values.put(cliente.nombre_cliente, e.getString(cliente.nombre_cliente));
			values.put(cliente.segundo_nombre_cliente, e.getString(cliente.segundo_nombre_cliente));
			values.put(cliente.apellido_cliente, e.getString(cliente.apellido_cliente));
			values.put(cliente.segundo_apellido_cliente, e.getString(cliente.segundo_apellido_cliente));
			values.put(cliente.actividad, e.getString(cliente.actividad));
			values.put(cliente.area_actividad, e.getString(cliente.area_actividad));
			values.put(cliente.dia_fecha_nacimiento, e.getString(cliente.dia_fecha_nacimiento));
			values.put(cliente.mes_fecha_nacimiento, e.getString(cliente.mes_fecha_nacimiento));
			values.put(cliente.ano_fecha_nacimiento, e.getString(cliente.ano_fecha_nacimiento));
			values.put(cliente.edad, e.getString(cliente.edad));
			values.put(cliente.email, e.getString(cliente.email));
			values.put(cliente.celular, e.getString(cliente.celular));
			values.put(cliente.telefono, e.getString(cliente.telefono));
		}
		return values;
	}
	public ContentValues cvCliente_empresa(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("cliente_empresa");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(cliente_empresa.id_cliente_empresa, e.getString(cliente_empresa.id_cliente_empresa));
			values.put(cliente_empresa.rut_cliente_empresa, e.getString(cliente_empresa.rut_cliente_empresa));
			values.put(cliente_empresa.digito_verificador, e.getString(cliente_empresa.digito_verificador));
			values.put(cliente_empresa.nombre, e.getString(cliente_empresa.nombre));
			values.put(cliente_empresa.email_cliente_empresa, e.getString(cliente_empresa.email_cliente_empresa));
			values.put(cliente_empresa.actividad_id_actividad, e.getString(cliente_empresa.actividad_id_actividad));
			values.put(cliente_empresa.empresa_id_empresa, e.getString(cliente_empresa.empresa_id_empresa));
		}
		return values;
	}
	public ContentValues cvCompracompleta(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("compracompleta");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(compracompleta.id_factura, e.getString(compracompleta.id_factura));
			values.put(compracompleta.rol_factura, e.getString(compracompleta.rol_factura));
			values.put(compracompleta.dia_factura, e.getString(compracompleta.dia_factura));
			values.put(compracompleta.mes_factura, e.getString(compracompleta.mes_factura));
			values.put(compracompleta.ano_factura, e.getString(compracompleta.ano_factura));
			values.put(compracompleta.fecha_factura, e.getString(compracompleta.fecha_factura));
			values.put(compracompleta.empresa_id_empresa, e.getString(compracompleta.empresa_id_empresa));
			values.put(compracompleta.carne_empresa_id_carne_empresa, e.getString(compracompleta.carne_empresa_id_carne_empresa));
			values.put(compracompleta.rut_proveedor, e.getString(compracompleta.rut_proveedor));
			values.put(compracompleta.nombre_proveedor, e.getString(compracompleta.nombre_proveedor));
			values.put(compracompleta.telefono_proveedor, e.getString(compracompleta.telefono_proveedor));
			values.put(compracompleta.tipo_documento_id_tipo_documento, e.getString(compracompleta.tipo_documento_id_tipo_documento));
			values.put(compracompleta.tipo_pago_id_tipo_pago, e.getString(compracompleta.tipo_pago_id_tipo_pago));
			values.put(compracompleta.total_factura, e.getString(compracompleta.total_factura));
			values.put(compracompleta.id_tipo_pago, e.getString(compracompleta.id_tipo_pago));
			values.put(compracompleta.nombre_tipo_pago, e.getString(compracompleta.nombre_tipo_pago));
			values.put(compracompleta.comision_tipo_pago, e.getString(compracompleta.comision_tipo_pago));
			values.put(compracompleta.id_tipo_documento, e.getString(compracompleta.id_tipo_documento));
			values.put(compracompleta.nombre_tipo_documento, e.getString(compracompleta.nombre_tipo_documento));
		}
		return values;
	}
	public ContentValues cvComuna(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("comuna");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(comuna.id_comuna, e.getString(comuna.id_comuna));
			values.put(comuna.codigo_comuna, e.getString(comuna.codigo_comuna));
			values.put(comuna.nombre_comuna, e.getString(comuna.nombre_comuna));
			values.put(comuna.provincia_id_provincia, e.getString(comuna.provincia_id_provincia));
		}
		return values;
	}
	public ContentValues cvContenido_unidad_medida(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("contenido_unidad_medida");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(contenido_unidad_medida.id_contenido_unidad_medida, e.getString(contenido_unidad_medida.id_contenido_unidad_medida));
			values.put(contenido_unidad_medida.nombre_contenido_unidad_medida, e.getString(contenido_unidad_medida.nombre_contenido_unidad_medida));
		}
		return values;
	}
	public ContentValues cvDia(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("dia");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(dia.iddia, e.getString(dia.iddia));
			values.put(dia.dia, e.getString(dia.dia));
			values.put(dia.mes, e.getString(dia.mes));
			values.put(dia.anno, e.getString(dia.anno));
			values.put(dia.fecha, e.getString(dia.fecha));
			values.put(dia.egreso, e.getString(dia.egreso));
			values.put(dia.ingreso, e.getString(dia.ingreso));
			values.put(dia.impuesto, e.getString(dia.impuesto));
		}
		return values;
	}
	public ContentValues cvEmpresa(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("empresa");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(empresa.id_empresa, e.getString(empresa.id_empresa));
			values.put(empresa.rut_empresa, e.getString(empresa.rut_empresa));
			values.put(empresa.digito_verificador_empresa, e.getString(empresa.digito_verificador_empresa));
			values.put(empresa.nombre_empresa, e.getString(empresa.nombre_empresa));
			values.put(empresa.nombre_contacto_empresa, e.getString(empresa.nombre_contacto_empresa));
			values.put(empresa.cargo_contacto_empresa, e.getString(empresa.cargo_contacto_empresa));
			values.put(empresa.email_empresa, e.getString(empresa.email_empresa));
			values.put(empresa.alcance_empresa, e.getString(empresa.alcance_empresa));
			values.put(empresa.telefono_empresa, e.getString(empresa.telefono_empresa));
			values.put(empresa.actividad_id_actividad, e.getString(empresa.actividad_id_actividad));
			values.put(empresa.tipo_empresa_id_tipo_empresa, e.getString(empresa.tipo_empresa_id_tipo_empresa));
		}
		return values;
	}
	public ContentValues cvEnvio(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("envio");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(envio.id_envio, e.getString(envio.id_envio));
			values.put(envio.direccion_alternativa, e.getString(envio.direccion_alternativa));
			values.put(envio.fecha_entrega, e.getString(envio.fecha_entrega));
			values.put(envio.hora_entrega, e.getString(envio.hora_entrega));
			values.put(envio.venta_id_venta, e.getString(envio.venta_id_venta));
			values.put(envio.enviado, e.getString(envio.enviado));
		}
		return values;
	}
	public ContentValues cvFactura(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("factura");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(factura.id_factura, e.getString(factura.id_factura));
			values.put(factura.rol_factura, e.getString(factura.rol_factura));
			values.put(factura.dia_factura, e.getString(factura.dia_factura));
			values.put(factura.mes_factura, e.getString(factura.mes_factura));
			values.put(factura.ano_factura, e.getString(factura.ano_factura));
			values.put(factura.fecha_factura, e.getString(factura.fecha_factura));
			values.put(factura.empresa_id_empresa, e.getString(factura.empresa_id_empresa));
			values.put(factura.carne_empresa_id_carne_empresa, e.getString(factura.carne_empresa_id_carne_empresa));
			values.put(factura.rut_proveedor, e.getString(factura.rut_proveedor));
			values.put(factura.nombre_proveedor, e.getString(factura.nombre_proveedor));
			values.put(factura.telefono_proveedor, e.getString(factura.telefono_proveedor));
			values.put(factura.tipo_documento_id_tipo_documento, e.getString(factura.tipo_documento_id_tipo_documento));
			values.put(factura.tipo_pago_id_tipo_pago, e.getString(factura.tipo_pago_id_tipo_pago));
			values.put(factura.total_factura, e.getString(factura.total_factura));
		}
		return values;
	}
	public ContentValues cvFamilia_necesidad(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("familia_necesidad");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(familia_necesidad.id_familia_necesidad, e.getString(familia_necesidad.id_familia_necesidad));
			values.put(familia_necesidad.nombre_familia_necesidad, e.getString(familia_necesidad.nombre_familia_necesidad));
		}
		return values;
	}
	public ContentValues cvFamilia_producto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("familia_producto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(familia_producto.id_familia_producto, e.getString(familia_producto.id_familia_producto));
			values.put(familia_producto.nombre_familia_producto, e.getString(familia_producto.nombre_familia_producto));
		}
		return values;
	}
	public ContentValues cvFormato_producto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("formato_producto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(formato_producto.id_formato_producto, e.getString(formato_producto.id_formato_producto));
			values.put(formato_producto.nombre_formato_producto, e.getString(formato_producto.nombre_formato_producto));
		}
		return values;
	}
	public ContentValues cvGasto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("gasto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(gasto.id_gasto, e.getString(gasto.id_gasto));
			values.put(gasto.nombre_gasto, e.getString(gasto.nombre_gasto));
			values.put(gasto.id_usuario, e.getString(gasto.id_usuario));
			values.put(gasto.monto_gasto, e.getString(gasto.monto_gasto));
			values.put(gasto.fecha_gasto, e.getString(gasto.fecha_gasto));
			values.put(gasto.empresa_id_empre, e.getString(gasto.empresa_id_empre));
		}
		return values;
	}
	public ContentValues cvGeocode_cache(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("geocode_cache");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(geocode_cache.id, e.getString(geocode_cache.id));
			values.put(geocode_cache.lng, e.getString(geocode_cache.lng));
			values.put(geocode_cache.lat, e.getString(geocode_cache.lat));
			values.put(geocode_cache.query, e.getString(geocode_cache.query));
		}
		return values;
	}
	public ContentValues cvImagenprod(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("imagenprod");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(imagenprod.id_imagenprod, e.getString(imagenprod.id_imagenprod));
			values.put(imagenprod.urlimagenprod, e.getString(imagenprod.urlimagenprod));
			values.put(imagenprod.producto_id_producto, e.getString(imagenprod.producto_id_producto));
		}
		return values;
	}
	public ContentValues cvImpuesto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("impuesto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(impuesto.id_impuesto, e.getString(impuesto.id_impuesto));
			values.put(impuesto.nombre_impuesto, e.getString(impuesto.nombre_impuesto));
			values.put(impuesto.valor_impuesto, e.getString(impuesto.valor_impuesto));
		}
		return values;
	}
	public ContentValues cvIngresosegresos(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("ingresosegresos");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(ingresosegresos.dia, e.getString(ingresosegresos.dia));
			values.put(ingresosegresos.mes, e.getString(ingresosegresos.mes));
			values.put(ingresosegresos.anno, e.getString(ingresosegresos.anno));
			values.put(ingresosegresos.fecha, e.getString(ingresosegresos.fecha));
			values.put(ingresosegresos.totalingreso, e.getString(ingresosegresos.totalingreso));
			values.put(ingresosegresos.totalgasto, e.getString(ingresosegresos.totalgasto));
			values.put(ingresosegresos.impuestoegreso, e.getString(ingresosegresos.impuestoegreso));
			values.put(ingresosegresos.impuestoingreso, e.getString(ingresosegresos.impuestoingreso));
		}
		return values;
	}
	public ContentValues cvItem_factura(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("item_factura");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(item_factura.id_itemfactura, e.getString(item_factura.id_itemfactura));
			values.put(item_factura.cantidad, e.getString(item_factura.cantidad));
			values.put(item_factura.precio, e.getString(item_factura.precio));
			values.put(item_factura.producto_id_producto, e.getString(item_factura.producto_id_producto));
			values.put(item_factura.factura_id_factura, e.getString(item_factura.factura_id_factura));
			values.put(item_factura.carro_egresos_id_carro_egresos, e.getString(item_factura.carro_egresos_id_carro_egresos));
		}
		return values;
	}
	public ContentValues cvItem_facturacompleto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("item_facturacompleto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(item_facturacompleto.id_itemfactura, e.getString(item_facturacompleto.id_itemfactura));
			values.put(item_facturacompleto.cantidad, e.getString(item_facturacompleto.cantidad));
			values.put(item_facturacompleto.precio, e.getString(item_facturacompleto.precio));
			values.put(item_facturacompleto.producto_id_producto, e.getString(item_facturacompleto.producto_id_producto));
			values.put(item_facturacompleto.factura_id_factura, e.getString(item_facturacompleto.factura_id_factura));
			values.put(item_facturacompleto.id_producto, e.getString(item_facturacompleto.id_producto));
			values.put(item_facturacompleto.codigo_producto, e.getString(item_facturacompleto.codigo_producto));
			values.put(item_facturacompleto.numero_serie, e.getString(item_facturacompleto.numero_serie));
			values.put(item_facturacompleto.descripcion_producto, e.getString(item_facturacompleto.descripcion_producto));
			values.put(item_facturacompleto.nombre_producto, e.getString(item_facturacompleto.nombre_producto));
			values.put(item_facturacompleto.marca_producto, e.getString(item_facturacompleto.marca_producto));
			values.put(item_facturacompleto.modelo_producto, e.getString(item_facturacompleto.modelo_producto));
			values.put(item_facturacompleto.contenido_unidad, e.getString(item_facturacompleto.contenido_unidad));
			values.put(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(item_facturacompleto.unidad_minima, e.getString(item_facturacompleto.unidad_minima));
			values.put(item_facturacompleto.contenido, e.getString(item_facturacompleto.contenido));
			values.put(item_facturacompleto.peso_neto, e.getString(item_facturacompleto.peso_neto));
			values.put(item_facturacompleto.alto_cm, e.getString(item_facturacompleto.alto_cm));
			values.put(item_facturacompleto.ancho_cm, e.getString(item_facturacompleto.ancho_cm));
			values.put(item_facturacompleto.fondo_cm, e.getString(item_facturacompleto.fondo_cm));
			values.put(item_facturacompleto.fabricante, e.getString(item_facturacompleto.fabricante));
			values.put(item_facturacompleto.clase_producto, e.getString(item_facturacompleto.clase_producto));
			values.put(item_facturacompleto.linea_producto, e.getString(item_facturacompleto.linea_producto));
			values.put(item_facturacompleto.hot, e.getString(item_facturacompleto.hot));
			values.put(item_facturacompleto.SKU, e.getString(item_facturacompleto.SKU));
			values.put(item_facturacompleto.subcategoria_id_subcategoria, e.getString(item_facturacompleto.subcategoria_id_subcategoria));
			values.put(item_facturacompleto.tipo_producto_id_tipo_producto, e.getString(item_facturacompleto.tipo_producto_id_tipo_producto));
			values.put(item_facturacompleto.formato_producto_id_formato_producto, e.getString(item_facturacompleto.formato_producto_id_formato_producto));
			values.put(item_facturacompleto.familia_necesidad_id_familia_necesidad, e.getString(item_facturacompleto.familia_necesidad_id_familia_necesidad));
			values.put(item_facturacompleto.familia_producto_id_familia_producto, e.getString(item_facturacompleto.familia_producto_id_familia_producto));
		}
		return values;
	}
	public ContentValues cvMapa(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("mapa");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(mapa.id, e.getString(mapa.id));
			values.put(mapa.name, e.getString(mapa.name));
			values.put(mapa.direccion, e.getString(mapa.direccion));
			values.put(mapa.lat, e.getString(mapa.lat));
			values.put(mapa.lng, e.getString(mapa.lng));
			values.put(mapa.tipo, e.getString(mapa.tipo));
			values.put(mapa.imagen, e.getString(mapa.imagen));
		}
		return values;
	}
	public ContentValues cvPais(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("pais");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(pais.id_pais, e.getString(pais.id_pais));
			values.put(pais.nombre_pais, e.getString(pais.nombre_pais));
			values.put(pais.iso_code_2_pais, e.getString(pais.iso_code_2_pais));
			values.put(pais.iso_code_3_pais, e.getString(pais.iso_code_3_pais));
			values.put(pais.address_format, e.getString(pais.address_format));
			values.put(pais.iso_code_number, e.getString(pais.iso_code_number));
		}
		return values;
	}
	public ContentValues cvPersona(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("persona");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(persona.id_persona, e.getString(persona.id_persona));
			values.put(persona.rut_persona, e.getString(persona.rut_persona));
			values.put(persona.digito_verificador, e.getString(persona.digito_verificador));
			values.put(persona.nombre_persona, e.getString(persona.nombre_persona));
			values.put(persona.segundo_nombre_persona, e.getString(persona.segundo_nombre_persona));
			values.put(persona.apellido_persona, e.getString(persona.apellido_persona));
			values.put(persona.segundo_apellido_persona, e.getString(persona.segundo_apellido_persona));
			values.put(persona.actividad, e.getString(persona.actividad));
			values.put(persona.area_actividad, e.getString(persona.area_actividad));
			values.put(persona.dia_fecha_nacimiento, e.getString(persona.dia_fecha_nacimiento));
			values.put(persona.mes_fecha_nacimiento, e.getString(persona.mes_fecha_nacimiento));
			values.put(persona.ano_fecha_nacimiento, e.getString(persona.ano_fecha_nacimiento));
			values.put(persona.edad, e.getString(persona.edad));
			values.put(persona.email, e.getString(persona.email));
			values.put(persona.celular, e.getString(persona.celular));
			values.put(persona.telefono, e.getString(persona.telefono));
		}
		return values;
	}
	public ContentValues cvPrecio(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("precio");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(precio.id_precio, e.getString(precio.id_precio));
			values.put(precio.precio_CLP, e.getString(precio.precio_CLP));
			values.put(precio.precio_us, e.getString(precio.precio_us));
			values.put(precio.precio_mayor_CLP, e.getString(precio.precio_mayor_CLP));
			values.put(precio.precio_mayor_us, e.getString(precio.precio_mayor_us));
			values.put(precio.precio_actual, e.getString(precio.precio_actual));
			values.put(precio.descuento_promocion, e.getString(precio.descuento_promocion));
			values.put(precio.cantidad_mayor, e.getString(precio.cantidad_mayor));
			values.put(precio.empresa_id_empresa, e.getString(precio.empresa_id_empresa));
			values.put(precio.producto_id_producto, e.getString(precio.producto_id_producto));
		}
		return values;
	}
	public ContentValues cvProducto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("producto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(producto.id_producto, e.getString(producto.id_producto));
			values.put(producto.codigo_producto, e.getString(producto.codigo_producto));
			values.put(producto.numero_serie, e.getString(producto.numero_serie));
			values.put(producto.descripcion_producto, e.getString(producto.descripcion_producto));
			values.put(producto.nombre_producto, e.getString(producto.nombre_producto));
			values.put(producto.marca_producto, e.getString(producto.marca_producto));
			values.put(producto.modelo_producto, e.getString(producto.modelo_producto));
			values.put(producto.contenido_unidad, e.getString(producto.contenido_unidad));
			values.put(producto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(producto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(producto.unidad_minima, e.getString(producto.unidad_minima));
			values.put(producto.contenido, e.getString(producto.contenido));
			values.put(producto.peso_neto, e.getString(producto.peso_neto));
			values.put(producto.alto_cm, e.getString(producto.alto_cm));
			values.put(producto.ancho_cm, e.getString(producto.ancho_cm));
			values.put(producto.fondo_cm, e.getString(producto.fondo_cm));
			values.put(producto.fabricante, e.getString(producto.fabricante));
			values.put(producto.clase_producto, e.getString(producto.clase_producto));
			values.put(producto.linea_producto, e.getString(producto.linea_producto));
			values.put(producto.hot, e.getString(producto.hot));
			values.put(producto.SKU, e.getString(producto.SKU));
			values.put(producto.subcategoria_id_subcategoria, e.getString(producto.subcategoria_id_subcategoria));
			values.put(producto.tipo_producto_id_tipo_producto, e.getString(producto.tipo_producto_id_tipo_producto));
			values.put(producto.formato_producto_id_formato_producto, e.getString(producto.formato_producto_id_formato_producto));
			values.put(producto.familia_necesidad_id_familia_necesidad, e.getString(producto.familia_necesidad_id_familia_necesidad));
			values.put(producto.familia_producto_id_familia_producto, e.getString(producto.familia_producto_id_familia_producto));
		}
		return values;
	}
	public ContentValues cvProductocompleto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("productocompleto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(productocompleto.id_producto, e.getString(productocompleto.id_producto));
			values.put(productocompleto.codigo_producto, e.getString(productocompleto.codigo_producto));
			values.put(productocompleto.numero_serie, e.getString(productocompleto.numero_serie));
			values.put(productocompleto.descripcion_producto, e.getString(productocompleto.descripcion_producto));
			values.put(productocompleto.nombre_producto, e.getString(productocompleto.nombre_producto));
			values.put(productocompleto.marca_producto, e.getString(productocompleto.marca_producto));
			values.put(productocompleto.modelo_producto, e.getString(productocompleto.modelo_producto));
			values.put(productocompleto.contenido_unidad, e.getString(productocompleto.contenido_unidad));
			values.put(productocompleto.unidad_minima, e.getString(productocompleto.unidad_minima));
			values.put(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(productocompleto.contenido, e.getString(productocompleto.contenido));
			values.put(productocompleto.peso_neto, e.getString(productocompleto.peso_neto));
			values.put(productocompleto.alto_cm, e.getString(productocompleto.alto_cm));
			values.put(productocompleto.ancho_cm, e.getString(productocompleto.ancho_cm));
			values.put(productocompleto.fondo_cm, e.getString(productocompleto.fondo_cm));
			values.put(productocompleto.fabricante, e.getString(productocompleto.fabricante));
			values.put(productocompleto.familia_necesidad_id_familia_necesidad, e.getString(productocompleto.familia_necesidad_id_familia_necesidad));
			values.put(productocompleto.familia_producto_id_familia_producto, e.getString(productocompleto.familia_producto_id_familia_producto));
			values.put(productocompleto.clase_producto, e.getString(productocompleto.clase_producto));
			values.put(productocompleto.linea_producto, e.getString(productocompleto.linea_producto));
			values.put(productocompleto.tipo_producto_id_tipo_producto, e.getString(productocompleto.tipo_producto_id_tipo_producto));
			values.put(productocompleto.hot, e.getString(productocompleto.hot));
			values.put(productocompleto.subcategoria_id_subcategoria, e.getString(productocompleto.subcategoria_id_subcategoria));
			values.put(productocompleto.SKU, e.getString(productocompleto.SKU));
			values.put(productocompleto.formato_producto_id_formato_producto, e.getString(productocompleto.formato_producto_id_formato_producto));
			values.put(productocompleto.id_caracteristica, e.getString(productocompleto.id_caracteristica));
			values.put(productocompleto.numero_caracteristica, e.getString(productocompleto.numero_caracteristica));
			values.put(productocompleto.caracteristica, e.getString(productocompleto.caracteristica));
			values.put(productocompleto.valor_caracteristica, e.getString(productocompleto.valor_caracteristica));
			values.put(productocompleto.id_categoria, e.getString(productocompleto.id_categoria));
			values.put(productocompleto.nombre_categoria, e.getString(productocompleto.nombre_categoria));
			values.put(productocompleto.id_empresa, e.getString(productocompleto.id_empresa));
			values.put(productocompleto.rut_empresa, e.getString(productocompleto.rut_empresa));
			values.put(productocompleto.digito_verificador_empresa, e.getString(productocompleto.digito_verificador_empresa));
			values.put(productocompleto.nombre_empresa, e.getString(productocompleto.nombre_empresa));
			values.put(productocompleto.nombre_contacto_empresa, e.getString(productocompleto.nombre_contacto_empresa));
			values.put(productocompleto.cargo_contacto_empresa, e.getString(productocompleto.cargo_contacto_empresa));
			values.put(productocompleto.email_empresa, e.getString(productocompleto.email_empresa));
			values.put(productocompleto.alcance_empresa, e.getString(productocompleto.alcance_empresa));
			values.put(productocompleto.telefono_empresa, e.getString(productocompleto.telefono_empresa));
			values.put(productocompleto.actividad_id_actividad, e.getString(productocompleto.actividad_id_actividad));
			values.put(productocompleto.id_imagenprod, e.getString(productocompleto.id_imagenprod));
			values.put(productocompleto.urlimagenprod, e.getString(productocompleto.urlimagenprod));
			values.put(productocompleto.id_precio, e.getString(productocompleto.id_precio));
			values.put(productocompleto.precio_CLP, e.getString(productocompleto.precio_CLP));
			values.put(productocompleto.precio_us, e.getString(productocompleto.precio_us));
			values.put(productocompleto.precio_mayor_CLP, e.getString(productocompleto.precio_mayor_CLP));
			values.put(productocompleto.precio_mayor_us, e.getString(productocompleto.precio_mayor_us));
			values.put(productocompleto.precio_actual, e.getString(productocompleto.precio_actual));
			values.put(productocompleto.descuento_promocion, e.getString(productocompleto.descuento_promocion));
			values.put(productocompleto.cantidad_mayor, e.getString(productocompleto.cantidad_mayor));
			values.put(productocompleto.id_reciclado, e.getString(productocompleto.id_reciclado));
			values.put(productocompleto.reciclable, e.getString(productocompleto.reciclable));
			values.put(productocompleto.reciclado, e.getString(productocompleto.reciclado));
			values.put(productocompleto.valor_reciclaje, e.getString(productocompleto.valor_reciclaje));
			values.put(productocompleto.empresa_id_empresa, e.getString(productocompleto.empresa_id_empresa));
			values.put(productocompleto.id_stock, e.getString(productocompleto.id_stock));
			values.put(productocompleto.stock_real, e.getString(productocompleto.stock_real));
			values.put(productocompleto.stock_minimo, e.getString(productocompleto.stock_minimo));
			values.put(productocompleto.stock_ideal, e.getString(productocompleto.stock_ideal));
			values.put(productocompleto.stock_tienda, e.getString(productocompleto.stock_tienda));
			values.put(productocompleto.stock_virtual, e.getString(productocompleto.stock_virtual));
			values.put(productocompleto.stock_vendido, e.getString(productocompleto.stock_vendido));
			values.put(productocompleto.last_update, e.getString(productocompleto.last_update));
			values.put(productocompleto.id_subcategoria, e.getString(productocompleto.id_subcategoria));
			values.put(productocompleto.nombre_subcategoria, e.getString(productocompleto.nombre_subcategoria));
			values.put(productocompleto.descripcion_subcategoria, e.getString(productocompleto.descripcion_subcategoria));
			values.put(productocompleto.categoria_id_categoria, e.getString(productocompleto.categoria_id_categoria));
			values.put(productocompleto.id_talla, e.getString(productocompleto.id_talla));
			values.put(productocompleto.am_largo, e.getString(productocompleto.am_largo));
			values.put(productocompleto.am_ancho, e.getString(productocompleto.am_ancho));
			values.put(productocompleto.am_fondo, e.getString(productocompleto.am_fondo));
			values.put(productocompleto.eu_largo, e.getString(productocompleto.eu_largo));
			values.put(productocompleto.eu_ancho, e.getString(productocompleto.eu_ancho));
			values.put(productocompleto.eu_fondo, e.getString(productocompleto.eu_fondo));
			values.put(productocompleto.num_largo, e.getString(productocompleto.num_largo));
			values.put(productocompleto.num_ancho, e.getString(productocompleto.num_ancho));
			values.put(productocompleto.num_fondo, e.getString(productocompleto.num_fondo));
			values.put(productocompleto.id_valor_nutricional, e.getString(productocompleto.id_valor_nutricional));
			values.put(productocompleto.nombre_valor, e.getString(productocompleto.nombre_valor));
			values.put(productocompleto.cantidad, e.getString(productocompleto.cantidad));
			values.put(productocompleto.valor_diario_total, e.getString(productocompleto.valor_diario_total));
			values.put(productocompleto.porcentaje_requerimientos, e.getString(productocompleto.porcentaje_requerimientos));
		}
		return values;
	}
	public ContentValues cvProductocompra(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("productocompra");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(productocompra.id_producto, e.getString(productocompra.id_producto));
			values.put(productocompra.codigo_producto, e.getString(productocompra.codigo_producto));
			values.put(productocompra.numero_serie, e.getString(productocompra.numero_serie));
			values.put(productocompra.descripcion_producto, e.getString(productocompra.descripcion_producto));
			values.put(productocompra.nombre_producto, e.getString(productocompra.nombre_producto));
			values.put(productocompra.marca_producto, e.getString(productocompra.marca_producto));
			values.put(productocompra.modelo_producto, e.getString(productocompra.modelo_producto));
			values.put(productocompra.contenido_unidad, e.getString(productocompra.contenido_unidad));
			values.put(productocompra.unidad_minima, e.getString(productocompra.unidad_minima));
			values.put(productocompra.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(productocompra.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(productocompra.contenido, e.getString(productocompra.contenido));
			values.put(productocompra.peso_neto, e.getString(productocompra.peso_neto));
			values.put(productocompra.alto_cm, e.getString(productocompra.alto_cm));
			values.put(productocompra.ancho_cm, e.getString(productocompra.ancho_cm));
			values.put(productocompra.fondo_cm, e.getString(productocompra.fondo_cm));
			values.put(productocompra.fabricante, e.getString(productocompra.fabricante));
			values.put(productocompra.familia_necesidad_id_familia_necesidad, e.getString(productocompra.familia_necesidad_id_familia_necesidad));
			values.put(productocompra.familia_producto_id_familia_producto, e.getString(productocompra.familia_producto_id_familia_producto));
			values.put(productocompra.clase_producto, e.getString(productocompra.clase_producto));
			values.put(productocompra.linea_producto, e.getString(productocompra.linea_producto));
			values.put(productocompra.tipo_producto_id_tipo_producto, e.getString(productocompra.tipo_producto_id_tipo_producto));
			values.put(productocompra.hot, e.getString(productocompra.hot));
			values.put(productocompra.subcategoria_id_subcategoria, e.getString(productocompra.subcategoria_id_subcategoria));
			values.put(productocompra.SKU, e.getString(productocompra.SKU));
			values.put(productocompra.formato_producto_id_formato_producto, e.getString(productocompra.formato_producto_id_formato_producto));
			values.put(productocompra.id_caracteristica, e.getString(productocompra.id_caracteristica));
			values.put(productocompra.numero_caracteristica, e.getString(productocompra.numero_caracteristica));
			values.put(productocompra.caracteristica, e.getString(productocompra.caracteristica));
			values.put(productocompra.valor_caracteristica, e.getString(productocompra.valor_caracteristica));
			values.put(productocompra.id_categoria, e.getString(productocompra.id_categoria));
			values.put(productocompra.nombre_categoria, e.getString(productocompra.nombre_categoria));
			values.put(productocompra.id_reciclado, e.getString(productocompra.id_reciclado));
			values.put(productocompra.reciclable, e.getString(productocompra.reciclable));
			values.put(productocompra.reciclado, e.getString(productocompra.reciclado));
			values.put(productocompra.valor_reciclaje, e.getString(productocompra.valor_reciclaje));
			values.put(productocompra.empresa_id_empresa, e.getString(productocompra.empresa_id_empresa));
			values.put(productocompra.id_stock, e.getString(productocompra.id_stock));
			values.put(productocompra.stock_real, e.getString(productocompra.stock_real));
			values.put(productocompra.stock_minimo, e.getString(productocompra.stock_minimo));
			values.put(productocompra.stock_ideal, e.getString(productocompra.stock_ideal));
			values.put(productocompra.stock_tienda, e.getString(productocompra.stock_tienda));
			values.put(productocompra.stock_virtual, e.getString(productocompra.stock_virtual));
			values.put(productocompra.stock_vendido, e.getString(productocompra.stock_vendido));
			values.put(productocompra.last_update, e.getString(productocompra.last_update));
			values.put(productocompra.id_subcategoria, e.getString(productocompra.id_subcategoria));
			values.put(productocompra.nombre_subcategoria, e.getString(productocompra.nombre_subcategoria));
			values.put(productocompra.descripcion_subcategoria, e.getString(productocompra.descripcion_subcategoria));
			values.put(productocompra.categoria_id_categoria, e.getString(productocompra.categoria_id_categoria));
			values.put(productocompra.id_talla, e.getString(productocompra.id_talla));
			values.put(productocompra.am_largo, e.getString(productocompra.am_largo));
			values.put(productocompra.am_ancho, e.getString(productocompra.am_ancho));
			values.put(productocompra.am_fondo, e.getString(productocompra.am_fondo));
			values.put(productocompra.eu_largo, e.getString(productocompra.eu_largo));
			values.put(productocompra.eu_ancho, e.getString(productocompra.eu_ancho));
			values.put(productocompra.eu_fondo, e.getString(productocompra.eu_fondo));
			values.put(productocompra.num_largo, e.getString(productocompra.num_largo));
			values.put(productocompra.num_ancho, e.getString(productocompra.num_ancho));
			values.put(productocompra.num_fondo, e.getString(productocompra.num_fondo));
			values.put(productocompra.id_valor_nutricional, e.getString(productocompra.id_valor_nutricional));
			values.put(productocompra.nombre_valor, e.getString(productocompra.nombre_valor));
			values.put(productocompra.cantidad, e.getString(productocompra.cantidad));
			values.put(productocompra.valor_diario_total, e.getString(productocompra.valor_diario_total));
			values.put(productocompra.porcentaje_requerimientos, e.getString(productocompra.porcentaje_requerimientos));
		}
		return values;
	}
	public ContentValues cvProductoprecio(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("productoprecio");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(productoprecio.id_producto, e.getString(productoprecio.id_producto));
			values.put(productoprecio.codigo_producto, e.getString(productoprecio.codigo_producto));
			values.put(productoprecio.numero_serie, e.getString(productoprecio.numero_serie));
			values.put(productoprecio.descripcion_producto, e.getString(productoprecio.descripcion_producto));
			values.put(productoprecio.nombre_producto, e.getString(productoprecio.nombre_producto));
			values.put(productoprecio.marca_producto, e.getString(productoprecio.marca_producto));
			values.put(productoprecio.modelo_producto, e.getString(productoprecio.modelo_producto));
			values.put(productoprecio.contenido_unidad, e.getString(productoprecio.contenido_unidad));
			values.put(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(productoprecio.unidad_minima, e.getString(productoprecio.unidad_minima));
			values.put(productoprecio.contenido, e.getString(productoprecio.contenido));
			values.put(productoprecio.peso_neto, e.getString(productoprecio.peso_neto));
			values.put(productoprecio.alto_cm, e.getString(productoprecio.alto_cm));
			values.put(productoprecio.ancho_cm, e.getString(productoprecio.ancho_cm));
			values.put(productoprecio.fondo_cm, e.getString(productoprecio.fondo_cm));
			values.put(productoprecio.fabricante, e.getString(productoprecio.fabricante));
			values.put(productoprecio.clase_producto, e.getString(productoprecio.clase_producto));
			values.put(productoprecio.linea_producto, e.getString(productoprecio.linea_producto));
			values.put(productoprecio.hot, e.getString(productoprecio.hot));
			values.put(productoprecio.SKU, e.getString(productoprecio.SKU));
			values.put(productoprecio.subcategoria_id_subcategoria, e.getString(productoprecio.subcategoria_id_subcategoria));
			values.put(productoprecio.tipo_producto_id_tipo_producto, e.getString(productoprecio.tipo_producto_id_tipo_producto));
			values.put(productoprecio.formato_producto_id_formato_producto, e.getString(productoprecio.formato_producto_id_formato_producto));
			values.put(productoprecio.familia_necesidad_id_familia_necesidad, e.getString(productoprecio.familia_necesidad_id_familia_necesidad));
			values.put(productoprecio.familia_producto_id_familia_producto, e.getString(productoprecio.familia_producto_id_familia_producto));
			values.put(productoprecio.id_precio, e.getString(productoprecio.id_precio));
			values.put(productoprecio.precio_CLP, e.getString(productoprecio.precio_CLP));
			values.put(productoprecio.precio_us, e.getString(productoprecio.precio_us));
			values.put(productoprecio.precio_mayor_CLP, e.getString(productoprecio.precio_mayor_CLP));
			values.put(productoprecio.precio_mayor_us, e.getString(productoprecio.precio_mayor_us));
			values.put(productoprecio.precio_actual, e.getString(productoprecio.precio_actual));
			values.put(productoprecio.descuento_promocion, e.getString(productoprecio.descuento_promocion));
			values.put(productoprecio.cantidad_mayor, e.getString(productoprecio.cantidad_mayor));
			values.put(productoprecio.id_stock, e.getString(productoprecio.id_stock));
			values.put(productoprecio.stock_real, e.getString(productoprecio.stock_real));
			values.put(productoprecio.stock_minimo, e.getString(productoprecio.stock_minimo));
			values.put(productoprecio.stock_ideal, e.getString(productoprecio.stock_ideal));
			values.put(productoprecio.stock_tienda, e.getString(productoprecio.stock_tienda));
			values.put(productoprecio.stock_virtual, e.getString(productoprecio.stock_virtual));
			values.put(productoprecio.stock_vendido, e.getString(productoprecio.stock_vendido));
			values.put(productoprecio.last_update, e.getString(productoprecio.last_update));
			values.put(productoprecio.empresa_id_empresa, e.getString(productoprecio.empresa_id_empresa));
		}
		return values;
	}
	public ContentValues cvProvincia(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("provincia");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(provincia.id_provincia, e.getString(provincia.id_provincia));
			values.put(provincia.nombre_provincia, e.getString(provincia.nombre_provincia));
			values.put(provincia.codigo_provincia, e.getString(provincia.codigo_provincia));
			values.put(provincia.region_id_region, e.getString(provincia.region_id_region));
		}
		return values;
	}
	public ContentValues cvReciclado(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("reciclado");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(reciclado.id_reciclado, e.getString(reciclado.id_reciclado));
			values.put(reciclado.reciclable, e.getString(reciclado.reciclable));
			values.put(reciclado.reciclado, e.getString(reciclado.reciclado));
			values.put(reciclado.valor_reciclaje, e.getString(reciclado.valor_reciclaje));
			values.put(reciclado.empresa_id_empresa, e.getString(reciclado.empresa_id_empresa));
			values.put(reciclado.producto_id_producto, e.getString(reciclado.producto_id_producto));
		}
		return values;
	}
	public ContentValues cvRegion(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("region");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(region.id_region, e.getString(region.id_region));
			values.put(region.nombre_region, e.getString(region.nombre_region));
			values.put(region.codigo_region, e.getString(region.codigo_region));
			values.put(region.pais_id_pais, e.getString(region.pais_id_pais));
		}
		return values;
	}
	public ContentValues cvRubro(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("rubro");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(rubro.id_rubro, e.getString(rubro.id_rubro));
			values.put(rubro.nombre_rubro, e.getString(rubro.nombre_rubro));
		}
		return values;
	}
	public ContentValues cvSincrodate(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("sincrodate");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(sincrodate.id_sincrodate, e.getString(sincrodate.id_sincrodate));
			values.put(sincrodate.date, e.getString(sincrodate.date));
		}
		return values;
	}
	public ContentValues cvStock(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("stock");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(stock.id_stock, e.getString(stock.id_stock));
			values.put(stock.stock_real, e.getString(stock.stock_real));
			values.put(stock.stock_minimo, e.getString(stock.stock_minimo));
			values.put(stock.stock_ideal, e.getString(stock.stock_ideal));
			values.put(stock.stock_tienda, e.getString(stock.stock_tienda));
			values.put(stock.stock_virtual, e.getString(stock.stock_virtual));
			values.put(stock.stock_vendido, e.getString(stock.stock_vendido));
			values.put(stock.last_update, e.getString(stock.last_update));
			values.put(stock.producto_id_producto, e.getString(stock.producto_id_producto));
			values.put(stock.empresa_id_empresa, e.getString(stock.empresa_id_empresa));
		}
		return values;
	}
	public ContentValues cvStockcompleto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("stockcompleto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(stockcompleto.id_producto, e.getString(stockcompleto.id_producto));
			values.put(stockcompleto.codigo_producto, e.getString(stockcompleto.codigo_producto));
			values.put(stockcompleto.numero_serie, e.getString(stockcompleto.numero_serie));
			values.put(stockcompleto.descripcion_producto, e.getString(stockcompleto.descripcion_producto));
			values.put(stockcompleto.nombre_producto, e.getString(stockcompleto.nombre_producto));
			values.put(stockcompleto.marca_producto, e.getString(stockcompleto.marca_producto));
			values.put(stockcompleto.modelo_producto, e.getString(stockcompleto.modelo_producto));
			values.put(stockcompleto.contenido_unidad, e.getString(stockcompleto.contenido_unidad));
			values.put(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida));
			values.put(stockcompleto.unidad_minima, e.getString(stockcompleto.unidad_minima));
			values.put(stockcompleto.contenido, e.getString(stockcompleto.contenido));
			values.put(stockcompleto.peso_neto, e.getString(stockcompleto.peso_neto));
			values.put(stockcompleto.alto_cm, e.getString(stockcompleto.alto_cm));
			values.put(stockcompleto.ancho_cm, e.getString(stockcompleto.ancho_cm));
			values.put(stockcompleto.fondo_cm, e.getString(stockcompleto.fondo_cm));
			values.put(stockcompleto.fabricante, e.getString(stockcompleto.fabricante));
			values.put(stockcompleto.clase_producto, e.getString(stockcompleto.clase_producto));
			values.put(stockcompleto.linea_producto, e.getString(stockcompleto.linea_producto));
			values.put(stockcompleto.hot, e.getString(stockcompleto.hot));
			values.put(stockcompleto.SKU, e.getString(stockcompleto.SKU));
			values.put(stockcompleto.subcategoria_id_subcategoria, e.getString(stockcompleto.subcategoria_id_subcategoria));
			values.put(stockcompleto.tipo_producto_id_tipo_producto, e.getString(stockcompleto.tipo_producto_id_tipo_producto));
			values.put(stockcompleto.formato_producto_id_formato_producto, e.getString(stockcompleto.formato_producto_id_formato_producto));
			values.put(stockcompleto.familia_necesidad_id_familia_necesidad, e.getString(stockcompleto.familia_necesidad_id_familia_necesidad));
			values.put(stockcompleto.familia_producto_id_familia_producto, e.getString(stockcompleto.familia_producto_id_familia_producto));
			values.put(stockcompleto.id_stock, e.getString(stockcompleto.id_stock));
			values.put(stockcompleto.stock_real, e.getString(stockcompleto.stock_real));
			values.put(stockcompleto.stock_minimo, e.getString(stockcompleto.stock_minimo));
			values.put(stockcompleto.stock_ideal, e.getString(stockcompleto.stock_ideal));
			values.put(stockcompleto.stock_tienda, e.getString(stockcompleto.stock_tienda));
			values.put(stockcompleto.stock_virtual, e.getString(stockcompleto.stock_virtual));
			values.put(stockcompleto.stock_vendido, e.getString(stockcompleto.stock_vendido));
			values.put(stockcompleto.last_update, e.getString(stockcompleto.last_update));
			values.put(stockcompleto.producto_id_producto, e.getString(stockcompleto.producto_id_producto));
			values.put(stockcompleto.empresa_id_empresa, e.getString(stockcompleto.empresa_id_empresa));
		}
		return values;
	}
	public ContentValues cvSubcategoria(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("subcategoria");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(subcategoria.id_subcategoria, e.getString(subcategoria.id_subcategoria));
			values.put(subcategoria.nombre_subcategoria, e.getString(subcategoria.nombre_subcategoria));
			values.put(subcategoria.descripcion_subcategoria, e.getString(subcategoria.descripcion_subcategoria));
			values.put(subcategoria.categoria_id_categoria, e.getString(subcategoria.categoria_id_categoria));
		}
		return values;
	}
	public ContentValues cvSubrubro(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("subrubro");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(subrubro.id_subrubro, e.getString(subrubro.id_subrubro));
			values.put(subrubro.nombre_subrubro, e.getString(subrubro.nombre_subrubro));
			values.put(subrubro.rubro_id_rubro, e.getString(subrubro.rubro_id_rubro));
		}
		return values;
	}
	public ContentValues cvTalla(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("talla");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(talla.id_talla, e.getString(talla.id_talla));
			values.put(talla.am_largo, e.getString(talla.am_largo));
			values.put(talla.am_ancho, e.getString(talla.am_ancho));
			values.put(talla.am_fondo, e.getString(talla.am_fondo));
			values.put(talla.eu_largo, e.getString(talla.eu_largo));
			values.put(talla.eu_ancho, e.getString(talla.eu_ancho));
			values.put(talla.eu_fondo, e.getString(talla.eu_fondo));
			values.put(talla.num_largo, e.getString(talla.num_largo));
			values.put(talla.num_ancho, e.getString(talla.num_ancho));
			values.put(talla.num_fondo, e.getString(talla.num_fondo));
			values.put(talla.producto_id_producto, e.getString(talla.producto_id_producto));
		}
		return values;
	}
	public ContentValues cvTipo_documento(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("tipo_documento");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(tipo_documento.id_tipo_documento, e.getString(tipo_documento.id_tipo_documento));
			values.put(tipo_documento.nombre_tipo_documento, e.getString(tipo_documento.nombre_tipo_documento));
		}
		return values;
	}
	public ContentValues cvTipo_empresa(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("tipo_empresa");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(tipo_empresa.id_tipo_empresa, e.getString(tipo_empresa.id_tipo_empresa));
			values.put(tipo_empresa.nombre_tipo_empresa, e.getString(tipo_empresa.nombre_tipo_empresa));
			values.put(tipo_empresa.categoria_empresa_id_categoria_empresa, e.getString(tipo_empresa.categoria_empresa_id_categoria_empresa));
		}
		return values;
	}
	public ContentValues cvTipo_pago(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("tipo_pago");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(tipo_pago.id_tipo_pago, e.getString(tipo_pago.id_tipo_pago));
			values.put(tipo_pago.nombre_tipo_pago, e.getString(tipo_pago.nombre_tipo_pago));
			values.put(tipo_pago.comision_tipo_pago, e.getString(tipo_pago.comision_tipo_pago));
		}
		return values;
	}
	public ContentValues cvTipo_producto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("tipo_producto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(tipo_producto.id_tipo_producto, e.getString(tipo_producto.id_tipo_producto));
			values.put(tipo_producto.nombre_tipo_producto, e.getString(tipo_producto.nombre_tipo_producto));
		}
		return values;
	}
	public ContentValues cvTipo_usuario(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("tipo_usuario");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(tipo_usuario.id_tipo_usuario, e.getString(tipo_usuario.id_tipo_usuario));
			values.put(tipo_usuario.nombre_tipo_usuario, e.getString(tipo_usuario.nombre_tipo_usuario));
		}
		return values;
	}
	public ContentValues cvUbicacion(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("ubicacion");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(ubicacion.id_ubicacion, e.getString(ubicacion.id_ubicacion));
			values.put(ubicacion.numero_ubicacion, e.getString(ubicacion.numero_ubicacion));
			values.put(ubicacion.numero_interior, e.getString(ubicacion.numero_interior));
			values.put(ubicacion.telefono_ubicacion, e.getString(ubicacion.telefono_ubicacion));
			values.put(ubicacion.default_ubicacion, e.getString(ubicacion.default_ubicacion));
			values.put(ubicacion.calle_id_calle, e.getString(ubicacion.calle_id_calle));
			values.put(ubicacion.empresa_id_empresa, e.getString(ubicacion.empresa_id_empresa));
			values.put(ubicacion.usuario_id_usuario, e.getString(ubicacion.usuario_id_usuario));
		}
		return values;
	}
	public ContentValues cvUsuario(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("usuario");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(usuario.id_usuario, e.getString(usuario.id_usuario));
			values.put(usuario.tipo_usuario, e.getString(usuario.tipo_usuario));
			values.put(usuario.nombre_usuario, e.getString(usuario.nombre_usuario));
			values.put(usuario.clave, e.getString(usuario.clave));
			values.put(usuario.cliente_id_cliente, e.getString(usuario.cliente_id_cliente));
			values.put(usuario.cliente_empresa_id_cliente_empresa, e.getString(usuario.cliente_empresa_id_cliente_empresa));
		}
		return values;
	}
	public ContentValues cvUsuariocompleto(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("usuariocompleto");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(usuariocompleto.id_persona, e.getString(usuariocompleto.id_persona));
			values.put(usuariocompleto.rut_persona, e.getString(usuariocompleto.rut_persona));
			values.put(usuariocompleto.digito_verificador, e.getString(usuariocompleto.digito_verificador));
			values.put(usuariocompleto.nombre_persona, e.getString(usuariocompleto.nombre_persona));
			values.put(usuariocompleto.segundo_nombre_persona, e.getString(usuariocompleto.segundo_nombre_persona));
			values.put(usuariocompleto.apellido_persona, e.getString(usuariocompleto.apellido_persona));
			values.put(usuariocompleto.segundo_apellido_persona, e.getString(usuariocompleto.segundo_apellido_persona));
			values.put(usuariocompleto.actividad, e.getString(usuariocompleto.actividad));
			values.put(usuariocompleto.area_actividad, e.getString(usuariocompleto.area_actividad));
			values.put(usuariocompleto.dia_fecha_nacimiento, e.getString(usuariocompleto.dia_fecha_nacimiento));
			values.put(usuariocompleto.mes_fecha_nacimiento, e.getString(usuariocompleto.mes_fecha_nacimiento));
			values.put(usuariocompleto.ano_fecha_nacimiento, e.getString(usuariocompleto.ano_fecha_nacimiento));
			values.put(usuariocompleto.edad, e.getString(usuariocompleto.edad));
			values.put(usuariocompleto.email, e.getString(usuariocompleto.email));
			values.put(usuariocompleto.celular, e.getString(usuariocompleto.celular));
			values.put(usuariocompleto.telefono, e.getString(usuariocompleto.telefono));
			values.put(usuariocompleto.id_carne_empresa, e.getString(usuariocompleto.id_carne_empresa));
			values.put(usuariocompleto.nombre_usuario, e.getString(usuariocompleto.nombre_usuario));
			values.put(usuariocompleto.clave_usuario, e.getString(usuariocompleto.clave_usuario));
			values.put(usuariocompleto.empresa_id_empresa, e.getString(usuariocompleto.empresa_id_empresa));
			values.put(usuariocompleto.persona_id_persona, e.getString(usuariocompleto.persona_id_persona));
			values.put(usuariocompleto.tipo_usuario_id_tipo_usuario, e.getString(usuariocompleto.tipo_usuario_id_tipo_usuario));
		}
		return values;
	}
	public ContentValues cvValor_nutricional(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("valor_nutricional");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(valor_nutricional.id_valor_nutricional, e.getString(valor_nutricional.id_valor_nutricional));
			values.put(valor_nutricional.nombre_valor, e.getString(valor_nutricional.nombre_valor));
			values.put(valor_nutricional.cantidad, e.getString(valor_nutricional.cantidad));
			values.put(valor_nutricional.valor_diario_total, e.getString(valor_nutricional.valor_diario_total));
			values.put(valor_nutricional.porcentaje_requerimientos, e.getString(valor_nutricional.porcentaje_requerimientos));
			values.put(valor_nutricional.producto_id_producto, e.getString(valor_nutricional.producto_id_producto));
		}
		return values;
	}
	public ContentValues cvVenta(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("venta");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(venta.id_venta, e.getString(venta.id_venta));
			values.put(venta.numero_articulos, e.getString(venta.numero_articulos));
			values.put(venta.total, e.getString(venta.total));
			values.put(venta.dia_fecha_venta, e.getString(venta.dia_fecha_venta));
			values.put(venta.mes_fecha_venta, e.getString(venta.mes_fecha_venta));
			values.put(venta.anno_fecha_venta, e.getString(venta.anno_fecha_venta));
			values.put(venta.hora_fecha_venta, e.getString(venta.hora_fecha_venta));
			values.put(venta.usuario_id_usuario, e.getString(venta.usuario_id_usuario));
			values.put(venta.carne_empresa_id_carne_empresa, e.getString(venta.carne_empresa_id_carne_empresa));
			values.put(venta.tipo_pago_id_tipo_pago, e.getString(venta.tipo_pago_id_tipo_pago));
			values.put(venta.tipo_documento_id_tipo_documento, e.getString(venta.tipo_documento_id_tipo_documento));
		}
		return values;
	}
	public ContentValues cvVentacompleta(JSONObject json) throws JSONException 
	{
		JSONArray jArray;
		jArray = json.getJSONArray("ventacompleta");
		ContentValues values;
		values = new ContentValues();
		for(int i=0;i < jArray.length();i++)
		{
			JSONObject e = jArray.getJSONObject(i);
			values.put(ventacompleta.id_venta, e.getString(ventacompleta.id_venta));
			values.put(ventacompleta.numero_articulos, e.getString(ventacompleta.numero_articulos));
			values.put(ventacompleta.total, e.getString(ventacompleta.total));
			values.put(ventacompleta.dia_fecha_venta, e.getString(ventacompleta.dia_fecha_venta));
			values.put(ventacompleta.mes_fecha_venta, e.getString(ventacompleta.mes_fecha_venta));
			values.put(ventacompleta.anno_fecha_venta, e.getString(ventacompleta.anno_fecha_venta));
			values.put(ventacompleta.hora_fecha_venta, e.getString(ventacompleta.hora_fecha_venta));
			values.put(ventacompleta.usuario_id_usuario, e.getString(ventacompleta.usuario_id_usuario));
			values.put(ventacompleta.carne_empresa_id_carne_empresa, e.getString(ventacompleta.carne_empresa_id_carne_empresa));
			values.put(ventacompleta.tipo_pago_id_tipo_pago, e.getString(ventacompleta.tipo_pago_id_tipo_pago));
			values.put(ventacompleta.tipo_documento_id_tipo_documento, e.getString(ventacompleta.tipo_documento_id_tipo_documento));
			values.put(ventacompleta.id_tipo_pago, e.getString(ventacompleta.id_tipo_pago));
			values.put(ventacompleta.nombre_tipo_pago, e.getString(ventacompleta.nombre_tipo_pago));
			values.put(ventacompleta.comision_tipo_pago, e.getString(ventacompleta.comision_tipo_pago));
			values.put(ventacompleta.id_tipo_documento, e.getString(ventacompleta.id_tipo_documento));
			values.put(ventacompleta.nombre_tipo_documento, e.getString(ventacompleta.nombre_tipo_documento));
		}
		return values;
	}

}
