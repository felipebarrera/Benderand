package cl.webinc.benderand.provider;

import cl.webinc.benderand.datos.Database;
import cl.webinc.benderand.provider.Base.*;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.util.Uris;

import android.content.Context;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.net.Uri;

public class DeleteDB {
	private Database mOpenHelper;
	private SQLiteDatabase db;
	private static UriMatcher sUriMatcher;

	public boolean onCreate() {
		Log.e("DeleteDB ", "ONCREATE.............");
		return true;
	}

	public int delete(Uri uri, String where, String[] whereArgs, Context context) {
		mOpenHelper = Database.getinstance(context);
		sUriMatcher = Uris.Creauri();
		db = mOpenHelper.getReadableDatabase();
		int count;
		switch (sUriMatcher.match(uri)) {
			case Constantes.ACTIVIDAD:
				count = db.delete(Constantes.ACTIVIDAD_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.ACTIVIDAD_ID:
				String actividadId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.ACTIVIDAD_TABLE_NAME, actividad._ID + "=" + actividadId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CALLE:
				count = db.delete(Constantes.CALLE_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CALLE_ID:
				String calleId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CALLE_TABLE_NAME, calle._ID + "=" + calleId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARACTERISTICA:
				count = db.delete(Constantes.CARACTERISTICA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARACTERISTICA_ID:
				String caracteristicaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARACTERISTICA_TABLE_NAME, caracteristica._ID + "=" + caracteristicaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARNE_EMPRESA:
				count = db.delete(Constantes.CARNE_EMPRESA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARNE_EMPRESA_ID:
				String carne_empresaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARNE_EMPRESA_TABLE_NAME, carne_empresa._ID + "=" + carne_empresaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARNE_EMPRESACOMPLETO:
				count = db.delete(Constantes.CARNE_EMPRESACOMPLETO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARNE_EMPRESACOMPLETO_ID:
				String carne_empresacompletoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARNE_EMPRESACOMPLETO_TABLE_NAME, carne_empresacompleto._ID + "=" + carne_empresacompletoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARRO_COMPRAS:
				count = db.delete(Constantes.CARRO_COMPRAS_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARRO_COMPRAS_ID:
				String carro_comprasId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARRO_COMPRAS_TABLE_NAME, carro_compras._ID + "=" + carro_comprasId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARRO_COMPRASCOMPLETO:
				count = db.delete(Constantes.CARRO_COMPRASCOMPLETO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARRO_COMPRASCOMPLETO_ID:
				String carro_comprascompletoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARRO_COMPRASCOMPLETO_TABLE_NAME, carro_comprascompleto._ID + "=" + carro_comprascompletoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARRO_EGRESOS:
				count = db.delete(Constantes.CARRO_EGRESOS_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARRO_EGRESOS_ID:
				String carro_egresosId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARRO_EGRESOS_TABLE_NAME, carro_egresos._ID + "=" + carro_egresosId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARRO_EGRESOSCOMPLETO:
				count = db.delete(Constantes.CARRO_EGRESOSCOMPLETO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARRO_EGRESOSCOMPLETO_ID:
				String carro_egresoscompletoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARRO_EGRESOSCOMPLETO_TABLE_NAME, carro_egresoscompleto._ID + "=" + carro_egresoscompletoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARRO_EGRESOSPRODUCTO:
				count = db.delete(Constantes.CARRO_EGRESOSPRODUCTO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARRO_EGRESOSPRODUCTO_ID:
				String carro_egresosproductoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARRO_EGRESOSPRODUCTO_TABLE_NAME, carro_egresosproducto._ID + "=" + carro_egresosproductoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARRO_VENTA:
				count = db.delete(Constantes.CARRO_VENTA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARRO_VENTA_ID:
				String carro_ventaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARRO_VENTA_TABLE_NAME, carro_venta._ID + "=" + carro_ventaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CARRO_VENTACOMPLETO:
				count = db.delete(Constantes.CARRO_VENTACOMPLETO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CARRO_VENTACOMPLETO_ID:
				String carro_ventacompletoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CARRO_VENTACOMPLETO_TABLE_NAME, carro_ventacompleto._ID + "=" + carro_ventacompletoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CATEGORIA:
				count = db.delete(Constantes.CATEGORIA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CATEGORIA_ID:
				String categoriaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CATEGORIA_TABLE_NAME, categoria._ID + "=" + categoriaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CATEGORIA_EMPRESA:
				count = db.delete(Constantes.CATEGORIA_EMPRESA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CATEGORIA_EMPRESA_ID:
				String categoria_empresaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CATEGORIA_EMPRESA_TABLE_NAME, categoria_empresa._ID + "=" + categoria_empresaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CI_SESSIONS:
				count = db.delete(Constantes.CI_SESSIONS_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CI_SESSIONS_ID:
				String ci_sessionsId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CI_SESSIONS_TABLE_NAME, ci_sessions._ID + "=" + ci_sessionsId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CLIENTE:
				count = db.delete(Constantes.CLIENTE_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CLIENTE_ID:
				String clienteId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CLIENTE_TABLE_NAME, cliente._ID + "=" + clienteId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CLIENTE_EMPRESA:
				count = db.delete(Constantes.CLIENTE_EMPRESA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CLIENTE_EMPRESA_ID:
				String cliente_empresaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CLIENTE_EMPRESA_TABLE_NAME, cliente_empresa._ID + "=" + cliente_empresaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.COMPRACOMPLETA:
				count = db.delete(Constantes.COMPRACOMPLETA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.COMPRACOMPLETA_ID:
				String compracompletaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.COMPRACOMPLETA_TABLE_NAME, compracompleta._ID + "=" + compracompletaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.COMUNA:
				count = db.delete(Constantes.COMUNA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.COMUNA_ID:
				String comunaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.COMUNA_TABLE_NAME, comuna._ID + "=" + comunaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.CONTENIDO_UNIDAD_MEDIDA:
				count = db.delete(Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.CONTENIDO_UNIDAD_MEDIDA_ID:
				String contenido_unidad_medidaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME, contenido_unidad_medida._ID + "=" + contenido_unidad_medidaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.DIA:
				count = db.delete(Constantes.DIA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.DIA_ID:
				String diaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.DIA_TABLE_NAME, dia._ID + "=" + diaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.EMPRESA:
				count = db.delete(Constantes.EMPRESA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.EMPRESA_ID:
				String empresaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.EMPRESA_TABLE_NAME, empresa._ID + "=" + empresaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.ENVIO:
				count = db.delete(Constantes.ENVIO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.ENVIO_ID:
				String envioId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.ENVIO_TABLE_NAME, envio._ID + "=" + envioId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.FACTURA:
				count = db.delete(Constantes.FACTURA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.FACTURA_ID:
				String facturaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.FACTURA_TABLE_NAME, factura._ID + "=" + facturaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.FAMILIA_NECESIDAD:
				count = db.delete(Constantes.FAMILIA_NECESIDAD_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.FAMILIA_NECESIDAD_ID:
				String familia_necesidadId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.FAMILIA_NECESIDAD_TABLE_NAME, familia_necesidad._ID + "=" + familia_necesidadId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.FAMILIA_PRODUCTO:
				count = db.delete(Constantes.FAMILIA_PRODUCTO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.FAMILIA_PRODUCTO_ID:
				String familia_productoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.FAMILIA_PRODUCTO_TABLE_NAME, familia_producto._ID + "=" + familia_productoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.FORMATO_PRODUCTO:
				count = db.delete(Constantes.FORMATO_PRODUCTO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.FORMATO_PRODUCTO_ID:
				String formato_productoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.FORMATO_PRODUCTO_TABLE_NAME, formato_producto._ID + "=" + formato_productoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.GASTO:
				count = db.delete(Constantes.GASTO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.GASTO_ID:
				String gastoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.GASTO_TABLE_NAME, gasto._ID + "=" + gastoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.GEOCODE_CACHE:
				count = db.delete(Constantes.GEOCODE_CACHE_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.GEOCODE_CACHE_ID:
				String geocode_cacheId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.GEOCODE_CACHE_TABLE_NAME, geocode_cache._ID + "=" + geocode_cacheId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.IMAGENPROD:
				count = db.delete(Constantes.IMAGENPROD_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.IMAGENPROD_ID:
				String imagenprodId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.IMAGENPROD_TABLE_NAME, imagenprod._ID + "=" + imagenprodId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.IMPUESTO:
				count = db.delete(Constantes.IMPUESTO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.IMPUESTO_ID:
				String impuestoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.IMPUESTO_TABLE_NAME, impuesto._ID + "=" + impuestoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.INGRESOSEGRESOS:
				count = db.delete(Constantes.INGRESOSEGRESOS_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.INGRESOSEGRESOS_ID:
				String ingresosegresosId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.INGRESOSEGRESOS_TABLE_NAME, ingresosegresos._ID + "=" + ingresosegresosId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.ITEM_FACTURA:
				count = db.delete(Constantes.ITEM_FACTURA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.ITEM_FACTURA_ID:
				String item_facturaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.ITEM_FACTURA_TABLE_NAME, item_factura._ID + "=" + item_facturaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.ITEM_FACTURACOMPLETO:
				count = db.delete(Constantes.ITEM_FACTURACOMPLETO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.ITEM_FACTURACOMPLETO_ID:
				String item_facturacompletoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.ITEM_FACTURACOMPLETO_TABLE_NAME, item_facturacompleto._ID + "=" + item_facturacompletoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.MAPA:
				count = db.delete(Constantes.MAPA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.MAPA_ID:
				String mapaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.MAPA_TABLE_NAME, mapa._ID + "=" + mapaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.PAIS:
				count = db.delete(Constantes.PAIS_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.PAIS_ID:
				String paisId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.PAIS_TABLE_NAME, pais._ID + "=" + paisId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.PERSONA:
				count = db.delete(Constantes.PERSONA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.PERSONA_ID:
				String personaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.PERSONA_TABLE_NAME, persona._ID + "=" + personaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.PRECIO:
				count = db.delete(Constantes.PRECIO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.PRECIO_ID:
				String precioId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.PRECIO_TABLE_NAME, precio._ID + "=" + precioId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.PRODUCTO:
				count = db.delete(Constantes.PRODUCTO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.PRODUCTO_ID:
				String productoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.PRODUCTO_TABLE_NAME, producto._ID + "=" + productoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.PRODUCTOCOMPLETO:
				count = db.delete(Constantes.PRODUCTOCOMPLETO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.PRODUCTOCOMPLETO_ID:
				String productocompletoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.PRODUCTOCOMPLETO_TABLE_NAME, productocompleto._ID + "=" + productocompletoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.PRODUCTOCOMPRA:
				count = db.delete(Constantes.PRODUCTOCOMPRA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.PRODUCTOCOMPRA_ID:
				String productocompraId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.PRODUCTOCOMPRA_TABLE_NAME, productocompra._ID + "=" + productocompraId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.PRODUCTOPRECIO:
				count = db.delete(Constantes.PRODUCTOPRECIO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.PRODUCTOPRECIO_ID:
				String productoprecioId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.PRODUCTOPRECIO_TABLE_NAME, productoprecio._ID + "=" + productoprecioId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.PROVINCIA:
				count = db.delete(Constantes.PROVINCIA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.PROVINCIA_ID:
				String provinciaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.PROVINCIA_TABLE_NAME, provincia._ID + "=" + provinciaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.RECICLADO:
				count = db.delete(Constantes.RECICLADO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.RECICLADO_ID:
				String recicladoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.RECICLADO_TABLE_NAME, reciclado._ID + "=" + recicladoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.REGION:
				count = db.delete(Constantes.REGION_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.REGION_ID:
				String regionId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.REGION_TABLE_NAME, region._ID + "=" + regionId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.RUBRO:
				count = db.delete(Constantes.RUBRO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.RUBRO_ID:
				String rubroId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.RUBRO_TABLE_NAME, rubro._ID + "=" + rubroId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.SINCRODATE:
				count = db.delete(Constantes.SINCRODATE_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.SINCRODATE_ID:
				String sincrodateId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.SINCRODATE_TABLE_NAME, sincrodate._ID + "=" + sincrodateId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.STOCK:
				count = db.delete(Constantes.STOCK_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.STOCK_ID:
				String stockId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.STOCK_TABLE_NAME, stock._ID + "=" + stockId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.STOCKCOMPLETO:
				count = db.delete(Constantes.STOCKCOMPLETO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.STOCKCOMPLETO_ID:
				String stockcompletoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.STOCKCOMPLETO_TABLE_NAME, stockcompleto._ID + "=" + stockcompletoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.SUBCATEGORIA:
				count = db.delete(Constantes.SUBCATEGORIA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.SUBCATEGORIA_ID:
				String subcategoriaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.SUBCATEGORIA_TABLE_NAME, subcategoria._ID + "=" + subcategoriaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.SUBRUBRO:
				count = db.delete(Constantes.SUBRUBRO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.SUBRUBRO_ID:
				String subrubroId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.SUBRUBRO_TABLE_NAME, subrubro._ID + "=" + subrubroId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.TALLA:
				count = db.delete(Constantes.TALLA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.TALLA_ID:
				String tallaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.TALLA_TABLE_NAME, talla._ID + "=" + tallaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.TIPO_DOCUMENTO:
				count = db.delete(Constantes.TIPO_DOCUMENTO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.TIPO_DOCUMENTO_ID:
				String tipo_documentoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.TIPO_DOCUMENTO_TABLE_NAME, tipo_documento._ID + "=" + tipo_documentoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.TIPO_EMPRESA:
				count = db.delete(Constantes.TIPO_EMPRESA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.TIPO_EMPRESA_ID:
				String tipo_empresaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.TIPO_EMPRESA_TABLE_NAME, tipo_empresa._ID + "=" + tipo_empresaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.TIPO_PAGO:
				count = db.delete(Constantes.TIPO_PAGO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.TIPO_PAGO_ID:
				String tipo_pagoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.TIPO_PAGO_TABLE_NAME, tipo_pago._ID + "=" + tipo_pagoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.TIPO_PRODUCTO:
				count = db.delete(Constantes.TIPO_PRODUCTO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.TIPO_PRODUCTO_ID:
				String tipo_productoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.TIPO_PRODUCTO_TABLE_NAME, tipo_producto._ID + "=" + tipo_productoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.TIPO_USUARIO:
				count = db.delete(Constantes.TIPO_USUARIO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.TIPO_USUARIO_ID:
				String tipo_usuarioId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.TIPO_USUARIO_TABLE_NAME, tipo_usuario._ID + "=" + tipo_usuarioId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.UBICACION:
				count = db.delete(Constantes.UBICACION_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.UBICACION_ID:
				String ubicacionId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.UBICACION_TABLE_NAME, ubicacion._ID + "=" + ubicacionId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.USUARIO:
				count = db.delete(Constantes.USUARIO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.USUARIO_ID:
				String usuarioId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.USUARIO_TABLE_NAME, usuario._ID + "=" + usuarioId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.USUARIOCOMPLETO:
				count = db.delete(Constantes.USUARIOCOMPLETO_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.USUARIOCOMPLETO_ID:
				String usuariocompletoId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.USUARIOCOMPLETO_TABLE_NAME, usuariocompleto._ID + "=" + usuariocompletoId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.VALOR_NUTRICIONAL:
				count = db.delete(Constantes.VALOR_NUTRICIONAL_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.VALOR_NUTRICIONAL_ID:
				String valor_nutricionalId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.VALOR_NUTRICIONAL_TABLE_NAME, valor_nutricional._ID + "=" + valor_nutricionalId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.VENTA:
				count = db.delete(Constantes.VENTA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.VENTA_ID:
				String ventaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.VENTA_TABLE_NAME, venta._ID + "=" + ventaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;
			case Constantes.VENTACOMPLETA:
				count = db.delete(Constantes.VENTACOMPLETA_TABLE_NAME, where, whereArgs);
				break;
			case Constantes.VENTACOMPLETA_ID:
				String ventacompletaId = uri.getPathSegments().get(1);
				count = db.delete(Constantes.VENTACOMPLETA_TABLE_NAME, ventacompleta._ID + "=" + ventacompletaId
                + (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			default:
				throw new IllegalArgumentException("Unknown URI " + uri);
		}
		context.getContentResolver().notifyChange(uri, null);
		return count;
	}			
}
