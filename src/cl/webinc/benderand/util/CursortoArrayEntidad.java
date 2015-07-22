package cl.webinc.benderand.util;

import java.util.ArrayList;

import android.database.Cursor;
import cl.webinc.benderand.entidad.*;
import cl.webinc.benderand.provider.Base.*;

public class CursortoArrayEntidad {
	private static CursortoArrayEntidad cta;
	private CursortoArrayEntidad() {
		super();
	}
	public static CursortoArrayEntidad getinstance() 
	{
		if(cta == null)
		{
			cta = new CursortoArrayEntidad();
		}
		return cta;       	
	}
	public ArrayList<Actividad> aeActividad(Cursor c){
		c.moveToFirst();
		ArrayList<Actividad> arraylist = new ArrayList<Actividad>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Actividad(
							c.getString(c.getColumnIndex(actividad.id_actividad)),
							c.getString(c.getColumnIndex(actividad.nombre_actividad)),
							c.getString(c.getColumnIndex(actividad.codigo_actividad)),
							c.getString(c.getColumnIndex(actividad.categoria_actividad)),
							c.getString(c.getColumnIndex(actividad.afectoiva_actividad)),
							c.getString(c.getColumnIndex(actividad.disponible_internet_actividad)),
							c.getString(c.getColumnIndex(actividad.subrubro_id_subrubro))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Calle> aeCalle(Cursor c){
		c.moveToFirst();
		ArrayList<Calle> arraylist = new ArrayList<Calle>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Calle(
							c.getString(c.getColumnIndex(calle.id_calle)),
							c.getString(c.getColumnIndex(calle.nombre_calle)),
							c.getString(c.getColumnIndex(calle.comuna_id_comuna))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Caracteristica> aeCaracteristica(Cursor c){
		c.moveToFirst();
		ArrayList<Caracteristica> arraylist = new ArrayList<Caracteristica>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Caracteristica(
							c.getString(c.getColumnIndex(caracteristica.id_caracteristica)),
							c.getString(c.getColumnIndex(caracteristica.numero_caracteristica)),
							c.getString(c.getColumnIndex(caracteristica.caracteristica)),
							c.getString(c.getColumnIndex(caracteristica.valor_caracteristica)),
							c.getString(c.getColumnIndex(caracteristica.producto_id_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carne_empresa> aeCarne_empresa(Cursor c){
		c.moveToFirst();
		ArrayList<Carne_empresa> arraylist = new ArrayList<Carne_empresa>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carne_empresa(
							c.getString(c.getColumnIndex(carne_empresa.id_carne_empresa)),
							c.getString(c.getColumnIndex(carne_empresa.nombre_usuario)),
							c.getString(c.getColumnIndex(carne_empresa.clave_usuario)),
							c.getString(c.getColumnIndex(carne_empresa.empresa_id_empresa)),
							c.getString(c.getColumnIndex(carne_empresa.persona_id_persona)),
							c.getString(c.getColumnIndex(carne_empresa.tipo_usuario_id_tipo_usuario))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carne_empresacompleto> aeCarne_empresacompleto(Cursor c){
		c.moveToFirst();
		ArrayList<Carne_empresacompleto> arraylist = new ArrayList<Carne_empresacompleto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carne_empresacompleto(
							c.getString(c.getColumnIndex(carne_empresacompleto.id_carne_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.nombre_usuario)),
							c.getString(c.getColumnIndex(carne_empresacompleto.clave_usuario)),
							c.getString(c.getColumnIndex(carne_empresacompleto.tipo_usuario_id_tipo_usuario)),
							c.getString(c.getColumnIndex(carne_empresacompleto.id_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.rut_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.digito_verificador_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.nombre_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.nombre_contacto_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.cargo_contacto_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.email_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.alcance_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.telefono_empresa)),
							c.getString(c.getColumnIndex(carne_empresacompleto.actividad_id_actividad)),
							c.getString(c.getColumnIndex(carne_empresacompleto.id_persona)),
							c.getString(c.getColumnIndex(carne_empresacompleto.rut_persona)),
							c.getString(c.getColumnIndex(carne_empresacompleto.digito_verificador)),
							c.getString(c.getColumnIndex(carne_empresacompleto.nombre_persona)),
							c.getString(c.getColumnIndex(carne_empresacompleto.segundo_nombre_persona)),
							c.getString(c.getColumnIndex(carne_empresacompleto.apellido_persona)),
							c.getString(c.getColumnIndex(carne_empresacompleto.segundo_apellido_persona)),
							c.getString(c.getColumnIndex(carne_empresacompleto.actividad)),
							c.getString(c.getColumnIndex(carne_empresacompleto.area_actividad)),
							c.getString(c.getColumnIndex(carne_empresacompleto.dia_fecha_nacimiento)),
							c.getString(c.getColumnIndex(carne_empresacompleto.mes_fecha_nacimiento)),
							c.getString(c.getColumnIndex(carne_empresacompleto.ano_fecha_nacimiento)),
							c.getString(c.getColumnIndex(carne_empresacompleto.edad)),
							c.getString(c.getColumnIndex(carne_empresacompleto.email)),
							c.getString(c.getColumnIndex(carne_empresacompleto.celular)),
							c.getString(c.getColumnIndex(carne_empresacompleto.telefono))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carro_compras> aeCarro_compras(Cursor c){
		c.moveToFirst();
		ArrayList<Carro_compras> arraylist = new ArrayList<Carro_compras>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carro_compras(
							c.getString(c.getColumnIndex(carro_compras.id_carro_compras)),
							c.getString(c.getColumnIndex(carro_compras.cantidad_carro)),
							c.getString(c.getColumnIndex(carro_compras.precio_carro)),
							c.getString(c.getColumnIndex(carro_compras.mayor)),
							c.getString(c.getColumnIndex(carro_compras.tienda)),
							c.getString(c.getColumnIndex(carro_compras.usuario_id_usuario)),
							c.getString(c.getColumnIndex(carro_compras.producto_id_producto)),
							c.getString(c.getColumnIndex(carro_compras.empresa_id_empresa)),
							c.getString(c.getColumnIndex(carro_compras.usado)),
							c.getString(c.getColumnIndex(carro_compras.carne_empresa_id_carne_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carro_comprascompleto> aeCarro_comprascompleto(Cursor c){
		c.moveToFirst();
		ArrayList<Carro_comprascompleto> arraylist = new ArrayList<Carro_comprascompleto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carro_comprascompleto(
							c.getString(c.getColumnIndex(carro_comprascompleto.id_carro_compras)),
							c.getString(c.getColumnIndex(carro_comprascompleto.cantidad_carro)),
							c.getString(c.getColumnIndex(carro_comprascompleto.precio_carro)),
							c.getString(c.getColumnIndex(carro_comprascompleto.mayor)),
							c.getString(c.getColumnIndex(carro_comprascompleto.tienda)),
							c.getString(c.getColumnIndex(carro_comprascompleto.usuario_id_usuario)),
							c.getString(c.getColumnIndex(carro_comprascompleto.usado)),
							c.getString(c.getColumnIndex(carro_comprascompleto.carne_empresa_id_carne_empresa)),
							c.getString(c.getColumnIndex(carro_comprascompleto.id_precio)),
							c.getString(c.getColumnIndex(carro_comprascompleto.precio_CLP)),
							c.getString(c.getColumnIndex(carro_comprascompleto.precio_us)),
							c.getString(c.getColumnIndex(carro_comprascompleto.precio_mayor_CLP)),
							c.getString(c.getColumnIndex(carro_comprascompleto.precio_mayor_us)),
							c.getString(c.getColumnIndex(carro_comprascompleto.precio_actual)),
							c.getString(c.getColumnIndex(carro_comprascompleto.descuento_promocion)),
							c.getString(c.getColumnIndex(carro_comprascompleto.cantidad_mayor)),
							c.getString(c.getColumnIndex(carro_comprascompleto.id_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.codigo_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.numero_serie)),
							c.getString(c.getColumnIndex(carro_comprascompleto.descripcion_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.nombre_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.marca_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.modelo_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.contenido_unidad)),
							c.getString(c.getColumnIndex(carro_comprascompleto.unidad_minima)),
							c.getString(c.getColumnIndex(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(carro_comprascompleto.contenido)),
							c.getString(c.getColumnIndex(carro_comprascompleto.peso_neto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.alto_cm)),
							c.getString(c.getColumnIndex(carro_comprascompleto.ancho_cm)),
							c.getString(c.getColumnIndex(carro_comprascompleto.fondo_cm)),
							c.getString(c.getColumnIndex(carro_comprascompleto.fabricante)),
							c.getString(c.getColumnIndex(carro_comprascompleto.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(carro_comprascompleto.familia_producto_id_familia_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.clase_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.linea_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.hot)),
							c.getString(c.getColumnIndex(carro_comprascompleto.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(carro_comprascompleto.SKU)),
							c.getString(c.getColumnIndex(carro_comprascompleto.formato_producto_id_formato_producto)),
							c.getString(c.getColumnIndex(carro_comprascompleto.stock_tienda))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carro_egresos> aeCarro_egresos(Cursor c){
		c.moveToFirst();
		ArrayList<Carro_egresos> arraylist = new ArrayList<Carro_egresos>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carro_egresos(
							c.getString(c.getColumnIndex(carro_egresos.id_carro_egresos)),
							c.getString(c.getColumnIndex(carro_egresos.cantidad_carro)),
							c.getString(c.getColumnIndex(carro_egresos.precio_carro)),
							c.getString(c.getColumnIndex(carro_egresos.mayor)),
							c.getString(c.getColumnIndex(carro_egresos.tienda)),
							c.getString(c.getColumnIndex(carro_egresos.usado)),
							c.getString(c.getColumnIndex(carro_egresos.producto_id_producto)),
							c.getString(c.getColumnIndex(carro_egresos.usuario_id_usuario)),
							c.getString(c.getColumnIndex(carro_egresos.empresa_id_empresa)),
							c.getString(c.getColumnIndex(carro_egresos.carne_empresa_id_carne_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carro_egresoscompleto> aeCarro_egresoscompleto(Cursor c){
		c.moveToFirst();
		ArrayList<Carro_egresoscompleto> arraylist = new ArrayList<Carro_egresoscompleto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carro_egresoscompleto(
							c.getString(c.getColumnIndex(carro_egresoscompleto.id_carro_egresos)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.cantidad_carro)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.precio_carro)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.mayor)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.tienda)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.usuario_id_usuario)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.usado)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.carne_empresa_id_carne_empresa)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.id_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.codigo_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.numero_serie)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.descripcion_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.nombre_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.marca_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.modelo_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.contenido_unidad)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.unidad_minima)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.contenido)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.peso_neto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.alto_cm)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.ancho_cm)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.fondo_cm)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.fabricante)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.familia_producto_id_familia_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.clase_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.linea_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.hot)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.SKU)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.formato_producto_id_formato_producto)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.stock_tienda)),
							c.getString(c.getColumnIndex(carro_egresoscompleto.precio_CLP))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carro_egresosproducto> aeCarro_egresosproducto(Cursor c){
		c.moveToFirst();
		ArrayList<Carro_egresosproducto> arraylist = new ArrayList<Carro_egresosproducto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carro_egresosproducto(
							c.getString(c.getColumnIndex(carro_egresosproducto.id_carro_egresos)),
							c.getString(c.getColumnIndex(carro_egresosproducto.cantidad_carro)),
							c.getString(c.getColumnIndex(carro_egresosproducto.precio_carro)),
							c.getString(c.getColumnIndex(carro_egresosproducto.mayor)),
							c.getString(c.getColumnIndex(carro_egresosproducto.tienda)),
							c.getString(c.getColumnIndex(carro_egresosproducto.usuario_id_usuario)),
							c.getString(c.getColumnIndex(carro_egresosproducto.usado)),
							c.getString(c.getColumnIndex(carro_egresosproducto.carne_empresa_id_carne_empresa)),
							c.getString(c.getColumnIndex(carro_egresosproducto.id_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.codigo_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.numero_serie)),
							c.getString(c.getColumnIndex(carro_egresosproducto.descripcion_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.nombre_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.marca_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.modelo_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.contenido_unidad)),
							c.getString(c.getColumnIndex(carro_egresosproducto.unidad_minima)),
							c.getString(c.getColumnIndex(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(carro_egresosproducto.contenido)),
							c.getString(c.getColumnIndex(carro_egresosproducto.peso_neto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.alto_cm)),
							c.getString(c.getColumnIndex(carro_egresosproducto.ancho_cm)),
							c.getString(c.getColumnIndex(carro_egresosproducto.fondo_cm)),
							c.getString(c.getColumnIndex(carro_egresosproducto.fabricante)),
							c.getString(c.getColumnIndex(carro_egresosproducto.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(carro_egresosproducto.familia_producto_id_familia_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.clase_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.linea_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(carro_egresosproducto.hot)),
							c.getString(c.getColumnIndex(carro_egresosproducto.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(carro_egresosproducto.SKU)),
							c.getString(c.getColumnIndex(carro_egresosproducto.formato_producto_id_formato_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carro_venta> aeCarro_venta(Cursor c){
		c.moveToFirst();
		ArrayList<Carro_venta> arraylist = new ArrayList<Carro_venta>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carro_venta(
							c.getString(c.getColumnIndex(carro_venta.id_carro_venta)),
							c.getString(c.getColumnIndex(carro_venta.cantidad)),
							c.getString(c.getColumnIndex(carro_venta.precio)),
							c.getString(c.getColumnIndex(carro_venta.carro_compras_id_carro_compras)),
							c.getString(c.getColumnIndex(carro_venta.venta_id_venta))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Carro_ventacompleto> aeCarro_ventacompleto(Cursor c){
		c.moveToFirst();
		ArrayList<Carro_ventacompleto> arraylist = new ArrayList<Carro_ventacompleto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Carro_ventacompleto(
							c.getString(c.getColumnIndex(carro_ventacompleto.id_carro_venta)),
							c.getString(c.getColumnIndex(carro_ventacompleto.cantidad)),
							c.getString(c.getColumnIndex(carro_ventacompleto.precio)),
							c.getString(c.getColumnIndex(carro_ventacompleto.venta_id_venta)),
							c.getString(c.getColumnIndex(carro_ventacompleto.id_carro_compras)),
							c.getString(c.getColumnIndex(carro_ventacompleto.cantidad_carro)),
							c.getString(c.getColumnIndex(carro_ventacompleto.precio_carro)),
							c.getString(c.getColumnIndex(carro_ventacompleto.mayor)),
							c.getString(c.getColumnIndex(carro_ventacompleto.tienda)),
							c.getString(c.getColumnIndex(carro_ventacompleto.usuario_id_usuario)),
							c.getString(c.getColumnIndex(carro_ventacompleto.usado)),
							c.getString(c.getColumnIndex(carro_ventacompleto.carne_empresa_id_carne_empresa)),
							c.getString(c.getColumnIndex(carro_ventacompleto.id_precio)),
							c.getString(c.getColumnIndex(carro_ventacompleto.precio_CLP)),
							c.getString(c.getColumnIndex(carro_ventacompleto.precio_us)),
							c.getString(c.getColumnIndex(carro_ventacompleto.precio_mayor_CLP)),
							c.getString(c.getColumnIndex(carro_ventacompleto.precio_mayor_us)),
							c.getString(c.getColumnIndex(carro_ventacompleto.precio_actual)),
							c.getString(c.getColumnIndex(carro_ventacompleto.descuento_promocion)),
							c.getString(c.getColumnIndex(carro_ventacompleto.cantidad_mayor)),
							c.getString(c.getColumnIndex(carro_ventacompleto.id_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.codigo_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.numero_serie)),
							c.getString(c.getColumnIndex(carro_ventacompleto.descripcion_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.nombre_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.marca_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.modelo_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.contenido_unidad)),
							c.getString(c.getColumnIndex(carro_ventacompleto.unidad_minima)),
							c.getString(c.getColumnIndex(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(carro_ventacompleto.contenido)),
							c.getString(c.getColumnIndex(carro_ventacompleto.peso_neto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.alto_cm)),
							c.getString(c.getColumnIndex(carro_ventacompleto.ancho_cm)),
							c.getString(c.getColumnIndex(carro_ventacompleto.fondo_cm)),
							c.getString(c.getColumnIndex(carro_ventacompleto.fabricante)),
							c.getString(c.getColumnIndex(carro_ventacompleto.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(carro_ventacompleto.familia_producto_id_familia_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.clase_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.linea_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(carro_ventacompleto.hot)),
							c.getString(c.getColumnIndex(carro_ventacompleto.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(carro_ventacompleto.SKU)),
							c.getString(c.getColumnIndex(carro_ventacompleto.formato_producto_id_formato_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Categoria> aeCategoria(Cursor c){
		c.moveToFirst();
		ArrayList<Categoria> arraylist = new ArrayList<Categoria>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Categoria(
							c.getString(c.getColumnIndex(categoria.id_categoria)),
							c.getString(c.getColumnIndex(categoria.nombre_categoria))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Categoria_empresa> aeCategoria_empresa(Cursor c){
		c.moveToFirst();
		ArrayList<Categoria_empresa> arraylist = new ArrayList<Categoria_empresa>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Categoria_empresa(
							c.getString(c.getColumnIndex(categoria_empresa.id_categoria_empresa)),
							c.getString(c.getColumnIndex(categoria_empresa.nombre_categoria_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Ci_sessions> aeCi_sessions(Cursor c){
		c.moveToFirst();
		ArrayList<Ci_sessions> arraylist = new ArrayList<Ci_sessions>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Ci_sessions(
							c.getString(c.getColumnIndex(ci_sessions.session_id)),
							c.getString(c.getColumnIndex(ci_sessions.ip_address)),
							c.getString(c.getColumnIndex(ci_sessions.user_agent)),
							c.getString(c.getColumnIndex(ci_sessions.id_user)),
							c.getString(c.getColumnIndex(ci_sessions.nombre_apellido)),
							c.getString(c.getColumnIndex(ci_sessions.email_user)),
							c.getString(c.getColumnIndex(ci_sessions.last_activity)),
							c.getString(c.getColumnIndex(ci_sessions.user_data))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Cliente> aeCliente(Cursor c){
		c.moveToFirst();
		ArrayList<Cliente> arraylist = new ArrayList<Cliente>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Cliente(
							c.getString(c.getColumnIndex(cliente.id_cliente)),
							c.getString(c.getColumnIndex(cliente.rut_cliente)),
							c.getString(c.getColumnIndex(cliente.digito_verificador)),
							c.getString(c.getColumnIndex(cliente.nombre_cliente)),
							c.getString(c.getColumnIndex(cliente.segundo_nombre_cliente)),
							c.getString(c.getColumnIndex(cliente.apellido_cliente)),
							c.getString(c.getColumnIndex(cliente.segundo_apellido_cliente)),
							c.getString(c.getColumnIndex(cliente.actividad)),
							c.getString(c.getColumnIndex(cliente.area_actividad)),
							c.getString(c.getColumnIndex(cliente.dia_fecha_nacimiento)),
							c.getString(c.getColumnIndex(cliente.mes_fecha_nacimiento)),
							c.getString(c.getColumnIndex(cliente.ano_fecha_nacimiento)),
							c.getString(c.getColumnIndex(cliente.edad)),
							c.getString(c.getColumnIndex(cliente.email)),
							c.getString(c.getColumnIndex(cliente.celular)),
							c.getString(c.getColumnIndex(cliente.telefono))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Cliente_empresa> aeCliente_empresa(Cursor c){
		c.moveToFirst();
		ArrayList<Cliente_empresa> arraylist = new ArrayList<Cliente_empresa>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Cliente_empresa(
							c.getString(c.getColumnIndex(cliente_empresa.id_cliente_empresa)),
							c.getString(c.getColumnIndex(cliente_empresa.rut_cliente_empresa)),
							c.getString(c.getColumnIndex(cliente_empresa.digito_verificador)),
							c.getString(c.getColumnIndex(cliente_empresa.nombre)),
							c.getString(c.getColumnIndex(cliente_empresa.email_cliente_empresa)),
							c.getString(c.getColumnIndex(cliente_empresa.actividad_id_actividad)),
							c.getString(c.getColumnIndex(cliente_empresa.empresa_id_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Compracompleta> aeCompracompleta(Cursor c){
		c.moveToFirst();
		ArrayList<Compracompleta> arraylist = new ArrayList<Compracompleta>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Compracompleta(
							c.getString(c.getColumnIndex(compracompleta.id_factura)),
							c.getString(c.getColumnIndex(compracompleta.rol_factura)),
							c.getString(c.getColumnIndex(compracompleta.dia_factura)),
							c.getString(c.getColumnIndex(compracompleta.mes_factura)),
							c.getString(c.getColumnIndex(compracompleta.ano_factura)),
							c.getString(c.getColumnIndex(compracompleta.fecha_factura)),
							c.getString(c.getColumnIndex(compracompleta.empresa_id_empresa)),
							c.getString(c.getColumnIndex(compracompleta.carne_empresa_id_carne_empresa)),
							c.getString(c.getColumnIndex(compracompleta.rut_proveedor)),
							c.getString(c.getColumnIndex(compracompleta.nombre_proveedor)),
							c.getString(c.getColumnIndex(compracompleta.telefono_proveedor)),
							c.getString(c.getColumnIndex(compracompleta.tipo_documento_id_tipo_documento)),
							c.getString(c.getColumnIndex(compracompleta.tipo_pago_id_tipo_pago)),
							c.getString(c.getColumnIndex(compracompleta.total_factura)),
							c.getString(c.getColumnIndex(compracompleta.id_tipo_pago)),
							c.getString(c.getColumnIndex(compracompleta.nombre_tipo_pago)),
							c.getString(c.getColumnIndex(compracompleta.comision_tipo_pago)),
							c.getString(c.getColumnIndex(compracompleta.id_tipo_documento)),
							c.getString(c.getColumnIndex(compracompleta.nombre_tipo_documento))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Comuna> aeComuna(Cursor c){
		c.moveToFirst();
		ArrayList<Comuna> arraylist = new ArrayList<Comuna>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Comuna(
							c.getString(c.getColumnIndex(comuna.id_comuna)),
							c.getString(c.getColumnIndex(comuna.codigo_comuna)),
							c.getString(c.getColumnIndex(comuna.nombre_comuna)),
							c.getString(c.getColumnIndex(comuna.provincia_id_provincia))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Contenido_unidad_medida> aeContenido_unidad_medida(Cursor c){
		c.moveToFirst();
		ArrayList<Contenido_unidad_medida> arraylist = new ArrayList<Contenido_unidad_medida>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Contenido_unidad_medida(
							c.getString(c.getColumnIndex(contenido_unidad_medida.id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(contenido_unidad_medida.nombre_contenido_unidad_medida))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Dia> aeDia(Cursor c){
		c.moveToFirst();
		ArrayList<Dia> arraylist = new ArrayList<Dia>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Dia(
							c.getString(c.getColumnIndex(dia.iddia)),
							c.getString(c.getColumnIndex(dia.dia)),
							c.getString(c.getColumnIndex(dia.mes)),
							c.getString(c.getColumnIndex(dia.anno)),
							c.getString(c.getColumnIndex(dia.fecha)),
							c.getString(c.getColumnIndex(dia.egreso)),
							c.getString(c.getColumnIndex(dia.ingreso)),
							c.getString(c.getColumnIndex(dia.impuesto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Empresa> aeEmpresa(Cursor c){
		c.moveToFirst();
		ArrayList<Empresa> arraylist = new ArrayList<Empresa>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Empresa(
							c.getString(c.getColumnIndex(empresa.id_empresa)),
							c.getString(c.getColumnIndex(empresa.rut_empresa)),
							c.getString(c.getColumnIndex(empresa.digito_verificador_empresa)),
							c.getString(c.getColumnIndex(empresa.nombre_empresa)),
							c.getString(c.getColumnIndex(empresa.nombre_contacto_empresa)),
							c.getString(c.getColumnIndex(empresa.cargo_contacto_empresa)),
							c.getString(c.getColumnIndex(empresa.email_empresa)),
							c.getString(c.getColumnIndex(empresa.alcance_empresa)),
							c.getString(c.getColumnIndex(empresa.telefono_empresa)),
							c.getString(c.getColumnIndex(empresa.actividad_id_actividad)),
							c.getString(c.getColumnIndex(empresa.tipo_empresa_id_tipo_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Envio> aeEnvio(Cursor c){
		c.moveToFirst();
		ArrayList<Envio> arraylist = new ArrayList<Envio>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Envio(
							c.getString(c.getColumnIndex(envio.id_envio)),
							c.getString(c.getColumnIndex(envio.direccion_alternativa)),
							c.getString(c.getColumnIndex(envio.fecha_entrega)),
							c.getString(c.getColumnIndex(envio.hora_entrega)),
							c.getString(c.getColumnIndex(envio.venta_id_venta)),
							c.getString(c.getColumnIndex(envio.enviado))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Factura> aeFactura(Cursor c){
		c.moveToFirst();
		ArrayList<Factura> arraylist = new ArrayList<Factura>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Factura(
							c.getString(c.getColumnIndex(factura.id_factura)),
							c.getString(c.getColumnIndex(factura.rol_factura)),
							c.getString(c.getColumnIndex(factura.dia_factura)),
							c.getString(c.getColumnIndex(factura.mes_factura)),
							c.getString(c.getColumnIndex(factura.ano_factura)),
							c.getString(c.getColumnIndex(factura.fecha_factura)),
							c.getString(c.getColumnIndex(factura.empresa_id_empresa)),
							c.getString(c.getColumnIndex(factura.carne_empresa_id_carne_empresa)),
							c.getString(c.getColumnIndex(factura.rut_proveedor)),
							c.getString(c.getColumnIndex(factura.nombre_proveedor)),
							c.getString(c.getColumnIndex(factura.telefono_proveedor)),
							c.getString(c.getColumnIndex(factura.tipo_documento_id_tipo_documento)),
							c.getString(c.getColumnIndex(factura.tipo_pago_id_tipo_pago)),
							c.getString(c.getColumnIndex(factura.total_factura))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Familia_necesidad> aeFamilia_necesidad(Cursor c){
		c.moveToFirst();
		ArrayList<Familia_necesidad> arraylist = new ArrayList<Familia_necesidad>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Familia_necesidad(
							c.getString(c.getColumnIndex(familia_necesidad.id_familia_necesidad)),
							c.getString(c.getColumnIndex(familia_necesidad.nombre_familia_necesidad))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Familia_producto> aeFamilia_producto(Cursor c){
		c.moveToFirst();
		ArrayList<Familia_producto> arraylist = new ArrayList<Familia_producto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Familia_producto(
							c.getString(c.getColumnIndex(familia_producto.id_familia_producto)),
							c.getString(c.getColumnIndex(familia_producto.nombre_familia_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Formato_producto> aeFormato_producto(Cursor c){
		c.moveToFirst();
		ArrayList<Formato_producto> arraylist = new ArrayList<Formato_producto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Formato_producto(
							c.getString(c.getColumnIndex(formato_producto.id_formato_producto)),
							c.getString(c.getColumnIndex(formato_producto.nombre_formato_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Gasto> aeGasto(Cursor c){
		c.moveToFirst();
		ArrayList<Gasto> arraylist = new ArrayList<Gasto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Gasto(
							c.getString(c.getColumnIndex(gasto.id_gasto)),
							c.getString(c.getColumnIndex(gasto.nombre_gasto)),
							c.getString(c.getColumnIndex(gasto.id_usuario)),
							c.getString(c.getColumnIndex(gasto.monto_gasto)),
							c.getString(c.getColumnIndex(gasto.fecha_gasto)),
							c.getString(c.getColumnIndex(gasto.empresa_id_empre))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Geocode_cache> aeGeocode_cache(Cursor c){
		c.moveToFirst();
		ArrayList<Geocode_cache> arraylist = new ArrayList<Geocode_cache>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Geocode_cache(
							c.getString(c.getColumnIndex(geocode_cache.id)),
							c.getString(c.getColumnIndex(geocode_cache.lng)),
							c.getString(c.getColumnIndex(geocode_cache.lat)),
							c.getString(c.getColumnIndex(geocode_cache.query))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Imagenprod> aeImagenprod(Cursor c){
		c.moveToFirst();
		ArrayList<Imagenprod> arraylist = new ArrayList<Imagenprod>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Imagenprod(
							c.getString(c.getColumnIndex(imagenprod.id_imagenprod)),
							c.getString(c.getColumnIndex(imagenprod.urlimagenprod)),
							c.getString(c.getColumnIndex(imagenprod.producto_id_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Impuesto> aeImpuesto(Cursor c){
		c.moveToFirst();
		ArrayList<Impuesto> arraylist = new ArrayList<Impuesto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Impuesto(
							c.getString(c.getColumnIndex(impuesto.id_impuesto)),
							c.getString(c.getColumnIndex(impuesto.nombre_impuesto)),
							c.getString(c.getColumnIndex(impuesto.valor_impuesto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Ingresosegresos> aeIngresosegresos(Cursor c){
		c.moveToFirst();
		ArrayList<Ingresosegresos> arraylist = new ArrayList<Ingresosegresos>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Ingresosegresos(
							c.getString(c.getColumnIndex(ingresosegresos.dia)),
							c.getString(c.getColumnIndex(ingresosegresos.mes)),
							c.getString(c.getColumnIndex(ingresosegresos.anno)),
							c.getString(c.getColumnIndex(ingresosegresos.fecha)),
							c.getString(c.getColumnIndex(ingresosegresos.totalingreso)),
							c.getString(c.getColumnIndex(ingresosegresos.totalgasto)),
							c.getString(c.getColumnIndex(ingresosegresos.impuestoegreso)),
							c.getString(c.getColumnIndex(ingresosegresos.impuestoingreso))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Item_factura> aeItem_factura(Cursor c){
		c.moveToFirst();
		ArrayList<Item_factura> arraylist = new ArrayList<Item_factura>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Item_factura(
							c.getString(c.getColumnIndex(item_factura.id_itemfactura)),
							c.getString(c.getColumnIndex(item_factura.cantidad)),
							c.getString(c.getColumnIndex(item_factura.precio)),
							c.getString(c.getColumnIndex(item_factura.producto_id_producto)),
							c.getString(c.getColumnIndex(item_factura.factura_id_factura)),
							c.getString(c.getColumnIndex(item_factura.carro_egresos_id_carro_egresos))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Item_facturacompleto> aeItem_facturacompleto(Cursor c){
		c.moveToFirst();
		ArrayList<Item_facturacompleto> arraylist = new ArrayList<Item_facturacompleto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Item_facturacompleto(
							c.getString(c.getColumnIndex(item_facturacompleto.id_itemfactura)),
							c.getString(c.getColumnIndex(item_facturacompleto.cantidad)),
							c.getString(c.getColumnIndex(item_facturacompleto.precio)),
							c.getString(c.getColumnIndex(item_facturacompleto.producto_id_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.factura_id_factura)),
							c.getString(c.getColumnIndex(item_facturacompleto.id_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.codigo_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.numero_serie)),
							c.getString(c.getColumnIndex(item_facturacompleto.descripcion_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.nombre_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.marca_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.modelo_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.contenido_unidad)),
							c.getString(c.getColumnIndex(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(item_facturacompleto.unidad_minima)),
							c.getString(c.getColumnIndex(item_facturacompleto.contenido)),
							c.getString(c.getColumnIndex(item_facturacompleto.peso_neto)),
							c.getString(c.getColumnIndex(item_facturacompleto.alto_cm)),
							c.getString(c.getColumnIndex(item_facturacompleto.ancho_cm)),
							c.getString(c.getColumnIndex(item_facturacompleto.fondo_cm)),
							c.getString(c.getColumnIndex(item_facturacompleto.fabricante)),
							c.getString(c.getColumnIndex(item_facturacompleto.clase_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.linea_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.hot)),
							c.getString(c.getColumnIndex(item_facturacompleto.SKU)),
							c.getString(c.getColumnIndex(item_facturacompleto.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(item_facturacompleto.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.formato_producto_id_formato_producto)),
							c.getString(c.getColumnIndex(item_facturacompleto.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(item_facturacompleto.familia_producto_id_familia_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Mapa> aeMapa(Cursor c){
		c.moveToFirst();
		ArrayList<Mapa> arraylist = new ArrayList<Mapa>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Mapa(
							c.getString(c.getColumnIndex(mapa.id)),
							c.getString(c.getColumnIndex(mapa.name)),
							c.getString(c.getColumnIndex(mapa.direccion)),
							c.getString(c.getColumnIndex(mapa.lat)),
							c.getString(c.getColumnIndex(mapa.lng)),
							c.getString(c.getColumnIndex(mapa.tipo)),
							c.getString(c.getColumnIndex(mapa.imagen))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Pais> aePais(Cursor c){
		c.moveToFirst();
		ArrayList<Pais> arraylist = new ArrayList<Pais>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Pais(
							c.getString(c.getColumnIndex(pais.id_pais)),
							c.getString(c.getColumnIndex(pais.nombre_pais)),
							c.getString(c.getColumnIndex(pais.iso_code_2_pais)),
							c.getString(c.getColumnIndex(pais.iso_code_3_pais)),
							c.getString(c.getColumnIndex(pais.address_format)),
							c.getString(c.getColumnIndex(pais.iso_code_number))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Persona> aePersona(Cursor c){
		c.moveToFirst();
		ArrayList<Persona> arraylist = new ArrayList<Persona>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Persona(
							c.getString(c.getColumnIndex(persona.id_persona)),
							c.getString(c.getColumnIndex(persona.rut_persona)),
							c.getString(c.getColumnIndex(persona.digito_verificador)),
							c.getString(c.getColumnIndex(persona.nombre_persona)),
							c.getString(c.getColumnIndex(persona.segundo_nombre_persona)),
							c.getString(c.getColumnIndex(persona.apellido_persona)),
							c.getString(c.getColumnIndex(persona.segundo_apellido_persona)),
							c.getString(c.getColumnIndex(persona.actividad)),
							c.getString(c.getColumnIndex(persona.area_actividad)),
							c.getString(c.getColumnIndex(persona.dia_fecha_nacimiento)),
							c.getString(c.getColumnIndex(persona.mes_fecha_nacimiento)),
							c.getString(c.getColumnIndex(persona.ano_fecha_nacimiento)),
							c.getString(c.getColumnIndex(persona.edad)),
							c.getString(c.getColumnIndex(persona.email)),
							c.getString(c.getColumnIndex(persona.celular)),
							c.getString(c.getColumnIndex(persona.telefono))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Precio> aePrecio(Cursor c){
		c.moveToFirst();
		ArrayList<Precio> arraylist = new ArrayList<Precio>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Precio(
							c.getString(c.getColumnIndex(precio.id_precio)),
							c.getString(c.getColumnIndex(precio.precio_CLP)),
							c.getString(c.getColumnIndex(precio.precio_us)),
							c.getString(c.getColumnIndex(precio.precio_mayor_CLP)),
							c.getString(c.getColumnIndex(precio.precio_mayor_us)),
							c.getString(c.getColumnIndex(precio.precio_actual)),
							c.getString(c.getColumnIndex(precio.descuento_promocion)),
							c.getString(c.getColumnIndex(precio.cantidad_mayor)),
							c.getString(c.getColumnIndex(precio.empresa_id_empresa)),
							c.getString(c.getColumnIndex(precio.producto_id_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Producto> aeProducto(Cursor c){
		c.moveToFirst();
		ArrayList<Producto> arraylist = new ArrayList<Producto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Producto(
							c.getString(c.getColumnIndex(producto.id_producto)),
							c.getString(c.getColumnIndex(producto.codigo_producto)),
							c.getString(c.getColumnIndex(producto.numero_serie)),
							c.getString(c.getColumnIndex(producto.descripcion_producto)),
							c.getString(c.getColumnIndex(producto.nombre_producto)),
							c.getString(c.getColumnIndex(producto.marca_producto)),
							c.getString(c.getColumnIndex(producto.modelo_producto)),
							c.getString(c.getColumnIndex(producto.contenido_unidad)),
							c.getString(c.getColumnIndex(producto.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(producto.unidad_minima)),
							c.getString(c.getColumnIndex(producto.contenido)),
							c.getString(c.getColumnIndex(producto.peso_neto)),
							c.getString(c.getColumnIndex(producto.alto_cm)),
							c.getString(c.getColumnIndex(producto.ancho_cm)),
							c.getString(c.getColumnIndex(producto.fondo_cm)),
							c.getString(c.getColumnIndex(producto.fabricante)),
							c.getString(c.getColumnIndex(producto.clase_producto)),
							c.getString(c.getColumnIndex(producto.linea_producto)),
							c.getString(c.getColumnIndex(producto.hot)),
							c.getString(c.getColumnIndex(producto.SKU)),
							c.getString(c.getColumnIndex(producto.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(producto.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(producto.formato_producto_id_formato_producto)),
							c.getString(c.getColumnIndex(producto.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(producto.familia_producto_id_familia_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Productocompleto> aeProductocompleto(Cursor c){
		c.moveToFirst();
		ArrayList<Productocompleto> arraylist = new ArrayList<Productocompleto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Productocompleto(
							c.getString(c.getColumnIndex(productocompleto.id_producto)),
							c.getString(c.getColumnIndex(productocompleto.codigo_producto)),
							c.getString(c.getColumnIndex(productocompleto.numero_serie)),
							c.getString(c.getColumnIndex(productocompleto.descripcion_producto)),
							c.getString(c.getColumnIndex(productocompleto.nombre_producto)),
							c.getString(c.getColumnIndex(productocompleto.marca_producto)),
							c.getString(c.getColumnIndex(productocompleto.modelo_producto)),
							c.getString(c.getColumnIndex(productocompleto.contenido_unidad)),
							c.getString(c.getColumnIndex(productocompleto.unidad_minima)),
							c.getString(c.getColumnIndex(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(productocompleto.contenido)),
							c.getString(c.getColumnIndex(productocompleto.peso_neto)),
							c.getString(c.getColumnIndex(productocompleto.alto_cm)),
							c.getString(c.getColumnIndex(productocompleto.ancho_cm)),
							c.getString(c.getColumnIndex(productocompleto.fondo_cm)),
							c.getString(c.getColumnIndex(productocompleto.fabricante)),
							c.getString(c.getColumnIndex(productocompleto.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(productocompleto.familia_producto_id_familia_producto)),
							c.getString(c.getColumnIndex(productocompleto.clase_producto)),
							c.getString(c.getColumnIndex(productocompleto.linea_producto)),
							c.getString(c.getColumnIndex(productocompleto.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(productocompleto.hot)),
							c.getString(c.getColumnIndex(productocompleto.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(productocompleto.SKU)),
							c.getString(c.getColumnIndex(productocompleto.formato_producto_id_formato_producto)),
							c.getString(c.getColumnIndex(productocompleto.id_caracteristica)),
							c.getString(c.getColumnIndex(productocompleto.numero_caracteristica)),
							c.getString(c.getColumnIndex(productocompleto.caracteristica)),
							c.getString(c.getColumnIndex(productocompleto.valor_caracteristica)),
							c.getString(c.getColumnIndex(productocompleto.id_categoria)),
							c.getString(c.getColumnIndex(productocompleto.nombre_categoria)),
							c.getString(c.getColumnIndex(productocompleto.id_empresa)),
							c.getString(c.getColumnIndex(productocompleto.rut_empresa)),
							c.getString(c.getColumnIndex(productocompleto.digito_verificador_empresa)),
							c.getString(c.getColumnIndex(productocompleto.nombre_empresa)),
							c.getString(c.getColumnIndex(productocompleto.nombre_contacto_empresa)),
							c.getString(c.getColumnIndex(productocompleto.cargo_contacto_empresa)),
							c.getString(c.getColumnIndex(productocompleto.email_empresa)),
							c.getString(c.getColumnIndex(productocompleto.alcance_empresa)),
							c.getString(c.getColumnIndex(productocompleto.telefono_empresa)),
							c.getString(c.getColumnIndex(productocompleto.actividad_id_actividad)),
							c.getString(c.getColumnIndex(productocompleto.id_imagenprod)),
							c.getString(c.getColumnIndex(productocompleto.urlimagenprod)),
							c.getString(c.getColumnIndex(productocompleto.id_precio)),
							c.getString(c.getColumnIndex(productocompleto.precio_CLP)),
							c.getString(c.getColumnIndex(productocompleto.precio_us)),
							c.getString(c.getColumnIndex(productocompleto.precio_mayor_CLP)),
							c.getString(c.getColumnIndex(productocompleto.precio_mayor_us)),
							c.getString(c.getColumnIndex(productocompleto.precio_actual)),
							c.getString(c.getColumnIndex(productocompleto.descuento_promocion)),
							c.getString(c.getColumnIndex(productocompleto.cantidad_mayor)),
							c.getString(c.getColumnIndex(productocompleto.id_reciclado)),
							c.getString(c.getColumnIndex(productocompleto.reciclable)),
							c.getString(c.getColumnIndex(productocompleto.reciclado)),
							c.getString(c.getColumnIndex(productocompleto.valor_reciclaje)),
							c.getString(c.getColumnIndex(productocompleto.empresa_id_empresa)),
							c.getString(c.getColumnIndex(productocompleto.id_stock)),
							c.getString(c.getColumnIndex(productocompleto.stock_real)),
							c.getString(c.getColumnIndex(productocompleto.stock_minimo)),
							c.getString(c.getColumnIndex(productocompleto.stock_ideal)),
							c.getString(c.getColumnIndex(productocompleto.stock_tienda)),
							c.getString(c.getColumnIndex(productocompleto.stock_virtual)),
							c.getString(c.getColumnIndex(productocompleto.stock_vendido)),
							c.getString(c.getColumnIndex(productocompleto.last_update)),
							c.getString(c.getColumnIndex(productocompleto.id_subcategoria)),
							c.getString(c.getColumnIndex(productocompleto.nombre_subcategoria)),
							c.getString(c.getColumnIndex(productocompleto.descripcion_subcategoria)),
							c.getString(c.getColumnIndex(productocompleto.categoria_id_categoria)),
							c.getString(c.getColumnIndex(productocompleto.id_talla)),
							c.getString(c.getColumnIndex(productocompleto.am_largo)),
							c.getString(c.getColumnIndex(productocompleto.am_ancho)),
							c.getString(c.getColumnIndex(productocompleto.am_fondo)),
							c.getString(c.getColumnIndex(productocompleto.eu_largo)),
							c.getString(c.getColumnIndex(productocompleto.eu_ancho)),
							c.getString(c.getColumnIndex(productocompleto.eu_fondo)),
							c.getString(c.getColumnIndex(productocompleto.num_largo)),
							c.getString(c.getColumnIndex(productocompleto.num_ancho)),
							c.getString(c.getColumnIndex(productocompleto.num_fondo)),
							c.getString(c.getColumnIndex(productocompleto.id_valor_nutricional)),
							c.getString(c.getColumnIndex(productocompleto.nombre_valor)),
							c.getString(c.getColumnIndex(productocompleto.cantidad)),
							c.getString(c.getColumnIndex(productocompleto.valor_diario_total)),
							c.getString(c.getColumnIndex(productocompleto.porcentaje_requerimientos))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Productocompra> aeProductocompra(Cursor c){
		c.moveToFirst();
		ArrayList<Productocompra> arraylist = new ArrayList<Productocompra>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Productocompra(
							c.getString(c.getColumnIndex(productocompra.id_producto)),
							c.getString(c.getColumnIndex(productocompra.codigo_producto)),
							c.getString(c.getColumnIndex(productocompra.numero_serie)),
							c.getString(c.getColumnIndex(productocompra.descripcion_producto)),
							c.getString(c.getColumnIndex(productocompra.nombre_producto)),
							c.getString(c.getColumnIndex(productocompra.marca_producto)),
							c.getString(c.getColumnIndex(productocompra.modelo_producto)),
							c.getString(c.getColumnIndex(productocompra.contenido_unidad)),
							c.getString(c.getColumnIndex(productocompra.unidad_minima)),
							c.getString(c.getColumnIndex(productocompra.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(productocompra.contenido)),
							c.getString(c.getColumnIndex(productocompra.peso_neto)),
							c.getString(c.getColumnIndex(productocompra.alto_cm)),
							c.getString(c.getColumnIndex(productocompra.ancho_cm)),
							c.getString(c.getColumnIndex(productocompra.fondo_cm)),
							c.getString(c.getColumnIndex(productocompra.fabricante)),
							c.getString(c.getColumnIndex(productocompra.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(productocompra.familia_producto_id_familia_producto)),
							c.getString(c.getColumnIndex(productocompra.clase_producto)),
							c.getString(c.getColumnIndex(productocompra.linea_producto)),
							c.getString(c.getColumnIndex(productocompra.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(productocompra.hot)),
							c.getString(c.getColumnIndex(productocompra.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(productocompra.SKU)),
							c.getString(c.getColumnIndex(productocompra.formato_producto_id_formato_producto)),
							c.getString(c.getColumnIndex(productocompra.id_caracteristica)),
							c.getString(c.getColumnIndex(productocompra.numero_caracteristica)),
							c.getString(c.getColumnIndex(productocompra.caracteristica)),
							c.getString(c.getColumnIndex(productocompra.valor_caracteristica)),
							c.getString(c.getColumnIndex(productocompra.id_categoria)),
							c.getString(c.getColumnIndex(productocompra.nombre_categoria)),
							c.getString(c.getColumnIndex(productocompra.id_reciclado)),
							c.getString(c.getColumnIndex(productocompra.reciclable)),
							c.getString(c.getColumnIndex(productocompra.reciclado)),
							c.getString(c.getColumnIndex(productocompra.valor_reciclaje)),
							c.getString(c.getColumnIndex(productocompra.empresa_id_empresa)),
							c.getString(c.getColumnIndex(productocompra.id_stock)),
							c.getString(c.getColumnIndex(productocompra.stock_real)),
							c.getString(c.getColumnIndex(productocompra.stock_minimo)),
							c.getString(c.getColumnIndex(productocompra.stock_ideal)),
							c.getString(c.getColumnIndex(productocompra.stock_tienda)),
							c.getString(c.getColumnIndex(productocompra.stock_virtual)),
							c.getString(c.getColumnIndex(productocompra.stock_vendido)),
							c.getString(c.getColumnIndex(productocompra.last_update)),
							c.getString(c.getColumnIndex(productocompra.id_subcategoria)),
							c.getString(c.getColumnIndex(productocompra.nombre_subcategoria)),
							c.getString(c.getColumnIndex(productocompra.descripcion_subcategoria)),
							c.getString(c.getColumnIndex(productocompra.categoria_id_categoria)),
							c.getString(c.getColumnIndex(productocompra.id_talla)),
							c.getString(c.getColumnIndex(productocompra.am_largo)),
							c.getString(c.getColumnIndex(productocompra.am_ancho)),
							c.getString(c.getColumnIndex(productocompra.am_fondo)),
							c.getString(c.getColumnIndex(productocompra.eu_largo)),
							c.getString(c.getColumnIndex(productocompra.eu_ancho)),
							c.getString(c.getColumnIndex(productocompra.eu_fondo)),
							c.getString(c.getColumnIndex(productocompra.num_largo)),
							c.getString(c.getColumnIndex(productocompra.num_ancho)),
							c.getString(c.getColumnIndex(productocompra.num_fondo)),
							c.getString(c.getColumnIndex(productocompra.id_valor_nutricional)),
							c.getString(c.getColumnIndex(productocompra.nombre_valor)),
							c.getString(c.getColumnIndex(productocompra.cantidad)),
							c.getString(c.getColumnIndex(productocompra.valor_diario_total)),
							c.getString(c.getColumnIndex(productocompra.porcentaje_requerimientos))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Productoprecio> aeProductoprecio(Cursor c){
		c.moveToFirst();
		ArrayList<Productoprecio> arraylist = new ArrayList<Productoprecio>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Productoprecio(
							c.getString(c.getColumnIndex(productoprecio.id_producto)),
							c.getString(c.getColumnIndex(productoprecio.codigo_producto)),
							c.getString(c.getColumnIndex(productoprecio.numero_serie)),
							c.getString(c.getColumnIndex(productoprecio.descripcion_producto)),
							c.getString(c.getColumnIndex(productoprecio.nombre_producto)),
							c.getString(c.getColumnIndex(productoprecio.marca_producto)),
							c.getString(c.getColumnIndex(productoprecio.modelo_producto)),
							c.getString(c.getColumnIndex(productoprecio.contenido_unidad)),
							c.getString(c.getColumnIndex(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(productoprecio.unidad_minima)),
							c.getString(c.getColumnIndex(productoprecio.contenido)),
							c.getString(c.getColumnIndex(productoprecio.peso_neto)),
							c.getString(c.getColumnIndex(productoprecio.alto_cm)),
							c.getString(c.getColumnIndex(productoprecio.ancho_cm)),
							c.getString(c.getColumnIndex(productoprecio.fondo_cm)),
							c.getString(c.getColumnIndex(productoprecio.fabricante)),
							c.getString(c.getColumnIndex(productoprecio.clase_producto)),
							c.getString(c.getColumnIndex(productoprecio.linea_producto)),
							c.getString(c.getColumnIndex(productoprecio.hot)),
							c.getString(c.getColumnIndex(productoprecio.SKU)),
							c.getString(c.getColumnIndex(productoprecio.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(productoprecio.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(productoprecio.formato_producto_id_formato_producto)),
							c.getString(c.getColumnIndex(productoprecio.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(productoprecio.familia_producto_id_familia_producto)),
							c.getString(c.getColumnIndex(productoprecio.id_precio)),
							c.getString(c.getColumnIndex(productoprecio.precio_CLP)),
							c.getString(c.getColumnIndex(productoprecio.precio_us)),
							c.getString(c.getColumnIndex(productoprecio.precio_mayor_CLP)),
							c.getString(c.getColumnIndex(productoprecio.precio_mayor_us)),
							c.getString(c.getColumnIndex(productoprecio.precio_actual)),
							c.getString(c.getColumnIndex(productoprecio.descuento_promocion)),
							c.getString(c.getColumnIndex(productoprecio.cantidad_mayor)),
							c.getString(c.getColumnIndex(productoprecio.id_stock)),
							c.getString(c.getColumnIndex(productoprecio.stock_real)),
							c.getString(c.getColumnIndex(productoprecio.stock_minimo)),
							c.getString(c.getColumnIndex(productoprecio.stock_ideal)),
							c.getString(c.getColumnIndex(productoprecio.stock_tienda)),
							c.getString(c.getColumnIndex(productoprecio.stock_virtual)),
							c.getString(c.getColumnIndex(productoprecio.stock_vendido)),
							c.getString(c.getColumnIndex(productoprecio.last_update)),
							c.getString(c.getColumnIndex(productoprecio.empresa_id_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Provincia> aeProvincia(Cursor c){
		c.moveToFirst();
		ArrayList<Provincia> arraylist = new ArrayList<Provincia>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Provincia(
							c.getString(c.getColumnIndex(provincia.id_provincia)),
							c.getString(c.getColumnIndex(provincia.nombre_provincia)),
							c.getString(c.getColumnIndex(provincia.codigo_provincia)),
							c.getString(c.getColumnIndex(provincia.region_id_region))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Reciclado> aeReciclado(Cursor c){
		c.moveToFirst();
		ArrayList<Reciclado> arraylist = new ArrayList<Reciclado>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Reciclado(
							c.getString(c.getColumnIndex(reciclado.id_reciclado)),
							c.getString(c.getColumnIndex(reciclado.reciclable)),
							c.getString(c.getColumnIndex(reciclado.reciclado)),
							c.getString(c.getColumnIndex(reciclado.valor_reciclaje)),
							c.getString(c.getColumnIndex(reciclado.empresa_id_empresa)),
							c.getString(c.getColumnIndex(reciclado.producto_id_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Region> aeRegion(Cursor c){
		c.moveToFirst();
		ArrayList<Region> arraylist = new ArrayList<Region>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Region(
							c.getString(c.getColumnIndex(region.id_region)),
							c.getString(c.getColumnIndex(region.nombre_region)),
							c.getString(c.getColumnIndex(region.codigo_region)),
							c.getString(c.getColumnIndex(region.pais_id_pais))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Rubro> aeRubro(Cursor c){
		c.moveToFirst();
		ArrayList<Rubro> arraylist = new ArrayList<Rubro>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Rubro(
							c.getString(c.getColumnIndex(rubro.id_rubro)),
							c.getString(c.getColumnIndex(rubro.nombre_rubro))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Sincrodate> aeSincrodate(Cursor c){
		c.moveToFirst();
		ArrayList<Sincrodate> arraylist = new ArrayList<Sincrodate>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Sincrodate(
							c.getString(c.getColumnIndex(sincrodate.id_sincrodate)),
							c.getString(c.getColumnIndex(sincrodate.date))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Stock> aeStock(Cursor c){
		c.moveToFirst();
		ArrayList<Stock> arraylist = new ArrayList<Stock>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Stock(
							c.getString(c.getColumnIndex(stock.id_stock)),
							c.getString(c.getColumnIndex(stock.stock_real)),
							c.getString(c.getColumnIndex(stock.stock_minimo)),
							c.getString(c.getColumnIndex(stock.stock_ideal)),
							c.getString(c.getColumnIndex(stock.stock_tienda)),
							c.getString(c.getColumnIndex(stock.stock_virtual)),
							c.getString(c.getColumnIndex(stock.stock_vendido)),
							c.getString(c.getColumnIndex(stock.last_update)),
							c.getString(c.getColumnIndex(stock.producto_id_producto)),
							c.getString(c.getColumnIndex(stock.empresa_id_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Stockcompleto> aeStockcompleto(Cursor c){
		c.moveToFirst();
		ArrayList<Stockcompleto> arraylist = new ArrayList<Stockcompleto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Stockcompleto(
							c.getString(c.getColumnIndex(stockcompleto.id_producto)),
							c.getString(c.getColumnIndex(stockcompleto.codigo_producto)),
							c.getString(c.getColumnIndex(stockcompleto.numero_serie)),
							c.getString(c.getColumnIndex(stockcompleto.descripcion_producto)),
							c.getString(c.getColumnIndex(stockcompleto.nombre_producto)),
							c.getString(c.getColumnIndex(stockcompleto.marca_producto)),
							c.getString(c.getColumnIndex(stockcompleto.modelo_producto)),
							c.getString(c.getColumnIndex(stockcompleto.contenido_unidad)),
							c.getString(c.getColumnIndex(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida)),
							c.getString(c.getColumnIndex(stockcompleto.unidad_minima)),
							c.getString(c.getColumnIndex(stockcompleto.contenido)),
							c.getString(c.getColumnIndex(stockcompleto.peso_neto)),
							c.getString(c.getColumnIndex(stockcompleto.alto_cm)),
							c.getString(c.getColumnIndex(stockcompleto.ancho_cm)),
							c.getString(c.getColumnIndex(stockcompleto.fondo_cm)),
							c.getString(c.getColumnIndex(stockcompleto.fabricante)),
							c.getString(c.getColumnIndex(stockcompleto.clase_producto)),
							c.getString(c.getColumnIndex(stockcompleto.linea_producto)),
							c.getString(c.getColumnIndex(stockcompleto.hot)),
							c.getString(c.getColumnIndex(stockcompleto.SKU)),
							c.getString(c.getColumnIndex(stockcompleto.subcategoria_id_subcategoria)),
							c.getString(c.getColumnIndex(stockcompleto.tipo_producto_id_tipo_producto)),
							c.getString(c.getColumnIndex(stockcompleto.formato_producto_id_formato_producto)),
							c.getString(c.getColumnIndex(stockcompleto.familia_necesidad_id_familia_necesidad)),
							c.getString(c.getColumnIndex(stockcompleto.familia_producto_id_familia_producto)),
							c.getString(c.getColumnIndex(stockcompleto.id_stock)),
							c.getString(c.getColumnIndex(stockcompleto.stock_real)),
							c.getString(c.getColumnIndex(stockcompleto.stock_minimo)),
							c.getString(c.getColumnIndex(stockcompleto.stock_ideal)),
							c.getString(c.getColumnIndex(stockcompleto.stock_tienda)),
							c.getString(c.getColumnIndex(stockcompleto.stock_virtual)),
							c.getString(c.getColumnIndex(stockcompleto.stock_vendido)),
							c.getString(c.getColumnIndex(stockcompleto.last_update)),
							c.getString(c.getColumnIndex(stockcompleto.producto_id_producto)),
							c.getString(c.getColumnIndex(stockcompleto.empresa_id_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Subcategoria> aeSubcategoria(Cursor c){
		c.moveToFirst();
		ArrayList<Subcategoria> arraylist = new ArrayList<Subcategoria>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Subcategoria(
							c.getString(c.getColumnIndex(subcategoria.id_subcategoria)),
							c.getString(c.getColumnIndex(subcategoria.nombre_subcategoria)),
							c.getString(c.getColumnIndex(subcategoria.descripcion_subcategoria)),
							c.getString(c.getColumnIndex(subcategoria.categoria_id_categoria))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Subrubro> aeSubrubro(Cursor c){
		c.moveToFirst();
		ArrayList<Subrubro> arraylist = new ArrayList<Subrubro>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Subrubro(
							c.getString(c.getColumnIndex(subrubro.id_subrubro)),
							c.getString(c.getColumnIndex(subrubro.nombre_subrubro)),
							c.getString(c.getColumnIndex(subrubro.rubro_id_rubro))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Talla> aeTalla(Cursor c){
		c.moveToFirst();
		ArrayList<Talla> arraylist = new ArrayList<Talla>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Talla(
							c.getString(c.getColumnIndex(talla.id_talla)),
							c.getString(c.getColumnIndex(talla.am_largo)),
							c.getString(c.getColumnIndex(talla.am_ancho)),
							c.getString(c.getColumnIndex(talla.am_fondo)),
							c.getString(c.getColumnIndex(talla.eu_largo)),
							c.getString(c.getColumnIndex(talla.eu_ancho)),
							c.getString(c.getColumnIndex(talla.eu_fondo)),
							c.getString(c.getColumnIndex(talla.num_largo)),
							c.getString(c.getColumnIndex(talla.num_ancho)),
							c.getString(c.getColumnIndex(talla.num_fondo)),
							c.getString(c.getColumnIndex(talla.producto_id_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Tipo_documento> aeTipo_documento(Cursor c){
		c.moveToFirst();
		ArrayList<Tipo_documento> arraylist = new ArrayList<Tipo_documento>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Tipo_documento(
							c.getString(c.getColumnIndex(tipo_documento.id_tipo_documento)),
							c.getString(c.getColumnIndex(tipo_documento.nombre_tipo_documento))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Tipo_empresa> aeTipo_empresa(Cursor c){
		c.moveToFirst();
		ArrayList<Tipo_empresa> arraylist = new ArrayList<Tipo_empresa>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Tipo_empresa(
							c.getString(c.getColumnIndex(tipo_empresa.id_tipo_empresa)),
							c.getString(c.getColumnIndex(tipo_empresa.nombre_tipo_empresa)),
							c.getString(c.getColumnIndex(tipo_empresa.categoria_empresa_id_categoria_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Tipo_pago> aeTipo_pago(Cursor c){
		c.moveToFirst();
		ArrayList<Tipo_pago> arraylist = new ArrayList<Tipo_pago>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Tipo_pago(
							c.getString(c.getColumnIndex(tipo_pago.id_tipo_pago)),
							c.getString(c.getColumnIndex(tipo_pago.nombre_tipo_pago)),
							c.getString(c.getColumnIndex(tipo_pago.comision_tipo_pago))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Tipo_producto> aeTipo_producto(Cursor c){
		c.moveToFirst();
		ArrayList<Tipo_producto> arraylist = new ArrayList<Tipo_producto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Tipo_producto(
							c.getString(c.getColumnIndex(tipo_producto.id_tipo_producto)),
							c.getString(c.getColumnIndex(tipo_producto.nombre_tipo_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Tipo_usuario> aeTipo_usuario(Cursor c){
		c.moveToFirst();
		ArrayList<Tipo_usuario> arraylist = new ArrayList<Tipo_usuario>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Tipo_usuario(
							c.getString(c.getColumnIndex(tipo_usuario.id_tipo_usuario)),
							c.getString(c.getColumnIndex(tipo_usuario.nombre_tipo_usuario))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Ubicacion> aeUbicacion(Cursor c){
		c.moveToFirst();
		ArrayList<Ubicacion> arraylist = new ArrayList<Ubicacion>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Ubicacion(
							c.getString(c.getColumnIndex(ubicacion.id_ubicacion)),
							c.getString(c.getColumnIndex(ubicacion.numero_ubicacion)),
							c.getString(c.getColumnIndex(ubicacion.numero_interior)),
							c.getString(c.getColumnIndex(ubicacion.telefono_ubicacion)),
							c.getString(c.getColumnIndex(ubicacion.default_ubicacion)),
							c.getString(c.getColumnIndex(ubicacion.calle_id_calle)),
							c.getString(c.getColumnIndex(ubicacion.empresa_id_empresa)),
							c.getString(c.getColumnIndex(ubicacion.usuario_id_usuario))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Usuario> aeUsuario(Cursor c){
		c.moveToFirst();
		ArrayList<Usuario> arraylist = new ArrayList<Usuario>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Usuario(
							c.getString(c.getColumnIndex(usuario.id_usuario)),
							c.getString(c.getColumnIndex(usuario.tipo_usuario)),
							c.getString(c.getColumnIndex(usuario.nombre_usuario)),
							c.getString(c.getColumnIndex(usuario.clave)),
							c.getString(c.getColumnIndex(usuario.cliente_id_cliente)),
							c.getString(c.getColumnIndex(usuario.cliente_empresa_id_cliente_empresa))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Usuariocompleto> aeUsuariocompleto(Cursor c){
		c.moveToFirst();
		ArrayList<Usuariocompleto> arraylist = new ArrayList<Usuariocompleto>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Usuariocompleto(
							c.getString(c.getColumnIndex(usuariocompleto.id_persona)),
							c.getString(c.getColumnIndex(usuariocompleto.rut_persona)),
							c.getString(c.getColumnIndex(usuariocompleto.digito_verificador)),
							c.getString(c.getColumnIndex(usuariocompleto.nombre_persona)),
							c.getString(c.getColumnIndex(usuariocompleto.segundo_nombre_persona)),
							c.getString(c.getColumnIndex(usuariocompleto.apellido_persona)),
							c.getString(c.getColumnIndex(usuariocompleto.segundo_apellido_persona)),
							c.getString(c.getColumnIndex(usuariocompleto.actividad)),
							c.getString(c.getColumnIndex(usuariocompleto.area_actividad)),
							c.getString(c.getColumnIndex(usuariocompleto.dia_fecha_nacimiento)),
							c.getString(c.getColumnIndex(usuariocompleto.mes_fecha_nacimiento)),
							c.getString(c.getColumnIndex(usuariocompleto.ano_fecha_nacimiento)),
							c.getString(c.getColumnIndex(usuariocompleto.edad)),
							c.getString(c.getColumnIndex(usuariocompleto.email)),
							c.getString(c.getColumnIndex(usuariocompleto.celular)),
							c.getString(c.getColumnIndex(usuariocompleto.telefono)),
							c.getString(c.getColumnIndex(usuariocompleto.id_carne_empresa)),
							c.getString(c.getColumnIndex(usuariocompleto.nombre_usuario)),
							c.getString(c.getColumnIndex(usuariocompleto.clave_usuario)),
							c.getString(c.getColumnIndex(usuariocompleto.empresa_id_empresa)),
							c.getString(c.getColumnIndex(usuariocompleto.persona_id_persona)),
							c.getString(c.getColumnIndex(usuariocompleto.tipo_usuario_id_tipo_usuario))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Valor_nutricional> aeValor_nutricional(Cursor c){
		c.moveToFirst();
		ArrayList<Valor_nutricional> arraylist = new ArrayList<Valor_nutricional>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Valor_nutricional(
							c.getString(c.getColumnIndex(valor_nutricional.id_valor_nutricional)),
							c.getString(c.getColumnIndex(valor_nutricional.nombre_valor)),
							c.getString(c.getColumnIndex(valor_nutricional.cantidad)),
							c.getString(c.getColumnIndex(valor_nutricional.valor_diario_total)),
							c.getString(c.getColumnIndex(valor_nutricional.porcentaje_requerimientos)),
							c.getString(c.getColumnIndex(valor_nutricional.producto_id_producto))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Venta> aeVenta(Cursor c){
		c.moveToFirst();
		ArrayList<Venta> arraylist = new ArrayList<Venta>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Venta(
							c.getString(c.getColumnIndex(venta.id_venta)),
							c.getString(c.getColumnIndex(venta.numero_articulos)),
							c.getString(c.getColumnIndex(venta.total)),
							c.getString(c.getColumnIndex(venta.dia_fecha_venta)),
							c.getString(c.getColumnIndex(venta.mes_fecha_venta)),
							c.getString(c.getColumnIndex(venta.anno_fecha_venta)),
							c.getString(c.getColumnIndex(venta.hora_fecha_venta)),
							c.getString(c.getColumnIndex(venta.usuario_id_usuario)),
							c.getString(c.getColumnIndex(venta.carne_empresa_id_carne_empresa)),
							c.getString(c.getColumnIndex(venta.tipo_pago_id_tipo_pago)),
							c.getString(c.getColumnIndex(venta.tipo_documento_id_tipo_documento))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}
	public ArrayList<Ventacompleta> aeVentacompleta(Cursor c){
		c.moveToFirst();
		ArrayList<Ventacompleta> arraylist = new ArrayList<Ventacompleta>();
		while(!c.isAfterLast()) {
			arraylist.add(
					new Ventacompleta(
							c.getString(c.getColumnIndex(ventacompleta.id_venta)),
							c.getString(c.getColumnIndex(ventacompleta.numero_articulos)),
							c.getString(c.getColumnIndex(ventacompleta.total)),
							c.getString(c.getColumnIndex(ventacompleta.dia_fecha_venta)),
							c.getString(c.getColumnIndex(ventacompleta.mes_fecha_venta)),
							c.getString(c.getColumnIndex(ventacompleta.anno_fecha_venta)),
							c.getString(c.getColumnIndex(ventacompleta.hora_fecha_venta)),
							c.getString(c.getColumnIndex(ventacompleta.usuario_id_usuario)),
							c.getString(c.getColumnIndex(ventacompleta.carne_empresa_id_carne_empresa)),
							c.getString(c.getColumnIndex(ventacompleta.tipo_pago_id_tipo_pago)),
							c.getString(c.getColumnIndex(ventacompleta.tipo_documento_id_tipo_documento)),
							c.getString(c.getColumnIndex(ventacompleta.id_tipo_pago)),
							c.getString(c.getColumnIndex(ventacompleta.nombre_tipo_pago)),
							c.getString(c.getColumnIndex(ventacompleta.comision_tipo_pago)),
							c.getString(c.getColumnIndex(ventacompleta.id_tipo_documento)),
							c.getString(c.getColumnIndex(ventacompleta.nombre_tipo_documento))
							)
					);
			c.moveToNext();
		}
		c.close();
		return arraylist;
	}

}
