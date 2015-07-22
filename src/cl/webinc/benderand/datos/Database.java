package cl.webinc.benderand.datos;
			
import cl.webinc.benderand.provider.Base.*;
import cl.webinc.benderand.util.Constantes;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

	private static Database dbh;

	private Database(Context context) {
		super(context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);
	}

	public static Database getinstance(Context context) {
		if (dbh == null) {
			dbh = new Database(context);
		}
		return dbh;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.e("data path", "dta" + db.getPath());
		
		db.execSQL("CREATE TABLE " + Constantes.ACTIVIDAD_TABLE_NAME + " ("
 + actividad.id_actividad + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + actividad.nombre_actividad + " TEXT, "
	 + actividad.codigo_actividad + " TEXT, "
	 + actividad.categoria_actividad + " TEXT, "
	 + actividad.afectoiva_actividad + " TEXT, "
	 + actividad.disponible_internet_actividad + " TEXT, "
	 + actividad.subrubro_id_subrubro + "  INTEGER REFERENCES subrubro ( " + subrubro.id_subrubro + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CALLE_TABLE_NAME + " ("
 + calle.id_calle + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + calle.nombre_calle + " TEXT, "
	 + calle.comuna_id_comuna + "  INTEGER REFERENCES comuna ( " + comuna.id_comuna + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CARACTERISTICA_TABLE_NAME + " ("
 + caracteristica.id_caracteristica + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + caracteristica.numero_caracteristica + " INTEGER, "
	 + caracteristica.caracteristica + " TEXT, "
	 + caracteristica.valor_caracteristica + " TEXT, "
	 + caracteristica.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CARNE_EMPRESA_TABLE_NAME + " ("
 + carne_empresa.id_carne_empresa + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + carne_empresa.nombre_usuario + " TEXT, "
	 + carne_empresa.clave_usuario + " TEXT, "
	 + carne_empresa.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ), "
	 + carne_empresa.persona_id_persona + "  INTEGER REFERENCES persona ( " + persona.id_persona + " ), "
	 + carne_empresa.tipo_usuario_id_tipo_usuario + "  INTEGER REFERENCES tipo_usuario ( " + tipo_usuario.id_tipo_usuario + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CARRO_COMPRAS_TABLE_NAME + " ("
 + carro_compras.id_carro_compras + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + carro_compras.cantidad_carro + " INTEGER, "
	 + carro_compras.precio_carro + " INTEGER, "
	 + carro_compras.mayor + " INTEGER, "
	 + carro_compras.tienda + " INTEGER, "
	 + carro_compras.usuario_id_usuario + "  INTEGER REFERENCES usuario ( " + usuario.id_usuario + " ), "
	 + carro_compras.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ), "
	 + carro_compras.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ), "
	 + carro_compras.usado + " INTEGER, "
	 + carro_compras.carne_empresa_id_carne_empresa + "  INTEGER REFERENCES carne_empresa ( " + carne_empresa.id_carne_empresa + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CARRO_EGRESOS_TABLE_NAME + " ("
 + carro_egresos.id_carro_egresos + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + carro_egresos.cantidad_carro + " INTEGER, "
	 + carro_egresos.precio_carro + " INTEGER, "
	 + carro_egresos.mayor + " INTEGER, "
	 + carro_egresos.tienda + " INTEGER, "
	 + carro_egresos.usado + " INTEGER, "
	 + carro_egresos.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ), "
	 + carro_egresos.usuario_id_usuario + "  INTEGER REFERENCES usuario ( " + usuario.id_usuario + " ), "
	 + carro_egresos.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ), "
	 + carro_egresos.carne_empresa_id_carne_empresa + "  INTEGER REFERENCES carne_empresa ( " + carne_empresa.id_carne_empresa + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CARRO_VENTA_TABLE_NAME + " ("
 + carro_venta.id_carro_venta + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + carro_venta.cantidad + " INTEGER, "
	 + carro_venta.precio + " INTEGER, "
	 + carro_venta.carro_compras_id_carro_compras + "  INTEGER REFERENCES carro_compras ( " + carro_compras.id_carro_compras + " ), "
	 + carro_venta.venta_id_venta + "  INTEGER REFERENCES venta ( " + venta.id_venta + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CATEGORIA_TABLE_NAME + " ("
 + categoria.id_categoria + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + categoria.nombre_categoria + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CATEGORIA_EMPRESA_TABLE_NAME + " ("
 + categoria_empresa.id_categoria_empresa + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + categoria_empresa.nombre_categoria_empresa + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CI_SESSIONS_TABLE_NAME + " ("
 + ci_sessions.session_id + " TEXT, "
	 + ci_sessions.ip_address + " TEXT, "
	 + ci_sessions.user_agent + " TEXT, "
	 + ci_sessions.id_user + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + ci_sessions.nombre_apellido + " TEXT, "
	 + ci_sessions.email_user + " TEXT, "
	 + ci_sessions.last_activity + " INTEGER, "
	 + ci_sessions.user_data + "  "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CLIENTE_TABLE_NAME + " ("
 + cliente.id_cliente + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + cliente.rut_cliente + " TEXT, "
	 + cliente.digito_verificador + " INTEGER, "
	 + cliente.nombre_cliente + " TEXT, "
	 + cliente.segundo_nombre_cliente + " TEXT, "
	 + cliente.apellido_cliente + " TEXT, "
	 + cliente.segundo_apellido_cliente + " TEXT, "
	 + cliente.actividad + " TEXT, "
	 + cliente.area_actividad + " TEXT, "
	 + cliente.dia_fecha_nacimiento + " INTEGER, "
	 + cliente.mes_fecha_nacimiento + " INTEGER, "
	 + cliente.ano_fecha_nacimiento + " INTEGER, "
	 + cliente.edad + " TEXT, "
	 + cliente.email + " TEXT, "
	 + cliente.celular + " TEXT, "
	 + cliente.telefono + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CLIENTE_EMPRESA_TABLE_NAME + " ("
 + cliente_empresa.id_cliente_empresa + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + cliente_empresa.rut_cliente_empresa + " TEXT, "
	 + cliente_empresa.digito_verificador + " TEXT, "
	 + cliente_empresa.nombre + " TEXT, "
	 + cliente_empresa.email_cliente_empresa + " TEXT, "
	 + cliente_empresa.actividad_id_actividad + "  INTEGER REFERENCES actividad ( " + actividad.id_actividad + " ), "
	 + cliente_empresa.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.COMUNA_TABLE_NAME + " ("
 + comuna.id_comuna + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + comuna.codigo_comuna + " TEXT, "
	 + comuna.nombre_comuna + " TEXT, "
	 + comuna.provincia_id_provincia + "  INTEGER REFERENCES provincia ( " + provincia.id_provincia + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME + " ("
 + contenido_unidad_medida.id_contenido_unidad_medida + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + contenido_unidad_medida.nombre_contenido_unidad_medida + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.DIA_TABLE_NAME + " ("
 + dia.iddia + " INTEGER, "
	 + dia.dia + " INTEGER, "
	 + dia.mes + " INTEGER, "
	 + dia.anno + " INTEGER, "
	 + dia.fecha + " TEXT, "
	 + dia.egreso + " INTEGER, "
	 + dia.ingreso + " INTEGER, "
	 + dia.impuesto + " INTEGER "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.EMPRESA_TABLE_NAME + " ("
 + empresa.id_empresa + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + empresa.rut_empresa + " TEXT, "
	 + empresa.digito_verificador_empresa + " TEXT, "
	 + empresa.nombre_empresa + " TEXT, "
	 + empresa.nombre_contacto_empresa + " TEXT, "
	 + empresa.cargo_contacto_empresa + " TEXT, "
	 + empresa.email_empresa + " TEXT, "
	 + empresa.alcance_empresa + " TEXT, "
	 + empresa.telefono_empresa + " TEXT, "
	 + empresa.actividad_id_actividad + "  INTEGER REFERENCES actividad ( " + actividad.id_actividad + " ), "
	 + empresa.tipo_empresa_id_tipo_empresa + "  INTEGER REFERENCES tipo_empresa ( " + tipo_empresa.id_tipo_empresa + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.ENVIO_TABLE_NAME + " ("
 + envio.id_envio + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + envio.direccion_alternativa + " TEXT, "
	 + envio.fecha_entrega + " TEXT, "
	 + envio.hora_entrega + " TEXT, "
	 + envio.venta_id_venta + "  INTEGER REFERENCES venta ( " + venta.id_venta + " ), "
	 + envio.enviado + " INTEGER "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.FACTURA_TABLE_NAME + " ("
 + factura.id_factura + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + factura.rol_factura + " INTEGER, "
	 + factura.dia_factura + " INTEGER, "
	 + factura.mes_factura + " INTEGER, "
	 + factura.ano_factura + " INTEGER, "
	 + factura.fecha_factura + " TEXT, "
	 + factura.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ), "
	 + factura.carne_empresa_id_carne_empresa + "  INTEGER REFERENCES carne_empresa ( " + carne_empresa.id_carne_empresa + " ), "
	 + factura.rut_proveedor + " TEXT, "
	 + factura.nombre_proveedor + " TEXT, "
	 + factura.telefono_proveedor + " TEXT, "
	 + factura.tipo_documento_id_tipo_documento + "  INTEGER REFERENCES tipo_documento ( " + tipo_documento.id_tipo_documento + " ), "
	 + factura.tipo_pago_id_tipo_pago + "  INTEGER REFERENCES tipo_pago ( " + tipo_pago.id_tipo_pago + " ), "
	 + factura.total_factura + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.FAMILIA_NECESIDAD_TABLE_NAME + " ("
 + familia_necesidad.id_familia_necesidad + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + familia_necesidad.nombre_familia_necesidad + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.FAMILIA_PRODUCTO_TABLE_NAME + " ("
 + familia_producto.id_familia_producto + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + familia_producto.nombre_familia_producto + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.FORMATO_PRODUCTO_TABLE_NAME + " ("
 + formato_producto.id_formato_producto + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + formato_producto.nombre_formato_producto + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.GASTO_TABLE_NAME + " ("
 + gasto.id_gasto + " INTEGER, "
	 + gasto.nombre_gasto + " TEXT, "
	 + gasto.id_usuario + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + gasto.monto_gasto + " INTEGER, "
	 + gasto.fecha_gasto + " TEXT, "
	 + gasto.empresa_id_empre + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.GEOCODE_CACHE_TABLE_NAME + " ("
 + geocode_cache.id + " INTEGER, "
	 + geocode_cache.lng + " INTEGER, "
	 + geocode_cache.lat + " INTEGER, "
	 + geocode_cache.query + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.IMAGENPROD_TABLE_NAME + " ("
 + imagenprod.id_imagenprod + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + imagenprod.urlimagenprod + " TEXT, "
	 + imagenprod.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.IMPUESTO_TABLE_NAME + " ("
 + impuesto.id_impuesto + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + impuesto.nombre_impuesto + " TEXT, "
	 + impuesto.valor_impuesto + " INTEGER "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.ITEM_FACTURA_TABLE_NAME + " ("
 + item_factura.id_itemfactura + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + item_factura.cantidad + " INTEGER, "
	 + item_factura.precio + " INTEGER, "
	 + item_factura.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ), "
	 + item_factura.factura_id_factura + "  INTEGER REFERENCES factura ( " + factura.id_factura + " ), "
	 + item_factura.carro_egresos_id_carro_egresos + "  INTEGER REFERENCES carro_egresos ( " + carro_egresos.id_carro_egresos + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.MAPA_TABLE_NAME + " ("
 + mapa.id + " INTEGER, "
	 + mapa.name + " TEXT, "
	 + mapa.direccion + " TEXT, "
	 + mapa.lat + " TEXT, "
	 + mapa.lng + " TEXT, "
	 + mapa.tipo + " TEXT, "
	 + mapa.imagen + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.PAIS_TABLE_NAME + " ("
 + pais.id_pais + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + pais.nombre_pais + " TEXT, "
	 + pais.iso_code_2_pais + " TEXT, "
	 + pais.iso_code_3_pais + " TEXT, "
	 + pais.address_format + " INTEGER, "
	 + pais.iso_code_number + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.PERSONA_TABLE_NAME + " ("
 + persona.id_persona + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + persona.rut_persona + " TEXT, "
	 + persona.digito_verificador + " INTEGER, "
	 + persona.nombre_persona + " TEXT, "
	 + persona.segundo_nombre_persona + " TEXT, "
	 + persona.apellido_persona + " TEXT, "
	 + persona.segundo_apellido_persona + " TEXT, "
	 + persona.actividad + " TEXT, "
	 + persona.area_actividad + " TEXT, "
	 + persona.dia_fecha_nacimiento + " INTEGER, "
	 + persona.mes_fecha_nacimiento + " INTEGER, "
	 + persona.ano_fecha_nacimiento + " INTEGER, "
	 + persona.edad + " TEXT, "
	 + persona.email + " TEXT, "
	 + persona.celular + " TEXT, "
	 + persona.telefono + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.PRECIO_TABLE_NAME + " ("
 + precio.id_precio + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + precio.precio_CLP + " INTEGER, "
	 + precio.precio_us + " INTEGER, "
	 + precio.precio_mayor_CLP + " INTEGER, "
	 + precio.precio_mayor_us + " INTEGER, "
	 + precio.precio_actual + " INTEGER, "
	 + precio.descuento_promocion + " INTEGER, "
	 + precio.cantidad_mayor + " INTEGER, "
	 + precio.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ), "
	 + precio.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.PRODUCTO_TABLE_NAME + " ("
 + producto.id_producto + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + producto.codigo_producto + " TEXT, "
	 + producto.numero_serie + " TEXT, "
	 + producto.descripcion_producto + " TEXT, "
	 + producto.nombre_producto + " TEXT, "
	 + producto.marca_producto + " TEXT, "
	 + producto.modelo_producto + " TEXT, "
	 + producto.contenido_unidad + " INTEGER, "
	 + producto.contenido_unidad_medida_id_contenido_unidad_medida + "  INTEGER REFERENCES contenido_unidad_medida ( " + contenido_unidad_medida.id_contenido_unidad_medida + " ), "
	 + producto.unidad_minima + " INTEGER, "
	 + producto.contenido + " INTEGER, "
	 + producto.peso_neto + " INTEGER, "
	 + producto.alto_cm + " INTEGER, "
	 + producto.ancho_cm + " INTEGER, "
	 + producto.fondo_cm + " INTEGER, "
	 + producto.fabricante + " TEXT, "
	 + producto.clase_producto + " TEXT, "
	 + producto.linea_producto + " TEXT, "
	 + producto.hot + " INTEGER, "
	 + producto.SKU + " TEXT, "
	 + producto.subcategoria_id_subcategoria + "  INTEGER REFERENCES subcategoria ( " + subcategoria.id_subcategoria + " ), "
	 + producto.tipo_producto_id_tipo_producto + "  INTEGER REFERENCES tipo_producto ( " + tipo_producto.id_tipo_producto + " ), "
	 + producto.formato_producto_id_formato_producto + "  INTEGER REFERENCES formato_producto ( " + formato_producto.id_formato_producto + " ), "
	 + producto.familia_necesidad_id_familia_necesidad + "  INTEGER REFERENCES familia_necesidad ( " + familia_necesidad.id_familia_necesidad + " ), "
	 + producto.familia_producto_id_familia_producto + "  INTEGER REFERENCES familia_producto ( " + familia_producto.id_familia_producto + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.PROVINCIA_TABLE_NAME + " ("
 + provincia.id_provincia + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + provincia.nombre_provincia + " TEXT, "
	 + provincia.codigo_provincia + " TEXT, "
	 + provincia.region_id_region + "  INTEGER REFERENCES region ( " + region.id_region + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.RECICLADO_TABLE_NAME + " ("
 + reciclado.id_reciclado + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + reciclado.reciclable + " INTEGER, "
	 + reciclado.reciclado + " INTEGER, "
	 + reciclado.valor_reciclaje + " INTEGER, "
	 + reciclado.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ), "
	 + reciclado.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.REGION_TABLE_NAME + " ("
 + region.id_region + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + region.nombre_region + " TEXT, "
	 + region.codigo_region + " TEXT, "
	 + region.pais_id_pais + "  INTEGER REFERENCES pais ( " + pais.id_pais + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.RUBRO_TABLE_NAME + " ("
 + rubro.id_rubro + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + rubro.nombre_rubro + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.SINCRODATE_TABLE_NAME + " ("
 + sincrodate.id_sincrodate + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + sincrodate.date + "  "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.STOCK_TABLE_NAME + " ("
 + stock.id_stock + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + stock.stock_real + " INTEGER, "
	 + stock.stock_minimo + " INTEGER, "
	 + stock.stock_ideal + " INTEGER, "
	 + stock.stock_tienda + " INTEGER, "
	 + stock.stock_virtual + " INTEGER, "
	 + stock.stock_vendido + " INTEGER, "
	 + stock.last_update + " TEXT, "
	 + stock.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ), "
	 + stock.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.SUBCATEGORIA_TABLE_NAME + " ("
 + subcategoria.id_subcategoria + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + subcategoria.nombre_subcategoria + " TEXT, "
	 + subcategoria.descripcion_subcategoria + " TEXT, "
	 + subcategoria.categoria_id_categoria + "  INTEGER REFERENCES categoria ( " + categoria.id_categoria + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.SUBRUBRO_TABLE_NAME + " ("
 + subrubro.id_subrubro + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + subrubro.nombre_subrubro + " TEXT, "
	 + subrubro.rubro_id_rubro + "  INTEGER REFERENCES rubro ( " + rubro.id_rubro + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.TALLA_TABLE_NAME + " ("
 + talla.id_talla + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + talla.am_largo + " INTEGER, "
	 + talla.am_ancho + " TEXT, "
	 + talla.am_fondo + " TEXT, "
	 + talla.eu_largo + " TEXT, "
	 + talla.eu_ancho + " TEXT, "
	 + talla.eu_fondo + " TEXT, "
	 + talla.num_largo + " TEXT, "
	 + talla.num_ancho + " TEXT, "
	 + talla.num_fondo + " TEXT, "
	 + talla.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.TIPO_DOCUMENTO_TABLE_NAME + " ("
 + tipo_documento.id_tipo_documento + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + tipo_documento.nombre_tipo_documento + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.TIPO_EMPRESA_TABLE_NAME + " ("
 + tipo_empresa.id_tipo_empresa + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + tipo_empresa.nombre_tipo_empresa + " TEXT, "
	 + tipo_empresa.categoria_empresa_id_categoria_empresa + "  INTEGER REFERENCES categoria_empresa ( " + categoria_empresa.id_categoria_empresa + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.TIPO_PAGO_TABLE_NAME + " ("
 + tipo_pago.id_tipo_pago + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + tipo_pago.nombre_tipo_pago + " TEXT, "
	 + tipo_pago.comision_tipo_pago + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.TIPO_PRODUCTO_TABLE_NAME + " ("
 + tipo_producto.id_tipo_producto + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + tipo_producto.nombre_tipo_producto + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.TIPO_USUARIO_TABLE_NAME + " ("
 + tipo_usuario.id_tipo_usuario + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + tipo_usuario.nombre_tipo_usuario + " TEXT "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.UBICACION_TABLE_NAME + " ("
 + ubicacion.id_ubicacion + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + ubicacion.numero_ubicacion + " TEXT, "
	 + ubicacion.numero_interior + " TEXT, "
	 + ubicacion.telefono_ubicacion + " TEXT, "
	 + ubicacion.default_ubicacion + " INTEGER, "
	 + ubicacion.calle_id_calle + "  INTEGER REFERENCES calle ( " + calle.id_calle + " ), "
	 + ubicacion.empresa_id_empresa + "  INTEGER REFERENCES empresa ( " + empresa.id_empresa + " ), "
	 + ubicacion.usuario_id_usuario + "  INTEGER REFERENCES usuario ( " + usuario.id_usuario + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.USUARIO_TABLE_NAME + " ("
 + usuario.id_usuario + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + usuario.tipo_usuario + " INTEGER, "
	 + usuario.nombre_usuario + " TEXT, "
	 + usuario.clave + " TEXT, "
	 + usuario.cliente_id_cliente + "  INTEGER REFERENCES cliente ( " + cliente.id_cliente + " ), "
	 + usuario.cliente_empresa_id_cliente_empresa + "  INTEGER REFERENCES cliente_empresa ( " + cliente_empresa.id_cliente_empresa + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.VALOR_NUTRICIONAL_TABLE_NAME + " ("
 + valor_nutricional.id_valor_nutricional + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + valor_nutricional.nombre_valor + " TEXT, "
	 + valor_nutricional.cantidad + " INTEGER, "
	 + valor_nutricional.valor_diario_total + " INTEGER, "
	 + valor_nutricional.porcentaje_requerimientos + " TEXT, "
	 + valor_nutricional.producto_id_producto + "  INTEGER REFERENCES producto ( " + producto.id_producto + " ) "
				+ ");");
		db.execSQL("CREATE TABLE " + Constantes.VENTA_TABLE_NAME + " ("
 + venta.id_venta + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	 + venta.numero_articulos + " INTEGER, "
	 + venta.total + " INTEGER, "
	 + venta.dia_fecha_venta + " TEXT, "
	 + venta.mes_fecha_venta + " TEXT, "
	 + venta.anno_fecha_venta + " TEXT, "
	 + venta.hora_fecha_venta + " TEXT, "
	 + venta.usuario_id_usuario + "  INTEGER REFERENCES usuario ( " + usuario.id_usuario + " ), "
	 + venta.carne_empresa_id_carne_empresa + "  INTEGER REFERENCES carne_empresa ( " + carne_empresa.id_carne_empresa + " ), "
	 + venta.tipo_pago_id_tipo_pago + "  INTEGER REFERENCES tipo_pago ( " + tipo_pago.id_tipo_pago + " ), "
	 + venta.tipo_documento_id_tipo_documento + "  INTEGER REFERENCES tipo_documento ( " + tipo_documento.id_tipo_documento + " ) "
				+ ");");
		
		DatabaseVistas.agregavistas(db);
		BulkInsert.bulk(db);
	}
			
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.ACTIVIDAD_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CALLE_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARACTERISTICA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARNE_EMPRESA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARNE_EMPRESACOMPLETO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARRO_COMPRAS_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARRO_COMPRASCOMPLETO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARRO_EGRESOS_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARRO_EGRESOSCOMPLETO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARRO_EGRESOSPRODUCTO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARRO_VENTA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CARRO_VENTACOMPLETO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CATEGORIA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CATEGORIA_EMPRESA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CI_SESSIONS_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CLIENTE_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CLIENTE_EMPRESA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.COMPRACOMPLETA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.COMUNA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.DIA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.EMPRESA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.ENVIO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.FACTURA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.FAMILIA_NECESIDAD_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.FAMILIA_PRODUCTO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.FORMATO_PRODUCTO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.GASTO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.GEOCODE_CACHE_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.IMAGENPROD_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.IMPUESTO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.INGRESOSEGRESOS_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.ITEM_FACTURA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.ITEM_FACTURACOMPLETO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.MAPA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.PAIS_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.PERSONA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.PRECIO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.PRODUCTO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.PRODUCTOCOMPLETO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.PRODUCTOCOMPRA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.PRODUCTOPRECIO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.PROVINCIA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.RECICLADO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.REGION_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.RUBRO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.SINCRODATE_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.STOCK_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.STOCKCOMPLETO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.SUBCATEGORIA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.SUBRUBRO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.TALLA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.TIPO_DOCUMENTO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.TIPO_EMPRESA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.TIPO_PAGO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.TIPO_PRODUCTO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.TIPO_USUARIO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.UBICACION_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.USUARIO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.USUARIOCOMPLETO_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.VALOR_NUTRICIONAL_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.VENTA_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + Constantes.VENTACOMPLETA_TABLE_NAME);

	}
}