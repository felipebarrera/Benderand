
package cl.webinc.benderand.provider;

import cl.webinc.benderand.datos.Database;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.util.Uris;
import cl.webinc.benderand.provider.Base.*;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class InsertDB 
{
	private Database mOpenHelper;
	private SQLiteDatabase db;
	//private static final Long now = Long.valueOf(System.currentTimeMillis());
	private long rowId;
	private Uri uriReturn;
	private static UriMatcher sUriMatcher;

	public boolean onCreate() 
	{
		Log.e("InsertDB ", "ONCREATE.............");
		return true;
	}

	public Uri insert(Uri uri, ContentValues initialValues, Context context) 
	{
		uriReturn = uri;
		mOpenHelper = Database.getinstance(context);
		sUriMatcher = Uris.Creauri();
		db = mOpenHelper.getReadableDatabase();
		ContentValues values;
		if (initialValues != null) 
		{
			values = new ContentValues(initialValues);
		} 
		else 
		{
			values = new ContentValues();
		}
		Log.e("urimatcher", "" + sUriMatcher.match(uri) + uri);

			if (sUriMatcher.match(uri) == Constantes.ACTIVIDAD) 
			{
				rowId = db.insert(Constantes.ACTIVIDAD_TABLE_NAME, actividad.subrubro_id_subrubro, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(actividad.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB actividad", " " + values.get(actividad.subrubro_id_subrubro));
			}
			if (sUriMatcher.match(uri) == Constantes.CALLE) 
			{
				rowId = db.insert(Constantes.CALLE_TABLE_NAME, calle.comuna_id_comuna, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(calle.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB calle", " " + values.get(calle.comuna_id_comuna));
			}
			if (sUriMatcher.match(uri) == Constantes.CARACTERISTICA) 
			{
				rowId = db.insert(Constantes.CARACTERISTICA_TABLE_NAME, caracteristica.producto_id_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(caracteristica.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB caracteristica", " " + values.get(caracteristica.producto_id_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.CARNE_EMPRESA) 
			{
				rowId = db.insert(Constantes.CARNE_EMPRESA_TABLE_NAME, carne_empresa.tipo_usuario_id_tipo_usuario, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carne_empresa.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carne_empresa", " " + values.get(carne_empresa.tipo_usuario_id_tipo_usuario));
			}
			if (sUriMatcher.match(uri) == Constantes.CARNE_EMPRESACOMPLETO) 
			{
				rowId = db.insert(Constantes.CARNE_EMPRESACOMPLETO_TABLE_NAME, carne_empresacompleto.telefono, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carne_empresacompleto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carne_empresacompleto", " " + values.get(carne_empresacompleto.telefono));
			}
			if (sUriMatcher.match(uri) == Constantes.CARRO_COMPRAS) 
			{
				rowId = db.insert(Constantes.CARRO_COMPRAS_TABLE_NAME, carro_compras.carne_empresa_id_carne_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carro_compras.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carro_compras", " " + values.get(carro_compras.carne_empresa_id_carne_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.CARRO_COMPRASCOMPLETO) 
			{
				rowId = db.insert(Constantes.CARRO_COMPRASCOMPLETO_TABLE_NAME, carro_comprascompleto.stock_tienda, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carro_comprascompleto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carro_comprascompleto", " " + values.get(carro_comprascompleto.stock_tienda));
			}
			if (sUriMatcher.match(uri) == Constantes.CARRO_EGRESOS) 
			{
				rowId = db.insert(Constantes.CARRO_EGRESOS_TABLE_NAME, carro_egresos.carne_empresa_id_carne_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carro_egresos.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carro_egresos", " " + values.get(carro_egresos.carne_empresa_id_carne_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.CARRO_EGRESOSCOMPLETO) 
			{
				rowId = db.insert(Constantes.CARRO_EGRESOSCOMPLETO_TABLE_NAME, carro_egresoscompleto.precio_CLP, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carro_egresoscompleto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carro_egresoscompleto", " " + values.get(carro_egresoscompleto.precio_CLP));
			}
			if (sUriMatcher.match(uri) == Constantes.CARRO_EGRESOSPRODUCTO) 
			{
				rowId = db.insert(Constantes.CARRO_EGRESOSPRODUCTO_TABLE_NAME, carro_egresosproducto.formato_producto_id_formato_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carro_egresosproducto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carro_egresosproducto", " " + values.get(carro_egresosproducto.formato_producto_id_formato_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.CARRO_VENTA) 
			{
				rowId = db.insert(Constantes.CARRO_VENTA_TABLE_NAME, carro_venta.venta_id_venta, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carro_venta.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carro_venta", " " + values.get(carro_venta.venta_id_venta));
			}
			if (sUriMatcher.match(uri) == Constantes.CARRO_VENTACOMPLETO) 
			{
				rowId = db.insert(Constantes.CARRO_VENTACOMPLETO_TABLE_NAME, carro_ventacompleto.formato_producto_id_formato_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(carro_ventacompleto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB carro_ventacompleto", " " + values.get(carro_ventacompleto.formato_producto_id_formato_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.CATEGORIA) 
			{
				rowId = db.insert(Constantes.CATEGORIA_TABLE_NAME, categoria.nombre_categoria, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(categoria.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB categoria", " " + values.get(categoria.nombre_categoria));
			}
			if (sUriMatcher.match(uri) == Constantes.CATEGORIA_EMPRESA) 
			{
				rowId = db.insert(Constantes.CATEGORIA_EMPRESA_TABLE_NAME, categoria_empresa.nombre_categoria_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(categoria_empresa.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB categoria_empresa", " " + values.get(categoria_empresa.nombre_categoria_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.CI_SESSIONS) 
			{
				rowId = db.insert(Constantes.CI_SESSIONS_TABLE_NAME, ci_sessions.user_data, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(ci_sessions.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB ci_sessions", " " + values.get(ci_sessions.user_data));
			}
			if (sUriMatcher.match(uri) == Constantes.CLIENTE) 
			{
				rowId = db.insert(Constantes.CLIENTE_TABLE_NAME, cliente.telefono, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(cliente.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB cliente", " " + values.get(cliente.telefono));
			}
			if (sUriMatcher.match(uri) == Constantes.CLIENTE_EMPRESA) 
			{
				rowId = db.insert(Constantes.CLIENTE_EMPRESA_TABLE_NAME, cliente_empresa.empresa_id_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(cliente_empresa.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB cliente_empresa", " " + values.get(cliente_empresa.empresa_id_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.COMPRACOMPLETA) 
			{
				rowId = db.insert(Constantes.COMPRACOMPLETA_TABLE_NAME, compracompleta.nombre_tipo_documento, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(compracompleta.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB compracompleta", " " + values.get(compracompleta.nombre_tipo_documento));
			}
			if (sUriMatcher.match(uri) == Constantes.COMUNA) 
			{
				rowId = db.insert(Constantes.COMUNA_TABLE_NAME, comuna.provincia_id_provincia, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(comuna.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB comuna", " " + values.get(comuna.provincia_id_provincia));
			}
			if (sUriMatcher.match(uri) == Constantes.CONTENIDO_UNIDAD_MEDIDA) 
			{
				rowId = db.insert(Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME, contenido_unidad_medida.nombre_contenido_unidad_medida, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(contenido_unidad_medida.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB contenido_unidad_medida", " " + values.get(contenido_unidad_medida.nombre_contenido_unidad_medida));
			}
			if (sUriMatcher.match(uri) == Constantes.DIA) 
			{
				rowId = db.insert(Constantes.DIA_TABLE_NAME, dia.impuesto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(dia.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB dia", " " + values.get(dia.impuesto));
			}
			if (sUriMatcher.match(uri) == Constantes.EMPRESA) 
			{
				rowId = db.insert(Constantes.EMPRESA_TABLE_NAME, empresa.tipo_empresa_id_tipo_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(empresa.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB empresa", " " + values.get(empresa.tipo_empresa_id_tipo_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.ENVIO) 
			{
				rowId = db.insert(Constantes.ENVIO_TABLE_NAME, envio.enviado, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(envio.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB envio", " " + values.get(envio.enviado));
			}
			if (sUriMatcher.match(uri) == Constantes.FACTURA) 
			{
				rowId = db.insert(Constantes.FACTURA_TABLE_NAME, factura.total_factura, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(factura.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB factura", " " + values.get(factura.total_factura));
			}
			if (sUriMatcher.match(uri) == Constantes.FAMILIA_NECESIDAD) 
			{
				rowId = db.insert(Constantes.FAMILIA_NECESIDAD_TABLE_NAME, familia_necesidad.nombre_familia_necesidad, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(familia_necesidad.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB familia_necesidad", " " + values.get(familia_necesidad.nombre_familia_necesidad));
			}
			if (sUriMatcher.match(uri) == Constantes.FAMILIA_PRODUCTO) 
			{
				rowId = db.insert(Constantes.FAMILIA_PRODUCTO_TABLE_NAME, familia_producto.nombre_familia_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(familia_producto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB familia_producto", " " + values.get(familia_producto.nombre_familia_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.FORMATO_PRODUCTO) 
			{
				rowId = db.insert(Constantes.FORMATO_PRODUCTO_TABLE_NAME, formato_producto.nombre_formato_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(formato_producto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB formato_producto", " " + values.get(formato_producto.nombre_formato_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.GASTO) 
			{
				rowId = db.insert(Constantes.GASTO_TABLE_NAME, gasto.empresa_id_empre, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(gasto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB gasto", " " + values.get(gasto.empresa_id_empre));
			}
			if (sUriMatcher.match(uri) == Constantes.GEOCODE_CACHE) 
			{
				rowId = db.insert(Constantes.GEOCODE_CACHE_TABLE_NAME, geocode_cache.query, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(geocode_cache.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB geocode_cache", " " + values.get(geocode_cache.query));
			}
			if (sUriMatcher.match(uri) == Constantes.IMAGENPROD) 
			{
				rowId = db.insert(Constantes.IMAGENPROD_TABLE_NAME, imagenprod.producto_id_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(imagenprod.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB imagenprod", " " + values.get(imagenprod.producto_id_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.IMPUESTO) 
			{
				rowId = db.insert(Constantes.IMPUESTO_TABLE_NAME, impuesto.valor_impuesto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(impuesto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB impuesto", " " + values.get(impuesto.valor_impuesto));
			}
			if (sUriMatcher.match(uri) == Constantes.INGRESOSEGRESOS) 
			{
				rowId = db.insert(Constantes.INGRESOSEGRESOS_TABLE_NAME, ingresosegresos.impuestoingreso, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(ingresosegresos.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB ingresosegresos", " " + values.get(ingresosegresos.impuestoingreso));
			}
			if (sUriMatcher.match(uri) == Constantes.ITEM_FACTURA) 
			{
				rowId = db.insert(Constantes.ITEM_FACTURA_TABLE_NAME, item_factura.carro_egresos_id_carro_egresos, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(item_factura.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB item_factura", " " + values.get(item_factura.carro_egresos_id_carro_egresos));
			}
			if (sUriMatcher.match(uri) == Constantes.ITEM_FACTURACOMPLETO) 
			{
				rowId = db.insert(Constantes.ITEM_FACTURACOMPLETO_TABLE_NAME, item_facturacompleto.familia_producto_id_familia_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(item_facturacompleto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB item_facturacompleto", " " + values.get(item_facturacompleto.familia_producto_id_familia_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.MAPA) 
			{
				rowId = db.insert(Constantes.MAPA_TABLE_NAME, mapa.imagen, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(mapa.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB mapa", " " + values.get(mapa.imagen));
			}
			if (sUriMatcher.match(uri) == Constantes.PAIS) 
			{
				rowId = db.insert(Constantes.PAIS_TABLE_NAME, pais.iso_code_number, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(pais.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB pais", " " + values.get(pais.iso_code_number));
			}
			if (sUriMatcher.match(uri) == Constantes.PERSONA) 
			{
				rowId = db.insert(Constantes.PERSONA_TABLE_NAME, persona.telefono, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(persona.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB persona", " " + values.get(persona.telefono));
			}
			if (sUriMatcher.match(uri) == Constantes.PRECIO) 
			{
				rowId = db.insert(Constantes.PRECIO_TABLE_NAME, precio.producto_id_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(precio.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB precio", " " + values.get(precio.producto_id_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.PRODUCTO) 
			{
				rowId = db.insert(Constantes.PRODUCTO_TABLE_NAME, producto.familia_producto_id_familia_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(producto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB producto", " " + values.get(producto.familia_producto_id_familia_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.PRODUCTOCOMPLETO) 
			{
				rowId = db.insert(Constantes.PRODUCTOCOMPLETO_TABLE_NAME, productocompleto.porcentaje_requerimientos, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(productocompleto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB productocompleto", " " + values.get(productocompleto.porcentaje_requerimientos));
			}
			if (sUriMatcher.match(uri) == Constantes.PRODUCTOCOMPRA) 
			{
				rowId = db.insert(Constantes.PRODUCTOCOMPRA_TABLE_NAME, productocompra.porcentaje_requerimientos, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(productocompra.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB productocompra", " " + values.get(productocompra.porcentaje_requerimientos));
			}
			if (sUriMatcher.match(uri) == Constantes.PRODUCTOPRECIO) 
			{
				rowId = db.insert(Constantes.PRODUCTOPRECIO_TABLE_NAME, productoprecio.empresa_id_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(productoprecio.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB productoprecio", " " + values.get(productoprecio.empresa_id_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.PROVINCIA) 
			{
				rowId = db.insert(Constantes.PROVINCIA_TABLE_NAME, provincia.region_id_region, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(provincia.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB provincia", " " + values.get(provincia.region_id_region));
			}
			if (sUriMatcher.match(uri) == Constantes.RECICLADO) 
			{
				rowId = db.insert(Constantes.RECICLADO_TABLE_NAME, reciclado.producto_id_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(reciclado.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB reciclado", " " + values.get(reciclado.producto_id_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.REGION) 
			{
				rowId = db.insert(Constantes.REGION_TABLE_NAME, region.pais_id_pais, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(region.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB region", " " + values.get(region.pais_id_pais));
			}
			if (sUriMatcher.match(uri) == Constantes.RUBRO) 
			{
				rowId = db.insert(Constantes.RUBRO_TABLE_NAME, rubro.nombre_rubro, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(rubro.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB rubro", " " + values.get(rubro.nombre_rubro));
			}
			if (sUriMatcher.match(uri) == Constantes.SINCRODATE) 
			{
				rowId = db.insert(Constantes.SINCRODATE_TABLE_NAME, sincrodate.date, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(sincrodate.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB sincrodate", " " + values.get(sincrodate.date));
			}
			if (sUriMatcher.match(uri) == Constantes.STOCK) 
			{
				rowId = db.insert(Constantes.STOCK_TABLE_NAME, stock.empresa_id_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(stock.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB stock", " " + values.get(stock.empresa_id_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.STOCKCOMPLETO) 
			{
				rowId = db.insert(Constantes.STOCKCOMPLETO_TABLE_NAME, stockcompleto.empresa_id_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(stockcompleto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB stockcompleto", " " + values.get(stockcompleto.empresa_id_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.SUBCATEGORIA) 
			{
				rowId = db.insert(Constantes.SUBCATEGORIA_TABLE_NAME, subcategoria.categoria_id_categoria, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(subcategoria.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB subcategoria", " " + values.get(subcategoria.categoria_id_categoria));
			}
			if (sUriMatcher.match(uri) == Constantes.SUBRUBRO) 
			{
				rowId = db.insert(Constantes.SUBRUBRO_TABLE_NAME, subrubro.rubro_id_rubro, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(subrubro.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB subrubro", " " + values.get(subrubro.rubro_id_rubro));
			}
			if (sUriMatcher.match(uri) == Constantes.TALLA) 
			{
				rowId = db.insert(Constantes.TALLA_TABLE_NAME, talla.producto_id_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(talla.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB talla", " " + values.get(talla.producto_id_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.TIPO_DOCUMENTO) 
			{
				rowId = db.insert(Constantes.TIPO_DOCUMENTO_TABLE_NAME, tipo_documento.nombre_tipo_documento, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(tipo_documento.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB tipo_documento", " " + values.get(tipo_documento.nombre_tipo_documento));
			}
			if (sUriMatcher.match(uri) == Constantes.TIPO_EMPRESA) 
			{
				rowId = db.insert(Constantes.TIPO_EMPRESA_TABLE_NAME, tipo_empresa.categoria_empresa_id_categoria_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(tipo_empresa.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB tipo_empresa", " " + values.get(tipo_empresa.categoria_empresa_id_categoria_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.TIPO_PAGO) 
			{
				rowId = db.insert(Constantes.TIPO_PAGO_TABLE_NAME, tipo_pago.comision_tipo_pago, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(tipo_pago.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB tipo_pago", " " + values.get(tipo_pago.comision_tipo_pago));
			}
			if (sUriMatcher.match(uri) == Constantes.TIPO_PRODUCTO) 
			{
				rowId = db.insert(Constantes.TIPO_PRODUCTO_TABLE_NAME, tipo_producto.nombre_tipo_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(tipo_producto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB tipo_producto", " " + values.get(tipo_producto.nombre_tipo_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.TIPO_USUARIO) 
			{
				rowId = db.insert(Constantes.TIPO_USUARIO_TABLE_NAME, tipo_usuario.nombre_tipo_usuario, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(tipo_usuario.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB tipo_usuario", " " + values.get(tipo_usuario.nombre_tipo_usuario));
			}
			if (sUriMatcher.match(uri) == Constantes.UBICACION) 
			{
				rowId = db.insert(Constantes.UBICACION_TABLE_NAME, ubicacion.usuario_id_usuario, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(ubicacion.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB ubicacion", " " + values.get(ubicacion.usuario_id_usuario));
			}
			if (sUriMatcher.match(uri) == Constantes.USUARIO) 
			{
				rowId = db.insert(Constantes.USUARIO_TABLE_NAME, usuario.cliente_empresa_id_cliente_empresa, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(usuario.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB usuario", " " + values.get(usuario.cliente_empresa_id_cliente_empresa));
			}
			if (sUriMatcher.match(uri) == Constantes.USUARIOCOMPLETO) 
			{
				rowId = db.insert(Constantes.USUARIOCOMPLETO_TABLE_NAME, usuariocompleto.tipo_usuario_id_tipo_usuario, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(usuariocompleto.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB usuariocompleto", " " + values.get(usuariocompleto.tipo_usuario_id_tipo_usuario));
			}
			if (sUriMatcher.match(uri) == Constantes.VALOR_NUTRICIONAL) 
			{
				rowId = db.insert(Constantes.VALOR_NUTRICIONAL_TABLE_NAME, valor_nutricional.producto_id_producto, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(valor_nutricional.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB valor_nutricional", " " + values.get(valor_nutricional.producto_id_producto));
			}
			if (sUriMatcher.match(uri) == Constantes.VENTA) 
			{
				rowId = db.insert(Constantes.VENTA_TABLE_NAME, venta.tipo_documento_id_tipo_documento, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(venta.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB venta", " " + values.get(venta.tipo_documento_id_tipo_documento));
			}
			if (sUriMatcher.match(uri) == Constantes.VENTACOMPLETA) 
			{
				rowId = db.insert(Constantes.VENTACOMPLETA_TABLE_NAME, ventacompleta.nombre_tipo_documento, values);
				db.close();
				if (rowId > 0) {
					uriReturn = ContentUris.withAppendedId(ventacompleta.CONTENT_URI, rowId);
					context.getContentResolver().notifyChange(uri, null);
					return uriReturn;
				}
				Log.e("Insert DB ventacompleta", " " + values.get(ventacompleta.nombre_tipo_documento));
			}
		db.close();
		if(sUriMatcher.match(uri) == UriMatcher.NO_MATCH)
		{
			throw new SQLException("Failed to insert row into " + uri);
		}
		else
		{
			return uriReturn;
		}
	}
	static 
	{
		sUriMatcher = Uris.Creauri();
		Log.e("sUriMatcher ", "STATIC Creauri");
	}
}
