/*package cl.webinc.benderand.movidos;

import java.util.HashMap;

import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import cl.webinc.benderand.provider.Query;
import cl.webinc.benderand.provider.base.*;

public class CursorDbbkp 
{
	private static final String PRODUCTO_TABLE_NAME = "producto";
    private static final String CARACTERISTICA_TABLE_NAME = "caracteristica";
    private static final String CARRO_COMPRAS_TABLE_NAME = "carro_compras";
    private static final String CARRO_VENTA_TABLE_NAME = "carro_venta";
    private static final String CATEGORIA_TABLE_NAME = "categoria";
    private static final String CLIENTE_TABLE_NAME = "cliente";
    private static final String COMUNA_TABLE_NAME = "comuna";
    private static final String EMPRESA_TABLE_NAME = "empresa";
    private static final String ENVIO_TABLE_NAME = "envio";
    private static final String FACTURA_TABLE_NAME = "factura";
    private static final String GASTO_TABLE_NAME = "gasto";
    private static final String ITEM_FACTURA_TABLE_NAME = "item_factura";
    private static final String PRECIO_TABLE_NAME = "precio";
    private static final String STOCK_TABLE_NAME = "stock";
    private static final String SUBCATEGORIA_TABLE_NAME = "subcategoria";
    private static final String TALLA_TABLE_NAME = "talla";
    private static final String USUARIO_TABLE_NAME = "usuario";
    private static final String VALOR_NUTRICIONAL_TABLE_NAME = "valor_nutricional";
    private static final String VENTA_TABLE_NAME = "venta";
    private static UriMatcher sUriMatcher;
	private static HashMap<String, String> sProductosProjectionMap;
	private static HashMap<String, String> sCaracteristicaProjectionMap;
	private static HashMap<String, String> sCarro_comprasProjectionMap;
	private static HashMap<String, String> sCarro_ventaProjectionMap;
	private static HashMap<String, String> sCategoriaProjectionMap;
	private static HashMap<String, String> sClienteProjectionMap;
	private static HashMap<String, String> sComunaProjectionMap;
	private static HashMap<String, String> sEmpresaProjectionMap;
	private static HashMap<String, String> sEnvioProjectionMap;
	private static HashMap<String, String> sFacturaProjectionMap;
	private static HashMap<String, String> sGastoProjectionMap;
	private static HashMap<String, String> sItem_facturaProjectionMap;
	private static HashMap<String, String> sPrecioProjectionMap;
	private static HashMap<String, String> sStockProjectionMap;
	private static HashMap<String, String> sSubcategoriaProjectionMap;
	private static HashMap<String, String> sTallaProjectionMap;
	private static HashMap<String, String> sUsuarioProjectionMap;
	private static HashMap<String, String> sValor_nutricionalProjectionMap;
	private static HashMap<String, String> sVentaProjectionMap;
    private DBHelper mOpenHelper;
    

    private static final int PRODUCTOS = 1;
    private static final int PROD_ID = 2;
    private static final int PROD_SERIAL = 4;
    private static final int SERIAL = 5;
    private static final int CARACTERISTICA = 6;
    private static final int CARRO_COMPRAS = 7;
    private static final int CARRO_VENTA = 8;
    private static final int CATEGORIA = 9;
    private static final int CLIENTE = 10;
    private static final int COMUNA = 12;
    private static final int EMPRESA = 13;
    private static final int ENVIO = 14;
    private static final int FACTURA = 15;
    private static final int GASTO = 44;
    private static final int ITEM_FACTURA = 16;
    private static final int PRECIO = 17;
    private static final int STOCK = 19;
    private static final int SUBCATEGORIA = 20;
    private static final int TALLA = 21;
    private static final int USUARIO = 22;
    private static final int VALOR_NUTRICIONAL = 23;
    private static final int VENTA = 24;
    private static final int GASTO_ID = 45;
    private static final int ID_CARACT = 25;
    private static final int ID_CARRO = 26;
    private static final int ID_CARVENTA = 27;
    private static final int ID_CATEGORIA = 28;
    private static final int ID_CLIENTE = 29;
    private static final int ID_EMPRE = 30;
    private static final int ID_ENVIO = 31;
    private static final int ID_FACTURA = 32;
    private static final int ID_ITEMFACTURA = 33;
    private static final int ID_PRECIO = 34;
    private static final int ID_STOCK = 36;
    private static final int ID_SUBCAT = 37;
    private static final int ID_TALLA = 38;
    private static final int ID_USUARIO = 39;
    private static final int ID_VAL_NUTRI = 40;
    private static final int ID_VENTA = 41;
    private static final int ID_COMUNA = 42;
    private static final int PRODUCTOS2 = 43;
    private static final int PRODUCTOS2_ID = 48;
    private  Cursor c;
    private int flag;
    
    public Cursor cursor(Uri uri, String[] projection, String selection, String[] selectionArgs,
            String sortOrder, Context context)
    {
    	flag = 0;
        mOpenHelper = DBHelper.getinstance(context);
    	sUriMatcher = Uris.Creauri();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
	    SQLiteDatabase db = mOpenHelper.getReadableDatabase();
	    Log.e("CursorDb", "QUERY... match " + uri + " " + sUriMatcher.match(uri));
	
	    switch (sUriMatcher.match(uri)) {
	    case PRODUCTOS:
		    qb.setTables(PRODUCTO_TABLE_NAME);
	        qb.setProjectionMap(sProductosProjectionMap);
	    	Log.e("CursorDb", "prodprecio............."+ uri.getLastPathSegment());
	        Log.e("CursorDb", "PROD_ID............."+ uri.getLastPathSegment());
	        break;
	
	    case PROD_ID:
		    qb.setTables(PRODUCTO_TABLE_NAME);
	        qb.setProjectionMap(sProductosProjectionMap);
	        Log.e("CursorDb", "PROD_ID............."+ uri.getLastPathSegment());
	        qb.appendWhere(productos.id_prod + "=" + uri.getLastPathSegment());
	        break;
	        
	    case CARACTERISTICA:
		    qb.setTables(CARACTERISTICA_TABLE_NAME);
	    	qb.setProjectionMap(sCaracteristicaProjectionMap);
	    	Log.e("CursorDb", "Caracteristica............."+ uri.getLastPathSegment());
	    	break;
    	case ID_CARACT:
		    qb.setTables(CARACTERISTICA_TABLE_NAME);
	    	Log.e("CursorDb", "ID_CARACT............."+ uri.getLastPathSegment());
	    	qb.appendWhere(caracteristica.id_caract + "=" + uri.getLastPathSegment());
	    	break;
    	case ID_CARRO:
		    qb.setTables(CARRO_COMPRAS_TABLE_NAME);
	    	qb.setProjectionMap(sCarro_comprasProjectionMap);
	    	Log.e("CursorDb", "ID_CARRO............."+ uri.getLastPathSegment());
	    	qb.appendWhere(carro_compras.id_carro + "=" + uri.getLastPathSegment());
	    	break;
    	case CARRO_VENTA:
		    qb.setTables(CARRO_VENTA_TABLE_NAME);
	    	qb.setProjectionMap(sCarro_ventaProjectionMap);
	    	Log.e("CursorDb", "Carro_venta............."+ uri.getLastPathSegment());
	    	break;
    	case ID_CARVENTA:
		    qb.setTables(CARRO_VENTA_TABLE_NAME);
	    	qb.setProjectionMap(sCarro_ventaProjectionMap);
	    	Log.e("CursorDb", "ID_CARVENTA............."+ uri.getLastPathSegment());
	    	qb.appendWhere(carro_venta.id_carventa + "=" + uri.getLastPathSegment());
	    	break;
    	case CATEGORIA:
		    qb.setTables(CATEGORIA_TABLE_NAME);
	    	qb.setProjectionMap(sCategoriaProjectionMap);
	    	Log.e("CursorDb", "Categoria............."+ uri.getLastPathSegment());
	    	break;
    	case ID_CATEGORIA:
		    qb.setTables(CATEGORIA_TABLE_NAME);
	    	qb.setProjectionMap(sCategoriaProjectionMap);
	    	Log.e("CursorDb", "ID_CATEGORIA............."+ uri.getLastPathSegment());
	    	qb.appendWhere(categoria.id_categoria + "=" + uri.getLastPathSegment());
	    	break;
    	case CLIENTE:
		    qb.setTables(CLIENTE_TABLE_NAME);
	    	qb.setProjectionMap(sClienteProjectionMap);
	    	Log.e("CursorDb", "Cliente............."+ uri.getLastPathSegment());
	    	break;
    	case ID_CLIENTE:
		    qb.setTables(CLIENTE_TABLE_NAME);
	    	qb.setProjectionMap(sClienteProjectionMap);
	    	Log.e("CursorDb", "ID_CLIENTE............."+ uri.getLastPathSegment());
	    	qb.appendWhere(cliente.id_cliente + "=" + uri.getLastPathSegment());
	    	break;
    	case COMUNA:
		    qb.setTables(COMUNA_TABLE_NAME);
	    	qb.setProjectionMap(sComunaProjectionMap);
	    	Log.e("CursorDb", "Comuna............."+ uri.getLastPathSegment());
	    	break;
    	case ID_COMUNA:
		    qb.setTables(COMUNA_TABLE_NAME);
	    	qb.setProjectionMap(sComunaProjectionMap);
	    	Log.e("CursorDb", "Comuna............."+ uri.getLastPathSegment());
	    	break;
    	case EMPRESA:
		    qb.setTables(EMPRESA_TABLE_NAME);
	    	qb.setProjectionMap(sEmpresaProjectionMap);
	    	Log.e("CursorDb", "Empresa............."+ uri.getLastPathSegment());
	    	sortOrder = empresa.DEFAULT_ORDEN;
	    	break;
    	case ID_EMPRE:
		    qb.setTables(EMPRESA_TABLE_NAME);
	    	qb.setProjectionMap(sEmpresaProjectionMap);
	    	Log.e("CursorDb", "ID_EMPRE............."+ uri.getLastPathSegment());
	    	qb.appendWhere(empresa.id_empre + "=" + uri.getLastPathSegment());
	    	sortOrder = empresa.DEFAULT_ORDEN;
	    	break;
    	case ENVIO:
		    qb.setTables(ENVIO_TABLE_NAME);
	    	qb.setProjectionMap(sEnvioProjectionMap);
	    	Log.e("CursorDb", "Envio............."+ uri.getLastPathSegment());
	    	break;
    	case ID_ENVIO:
		    qb.setTables(ENVIO_TABLE_NAME);
	    	qb.setProjectionMap(sProductosProjectionMap);
	    	Log.e("CursorDb", "ID_ENVIO............."+ uri.getLastPathSegment());
	    	qb.appendWhere(envio.id_envio + "=" + uri.getLastPathSegment());
	    	break;
    	case FACTURA:
		    qb.setTables(FACTURA_TABLE_NAME);
	    	qb.setProjectionMap(sFacturaProjectionMap);
	    	Log.e("CursorDb", "Factura............."+ uri.getLastPathSegment());
	    	break;
    	case ID_FACTURA:
		    qb.setTables(FACTURA_TABLE_NAME);
	    	qb.setProjectionMap(sProductosProjectionMap);
	    	Log.e("CursorDb", "ID_FACTURA............."+ uri.getLastPathSegment());
	    	qb.appendWhere(factura.id_factura + "=" + uri.getLastPathSegment());
	    	break;
    	case GASTO:
		    qb.setTables(GASTO_TABLE_NAME);
	    	qb.setProjectionMap(sGastoProjectionMap);
	    	Log.e("CursorDb", "Gasto............."+ uri.getLastPathSegment());
	    	break;
    	case GASTO_ID:
		    qb.setTables(GASTO_TABLE_NAME);
	    	qb.setProjectionMap(sGastoProjectionMap);
	    	Log.e("CursorDb", "Gasto............."+ uri.getLastPathSegment());
	    	break;
    	case ITEM_FACTURA:
		    qb.setTables(ITEM_FACTURA_TABLE_NAME);
	    	qb.setProjectionMap(sItem_facturaProjectionMap);
	    	Log.e("CursorDb", "Item_factura............."+ uri.getLastPathSegment());
	    	break;
    	case ID_ITEMFACTURA:
		    qb.setTables(ITEM_FACTURA_TABLE_NAME);
	    	qb.setProjectionMap(sItem_facturaProjectionMap);
	    	Log.e("CursorDb", "ID_ITEMFACTURA............."+ uri.getLastPathSegment());
	    	qb.appendWhere(item_factura.id_itemfactura + "=" + uri.getLastPathSegment());
	    	break;
    	case PRECIO:
		    qb.setTables(PRECIO_TABLE_NAME);
	    	qb.setProjectionMap(sPrecioProjectionMap);
	    	Log.e("CursorDb", "Precio............."+ uri.getLastPathSegment());
	    	break;
    	case ID_PRECIO:
		    qb.setTables(PRECIO_TABLE_NAME);
	    	qb.setProjectionMap(sPrecioProjectionMap);
	    	Log.e("CursorDb", "ID_PRECIO............."+ uri.getLastPathSegment());
	    	qb.appendWhere(precio.id_precio + "=" + uri.getLastPathSegment());
	    	break;
    	case STOCK:
		    qb.setTables(STOCK_TABLE_NAME);
	    	qb.setProjectionMap(sStockProjectionMap);
	    	Log.e("CursorDb", "Stock............."+ uri.getLastPathSegment());
	    	break;
    	case ID_STOCK:
		    qb.setTables(STOCK_TABLE_NAME);
	    	qb.setProjectionMap(sStockProjectionMap);
	    	Log.e("CursorDb", "ID_STOCK............."+ uri.getLastPathSegment());
	    	qb.appendWhere(stock.id_stock + "=" + uri.getLastPathSegment());
	    	break;
    	case SUBCATEGORIA:
		    qb.setTables(SUBCATEGORIA_TABLE_NAME);
	    	qb.setProjectionMap(sSubcategoriaProjectionMap);
	    	Log.e("CursorDb", "Subcategoria............."+ uri.getLastPathSegment());
	    	break;
    	case ID_SUBCAT:
		    qb.setTables(SUBCATEGORIA_TABLE_NAME);
	    	qb.setProjectionMap(sSubcategoriaProjectionMap);
	    	Log.e("CursorDb", "ID_SUBCAT............."+ uri.getLastPathSegment());
	    	qb.appendWhere(subcategoria.id_subcat + "=" + uri.getLastPathSegment());
	    	break;
    	case TALLA:
		    qb.setTables(TALLA_TABLE_NAME);
	    	qb.setProjectionMap(sTallaProjectionMap);
	    	Log.e("CursorDb", "Talla............."+ uri.getLastPathSegment());
	    	break;
    	case ID_TALLA:
		    qb.setTables(TALLA_TABLE_NAME);
	    	qb.setProjectionMap(sTallaProjectionMap);
	    	Log.e("CursorDb", "ID_TALLA............."+ uri.getLastPathSegment());
	    	qb.appendWhere(talla.id_talla + "=" + uri.getLastPathSegment());
	    	break;
    	case USUARIO:
		    qb.setTables(USUARIO_TABLE_NAME);
	    	qb.setProjectionMap(sUsuarioProjectionMap);
	    	Log.e("CursorDb", "Usuario............."+ uri.getLastPathSegment());
	    	break;
    	case ID_USUARIO:
		    qb.setTables(USUARIO_TABLE_NAME);
	    	qb.setProjectionMap(sUsuarioProjectionMap);
	    	Log.e("CursorDb", "ID_USUARIO............."+ uri.getLastPathSegment());
	    	qb.appendWhere(carne.id_usuario + "=" + uri.getLastPathSegment());
	    	sortOrder = carne.DEFAULT_ORDEN;
	    	break;
    	case VALOR_NUTRICIONAL:
		    qb.setTables(VALOR_NUTRICIONAL_TABLE_NAME);
	    	qb.setProjectionMap(sValor_nutricionalProjectionMap);
	    	Log.e("CursorDb", "Valor_nutricional............."+ uri.getLastPathSegment());
	    	break;
    	case ID_VAL_NUTRI:
		    qb.setTables(VALOR_NUTRICIONAL_TABLE_NAME);
	    	qb.setProjectionMap(sValor_nutricionalProjectionMap);
	    	Log.e("CursorDb", "ID_VAL_NUTRI............."+ uri.getLastPathSegment());
	    	qb.appendWhere(valor_nutricional.id_val_nutri + "=" + uri.getLastPathSegment());
	    	break;
    	case VENTA:
		    qb.setTables(VENTA_TABLE_NAME);
	    	qb.setProjectionMap(sVentaProjectionMap);
	    	Log.e("CursorDb", "Venta............."+ uri.getLastPathSegment());
	    	break;
    	case ID_VENTA:
		    qb.setTables(VENTA_TABLE_NAME);
	    	qb.setProjectionMap(sVentaProjectionMap);
	    	Log.e("CursorDb", "ID_VENTA............."+ uri.getLastPathSegment());
	    	qb.appendWhere(venta.id_venta + "=" + uri.getLastPathSegment());
	    	break;
	
	
	    default:
			UriMatcher matcher = Query.Creaurilocal();
			if(matcher.match(uri)!= UriMatcher.NO_MATCH)
			{
				flag = 1;
				c = Query.matcher(uri, context);
			}
			else
			{
				throw new IllegalArgumentException("Unknown URI " + uri);
			}
	    }
	
	    // If no sort order is specified use the default
	    String orderBy;
	    if (TextUtils.isEmpty(sortOrder)) {
	        orderBy = base.productos.DEFAULT_ORDEN;
	    } else {
	        orderBy = sortOrder;
	    }
	    if(flag == 0) 
	    {
		    // Get the database and run the query
		    c = qb.query(db, projection, selection, selectionArgs, null, null, orderBy);
		    Log.e("CursorDb", "SERIAL............."+ selectionArgs + selection);
	    }
	    flag = 0;
	    // Tell the cursor what uri to watch, so it knows when its source data changes
	    c.setNotificationUri(context.getContentResolver(), uri);
	    return c;
    }
}
*/