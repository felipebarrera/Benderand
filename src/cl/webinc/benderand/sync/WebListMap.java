package cl.webinc.benderand.sync;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import cl.webinc.benderand.provider.Base.*;

public class WebListMap 
{
	public String TAG = "WebListMap";
	public ArrayList<HashMap<String, String>> jsonToHashMap(JSONObject json, String funcion) throws JSONException
	{
		Log.e(TAG, funcion);
		JSONArray jArray;
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

		if(funcion.equals("actividad"))
		{
			jArray = json.getJSONArray("actividad");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(actividad.id_actividad, e.getString(actividad.id_actividad));
				map.put(actividad.nombre_actividad, e.getString(actividad.nombre_actividad));
				map.put(actividad.codigo_actividad, e.getString(actividad.codigo_actividad));
				map.put(actividad.categoria_actividad, e.getString(actividad.categoria_actividad));
				map.put(actividad.afectoiva_actividad, e.getString(actividad.afectoiva_actividad));
				map.put(actividad.disponible_internet_actividad, e.getString(actividad.disponible_internet_actividad));
				map.put(actividad.subrubro_id_subrubro, e.getString(actividad.subrubro_id_subrubro));
				mylist.add(map);
			}
		}

		if(funcion.equals("calle"))
		{
			jArray = json.getJSONArray("calle");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(calle.id_calle, e.getString(calle.id_calle));
				map.put(calle.nombre_calle, e.getString(calle.nombre_calle));
				map.put(calle.comuna_id_comuna, e.getString(calle.comuna_id_comuna));
				mylist.add(map);
			}
		}

		if(funcion.equals("caracteristica"))
		{
			jArray = json.getJSONArray("caracteristica");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(caracteristica.id_caracteristica, e.getString(caracteristica.id_caracteristica));
				map.put(caracteristica.numero_caracteristica, e.getString(caracteristica.numero_caracteristica));
				map.put(caracteristica.caracteristica, e.getString(caracteristica.caracteristica));
				map.put(caracteristica.valor_caracteristica, e.getString(caracteristica.valor_caracteristica));
				map.put(caracteristica.producto_id_producto, e.getString(caracteristica.producto_id_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("carne_empresa"))
		{
			jArray = json.getJSONArray("carne_empresa");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carne_empresa.id_carne_empresa, e.getString(carne_empresa.id_carne_empresa));
				map.put(carne_empresa.nombre_usuario, e.getString(carne_empresa.nombre_usuario));
				map.put(carne_empresa.clave_usuario, e.getString(carne_empresa.clave_usuario));
				map.put(carne_empresa.empresa_id_empresa, e.getString(carne_empresa.empresa_id_empresa));
				map.put(carne_empresa.persona_id_persona, e.getString(carne_empresa.persona_id_persona));
				map.put(carne_empresa.tipo_usuario_id_tipo_usuario, e.getString(carne_empresa.tipo_usuario_id_tipo_usuario));
				mylist.add(map);
			}
		}

		if(funcion.equals("carne_empresacompleto"))
		{
			jArray = json.getJSONArray("carne_empresacompleto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carne_empresacompleto.id_carne_empresa, e.getString(carne_empresacompleto.id_carne_empresa));
				map.put(carne_empresacompleto.nombre_usuario, e.getString(carne_empresacompleto.nombre_usuario));
				map.put(carne_empresacompleto.clave_usuario, e.getString(carne_empresacompleto.clave_usuario));
				map.put(carne_empresacompleto.tipo_usuario_id_tipo_usuario, e.getString(carne_empresacompleto.tipo_usuario_id_tipo_usuario));
				map.put(carne_empresacompleto.id_empresa, e.getString(carne_empresacompleto.id_empresa));
				map.put(carne_empresacompleto.rut_empresa, e.getString(carne_empresacompleto.rut_empresa));
				map.put(carne_empresacompleto.digito_verificador_empresa, e.getString(carne_empresacompleto.digito_verificador_empresa));
				map.put(carne_empresacompleto.nombre_empresa, e.getString(carne_empresacompleto.nombre_empresa));
				map.put(carne_empresacompleto.nombre_contacto_empresa, e.getString(carne_empresacompleto.nombre_contacto_empresa));
				map.put(carne_empresacompleto.cargo_contacto_empresa, e.getString(carne_empresacompleto.cargo_contacto_empresa));
				map.put(carne_empresacompleto.email_empresa, e.getString(carne_empresacompleto.email_empresa));
				map.put(carne_empresacompleto.alcance_empresa, e.getString(carne_empresacompleto.alcance_empresa));
				map.put(carne_empresacompleto.telefono_empresa, e.getString(carne_empresacompleto.telefono_empresa));
				map.put(carne_empresacompleto.actividad_id_actividad, e.getString(carne_empresacompleto.actividad_id_actividad));
				map.put(carne_empresacompleto.id_persona, e.getString(carne_empresacompleto.id_persona));
				map.put(carne_empresacompleto.rut_persona, e.getString(carne_empresacompleto.rut_persona));
				map.put(carne_empresacompleto.digito_verificador, e.getString(carne_empresacompleto.digito_verificador));
				map.put(carne_empresacompleto.nombre_persona, e.getString(carne_empresacompleto.nombre_persona));
				map.put(carne_empresacompleto.segundo_nombre_persona, e.getString(carne_empresacompleto.segundo_nombre_persona));
				map.put(carne_empresacompleto.apellido_persona, e.getString(carne_empresacompleto.apellido_persona));
				map.put(carne_empresacompleto.segundo_apellido_persona, e.getString(carne_empresacompleto.segundo_apellido_persona));
				map.put(carne_empresacompleto.actividad, e.getString(carne_empresacompleto.actividad));
				map.put(carne_empresacompleto.area_actividad, e.getString(carne_empresacompleto.area_actividad));
				map.put(carne_empresacompleto.dia_fecha_nacimiento, e.getString(carne_empresacompleto.dia_fecha_nacimiento));
				map.put(carne_empresacompleto.mes_fecha_nacimiento, e.getString(carne_empresacompleto.mes_fecha_nacimiento));
				map.put(carne_empresacompleto.ano_fecha_nacimiento, e.getString(carne_empresacompleto.ano_fecha_nacimiento));
				map.put(carne_empresacompleto.edad, e.getString(carne_empresacompleto.edad));
				map.put(carne_empresacompleto.email, e.getString(carne_empresacompleto.email));
				map.put(carne_empresacompleto.celular, e.getString(carne_empresacompleto.celular));
				map.put(carne_empresacompleto.telefono, e.getString(carne_empresacompleto.telefono));
				mylist.add(map);
			}
		}

		if(funcion.equals("carro_compras"))
		{
			jArray = json.getJSONArray("carro_compras");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carro_compras.id_carro_compras, e.getString(carro_compras.id_carro_compras));
				map.put(carro_compras.cantidad_carro, e.getString(carro_compras.cantidad_carro));
				map.put(carro_compras.precio_carro, e.getString(carro_compras.precio_carro));
				map.put(carro_compras.mayor, e.getString(carro_compras.mayor));
				map.put(carro_compras.tienda, e.getString(carro_compras.tienda));
				map.put(carro_compras.usuario_id_usuario, e.getString(carro_compras.usuario_id_usuario));
				map.put(carro_compras.producto_id_producto, e.getString(carro_compras.producto_id_producto));
				map.put(carro_compras.empresa_id_empresa, e.getString(carro_compras.empresa_id_empresa));
				map.put(carro_compras.usado, e.getString(carro_compras.usado));
				map.put(carro_compras.carne_empresa_id_carne_empresa, e.getString(carro_compras.carne_empresa_id_carne_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("carro_comprascompleto"))
		{
			jArray = json.getJSONArray("carro_comprascompleto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carro_comprascompleto.id_carro_compras, e.getString(carro_comprascompleto.id_carro_compras));
				map.put(carro_comprascompleto.cantidad_carro, e.getString(carro_comprascompleto.cantidad_carro));
				map.put(carro_comprascompleto.precio_carro, e.getString(carro_comprascompleto.precio_carro));
				map.put(carro_comprascompleto.mayor, e.getString(carro_comprascompleto.mayor));
				map.put(carro_comprascompleto.tienda, e.getString(carro_comprascompleto.tienda));
				map.put(carro_comprascompleto.usuario_id_usuario, e.getString(carro_comprascompleto.usuario_id_usuario));
				map.put(carro_comprascompleto.usado, e.getString(carro_comprascompleto.usado));
				map.put(carro_comprascompleto.carne_empresa_id_carne_empresa, e.getString(carro_comprascompleto.carne_empresa_id_carne_empresa));
				map.put(carro_comprascompleto.id_precio, e.getString(carro_comprascompleto.id_precio));
				map.put(carro_comprascompleto.precio_CLP, e.getString(carro_comprascompleto.precio_CLP));
				map.put(carro_comprascompleto.precio_us, e.getString(carro_comprascompleto.precio_us));
				map.put(carro_comprascompleto.precio_mayor_CLP, e.getString(carro_comprascompleto.precio_mayor_CLP));
				map.put(carro_comprascompleto.precio_mayor_us, e.getString(carro_comprascompleto.precio_mayor_us));
				map.put(carro_comprascompleto.precio_actual, e.getString(carro_comprascompleto.precio_actual));
				map.put(carro_comprascompleto.descuento_promocion, e.getString(carro_comprascompleto.descuento_promocion));
				map.put(carro_comprascompleto.cantidad_mayor, e.getString(carro_comprascompleto.cantidad_mayor));
				map.put(carro_comprascompleto.id_producto, e.getString(carro_comprascompleto.id_producto));
				map.put(carro_comprascompleto.codigo_producto, e.getString(carro_comprascompleto.codigo_producto));
				map.put(carro_comprascompleto.numero_serie, e.getString(carro_comprascompleto.numero_serie));
				map.put(carro_comprascompleto.descripcion_producto, e.getString(carro_comprascompleto.descripcion_producto));
				map.put(carro_comprascompleto.nombre_producto, e.getString(carro_comprascompleto.nombre_producto));
				map.put(carro_comprascompleto.marca_producto, e.getString(carro_comprascompleto.marca_producto));
				map.put(carro_comprascompleto.modelo_producto, e.getString(carro_comprascompleto.modelo_producto));
				map.put(carro_comprascompleto.contenido_unidad, e.getString(carro_comprascompleto.contenido_unidad));
				map.put(carro_comprascompleto.unidad_minima, e.getString(carro_comprascompleto.unidad_minima));
				map.put(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(carro_comprascompleto.contenido, e.getString(carro_comprascompleto.contenido));
				map.put(carro_comprascompleto.peso_neto, e.getString(carro_comprascompleto.peso_neto));
				map.put(carro_comprascompleto.alto_cm, e.getString(carro_comprascompleto.alto_cm));
				map.put(carro_comprascompleto.ancho_cm, e.getString(carro_comprascompleto.ancho_cm));
				map.put(carro_comprascompleto.fondo_cm, e.getString(carro_comprascompleto.fondo_cm));
				map.put(carro_comprascompleto.fabricante, e.getString(carro_comprascompleto.fabricante));
				map.put(carro_comprascompleto.familia_necesidad_id_familia_necesidad, e.getString(carro_comprascompleto.familia_necesidad_id_familia_necesidad));
				map.put(carro_comprascompleto.familia_producto_id_familia_producto, e.getString(carro_comprascompleto.familia_producto_id_familia_producto));
				map.put(carro_comprascompleto.clase_producto, e.getString(carro_comprascompleto.clase_producto));
				map.put(carro_comprascompleto.linea_producto, e.getString(carro_comprascompleto.linea_producto));
				map.put(carro_comprascompleto.tipo_producto_id_tipo_producto, e.getString(carro_comprascompleto.tipo_producto_id_tipo_producto));
				map.put(carro_comprascompleto.hot, e.getString(carro_comprascompleto.hot));
				map.put(carro_comprascompleto.subcategoria_id_subcategoria, e.getString(carro_comprascompleto.subcategoria_id_subcategoria));
				map.put(carro_comprascompleto.SKU, e.getString(carro_comprascompleto.SKU));
				map.put(carro_comprascompleto.formato_producto_id_formato_producto, e.getString(carro_comprascompleto.formato_producto_id_formato_producto));
				map.put(carro_comprascompleto.stock_tienda, e.getString(carro_comprascompleto.stock_tienda));
				mylist.add(map);
			}
		}

		if(funcion.equals("carro_egresos"))
		{
			jArray = json.getJSONArray("carro_egresos");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carro_egresos.id_carro_egresos, e.getString(carro_egresos.id_carro_egresos));
				map.put(carro_egresos.cantidad_carro, e.getString(carro_egresos.cantidad_carro));
				map.put(carro_egresos.precio_carro, e.getString(carro_egresos.precio_carro));
				map.put(carro_egresos.mayor, e.getString(carro_egresos.mayor));
				map.put(carro_egresos.tienda, e.getString(carro_egresos.tienda));
				map.put(carro_egresos.usado, e.getString(carro_egresos.usado));
				map.put(carro_egresos.producto_id_producto, e.getString(carro_egresos.producto_id_producto));
				map.put(carro_egresos.usuario_id_usuario, e.getString(carro_egresos.usuario_id_usuario));
				map.put(carro_egresos.empresa_id_empresa, e.getString(carro_egresos.empresa_id_empresa));
				map.put(carro_egresos.carne_empresa_id_carne_empresa, e.getString(carro_egresos.carne_empresa_id_carne_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("carro_egresoscompleto"))
		{
			jArray = json.getJSONArray("carro_egresoscompleto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carro_egresoscompleto.id_carro_egresos, e.getString(carro_egresoscompleto.id_carro_egresos));
				map.put(carro_egresoscompleto.cantidad_carro, e.getString(carro_egresoscompleto.cantidad_carro));
				map.put(carro_egresoscompleto.precio_carro, e.getString(carro_egresoscompleto.precio_carro));
				map.put(carro_egresoscompleto.mayor, e.getString(carro_egresoscompleto.mayor));
				map.put(carro_egresoscompleto.tienda, e.getString(carro_egresoscompleto.tienda));
				map.put(carro_egresoscompleto.usuario_id_usuario, e.getString(carro_egresoscompleto.usuario_id_usuario));
				map.put(carro_egresoscompleto.usado, e.getString(carro_egresoscompleto.usado));
				map.put(carro_egresoscompleto.carne_empresa_id_carne_empresa, e.getString(carro_egresoscompleto.carne_empresa_id_carne_empresa));
				map.put(carro_egresoscompleto.id_producto, e.getString(carro_egresoscompleto.id_producto));
				map.put(carro_egresoscompleto.codigo_producto, e.getString(carro_egresoscompleto.codigo_producto));
				map.put(carro_egresoscompleto.numero_serie, e.getString(carro_egresoscompleto.numero_serie));
				map.put(carro_egresoscompleto.descripcion_producto, e.getString(carro_egresoscompleto.descripcion_producto));
				map.put(carro_egresoscompleto.nombre_producto, e.getString(carro_egresoscompleto.nombre_producto));
				map.put(carro_egresoscompleto.marca_producto, e.getString(carro_egresoscompleto.marca_producto));
				map.put(carro_egresoscompleto.modelo_producto, e.getString(carro_egresoscompleto.modelo_producto));
				map.put(carro_egresoscompleto.contenido_unidad, e.getString(carro_egresoscompleto.contenido_unidad));
				map.put(carro_egresoscompleto.unidad_minima, e.getString(carro_egresoscompleto.unidad_minima));
				map.put(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(carro_egresoscompleto.contenido, e.getString(carro_egresoscompleto.contenido));
				map.put(carro_egresoscompleto.peso_neto, e.getString(carro_egresoscompleto.peso_neto));
				map.put(carro_egresoscompleto.alto_cm, e.getString(carro_egresoscompleto.alto_cm));
				map.put(carro_egresoscompleto.ancho_cm, e.getString(carro_egresoscompleto.ancho_cm));
				map.put(carro_egresoscompleto.fondo_cm, e.getString(carro_egresoscompleto.fondo_cm));
				map.put(carro_egresoscompleto.fabricante, e.getString(carro_egresoscompleto.fabricante));
				map.put(carro_egresoscompleto.familia_necesidad_id_familia_necesidad, e.getString(carro_egresoscompleto.familia_necesidad_id_familia_necesidad));
				map.put(carro_egresoscompleto.familia_producto_id_familia_producto, e.getString(carro_egresoscompleto.familia_producto_id_familia_producto));
				map.put(carro_egresoscompleto.clase_producto, e.getString(carro_egresoscompleto.clase_producto));
				map.put(carro_egresoscompleto.linea_producto, e.getString(carro_egresoscompleto.linea_producto));
				map.put(carro_egresoscompleto.tipo_producto_id_tipo_producto, e.getString(carro_egresoscompleto.tipo_producto_id_tipo_producto));
				map.put(carro_egresoscompleto.hot, e.getString(carro_egresoscompleto.hot));
				map.put(carro_egresoscompleto.subcategoria_id_subcategoria, e.getString(carro_egresoscompleto.subcategoria_id_subcategoria));
				map.put(carro_egresoscompleto.SKU, e.getString(carro_egresoscompleto.SKU));
				map.put(carro_egresoscompleto.formato_producto_id_formato_producto, e.getString(carro_egresoscompleto.formato_producto_id_formato_producto));
				map.put(carro_egresoscompleto.stock_tienda, e.getString(carro_egresoscompleto.stock_tienda));
				map.put(carro_egresoscompleto.precio_CLP, e.getString(carro_egresoscompleto.precio_CLP));
				mylist.add(map);
			}
		}

		if(funcion.equals("carro_egresosproducto"))
		{
			jArray = json.getJSONArray("carro_egresosproducto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carro_egresosproducto.id_carro_egresos, e.getString(carro_egresosproducto.id_carro_egresos));
				map.put(carro_egresosproducto.cantidad_carro, e.getString(carro_egresosproducto.cantidad_carro));
				map.put(carro_egresosproducto.precio_carro, e.getString(carro_egresosproducto.precio_carro));
				map.put(carro_egresosproducto.mayor, e.getString(carro_egresosproducto.mayor));
				map.put(carro_egresosproducto.tienda, e.getString(carro_egresosproducto.tienda));
				map.put(carro_egresosproducto.usuario_id_usuario, e.getString(carro_egresosproducto.usuario_id_usuario));
				map.put(carro_egresosproducto.usado, e.getString(carro_egresosproducto.usado));
				map.put(carro_egresosproducto.carne_empresa_id_carne_empresa, e.getString(carro_egresosproducto.carne_empresa_id_carne_empresa));
				map.put(carro_egresosproducto.id_producto, e.getString(carro_egresosproducto.id_producto));
				map.put(carro_egresosproducto.codigo_producto, e.getString(carro_egresosproducto.codigo_producto));
				map.put(carro_egresosproducto.numero_serie, e.getString(carro_egresosproducto.numero_serie));
				map.put(carro_egresosproducto.descripcion_producto, e.getString(carro_egresosproducto.descripcion_producto));
				map.put(carro_egresosproducto.nombre_producto, e.getString(carro_egresosproducto.nombre_producto));
				map.put(carro_egresosproducto.marca_producto, e.getString(carro_egresosproducto.marca_producto));
				map.put(carro_egresosproducto.modelo_producto, e.getString(carro_egresosproducto.modelo_producto));
				map.put(carro_egresosproducto.contenido_unidad, e.getString(carro_egresosproducto.contenido_unidad));
				map.put(carro_egresosproducto.unidad_minima, e.getString(carro_egresosproducto.unidad_minima));
				map.put(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(carro_egresosproducto.contenido, e.getString(carro_egresosproducto.contenido));
				map.put(carro_egresosproducto.peso_neto, e.getString(carro_egresosproducto.peso_neto));
				map.put(carro_egresosproducto.alto_cm, e.getString(carro_egresosproducto.alto_cm));
				map.put(carro_egresosproducto.ancho_cm, e.getString(carro_egresosproducto.ancho_cm));
				map.put(carro_egresosproducto.fondo_cm, e.getString(carro_egresosproducto.fondo_cm));
				map.put(carro_egresosproducto.fabricante, e.getString(carro_egresosproducto.fabricante));
				map.put(carro_egresosproducto.familia_necesidad_id_familia_necesidad, e.getString(carro_egresosproducto.familia_necesidad_id_familia_necesidad));
				map.put(carro_egresosproducto.familia_producto_id_familia_producto, e.getString(carro_egresosproducto.familia_producto_id_familia_producto));
				map.put(carro_egresosproducto.clase_producto, e.getString(carro_egresosproducto.clase_producto));
				map.put(carro_egresosproducto.linea_producto, e.getString(carro_egresosproducto.linea_producto));
				map.put(carro_egresosproducto.tipo_producto_id_tipo_producto, e.getString(carro_egresosproducto.tipo_producto_id_tipo_producto));
				map.put(carro_egresosproducto.hot, e.getString(carro_egresosproducto.hot));
				map.put(carro_egresosproducto.subcategoria_id_subcategoria, e.getString(carro_egresosproducto.subcategoria_id_subcategoria));
				map.put(carro_egresosproducto.SKU, e.getString(carro_egresosproducto.SKU));
				map.put(carro_egresosproducto.formato_producto_id_formato_producto, e.getString(carro_egresosproducto.formato_producto_id_formato_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("carro_venta"))
		{
			jArray = json.getJSONArray("carro_venta");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carro_venta.id_carro_venta, e.getString(carro_venta.id_carro_venta));
				map.put(carro_venta.cantidad, e.getString(carro_venta.cantidad));
				map.put(carro_venta.precio, e.getString(carro_venta.precio));
				map.put(carro_venta.carro_compras_id_carro_compras, e.getString(carro_venta.carro_compras_id_carro_compras));
				map.put(carro_venta.venta_id_venta, e.getString(carro_venta.venta_id_venta));
				mylist.add(map);
			}
		}

		if(funcion.equals("carro_ventacompleto"))
		{
			jArray = json.getJSONArray("carro_ventacompleto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(carro_ventacompleto.id_carro_venta, e.getString(carro_ventacompleto.id_carro_venta));
				map.put(carro_ventacompleto.cantidad, e.getString(carro_ventacompleto.cantidad));
				map.put(carro_ventacompleto.precio, e.getString(carro_ventacompleto.precio));
				map.put(carro_ventacompleto.venta_id_venta, e.getString(carro_ventacompleto.venta_id_venta));
				map.put(carro_ventacompleto.id_carro_compras, e.getString(carro_ventacompleto.id_carro_compras));
				map.put(carro_ventacompleto.cantidad_carro, e.getString(carro_ventacompleto.cantidad_carro));
				map.put(carro_ventacompleto.precio_carro, e.getString(carro_ventacompleto.precio_carro));
				map.put(carro_ventacompleto.mayor, e.getString(carro_ventacompleto.mayor));
				map.put(carro_ventacompleto.tienda, e.getString(carro_ventacompleto.tienda));
				map.put(carro_ventacompleto.usuario_id_usuario, e.getString(carro_ventacompleto.usuario_id_usuario));
				map.put(carro_ventacompleto.usado, e.getString(carro_ventacompleto.usado));
				map.put(carro_ventacompleto.carne_empresa_id_carne_empresa, e.getString(carro_ventacompleto.carne_empresa_id_carne_empresa));
				map.put(carro_ventacompleto.id_precio, e.getString(carro_ventacompleto.id_precio));
				map.put(carro_ventacompleto.precio_CLP, e.getString(carro_ventacompleto.precio_CLP));
				map.put(carro_ventacompleto.precio_us, e.getString(carro_ventacompleto.precio_us));
				map.put(carro_ventacompleto.precio_mayor_CLP, e.getString(carro_ventacompleto.precio_mayor_CLP));
				map.put(carro_ventacompleto.precio_mayor_us, e.getString(carro_ventacompleto.precio_mayor_us));
				map.put(carro_ventacompleto.precio_actual, e.getString(carro_ventacompleto.precio_actual));
				map.put(carro_ventacompleto.descuento_promocion, e.getString(carro_ventacompleto.descuento_promocion));
				map.put(carro_ventacompleto.cantidad_mayor, e.getString(carro_ventacompleto.cantidad_mayor));
				map.put(carro_ventacompleto.id_producto, e.getString(carro_ventacompleto.id_producto));
				map.put(carro_ventacompleto.codigo_producto, e.getString(carro_ventacompleto.codigo_producto));
				map.put(carro_ventacompleto.numero_serie, e.getString(carro_ventacompleto.numero_serie));
				map.put(carro_ventacompleto.descripcion_producto, e.getString(carro_ventacompleto.descripcion_producto));
				map.put(carro_ventacompleto.nombre_producto, e.getString(carro_ventacompleto.nombre_producto));
				map.put(carro_ventacompleto.marca_producto, e.getString(carro_ventacompleto.marca_producto));
				map.put(carro_ventacompleto.modelo_producto, e.getString(carro_ventacompleto.modelo_producto));
				map.put(carro_ventacompleto.contenido_unidad, e.getString(carro_ventacompleto.contenido_unidad));
				map.put(carro_ventacompleto.unidad_minima, e.getString(carro_ventacompleto.unidad_minima));
				map.put(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(carro_ventacompleto.contenido, e.getString(carro_ventacompleto.contenido));
				map.put(carro_ventacompleto.peso_neto, e.getString(carro_ventacompleto.peso_neto));
				map.put(carro_ventacompleto.alto_cm, e.getString(carro_ventacompleto.alto_cm));
				map.put(carro_ventacompleto.ancho_cm, e.getString(carro_ventacompleto.ancho_cm));
				map.put(carro_ventacompleto.fondo_cm, e.getString(carro_ventacompleto.fondo_cm));
				map.put(carro_ventacompleto.fabricante, e.getString(carro_ventacompleto.fabricante));
				map.put(carro_ventacompleto.familia_necesidad_id_familia_necesidad, e.getString(carro_ventacompleto.familia_necesidad_id_familia_necesidad));
				map.put(carro_ventacompleto.familia_producto_id_familia_producto, e.getString(carro_ventacompleto.familia_producto_id_familia_producto));
				map.put(carro_ventacompleto.clase_producto, e.getString(carro_ventacompleto.clase_producto));
				map.put(carro_ventacompleto.linea_producto, e.getString(carro_ventacompleto.linea_producto));
				map.put(carro_ventacompleto.tipo_producto_id_tipo_producto, e.getString(carro_ventacompleto.tipo_producto_id_tipo_producto));
				map.put(carro_ventacompleto.hot, e.getString(carro_ventacompleto.hot));
				map.put(carro_ventacompleto.subcategoria_id_subcategoria, e.getString(carro_ventacompleto.subcategoria_id_subcategoria));
				map.put(carro_ventacompleto.SKU, e.getString(carro_ventacompleto.SKU));
				map.put(carro_ventacompleto.formato_producto_id_formato_producto, e.getString(carro_ventacompleto.formato_producto_id_formato_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("categoria"))
		{
			jArray = json.getJSONArray("categoria");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(categoria.id_categoria, e.getString(categoria.id_categoria));
				map.put(categoria.nombre_categoria, e.getString(categoria.nombre_categoria));
				mylist.add(map);
			}
		}

		if(funcion.equals("categoria_empresa"))
		{
			jArray = json.getJSONArray("categoria_empresa");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(categoria_empresa.id_categoria_empresa, e.getString(categoria_empresa.id_categoria_empresa));
				map.put(categoria_empresa.nombre_categoria_empresa, e.getString(categoria_empresa.nombre_categoria_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("ci_sessions"))
		{
			jArray = json.getJSONArray("ci_sessions");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(ci_sessions.session_id, e.getString(ci_sessions.session_id));
				map.put(ci_sessions.ip_address, e.getString(ci_sessions.ip_address));
				map.put(ci_sessions.user_agent, e.getString(ci_sessions.user_agent));
				map.put(ci_sessions.id_user, e.getString(ci_sessions.id_user));
				map.put(ci_sessions.nombre_apellido, e.getString(ci_sessions.nombre_apellido));
				map.put(ci_sessions.email_user, e.getString(ci_sessions.email_user));
				map.put(ci_sessions.last_activity, e.getString(ci_sessions.last_activity));
				map.put(ci_sessions.user_data, e.getString(ci_sessions.user_data));
				mylist.add(map);
			}
		}

		if(funcion.equals("cliente"))
		{
			jArray = json.getJSONArray("cliente");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(cliente.id_cliente, e.getString(cliente.id_cliente));
				map.put(cliente.rut_cliente, e.getString(cliente.rut_cliente));
				map.put(cliente.digito_verificador, e.getString(cliente.digito_verificador));
				map.put(cliente.nombre_cliente, e.getString(cliente.nombre_cliente));
				map.put(cliente.segundo_nombre_cliente, e.getString(cliente.segundo_nombre_cliente));
				map.put(cliente.apellido_cliente, e.getString(cliente.apellido_cliente));
				map.put(cliente.segundo_apellido_cliente, e.getString(cliente.segundo_apellido_cliente));
				map.put(cliente.actividad, e.getString(cliente.actividad));
				map.put(cliente.area_actividad, e.getString(cliente.area_actividad));
				map.put(cliente.dia_fecha_nacimiento, e.getString(cliente.dia_fecha_nacimiento));
				map.put(cliente.mes_fecha_nacimiento, e.getString(cliente.mes_fecha_nacimiento));
				map.put(cliente.ano_fecha_nacimiento, e.getString(cliente.ano_fecha_nacimiento));
				map.put(cliente.edad, e.getString(cliente.edad));
				map.put(cliente.email, e.getString(cliente.email));
				map.put(cliente.celular, e.getString(cliente.celular));
				map.put(cliente.telefono, e.getString(cliente.telefono));
				mylist.add(map);
			}
		}

		if(funcion.equals("cliente_empresa"))
		{
			jArray = json.getJSONArray("cliente_empresa");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(cliente_empresa.id_cliente_empresa, e.getString(cliente_empresa.id_cliente_empresa));
				map.put(cliente_empresa.rut_cliente_empresa, e.getString(cliente_empresa.rut_cliente_empresa));
				map.put(cliente_empresa.digito_verificador, e.getString(cliente_empresa.digito_verificador));
				map.put(cliente_empresa.nombre, e.getString(cliente_empresa.nombre));
				map.put(cliente_empresa.email_cliente_empresa, e.getString(cliente_empresa.email_cliente_empresa));
				map.put(cliente_empresa.actividad_id_actividad, e.getString(cliente_empresa.actividad_id_actividad));
				map.put(cliente_empresa.empresa_id_empresa, e.getString(cliente_empresa.empresa_id_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("compracompleta"))
		{
			jArray = json.getJSONArray("compracompleta");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(compracompleta.id_factura, e.getString(compracompleta.id_factura));
				map.put(compracompleta.rol_factura, e.getString(compracompleta.rol_factura));
				map.put(compracompleta.dia_factura, e.getString(compracompleta.dia_factura));
				map.put(compracompleta.mes_factura, e.getString(compracompleta.mes_factura));
				map.put(compracompleta.ano_factura, e.getString(compracompleta.ano_factura));
				map.put(compracompleta.fecha_factura, e.getString(compracompleta.fecha_factura));
				map.put(compracompleta.empresa_id_empresa, e.getString(compracompleta.empresa_id_empresa));
				map.put(compracompleta.carne_empresa_id_carne_empresa, e.getString(compracompleta.carne_empresa_id_carne_empresa));
				map.put(compracompleta.rut_proveedor, e.getString(compracompleta.rut_proveedor));
				map.put(compracompleta.nombre_proveedor, e.getString(compracompleta.nombre_proveedor));
				map.put(compracompleta.telefono_proveedor, e.getString(compracompleta.telefono_proveedor));
				map.put(compracompleta.tipo_documento_id_tipo_documento, e.getString(compracompleta.tipo_documento_id_tipo_documento));
				map.put(compracompleta.tipo_pago_id_tipo_pago, e.getString(compracompleta.tipo_pago_id_tipo_pago));
				map.put(compracompleta.total_factura, e.getString(compracompleta.total_factura));
				map.put(compracompleta.id_tipo_pago, e.getString(compracompleta.id_tipo_pago));
				map.put(compracompleta.nombre_tipo_pago, e.getString(compracompleta.nombre_tipo_pago));
				map.put(compracompleta.comision_tipo_pago, e.getString(compracompleta.comision_tipo_pago));
				map.put(compracompleta.id_tipo_documento, e.getString(compracompleta.id_tipo_documento));
				map.put(compracompleta.nombre_tipo_documento, e.getString(compracompleta.nombre_tipo_documento));
				mylist.add(map);
			}
		}

		if(funcion.equals("comuna"))
		{
			jArray = json.getJSONArray("comuna");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(comuna.id_comuna, e.getString(comuna.id_comuna));
				map.put(comuna.codigo_comuna, e.getString(comuna.codigo_comuna));
				map.put(comuna.nombre_comuna, e.getString(comuna.nombre_comuna));
				map.put(comuna.provincia_id_provincia, e.getString(comuna.provincia_id_provincia));
				mylist.add(map);
			}
		}

		if(funcion.equals("contenido_unidad_medida"))
		{
			jArray = json.getJSONArray("contenido_unidad_medida");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(contenido_unidad_medida.id_contenido_unidad_medida, e.getString(contenido_unidad_medida.id_contenido_unidad_medida));
				map.put(contenido_unidad_medida.nombre_contenido_unidad_medida, e.getString(contenido_unidad_medida.nombre_contenido_unidad_medida));
				mylist.add(map);
			}
		}

		if(funcion.equals("dia"))
		{
			jArray = json.getJSONArray("dia");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(dia.iddia, e.getString(dia.iddia));
				map.put(dia.dia, e.getString(dia.dia));
				map.put(dia.mes, e.getString(dia.mes));
				map.put(dia.anno, e.getString(dia.anno));
				map.put(dia.fecha, e.getString(dia.fecha));
				map.put(dia.egreso, e.getString(dia.egreso));
				map.put(dia.ingreso, e.getString(dia.ingreso));
				map.put(dia.impuesto, e.getString(dia.impuesto));
				mylist.add(map);
			}
		}

		if(funcion.equals("empresa"))
		{
			jArray = json.getJSONArray("empresa");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(empresa.id_empresa, e.getString(empresa.id_empresa));
				map.put(empresa.rut_empresa, e.getString(empresa.rut_empresa));
				map.put(empresa.digito_verificador_empresa, e.getString(empresa.digito_verificador_empresa));
				map.put(empresa.nombre_empresa, e.getString(empresa.nombre_empresa));
				map.put(empresa.nombre_contacto_empresa, e.getString(empresa.nombre_contacto_empresa));
				map.put(empresa.cargo_contacto_empresa, e.getString(empresa.cargo_contacto_empresa));
				map.put(empresa.email_empresa, e.getString(empresa.email_empresa));
				map.put(empresa.alcance_empresa, e.getString(empresa.alcance_empresa));
				map.put(empresa.telefono_empresa, e.getString(empresa.telefono_empresa));
				map.put(empresa.actividad_id_actividad, e.getString(empresa.actividad_id_actividad));
				map.put(empresa.tipo_empresa_id_tipo_empresa, e.getString(empresa.tipo_empresa_id_tipo_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("envio"))
		{
			jArray = json.getJSONArray("envio");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(envio.id_envio, e.getString(envio.id_envio));
				map.put(envio.direccion_alternativa, e.getString(envio.direccion_alternativa));
				map.put(envio.fecha_entrega, e.getString(envio.fecha_entrega));
				map.put(envio.hora_entrega, e.getString(envio.hora_entrega));
				map.put(envio.venta_id_venta, e.getString(envio.venta_id_venta));
				map.put(envio.enviado, e.getString(envio.enviado));
				mylist.add(map);
			}
		}

		if(funcion.equals("factura"))
		{
			jArray = json.getJSONArray("factura");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(factura.id_factura, e.getString(factura.id_factura));
				map.put(factura.rol_factura, e.getString(factura.rol_factura));
				map.put(factura.dia_factura, e.getString(factura.dia_factura));
				map.put(factura.mes_factura, e.getString(factura.mes_factura));
				map.put(factura.ano_factura, e.getString(factura.ano_factura));
				map.put(factura.fecha_factura, e.getString(factura.fecha_factura));
				map.put(factura.empresa_id_empresa, e.getString(factura.empresa_id_empresa));
				map.put(factura.carne_empresa_id_carne_empresa, e.getString(factura.carne_empresa_id_carne_empresa));
				map.put(factura.rut_proveedor, e.getString(factura.rut_proveedor));
				map.put(factura.nombre_proveedor, e.getString(factura.nombre_proveedor));
				map.put(factura.telefono_proveedor, e.getString(factura.telefono_proveedor));
				map.put(factura.tipo_documento_id_tipo_documento, e.getString(factura.tipo_documento_id_tipo_documento));
				map.put(factura.tipo_pago_id_tipo_pago, e.getString(factura.tipo_pago_id_tipo_pago));
				map.put(factura.total_factura, e.getString(factura.total_factura));
				mylist.add(map);
			}
		}

		if(funcion.equals("familia_necesidad"))
		{
			jArray = json.getJSONArray("familia_necesidad");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(familia_necesidad.id_familia_necesidad, e.getString(familia_necesidad.id_familia_necesidad));
				map.put(familia_necesidad.nombre_familia_necesidad, e.getString(familia_necesidad.nombre_familia_necesidad));
				mylist.add(map);
			}
		}

		if(funcion.equals("familia_producto"))
		{
			jArray = json.getJSONArray("familia_producto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(familia_producto.id_familia_producto, e.getString(familia_producto.id_familia_producto));
				map.put(familia_producto.nombre_familia_producto, e.getString(familia_producto.nombre_familia_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("formato_producto"))
		{
			jArray = json.getJSONArray("formato_producto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(formato_producto.id_formato_producto, e.getString(formato_producto.id_formato_producto));
				map.put(formato_producto.nombre_formato_producto, e.getString(formato_producto.nombre_formato_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("gasto"))
		{
			jArray = json.getJSONArray("gasto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(gasto.id_gasto, e.getString(gasto.id_gasto));
				map.put(gasto.nombre_gasto, e.getString(gasto.nombre_gasto));
				map.put(gasto.id_usuario, e.getString(gasto.id_usuario));
				map.put(gasto.monto_gasto, e.getString(gasto.monto_gasto));
				map.put(gasto.fecha_gasto, e.getString(gasto.fecha_gasto));
				map.put(gasto.empresa_id_empre, e.getString(gasto.empresa_id_empre));
				mylist.add(map);
			}
		}

		if(funcion.equals("geocode_cache"))
		{
			jArray = json.getJSONArray("geocode_cache");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(geocode_cache.id, e.getString(geocode_cache.id));
				map.put(geocode_cache.lng, e.getString(geocode_cache.lng));
				map.put(geocode_cache.lat, e.getString(geocode_cache.lat));
				map.put(geocode_cache.query, e.getString(geocode_cache.query));
				mylist.add(map);
			}
		}

		if(funcion.equals("imagenprod"))
		{
			jArray = json.getJSONArray("imagenprod");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(imagenprod.id_imagenprod, e.getString(imagenprod.id_imagenprod));
				map.put(imagenprod.urlimagenprod, e.getString(imagenprod.urlimagenprod));
				map.put(imagenprod.producto_id_producto, e.getString(imagenprod.producto_id_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("impuesto"))
		{
			jArray = json.getJSONArray("impuesto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(impuesto.id_impuesto, e.getString(impuesto.id_impuesto));
				map.put(impuesto.nombre_impuesto, e.getString(impuesto.nombre_impuesto));
				map.put(impuesto.valor_impuesto, e.getString(impuesto.valor_impuesto));
				mylist.add(map);
			}
		}

		if(funcion.equals("ingresosegresos"))
		{
			jArray = json.getJSONArray("ingresosegresos");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(ingresosegresos.dia, e.getString(ingresosegresos.dia));
				map.put(ingresosegresos.mes, e.getString(ingresosegresos.mes));
				map.put(ingresosegresos.anno, e.getString(ingresosegresos.anno));
				map.put(ingresosegresos.fecha, e.getString(ingresosegresos.fecha));
				map.put(ingresosegresos.totalingreso, e.getString(ingresosegresos.totalingreso));
				map.put(ingresosegresos.totalgasto, e.getString(ingresosegresos.totalgasto));
				map.put(ingresosegresos.impuestoegreso, e.getString(ingresosegresos.impuestoegreso));
				map.put(ingresosegresos.impuestoingreso, e.getString(ingresosegresos.impuestoingreso));
				mylist.add(map);
			}
		}

		if(funcion.equals("item_factura"))
		{
			jArray = json.getJSONArray("item_factura");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(item_factura.id_itemfactura, e.getString(item_factura.id_itemfactura));
				map.put(item_factura.cantidad, e.getString(item_factura.cantidad));
				map.put(item_factura.precio, e.getString(item_factura.precio));
				map.put(item_factura.producto_id_producto, e.getString(item_factura.producto_id_producto));
				map.put(item_factura.factura_id_factura, e.getString(item_factura.factura_id_factura));
				map.put(item_factura.carro_egresos_id_carro_egresos, e.getString(item_factura.carro_egresos_id_carro_egresos));
				mylist.add(map);
			}
		}

		if(funcion.equals("item_facturacompleto"))
		{
			jArray = json.getJSONArray("item_facturacompleto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(item_facturacompleto.id_itemfactura, e.getString(item_facturacompleto.id_itemfactura));
				map.put(item_facturacompleto.cantidad, e.getString(item_facturacompleto.cantidad));
				map.put(item_facturacompleto.precio, e.getString(item_facturacompleto.precio));
				map.put(item_facturacompleto.producto_id_producto, e.getString(item_facturacompleto.producto_id_producto));
				map.put(item_facturacompleto.factura_id_factura, e.getString(item_facturacompleto.factura_id_factura));
				map.put(item_facturacompleto.id_producto, e.getString(item_facturacompleto.id_producto));
				map.put(item_facturacompleto.codigo_producto, e.getString(item_facturacompleto.codigo_producto));
				map.put(item_facturacompleto.numero_serie, e.getString(item_facturacompleto.numero_serie));
				map.put(item_facturacompleto.descripcion_producto, e.getString(item_facturacompleto.descripcion_producto));
				map.put(item_facturacompleto.nombre_producto, e.getString(item_facturacompleto.nombre_producto));
				map.put(item_facturacompleto.marca_producto, e.getString(item_facturacompleto.marca_producto));
				map.put(item_facturacompleto.modelo_producto, e.getString(item_facturacompleto.modelo_producto));
				map.put(item_facturacompleto.contenido_unidad, e.getString(item_facturacompleto.contenido_unidad));
				map.put(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(item_facturacompleto.unidad_minima, e.getString(item_facturacompleto.unidad_minima));
				map.put(item_facturacompleto.contenido, e.getString(item_facturacompleto.contenido));
				map.put(item_facturacompleto.peso_neto, e.getString(item_facturacompleto.peso_neto));
				map.put(item_facturacompleto.alto_cm, e.getString(item_facturacompleto.alto_cm));
				map.put(item_facturacompleto.ancho_cm, e.getString(item_facturacompleto.ancho_cm));
				map.put(item_facturacompleto.fondo_cm, e.getString(item_facturacompleto.fondo_cm));
				map.put(item_facturacompleto.fabricante, e.getString(item_facturacompleto.fabricante));
				map.put(item_facturacompleto.clase_producto, e.getString(item_facturacompleto.clase_producto));
				map.put(item_facturacompleto.linea_producto, e.getString(item_facturacompleto.linea_producto));
				map.put(item_facturacompleto.hot, e.getString(item_facturacompleto.hot));
				map.put(item_facturacompleto.SKU, e.getString(item_facturacompleto.SKU));
				map.put(item_facturacompleto.subcategoria_id_subcategoria, e.getString(item_facturacompleto.subcategoria_id_subcategoria));
				map.put(item_facturacompleto.tipo_producto_id_tipo_producto, e.getString(item_facturacompleto.tipo_producto_id_tipo_producto));
				map.put(item_facturacompleto.formato_producto_id_formato_producto, e.getString(item_facturacompleto.formato_producto_id_formato_producto));
				map.put(item_facturacompleto.familia_necesidad_id_familia_necesidad, e.getString(item_facturacompleto.familia_necesidad_id_familia_necesidad));
				map.put(item_facturacompleto.familia_producto_id_familia_producto, e.getString(item_facturacompleto.familia_producto_id_familia_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("mapa"))
		{
			jArray = json.getJSONArray("mapa");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(mapa.id, e.getString(mapa.id));
				map.put(mapa.name, e.getString(mapa.name));
				map.put(mapa.direccion, e.getString(mapa.direccion));
				map.put(mapa.lat, e.getString(mapa.lat));
				map.put(mapa.lng, e.getString(mapa.lng));
				map.put(mapa.tipo, e.getString(mapa.tipo));
				map.put(mapa.imagen, e.getString(mapa.imagen));
				mylist.add(map);
			}
		}

		if(funcion.equals("pais"))
		{
			jArray = json.getJSONArray("pais");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(pais.id_pais, e.getString(pais.id_pais));
				map.put(pais.nombre_pais, e.getString(pais.nombre_pais));
				map.put(pais.iso_code_2_pais, e.getString(pais.iso_code_2_pais));
				map.put(pais.iso_code_3_pais, e.getString(pais.iso_code_3_pais));
				map.put(pais.address_format, e.getString(pais.address_format));
				map.put(pais.iso_code_number, e.getString(pais.iso_code_number));
				mylist.add(map);
			}
		}

		if(funcion.equals("persona"))
		{
			jArray = json.getJSONArray("persona");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(persona.id_persona, e.getString(persona.id_persona));
				map.put(persona.rut_persona, e.getString(persona.rut_persona));
				map.put(persona.digito_verificador, e.getString(persona.digito_verificador));
				map.put(persona.nombre_persona, e.getString(persona.nombre_persona));
				map.put(persona.segundo_nombre_persona, e.getString(persona.segundo_nombre_persona));
				map.put(persona.apellido_persona, e.getString(persona.apellido_persona));
				map.put(persona.segundo_apellido_persona, e.getString(persona.segundo_apellido_persona));
				map.put(persona.actividad, e.getString(persona.actividad));
				map.put(persona.area_actividad, e.getString(persona.area_actividad));
				map.put(persona.dia_fecha_nacimiento, e.getString(persona.dia_fecha_nacimiento));
				map.put(persona.mes_fecha_nacimiento, e.getString(persona.mes_fecha_nacimiento));
				map.put(persona.ano_fecha_nacimiento, e.getString(persona.ano_fecha_nacimiento));
				map.put(persona.edad, e.getString(persona.edad));
				map.put(persona.email, e.getString(persona.email));
				map.put(persona.celular, e.getString(persona.celular));
				map.put(persona.telefono, e.getString(persona.telefono));
				mylist.add(map);
			}
		}

		if(funcion.equals("precio"))
		{
			jArray = json.getJSONArray("precio");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(precio.id_precio, e.getString(precio.id_precio));
				map.put(precio.precio_CLP, e.getString(precio.precio_CLP));
				map.put(precio.precio_us, e.getString(precio.precio_us));
				map.put(precio.precio_mayor_CLP, e.getString(precio.precio_mayor_CLP));
				map.put(precio.precio_mayor_us, e.getString(precio.precio_mayor_us));
				map.put(precio.precio_actual, e.getString(precio.precio_actual));
				map.put(precio.descuento_promocion, e.getString(precio.descuento_promocion));
				map.put(precio.cantidad_mayor, e.getString(precio.cantidad_mayor));
				map.put(precio.empresa_id_empresa, e.getString(precio.empresa_id_empresa));
				map.put(precio.producto_id_producto, e.getString(precio.producto_id_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("producto"))
		{
			jArray = json.getJSONArray("producto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(producto.id_producto, e.getString(producto.id_producto));
				map.put(producto.codigo_producto, e.getString(producto.codigo_producto));
				map.put(producto.numero_serie, e.getString(producto.numero_serie));
				map.put(producto.descripcion_producto, e.getString(producto.descripcion_producto));
				map.put(producto.nombre_producto, e.getString(producto.nombre_producto));
				map.put(producto.marca_producto, e.getString(producto.marca_producto));
				map.put(producto.modelo_producto, e.getString(producto.modelo_producto));
				map.put(producto.contenido_unidad, e.getString(producto.contenido_unidad));
				map.put(producto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(producto.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(producto.unidad_minima, e.getString(producto.unidad_minima));
				map.put(producto.contenido, e.getString(producto.contenido));
				map.put(producto.peso_neto, e.getString(producto.peso_neto));
				map.put(producto.alto_cm, e.getString(producto.alto_cm));
				map.put(producto.ancho_cm, e.getString(producto.ancho_cm));
				map.put(producto.fondo_cm, e.getString(producto.fondo_cm));
				map.put(producto.fabricante, e.getString(producto.fabricante));
				map.put(producto.clase_producto, e.getString(producto.clase_producto));
				map.put(producto.linea_producto, e.getString(producto.linea_producto));
				map.put(producto.hot, e.getString(producto.hot));
				map.put(producto.SKU, e.getString(producto.SKU));
				map.put(producto.subcategoria_id_subcategoria, e.getString(producto.subcategoria_id_subcategoria));
				map.put(producto.tipo_producto_id_tipo_producto, e.getString(producto.tipo_producto_id_tipo_producto));
				map.put(producto.formato_producto_id_formato_producto, e.getString(producto.formato_producto_id_formato_producto));
				map.put(producto.familia_necesidad_id_familia_necesidad, e.getString(producto.familia_necesidad_id_familia_necesidad));
				map.put(producto.familia_producto_id_familia_producto, e.getString(producto.familia_producto_id_familia_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("productocompleto"))
		{
			jArray = json.getJSONArray("productocompleto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(productocompleto.id_producto, e.getString(productocompleto.id_producto));
				map.put(productocompleto.codigo_producto, e.getString(productocompleto.codigo_producto));
				map.put(productocompleto.numero_serie, e.getString(productocompleto.numero_serie));
				map.put(productocompleto.descripcion_producto, e.getString(productocompleto.descripcion_producto));
				map.put(productocompleto.nombre_producto, e.getString(productocompleto.nombre_producto));
				map.put(productocompleto.marca_producto, e.getString(productocompleto.marca_producto));
				map.put(productocompleto.modelo_producto, e.getString(productocompleto.modelo_producto));
				map.put(productocompleto.contenido_unidad, e.getString(productocompleto.contenido_unidad));
				map.put(productocompleto.unidad_minima, e.getString(productocompleto.unidad_minima));
				map.put(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(productocompleto.contenido, e.getString(productocompleto.contenido));
				map.put(productocompleto.peso_neto, e.getString(productocompleto.peso_neto));
				map.put(productocompleto.alto_cm, e.getString(productocompleto.alto_cm));
				map.put(productocompleto.ancho_cm, e.getString(productocompleto.ancho_cm));
				map.put(productocompleto.fondo_cm, e.getString(productocompleto.fondo_cm));
				map.put(productocompleto.fabricante, e.getString(productocompleto.fabricante));
				map.put(productocompleto.familia_necesidad_id_familia_necesidad, e.getString(productocompleto.familia_necesidad_id_familia_necesidad));
				map.put(productocompleto.familia_producto_id_familia_producto, e.getString(productocompleto.familia_producto_id_familia_producto));
				map.put(productocompleto.clase_producto, e.getString(productocompleto.clase_producto));
				map.put(productocompleto.linea_producto, e.getString(productocompleto.linea_producto));
				map.put(productocompleto.tipo_producto_id_tipo_producto, e.getString(productocompleto.tipo_producto_id_tipo_producto));
				map.put(productocompleto.hot, e.getString(productocompleto.hot));
				map.put(productocompleto.subcategoria_id_subcategoria, e.getString(productocompleto.subcategoria_id_subcategoria));
				map.put(productocompleto.SKU, e.getString(productocompleto.SKU));
				map.put(productocompleto.formato_producto_id_formato_producto, e.getString(productocompleto.formato_producto_id_formato_producto));
				map.put(productocompleto.id_caracteristica, e.getString(productocompleto.id_caracteristica));
				map.put(productocompleto.numero_caracteristica, e.getString(productocompleto.numero_caracteristica));
				map.put(productocompleto.caracteristica, e.getString(productocompleto.caracteristica));
				map.put(productocompleto.valor_caracteristica, e.getString(productocompleto.valor_caracteristica));
				map.put(productocompleto.id_categoria, e.getString(productocompleto.id_categoria));
				map.put(productocompleto.nombre_categoria, e.getString(productocompleto.nombre_categoria));
				map.put(productocompleto.id_empresa, e.getString(productocompleto.id_empresa));
				map.put(productocompleto.rut_empresa, e.getString(productocompleto.rut_empresa));
				map.put(productocompleto.digito_verificador_empresa, e.getString(productocompleto.digito_verificador_empresa));
				map.put(productocompleto.nombre_empresa, e.getString(productocompleto.nombre_empresa));
				map.put(productocompleto.nombre_contacto_empresa, e.getString(productocompleto.nombre_contacto_empresa));
				map.put(productocompleto.cargo_contacto_empresa, e.getString(productocompleto.cargo_contacto_empresa));
				map.put(productocompleto.email_empresa, e.getString(productocompleto.email_empresa));
				map.put(productocompleto.alcance_empresa, e.getString(productocompleto.alcance_empresa));
				map.put(productocompleto.telefono_empresa, e.getString(productocompleto.telefono_empresa));
				map.put(productocompleto.actividad_id_actividad, e.getString(productocompleto.actividad_id_actividad));
				map.put(productocompleto.id_imagenprod, e.getString(productocompleto.id_imagenprod));
				map.put(productocompleto.urlimagenprod, e.getString(productocompleto.urlimagenprod));
				map.put(productocompleto.id_precio, e.getString(productocompleto.id_precio));
				map.put(productocompleto.precio_CLP, e.getString(productocompleto.precio_CLP));
				map.put(productocompleto.precio_us, e.getString(productocompleto.precio_us));
				map.put(productocompleto.precio_mayor_CLP, e.getString(productocompleto.precio_mayor_CLP));
				map.put(productocompleto.precio_mayor_us, e.getString(productocompleto.precio_mayor_us));
				map.put(productocompleto.precio_actual, e.getString(productocompleto.precio_actual));
				map.put(productocompleto.descuento_promocion, e.getString(productocompleto.descuento_promocion));
				map.put(productocompleto.cantidad_mayor, e.getString(productocompleto.cantidad_mayor));
				map.put(productocompleto.id_reciclado, e.getString(productocompleto.id_reciclado));
				map.put(productocompleto.reciclable, e.getString(productocompleto.reciclable));
				map.put(productocompleto.reciclado, e.getString(productocompleto.reciclado));
				map.put(productocompleto.valor_reciclaje, e.getString(productocompleto.valor_reciclaje));
				map.put(productocompleto.empresa_id_empresa, e.getString(productocompleto.empresa_id_empresa));
				map.put(productocompleto.id_stock, e.getString(productocompleto.id_stock));
				map.put(productocompleto.stock_real, e.getString(productocompleto.stock_real));
				map.put(productocompleto.stock_minimo, e.getString(productocompleto.stock_minimo));
				map.put(productocompleto.stock_ideal, e.getString(productocompleto.stock_ideal));
				map.put(productocompleto.stock_tienda, e.getString(productocompleto.stock_tienda));
				map.put(productocompleto.stock_virtual, e.getString(productocompleto.stock_virtual));
				map.put(productocompleto.stock_vendido, e.getString(productocompleto.stock_vendido));
				map.put(productocompleto.last_update, e.getString(productocompleto.last_update));
				map.put(productocompleto.id_subcategoria, e.getString(productocompleto.id_subcategoria));
				map.put(productocompleto.nombre_subcategoria, e.getString(productocompleto.nombre_subcategoria));
				map.put(productocompleto.descripcion_subcategoria, e.getString(productocompleto.descripcion_subcategoria));
				map.put(productocompleto.categoria_id_categoria, e.getString(productocompleto.categoria_id_categoria));
				map.put(productocompleto.id_talla, e.getString(productocompleto.id_talla));
				map.put(productocompleto.am_largo, e.getString(productocompleto.am_largo));
				map.put(productocompleto.am_ancho, e.getString(productocompleto.am_ancho));
				map.put(productocompleto.am_fondo, e.getString(productocompleto.am_fondo));
				map.put(productocompleto.eu_largo, e.getString(productocompleto.eu_largo));
				map.put(productocompleto.eu_ancho, e.getString(productocompleto.eu_ancho));
				map.put(productocompleto.eu_fondo, e.getString(productocompleto.eu_fondo));
				map.put(productocompleto.num_largo, e.getString(productocompleto.num_largo));
				map.put(productocompleto.num_ancho, e.getString(productocompleto.num_ancho));
				map.put(productocompleto.num_fondo, e.getString(productocompleto.num_fondo));
				map.put(productocompleto.id_valor_nutricional, e.getString(productocompleto.id_valor_nutricional));
				map.put(productocompleto.nombre_valor, e.getString(productocompleto.nombre_valor));
				map.put(productocompleto.cantidad, e.getString(productocompleto.cantidad));
				map.put(productocompleto.valor_diario_total, e.getString(productocompleto.valor_diario_total));
				map.put(productocompleto.porcentaje_requerimientos, e.getString(productocompleto.porcentaje_requerimientos));
				mylist.add(map);
			}
		}

		if(funcion.equals("productocompra"))
		{
			jArray = json.getJSONArray("productocompra");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(productocompra.id_producto, e.getString(productocompra.id_producto));
				map.put(productocompra.codigo_producto, e.getString(productocompra.codigo_producto));
				map.put(productocompra.numero_serie, e.getString(productocompra.numero_serie));
				map.put(productocompra.descripcion_producto, e.getString(productocompra.descripcion_producto));
				map.put(productocompra.nombre_producto, e.getString(productocompra.nombre_producto));
				map.put(productocompra.marca_producto, e.getString(productocompra.marca_producto));
				map.put(productocompra.modelo_producto, e.getString(productocompra.modelo_producto));
				map.put(productocompra.contenido_unidad, e.getString(productocompra.contenido_unidad));
				map.put(productocompra.unidad_minima, e.getString(productocompra.unidad_minima));
				map.put(productocompra.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(productocompra.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(productocompra.contenido, e.getString(productocompra.contenido));
				map.put(productocompra.peso_neto, e.getString(productocompra.peso_neto));
				map.put(productocompra.alto_cm, e.getString(productocompra.alto_cm));
				map.put(productocompra.ancho_cm, e.getString(productocompra.ancho_cm));
				map.put(productocompra.fondo_cm, e.getString(productocompra.fondo_cm));
				map.put(productocompra.fabricante, e.getString(productocompra.fabricante));
				map.put(productocompra.familia_necesidad_id_familia_necesidad, e.getString(productocompra.familia_necesidad_id_familia_necesidad));
				map.put(productocompra.familia_producto_id_familia_producto, e.getString(productocompra.familia_producto_id_familia_producto));
				map.put(productocompra.clase_producto, e.getString(productocompra.clase_producto));
				map.put(productocompra.linea_producto, e.getString(productocompra.linea_producto));
				map.put(productocompra.tipo_producto_id_tipo_producto, e.getString(productocompra.tipo_producto_id_tipo_producto));
				map.put(productocompra.hot, e.getString(productocompra.hot));
				map.put(productocompra.subcategoria_id_subcategoria, e.getString(productocompra.subcategoria_id_subcategoria));
				map.put(productocompra.SKU, e.getString(productocompra.SKU));
				map.put(productocompra.formato_producto_id_formato_producto, e.getString(productocompra.formato_producto_id_formato_producto));
				map.put(productocompra.id_caracteristica, e.getString(productocompra.id_caracteristica));
				map.put(productocompra.numero_caracteristica, e.getString(productocompra.numero_caracteristica));
				map.put(productocompra.caracteristica, e.getString(productocompra.caracteristica));
				map.put(productocompra.valor_caracteristica, e.getString(productocompra.valor_caracteristica));
				map.put(productocompra.id_categoria, e.getString(productocompra.id_categoria));
				map.put(productocompra.nombre_categoria, e.getString(productocompra.nombre_categoria));
				map.put(productocompra.id_reciclado, e.getString(productocompra.id_reciclado));
				map.put(productocompra.reciclable, e.getString(productocompra.reciclable));
				map.put(productocompra.reciclado, e.getString(productocompra.reciclado));
				map.put(productocompra.valor_reciclaje, e.getString(productocompra.valor_reciclaje));
				map.put(productocompra.empresa_id_empresa, e.getString(productocompra.empresa_id_empresa));
				map.put(productocompra.id_stock, e.getString(productocompra.id_stock));
				map.put(productocompra.stock_real, e.getString(productocompra.stock_real));
				map.put(productocompra.stock_minimo, e.getString(productocompra.stock_minimo));
				map.put(productocompra.stock_ideal, e.getString(productocompra.stock_ideal));
				map.put(productocompra.stock_tienda, e.getString(productocompra.stock_tienda));
				map.put(productocompra.stock_virtual, e.getString(productocompra.stock_virtual));
				map.put(productocompra.stock_vendido, e.getString(productocompra.stock_vendido));
				map.put(productocompra.last_update, e.getString(productocompra.last_update));
				map.put(productocompra.id_subcategoria, e.getString(productocompra.id_subcategoria));
				map.put(productocompra.nombre_subcategoria, e.getString(productocompra.nombre_subcategoria));
				map.put(productocompra.descripcion_subcategoria, e.getString(productocompra.descripcion_subcategoria));
				map.put(productocompra.categoria_id_categoria, e.getString(productocompra.categoria_id_categoria));
				map.put(productocompra.id_talla, e.getString(productocompra.id_talla));
				map.put(productocompra.am_largo, e.getString(productocompra.am_largo));
				map.put(productocompra.am_ancho, e.getString(productocompra.am_ancho));
				map.put(productocompra.am_fondo, e.getString(productocompra.am_fondo));
				map.put(productocompra.eu_largo, e.getString(productocompra.eu_largo));
				map.put(productocompra.eu_ancho, e.getString(productocompra.eu_ancho));
				map.put(productocompra.eu_fondo, e.getString(productocompra.eu_fondo));
				map.put(productocompra.num_largo, e.getString(productocompra.num_largo));
				map.put(productocompra.num_ancho, e.getString(productocompra.num_ancho));
				map.put(productocompra.num_fondo, e.getString(productocompra.num_fondo));
				map.put(productocompra.id_valor_nutricional, e.getString(productocompra.id_valor_nutricional));
				map.put(productocompra.nombre_valor, e.getString(productocompra.nombre_valor));
				map.put(productocompra.cantidad, e.getString(productocompra.cantidad));
				map.put(productocompra.valor_diario_total, e.getString(productocompra.valor_diario_total));
				map.put(productocompra.porcentaje_requerimientos, e.getString(productocompra.porcentaje_requerimientos));
				mylist.add(map);
			}
		}

		if(funcion.equals("productoprecio"))
		{
			jArray = json.getJSONArray("productoprecio");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(productoprecio.id_producto, e.getString(productoprecio.id_producto));
				map.put(productoprecio.codigo_producto, e.getString(productoprecio.codigo_producto));
				map.put(productoprecio.numero_serie, e.getString(productoprecio.numero_serie));
				map.put(productoprecio.descripcion_producto, e.getString(productoprecio.descripcion_producto));
				map.put(productoprecio.nombre_producto, e.getString(productoprecio.nombre_producto));
				map.put(productoprecio.marca_producto, e.getString(productoprecio.marca_producto));
				map.put(productoprecio.modelo_producto, e.getString(productoprecio.modelo_producto));
				map.put(productoprecio.contenido_unidad, e.getString(productoprecio.contenido_unidad));
				map.put(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(productoprecio.unidad_minima, e.getString(productoprecio.unidad_minima));
				map.put(productoprecio.contenido, e.getString(productoprecio.contenido));
				map.put(productoprecio.peso_neto, e.getString(productoprecio.peso_neto));
				map.put(productoprecio.alto_cm, e.getString(productoprecio.alto_cm));
				map.put(productoprecio.ancho_cm, e.getString(productoprecio.ancho_cm));
				map.put(productoprecio.fondo_cm, e.getString(productoprecio.fondo_cm));
				map.put(productoprecio.fabricante, e.getString(productoprecio.fabricante));
				map.put(productoprecio.clase_producto, e.getString(productoprecio.clase_producto));
				map.put(productoprecio.linea_producto, e.getString(productoprecio.linea_producto));
				map.put(productoprecio.hot, e.getString(productoprecio.hot));
				map.put(productoprecio.SKU, e.getString(productoprecio.SKU));
				map.put(productoprecio.subcategoria_id_subcategoria, e.getString(productoprecio.subcategoria_id_subcategoria));
				map.put(productoprecio.tipo_producto_id_tipo_producto, e.getString(productoprecio.tipo_producto_id_tipo_producto));
				map.put(productoprecio.formato_producto_id_formato_producto, e.getString(productoprecio.formato_producto_id_formato_producto));
				map.put(productoprecio.familia_necesidad_id_familia_necesidad, e.getString(productoprecio.familia_necesidad_id_familia_necesidad));
				map.put(productoprecio.familia_producto_id_familia_producto, e.getString(productoprecio.familia_producto_id_familia_producto));
				map.put(productoprecio.id_precio, e.getString(productoprecio.id_precio));
				map.put(productoprecio.precio_CLP, e.getString(productoprecio.precio_CLP));
				map.put(productoprecio.precio_us, e.getString(productoprecio.precio_us));
				map.put(productoprecio.precio_mayor_CLP, e.getString(productoprecio.precio_mayor_CLP));
				map.put(productoprecio.precio_mayor_us, e.getString(productoprecio.precio_mayor_us));
				map.put(productoprecio.precio_actual, e.getString(productoprecio.precio_actual));
				map.put(productoprecio.descuento_promocion, e.getString(productoprecio.descuento_promocion));
				map.put(productoprecio.cantidad_mayor, e.getString(productoprecio.cantidad_mayor));
				map.put(productoprecio.id_stock, e.getString(productoprecio.id_stock));
				map.put(productoprecio.stock_real, e.getString(productoprecio.stock_real));
				map.put(productoprecio.stock_minimo, e.getString(productoprecio.stock_minimo));
				map.put(productoprecio.stock_ideal, e.getString(productoprecio.stock_ideal));
				map.put(productoprecio.stock_tienda, e.getString(productoprecio.stock_tienda));
				map.put(productoprecio.stock_virtual, e.getString(productoprecio.stock_virtual));
				map.put(productoprecio.stock_vendido, e.getString(productoprecio.stock_vendido));
				map.put(productoprecio.last_update, e.getString(productoprecio.last_update));
				map.put(productoprecio.empresa_id_empresa, e.getString(productoprecio.empresa_id_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("provincia"))
		{
			jArray = json.getJSONArray("provincia");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(provincia.id_provincia, e.getString(provincia.id_provincia));
				map.put(provincia.nombre_provincia, e.getString(provincia.nombre_provincia));
				map.put(provincia.codigo_provincia, e.getString(provincia.codigo_provincia));
				map.put(provincia.region_id_region, e.getString(provincia.region_id_region));
				mylist.add(map);
			}
		}

		if(funcion.equals("reciclado"))
		{
			jArray = json.getJSONArray("reciclado");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(reciclado.id_reciclado, e.getString(reciclado.id_reciclado));
				map.put(reciclado.reciclable, e.getString(reciclado.reciclable));
				map.put(reciclado.reciclado, e.getString(reciclado.reciclado));
				map.put(reciclado.valor_reciclaje, e.getString(reciclado.valor_reciclaje));
				map.put(reciclado.empresa_id_empresa, e.getString(reciclado.empresa_id_empresa));
				map.put(reciclado.producto_id_producto, e.getString(reciclado.producto_id_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("region"))
		{
			jArray = json.getJSONArray("region");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(region.id_region, e.getString(region.id_region));
				map.put(region.nombre_region, e.getString(region.nombre_region));
				map.put(region.codigo_region, e.getString(region.codigo_region));
				map.put(region.pais_id_pais, e.getString(region.pais_id_pais));
				mylist.add(map);
			}
		}

		if(funcion.equals("rubro"))
		{
			jArray = json.getJSONArray("rubro");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(rubro.id_rubro, e.getString(rubro.id_rubro));
				map.put(rubro.nombre_rubro, e.getString(rubro.nombre_rubro));
				mylist.add(map);
			}
		}

		if(funcion.equals("sincrodate"))
		{
			jArray = json.getJSONArray("sincrodate");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(sincrodate.id_sincrodate, e.getString(sincrodate.id_sincrodate));
				map.put(sincrodate.date, e.getString(sincrodate.date));
				mylist.add(map);
			}
		}

		if(funcion.equals("stock"))
		{
			jArray = json.getJSONArray("stock");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(stock.id_stock, e.getString(stock.id_stock));
				map.put(stock.stock_real, e.getString(stock.stock_real));
				map.put(stock.stock_minimo, e.getString(stock.stock_minimo));
				map.put(stock.stock_ideal, e.getString(stock.stock_ideal));
				map.put(stock.stock_tienda, e.getString(stock.stock_tienda));
				map.put(stock.stock_virtual, e.getString(stock.stock_virtual));
				map.put(stock.stock_vendido, e.getString(stock.stock_vendido));
				map.put(stock.last_update, e.getString(stock.last_update));
				map.put(stock.producto_id_producto, e.getString(stock.producto_id_producto));
				map.put(stock.empresa_id_empresa, e.getString(stock.empresa_id_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("stockcompleto"))
		{
			jArray = json.getJSONArray("stockcompleto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(stockcompleto.id_producto, e.getString(stockcompleto.id_producto));
				map.put(stockcompleto.codigo_producto, e.getString(stockcompleto.codigo_producto));
				map.put(stockcompleto.numero_serie, e.getString(stockcompleto.numero_serie));
				map.put(stockcompleto.descripcion_producto, e.getString(stockcompleto.descripcion_producto));
				map.put(stockcompleto.nombre_producto, e.getString(stockcompleto.nombre_producto));
				map.put(stockcompleto.marca_producto, e.getString(stockcompleto.marca_producto));
				map.put(stockcompleto.modelo_producto, e.getString(stockcompleto.modelo_producto));
				map.put(stockcompleto.contenido_unidad, e.getString(stockcompleto.contenido_unidad));
				map.put(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida, e.getString(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida));
				map.put(stockcompleto.unidad_minima, e.getString(stockcompleto.unidad_minima));
				map.put(stockcompleto.contenido, e.getString(stockcompleto.contenido));
				map.put(stockcompleto.peso_neto, e.getString(stockcompleto.peso_neto));
				map.put(stockcompleto.alto_cm, e.getString(stockcompleto.alto_cm));
				map.put(stockcompleto.ancho_cm, e.getString(stockcompleto.ancho_cm));
				map.put(stockcompleto.fondo_cm, e.getString(stockcompleto.fondo_cm));
				map.put(stockcompleto.fabricante, e.getString(stockcompleto.fabricante));
				map.put(stockcompleto.clase_producto, e.getString(stockcompleto.clase_producto));
				map.put(stockcompleto.linea_producto, e.getString(stockcompleto.linea_producto));
				map.put(stockcompleto.hot, e.getString(stockcompleto.hot));
				map.put(stockcompleto.SKU, e.getString(stockcompleto.SKU));
				map.put(stockcompleto.subcategoria_id_subcategoria, e.getString(stockcompleto.subcategoria_id_subcategoria));
				map.put(stockcompleto.tipo_producto_id_tipo_producto, e.getString(stockcompleto.tipo_producto_id_tipo_producto));
				map.put(stockcompleto.formato_producto_id_formato_producto, e.getString(stockcompleto.formato_producto_id_formato_producto));
				map.put(stockcompleto.familia_necesidad_id_familia_necesidad, e.getString(stockcompleto.familia_necesidad_id_familia_necesidad));
				map.put(stockcompleto.familia_producto_id_familia_producto, e.getString(stockcompleto.familia_producto_id_familia_producto));
				map.put(stockcompleto.id_stock, e.getString(stockcompleto.id_stock));
				map.put(stockcompleto.stock_real, e.getString(stockcompleto.stock_real));
				map.put(stockcompleto.stock_minimo, e.getString(stockcompleto.stock_minimo));
				map.put(stockcompleto.stock_ideal, e.getString(stockcompleto.stock_ideal));
				map.put(stockcompleto.stock_tienda, e.getString(stockcompleto.stock_tienda));
				map.put(stockcompleto.stock_virtual, e.getString(stockcompleto.stock_virtual));
				map.put(stockcompleto.stock_vendido, e.getString(stockcompleto.stock_vendido));
				map.put(stockcompleto.last_update, e.getString(stockcompleto.last_update));
				map.put(stockcompleto.producto_id_producto, e.getString(stockcompleto.producto_id_producto));
				map.put(stockcompleto.empresa_id_empresa, e.getString(stockcompleto.empresa_id_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("subcategoria"))
		{
			jArray = json.getJSONArray("subcategoria");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(subcategoria.id_subcategoria, e.getString(subcategoria.id_subcategoria));
				map.put(subcategoria.nombre_subcategoria, e.getString(subcategoria.nombre_subcategoria));
				map.put(subcategoria.descripcion_subcategoria, e.getString(subcategoria.descripcion_subcategoria));
				map.put(subcategoria.categoria_id_categoria, e.getString(subcategoria.categoria_id_categoria));
				mylist.add(map);
			}
		}

		if(funcion.equals("subrubro"))
		{
			jArray = json.getJSONArray("subrubro");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(subrubro.id_subrubro, e.getString(subrubro.id_subrubro));
				map.put(subrubro.nombre_subrubro, e.getString(subrubro.nombre_subrubro));
				map.put(subrubro.rubro_id_rubro, e.getString(subrubro.rubro_id_rubro));
				mylist.add(map);
			}
		}

		if(funcion.equals("talla"))
		{
			jArray = json.getJSONArray("talla");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(talla.id_talla, e.getString(talla.id_talla));
				map.put(talla.am_largo, e.getString(talla.am_largo));
				map.put(talla.am_ancho, e.getString(talla.am_ancho));
				map.put(talla.am_fondo, e.getString(talla.am_fondo));
				map.put(talla.eu_largo, e.getString(talla.eu_largo));
				map.put(talla.eu_ancho, e.getString(talla.eu_ancho));
				map.put(talla.eu_fondo, e.getString(talla.eu_fondo));
				map.put(talla.num_largo, e.getString(talla.num_largo));
				map.put(talla.num_ancho, e.getString(talla.num_ancho));
				map.put(talla.num_fondo, e.getString(talla.num_fondo));
				map.put(talla.producto_id_producto, e.getString(talla.producto_id_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("tipo_documento"))
		{
			jArray = json.getJSONArray("tipo_documento");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(tipo_documento.id_tipo_documento, e.getString(tipo_documento.id_tipo_documento));
				map.put(tipo_documento.nombre_tipo_documento, e.getString(tipo_documento.nombre_tipo_documento));
				mylist.add(map);
			}
		}

		if(funcion.equals("tipo_empresa"))
		{
			jArray = json.getJSONArray("tipo_empresa");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(tipo_empresa.id_tipo_empresa, e.getString(tipo_empresa.id_tipo_empresa));
				map.put(tipo_empresa.nombre_tipo_empresa, e.getString(tipo_empresa.nombre_tipo_empresa));
				map.put(tipo_empresa.categoria_empresa_id_categoria_empresa, e.getString(tipo_empresa.categoria_empresa_id_categoria_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("tipo_pago"))
		{
			jArray = json.getJSONArray("tipo_pago");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(tipo_pago.id_tipo_pago, e.getString(tipo_pago.id_tipo_pago));
				map.put(tipo_pago.nombre_tipo_pago, e.getString(tipo_pago.nombre_tipo_pago));
				map.put(tipo_pago.comision_tipo_pago, e.getString(tipo_pago.comision_tipo_pago));
				mylist.add(map);
			}
		}

		if(funcion.equals("tipo_producto"))
		{
			jArray = json.getJSONArray("tipo_producto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(tipo_producto.id_tipo_producto, e.getString(tipo_producto.id_tipo_producto));
				map.put(tipo_producto.nombre_tipo_producto, e.getString(tipo_producto.nombre_tipo_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("tipo_usuario"))
		{
			jArray = json.getJSONArray("tipo_usuario");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(tipo_usuario.id_tipo_usuario, e.getString(tipo_usuario.id_tipo_usuario));
				map.put(tipo_usuario.nombre_tipo_usuario, e.getString(tipo_usuario.nombre_tipo_usuario));
				mylist.add(map);
			}
		}

		if(funcion.equals("ubicacion"))
		{
			jArray = json.getJSONArray("ubicacion");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(ubicacion.id_ubicacion, e.getString(ubicacion.id_ubicacion));
				map.put(ubicacion.numero_ubicacion, e.getString(ubicacion.numero_ubicacion));
				map.put(ubicacion.numero_interior, e.getString(ubicacion.numero_interior));
				map.put(ubicacion.telefono_ubicacion, e.getString(ubicacion.telefono_ubicacion));
				map.put(ubicacion.default_ubicacion, e.getString(ubicacion.default_ubicacion));
				map.put(ubicacion.calle_id_calle, e.getString(ubicacion.calle_id_calle));
				map.put(ubicacion.empresa_id_empresa, e.getString(ubicacion.empresa_id_empresa));
				map.put(ubicacion.usuario_id_usuario, e.getString(ubicacion.usuario_id_usuario));
				mylist.add(map);
			}
		}

		if(funcion.equals("usuario"))
		{
			jArray = json.getJSONArray("usuario");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(usuario.id_usuario, e.getString(usuario.id_usuario));
				map.put(usuario.tipo_usuario, e.getString(usuario.tipo_usuario));
				map.put(usuario.nombre_usuario, e.getString(usuario.nombre_usuario));
				map.put(usuario.clave, e.getString(usuario.clave));
				map.put(usuario.cliente_id_cliente, e.getString(usuario.cliente_id_cliente));
				map.put(usuario.cliente_empresa_id_cliente_empresa, e.getString(usuario.cliente_empresa_id_cliente_empresa));
				mylist.add(map);
			}
		}

		if(funcion.equals("usuariocompleto"))
		{
			jArray = json.getJSONArray("usuariocompleto");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(usuariocompleto.id_persona, e.getString(usuariocompleto.id_persona));
				map.put(usuariocompleto.rut_persona, e.getString(usuariocompleto.rut_persona));
				map.put(usuariocompleto.digito_verificador, e.getString(usuariocompleto.digito_verificador));
				map.put(usuariocompleto.nombre_persona, e.getString(usuariocompleto.nombre_persona));
				map.put(usuariocompleto.segundo_nombre_persona, e.getString(usuariocompleto.segundo_nombre_persona));
				map.put(usuariocompleto.apellido_persona, e.getString(usuariocompleto.apellido_persona));
				map.put(usuariocompleto.segundo_apellido_persona, e.getString(usuariocompleto.segundo_apellido_persona));
				map.put(usuariocompleto.actividad, e.getString(usuariocompleto.actividad));
				map.put(usuariocompleto.area_actividad, e.getString(usuariocompleto.area_actividad));
				map.put(usuariocompleto.dia_fecha_nacimiento, e.getString(usuariocompleto.dia_fecha_nacimiento));
				map.put(usuariocompleto.mes_fecha_nacimiento, e.getString(usuariocompleto.mes_fecha_nacimiento));
				map.put(usuariocompleto.ano_fecha_nacimiento, e.getString(usuariocompleto.ano_fecha_nacimiento));
				map.put(usuariocompleto.edad, e.getString(usuariocompleto.edad));
				map.put(usuariocompleto.email, e.getString(usuariocompleto.email));
				map.put(usuariocompleto.celular, e.getString(usuariocompleto.celular));
				map.put(usuariocompleto.telefono, e.getString(usuariocompleto.telefono));
				map.put(usuariocompleto.id_carne_empresa, e.getString(usuariocompleto.id_carne_empresa));
				map.put(usuariocompleto.nombre_usuario, e.getString(usuariocompleto.nombre_usuario));
				map.put(usuariocompleto.clave_usuario, e.getString(usuariocompleto.clave_usuario));
				map.put(usuariocompleto.empresa_id_empresa, e.getString(usuariocompleto.empresa_id_empresa));
				map.put(usuariocompleto.persona_id_persona, e.getString(usuariocompleto.persona_id_persona));
				map.put(usuariocompleto.tipo_usuario_id_tipo_usuario, e.getString(usuariocompleto.tipo_usuario_id_tipo_usuario));
				mylist.add(map);
			}
		}

		if(funcion.equals("valor_nutricional"))
		{
			jArray = json.getJSONArray("valor_nutricional");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(valor_nutricional.id_valor_nutricional, e.getString(valor_nutricional.id_valor_nutricional));
				map.put(valor_nutricional.nombre_valor, e.getString(valor_nutricional.nombre_valor));
				map.put(valor_nutricional.cantidad, e.getString(valor_nutricional.cantidad));
				map.put(valor_nutricional.valor_diario_total, e.getString(valor_nutricional.valor_diario_total));
				map.put(valor_nutricional.porcentaje_requerimientos, e.getString(valor_nutricional.porcentaje_requerimientos));
				map.put(valor_nutricional.producto_id_producto, e.getString(valor_nutricional.producto_id_producto));
				mylist.add(map);
			}
		}

		if(funcion.equals("venta"))
		{
			jArray = json.getJSONArray("venta");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(venta.id_venta, e.getString(venta.id_venta));
				map.put(venta.numero_articulos, e.getString(venta.numero_articulos));
				map.put(venta.total, e.getString(venta.total));
				map.put(venta.dia_fecha_venta, e.getString(venta.dia_fecha_venta));
				map.put(venta.mes_fecha_venta, e.getString(venta.mes_fecha_venta));
				map.put(venta.anno_fecha_venta, e.getString(venta.anno_fecha_venta));
				map.put(venta.hora_fecha_venta, e.getString(venta.hora_fecha_venta));
				map.put(venta.usuario_id_usuario, e.getString(venta.usuario_id_usuario));
				map.put(venta.carne_empresa_id_carne_empresa, e.getString(venta.carne_empresa_id_carne_empresa));
				map.put(venta.tipo_pago_id_tipo_pago, e.getString(venta.tipo_pago_id_tipo_pago));
				map.put(venta.tipo_documento_id_tipo_documento, e.getString(venta.tipo_documento_id_tipo_documento));
				mylist.add(map);
			}
		}

		if(funcion.equals("ventacompleta"))
		{
			jArray = json.getJSONArray("ventacompleta");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(ventacompleta.id_venta, e.getString(ventacompleta.id_venta));
				map.put(ventacompleta.numero_articulos, e.getString(ventacompleta.numero_articulos));
				map.put(ventacompleta.total, e.getString(ventacompleta.total));
				map.put(ventacompleta.dia_fecha_venta, e.getString(ventacompleta.dia_fecha_venta));
				map.put(ventacompleta.mes_fecha_venta, e.getString(ventacompleta.mes_fecha_venta));
				map.put(ventacompleta.anno_fecha_venta, e.getString(ventacompleta.anno_fecha_venta));
				map.put(ventacompleta.hora_fecha_venta, e.getString(ventacompleta.hora_fecha_venta));
				map.put(ventacompleta.usuario_id_usuario, e.getString(ventacompleta.usuario_id_usuario));
				map.put(ventacompleta.carne_empresa_id_carne_empresa, e.getString(ventacompleta.carne_empresa_id_carne_empresa));
				map.put(ventacompleta.tipo_pago_id_tipo_pago, e.getString(ventacompleta.tipo_pago_id_tipo_pago));
				map.put(ventacompleta.tipo_documento_id_tipo_documento, e.getString(ventacompleta.tipo_documento_id_tipo_documento));
				map.put(ventacompleta.id_tipo_pago, e.getString(ventacompleta.id_tipo_pago));
				map.put(ventacompleta.nombre_tipo_pago, e.getString(ventacompleta.nombre_tipo_pago));
				map.put(ventacompleta.comision_tipo_pago, e.getString(ventacompleta.comision_tipo_pago));
				map.put(ventacompleta.id_tipo_documento, e.getString(ventacompleta.id_tipo_documento));
				map.put(ventacompleta.nombre_tipo_documento, e.getString(ventacompleta.nombre_tipo_documento));
				mylist.add(map);
			}
		}

		Log.e(TAG, "return mylist");
		return mylist;
	}
}
