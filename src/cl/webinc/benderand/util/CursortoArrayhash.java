package cl.webinc.benderand.util;

import java.util.ArrayList;
import java.util.HashMap;

import android.database.Cursor;
import cl.webinc.benderand.provider.Base.*;

public class CursortoArrayhash {

	private static CursortoArrayhash cta;
	private CursortoArrayhash() {
		super();
	}
	public static CursortoArrayhash getinstance() 
	{
		if(cta == null)
		{
			cta = new CursortoArrayhash();
		}
		return cta;       	
	}
	public ArrayList<HashMap<String, String>> ahActividad(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(actividad.id_actividad, c.getString(c.getColumnIndex(actividad.id_actividad)));
			map.put(actividad.nombre_actividad, c.getString(c.getColumnIndex(actividad.nombre_actividad)));
			map.put(actividad.codigo_actividad, c.getString(c.getColumnIndex(actividad.codigo_actividad)));
			map.put(actividad.categoria_actividad, c.getString(c.getColumnIndex(actividad.categoria_actividad)));
			map.put(actividad.afectoiva_actividad, c.getString(c.getColumnIndex(actividad.afectoiva_actividad)));
			map.put(actividad.disponible_internet_actividad, c.getString(c.getColumnIndex(actividad.disponible_internet_actividad)));
			map.put(actividad.subrubro_id_subrubro, c.getString(c.getColumnIndex(actividad.subrubro_id_subrubro)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCalle(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(calle.id_calle, c.getString(c.getColumnIndex(calle.id_calle)));
			map.put(calle.nombre_calle, c.getString(c.getColumnIndex(calle.nombre_calle)));
			map.put(calle.comuna_id_comuna, c.getString(c.getColumnIndex(calle.comuna_id_comuna)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCaracteristica(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(caracteristica.id_caracteristica, c.getString(c.getColumnIndex(caracteristica.id_caracteristica)));
			map.put(caracteristica.numero_caracteristica, c.getString(c.getColumnIndex(caracteristica.numero_caracteristica)));
			map.put(caracteristica.caracteristica, c.getString(c.getColumnIndex(caracteristica.caracteristica)));
			map.put(caracteristica.valor_caracteristica, c.getString(c.getColumnIndex(caracteristica.valor_caracteristica)));
			map.put(caracteristica.producto_id_producto, c.getString(c.getColumnIndex(caracteristica.producto_id_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarne_empresa(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carne_empresa.id_carne_empresa, c.getString(c.getColumnIndex(carne_empresa.id_carne_empresa)));
			map.put(carne_empresa.nombre_usuario, c.getString(c.getColumnIndex(carne_empresa.nombre_usuario)));
			map.put(carne_empresa.clave_usuario, c.getString(c.getColumnIndex(carne_empresa.clave_usuario)));
			map.put(carne_empresa.empresa_id_empresa, c.getString(c.getColumnIndex(carne_empresa.empresa_id_empresa)));
			map.put(carne_empresa.persona_id_persona, c.getString(c.getColumnIndex(carne_empresa.persona_id_persona)));
			map.put(carne_empresa.tipo_usuario_id_tipo_usuario, c.getString(c.getColumnIndex(carne_empresa.tipo_usuario_id_tipo_usuario)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarne_empresacompleto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carne_empresacompleto.id_carne_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.id_carne_empresa)));
			map.put(carne_empresacompleto.nombre_usuario, c.getString(c.getColumnIndex(carne_empresacompleto.nombre_usuario)));
			map.put(carne_empresacompleto.clave_usuario, c.getString(c.getColumnIndex(carne_empresacompleto.clave_usuario)));
			map.put(carne_empresacompleto.tipo_usuario_id_tipo_usuario, c.getString(c.getColumnIndex(carne_empresacompleto.tipo_usuario_id_tipo_usuario)));
			map.put(carne_empresacompleto.id_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.id_empresa)));
			map.put(carne_empresacompleto.rut_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.rut_empresa)));
			map.put(carne_empresacompleto.digito_verificador_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.digito_verificador_empresa)));
			map.put(carne_empresacompleto.nombre_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.nombre_empresa)));
			map.put(carne_empresacompleto.nombre_contacto_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.nombre_contacto_empresa)));
			map.put(carne_empresacompleto.cargo_contacto_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.cargo_contacto_empresa)));
			map.put(carne_empresacompleto.email_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.email_empresa)));
			map.put(carne_empresacompleto.alcance_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.alcance_empresa)));
			map.put(carne_empresacompleto.telefono_empresa, c.getString(c.getColumnIndex(carne_empresacompleto.telefono_empresa)));
			map.put(carne_empresacompleto.actividad_id_actividad, c.getString(c.getColumnIndex(carne_empresacompleto.actividad_id_actividad)));
			map.put(carne_empresacompleto.id_persona, c.getString(c.getColumnIndex(carne_empresacompleto.id_persona)));
			map.put(carne_empresacompleto.rut_persona, c.getString(c.getColumnIndex(carne_empresacompleto.rut_persona)));
			map.put(carne_empresacompleto.digito_verificador, c.getString(c.getColumnIndex(carne_empresacompleto.digito_verificador)));
			map.put(carne_empresacompleto.nombre_persona, c.getString(c.getColumnIndex(carne_empresacompleto.nombre_persona)));
			map.put(carne_empresacompleto.segundo_nombre_persona, c.getString(c.getColumnIndex(carne_empresacompleto.segundo_nombre_persona)));
			map.put(carne_empresacompleto.apellido_persona, c.getString(c.getColumnIndex(carne_empresacompleto.apellido_persona)));
			map.put(carne_empresacompleto.segundo_apellido_persona, c.getString(c.getColumnIndex(carne_empresacompleto.segundo_apellido_persona)));
			map.put(carne_empresacompleto.actividad, c.getString(c.getColumnIndex(carne_empresacompleto.actividad)));
			map.put(carne_empresacompleto.area_actividad, c.getString(c.getColumnIndex(carne_empresacompleto.area_actividad)));
			map.put(carne_empresacompleto.dia_fecha_nacimiento, c.getString(c.getColumnIndex(carne_empresacompleto.dia_fecha_nacimiento)));
			map.put(carne_empresacompleto.mes_fecha_nacimiento, c.getString(c.getColumnIndex(carne_empresacompleto.mes_fecha_nacimiento)));
			map.put(carne_empresacompleto.ano_fecha_nacimiento, c.getString(c.getColumnIndex(carne_empresacompleto.ano_fecha_nacimiento)));
			map.put(carne_empresacompleto.edad, c.getString(c.getColumnIndex(carne_empresacompleto.edad)));
			map.put(carne_empresacompleto.email, c.getString(c.getColumnIndex(carne_empresacompleto.email)));
			map.put(carne_empresacompleto.celular, c.getString(c.getColumnIndex(carne_empresacompleto.celular)));
			map.put(carne_empresacompleto.telefono, c.getString(c.getColumnIndex(carne_empresacompleto.telefono)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarro_compras(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carro_compras.id_carro_compras, c.getString(c.getColumnIndex(carro_compras.id_carro_compras)));
			map.put(carro_compras.cantidad_carro, c.getString(c.getColumnIndex(carro_compras.cantidad_carro)));
			map.put(carro_compras.precio_carro, c.getString(c.getColumnIndex(carro_compras.precio_carro)));
			map.put(carro_compras.mayor, c.getString(c.getColumnIndex(carro_compras.mayor)));
			map.put(carro_compras.tienda, c.getString(c.getColumnIndex(carro_compras.tienda)));
			map.put(carro_compras.usuario_id_usuario, c.getString(c.getColumnIndex(carro_compras.usuario_id_usuario)));
			map.put(carro_compras.producto_id_producto, c.getString(c.getColumnIndex(carro_compras.producto_id_producto)));
			map.put(carro_compras.empresa_id_empresa, c.getString(c.getColumnIndex(carro_compras.empresa_id_empresa)));
			map.put(carro_compras.usado, c.getString(c.getColumnIndex(carro_compras.usado)));
			map.put(carro_compras.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(carro_compras.carne_empresa_id_carne_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarro_comprascompleto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carro_comprascompleto.id_carro_compras, c.getString(c.getColumnIndex(carro_comprascompleto.id_carro_compras)));
			map.put(carro_comprascompleto.cantidad_carro, c.getString(c.getColumnIndex(carro_comprascompleto.cantidad_carro)));
			map.put(carro_comprascompleto.precio_carro, c.getString(c.getColumnIndex(carro_comprascompleto.precio_carro)));
			map.put(carro_comprascompleto.mayor, c.getString(c.getColumnIndex(carro_comprascompleto.mayor)));
			map.put(carro_comprascompleto.tienda, c.getString(c.getColumnIndex(carro_comprascompleto.tienda)));
			map.put(carro_comprascompleto.usuario_id_usuario, c.getString(c.getColumnIndex(carro_comprascompleto.usuario_id_usuario)));
			map.put(carro_comprascompleto.usado, c.getString(c.getColumnIndex(carro_comprascompleto.usado)));
			map.put(carro_comprascompleto.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(carro_comprascompleto.carne_empresa_id_carne_empresa)));
			map.put(carro_comprascompleto.id_precio, c.getString(c.getColumnIndex(carro_comprascompleto.id_precio)));
			map.put(carro_comprascompleto.precio_CLP, c.getString(c.getColumnIndex(carro_comprascompleto.precio_CLP)));
			map.put(carro_comprascompleto.precio_us, c.getString(c.getColumnIndex(carro_comprascompleto.precio_us)));
			map.put(carro_comprascompleto.precio_mayor_CLP, c.getString(c.getColumnIndex(carro_comprascompleto.precio_mayor_CLP)));
			map.put(carro_comprascompleto.precio_mayor_us, c.getString(c.getColumnIndex(carro_comprascompleto.precio_mayor_us)));
			map.put(carro_comprascompleto.precio_actual, c.getString(c.getColumnIndex(carro_comprascompleto.precio_actual)));
			map.put(carro_comprascompleto.descuento_promocion, c.getString(c.getColumnIndex(carro_comprascompleto.descuento_promocion)));
			map.put(carro_comprascompleto.cantidad_mayor, c.getString(c.getColumnIndex(carro_comprascompleto.cantidad_mayor)));
			map.put(carro_comprascompleto.id_producto, c.getString(c.getColumnIndex(carro_comprascompleto.id_producto)));
			map.put(carro_comprascompleto.codigo_producto, c.getString(c.getColumnIndex(carro_comprascompleto.codigo_producto)));
			map.put(carro_comprascompleto.numero_serie, c.getString(c.getColumnIndex(carro_comprascompleto.numero_serie)));
			map.put(carro_comprascompleto.descripcion_producto, c.getString(c.getColumnIndex(carro_comprascompleto.descripcion_producto)));
			map.put(carro_comprascompleto.nombre_producto, c.getString(c.getColumnIndex(carro_comprascompleto.nombre_producto)));
			map.put(carro_comprascompleto.marca_producto, c.getString(c.getColumnIndex(carro_comprascompleto.marca_producto)));
			map.put(carro_comprascompleto.modelo_producto, c.getString(c.getColumnIndex(carro_comprascompleto.modelo_producto)));
			map.put(carro_comprascompleto.contenido_unidad, c.getString(c.getColumnIndex(carro_comprascompleto.contenido_unidad)));
			map.put(carro_comprascompleto.unidad_minima, c.getString(c.getColumnIndex(carro_comprascompleto.unidad_minima)));
			map.put(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(carro_comprascompleto.contenido, c.getString(c.getColumnIndex(carro_comprascompleto.contenido)));
			map.put(carro_comprascompleto.peso_neto, c.getString(c.getColumnIndex(carro_comprascompleto.peso_neto)));
			map.put(carro_comprascompleto.alto_cm, c.getString(c.getColumnIndex(carro_comprascompleto.alto_cm)));
			map.put(carro_comprascompleto.ancho_cm, c.getString(c.getColumnIndex(carro_comprascompleto.ancho_cm)));
			map.put(carro_comprascompleto.fondo_cm, c.getString(c.getColumnIndex(carro_comprascompleto.fondo_cm)));
			map.put(carro_comprascompleto.fabricante, c.getString(c.getColumnIndex(carro_comprascompleto.fabricante)));
			map.put(carro_comprascompleto.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(carro_comprascompleto.familia_necesidad_id_familia_necesidad)));
			map.put(carro_comprascompleto.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(carro_comprascompleto.familia_producto_id_familia_producto)));
			map.put(carro_comprascompleto.clase_producto, c.getString(c.getColumnIndex(carro_comprascompleto.clase_producto)));
			map.put(carro_comprascompleto.linea_producto, c.getString(c.getColumnIndex(carro_comprascompleto.linea_producto)));
			map.put(carro_comprascompleto.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(carro_comprascompleto.tipo_producto_id_tipo_producto)));
			map.put(carro_comprascompleto.hot, c.getString(c.getColumnIndex(carro_comprascompleto.hot)));
			map.put(carro_comprascompleto.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(carro_comprascompleto.subcategoria_id_subcategoria)));
			map.put(carro_comprascompleto.SKU, c.getString(c.getColumnIndex(carro_comprascompleto.SKU)));
			map.put(carro_comprascompleto.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(carro_comprascompleto.formato_producto_id_formato_producto)));
			map.put(carro_comprascompleto.stock_tienda, c.getString(c.getColumnIndex(carro_comprascompleto.stock_tienda)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarro_egresos(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carro_egresos.id_carro_egresos, c.getString(c.getColumnIndex(carro_egresos.id_carro_egresos)));
			map.put(carro_egresos.cantidad_carro, c.getString(c.getColumnIndex(carro_egresos.cantidad_carro)));
			map.put(carro_egresos.precio_carro, c.getString(c.getColumnIndex(carro_egresos.precio_carro)));
			map.put(carro_egresos.mayor, c.getString(c.getColumnIndex(carro_egresos.mayor)));
			map.put(carro_egresos.tienda, c.getString(c.getColumnIndex(carro_egresos.tienda)));
			map.put(carro_egresos.usado, c.getString(c.getColumnIndex(carro_egresos.usado)));
			map.put(carro_egresos.producto_id_producto, c.getString(c.getColumnIndex(carro_egresos.producto_id_producto)));
			map.put(carro_egresos.usuario_id_usuario, c.getString(c.getColumnIndex(carro_egresos.usuario_id_usuario)));
			map.put(carro_egresos.empresa_id_empresa, c.getString(c.getColumnIndex(carro_egresos.empresa_id_empresa)));
			map.put(carro_egresos.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(carro_egresos.carne_empresa_id_carne_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarro_egresoscompleto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carro_egresoscompleto.id_carro_egresos, c.getString(c.getColumnIndex(carro_egresoscompleto.id_carro_egresos)));
			map.put(carro_egresoscompleto.cantidad_carro, c.getString(c.getColumnIndex(carro_egresoscompleto.cantidad_carro)));
			map.put(carro_egresoscompleto.precio_carro, c.getString(c.getColumnIndex(carro_egresoscompleto.precio_carro)));
			map.put(carro_egresoscompleto.mayor, c.getString(c.getColumnIndex(carro_egresoscompleto.mayor)));
			map.put(carro_egresoscompleto.tienda, c.getString(c.getColumnIndex(carro_egresoscompleto.tienda)));
			map.put(carro_egresoscompleto.usuario_id_usuario, c.getString(c.getColumnIndex(carro_egresoscompleto.usuario_id_usuario)));
			map.put(carro_egresoscompleto.usado, c.getString(c.getColumnIndex(carro_egresoscompleto.usado)));
			map.put(carro_egresoscompleto.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(carro_egresoscompleto.carne_empresa_id_carne_empresa)));
			map.put(carro_egresoscompleto.id_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.id_producto)));
			map.put(carro_egresoscompleto.codigo_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.codigo_producto)));
			map.put(carro_egresoscompleto.numero_serie, c.getString(c.getColumnIndex(carro_egresoscompleto.numero_serie)));
			map.put(carro_egresoscompleto.descripcion_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.descripcion_producto)));
			map.put(carro_egresoscompleto.nombre_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.nombre_producto)));
			map.put(carro_egresoscompleto.marca_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.marca_producto)));
			map.put(carro_egresoscompleto.modelo_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.modelo_producto)));
			map.put(carro_egresoscompleto.contenido_unidad, c.getString(c.getColumnIndex(carro_egresoscompleto.contenido_unidad)));
			map.put(carro_egresoscompleto.unidad_minima, c.getString(c.getColumnIndex(carro_egresoscompleto.unidad_minima)));
			map.put(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(carro_egresoscompleto.contenido, c.getString(c.getColumnIndex(carro_egresoscompleto.contenido)));
			map.put(carro_egresoscompleto.peso_neto, c.getString(c.getColumnIndex(carro_egresoscompleto.peso_neto)));
			map.put(carro_egresoscompleto.alto_cm, c.getString(c.getColumnIndex(carro_egresoscompleto.alto_cm)));
			map.put(carro_egresoscompleto.ancho_cm, c.getString(c.getColumnIndex(carro_egresoscompleto.ancho_cm)));
			map.put(carro_egresoscompleto.fondo_cm, c.getString(c.getColumnIndex(carro_egresoscompleto.fondo_cm)));
			map.put(carro_egresoscompleto.fabricante, c.getString(c.getColumnIndex(carro_egresoscompleto.fabricante)));
			map.put(carro_egresoscompleto.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(carro_egresoscompleto.familia_necesidad_id_familia_necesidad)));
			map.put(carro_egresoscompleto.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.familia_producto_id_familia_producto)));
			map.put(carro_egresoscompleto.clase_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.clase_producto)));
			map.put(carro_egresoscompleto.linea_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.linea_producto)));
			map.put(carro_egresoscompleto.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.tipo_producto_id_tipo_producto)));
			map.put(carro_egresoscompleto.hot, c.getString(c.getColumnIndex(carro_egresoscompleto.hot)));
			map.put(carro_egresoscompleto.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(carro_egresoscompleto.subcategoria_id_subcategoria)));
			map.put(carro_egresoscompleto.SKU, c.getString(c.getColumnIndex(carro_egresoscompleto.SKU)));
			map.put(carro_egresoscompleto.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(carro_egresoscompleto.formato_producto_id_formato_producto)));
			map.put(carro_egresoscompleto.stock_tienda, c.getString(c.getColumnIndex(carro_egresoscompleto.stock_tienda)));
			map.put(carro_egresoscompleto.precio_CLP, c.getString(c.getColumnIndex(carro_egresoscompleto.precio_CLP)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarro_egresosproducto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carro_egresosproducto.id_carro_egresos, c.getString(c.getColumnIndex(carro_egresosproducto.id_carro_egresos)));
			map.put(carro_egresosproducto.cantidad_carro, c.getString(c.getColumnIndex(carro_egresosproducto.cantidad_carro)));
			map.put(carro_egresosproducto.precio_carro, c.getString(c.getColumnIndex(carro_egresosproducto.precio_carro)));
			map.put(carro_egresosproducto.mayor, c.getString(c.getColumnIndex(carro_egresosproducto.mayor)));
			map.put(carro_egresosproducto.tienda, c.getString(c.getColumnIndex(carro_egresosproducto.tienda)));
			map.put(carro_egresosproducto.usuario_id_usuario, c.getString(c.getColumnIndex(carro_egresosproducto.usuario_id_usuario)));
			map.put(carro_egresosproducto.usado, c.getString(c.getColumnIndex(carro_egresosproducto.usado)));
			map.put(carro_egresosproducto.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(carro_egresosproducto.carne_empresa_id_carne_empresa)));
			map.put(carro_egresosproducto.id_producto, c.getString(c.getColumnIndex(carro_egresosproducto.id_producto)));
			map.put(carro_egresosproducto.codigo_producto, c.getString(c.getColumnIndex(carro_egresosproducto.codigo_producto)));
			map.put(carro_egresosproducto.numero_serie, c.getString(c.getColumnIndex(carro_egresosproducto.numero_serie)));
			map.put(carro_egresosproducto.descripcion_producto, c.getString(c.getColumnIndex(carro_egresosproducto.descripcion_producto)));
			map.put(carro_egresosproducto.nombre_producto, c.getString(c.getColumnIndex(carro_egresosproducto.nombre_producto)));
			map.put(carro_egresosproducto.marca_producto, c.getString(c.getColumnIndex(carro_egresosproducto.marca_producto)));
			map.put(carro_egresosproducto.modelo_producto, c.getString(c.getColumnIndex(carro_egresosproducto.modelo_producto)));
			map.put(carro_egresosproducto.contenido_unidad, c.getString(c.getColumnIndex(carro_egresosproducto.contenido_unidad)));
			map.put(carro_egresosproducto.unidad_minima, c.getString(c.getColumnIndex(carro_egresosproducto.unidad_minima)));
			map.put(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(carro_egresosproducto.contenido, c.getString(c.getColumnIndex(carro_egresosproducto.contenido)));
			map.put(carro_egresosproducto.peso_neto, c.getString(c.getColumnIndex(carro_egresosproducto.peso_neto)));
			map.put(carro_egresosproducto.alto_cm, c.getString(c.getColumnIndex(carro_egresosproducto.alto_cm)));
			map.put(carro_egresosproducto.ancho_cm, c.getString(c.getColumnIndex(carro_egresosproducto.ancho_cm)));
			map.put(carro_egresosproducto.fondo_cm, c.getString(c.getColumnIndex(carro_egresosproducto.fondo_cm)));
			map.put(carro_egresosproducto.fabricante, c.getString(c.getColumnIndex(carro_egresosproducto.fabricante)));
			map.put(carro_egresosproducto.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(carro_egresosproducto.familia_necesidad_id_familia_necesidad)));
			map.put(carro_egresosproducto.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(carro_egresosproducto.familia_producto_id_familia_producto)));
			map.put(carro_egresosproducto.clase_producto, c.getString(c.getColumnIndex(carro_egresosproducto.clase_producto)));
			map.put(carro_egresosproducto.linea_producto, c.getString(c.getColumnIndex(carro_egresosproducto.linea_producto)));
			map.put(carro_egresosproducto.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(carro_egresosproducto.tipo_producto_id_tipo_producto)));
			map.put(carro_egresosproducto.hot, c.getString(c.getColumnIndex(carro_egresosproducto.hot)));
			map.put(carro_egresosproducto.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(carro_egresosproducto.subcategoria_id_subcategoria)));
			map.put(carro_egresosproducto.SKU, c.getString(c.getColumnIndex(carro_egresosproducto.SKU)));
			map.put(carro_egresosproducto.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(carro_egresosproducto.formato_producto_id_formato_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarro_venta(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carro_venta.id_carro_venta, c.getString(c.getColumnIndex(carro_venta.id_carro_venta)));
			map.put(carro_venta.cantidad, c.getString(c.getColumnIndex(carro_venta.cantidad)));
			map.put(carro_venta.precio, c.getString(c.getColumnIndex(carro_venta.precio)));
			map.put(carro_venta.carro_compras_id_carro_compras, c.getString(c.getColumnIndex(carro_venta.carro_compras_id_carro_compras)));
			map.put(carro_venta.venta_id_venta, c.getString(c.getColumnIndex(carro_venta.venta_id_venta)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCarro_ventacompleto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(carro_ventacompleto.id_carro_venta, c.getString(c.getColumnIndex(carro_ventacompleto.id_carro_venta)));
			map.put(carro_ventacompleto.cantidad, c.getString(c.getColumnIndex(carro_ventacompleto.cantidad)));
			map.put(carro_ventacompleto.precio, c.getString(c.getColumnIndex(carro_ventacompleto.precio)));
			map.put(carro_ventacompleto.venta_id_venta, c.getString(c.getColumnIndex(carro_ventacompleto.venta_id_venta)));
			map.put(carro_ventacompleto.id_carro_compras, c.getString(c.getColumnIndex(carro_ventacompleto.id_carro_compras)));
			map.put(carro_ventacompleto.cantidad_carro, c.getString(c.getColumnIndex(carro_ventacompleto.cantidad_carro)));
			map.put(carro_ventacompleto.precio_carro, c.getString(c.getColumnIndex(carro_ventacompleto.precio_carro)));
			map.put(carro_ventacompleto.mayor, c.getString(c.getColumnIndex(carro_ventacompleto.mayor)));
			map.put(carro_ventacompleto.tienda, c.getString(c.getColumnIndex(carro_ventacompleto.tienda)));
			map.put(carro_ventacompleto.usuario_id_usuario, c.getString(c.getColumnIndex(carro_ventacompleto.usuario_id_usuario)));
			map.put(carro_ventacompleto.usado, c.getString(c.getColumnIndex(carro_ventacompleto.usado)));
			map.put(carro_ventacompleto.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(carro_ventacompleto.carne_empresa_id_carne_empresa)));
			map.put(carro_ventacompleto.id_precio, c.getString(c.getColumnIndex(carro_ventacompleto.id_precio)));
			map.put(carro_ventacompleto.precio_CLP, c.getString(c.getColumnIndex(carro_ventacompleto.precio_CLP)));
			map.put(carro_ventacompleto.precio_us, c.getString(c.getColumnIndex(carro_ventacompleto.precio_us)));
			map.put(carro_ventacompleto.precio_mayor_CLP, c.getString(c.getColumnIndex(carro_ventacompleto.precio_mayor_CLP)));
			map.put(carro_ventacompleto.precio_mayor_us, c.getString(c.getColumnIndex(carro_ventacompleto.precio_mayor_us)));
			map.put(carro_ventacompleto.precio_actual, c.getString(c.getColumnIndex(carro_ventacompleto.precio_actual)));
			map.put(carro_ventacompleto.descuento_promocion, c.getString(c.getColumnIndex(carro_ventacompleto.descuento_promocion)));
			map.put(carro_ventacompleto.cantidad_mayor, c.getString(c.getColumnIndex(carro_ventacompleto.cantidad_mayor)));
			map.put(carro_ventacompleto.id_producto, c.getString(c.getColumnIndex(carro_ventacompleto.id_producto)));
			map.put(carro_ventacompleto.codigo_producto, c.getString(c.getColumnIndex(carro_ventacompleto.codigo_producto)));
			map.put(carro_ventacompleto.numero_serie, c.getString(c.getColumnIndex(carro_ventacompleto.numero_serie)));
			map.put(carro_ventacompleto.descripcion_producto, c.getString(c.getColumnIndex(carro_ventacompleto.descripcion_producto)));
			map.put(carro_ventacompleto.nombre_producto, c.getString(c.getColumnIndex(carro_ventacompleto.nombre_producto)));
			map.put(carro_ventacompleto.marca_producto, c.getString(c.getColumnIndex(carro_ventacompleto.marca_producto)));
			map.put(carro_ventacompleto.modelo_producto, c.getString(c.getColumnIndex(carro_ventacompleto.modelo_producto)));
			map.put(carro_ventacompleto.contenido_unidad, c.getString(c.getColumnIndex(carro_ventacompleto.contenido_unidad)));
			map.put(carro_ventacompleto.unidad_minima, c.getString(c.getColumnIndex(carro_ventacompleto.unidad_minima)));
			map.put(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(carro_ventacompleto.contenido, c.getString(c.getColumnIndex(carro_ventacompleto.contenido)));
			map.put(carro_ventacompleto.peso_neto, c.getString(c.getColumnIndex(carro_ventacompleto.peso_neto)));
			map.put(carro_ventacompleto.alto_cm, c.getString(c.getColumnIndex(carro_ventacompleto.alto_cm)));
			map.put(carro_ventacompleto.ancho_cm, c.getString(c.getColumnIndex(carro_ventacompleto.ancho_cm)));
			map.put(carro_ventacompleto.fondo_cm, c.getString(c.getColumnIndex(carro_ventacompleto.fondo_cm)));
			map.put(carro_ventacompleto.fabricante, c.getString(c.getColumnIndex(carro_ventacompleto.fabricante)));
			map.put(carro_ventacompleto.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(carro_ventacompleto.familia_necesidad_id_familia_necesidad)));
			map.put(carro_ventacompleto.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(carro_ventacompleto.familia_producto_id_familia_producto)));
			map.put(carro_ventacompleto.clase_producto, c.getString(c.getColumnIndex(carro_ventacompleto.clase_producto)));
			map.put(carro_ventacompleto.linea_producto, c.getString(c.getColumnIndex(carro_ventacompleto.linea_producto)));
			map.put(carro_ventacompleto.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(carro_ventacompleto.tipo_producto_id_tipo_producto)));
			map.put(carro_ventacompleto.hot, c.getString(c.getColumnIndex(carro_ventacompleto.hot)));
			map.put(carro_ventacompleto.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(carro_ventacompleto.subcategoria_id_subcategoria)));
			map.put(carro_ventacompleto.SKU, c.getString(c.getColumnIndex(carro_ventacompleto.SKU)));
			map.put(carro_ventacompleto.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(carro_ventacompleto.formato_producto_id_formato_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCategoria(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(categoria.id_categoria, c.getString(c.getColumnIndex(categoria.id_categoria)));
			map.put(categoria.nombre_categoria, c.getString(c.getColumnIndex(categoria.nombre_categoria)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCategoria_empresa(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(categoria_empresa.id_categoria_empresa, c.getString(c.getColumnIndex(categoria_empresa.id_categoria_empresa)));
			map.put(categoria_empresa.nombre_categoria_empresa, c.getString(c.getColumnIndex(categoria_empresa.nombre_categoria_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCi_sessions(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(ci_sessions.session_id, c.getString(c.getColumnIndex(ci_sessions.session_id)));
			map.put(ci_sessions.ip_address, c.getString(c.getColumnIndex(ci_sessions.ip_address)));
			map.put(ci_sessions.user_agent, c.getString(c.getColumnIndex(ci_sessions.user_agent)));
			map.put(ci_sessions.id_user, c.getString(c.getColumnIndex(ci_sessions.id_user)));
			map.put(ci_sessions.nombre_apellido, c.getString(c.getColumnIndex(ci_sessions.nombre_apellido)));
			map.put(ci_sessions.email_user, c.getString(c.getColumnIndex(ci_sessions.email_user)));
			map.put(ci_sessions.last_activity, c.getString(c.getColumnIndex(ci_sessions.last_activity)));
			map.put(ci_sessions.user_data, c.getString(c.getColumnIndex(ci_sessions.user_data)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCliente(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(cliente.id_cliente, c.getString(c.getColumnIndex(cliente.id_cliente)));
			map.put(cliente.rut_cliente, c.getString(c.getColumnIndex(cliente.rut_cliente)));
			map.put(cliente.digito_verificador, c.getString(c.getColumnIndex(cliente.digito_verificador)));
			map.put(cliente.nombre_cliente, c.getString(c.getColumnIndex(cliente.nombre_cliente)));
			map.put(cliente.segundo_nombre_cliente, c.getString(c.getColumnIndex(cliente.segundo_nombre_cliente)));
			map.put(cliente.apellido_cliente, c.getString(c.getColumnIndex(cliente.apellido_cliente)));
			map.put(cliente.segundo_apellido_cliente, c.getString(c.getColumnIndex(cliente.segundo_apellido_cliente)));
			map.put(cliente.actividad, c.getString(c.getColumnIndex(cliente.actividad)));
			map.put(cliente.area_actividad, c.getString(c.getColumnIndex(cliente.area_actividad)));
			map.put(cliente.dia_fecha_nacimiento, c.getString(c.getColumnIndex(cliente.dia_fecha_nacimiento)));
			map.put(cliente.mes_fecha_nacimiento, c.getString(c.getColumnIndex(cliente.mes_fecha_nacimiento)));
			map.put(cliente.ano_fecha_nacimiento, c.getString(c.getColumnIndex(cliente.ano_fecha_nacimiento)));
			map.put(cliente.edad, c.getString(c.getColumnIndex(cliente.edad)));
			map.put(cliente.email, c.getString(c.getColumnIndex(cliente.email)));
			map.put(cliente.celular, c.getString(c.getColumnIndex(cliente.celular)));
			map.put(cliente.telefono, c.getString(c.getColumnIndex(cliente.telefono)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCliente_empresa(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(cliente_empresa.id_cliente_empresa, c.getString(c.getColumnIndex(cliente_empresa.id_cliente_empresa)));
			map.put(cliente_empresa.rut_cliente_empresa, c.getString(c.getColumnIndex(cliente_empresa.rut_cliente_empresa)));
			map.put(cliente_empresa.digito_verificador, c.getString(c.getColumnIndex(cliente_empresa.digito_verificador)));
			map.put(cliente_empresa.nombre, c.getString(c.getColumnIndex(cliente_empresa.nombre)));
			map.put(cliente_empresa.email_cliente_empresa, c.getString(c.getColumnIndex(cliente_empresa.email_cliente_empresa)));
			map.put(cliente_empresa.actividad_id_actividad, c.getString(c.getColumnIndex(cliente_empresa.actividad_id_actividad)));
			map.put(cliente_empresa.empresa_id_empresa, c.getString(c.getColumnIndex(cliente_empresa.empresa_id_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahCompracompleta(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(compracompleta.id_factura, c.getString(c.getColumnIndex(compracompleta.id_factura)));
			map.put(compracompleta.rol_factura, c.getString(c.getColumnIndex(compracompleta.rol_factura)));
			map.put(compracompleta.dia_factura, c.getString(c.getColumnIndex(compracompleta.dia_factura)));
			map.put(compracompleta.mes_factura, c.getString(c.getColumnIndex(compracompleta.mes_factura)));
			map.put(compracompleta.ano_factura, c.getString(c.getColumnIndex(compracompleta.ano_factura)));
			map.put(compracompleta.fecha_factura, c.getString(c.getColumnIndex(compracompleta.fecha_factura)));
			map.put(compracompleta.empresa_id_empresa, c.getString(c.getColumnIndex(compracompleta.empresa_id_empresa)));
			map.put(compracompleta.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(compracompleta.carne_empresa_id_carne_empresa)));
			map.put(compracompleta.rut_proveedor, c.getString(c.getColumnIndex(compracompleta.rut_proveedor)));
			map.put(compracompleta.nombre_proveedor, c.getString(c.getColumnIndex(compracompleta.nombre_proveedor)));
			map.put(compracompleta.telefono_proveedor, c.getString(c.getColumnIndex(compracompleta.telefono_proveedor)));
			map.put(compracompleta.tipo_documento_id_tipo_documento, c.getString(c.getColumnIndex(compracompleta.tipo_documento_id_tipo_documento)));
			map.put(compracompleta.tipo_pago_id_tipo_pago, c.getString(c.getColumnIndex(compracompleta.tipo_pago_id_tipo_pago)));
			map.put(compracompleta.total_factura, c.getString(c.getColumnIndex(compracompleta.total_factura)));
			map.put(compracompleta.id_tipo_pago, c.getString(c.getColumnIndex(compracompleta.id_tipo_pago)));
			map.put(compracompleta.nombre_tipo_pago, c.getString(c.getColumnIndex(compracompleta.nombre_tipo_pago)));
			map.put(compracompleta.comision_tipo_pago, c.getString(c.getColumnIndex(compracompleta.comision_tipo_pago)));
			map.put(compracompleta.id_tipo_documento, c.getString(c.getColumnIndex(compracompleta.id_tipo_documento)));
			map.put(compracompleta.nombre_tipo_documento, c.getString(c.getColumnIndex(compracompleta.nombre_tipo_documento)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahComuna(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(comuna.id_comuna, c.getString(c.getColumnIndex(comuna.id_comuna)));
			map.put(comuna.codigo_comuna, c.getString(c.getColumnIndex(comuna.codigo_comuna)));
			map.put(comuna.nombre_comuna, c.getString(c.getColumnIndex(comuna.nombre_comuna)));
			map.put(comuna.provincia_id_provincia, c.getString(c.getColumnIndex(comuna.provincia_id_provincia)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahContenido_unidad_medida(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(contenido_unidad_medida.id_contenido_unidad_medida, c.getString(c.getColumnIndex(contenido_unidad_medida.id_contenido_unidad_medida)));
			map.put(contenido_unidad_medida.nombre_contenido_unidad_medida, c.getString(c.getColumnIndex(contenido_unidad_medida.nombre_contenido_unidad_medida)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahDia(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(dia.iddia, c.getString(c.getColumnIndex(dia.iddia)));
			map.put(dia.dia, c.getString(c.getColumnIndex(dia.dia)));
			map.put(dia.mes, c.getString(c.getColumnIndex(dia.mes)));
			map.put(dia.anno, c.getString(c.getColumnIndex(dia.anno)));
			map.put(dia.fecha, c.getString(c.getColumnIndex(dia.fecha)));
			map.put(dia.egreso, c.getString(c.getColumnIndex(dia.egreso)));
			map.put(dia.ingreso, c.getString(c.getColumnIndex(dia.ingreso)));
			map.put(dia.impuesto, c.getString(c.getColumnIndex(dia.impuesto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahEmpresa(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(empresa.id_empresa, c.getString(c.getColumnIndex(empresa.id_empresa)));
			map.put(empresa.rut_empresa, c.getString(c.getColumnIndex(empresa.rut_empresa)));
			map.put(empresa.digito_verificador_empresa, c.getString(c.getColumnIndex(empresa.digito_verificador_empresa)));
			map.put(empresa.nombre_empresa, c.getString(c.getColumnIndex(empresa.nombre_empresa)));
			map.put(empresa.nombre_contacto_empresa, c.getString(c.getColumnIndex(empresa.nombre_contacto_empresa)));
			map.put(empresa.cargo_contacto_empresa, c.getString(c.getColumnIndex(empresa.cargo_contacto_empresa)));
			map.put(empresa.email_empresa, c.getString(c.getColumnIndex(empresa.email_empresa)));
			map.put(empresa.alcance_empresa, c.getString(c.getColumnIndex(empresa.alcance_empresa)));
			map.put(empresa.telefono_empresa, c.getString(c.getColumnIndex(empresa.telefono_empresa)));
			map.put(empresa.actividad_id_actividad, c.getString(c.getColumnIndex(empresa.actividad_id_actividad)));
			map.put(empresa.tipo_empresa_id_tipo_empresa, c.getString(c.getColumnIndex(empresa.tipo_empresa_id_tipo_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahEnvio(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(envio.id_envio, c.getString(c.getColumnIndex(envio.id_envio)));
			map.put(envio.direccion_alternativa, c.getString(c.getColumnIndex(envio.direccion_alternativa)));
			map.put(envio.fecha_entrega, c.getString(c.getColumnIndex(envio.fecha_entrega)));
			map.put(envio.hora_entrega, c.getString(c.getColumnIndex(envio.hora_entrega)));
			map.put(envio.venta_id_venta, c.getString(c.getColumnIndex(envio.venta_id_venta)));
			map.put(envio.enviado, c.getString(c.getColumnIndex(envio.enviado)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahFactura(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(factura.id_factura, c.getString(c.getColumnIndex(factura.id_factura)));
			map.put(factura.rol_factura, c.getString(c.getColumnIndex(factura.rol_factura)));
			map.put(factura.dia_factura, c.getString(c.getColumnIndex(factura.dia_factura)));
			map.put(factura.mes_factura, c.getString(c.getColumnIndex(factura.mes_factura)));
			map.put(factura.ano_factura, c.getString(c.getColumnIndex(factura.ano_factura)));
			map.put(factura.fecha_factura, c.getString(c.getColumnIndex(factura.fecha_factura)));
			map.put(factura.empresa_id_empresa, c.getString(c.getColumnIndex(factura.empresa_id_empresa)));
			map.put(factura.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(factura.carne_empresa_id_carne_empresa)));
			map.put(factura.rut_proveedor, c.getString(c.getColumnIndex(factura.rut_proveedor)));
			map.put(factura.nombre_proveedor, c.getString(c.getColumnIndex(factura.nombre_proveedor)));
			map.put(factura.telefono_proveedor, c.getString(c.getColumnIndex(factura.telefono_proveedor)));
			map.put(factura.tipo_documento_id_tipo_documento, c.getString(c.getColumnIndex(factura.tipo_documento_id_tipo_documento)));
			map.put(factura.tipo_pago_id_tipo_pago, c.getString(c.getColumnIndex(factura.tipo_pago_id_tipo_pago)));
			map.put(factura.total_factura, c.getString(c.getColumnIndex(factura.total_factura)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahFamilia_necesidad(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(familia_necesidad.id_familia_necesidad, c.getString(c.getColumnIndex(familia_necesidad.id_familia_necesidad)));
			map.put(familia_necesidad.nombre_familia_necesidad, c.getString(c.getColumnIndex(familia_necesidad.nombre_familia_necesidad)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahFamilia_producto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(familia_producto.id_familia_producto, c.getString(c.getColumnIndex(familia_producto.id_familia_producto)));
			map.put(familia_producto.nombre_familia_producto, c.getString(c.getColumnIndex(familia_producto.nombre_familia_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahFormato_producto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(formato_producto.id_formato_producto, c.getString(c.getColumnIndex(formato_producto.id_formato_producto)));
			map.put(formato_producto.nombre_formato_producto, c.getString(c.getColumnIndex(formato_producto.nombre_formato_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahGasto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(gasto.id_gasto, c.getString(c.getColumnIndex(gasto.id_gasto)));
			map.put(gasto.nombre_gasto, c.getString(c.getColumnIndex(gasto.nombre_gasto)));
			map.put(gasto.id_usuario, c.getString(c.getColumnIndex(gasto.id_usuario)));
			map.put(gasto.monto_gasto, c.getString(c.getColumnIndex(gasto.monto_gasto)));
			map.put(gasto.fecha_gasto, c.getString(c.getColumnIndex(gasto.fecha_gasto)));
			map.put(gasto.empresa_id_empre, c.getString(c.getColumnIndex(gasto.empresa_id_empre)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahGeocode_cache(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(geocode_cache.id, c.getString(c.getColumnIndex(geocode_cache.id)));
			map.put(geocode_cache.lng, c.getString(c.getColumnIndex(geocode_cache.lng)));
			map.put(geocode_cache.lat, c.getString(c.getColumnIndex(geocode_cache.lat)));
			map.put(geocode_cache.query, c.getString(c.getColumnIndex(geocode_cache.query)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahImagenprod(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(imagenprod.id_imagenprod, c.getString(c.getColumnIndex(imagenprod.id_imagenprod)));
			map.put(imagenprod.urlimagenprod, c.getString(c.getColumnIndex(imagenprod.urlimagenprod)));
			map.put(imagenprod.producto_id_producto, c.getString(c.getColumnIndex(imagenprod.producto_id_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahImpuesto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(impuesto.id_impuesto, c.getString(c.getColumnIndex(impuesto.id_impuesto)));
			map.put(impuesto.nombre_impuesto, c.getString(c.getColumnIndex(impuesto.nombre_impuesto)));
			map.put(impuesto.valor_impuesto, c.getString(c.getColumnIndex(impuesto.valor_impuesto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahIngresosegresos(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(ingresosegresos.dia, c.getString(c.getColumnIndex(ingresosegresos.dia)));
			map.put(ingresosegresos.mes, c.getString(c.getColumnIndex(ingresosegresos.mes)));
			map.put(ingresosegresos.anno, c.getString(c.getColumnIndex(ingresosegresos.anno)));
			map.put(ingresosegresos.fecha, c.getString(c.getColumnIndex(ingresosegresos.fecha)));
			map.put(ingresosegresos.totalingreso, c.getString(c.getColumnIndex(ingresosegresos.totalingreso)));
			map.put(ingresosegresos.totalgasto, c.getString(c.getColumnIndex(ingresosegresos.totalgasto)));
			map.put(ingresosegresos.impuestoegreso, c.getString(c.getColumnIndex(ingresosegresos.impuestoegreso)));
			map.put(ingresosegresos.impuestoingreso, c.getString(c.getColumnIndex(ingresosegresos.impuestoingreso)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahItem_factura(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(item_factura.id_itemfactura, c.getString(c.getColumnIndex(item_factura.id_itemfactura)));
			map.put(item_factura.cantidad, c.getString(c.getColumnIndex(item_factura.cantidad)));
			map.put(item_factura.precio, c.getString(c.getColumnIndex(item_factura.precio)));
			map.put(item_factura.producto_id_producto, c.getString(c.getColumnIndex(item_factura.producto_id_producto)));
			map.put(item_factura.factura_id_factura, c.getString(c.getColumnIndex(item_factura.factura_id_factura)));
			map.put(item_factura.carro_egresos_id_carro_egresos, c.getString(c.getColumnIndex(item_factura.carro_egresos_id_carro_egresos)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahItem_facturacompleto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(item_facturacompleto.id_itemfactura, c.getString(c.getColumnIndex(item_facturacompleto.id_itemfactura)));
			map.put(item_facturacompleto.cantidad, c.getString(c.getColumnIndex(item_facturacompleto.cantidad)));
			map.put(item_facturacompleto.precio, c.getString(c.getColumnIndex(item_facturacompleto.precio)));
			map.put(item_facturacompleto.producto_id_producto, c.getString(c.getColumnIndex(item_facturacompleto.producto_id_producto)));
			map.put(item_facturacompleto.factura_id_factura, c.getString(c.getColumnIndex(item_facturacompleto.factura_id_factura)));
			map.put(item_facturacompleto.id_producto, c.getString(c.getColumnIndex(item_facturacompleto.id_producto)));
			map.put(item_facturacompleto.codigo_producto, c.getString(c.getColumnIndex(item_facturacompleto.codigo_producto)));
			map.put(item_facturacompleto.numero_serie, c.getString(c.getColumnIndex(item_facturacompleto.numero_serie)));
			map.put(item_facturacompleto.descripcion_producto, c.getString(c.getColumnIndex(item_facturacompleto.descripcion_producto)));
			map.put(item_facturacompleto.nombre_producto, c.getString(c.getColumnIndex(item_facturacompleto.nombre_producto)));
			map.put(item_facturacompleto.marca_producto, c.getString(c.getColumnIndex(item_facturacompleto.marca_producto)));
			map.put(item_facturacompleto.modelo_producto, c.getString(c.getColumnIndex(item_facturacompleto.modelo_producto)));
			map.put(item_facturacompleto.contenido_unidad, c.getString(c.getColumnIndex(item_facturacompleto.contenido_unidad)));
			map.put(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(item_facturacompleto.unidad_minima, c.getString(c.getColumnIndex(item_facturacompleto.unidad_minima)));
			map.put(item_facturacompleto.contenido, c.getString(c.getColumnIndex(item_facturacompleto.contenido)));
			map.put(item_facturacompleto.peso_neto, c.getString(c.getColumnIndex(item_facturacompleto.peso_neto)));
			map.put(item_facturacompleto.alto_cm, c.getString(c.getColumnIndex(item_facturacompleto.alto_cm)));
			map.put(item_facturacompleto.ancho_cm, c.getString(c.getColumnIndex(item_facturacompleto.ancho_cm)));
			map.put(item_facturacompleto.fondo_cm, c.getString(c.getColumnIndex(item_facturacompleto.fondo_cm)));
			map.put(item_facturacompleto.fabricante, c.getString(c.getColumnIndex(item_facturacompleto.fabricante)));
			map.put(item_facturacompleto.clase_producto, c.getString(c.getColumnIndex(item_facturacompleto.clase_producto)));
			map.put(item_facturacompleto.linea_producto, c.getString(c.getColumnIndex(item_facturacompleto.linea_producto)));
			map.put(item_facturacompleto.hot, c.getString(c.getColumnIndex(item_facturacompleto.hot)));
			map.put(item_facturacompleto.SKU, c.getString(c.getColumnIndex(item_facturacompleto.SKU)));
			map.put(item_facturacompleto.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(item_facturacompleto.subcategoria_id_subcategoria)));
			map.put(item_facturacompleto.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(item_facturacompleto.tipo_producto_id_tipo_producto)));
			map.put(item_facturacompleto.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(item_facturacompleto.formato_producto_id_formato_producto)));
			map.put(item_facturacompleto.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(item_facturacompleto.familia_necesidad_id_familia_necesidad)));
			map.put(item_facturacompleto.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(item_facturacompleto.familia_producto_id_familia_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahMapa(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(mapa.id, c.getString(c.getColumnIndex(mapa.id)));
			map.put(mapa.name, c.getString(c.getColumnIndex(mapa.name)));
			map.put(mapa.direccion, c.getString(c.getColumnIndex(mapa.direccion)));
			map.put(mapa.lat, c.getString(c.getColumnIndex(mapa.lat)));
			map.put(mapa.lng, c.getString(c.getColumnIndex(mapa.lng)));
			map.put(mapa.tipo, c.getString(c.getColumnIndex(mapa.tipo)));
			map.put(mapa.imagen, c.getString(c.getColumnIndex(mapa.imagen)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahPais(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(pais.id_pais, c.getString(c.getColumnIndex(pais.id_pais)));
			map.put(pais.nombre_pais, c.getString(c.getColumnIndex(pais.nombre_pais)));
			map.put(pais.iso_code_2_pais, c.getString(c.getColumnIndex(pais.iso_code_2_pais)));
			map.put(pais.iso_code_3_pais, c.getString(c.getColumnIndex(pais.iso_code_3_pais)));
			map.put(pais.address_format, c.getString(c.getColumnIndex(pais.address_format)));
			map.put(pais.iso_code_number, c.getString(c.getColumnIndex(pais.iso_code_number)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahPersona(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(persona.id_persona, c.getString(c.getColumnIndex(persona.id_persona)));
			map.put(persona.rut_persona, c.getString(c.getColumnIndex(persona.rut_persona)));
			map.put(persona.digito_verificador, c.getString(c.getColumnIndex(persona.digito_verificador)));
			map.put(persona.nombre_persona, c.getString(c.getColumnIndex(persona.nombre_persona)));
			map.put(persona.segundo_nombre_persona, c.getString(c.getColumnIndex(persona.segundo_nombre_persona)));
			map.put(persona.apellido_persona, c.getString(c.getColumnIndex(persona.apellido_persona)));
			map.put(persona.segundo_apellido_persona, c.getString(c.getColumnIndex(persona.segundo_apellido_persona)));
			map.put(persona.actividad, c.getString(c.getColumnIndex(persona.actividad)));
			map.put(persona.area_actividad, c.getString(c.getColumnIndex(persona.area_actividad)));
			map.put(persona.dia_fecha_nacimiento, c.getString(c.getColumnIndex(persona.dia_fecha_nacimiento)));
			map.put(persona.mes_fecha_nacimiento, c.getString(c.getColumnIndex(persona.mes_fecha_nacimiento)));
			map.put(persona.ano_fecha_nacimiento, c.getString(c.getColumnIndex(persona.ano_fecha_nacimiento)));
			map.put(persona.edad, c.getString(c.getColumnIndex(persona.edad)));
			map.put(persona.email, c.getString(c.getColumnIndex(persona.email)));
			map.put(persona.celular, c.getString(c.getColumnIndex(persona.celular)));
			map.put(persona.telefono, c.getString(c.getColumnIndex(persona.telefono)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahPrecio(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(precio.id_precio, c.getString(c.getColumnIndex(precio.id_precio)));
			map.put(precio.precio_CLP, c.getString(c.getColumnIndex(precio.precio_CLP)));
			map.put(precio.precio_us, c.getString(c.getColumnIndex(precio.precio_us)));
			map.put(precio.precio_mayor_CLP, c.getString(c.getColumnIndex(precio.precio_mayor_CLP)));
			map.put(precio.precio_mayor_us, c.getString(c.getColumnIndex(precio.precio_mayor_us)));
			map.put(precio.precio_actual, c.getString(c.getColumnIndex(precio.precio_actual)));
			map.put(precio.descuento_promocion, c.getString(c.getColumnIndex(precio.descuento_promocion)));
			map.put(precio.cantidad_mayor, c.getString(c.getColumnIndex(precio.cantidad_mayor)));
			map.put(precio.empresa_id_empresa, c.getString(c.getColumnIndex(precio.empresa_id_empresa)));
			map.put(precio.producto_id_producto, c.getString(c.getColumnIndex(precio.producto_id_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahProducto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(producto.id_producto, c.getString(c.getColumnIndex(producto.id_producto)));
			map.put(producto.codigo_producto, c.getString(c.getColumnIndex(producto.codigo_producto)));
			map.put(producto.numero_serie, c.getString(c.getColumnIndex(producto.numero_serie)));
			map.put(producto.descripcion_producto, c.getString(c.getColumnIndex(producto.descripcion_producto)));
			map.put(producto.nombre_producto, c.getString(c.getColumnIndex(producto.nombre_producto)));
			map.put(producto.marca_producto, c.getString(c.getColumnIndex(producto.marca_producto)));
			map.put(producto.modelo_producto, c.getString(c.getColumnIndex(producto.modelo_producto)));
			map.put(producto.contenido_unidad, c.getString(c.getColumnIndex(producto.contenido_unidad)));
			map.put(producto.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(producto.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(producto.unidad_minima, c.getString(c.getColumnIndex(producto.unidad_minima)));
			map.put(producto.contenido, c.getString(c.getColumnIndex(producto.contenido)));
			map.put(producto.peso_neto, c.getString(c.getColumnIndex(producto.peso_neto)));
			map.put(producto.alto_cm, c.getString(c.getColumnIndex(producto.alto_cm)));
			map.put(producto.ancho_cm, c.getString(c.getColumnIndex(producto.ancho_cm)));
			map.put(producto.fondo_cm, c.getString(c.getColumnIndex(producto.fondo_cm)));
			map.put(producto.fabricante, c.getString(c.getColumnIndex(producto.fabricante)));
			map.put(producto.clase_producto, c.getString(c.getColumnIndex(producto.clase_producto)));
			map.put(producto.linea_producto, c.getString(c.getColumnIndex(producto.linea_producto)));
			map.put(producto.hot, c.getString(c.getColumnIndex(producto.hot)));
			map.put(producto.SKU, c.getString(c.getColumnIndex(producto.SKU)));
			map.put(producto.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(producto.subcategoria_id_subcategoria)));
			map.put(producto.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(producto.tipo_producto_id_tipo_producto)));
			map.put(producto.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(producto.formato_producto_id_formato_producto)));
			map.put(producto.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(producto.familia_necesidad_id_familia_necesidad)));
			map.put(producto.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(producto.familia_producto_id_familia_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahProductocompleto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(productocompleto.id_producto, c.getString(c.getColumnIndex(productocompleto.id_producto)));
			map.put(productocompleto.codigo_producto, c.getString(c.getColumnIndex(productocompleto.codigo_producto)));
			map.put(productocompleto.numero_serie, c.getString(c.getColumnIndex(productocompleto.numero_serie)));
			map.put(productocompleto.descripcion_producto, c.getString(c.getColumnIndex(productocompleto.descripcion_producto)));
			map.put(productocompleto.nombre_producto, c.getString(c.getColumnIndex(productocompleto.nombre_producto)));
			map.put(productocompleto.marca_producto, c.getString(c.getColumnIndex(productocompleto.marca_producto)));
			map.put(productocompleto.modelo_producto, c.getString(c.getColumnIndex(productocompleto.modelo_producto)));
			map.put(productocompleto.contenido_unidad, c.getString(c.getColumnIndex(productocompleto.contenido_unidad)));
			map.put(productocompleto.unidad_minima, c.getString(c.getColumnIndex(productocompleto.unidad_minima)));
			map.put(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(productocompleto.contenido, c.getString(c.getColumnIndex(productocompleto.contenido)));
			map.put(productocompleto.peso_neto, c.getString(c.getColumnIndex(productocompleto.peso_neto)));
			map.put(productocompleto.alto_cm, c.getString(c.getColumnIndex(productocompleto.alto_cm)));
			map.put(productocompleto.ancho_cm, c.getString(c.getColumnIndex(productocompleto.ancho_cm)));
			map.put(productocompleto.fondo_cm, c.getString(c.getColumnIndex(productocompleto.fondo_cm)));
			map.put(productocompleto.fabricante, c.getString(c.getColumnIndex(productocompleto.fabricante)));
			map.put(productocompleto.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(productocompleto.familia_necesidad_id_familia_necesidad)));
			map.put(productocompleto.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(productocompleto.familia_producto_id_familia_producto)));
			map.put(productocompleto.clase_producto, c.getString(c.getColumnIndex(productocompleto.clase_producto)));
			map.put(productocompleto.linea_producto, c.getString(c.getColumnIndex(productocompleto.linea_producto)));
			map.put(productocompleto.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(productocompleto.tipo_producto_id_tipo_producto)));
			map.put(productocompleto.hot, c.getString(c.getColumnIndex(productocompleto.hot)));
			map.put(productocompleto.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(productocompleto.subcategoria_id_subcategoria)));
			map.put(productocompleto.SKU, c.getString(c.getColumnIndex(productocompleto.SKU)));
			map.put(productocompleto.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(productocompleto.formato_producto_id_formato_producto)));
			map.put(productocompleto.id_caracteristica, c.getString(c.getColumnIndex(productocompleto.id_caracteristica)));
			map.put(productocompleto.numero_caracteristica, c.getString(c.getColumnIndex(productocompleto.numero_caracteristica)));
			map.put(productocompleto.caracteristica, c.getString(c.getColumnIndex(productocompleto.caracteristica)));
			map.put(productocompleto.valor_caracteristica, c.getString(c.getColumnIndex(productocompleto.valor_caracteristica)));
			map.put(productocompleto.id_categoria, c.getString(c.getColumnIndex(productocompleto.id_categoria)));
			map.put(productocompleto.nombre_categoria, c.getString(c.getColumnIndex(productocompleto.nombre_categoria)));
			map.put(productocompleto.id_empresa, c.getString(c.getColumnIndex(productocompleto.id_empresa)));
			map.put(productocompleto.rut_empresa, c.getString(c.getColumnIndex(productocompleto.rut_empresa)));
			map.put(productocompleto.digito_verificador_empresa, c.getString(c.getColumnIndex(productocompleto.digito_verificador_empresa)));
			map.put(productocompleto.nombre_empresa, c.getString(c.getColumnIndex(productocompleto.nombre_empresa)));
			map.put(productocompleto.nombre_contacto_empresa, c.getString(c.getColumnIndex(productocompleto.nombre_contacto_empresa)));
			map.put(productocompleto.cargo_contacto_empresa, c.getString(c.getColumnIndex(productocompleto.cargo_contacto_empresa)));
			map.put(productocompleto.email_empresa, c.getString(c.getColumnIndex(productocompleto.email_empresa)));
			map.put(productocompleto.alcance_empresa, c.getString(c.getColumnIndex(productocompleto.alcance_empresa)));
			map.put(productocompleto.telefono_empresa, c.getString(c.getColumnIndex(productocompleto.telefono_empresa)));
			map.put(productocompleto.actividad_id_actividad, c.getString(c.getColumnIndex(productocompleto.actividad_id_actividad)));
			map.put(productocompleto.id_imagenprod, c.getString(c.getColumnIndex(productocompleto.id_imagenprod)));
			map.put(productocompleto.urlimagenprod, c.getString(c.getColumnIndex(productocompleto.urlimagenprod)));
			map.put(productocompleto.id_precio, c.getString(c.getColumnIndex(productocompleto.id_precio)));
			map.put(productocompleto.precio_CLP, c.getString(c.getColumnIndex(productocompleto.precio_CLP)));
			map.put(productocompleto.precio_us, c.getString(c.getColumnIndex(productocompleto.precio_us)));
			map.put(productocompleto.precio_mayor_CLP, c.getString(c.getColumnIndex(productocompleto.precio_mayor_CLP)));
			map.put(productocompleto.precio_mayor_us, c.getString(c.getColumnIndex(productocompleto.precio_mayor_us)));
			map.put(productocompleto.precio_actual, c.getString(c.getColumnIndex(productocompleto.precio_actual)));
			map.put(productocompleto.descuento_promocion, c.getString(c.getColumnIndex(productocompleto.descuento_promocion)));
			map.put(productocompleto.cantidad_mayor, c.getString(c.getColumnIndex(productocompleto.cantidad_mayor)));
			map.put(productocompleto.id_reciclado, c.getString(c.getColumnIndex(productocompleto.id_reciclado)));
			map.put(productocompleto.reciclable, c.getString(c.getColumnIndex(productocompleto.reciclable)));
			map.put(productocompleto.reciclado, c.getString(c.getColumnIndex(productocompleto.reciclado)));
			map.put(productocompleto.valor_reciclaje, c.getString(c.getColumnIndex(productocompleto.valor_reciclaje)));
			map.put(productocompleto.empresa_id_empresa, c.getString(c.getColumnIndex(productocompleto.empresa_id_empresa)));
			map.put(productocompleto.id_stock, c.getString(c.getColumnIndex(productocompleto.id_stock)));
			map.put(productocompleto.stock_real, c.getString(c.getColumnIndex(productocompleto.stock_real)));
			map.put(productocompleto.stock_minimo, c.getString(c.getColumnIndex(productocompleto.stock_minimo)));
			map.put(productocompleto.stock_ideal, c.getString(c.getColumnIndex(productocompleto.stock_ideal)));
			map.put(productocompleto.stock_tienda, c.getString(c.getColumnIndex(productocompleto.stock_tienda)));
			map.put(productocompleto.stock_virtual, c.getString(c.getColumnIndex(productocompleto.stock_virtual)));
			map.put(productocompleto.stock_vendido, c.getString(c.getColumnIndex(productocompleto.stock_vendido)));
			map.put(productocompleto.last_update, c.getString(c.getColumnIndex(productocompleto.last_update)));
			map.put(productocompleto.id_subcategoria, c.getString(c.getColumnIndex(productocompleto.id_subcategoria)));
			map.put(productocompleto.nombre_subcategoria, c.getString(c.getColumnIndex(productocompleto.nombre_subcategoria)));
			map.put(productocompleto.descripcion_subcategoria, c.getString(c.getColumnIndex(productocompleto.descripcion_subcategoria)));
			map.put(productocompleto.categoria_id_categoria, c.getString(c.getColumnIndex(productocompleto.categoria_id_categoria)));
			map.put(productocompleto.id_talla, c.getString(c.getColumnIndex(productocompleto.id_talla)));
			map.put(productocompleto.am_largo, c.getString(c.getColumnIndex(productocompleto.am_largo)));
			map.put(productocompleto.am_ancho, c.getString(c.getColumnIndex(productocompleto.am_ancho)));
			map.put(productocompleto.am_fondo, c.getString(c.getColumnIndex(productocompleto.am_fondo)));
			map.put(productocompleto.eu_largo, c.getString(c.getColumnIndex(productocompleto.eu_largo)));
			map.put(productocompleto.eu_ancho, c.getString(c.getColumnIndex(productocompleto.eu_ancho)));
			map.put(productocompleto.eu_fondo, c.getString(c.getColumnIndex(productocompleto.eu_fondo)));
			map.put(productocompleto.num_largo, c.getString(c.getColumnIndex(productocompleto.num_largo)));
			map.put(productocompleto.num_ancho, c.getString(c.getColumnIndex(productocompleto.num_ancho)));
			map.put(productocompleto.num_fondo, c.getString(c.getColumnIndex(productocompleto.num_fondo)));
			map.put(productocompleto.id_valor_nutricional, c.getString(c.getColumnIndex(productocompleto.id_valor_nutricional)));
			map.put(productocompleto.nombre_valor, c.getString(c.getColumnIndex(productocompleto.nombre_valor)));
			map.put(productocompleto.cantidad, c.getString(c.getColumnIndex(productocompleto.cantidad)));
			map.put(productocompleto.valor_diario_total, c.getString(c.getColumnIndex(productocompleto.valor_diario_total)));
			map.put(productocompleto.porcentaje_requerimientos, c.getString(c.getColumnIndex(productocompleto.porcentaje_requerimientos)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahProductocompra(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(productocompra.id_producto, c.getString(c.getColumnIndex(productocompra.id_producto)));
			map.put(productocompra.codigo_producto, c.getString(c.getColumnIndex(productocompra.codigo_producto)));
			map.put(productocompra.numero_serie, c.getString(c.getColumnIndex(productocompra.numero_serie)));
			map.put(productocompra.descripcion_producto, c.getString(c.getColumnIndex(productocompra.descripcion_producto)));
			map.put(productocompra.nombre_producto, c.getString(c.getColumnIndex(productocompra.nombre_producto)));
			map.put(productocompra.marca_producto, c.getString(c.getColumnIndex(productocompra.marca_producto)));
			map.put(productocompra.modelo_producto, c.getString(c.getColumnIndex(productocompra.modelo_producto)));
			map.put(productocompra.contenido_unidad, c.getString(c.getColumnIndex(productocompra.contenido_unidad)));
			map.put(productocompra.unidad_minima, c.getString(c.getColumnIndex(productocompra.unidad_minima)));
			map.put(productocompra.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(productocompra.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(productocompra.contenido, c.getString(c.getColumnIndex(productocompra.contenido)));
			map.put(productocompra.peso_neto, c.getString(c.getColumnIndex(productocompra.peso_neto)));
			map.put(productocompra.alto_cm, c.getString(c.getColumnIndex(productocompra.alto_cm)));
			map.put(productocompra.ancho_cm, c.getString(c.getColumnIndex(productocompra.ancho_cm)));
			map.put(productocompra.fondo_cm, c.getString(c.getColumnIndex(productocompra.fondo_cm)));
			map.put(productocompra.fabricante, c.getString(c.getColumnIndex(productocompra.fabricante)));
			map.put(productocompra.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(productocompra.familia_necesidad_id_familia_necesidad)));
			map.put(productocompra.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(productocompra.familia_producto_id_familia_producto)));
			map.put(productocompra.clase_producto, c.getString(c.getColumnIndex(productocompra.clase_producto)));
			map.put(productocompra.linea_producto, c.getString(c.getColumnIndex(productocompra.linea_producto)));
			map.put(productocompra.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(productocompra.tipo_producto_id_tipo_producto)));
			map.put(productocompra.hot, c.getString(c.getColumnIndex(productocompra.hot)));
			map.put(productocompra.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(productocompra.subcategoria_id_subcategoria)));
			map.put(productocompra.SKU, c.getString(c.getColumnIndex(productocompra.SKU)));
			map.put(productocompra.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(productocompra.formato_producto_id_formato_producto)));
			map.put(productocompra.id_caracteristica, c.getString(c.getColumnIndex(productocompra.id_caracteristica)));
			map.put(productocompra.numero_caracteristica, c.getString(c.getColumnIndex(productocompra.numero_caracteristica)));
			map.put(productocompra.caracteristica, c.getString(c.getColumnIndex(productocompra.caracteristica)));
			map.put(productocompra.valor_caracteristica, c.getString(c.getColumnIndex(productocompra.valor_caracteristica)));
			map.put(productocompra.id_categoria, c.getString(c.getColumnIndex(productocompra.id_categoria)));
			map.put(productocompra.nombre_categoria, c.getString(c.getColumnIndex(productocompra.nombre_categoria)));
			map.put(productocompra.id_reciclado, c.getString(c.getColumnIndex(productocompra.id_reciclado)));
			map.put(productocompra.reciclable, c.getString(c.getColumnIndex(productocompra.reciclable)));
			map.put(productocompra.reciclado, c.getString(c.getColumnIndex(productocompra.reciclado)));
			map.put(productocompra.valor_reciclaje, c.getString(c.getColumnIndex(productocompra.valor_reciclaje)));
			map.put(productocompra.empresa_id_empresa, c.getString(c.getColumnIndex(productocompra.empresa_id_empresa)));
			map.put(productocompra.id_stock, c.getString(c.getColumnIndex(productocompra.id_stock)));
			map.put(productocompra.stock_real, c.getString(c.getColumnIndex(productocompra.stock_real)));
			map.put(productocompra.stock_minimo, c.getString(c.getColumnIndex(productocompra.stock_minimo)));
			map.put(productocompra.stock_ideal, c.getString(c.getColumnIndex(productocompra.stock_ideal)));
			map.put(productocompra.stock_tienda, c.getString(c.getColumnIndex(productocompra.stock_tienda)));
			map.put(productocompra.stock_virtual, c.getString(c.getColumnIndex(productocompra.stock_virtual)));
			map.put(productocompra.stock_vendido, c.getString(c.getColumnIndex(productocompra.stock_vendido)));
			map.put(productocompra.last_update, c.getString(c.getColumnIndex(productocompra.last_update)));
			map.put(productocompra.id_subcategoria, c.getString(c.getColumnIndex(productocompra.id_subcategoria)));
			map.put(productocompra.nombre_subcategoria, c.getString(c.getColumnIndex(productocompra.nombre_subcategoria)));
			map.put(productocompra.descripcion_subcategoria, c.getString(c.getColumnIndex(productocompra.descripcion_subcategoria)));
			map.put(productocompra.categoria_id_categoria, c.getString(c.getColumnIndex(productocompra.categoria_id_categoria)));
			map.put(productocompra.id_talla, c.getString(c.getColumnIndex(productocompra.id_talla)));
			map.put(productocompra.am_largo, c.getString(c.getColumnIndex(productocompra.am_largo)));
			map.put(productocompra.am_ancho, c.getString(c.getColumnIndex(productocompra.am_ancho)));
			map.put(productocompra.am_fondo, c.getString(c.getColumnIndex(productocompra.am_fondo)));
			map.put(productocompra.eu_largo, c.getString(c.getColumnIndex(productocompra.eu_largo)));
			map.put(productocompra.eu_ancho, c.getString(c.getColumnIndex(productocompra.eu_ancho)));
			map.put(productocompra.eu_fondo, c.getString(c.getColumnIndex(productocompra.eu_fondo)));
			map.put(productocompra.num_largo, c.getString(c.getColumnIndex(productocompra.num_largo)));
			map.put(productocompra.num_ancho, c.getString(c.getColumnIndex(productocompra.num_ancho)));
			map.put(productocompra.num_fondo, c.getString(c.getColumnIndex(productocompra.num_fondo)));
			map.put(productocompra.id_valor_nutricional, c.getString(c.getColumnIndex(productocompra.id_valor_nutricional)));
			map.put(productocompra.nombre_valor, c.getString(c.getColumnIndex(productocompra.nombre_valor)));
			map.put(productocompra.cantidad, c.getString(c.getColumnIndex(productocompra.cantidad)));
			map.put(productocompra.valor_diario_total, c.getString(c.getColumnIndex(productocompra.valor_diario_total)));
			map.put(productocompra.porcentaje_requerimientos, c.getString(c.getColumnIndex(productocompra.porcentaje_requerimientos)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahProductoprecio(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(productoprecio.id_producto, c.getString(c.getColumnIndex(productoprecio.id_producto)));
			map.put(productoprecio.codigo_producto, c.getString(c.getColumnIndex(productoprecio.codigo_producto)));
			map.put(productoprecio.numero_serie, c.getString(c.getColumnIndex(productoprecio.numero_serie)));
			map.put(productoprecio.descripcion_producto, c.getString(c.getColumnIndex(productoprecio.descripcion_producto)));
			map.put(productoprecio.nombre_producto, c.getString(c.getColumnIndex(productoprecio.nombre_producto)));
			map.put(productoprecio.marca_producto, c.getString(c.getColumnIndex(productoprecio.marca_producto)));
			map.put(productoprecio.modelo_producto, c.getString(c.getColumnIndex(productoprecio.modelo_producto)));
			map.put(productoprecio.contenido_unidad, c.getString(c.getColumnIndex(productoprecio.contenido_unidad)));
			map.put(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(productoprecio.unidad_minima, c.getString(c.getColumnIndex(productoprecio.unidad_minima)));
			map.put(productoprecio.contenido, c.getString(c.getColumnIndex(productoprecio.contenido)));
			map.put(productoprecio.peso_neto, c.getString(c.getColumnIndex(productoprecio.peso_neto)));
			map.put(productoprecio.alto_cm, c.getString(c.getColumnIndex(productoprecio.alto_cm)));
			map.put(productoprecio.ancho_cm, c.getString(c.getColumnIndex(productoprecio.ancho_cm)));
			map.put(productoprecio.fondo_cm, c.getString(c.getColumnIndex(productoprecio.fondo_cm)));
			map.put(productoprecio.fabricante, c.getString(c.getColumnIndex(productoprecio.fabricante)));
			map.put(productoprecio.clase_producto, c.getString(c.getColumnIndex(productoprecio.clase_producto)));
			map.put(productoprecio.linea_producto, c.getString(c.getColumnIndex(productoprecio.linea_producto)));
			map.put(productoprecio.hot, c.getString(c.getColumnIndex(productoprecio.hot)));
			map.put(productoprecio.SKU, c.getString(c.getColumnIndex(productoprecio.SKU)));
			map.put(productoprecio.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(productoprecio.subcategoria_id_subcategoria)));
			map.put(productoprecio.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(productoprecio.tipo_producto_id_tipo_producto)));
			map.put(productoprecio.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(productoprecio.formato_producto_id_formato_producto)));
			map.put(productoprecio.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(productoprecio.familia_necesidad_id_familia_necesidad)));
			map.put(productoprecio.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(productoprecio.familia_producto_id_familia_producto)));
			map.put(productoprecio.id_precio, c.getString(c.getColumnIndex(productoprecio.id_precio)));
			map.put(productoprecio.precio_CLP, c.getString(c.getColumnIndex(productoprecio.precio_CLP)));
			map.put(productoprecio.precio_us, c.getString(c.getColumnIndex(productoprecio.precio_us)));
			map.put(productoprecio.precio_mayor_CLP, c.getString(c.getColumnIndex(productoprecio.precio_mayor_CLP)));
			map.put(productoprecio.precio_mayor_us, c.getString(c.getColumnIndex(productoprecio.precio_mayor_us)));
			map.put(productoprecio.precio_actual, c.getString(c.getColumnIndex(productoprecio.precio_actual)));
			map.put(productoprecio.descuento_promocion, c.getString(c.getColumnIndex(productoprecio.descuento_promocion)));
			map.put(productoprecio.cantidad_mayor, c.getString(c.getColumnIndex(productoprecio.cantidad_mayor)));
			map.put(productoprecio.id_stock, c.getString(c.getColumnIndex(productoprecio.id_stock)));
			map.put(productoprecio.stock_real, c.getString(c.getColumnIndex(productoprecio.stock_real)));
			map.put(productoprecio.stock_minimo, c.getString(c.getColumnIndex(productoprecio.stock_minimo)));
			map.put(productoprecio.stock_ideal, c.getString(c.getColumnIndex(productoprecio.stock_ideal)));
			map.put(productoprecio.stock_tienda, c.getString(c.getColumnIndex(productoprecio.stock_tienda)));
			map.put(productoprecio.stock_virtual, c.getString(c.getColumnIndex(productoprecio.stock_virtual)));
			map.put(productoprecio.stock_vendido, c.getString(c.getColumnIndex(productoprecio.stock_vendido)));
			map.put(productoprecio.last_update, c.getString(c.getColumnIndex(productoprecio.last_update)));
			map.put(productoprecio.empresa_id_empresa, c.getString(c.getColumnIndex(productoprecio.empresa_id_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahProvincia(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(provincia.id_provincia, c.getString(c.getColumnIndex(provincia.id_provincia)));
			map.put(provincia.nombre_provincia, c.getString(c.getColumnIndex(provincia.nombre_provincia)));
			map.put(provincia.codigo_provincia, c.getString(c.getColumnIndex(provincia.codigo_provincia)));
			map.put(provincia.region_id_region, c.getString(c.getColumnIndex(provincia.region_id_region)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahReciclado(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(reciclado.id_reciclado, c.getString(c.getColumnIndex(reciclado.id_reciclado)));
			map.put(reciclado.reciclable, c.getString(c.getColumnIndex(reciclado.reciclable)));
			map.put(reciclado.reciclado, c.getString(c.getColumnIndex(reciclado.reciclado)));
			map.put(reciclado.valor_reciclaje, c.getString(c.getColumnIndex(reciclado.valor_reciclaje)));
			map.put(reciclado.empresa_id_empresa, c.getString(c.getColumnIndex(reciclado.empresa_id_empresa)));
			map.put(reciclado.producto_id_producto, c.getString(c.getColumnIndex(reciclado.producto_id_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahRegion(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(region.id_region, c.getString(c.getColumnIndex(region.id_region)));
			map.put(region.nombre_region, c.getString(c.getColumnIndex(region.nombre_region)));
			map.put(region.codigo_region, c.getString(c.getColumnIndex(region.codigo_region)));
			map.put(region.pais_id_pais, c.getString(c.getColumnIndex(region.pais_id_pais)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahRubro(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(rubro.id_rubro, c.getString(c.getColumnIndex(rubro.id_rubro)));
			map.put(rubro.nombre_rubro, c.getString(c.getColumnIndex(rubro.nombre_rubro)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahSincrodate(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(sincrodate.id_sincrodate, c.getString(c.getColumnIndex(sincrodate.id_sincrodate)));
			map.put(sincrodate.date, c.getString(c.getColumnIndex(sincrodate.date)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahStock(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(stock.id_stock, c.getString(c.getColumnIndex(stock.id_stock)));
			map.put(stock.stock_real, c.getString(c.getColumnIndex(stock.stock_real)));
			map.put(stock.stock_minimo, c.getString(c.getColumnIndex(stock.stock_minimo)));
			map.put(stock.stock_ideal, c.getString(c.getColumnIndex(stock.stock_ideal)));
			map.put(stock.stock_tienda, c.getString(c.getColumnIndex(stock.stock_tienda)));
			map.put(stock.stock_virtual, c.getString(c.getColumnIndex(stock.stock_virtual)));
			map.put(stock.stock_vendido, c.getString(c.getColumnIndex(stock.stock_vendido)));
			map.put(stock.last_update, c.getString(c.getColumnIndex(stock.last_update)));
			map.put(stock.producto_id_producto, c.getString(c.getColumnIndex(stock.producto_id_producto)));
			map.put(stock.empresa_id_empresa, c.getString(c.getColumnIndex(stock.empresa_id_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahStockcompleto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(stockcompleto.id_producto, c.getString(c.getColumnIndex(stockcompleto.id_producto)));
			map.put(stockcompleto.codigo_producto, c.getString(c.getColumnIndex(stockcompleto.codigo_producto)));
			map.put(stockcompleto.numero_serie, c.getString(c.getColumnIndex(stockcompleto.numero_serie)));
			map.put(stockcompleto.descripcion_producto, c.getString(c.getColumnIndex(stockcompleto.descripcion_producto)));
			map.put(stockcompleto.nombre_producto, c.getString(c.getColumnIndex(stockcompleto.nombre_producto)));
			map.put(stockcompleto.marca_producto, c.getString(c.getColumnIndex(stockcompleto.marca_producto)));
			map.put(stockcompleto.modelo_producto, c.getString(c.getColumnIndex(stockcompleto.modelo_producto)));
			map.put(stockcompleto.contenido_unidad, c.getString(c.getColumnIndex(stockcompleto.contenido_unidad)));
			map.put(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida, c.getString(c.getColumnIndex(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida)));
			map.put(stockcompleto.unidad_minima, c.getString(c.getColumnIndex(stockcompleto.unidad_minima)));
			map.put(stockcompleto.contenido, c.getString(c.getColumnIndex(stockcompleto.contenido)));
			map.put(stockcompleto.peso_neto, c.getString(c.getColumnIndex(stockcompleto.peso_neto)));
			map.put(stockcompleto.alto_cm, c.getString(c.getColumnIndex(stockcompleto.alto_cm)));
			map.put(stockcompleto.ancho_cm, c.getString(c.getColumnIndex(stockcompleto.ancho_cm)));
			map.put(stockcompleto.fondo_cm, c.getString(c.getColumnIndex(stockcompleto.fondo_cm)));
			map.put(stockcompleto.fabricante, c.getString(c.getColumnIndex(stockcompleto.fabricante)));
			map.put(stockcompleto.clase_producto, c.getString(c.getColumnIndex(stockcompleto.clase_producto)));
			map.put(stockcompleto.linea_producto, c.getString(c.getColumnIndex(stockcompleto.linea_producto)));
			map.put(stockcompleto.hot, c.getString(c.getColumnIndex(stockcompleto.hot)));
			map.put(stockcompleto.SKU, c.getString(c.getColumnIndex(stockcompleto.SKU)));
			map.put(stockcompleto.subcategoria_id_subcategoria, c.getString(c.getColumnIndex(stockcompleto.subcategoria_id_subcategoria)));
			map.put(stockcompleto.tipo_producto_id_tipo_producto, c.getString(c.getColumnIndex(stockcompleto.tipo_producto_id_tipo_producto)));
			map.put(stockcompleto.formato_producto_id_formato_producto, c.getString(c.getColumnIndex(stockcompleto.formato_producto_id_formato_producto)));
			map.put(stockcompleto.familia_necesidad_id_familia_necesidad, c.getString(c.getColumnIndex(stockcompleto.familia_necesidad_id_familia_necesidad)));
			map.put(stockcompleto.familia_producto_id_familia_producto, c.getString(c.getColumnIndex(stockcompleto.familia_producto_id_familia_producto)));
			map.put(stockcompleto.id_stock, c.getString(c.getColumnIndex(stockcompleto.id_stock)));
			map.put(stockcompleto.stock_real, c.getString(c.getColumnIndex(stockcompleto.stock_real)));
			map.put(stockcompleto.stock_minimo, c.getString(c.getColumnIndex(stockcompleto.stock_minimo)));
			map.put(stockcompleto.stock_ideal, c.getString(c.getColumnIndex(stockcompleto.stock_ideal)));
			map.put(stockcompleto.stock_tienda, c.getString(c.getColumnIndex(stockcompleto.stock_tienda)));
			map.put(stockcompleto.stock_virtual, c.getString(c.getColumnIndex(stockcompleto.stock_virtual)));
			map.put(stockcompleto.stock_vendido, c.getString(c.getColumnIndex(stockcompleto.stock_vendido)));
			map.put(stockcompleto.last_update, c.getString(c.getColumnIndex(stockcompleto.last_update)));
			map.put(stockcompleto.producto_id_producto, c.getString(c.getColumnIndex(stockcompleto.producto_id_producto)));
			map.put(stockcompleto.empresa_id_empresa, c.getString(c.getColumnIndex(stockcompleto.empresa_id_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahSubcategoria(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(subcategoria.id_subcategoria, c.getString(c.getColumnIndex(subcategoria.id_subcategoria)));
			map.put(subcategoria.nombre_subcategoria, c.getString(c.getColumnIndex(subcategoria.nombre_subcategoria)));
			map.put(subcategoria.descripcion_subcategoria, c.getString(c.getColumnIndex(subcategoria.descripcion_subcategoria)));
			map.put(subcategoria.categoria_id_categoria, c.getString(c.getColumnIndex(subcategoria.categoria_id_categoria)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahSubrubro(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(subrubro.id_subrubro, c.getString(c.getColumnIndex(subrubro.id_subrubro)));
			map.put(subrubro.nombre_subrubro, c.getString(c.getColumnIndex(subrubro.nombre_subrubro)));
			map.put(subrubro.rubro_id_rubro, c.getString(c.getColumnIndex(subrubro.rubro_id_rubro)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahTalla(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(talla.id_talla, c.getString(c.getColumnIndex(talla.id_talla)));
			map.put(talla.am_largo, c.getString(c.getColumnIndex(talla.am_largo)));
			map.put(talla.am_ancho, c.getString(c.getColumnIndex(talla.am_ancho)));
			map.put(talla.am_fondo, c.getString(c.getColumnIndex(talla.am_fondo)));
			map.put(talla.eu_largo, c.getString(c.getColumnIndex(talla.eu_largo)));
			map.put(talla.eu_ancho, c.getString(c.getColumnIndex(talla.eu_ancho)));
			map.put(talla.eu_fondo, c.getString(c.getColumnIndex(talla.eu_fondo)));
			map.put(talla.num_largo, c.getString(c.getColumnIndex(talla.num_largo)));
			map.put(talla.num_ancho, c.getString(c.getColumnIndex(talla.num_ancho)));
			map.put(talla.num_fondo, c.getString(c.getColumnIndex(talla.num_fondo)));
			map.put(talla.producto_id_producto, c.getString(c.getColumnIndex(talla.producto_id_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahTipo_documento(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(tipo_documento.id_tipo_documento, c.getString(c.getColumnIndex(tipo_documento.id_tipo_documento)));
			map.put(tipo_documento.nombre_tipo_documento, c.getString(c.getColumnIndex(tipo_documento.nombre_tipo_documento)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahTipo_empresa(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(tipo_empresa.id_tipo_empresa, c.getString(c.getColumnIndex(tipo_empresa.id_tipo_empresa)));
			map.put(tipo_empresa.nombre_tipo_empresa, c.getString(c.getColumnIndex(tipo_empresa.nombre_tipo_empresa)));
			map.put(tipo_empresa.categoria_empresa_id_categoria_empresa, c.getString(c.getColumnIndex(tipo_empresa.categoria_empresa_id_categoria_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahTipo_pago(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(tipo_pago.id_tipo_pago, c.getString(c.getColumnIndex(tipo_pago.id_tipo_pago)));
			map.put(tipo_pago.nombre_tipo_pago, c.getString(c.getColumnIndex(tipo_pago.nombre_tipo_pago)));
			map.put(tipo_pago.comision_tipo_pago, c.getString(c.getColumnIndex(tipo_pago.comision_tipo_pago)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahTipo_producto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(tipo_producto.id_tipo_producto, c.getString(c.getColumnIndex(tipo_producto.id_tipo_producto)));
			map.put(tipo_producto.nombre_tipo_producto, c.getString(c.getColumnIndex(tipo_producto.nombre_tipo_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahTipo_usuario(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(tipo_usuario.id_tipo_usuario, c.getString(c.getColumnIndex(tipo_usuario.id_tipo_usuario)));
			map.put(tipo_usuario.nombre_tipo_usuario, c.getString(c.getColumnIndex(tipo_usuario.nombre_tipo_usuario)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahUbicacion(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(ubicacion.id_ubicacion, c.getString(c.getColumnIndex(ubicacion.id_ubicacion)));
			map.put(ubicacion.numero_ubicacion, c.getString(c.getColumnIndex(ubicacion.numero_ubicacion)));
			map.put(ubicacion.numero_interior, c.getString(c.getColumnIndex(ubicacion.numero_interior)));
			map.put(ubicacion.telefono_ubicacion, c.getString(c.getColumnIndex(ubicacion.telefono_ubicacion)));
			map.put(ubicacion.default_ubicacion, c.getString(c.getColumnIndex(ubicacion.default_ubicacion)));
			map.put(ubicacion.calle_id_calle, c.getString(c.getColumnIndex(ubicacion.calle_id_calle)));
			map.put(ubicacion.empresa_id_empresa, c.getString(c.getColumnIndex(ubicacion.empresa_id_empresa)));
			map.put(ubicacion.usuario_id_usuario, c.getString(c.getColumnIndex(ubicacion.usuario_id_usuario)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahUsuario(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(usuario.id_usuario, c.getString(c.getColumnIndex(usuario.id_usuario)));
			map.put(usuario.tipo_usuario, c.getString(c.getColumnIndex(usuario.tipo_usuario)));
			map.put(usuario.nombre_usuario, c.getString(c.getColumnIndex(usuario.nombre_usuario)));
			map.put(usuario.clave, c.getString(c.getColumnIndex(usuario.clave)));
			map.put(usuario.cliente_id_cliente, c.getString(c.getColumnIndex(usuario.cliente_id_cliente)));
			map.put(usuario.cliente_empresa_id_cliente_empresa, c.getString(c.getColumnIndex(usuario.cliente_empresa_id_cliente_empresa)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahUsuariocompleto(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(usuariocompleto.id_persona, c.getString(c.getColumnIndex(usuariocompleto.id_persona)));
			map.put(usuariocompleto.rut_persona, c.getString(c.getColumnIndex(usuariocompleto.rut_persona)));
			map.put(usuariocompleto.digito_verificador, c.getString(c.getColumnIndex(usuariocompleto.digito_verificador)));
			map.put(usuariocompleto.nombre_persona, c.getString(c.getColumnIndex(usuariocompleto.nombre_persona)));
			map.put(usuariocompleto.segundo_nombre_persona, c.getString(c.getColumnIndex(usuariocompleto.segundo_nombre_persona)));
			map.put(usuariocompleto.apellido_persona, c.getString(c.getColumnIndex(usuariocompleto.apellido_persona)));
			map.put(usuariocompleto.segundo_apellido_persona, c.getString(c.getColumnIndex(usuariocompleto.segundo_apellido_persona)));
			map.put(usuariocompleto.actividad, c.getString(c.getColumnIndex(usuariocompleto.actividad)));
			map.put(usuariocompleto.area_actividad, c.getString(c.getColumnIndex(usuariocompleto.area_actividad)));
			map.put(usuariocompleto.dia_fecha_nacimiento, c.getString(c.getColumnIndex(usuariocompleto.dia_fecha_nacimiento)));
			map.put(usuariocompleto.mes_fecha_nacimiento, c.getString(c.getColumnIndex(usuariocompleto.mes_fecha_nacimiento)));
			map.put(usuariocompleto.ano_fecha_nacimiento, c.getString(c.getColumnIndex(usuariocompleto.ano_fecha_nacimiento)));
			map.put(usuariocompleto.edad, c.getString(c.getColumnIndex(usuariocompleto.edad)));
			map.put(usuariocompleto.email, c.getString(c.getColumnIndex(usuariocompleto.email)));
			map.put(usuariocompleto.celular, c.getString(c.getColumnIndex(usuariocompleto.celular)));
			map.put(usuariocompleto.telefono, c.getString(c.getColumnIndex(usuariocompleto.telefono)));
			map.put(usuariocompleto.id_carne_empresa, c.getString(c.getColumnIndex(usuariocompleto.id_carne_empresa)));
			map.put(usuariocompleto.nombre_usuario, c.getString(c.getColumnIndex(usuariocompleto.nombre_usuario)));
			map.put(usuariocompleto.clave_usuario, c.getString(c.getColumnIndex(usuariocompleto.clave_usuario)));
			map.put(usuariocompleto.empresa_id_empresa, c.getString(c.getColumnIndex(usuariocompleto.empresa_id_empresa)));
			map.put(usuariocompleto.persona_id_persona, c.getString(c.getColumnIndex(usuariocompleto.persona_id_persona)));
			map.put(usuariocompleto.tipo_usuario_id_tipo_usuario, c.getString(c.getColumnIndex(usuariocompleto.tipo_usuario_id_tipo_usuario)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahValor_nutricional(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(valor_nutricional.id_valor_nutricional, c.getString(c.getColumnIndex(valor_nutricional.id_valor_nutricional)));
			map.put(valor_nutricional.nombre_valor, c.getString(c.getColumnIndex(valor_nutricional.nombre_valor)));
			map.put(valor_nutricional.cantidad, c.getString(c.getColumnIndex(valor_nutricional.cantidad)));
			map.put(valor_nutricional.valor_diario_total, c.getString(c.getColumnIndex(valor_nutricional.valor_diario_total)));
			map.put(valor_nutricional.porcentaje_requerimientos, c.getString(c.getColumnIndex(valor_nutricional.porcentaje_requerimientos)));
			map.put(valor_nutricional.producto_id_producto, c.getString(c.getColumnIndex(valor_nutricional.producto_id_producto)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahVenta(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(venta.id_venta, c.getString(c.getColumnIndex(venta.id_venta)));
			map.put(venta.numero_articulos, c.getString(c.getColumnIndex(venta.numero_articulos)));
			map.put(venta.total, c.getString(c.getColumnIndex(venta.total)));
			map.put(venta.dia_fecha_venta, c.getString(c.getColumnIndex(venta.dia_fecha_venta)));
			map.put(venta.mes_fecha_venta, c.getString(c.getColumnIndex(venta.mes_fecha_venta)));
			map.put(venta.anno_fecha_venta, c.getString(c.getColumnIndex(venta.anno_fecha_venta)));
			map.put(venta.hora_fecha_venta, c.getString(c.getColumnIndex(venta.hora_fecha_venta)));
			map.put(venta.usuario_id_usuario, c.getString(c.getColumnIndex(venta.usuario_id_usuario)));
			map.put(venta.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(venta.carne_empresa_id_carne_empresa)));
			map.put(venta.tipo_pago_id_tipo_pago, c.getString(c.getColumnIndex(venta.tipo_pago_id_tipo_pago)));
			map.put(venta.tipo_documento_id_tipo_documento, c.getString(c.getColumnIndex(venta.tipo_documento_id_tipo_documento)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}
	public ArrayList<HashMap<String, String>> ahVentacompleta(Cursor c){
		c.moveToFirst();
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
		while(!c.isAfterLast()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(ventacompleta.id_venta, c.getString(c.getColumnIndex(ventacompleta.id_venta)));
			map.put(ventacompleta.numero_articulos, c.getString(c.getColumnIndex(ventacompleta.numero_articulos)));
			map.put(ventacompleta.total, c.getString(c.getColumnIndex(ventacompleta.total)));
			map.put(ventacompleta.dia_fecha_venta, c.getString(c.getColumnIndex(ventacompleta.dia_fecha_venta)));
			map.put(ventacompleta.mes_fecha_venta, c.getString(c.getColumnIndex(ventacompleta.mes_fecha_venta)));
			map.put(ventacompleta.anno_fecha_venta, c.getString(c.getColumnIndex(ventacompleta.anno_fecha_venta)));
			map.put(ventacompleta.hora_fecha_venta, c.getString(c.getColumnIndex(ventacompleta.hora_fecha_venta)));
			map.put(ventacompleta.usuario_id_usuario, c.getString(c.getColumnIndex(ventacompleta.usuario_id_usuario)));
			map.put(ventacompleta.carne_empresa_id_carne_empresa, c.getString(c.getColumnIndex(ventacompleta.carne_empresa_id_carne_empresa)));
			map.put(ventacompleta.tipo_pago_id_tipo_pago, c.getString(c.getColumnIndex(ventacompleta.tipo_pago_id_tipo_pago)));
			map.put(ventacompleta.tipo_documento_id_tipo_documento, c.getString(c.getColumnIndex(ventacompleta.tipo_documento_id_tipo_documento)));
			map.put(ventacompleta.id_tipo_pago, c.getString(c.getColumnIndex(ventacompleta.id_tipo_pago)));
			map.put(ventacompleta.nombre_tipo_pago, c.getString(c.getColumnIndex(ventacompleta.nombre_tipo_pago)));
			map.put(ventacompleta.comision_tipo_pago, c.getString(c.getColumnIndex(ventacompleta.comision_tipo_pago)));
			map.put(ventacompleta.id_tipo_documento, c.getString(c.getColumnIndex(ventacompleta.id_tipo_documento)));
			map.put(ventacompleta.nombre_tipo_documento, c.getString(c.getColumnIndex(ventacompleta.nombre_tipo_documento)));
			ar.add(map);
			c.moveToNext();
		}
		c.close();
		return ar;
	}

		
}
