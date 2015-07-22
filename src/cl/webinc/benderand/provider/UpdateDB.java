
package cl.webinc.benderand.provider;

import cl.webinc.benderand.datos.Database;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.provider.Base.*;
import cl.webinc.benderand.util.Uris;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class UpdateDB 
{
	private Database mOpenHelper;
	private SQLiteDatabase db;
	private static UriMatcher sUriMatcher;

	public boolean onCreate() 
	{
		Log.e("updateDB ", "ONCREATE.............");
		return true;
	}

	public int update(Uri uri, ContentValues values, String where, String[] whereArgs, Context context) 
	{
		mOpenHelper = Database.getinstance(context);
		sUriMatcher = Uris.Creauri();
		db = mOpenHelper.getReadableDatabase();
		int count;
		switch (sUriMatcher.match(uri)) 
		{

			case Constantes.ACTIVIDAD:
				count = db.update(Constantes.ACTIVIDAD_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.ACTIVIDAD_ID:
				String actividadId = uri.getPathSegments().get(1);
				count = db.update(Constantes.ACTIVIDAD_TABLE_NAME, values, actividad._ID + "=" + actividadId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CALLE:
				count = db.update(Constantes.CALLE_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CALLE_ID:
				String calleId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CALLE_TABLE_NAME, values, calle._ID + "=" + calleId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARACTERISTICA:
				count = db.update(Constantes.CARACTERISTICA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARACTERISTICA_ID:
				String caracteristicaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARACTERISTICA_TABLE_NAME, values, caracteristica._ID + "=" + caracteristicaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARNE_EMPRESA:
				count = db.update(Constantes.CARNE_EMPRESA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARNE_EMPRESA_ID:
				String carne_empresaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARNE_EMPRESA_TABLE_NAME, values, carne_empresa._ID + "=" + carne_empresaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARNE_EMPRESACOMPLETO:
				count = db.update(Constantes.CARNE_EMPRESACOMPLETO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARNE_EMPRESACOMPLETO_ID:
				String carne_empresacompletoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARNE_EMPRESACOMPLETO_TABLE_NAME, values, carne_empresacompleto._ID + "=" + carne_empresacompletoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARRO_COMPRAS:
				count = db.update(Constantes.CARRO_COMPRAS_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARRO_COMPRAS_ID:
				String carro_comprasId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARRO_COMPRAS_TABLE_NAME, values, carro_compras._ID + "=" + carro_comprasId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARRO_COMPRASCOMPLETO:
				count = db.update(Constantes.CARRO_COMPRASCOMPLETO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARRO_COMPRASCOMPLETO_ID:
				String carro_comprascompletoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARRO_COMPRASCOMPLETO_TABLE_NAME, values, carro_comprascompleto._ID + "=" + carro_comprascompletoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARRO_EGRESOS:
				count = db.update(Constantes.CARRO_EGRESOS_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARRO_EGRESOS_ID:
				String carro_egresosId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARRO_EGRESOS_TABLE_NAME, values, carro_egresos._ID + "=" + carro_egresosId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARRO_EGRESOSCOMPLETO:
				count = db.update(Constantes.CARRO_EGRESOSCOMPLETO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARRO_EGRESOSCOMPLETO_ID:
				String carro_egresoscompletoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARRO_EGRESOSCOMPLETO_TABLE_NAME, values, carro_egresoscompleto._ID + "=" + carro_egresoscompletoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARRO_EGRESOSPRODUCTO:
				count = db.update(Constantes.CARRO_EGRESOSPRODUCTO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARRO_EGRESOSPRODUCTO_ID:
				String carro_egresosproductoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARRO_EGRESOSPRODUCTO_TABLE_NAME, values, carro_egresosproducto._ID + "=" + carro_egresosproductoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARRO_VENTA:
				count = db.update(Constantes.CARRO_VENTA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARRO_VENTA_ID:
				String carro_ventaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARRO_VENTA_TABLE_NAME, values, carro_venta._ID + "=" + carro_ventaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CARRO_VENTACOMPLETO:
				count = db.update(Constantes.CARRO_VENTACOMPLETO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CARRO_VENTACOMPLETO_ID:
				String carro_ventacompletoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CARRO_VENTACOMPLETO_TABLE_NAME, values, carro_ventacompleto._ID + "=" + carro_ventacompletoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CATEGORIA:
				count = db.update(Constantes.CATEGORIA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CATEGORIA_ID:
				String categoriaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CATEGORIA_TABLE_NAME, values, categoria._ID + "=" + categoriaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CATEGORIA_EMPRESA:
				count = db.update(Constantes.CATEGORIA_EMPRESA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CATEGORIA_EMPRESA_ID:
				String categoria_empresaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CATEGORIA_EMPRESA_TABLE_NAME, values, categoria_empresa._ID + "=" + categoria_empresaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CI_SESSIONS:
				count = db.update(Constantes.CI_SESSIONS_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CI_SESSIONS_ID:
				String ci_sessionsId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CI_SESSIONS_TABLE_NAME, values, ci_sessions._ID + "=" + ci_sessionsId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CLIENTE:
				count = db.update(Constantes.CLIENTE_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CLIENTE_ID:
				String clienteId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CLIENTE_TABLE_NAME, values, cliente._ID + "=" + clienteId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CLIENTE_EMPRESA:
				count = db.update(Constantes.CLIENTE_EMPRESA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CLIENTE_EMPRESA_ID:
				String cliente_empresaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CLIENTE_EMPRESA_TABLE_NAME, values, cliente_empresa._ID + "=" + cliente_empresaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.COMPRACOMPLETA:
				count = db.update(Constantes.COMPRACOMPLETA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.COMPRACOMPLETA_ID:
				String compracompletaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.COMPRACOMPLETA_TABLE_NAME, values, compracompleta._ID + "=" + compracompletaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.COMUNA:
				count = db.update(Constantes.COMUNA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.COMUNA_ID:
				String comunaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.COMUNA_TABLE_NAME, values, comuna._ID + "=" + comunaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.CONTENIDO_UNIDAD_MEDIDA:
				count = db.update(Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.CONTENIDO_UNIDAD_MEDIDA_ID:
				String contenido_unidad_medidaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME, values, contenido_unidad_medida._ID + "=" + contenido_unidad_medidaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.DIA:
				count = db.update(Constantes.DIA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.DIA_ID:
				String diaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.DIA_TABLE_NAME, values, dia._ID + "=" + diaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.EMPRESA:
				count = db.update(Constantes.EMPRESA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.EMPRESA_ID:
				String empresaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.EMPRESA_TABLE_NAME, values, empresa._ID + "=" + empresaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.ENVIO:
				count = db.update(Constantes.ENVIO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.ENVIO_ID:
				String envioId = uri.getPathSegments().get(1);
				count = db.update(Constantes.ENVIO_TABLE_NAME, values, envio._ID + "=" + envioId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.FACTURA:
				count = db.update(Constantes.FACTURA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.FACTURA_ID:
				String facturaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.FACTURA_TABLE_NAME, values, factura._ID + "=" + facturaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.FAMILIA_NECESIDAD:
				count = db.update(Constantes.FAMILIA_NECESIDAD_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.FAMILIA_NECESIDAD_ID:
				String familia_necesidadId = uri.getPathSegments().get(1);
				count = db.update(Constantes.FAMILIA_NECESIDAD_TABLE_NAME, values, familia_necesidad._ID + "=" + familia_necesidadId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.FAMILIA_PRODUCTO:
				count = db.update(Constantes.FAMILIA_PRODUCTO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.FAMILIA_PRODUCTO_ID:
				String familia_productoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.FAMILIA_PRODUCTO_TABLE_NAME, values, familia_producto._ID + "=" + familia_productoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.FORMATO_PRODUCTO:
				count = db.update(Constantes.FORMATO_PRODUCTO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.FORMATO_PRODUCTO_ID:
				String formato_productoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.FORMATO_PRODUCTO_TABLE_NAME, values, formato_producto._ID + "=" + formato_productoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.GASTO:
				count = db.update(Constantes.GASTO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.GASTO_ID:
				String gastoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.GASTO_TABLE_NAME, values, gasto._ID + "=" + gastoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.GEOCODE_CACHE:
				count = db.update(Constantes.GEOCODE_CACHE_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.GEOCODE_CACHE_ID:
				String geocode_cacheId = uri.getPathSegments().get(1);
				count = db.update(Constantes.GEOCODE_CACHE_TABLE_NAME, values, geocode_cache._ID + "=" + geocode_cacheId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.IMAGENPROD:
				count = db.update(Constantes.IMAGENPROD_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.IMAGENPROD_ID:
				String imagenprodId = uri.getPathSegments().get(1);
				count = db.update(Constantes.IMAGENPROD_TABLE_NAME, values, imagenprod._ID + "=" + imagenprodId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.IMPUESTO:
				count = db.update(Constantes.IMPUESTO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.IMPUESTO_ID:
				String impuestoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.IMPUESTO_TABLE_NAME, values, impuesto._ID + "=" + impuestoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.INGRESOSEGRESOS:
				count = db.update(Constantes.INGRESOSEGRESOS_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.INGRESOSEGRESOS_ID:
				String ingresosegresosId = uri.getPathSegments().get(1);
				count = db.update(Constantes.INGRESOSEGRESOS_TABLE_NAME, values, ingresosegresos._ID + "=" + ingresosegresosId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.ITEM_FACTURA:
				count = db.update(Constantes.ITEM_FACTURA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.ITEM_FACTURA_ID:
				String item_facturaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.ITEM_FACTURA_TABLE_NAME, values, item_factura._ID + "=" + item_facturaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.ITEM_FACTURACOMPLETO:
				count = db.update(Constantes.ITEM_FACTURACOMPLETO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.ITEM_FACTURACOMPLETO_ID:
				String item_facturacompletoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.ITEM_FACTURACOMPLETO_TABLE_NAME, values, item_facturacompleto._ID + "=" + item_facturacompletoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.MAPA:
				count = db.update(Constantes.MAPA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.MAPA_ID:
				String mapaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.MAPA_TABLE_NAME, values, mapa._ID + "=" + mapaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.PAIS:
				count = db.update(Constantes.PAIS_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.PAIS_ID:
				String paisId = uri.getPathSegments().get(1);
				count = db.update(Constantes.PAIS_TABLE_NAME, values, pais._ID + "=" + paisId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.PERSONA:
				count = db.update(Constantes.PERSONA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.PERSONA_ID:
				String personaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.PERSONA_TABLE_NAME, values, persona._ID + "=" + personaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.PRECIO:
				count = db.update(Constantes.PRECIO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.PRECIO_ID:
				String precioId = uri.getPathSegments().get(1);
				count = db.update(Constantes.PRECIO_TABLE_NAME, values, precio._ID + "=" + precioId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.PRODUCTO:
				count = db.update(Constantes.PRODUCTO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.PRODUCTO_ID:
				String productoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.PRODUCTO_TABLE_NAME, values, producto._ID + "=" + productoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.PRODUCTOCOMPLETO:
				count = db.update(Constantes.PRODUCTOCOMPLETO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.PRODUCTOCOMPLETO_ID:
				String productocompletoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.PRODUCTOCOMPLETO_TABLE_NAME, values, productocompleto._ID + "=" + productocompletoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.PRODUCTOCOMPRA:
				count = db.update(Constantes.PRODUCTOCOMPRA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.PRODUCTOCOMPRA_ID:
				String productocompraId = uri.getPathSegments().get(1);
				count = db.update(Constantes.PRODUCTOCOMPRA_TABLE_NAME, values, productocompra._ID + "=" + productocompraId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.PRODUCTOPRECIO:
				count = db.update(Constantes.PRODUCTOPRECIO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.PRODUCTOPRECIO_ID:
				String productoprecioId = uri.getPathSegments().get(1);
				count = db.update(Constantes.PRODUCTOPRECIO_TABLE_NAME, values, productoprecio._ID + "=" + productoprecioId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.PROVINCIA:
				count = db.update(Constantes.PROVINCIA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.PROVINCIA_ID:
				String provinciaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.PROVINCIA_TABLE_NAME, values, provincia._ID + "=" + provinciaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.RECICLADO:
				count = db.update(Constantes.RECICLADO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.RECICLADO_ID:
				String recicladoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.RECICLADO_TABLE_NAME, values, reciclado._ID + "=" + recicladoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.REGION:
				count = db.update(Constantes.REGION_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.REGION_ID:
				String regionId = uri.getPathSegments().get(1);
				count = db.update(Constantes.REGION_TABLE_NAME, values, region._ID + "=" + regionId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.RUBRO:
				count = db.update(Constantes.RUBRO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.RUBRO_ID:
				String rubroId = uri.getPathSegments().get(1);
				count = db.update(Constantes.RUBRO_TABLE_NAME, values, rubro._ID + "=" + rubroId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.SINCRODATE:
				count = db.update(Constantes.SINCRODATE_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.SINCRODATE_ID:
				String sincrodateId = uri.getPathSegments().get(1);
				count = db.update(Constantes.SINCRODATE_TABLE_NAME, values, sincrodate._ID + "=" + sincrodateId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.STOCK:
				count = db.update(Constantes.STOCK_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.STOCK_ID:
				String stockId = uri.getPathSegments().get(1);
				count = db.update(Constantes.STOCK_TABLE_NAME, values, stock._ID + "=" + stockId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.STOCKCOMPLETO:
				count = db.update(Constantes.STOCKCOMPLETO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.STOCKCOMPLETO_ID:
				String stockcompletoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.STOCKCOMPLETO_TABLE_NAME, values, stockcompleto._ID + "=" + stockcompletoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.SUBCATEGORIA:
				count = db.update(Constantes.SUBCATEGORIA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.SUBCATEGORIA_ID:
				String subcategoriaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.SUBCATEGORIA_TABLE_NAME, values, subcategoria._ID + "=" + subcategoriaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.SUBRUBRO:
				count = db.update(Constantes.SUBRUBRO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.SUBRUBRO_ID:
				String subrubroId = uri.getPathSegments().get(1);
				count = db.update(Constantes.SUBRUBRO_TABLE_NAME, values, subrubro._ID + "=" + subrubroId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.TALLA:
				count = db.update(Constantes.TALLA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.TALLA_ID:
				String tallaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.TALLA_TABLE_NAME, values, talla._ID + "=" + tallaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.TIPO_DOCUMENTO:
				count = db.update(Constantes.TIPO_DOCUMENTO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.TIPO_DOCUMENTO_ID:
				String tipo_documentoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.TIPO_DOCUMENTO_TABLE_NAME, values, tipo_documento._ID + "=" + tipo_documentoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.TIPO_EMPRESA:
				count = db.update(Constantes.TIPO_EMPRESA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.TIPO_EMPRESA_ID:
				String tipo_empresaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.TIPO_EMPRESA_TABLE_NAME, values, tipo_empresa._ID + "=" + tipo_empresaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.TIPO_PAGO:
				count = db.update(Constantes.TIPO_PAGO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.TIPO_PAGO_ID:
				String tipo_pagoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.TIPO_PAGO_TABLE_NAME, values, tipo_pago._ID + "=" + tipo_pagoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.TIPO_PRODUCTO:
				count = db.update(Constantes.TIPO_PRODUCTO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.TIPO_PRODUCTO_ID:
				String tipo_productoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.TIPO_PRODUCTO_TABLE_NAME, values, tipo_producto._ID + "=" + tipo_productoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.TIPO_USUARIO:
				count = db.update(Constantes.TIPO_USUARIO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.TIPO_USUARIO_ID:
				String tipo_usuarioId = uri.getPathSegments().get(1);
				count = db.update(Constantes.TIPO_USUARIO_TABLE_NAME, values, tipo_usuario._ID + "=" + tipo_usuarioId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.UBICACION:
				count = db.update(Constantes.UBICACION_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.UBICACION_ID:
				String ubicacionId = uri.getPathSegments().get(1);
				count = db.update(Constantes.UBICACION_TABLE_NAME, values, ubicacion._ID + "=" + ubicacionId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.USUARIO:
				count = db.update(Constantes.USUARIO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.USUARIO_ID:
				String usuarioId = uri.getPathSegments().get(1);
				count = db.update(Constantes.USUARIO_TABLE_NAME, values, usuario._ID + "=" + usuarioId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.USUARIOCOMPLETO:
				count = db.update(Constantes.USUARIOCOMPLETO_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.USUARIOCOMPLETO_ID:
				String usuariocompletoId = uri.getPathSegments().get(1);
				count = db.update(Constantes.USUARIOCOMPLETO_TABLE_NAME, values, usuariocompleto._ID + "=" + usuariocompletoId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.VALOR_NUTRICIONAL:
				count = db.update(Constantes.VALOR_NUTRICIONAL_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.VALOR_NUTRICIONAL_ID:
				String valor_nutricionalId = uri.getPathSegments().get(1);
				count = db.update(Constantes.VALOR_NUTRICIONAL_TABLE_NAME, values, valor_nutricional._ID + "=" + valor_nutricionalId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.VENTA:
				count = db.update(Constantes.VENTA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.VENTA_ID:
				String ventaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.VENTA_TABLE_NAME, values, venta._ID + "=" + ventaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			case Constantes.VENTACOMPLETA:
				count = db.update(Constantes.VENTACOMPLETA_TABLE_NAME, values, where, whereArgs);
				break;

			case Constantes.VENTACOMPLETA_ID:
				String ventacompletaId = uri.getPathSegments().get(1);
				count = db.update(Constantes.VENTACOMPLETA_TABLE_NAME, values, ventacompleta._ID + "=" + ventacompletaId
				+ (!TextUtils.isEmpty(where) ? " AND (" + where + ")" : ""), whereArgs);
				break;

			default:
				throw new IllegalArgumentException("Unknown URI " + uri);
		}
		context.getContentResolver().notifyChange(uri, null);
		return count;
	}
}
