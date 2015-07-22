
package cl.webinc.benderand.util;

import android.content.UriMatcher;
import android.util.Log;


public class Uris 
{
	
	public static UriMatcher Creauri()
	{

					UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
sUriMatcher.addURI(Constantes.AUTHORITY, "actividad", Constantes.ACTIVIDAD);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "actividad/#", Constantes.ACTIVIDAD_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "calle", Constantes.CALLE);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "calle/#", Constantes.CALLE_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "caracteristica", Constantes.CARACTERISTICA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "caracteristica/#", Constantes.CARACTERISTICA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carne_empresa", Constantes.CARNE_EMPRESA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carne_empresa/#", Constantes.CARNE_EMPRESA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carne_empresacompleto", Constantes.CARNE_EMPRESACOMPLETO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carne_empresacompleto/#", Constantes.CARNE_EMPRESACOMPLETO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_compras", Constantes.CARRO_COMPRAS);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_compras/#", Constantes.CARRO_COMPRAS_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_comprascompleto", Constantes.CARRO_COMPRASCOMPLETO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_comprascompleto/#", Constantes.CARRO_COMPRASCOMPLETO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_egresos", Constantes.CARRO_EGRESOS);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_egresos/#", Constantes.CARRO_EGRESOS_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_egresoscompleto", Constantes.CARRO_EGRESOSCOMPLETO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_egresoscompleto/#", Constantes.CARRO_EGRESOSCOMPLETO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_egresosproducto", Constantes.CARRO_EGRESOSPRODUCTO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_egresosproducto/#", Constantes.CARRO_EGRESOSPRODUCTO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_venta", Constantes.CARRO_VENTA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_venta/#", Constantes.CARRO_VENTA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_ventacompleto", Constantes.CARRO_VENTACOMPLETO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "carro_ventacompleto/#", Constantes.CARRO_VENTACOMPLETO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "categoria", Constantes.CATEGORIA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "categoria/#", Constantes.CATEGORIA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "categoria_empresa", Constantes.CATEGORIA_EMPRESA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "categoria_empresa/#", Constantes.CATEGORIA_EMPRESA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "ci_sessions", Constantes.CI_SESSIONS);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "ci_sessions/#", Constantes.CI_SESSIONS_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "cliente", Constantes.CLIENTE);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "cliente/#", Constantes.CLIENTE_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "cliente_empresa", Constantes.CLIENTE_EMPRESA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "cliente_empresa/#", Constantes.CLIENTE_EMPRESA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "compracompleta", Constantes.COMPRACOMPLETA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "compracompleta/#", Constantes.COMPRACOMPLETA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "comuna", Constantes.COMUNA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "comuna/#", Constantes.COMUNA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "contenido_unidad_medida", Constantes.CONTENIDO_UNIDAD_MEDIDA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "contenido_unidad_medida/#", Constantes.CONTENIDO_UNIDAD_MEDIDA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "dia", Constantes.DIA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "dia/#", Constantes.DIA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "empresa", Constantes.EMPRESA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "empresa/#", Constantes.EMPRESA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "envio", Constantes.ENVIO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "envio/#", Constantes.ENVIO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "factura", Constantes.FACTURA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "factura/#", Constantes.FACTURA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "familia_necesidad", Constantes.FAMILIA_NECESIDAD);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "familia_necesidad/#", Constantes.FAMILIA_NECESIDAD_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "familia_producto", Constantes.FAMILIA_PRODUCTO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "familia_producto/#", Constantes.FAMILIA_PRODUCTO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "formato_producto", Constantes.FORMATO_PRODUCTO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "formato_producto/#", Constantes.FORMATO_PRODUCTO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "gasto", Constantes.GASTO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "gasto/#", Constantes.GASTO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "geocode_cache", Constantes.GEOCODE_CACHE);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "geocode_cache/#", Constantes.GEOCODE_CACHE_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "imagenprod", Constantes.IMAGENPROD);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "imagenprod/#", Constantes.IMAGENPROD_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "impuesto", Constantes.IMPUESTO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "impuesto/#", Constantes.IMPUESTO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "ingresosegresos", Constantes.INGRESOSEGRESOS);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "ingresosegresos/#", Constantes.INGRESOSEGRESOS_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "item_factura", Constantes.ITEM_FACTURA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "item_factura/#", Constantes.ITEM_FACTURA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "item_facturacompleto", Constantes.ITEM_FACTURACOMPLETO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "item_facturacompleto/#", Constantes.ITEM_FACTURACOMPLETO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "mapa", Constantes.MAPA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "mapa/#", Constantes.MAPA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "pais", Constantes.PAIS);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "pais/#", Constantes.PAIS_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "persona", Constantes.PERSONA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "persona/#", Constantes.PERSONA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "precio", Constantes.PRECIO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "precio/#", Constantes.PRECIO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "producto", Constantes.PRODUCTO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "producto/#", Constantes.PRODUCTO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "productocompleto", Constantes.PRODUCTOCOMPLETO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "productocompleto/#", Constantes.PRODUCTOCOMPLETO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "productocompra", Constantes.PRODUCTOCOMPRA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "productocompra/#", Constantes.PRODUCTOCOMPRA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "productoprecio", Constantes.PRODUCTOPRECIO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "productoprecio/#", Constantes.PRODUCTOPRECIO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "provincia", Constantes.PROVINCIA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "provincia/#", Constantes.PROVINCIA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "reciclado", Constantes.RECICLADO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "reciclado/#", Constantes.RECICLADO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "region", Constantes.REGION);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "region/#", Constantes.REGION_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "rubro", Constantes.RUBRO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "rubro/#", Constantes.RUBRO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "sincrodate", Constantes.SINCRODATE);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "sincrodate/#", Constantes.SINCRODATE_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "stock", Constantes.STOCK);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "stock/#", Constantes.STOCK_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "stockcompleto", Constantes.STOCKCOMPLETO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "stockcompleto/#", Constantes.STOCKCOMPLETO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "subcategoria", Constantes.SUBCATEGORIA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "subcategoria/#", Constantes.SUBCATEGORIA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "subrubro", Constantes.SUBRUBRO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "subrubro/#", Constantes.SUBRUBRO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "talla", Constantes.TALLA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "talla/#", Constantes.TALLA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_documento", Constantes.TIPO_DOCUMENTO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_documento/#", Constantes.TIPO_DOCUMENTO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_empresa", Constantes.TIPO_EMPRESA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_empresa/#", Constantes.TIPO_EMPRESA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_pago", Constantes.TIPO_PAGO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_pago/#", Constantes.TIPO_PAGO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_producto", Constantes.TIPO_PRODUCTO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_producto/#", Constantes.TIPO_PRODUCTO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_usuario", Constantes.TIPO_USUARIO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "tipo_usuario/#", Constantes.TIPO_USUARIO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "ubicacion", Constantes.UBICACION);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "ubicacion/#", Constantes.UBICACION_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "usuario", Constantes.USUARIO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "usuario/#", Constantes.USUARIO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "usuariocompleto", Constantes.USUARIOCOMPLETO);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "usuariocompleto/#", Constantes.USUARIOCOMPLETO_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "valor_nutricional", Constantes.VALOR_NUTRICIONAL);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "valor_nutricional/#", Constantes.VALOR_NUTRICIONAL_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "venta", Constantes.VENTA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "venta/#", Constantes.VENTA_ID);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "ventacompleta", Constantes.VENTACOMPLETA);
			
sUriMatcher.addURI(Constantes.AUTHORITY, "ventacompleta/#", Constantes.VENTACOMPLETA_ID);
			
 
		Log.e("Uris", "created ");
		return sUriMatcher;	
	}
}
