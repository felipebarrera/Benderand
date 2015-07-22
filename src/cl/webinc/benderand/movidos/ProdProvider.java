/*package cl.webinc.benderand.movidos;

import cl.webinc.benderand.movidos.DBHelper;
import cl.webinc.benderand.provider.base.Caracteristica;
import cl.webinc.benderand.provider.base.carro_compras;
import cl.webinc.benderand.provider.base.Carro_venta;
import cl.webinc.benderand.provider.base.Categoria;
import cl.webinc.benderand.provider.base.Cliente;
import cl.webinc.benderand.provider.base.Comuna;
import cl.webinc.benderand.provider.base.Empresa;
import cl.webinc.benderand.provider.base.Envio;
import cl.webinc.benderand.provider.base.Factura;
import cl.webinc.benderand.provider.base.Gasto;
import cl.webinc.benderand.provider.base.Item_factura;
import cl.webinc.benderand.provider.base.Precio;
import cl.webinc.benderand.provider.base.Stock;
import cl.webinc.benderand.provider.base.Subcategoria;
import cl.webinc.benderand.provider.base.Talla;
import cl.webinc.benderand.provider.base.Usuario;
import cl.webinc.benderand.provider.base.Valor_nutricional;
import cl.webinc.benderand.provider.base.Venta;
import cl.webinc.benderand.provider.base.productos;
import cl.webinc.benderand.util.ProjectionMaper;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.LiveFolders;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;

@SuppressWarnings("unused")
public class ProdProvider extends ContentProvider 
{
    private DBHelper mOpenHelper;
    private static final String TAG = "hello benderProvider";
    private static final ProjectionMaper Mapper = new ProjectionMaper();

    private static final String DATABASE_NAME = "com_ncwebinc_vender_data.db";
    private static final int DATABASE_VERSION = 1;
    private static final String PRODUCTO_TABLE_NAME = "producto";
    private static final String CARRO_COMPRA_TABLE_NAME = "carro_compras";
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

    private static final int PRODUCTOS = 1;
    private static final int PRODUCTO = 18;
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
    private static final int ID_ENVIO = 31;
    private static final int ID_FACTURA = 32;
    private static final int ID_ITEMFACTURA = 33;
    private static final int ID_PRECIO = 34;
    private static final int ID_STOCK = 36;
    private static final int ID_SUBCAT = 37;
    private static final int ID_TALLA = 38;
    private static final int ID_VAL_NUTRI = 40;
    private static final int ID_VENTA = 41;
    private static final int ID_COMUNA = 42;
    private static final int ID_EMPRE = 30;
    private static final int ID_USUARIO = 39;
    private static final int PRODUCTOS2 = 43;
    private static final int PRODUCTOS2_ID = 48;
    private static final int PRECIO_ID = 49;

    private static final UriMatcher sUriMatcher;
    private static final CursorDbbkp cursorDb = new CursorDbbkp();
    private static final Uris uriHelper = new Uris();

    @Override
    public boolean onCreate() {
        mOpenHelper = DBHelper.getinstance(getContext());
        mOpenHelper.getWritableDatabase();
        Log.w(TAG, "ONCREATE.............");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
            String sortOrder) 
    {
    	Cursor c = cursorDb.cursor(uri, projection, selection, selectionArgs, sortOrder, getContext());
        return c;
    }

    @Override
    public String getType(Uri uri) {
        Log.w(TAG, "GETTYPE.............");
        switch (sUriMatcher.match(uri)) {
        case PRODUCTOS:
            return productos.CONTENT_TYPE;
            
        case PRODUCTOS2:
            return productos.CONTENT_TYPE;
            
        case PRODUCTOS2_ID:
            return productos.CONTENT_ITEM_TYPE;

        case PROD_ID:
            return productos.CONTENT_ITEM_TYPE;

        case PRECIO_ID:
            return Precio.CONTENT_ITEM_TYPE;

        case PROD_SERIAL:
            return productos.CONTENT_ITEM_TYPE;

        case GASTO:
            return Gasto.CONTENT_ITEM_TYPE;

        case GASTO_ID:
            return Gasto.CONTENT_ITEM_TYPE;

        case ID_USUARIO:
            return Usuario.CONTENT_ITEM_TYPE;

        case USUARIO:
            return Usuario.CONTENT_ITEM_TYPE;

        case EMPRESA:
            return Usuario.CONTENT_ITEM_TYPE;

        case ID_EMPRE:
            return Usuario.CONTENT_ITEM_TYPE;

        default:
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        Log.w(TAG, "INSERT............." + uri);
        InsertDB insertDB = new InsertDB();
        Uri noteUri = insertDB.insert(uri, initialValues, getContext());
        return noteUri;
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
    	Log.w("data path", "dta" + db.getPath());
        Log.w(TAG, "DELETE............." + sUriMatcher.match(uri));
        int count;
        switch (sUriMatcher.match(uri)) {
        case PRODUCTOS2:
            count = db.delete(PRODUCTO_TABLE_NAME, where, whereArgs);
            break;

        case PRODUCTOS2_ID:
            String prod2Id = uri.getPathSegments().get(1);
            count = db.delete(PRODUCTO_TABLE_NAME, productos.id_prod + "=" + prod2Id
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            Log.e("prod provider ", "" + prod2Id);
            break;
            
        case PRODUCTOS:
            count = db.delete(PRODUCTO_TABLE_NAME, where, whereArgs);
            break;

        case PROD_ID:
            String prodId = uri.getPathSegments().get(1);
            count = db.delete(PRODUCTO_TABLE_NAME, productos.id_prod + "=" + prodId
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;

        case PRECIO_ID:
            String prod_Id = uri.getPathSegments().get(1);
            count = db.delete(PRECIO_TABLE_NAME, Precio.producto_id_prod + "=" + prod_Id
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;
            
        case GASTO:
            count = db.delete(GASTO_TABLE_NAME, where, whereArgs);
            break;

        case GASTO_ID:
            String gastoId = uri.getPathSegments().get(1);
            count = db.delete(GASTO_TABLE_NAME, Gasto.id_gasto + "=" + gastoId
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;
            
        case USUARIO:
            count = db.delete(USUARIO_TABLE_NAME, where, whereArgs);
            break;

        case ID_USUARIO:
            String usuarioId = uri.getPathSegments().get(1);
            count = db.delete(USUARIO_TABLE_NAME, Usuario.id_usuario + "=" + usuarioId
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;
            
        case EMPRESA:
            count = db.delete(EMPRESA_TABLE_NAME, where, whereArgs);
            break;

        case ID_EMPRE:
            String empresaId = uri.getPathSegments().get(1);
            count = db.delete(EMPRESA_TABLE_NAME, Empresa.id_empre + "=" + empresaId
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;

        default:
            throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        Log.w(TAG, "UPDATE.............");
        int count;
        switch (sUriMatcher.match(uri)) {
        case PRODUCTOS:
            count = db.update(PRODUCTO_TABLE_NAME, values, where, whereArgs);
            break;
            
        case PRODUCTOS2:
            count = db.update(PRODUCTO_TABLE_NAME, values, where, whereArgs);
            break;

        case PROD_ID:
            String prodId = uri.getPathSegments().get(1);
            count = db.update(PRODUCTO_TABLE_NAME, values, productos.id_prod + "=" + prodId
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;

        case PRECIO_ID:
            String prod_Id = uri.getPathSegments().get(1);
            count = db.update(PRODUCTO_TABLE_NAME, values, Precio.producto_id_prod + "=" + prod_Id
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;

        case PRODUCTOS2_ID:
            String prodIdpre = uri.getPathSegments().get(1);
            count = db.update(PRODUCTO_TABLE_NAME, values, productos.id_prod + "=" + prodIdpre
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;

        case PROD_SERIAL:
            String prodSerial = uri.getPathSegments().get(1);
            count = db.update(PRODUCTO_TABLE_NAME, values, productos.num_serie + "=" + prodSerial
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;
            
        case GASTO:
            count = db.update(GASTO_TABLE_NAME, values, where, whereArgs);
            break;

        case GASTO_ID:
            String gastoId = uri.getPathSegments().get(1);
            count = db.update(GASTO_TABLE_NAME, values, Gasto.id_gasto + "=" + gastoId
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;
            
        case USUARIO:
            count = db.update(USUARIO_TABLE_NAME, values, where, whereArgs);
            break;

        case ID_USUARIO:
            String usuarioId = uri.getPathSegments().get(1);
            count = db.update(USUARIO_TABLE_NAME, values, Usuario.id_usuario + "=" + usuarioId
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;
            
        case EMPRESA:
            count = db.update(EMPRESA_TABLE_NAME, values, where, whereArgs);
            break;

        case ID_EMPRE:
            String empresaId = uri.getPathSegments().get(1);
            count = db.update(EMPRESA_TABLE_NAME, values, Empresa.id_empre + "=" + empresaId
                    + (!TextUtils.isEmpty(where) ? " AND (" + where + ')' : ""), whereArgs);
            break;

        default:
            throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    static {
    	sUriMatcher = Uris.Creauri();

        sProductosProjectionMap = Mapper.Producto2Map();
        sCaracteristicaProjectionMap = Mapper.CaracteristicaMap();
        sCarro_comprasProjectionMap = Mapper.Carro_comprasMap();
        sCarro_ventaProjectionMap = Mapper.Carro_ventaMap();
        sCategoriaProjectionMap = Mapper.CategoriaMap();
        sClienteProjectionMap = Mapper.ClienteMap();
        sComunaProjectionMap = Mapper.ComunaMap();
        sEmpresaProjectionMap = Mapper.EmpresaMap();
        sEnvioProjectionMap = Mapper.EnvioMap();
        sFacturaProjectionMap = Mapper.FacturaMap();
        sGastoProjectionMap = Mapper.GastoMap();
        sItem_facturaProjectionMap = Mapper.Item_facturaMap();
        sPrecioProjectionMap = Mapper.PrecioMap();
        sStockProjectionMap = Mapper.StockMap();
        sSubcategoriaProjectionMap = Mapper.SubcategoriaMap();
        sTallaProjectionMap = Mapper.TallaMap();
        sUsuarioProjectionMap = Mapper.UsuarioMap();
        sValor_nutricionalProjectionMap = Mapper.Valor_nutricionalMap();
        sVentaProjectionMap = Mapper.VentaMap();
    }
}
*/