
package cl.webinc.benderand.provider;

import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import cl.webinc.benderand.datos.Database;
import cl.webinc.benderand.provider.Base.*;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.util.Uris;

public class CursorDB {
	private Cursor c;
	private int flag;
	private Database mOpenHelper;
	private static UriMatcher sUriMatcher;

	public Cursor cursor(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder, Context context) {

		flag = 0;
		mOpenHelper = Database.getinstance(context);
		sUriMatcher = Uris.Creauri();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		Log.e("CursorDb", "QUERY... match " + uri + " " + sUriMatcher.match(uri));
		
			switch (sUriMatcher.match(uri)) 
			{
				case Constantes.ACTIVIDAD: 
					qb.setTables(Constantes.ACTIVIDAD_TABLE_NAME);
					qb.setProjectionMap(Constantes.sActividadProjectionMap);
					Log.e("CursorDb", "ACTIVIDAD............."+ uri.getLastPathSegment());
					break;
				case Constantes.ACTIVIDAD_ID: 
					qb.setTables(Constantes.ACTIVIDAD_TABLE_NAME);
					qb.setProjectionMap(Constantes.sActividadProjectionMap);
					qb.appendWhere(actividad._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "ACTIVIDAD............."+ uri.getLastPathSegment());
					break;
				case Constantes.CALLE: 
					qb.setTables(Constantes.CALLE_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCalleProjectionMap);
					Log.e("CursorDb", "CALLE............."+ uri.getLastPathSegment());
					break;
				case Constantes.CALLE_ID: 
					qb.setTables(Constantes.CALLE_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCalleProjectionMap);
					qb.appendWhere(calle._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CALLE............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARACTERISTICA: 
					qb.setTables(Constantes.CARACTERISTICA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCaracteristicaProjectionMap);
					Log.e("CursorDb", "CARACTERISTICA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARACTERISTICA_ID: 
					qb.setTables(Constantes.CARACTERISTICA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCaracteristicaProjectionMap);
					qb.appendWhere(caracteristica._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARACTERISTICA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARNE_EMPRESA: 
					qb.setTables(Constantes.CARNE_EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarne_empresaProjectionMap);
					Log.e("CursorDb", "CARNE_EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARNE_EMPRESA_ID: 
					qb.setTables(Constantes.CARNE_EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarne_empresaProjectionMap);
					qb.appendWhere(carne_empresa._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARNE_EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARNE_EMPRESACOMPLETO: 
					qb.setTables(Constantes.CARNE_EMPRESACOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarne_empresacompletoProjectionMap);
					Log.e("CursorDb", "CARNE_EMPRESACOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARNE_EMPRESACOMPLETO_ID: 
					qb.setTables(Constantes.CARNE_EMPRESACOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarne_empresacompletoProjectionMap);
					qb.appendWhere(carne_empresacompleto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARNE_EMPRESACOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_COMPRAS: 
					qb.setTables(Constantes.CARRO_COMPRAS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_comprasProjectionMap);
					Log.e("CursorDb", "CARRO_COMPRAS............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_COMPRAS_ID: 
					qb.setTables(Constantes.CARRO_COMPRAS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_comprasProjectionMap);
					qb.appendWhere(carro_compras._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARRO_COMPRAS............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_COMPRASCOMPLETO: 
					qb.setTables(Constantes.CARRO_COMPRASCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_comprascompletoProjectionMap);
					Log.e("CursorDb", "CARRO_COMPRASCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_COMPRASCOMPLETO_ID: 
					qb.setTables(Constantes.CARRO_COMPRASCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_comprascompletoProjectionMap);
					qb.appendWhere(carro_comprascompleto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARRO_COMPRASCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_EGRESOS: 
					qb.setTables(Constantes.CARRO_EGRESOS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_egresosProjectionMap);
					Log.e("CursorDb", "CARRO_EGRESOS............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_EGRESOS_ID: 
					qb.setTables(Constantes.CARRO_EGRESOS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_egresosProjectionMap);
					qb.appendWhere(carro_egresos._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARRO_EGRESOS............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_EGRESOSCOMPLETO: 
					qb.setTables(Constantes.CARRO_EGRESOSCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_egresoscompletoProjectionMap);
					Log.e("CursorDb", "CARRO_EGRESOSCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_EGRESOSCOMPLETO_ID: 
					qb.setTables(Constantes.CARRO_EGRESOSCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_egresoscompletoProjectionMap);
					qb.appendWhere(carro_egresoscompleto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARRO_EGRESOSCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_EGRESOSPRODUCTO: 
					qb.setTables(Constantes.CARRO_EGRESOSPRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_egresosproductoProjectionMap);
					Log.e("CursorDb", "CARRO_EGRESOSPRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_EGRESOSPRODUCTO_ID: 
					qb.setTables(Constantes.CARRO_EGRESOSPRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_egresosproductoProjectionMap);
					qb.appendWhere(carro_egresosproducto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARRO_EGRESOSPRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_VENTA: 
					qb.setTables(Constantes.CARRO_VENTA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_ventaProjectionMap);
					Log.e("CursorDb", "CARRO_VENTA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_VENTA_ID: 
					qb.setTables(Constantes.CARRO_VENTA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_ventaProjectionMap);
					qb.appendWhere(carro_venta._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARRO_VENTA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_VENTACOMPLETO: 
					qb.setTables(Constantes.CARRO_VENTACOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_ventacompletoProjectionMap);
					Log.e("CursorDb", "CARRO_VENTACOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CARRO_VENTACOMPLETO_ID: 
					qb.setTables(Constantes.CARRO_VENTACOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCarro_ventacompletoProjectionMap);
					qb.appendWhere(carro_ventacompleto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CARRO_VENTACOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.CATEGORIA: 
					qb.setTables(Constantes.CATEGORIA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCategoriaProjectionMap);
					Log.e("CursorDb", "CATEGORIA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CATEGORIA_ID: 
					qb.setTables(Constantes.CATEGORIA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCategoriaProjectionMap);
					qb.appendWhere(categoria._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CATEGORIA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CATEGORIA_EMPRESA: 
					qb.setTables(Constantes.CATEGORIA_EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCategoria_empresaProjectionMap);
					Log.e("CursorDb", "CATEGORIA_EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CATEGORIA_EMPRESA_ID: 
					qb.setTables(Constantes.CATEGORIA_EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCategoria_empresaProjectionMap);
					qb.appendWhere(categoria_empresa._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CATEGORIA_EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CI_SESSIONS: 
					qb.setTables(Constantes.CI_SESSIONS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCi_sessionsProjectionMap);
					Log.e("CursorDb", "CI_SESSIONS............."+ uri.getLastPathSegment());
					break;
				case Constantes.CI_SESSIONS_ID: 
					qb.setTables(Constantes.CI_SESSIONS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCi_sessionsProjectionMap);
					qb.appendWhere(ci_sessions._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CI_SESSIONS............."+ uri.getLastPathSegment());
					break;
				case Constantes.CLIENTE: 
					qb.setTables(Constantes.CLIENTE_TABLE_NAME);
					qb.setProjectionMap(Constantes.sClienteProjectionMap);
					Log.e("CursorDb", "CLIENTE............."+ uri.getLastPathSegment());
					break;
				case Constantes.CLIENTE_ID: 
					qb.setTables(Constantes.CLIENTE_TABLE_NAME);
					qb.setProjectionMap(Constantes.sClienteProjectionMap);
					qb.appendWhere(cliente._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CLIENTE............."+ uri.getLastPathSegment());
					break;
				case Constantes.CLIENTE_EMPRESA: 
					qb.setTables(Constantes.CLIENTE_EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCliente_empresaProjectionMap);
					Log.e("CursorDb", "CLIENTE_EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CLIENTE_EMPRESA_ID: 
					qb.setTables(Constantes.CLIENTE_EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCliente_empresaProjectionMap);
					qb.appendWhere(cliente_empresa._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CLIENTE_EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.COMPRACOMPLETA: 
					qb.setTables(Constantes.COMPRACOMPLETA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCompracompletaProjectionMap);
					Log.e("CursorDb", "COMPRACOMPLETA............."+ uri.getLastPathSegment());
					break;
				case Constantes.COMPRACOMPLETA_ID: 
					qb.setTables(Constantes.COMPRACOMPLETA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sCompracompletaProjectionMap);
					qb.appendWhere(compracompleta._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "COMPRACOMPLETA............."+ uri.getLastPathSegment());
					break;
				case Constantes.COMUNA: 
					qb.setTables(Constantes.COMUNA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sComunaProjectionMap);
					Log.e("CursorDb", "COMUNA............."+ uri.getLastPathSegment());
					break;
				case Constantes.COMUNA_ID: 
					qb.setTables(Constantes.COMUNA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sComunaProjectionMap);
					qb.appendWhere(comuna._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "COMUNA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CONTENIDO_UNIDAD_MEDIDA: 
					qb.setTables(Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sContenido_unidad_medidaProjectionMap);
					Log.e("CursorDb", "CONTENIDO_UNIDAD_MEDIDA............."+ uri.getLastPathSegment());
					break;
				case Constantes.CONTENIDO_UNIDAD_MEDIDA_ID: 
					qb.setTables(Constantes.CONTENIDO_UNIDAD_MEDIDA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sContenido_unidad_medidaProjectionMap);
					qb.appendWhere(contenido_unidad_medida._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "CONTENIDO_UNIDAD_MEDIDA............."+ uri.getLastPathSegment());
					break;
				case Constantes.DIA: 
					qb.setTables(Constantes.DIA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sDiaProjectionMap);
					Log.e("CursorDb", "DIA............."+ uri.getLastPathSegment());
					break;
				case Constantes.DIA_ID: 
					qb.setTables(Constantes.DIA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sDiaProjectionMap);
					qb.appendWhere(dia._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "DIA............."+ uri.getLastPathSegment());
					break;
				case Constantes.EMPRESA: 
					qb.setTables(Constantes.EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sEmpresaProjectionMap);
					Log.e("CursorDb", "EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.EMPRESA_ID: 
					qb.setTables(Constantes.EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sEmpresaProjectionMap);
					qb.appendWhere(empresa._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.ENVIO: 
					qb.setTables(Constantes.ENVIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sEnvioProjectionMap);
					Log.e("CursorDb", "ENVIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.ENVIO_ID: 
					qb.setTables(Constantes.ENVIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sEnvioProjectionMap);
					qb.appendWhere(envio._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "ENVIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.FACTURA: 
					qb.setTables(Constantes.FACTURA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sFacturaProjectionMap);
					Log.e("CursorDb", "FACTURA............."+ uri.getLastPathSegment());
					break;
				case Constantes.FACTURA_ID: 
					qb.setTables(Constantes.FACTURA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sFacturaProjectionMap);
					qb.appendWhere(factura._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "FACTURA............."+ uri.getLastPathSegment());
					break;
				case Constantes.FAMILIA_NECESIDAD: 
					qb.setTables(Constantes.FAMILIA_NECESIDAD_TABLE_NAME);
					qb.setProjectionMap(Constantes.sFamilia_necesidadProjectionMap);
					Log.e("CursorDb", "FAMILIA_NECESIDAD............."+ uri.getLastPathSegment());
					break;
				case Constantes.FAMILIA_NECESIDAD_ID: 
					qb.setTables(Constantes.FAMILIA_NECESIDAD_TABLE_NAME);
					qb.setProjectionMap(Constantes.sFamilia_necesidadProjectionMap);
					qb.appendWhere(familia_necesidad._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "FAMILIA_NECESIDAD............."+ uri.getLastPathSegment());
					break;
				case Constantes.FAMILIA_PRODUCTO: 
					qb.setTables(Constantes.FAMILIA_PRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sFamilia_productoProjectionMap);
					Log.e("CursorDb", "FAMILIA_PRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.FAMILIA_PRODUCTO_ID: 
					qb.setTables(Constantes.FAMILIA_PRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sFamilia_productoProjectionMap);
					qb.appendWhere(familia_producto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "FAMILIA_PRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.FORMATO_PRODUCTO: 
					qb.setTables(Constantes.FORMATO_PRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sFormato_productoProjectionMap);
					Log.e("CursorDb", "FORMATO_PRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.FORMATO_PRODUCTO_ID: 
					qb.setTables(Constantes.FORMATO_PRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sFormato_productoProjectionMap);
					qb.appendWhere(formato_producto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "FORMATO_PRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.GASTO: 
					qb.setTables(Constantes.GASTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sGastoProjectionMap);
					Log.e("CursorDb", "GASTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.GASTO_ID: 
					qb.setTables(Constantes.GASTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sGastoProjectionMap);
					qb.appendWhere(gasto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "GASTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.GEOCODE_CACHE: 
					qb.setTables(Constantes.GEOCODE_CACHE_TABLE_NAME);
					qb.setProjectionMap(Constantes.sGeocode_cacheProjectionMap);
					Log.e("CursorDb", "GEOCODE_CACHE............."+ uri.getLastPathSegment());
					break;
				case Constantes.GEOCODE_CACHE_ID: 
					qb.setTables(Constantes.GEOCODE_CACHE_TABLE_NAME);
					qb.setProjectionMap(Constantes.sGeocode_cacheProjectionMap);
					qb.appendWhere(geocode_cache._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "GEOCODE_CACHE............."+ uri.getLastPathSegment());
					break;
				case Constantes.IMAGENPROD: 
					qb.setTables(Constantes.IMAGENPROD_TABLE_NAME);
					qb.setProjectionMap(Constantes.sImagenprodProjectionMap);
					Log.e("CursorDb", "IMAGENPROD............."+ uri.getLastPathSegment());
					break;
				case Constantes.IMAGENPROD_ID: 
					qb.setTables(Constantes.IMAGENPROD_TABLE_NAME);
					qb.setProjectionMap(Constantes.sImagenprodProjectionMap);
					qb.appendWhere(imagenprod._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "IMAGENPROD............."+ uri.getLastPathSegment());
					break;
				case Constantes.IMPUESTO: 
					qb.setTables(Constantes.IMPUESTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sImpuestoProjectionMap);
					Log.e("CursorDb", "IMPUESTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.IMPUESTO_ID: 
					qb.setTables(Constantes.IMPUESTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sImpuestoProjectionMap);
					qb.appendWhere(impuesto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "IMPUESTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.INGRESOSEGRESOS: 
					qb.setTables(Constantes.INGRESOSEGRESOS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sIngresosegresosProjectionMap);
					Log.e("CursorDb", "INGRESOSEGRESOS............."+ uri.getLastPathSegment());
					break;
				case Constantes.INGRESOSEGRESOS_ID: 
					qb.setTables(Constantes.INGRESOSEGRESOS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sIngresosegresosProjectionMap);
					qb.appendWhere(ingresosegresos._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "INGRESOSEGRESOS............."+ uri.getLastPathSegment());
					break;
				case Constantes.ITEM_FACTURA: 
					qb.setTables(Constantes.ITEM_FACTURA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sItem_facturaProjectionMap);
					Log.e("CursorDb", "ITEM_FACTURA............."+ uri.getLastPathSegment());
					break;
				case Constantes.ITEM_FACTURA_ID: 
					qb.setTables(Constantes.ITEM_FACTURA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sItem_facturaProjectionMap);
					qb.appendWhere(item_factura._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "ITEM_FACTURA............."+ uri.getLastPathSegment());
					break;
				case Constantes.ITEM_FACTURACOMPLETO: 
					qb.setTables(Constantes.ITEM_FACTURACOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sItem_facturacompletoProjectionMap);
					Log.e("CursorDb", "ITEM_FACTURACOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.ITEM_FACTURACOMPLETO_ID: 
					qb.setTables(Constantes.ITEM_FACTURACOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sItem_facturacompletoProjectionMap);
					qb.appendWhere(item_facturacompleto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "ITEM_FACTURACOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.MAPA: 
					qb.setTables(Constantes.MAPA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sMapaProjectionMap);
					Log.e("CursorDb", "MAPA............."+ uri.getLastPathSegment());
					break;
				case Constantes.MAPA_ID: 
					qb.setTables(Constantes.MAPA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sMapaProjectionMap);
					qb.appendWhere(mapa._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "MAPA............."+ uri.getLastPathSegment());
					break;
				case Constantes.PAIS: 
					qb.setTables(Constantes.PAIS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sPaisProjectionMap);
					Log.e("CursorDb", "PAIS............."+ uri.getLastPathSegment());
					break;
				case Constantes.PAIS_ID: 
					qb.setTables(Constantes.PAIS_TABLE_NAME);
					qb.setProjectionMap(Constantes.sPaisProjectionMap);
					qb.appendWhere(pais._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "PAIS............."+ uri.getLastPathSegment());
					break;
				case Constantes.PERSONA: 
					qb.setTables(Constantes.PERSONA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sPersonaProjectionMap);
					Log.e("CursorDb", "PERSONA............."+ uri.getLastPathSegment());
					break;
				case Constantes.PERSONA_ID: 
					qb.setTables(Constantes.PERSONA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sPersonaProjectionMap);
					qb.appendWhere(persona._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "PERSONA............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRECIO: 
					qb.setTables(Constantes.PRECIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sPrecioProjectionMap);
					Log.e("CursorDb", "PRECIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRECIO_ID: 
					qb.setTables(Constantes.PRECIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sPrecioProjectionMap);
					qb.appendWhere(precio._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "PRECIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRODUCTO: 
					qb.setTables(Constantes.PRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProductoProjectionMap);
					Log.e("CursorDb", "PRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRODUCTO_ID: 
					qb.setTables(Constantes.PRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProductoProjectionMap);
					qb.appendWhere(producto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "PRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRODUCTOCOMPLETO: 
					qb.setTables(Constantes.PRODUCTOCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProductocompletoProjectionMap);
					Log.e("CursorDb", "PRODUCTOCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRODUCTOCOMPLETO_ID: 
					qb.setTables(Constantes.PRODUCTOCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProductocompletoProjectionMap);
					qb.appendWhere(productocompleto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "PRODUCTOCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRODUCTOCOMPRA: 
					qb.setTables(Constantes.PRODUCTOCOMPRA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProductocompraProjectionMap);
					Log.e("CursorDb", "PRODUCTOCOMPRA............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRODUCTOCOMPRA_ID: 
					qb.setTables(Constantes.PRODUCTOCOMPRA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProductocompraProjectionMap);
					qb.appendWhere(productocompra._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "PRODUCTOCOMPRA............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRODUCTOPRECIO: 
					qb.setTables(Constantes.PRODUCTOPRECIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProductoprecioProjectionMap);
					Log.e("CursorDb", "PRODUCTOPRECIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.PRODUCTOPRECIO_ID: 
					qb.setTables(Constantes.PRODUCTOPRECIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProductoprecioProjectionMap);
					qb.appendWhere(productoprecio._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "PRODUCTOPRECIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.PROVINCIA: 
					qb.setTables(Constantes.PROVINCIA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProvinciaProjectionMap);
					Log.e("CursorDb", "PROVINCIA............."+ uri.getLastPathSegment());
					break;
				case Constantes.PROVINCIA_ID: 
					qb.setTables(Constantes.PROVINCIA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sProvinciaProjectionMap);
					qb.appendWhere(provincia._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "PROVINCIA............."+ uri.getLastPathSegment());
					break;
				case Constantes.RECICLADO: 
					qb.setTables(Constantes.RECICLADO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sRecicladoProjectionMap);
					Log.e("CursorDb", "RECICLADO............."+ uri.getLastPathSegment());
					break;
				case Constantes.RECICLADO_ID: 
					qb.setTables(Constantes.RECICLADO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sRecicladoProjectionMap);
					qb.appendWhere(reciclado._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "RECICLADO............."+ uri.getLastPathSegment());
					break;
				case Constantes.REGION: 
					qb.setTables(Constantes.REGION_TABLE_NAME);
					qb.setProjectionMap(Constantes.sRegionProjectionMap);
					Log.e("CursorDb", "REGION............."+ uri.getLastPathSegment());
					break;
				case Constantes.REGION_ID: 
					qb.setTables(Constantes.REGION_TABLE_NAME);
					qb.setProjectionMap(Constantes.sRegionProjectionMap);
					qb.appendWhere(region._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "REGION............."+ uri.getLastPathSegment());
					break;
				case Constantes.RUBRO: 
					qb.setTables(Constantes.RUBRO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sRubroProjectionMap);
					Log.e("CursorDb", "RUBRO............."+ uri.getLastPathSegment());
					break;
				case Constantes.RUBRO_ID: 
					qb.setTables(Constantes.RUBRO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sRubroProjectionMap);
					qb.appendWhere(rubro._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "RUBRO............."+ uri.getLastPathSegment());
					break;
				case Constantes.SINCRODATE: 
					qb.setTables(Constantes.SINCRODATE_TABLE_NAME);
					qb.setProjectionMap(Constantes.sSincrodateProjectionMap);
					Log.e("CursorDb", "SINCRODATE............."+ uri.getLastPathSegment());
					break;
				case Constantes.SINCRODATE_ID: 
					qb.setTables(Constantes.SINCRODATE_TABLE_NAME);
					qb.setProjectionMap(Constantes.sSincrodateProjectionMap);
					qb.appendWhere(sincrodate._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "SINCRODATE............."+ uri.getLastPathSegment());
					break;
				case Constantes.STOCK: 
					qb.setTables(Constantes.STOCK_TABLE_NAME);
					qb.setProjectionMap(Constantes.sStockProjectionMap);
					Log.e("CursorDb", "STOCK............."+ uri.getLastPathSegment());
					break;
				case Constantes.STOCK_ID: 
					qb.setTables(Constantes.STOCK_TABLE_NAME);
					qb.setProjectionMap(Constantes.sStockProjectionMap);
					qb.appendWhere(stock._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "STOCK............."+ uri.getLastPathSegment());
					break;
				case Constantes.STOCKCOMPLETO: 
					qb.setTables(Constantes.STOCKCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sStockcompletoProjectionMap);
					Log.e("CursorDb", "STOCKCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.STOCKCOMPLETO_ID: 
					qb.setTables(Constantes.STOCKCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sStockcompletoProjectionMap);
					qb.appendWhere(stockcompleto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "STOCKCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.SUBCATEGORIA: 
					qb.setTables(Constantes.SUBCATEGORIA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sSubcategoriaProjectionMap);
					Log.e("CursorDb", "SUBCATEGORIA............."+ uri.getLastPathSegment());
					break;
				case Constantes.SUBCATEGORIA_ID: 
					qb.setTables(Constantes.SUBCATEGORIA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sSubcategoriaProjectionMap);
					qb.appendWhere(subcategoria._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "SUBCATEGORIA............."+ uri.getLastPathSegment());
					break;
				case Constantes.SUBRUBRO: 
					qb.setTables(Constantes.SUBRUBRO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sSubrubroProjectionMap);
					Log.e("CursorDb", "SUBRUBRO............."+ uri.getLastPathSegment());
					break;
				case Constantes.SUBRUBRO_ID: 
					qb.setTables(Constantes.SUBRUBRO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sSubrubroProjectionMap);
					qb.appendWhere(subrubro._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "SUBRUBRO............."+ uri.getLastPathSegment());
					break;
				case Constantes.TALLA: 
					qb.setTables(Constantes.TALLA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTallaProjectionMap);
					Log.e("CursorDb", "TALLA............."+ uri.getLastPathSegment());
					break;
				case Constantes.TALLA_ID: 
					qb.setTables(Constantes.TALLA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTallaProjectionMap);
					qb.appendWhere(talla._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "TALLA............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_DOCUMENTO: 
					qb.setTables(Constantes.TIPO_DOCUMENTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_documentoProjectionMap);
					Log.e("CursorDb", "TIPO_DOCUMENTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_DOCUMENTO_ID: 
					qb.setTables(Constantes.TIPO_DOCUMENTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_documentoProjectionMap);
					qb.appendWhere(tipo_documento._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "TIPO_DOCUMENTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_EMPRESA: 
					qb.setTables(Constantes.TIPO_EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_empresaProjectionMap);
					Log.e("CursorDb", "TIPO_EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_EMPRESA_ID: 
					qb.setTables(Constantes.TIPO_EMPRESA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_empresaProjectionMap);
					qb.appendWhere(tipo_empresa._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "TIPO_EMPRESA............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_PAGO: 
					qb.setTables(Constantes.TIPO_PAGO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_pagoProjectionMap);
					Log.e("CursorDb", "TIPO_PAGO............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_PAGO_ID: 
					qb.setTables(Constantes.TIPO_PAGO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_pagoProjectionMap);
					qb.appendWhere(tipo_pago._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "TIPO_PAGO............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_PRODUCTO: 
					qb.setTables(Constantes.TIPO_PRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_productoProjectionMap);
					Log.e("CursorDb", "TIPO_PRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_PRODUCTO_ID: 
					qb.setTables(Constantes.TIPO_PRODUCTO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_productoProjectionMap);
					qb.appendWhere(tipo_producto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "TIPO_PRODUCTO............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_USUARIO: 
					qb.setTables(Constantes.TIPO_USUARIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_usuarioProjectionMap);
					Log.e("CursorDb", "TIPO_USUARIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.TIPO_USUARIO_ID: 
					qb.setTables(Constantes.TIPO_USUARIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sTipo_usuarioProjectionMap);
					qb.appendWhere(tipo_usuario._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "TIPO_USUARIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.UBICACION: 
					qb.setTables(Constantes.UBICACION_TABLE_NAME);
					qb.setProjectionMap(Constantes.sUbicacionProjectionMap);
					Log.e("CursorDb", "UBICACION............."+ uri.getLastPathSegment());
					break;
				case Constantes.UBICACION_ID: 
					qb.setTables(Constantes.UBICACION_TABLE_NAME);
					qb.setProjectionMap(Constantes.sUbicacionProjectionMap);
					qb.appendWhere(ubicacion._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "UBICACION............."+ uri.getLastPathSegment());
					break;
				case Constantes.USUARIO: 
					qb.setTables(Constantes.USUARIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sUsuarioProjectionMap);
					Log.e("CursorDb", "USUARIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.USUARIO_ID: 
					qb.setTables(Constantes.USUARIO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sUsuarioProjectionMap);
					qb.appendWhere(usuario._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "USUARIO............."+ uri.getLastPathSegment());
					break;
				case Constantes.USUARIOCOMPLETO: 
					qb.setTables(Constantes.USUARIOCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sUsuariocompletoProjectionMap);
					Log.e("CursorDb", "USUARIOCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.USUARIOCOMPLETO_ID: 
					qb.setTables(Constantes.USUARIOCOMPLETO_TABLE_NAME);
					qb.setProjectionMap(Constantes.sUsuariocompletoProjectionMap);
					qb.appendWhere(usuariocompleto._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "USUARIOCOMPLETO............."+ uri.getLastPathSegment());
					break;
				case Constantes.VALOR_NUTRICIONAL: 
					qb.setTables(Constantes.VALOR_NUTRICIONAL_TABLE_NAME);
					qb.setProjectionMap(Constantes.sValor_nutricionalProjectionMap);
					Log.e("CursorDb", "VALOR_NUTRICIONAL............."+ uri.getLastPathSegment());
					break;
				case Constantes.VALOR_NUTRICIONAL_ID: 
					qb.setTables(Constantes.VALOR_NUTRICIONAL_TABLE_NAME);
					qb.setProjectionMap(Constantes.sValor_nutricionalProjectionMap);
					qb.appendWhere(valor_nutricional._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "VALOR_NUTRICIONAL............."+ uri.getLastPathSegment());
					break;
				case Constantes.VENTA: 
					qb.setTables(Constantes.VENTA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sVentaProjectionMap);
					Log.e("CursorDb", "VENTA............."+ uri.getLastPathSegment());
					break;
				case Constantes.VENTA_ID: 
					qb.setTables(Constantes.VENTA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sVentaProjectionMap);
					qb.appendWhere(venta._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "VENTA............."+ uri.getLastPathSegment());
					break;
				case Constantes.VENTACOMPLETA: 
					qb.setTables(Constantes.VENTACOMPLETA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sVentacompletaProjectionMap);
					Log.e("CursorDb", "VENTACOMPLETA............."+ uri.getLastPathSegment());
					break;
				case Constantes.VENTACOMPLETA_ID: 
					qb.setTables(Constantes.VENTACOMPLETA_TABLE_NAME);
					qb.setProjectionMap(Constantes.sVentacompletaProjectionMap);
					qb.appendWhere(ventacompleta._ID + "=" + uri.getLastPathSegment());
					Log.e("CursorDb", "VENTACOMPLETA............."+ uri.getLastPathSegment());
					break;

		
		default:
			UriMatcher matcher = Consultas.Creaurilocal();
			if(matcher.match(uri)!= UriMatcher.NO_MATCH)
			{
				flag = 1;
				c = Consultas.matcher(uri, context);
			}
			else
			{
				throw new IllegalArgumentException("Unknown URI " + uri);
			}
		}
		String orderBy;
		if (TextUtils.isEmpty(sortOrder)) {
			orderBy = sortOrder;
		} else {
			orderBy = sortOrder;
		}
		if (flag == 0) {
			Log.e("CursorDb", "argumentos " + selectionArgs + " selection "
					+ selection);
			c = qb.query(db, projection, selection, selectionArgs, null, null,
					orderBy);
			Log.e("CursorDb", "count original " + c.getCount());

			Log.e("CursorDb", "argumentos " + selectionArgs + " selection "
					+ selection);
		}
		flag = 0;
		c.setNotificationUri(context.getContentResolver(), uri);
		return c;
	}
}

			