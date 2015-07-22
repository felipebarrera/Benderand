/*package cl.webinc.benderand.movidos;

import java.util.HashMap;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
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

public class InsertDB 
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
	private static final int PRODUCTOS = 1;
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
	private static UriMatcher sUriMatcher;

	@SuppressWarnings("unused")
	private static HashMap<String, String> sCarro_comprasProjectionMap;

    private static final ProjectionMaper Mapper = new ProjectionMaper();
	private DBHelper mOpenHelper;
	private SQLiteDatabase db;
	private static final Long now = Long.valueOf(System.currentTimeMillis());
	private long rowId;
	private Uri noteUri;

    public boolean onCreate() {
        Log.w("InsertDB ", "ONCREATE.............");
        return true;
    }
    
	public Uri insert(Uri uri, ContentValues initialValues, Context context) 
	{
		mOpenHelper = DBHelper.getinstance(context);
		db = mOpenHelper.getWritableDatabase();

		ContentValues values;
		if (initialValues != null) 
		{
			values = new ContentValues(initialValues);
		} else {
			values = new ContentValues();
		}
		Log.w("urimatcher", "" + sUriMatcher.match(uri) + uri);
		if (sUriMatcher.match(uri) == PRODUCTOS) 
		{
			if (values.containsKey(base.productos.cod_prod) == false) 
			{
				values.put(base.productos.cod_prod, now);
			}
			if (values.containsKey(base.productos.num_serie) == false) 
			{
				values.put(base.productos.num_serie, now);
			}
			if (values.containsKey(base.productos.descrip_prod) == false) 
			{
				values.put(base.productos.descrip_prod, now);
			}
			if (values.containsKey(base.productos.subcategoria_id_subcat) == false) 
			{
				values.put(base.productos.subcategoria_id_subcat, now);
			}
			if (values.containsKey(base.productos.nom_prod) == false) {
				values.put(base.productos.nom_prod, "");
			}
			if (values.containsKey(base.productos.marca_prod) == false) {
				values.put(base.productos.marca_prod, now);
			}
			if (values.containsKey(base.productos.mod_prod) == false) {
				values.put(base.productos.mod_prod, now);
			}
			if (values.containsKey(base.productos.cont_uni) == false) {
				values.put(base.productos.cont_uni, now);
			}
			if (values.containsKey(base.productos.uni_min) == false) {
				values.put(base.productos.uni_min, now);
			}
			if (values.containsKey(base.productos.cont_uni_med) == false) {
				values.put(base.productos.cont_uni_med, now);
			}
			if (values.containsKey(base.productos.contenido) == false) {
				values.put(base.productos.contenido, now);
			}
			if (values.containsKey(base.productos.peso_neto) == false) {
				values.put(base.productos.peso_neto, now);
			}
			if (values.containsKey(base.productos.alto_cm) == false) {
				values.put(base.productos.alto_cm, now);
			}
			if (values.containsKey(base.productos.ancho_cm) == false) {
				values.put(base.productos.ancho_cm, now);
			}
			if (values.containsKey(base.productos.fondo_cm) == false) {
				values.put(base.productos.fondo_cm, now);
			}
			if (values.containsKey(base.productos.fabr) == false) {
				values.put(base.productos.fabr, now);
			}
			if (values.containsKey(base.productos.fam_nec) == false) {
				values.put(base.productos.fam_nec, now);
			}
			if (values.containsKey(base.productos.fam_prod) == false) {
				values.put(base.productos.fam_prod, now);
			}
			if (values.containsKey(base.productos.clase_prod) == false) {
				values.put(base.productos.clase_prod, now);
			}
			if (values.containsKey(base.productos.linea_prod) == false) {
				values.put(base.productos.linea_prod, now);
			}
			if (values.containsKey(base.productos.tipo_prod) == false) {
				values.put(base.productos.tipo_prod, now);
			}
			if (values.containsKey(base.productos.SKU) == false) {
				values.put(base.productos.SKU, now);
			}
			if (values.containsKey(base.productos.hot) == false) {
				values.put(base.productos.hot, now);
			}

			rowId = db.insert(PRODUCTO_TABLE_NAME, productos.hot, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(base.productos.CONTENT_URI,
						rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}
	
		if (sUriMatcher.match(uri) == CARACTERISTICA) {
			if (values.containsKey(cl.webinc.benderand.provider.Caracteristica.carac) == false) {
				values.put(cl.webinc.benderand.provider.Caracteristica.carac, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Caracteristica.num_carac) == false) {
				values.put(cl.webinc.benderand.provider.Caracteristica.num_carac, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Caracteristica.valor_carac) == false) {
				values.put(cl.webinc.benderand.provider.Caracteristica.valor_carac, now);
			}

			rowId = db.insert(CARACTERISTICA_TABLE_NAME, Caracteristica.valor_carac, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Caracteristica.CONTENT_URI_CARACTERISTICA, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}
		
		if (sUriMatcher.match(uri) == CARRO_COMPRAS) {
			if (values.containsKey(base.carro_compras.cant_carro) == false) {
				values.put(base.carro_compras.cant_carro, now);
			}
			if (values.containsKey(base.carro_compras.empresa_id_empre) == false) {
				values.put(base.carro_compras.empresa_id_empre, now);
			}
			if (values.containsKey(base.carro_compras.producto_id_prod) == false) {
				values.put(base.carro_compras.producto_id_prod, now);
			}
			if (values.containsKey(base.carro_compras.carne_id_usuario) == false) {
				values.put(base.carro_compras.carne_id_usuario, now);
			}
			if (values.containsKey(base.carro_compras.precio_carro) == false) {
				values.put(base.carro_compras.precio_carro, now);
			}
			rowId = db.insert(CARRO_COMPRAS_TABLE_NAME, carro_compras.precio_carro,
					values);
			db.close();
				noteUri = ContentUris.withAppendedId(
						base.carro_compras.CONTENT_URI_CARRO_COMPRAS, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			
			//if (rowId > 0) {}
		}

		if (sUriMatcher.match(uri) == CARRO_VENTA) {
			if (values.containsKey(cl.webinc.benderand.provider.Carro_venta.cant) == false) {
				values.put(cl.webinc.benderand.provider.Carro_venta.cant, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Carro_venta.id_carro) == false) {
				values.put(cl.webinc.benderand.provider.Carro_venta.id_carro, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Carro_venta.id_empre) == false) {
				values.put(cl.webinc.benderand.provider.Carro_venta.id_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Carro_venta.id_prod) == false) {
				values.put(cl.webinc.benderand.provider.Carro_venta.id_prod, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Carro_venta.id_usuario) == false) {
				values.put(cl.webinc.benderand.provider.Carro_venta.id_usuario, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Carro_venta.precio) == false) {
				values.put(cl.webinc.benderand.provider.Carro_venta.precio, now);
			}
			rowId = db.insert(CARRO_VENTA_TABLE_NAME, Carro_venta.precio, values);
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Carro_venta.CONTENT_URI_CARRO_VENTA, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == CATEGORIA) {
			if (values.containsKey(cl.webinc.benderand.provider.Categoria.nom_categoria) == false) {
				values.put(cl.webinc.benderand.provider.Categoria.nom_categoria, now);
			}
			rowId = db.insert(CATEGORIA_TABLE_NAME, Categoria.nom_categoria, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Categoria.CONTENT_URI_CATEGORIA, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == CLIENTE) {
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.actividad) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.actividad, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.ano_fecnac) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.ano_fecnac, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.apelli2_cliente) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.apelli2_cliente, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.apelli_cliente) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.apelli_cliente, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.area_activ) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.area_activ, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.calle_res) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.calle_res, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.celfono) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.celfono, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.ciudad_cliente) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.ciudad_cliente, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.comuna_res) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.comuna_res, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.dia_fecnac) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.dia_fecnac, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.dig_ver) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.dig_ver, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.edad) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.edad, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.email) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.email, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.mes_fecnac) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.mes_fecnac, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.nacionalidad) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.nacionalidad, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.nom2_cliente) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.nom2_cliente, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.nom_cliente) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.nom_cliente, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.numerodp) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.numerodp, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.num_res) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.num_res, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.rut_cliente) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.rut_cliente, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.sector) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.sector, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Cliente.telefono) == false) {
				values.put(cl.webinc.benderand.provider.Cliente.telefono, now);
			}
			rowId = db.insert(CLIENTE_TABLE_NAME, Cliente.telefono, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Cliente.CONTENT_URI_CLIENTE, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == COMUNA) {
			if (values.containsKey(cl.webinc.benderand.provider.Comuna.nom_comuna) == false) {
				values.put(cl.webinc.benderand.provider.Comuna.nom_comuna, now);
			}
			rowId = db.insert(COMUNA_TABLE_NAME, Comuna.nom_comuna, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Comuna.CONTENT_URI_COMUNA, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}
		
		if (sUriMatcher.match(uri) == EMPRESA) {
			if (values.containsKey(cl.webinc.benderand.provider.Empresa.alcance_empre) == false) {
				values.put(cl.webinc.benderand.provider.Empresa.alcance_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Empresa.cargo_cont_empre) == false) {
				values.put(cl.webinc.benderand.provider.Empresa.cargo_cont_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Empresa.dig_verifi_empre) == false) {
				values.put(cl.webinc.benderand.provider.Empresa.dig_verifi_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Empresa.email_empre) == false) {
				values.put(cl.webinc.benderand.provider.Empresa.email_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Empresa.nombre_empre) == false) {
				values.put(cl.webinc.benderand.provider.Empresa.nombre_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Empresa.nom_cont_empre) == false) {
				values.put(cl.webinc.benderand.provider.Empresa.nom_cont_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Empresa.rut_empre) == false) {
				values.put(cl.webinc.benderand.provider.Empresa.rut_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Empresa.telefono_empre) == false) {
				values.put(cl.webinc.benderand.provider.Empresa.telefono_empre, now);
			}
			rowId = db.insert(EMPRESA_TABLE_NAME, Empresa.nombre_empre, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Empresa.CONTENT_URI_EMPRESA, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == ENVIO) {
			if (values.containsKey(cl.webinc.benderand.provider.Envio.alt_dir) == false) {
				values.put(cl.webinc.benderand.provider.Envio.alt_dir, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Envio.fec_entre) == false) {
				values.put(cl.webinc.benderand.provider.Envio.fec_entre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Envio.hor_entr) == false) {
				values.put(cl.webinc.benderand.provider.Envio.hor_entr, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Envio.id_venta) == false) {
				values.put(cl.webinc.benderand.provider.Envio.id_venta, now);
			}
			rowId = db.insert(ENVIO_TABLE_NAME, Envio.id_venta, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(cl.webinc.benderand.provider.Envio.CONTENT_URI_ENVIO,
						rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == FACTURA) {
			if (values.containsKey(cl.webinc.benderand.provider.Factura.ano) == false) {
				values.put(cl.webinc.benderand.provider.Factura.ano, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Factura.dia) == false) {
				values.put(cl.webinc.benderand.provider.Factura.dia, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Factura.id_empresa) == false) {
				values.put(cl.webinc.benderand.provider.Factura.id_empresa, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Factura.mes) == false) {
				values.put(cl.webinc.benderand.provider.Factura.mes, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Factura.rol) == false) {
				values.put(cl.webinc.benderand.provider.Factura.rol, now);
			}
			rowId = db.insert(FACTURA_TABLE_NAME, Factura.rol, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Factura.CONTENT_URI_FACTURA, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == GASTO) {
			if (values.containsKey(cl.webinc.benderand.provider.Gasto.fecha_gasto) == false) {
				values.put(cl.webinc.benderand.provider.Gasto.fecha_gasto, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Gasto.id_usuario) == false) {
				values.put(cl.webinc.benderand.provider.Gasto.id_usuario, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Gasto.monto_gasto) == false) {
				values.put(cl.webinc.benderand.provider.Gasto.monto_gasto, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Gasto.nombre_gasto) == false) {
				values.put(cl.webinc.benderand.provider.Gasto.nombre_gasto, now);
			}
			rowId = db.insert(GASTO_TABLE_NAME, Gasto.id_gasto, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Gasto.CONTENT_URI_GASTO, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}
		
		if (sUriMatcher.match(uri) == ITEM_FACTURA) {
			if (values.containsKey(cl.webinc.benderand.provider.Item_factura.cant) == false) {
				values.put(cl.webinc.benderand.provider.Item_factura.cant, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Item_factura.id_factura) == false) {
				values.put(cl.webinc.benderand.provider.Item_factura.id_factura, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Item_factura.id_prod) == false) {
				values.put(cl.webinc.benderand.provider.Item_factura.id_prod, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Item_factura.precio) == false) {
				values.put(cl.webinc.benderand.provider.Item_factura.precio, now);
			}
			rowId = db.insert(ITEM_FACTURA_TABLE_NAME, Item_factura.precio, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Item_factura.CONTENT_URI_ITEM_FACTURA, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == PRECIO) {
			if (values.containsKey(cl.webinc.benderand.provider.Precio.id_precio) == false) {
				values.put(cl.webinc.benderand.provider.Precio.id_precio, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.empresa_id_empre) == false) {
				values.put(cl.webinc.benderand.provider.Precio.empresa_id_empre, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.cant_mayor) == false) {
				values.put(cl.webinc.benderand.provider.Precio.cant_mayor, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.producto_id_prod) == false) {
				values.put(cl.webinc.benderand.provider.Precio.producto_id_prod, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.p_mayor_p_ch) == false) {
				values.put(cl.webinc.benderand.provider.Precio.p_mayor_p_ch, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.p_mayor_p_ch_ant) == false) {
				values.put(cl.webinc.benderand.provider.Precio.p_mayor_p_ch_ant, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.p_mayor_us) == false) {
				values.put(cl.webinc.benderand.provider.Precio.p_mayor_us, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.p_pes_ch) == false) {
				values.put(cl.webinc.benderand.provider.Precio.p_pes_ch, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.p_pes_ch_ant) == false) {
				values.put(cl.webinc.benderand.provider.Precio.p_pes_ch_ant, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.p_us) == false) {
				values.put(cl.webinc.benderand.provider.Precio.p_us, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Precio.v_mayor) == false) {
				values.put(cl.webinc.benderand.provider.Precio.v_mayor, now);
			}
			rowId = db.insert(PRECIO_TABLE_NAME, Precio.p_us, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Precio.CONTENT_URI_PRECIO, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == STOCK) {
			if (values.containsKey(cl.webinc.benderand.provider.Stock.id_prod) == false) {
				values.put(cl.webinc.benderand.provider.Stock.id_prod, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Stock.last_update) == false) {
				values.put(cl.webinc.benderand.provider.Stock.last_update, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Stock.stock_ideal) == false) {
				values.put(cl.webinc.benderand.provider.Stock.stock_ideal, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Stock.stock_minimo) == false) {
				values.put(cl.webinc.benderand.provider.Stock.stock_minimo, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Stock.stock_real) == false) {
				values.put(cl.webinc.benderand.provider.Stock.stock_real, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Stock.stock_tienda) == false) {
				values.put(cl.webinc.benderand.provider.Stock.stock_tienda, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Stock.stock_vendido) == false) {
				values.put(cl.webinc.benderand.provider.Stock.stock_vendido, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Stock.stock_virtual) == false) {
				values.put(cl.webinc.benderand.provider.Stock.stock_virtual, now);
			}
			rowId = db.insert(STOCK_TABLE_NAME, Stock.stock_virtual, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(cl.webinc.benderand.provider.Stock.CONTENT_URI_STOCK,
						rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}
		
		if (sUriMatcher.match(uri) == SUBCATEGORIA) {
			if (values.containsKey(cl.webinc.benderand.provider.Subcategoria.id_categoria) == false) {
				values.put(cl.webinc.benderand.provider.Subcategoria.id_categoria, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Subcategoria.nom_subcat) == false) {
				values.put(cl.webinc.benderand.provider.Subcategoria.nom_subcat, now);
			}
			rowId = db.insert(SUBCATEGORIA_TABLE_NAME, Subcategoria.nom_subcat,
					values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Subcategoria.CONTENT_URI_SUBCATEGORIA, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == TALLA) {
			if (values.containsKey(cl.webinc.benderand.provider.Talla.am_ancho) == false) {
				values.put(cl.webinc.benderand.provider.Talla.am_ancho, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.am_fondo) == false) {
				values.put(cl.webinc.benderand.provider.Talla.am_fondo, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.a_largo) == false) {
				values.put(cl.webinc.benderand.provider.Talla.a_largo, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.eu_ancho) == false) {
				values.put(cl.webinc.benderand.provider.Talla.eu_ancho, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.eu_fondo) == false) {
				values.put(cl.webinc.benderand.provider.Talla.eu_fondo, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.eu_largo) == false) {
				values.put(cl.webinc.benderand.provider.Talla.eu_largo, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.id_prod) == false) {
				values.put(cl.webinc.benderand.provider.Talla.id_prod, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.num_ancho) == false) {
				values.put(cl.webinc.benderand.provider.Talla.num_ancho, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.num_fondo) == false) {
				values.put(cl.webinc.benderand.provider.Talla.num_fondo, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Talla.num_largo) == false) {
				values.put(cl.webinc.benderand.provider.Talla.num_largo, now);
			}
			rowId = db.insert(TALLA_TABLE_NAME, Talla.num_largo, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(cl.webinc.benderand.provider.Talla.CONTENT_URI_TALLA,
						rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}

		}

		if (sUriMatcher.match(uri) == USUARIO) {
			if (values.containsKey(cl.webinc.benderand.provider.Usuario.clave) == false) {
				values.put(cl.webinc.benderand.provider.Usuario.clave, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Usuario.id_cliente) == false) {
				values.put(cl.webinc.benderand.provider.Usuario.id_cliente, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Usuario.nom_usuario) == false) {
				values.put(cl.webinc.benderand.provider.Usuario.nom_usuario, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Usuario.tipo_usuario) == false) {
				values.put(cl.webinc.benderand.provider.Usuario.tipo_usuario, now);
			}
			rowId = db.insert(USUARIO_TABLE_NAME, Usuario.tipo_usuario, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(
						cl.webinc.benderand.provider.Usuario.CONTENT_URI_USUARIO, rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == VALOR_NUTRICIONAL) {
			if (values.containsKey(cl.webinc.benderand.provider.Valor_nutricional._requerimientos) == false) {
				values.put(cl.webinc.benderand.provider.Valor_nutricional._requerimientos, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Valor_nutricional.cantidad) == false) {
				values.put(cl.webinc.benderand.provider.Valor_nutricional.cantidad, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Valor_nutricional.id_prod) == false) {
				values.put(cl.webinc.benderand.provider.Valor_nutricional.id_prod, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Valor_nutricional.nombre_valor) == false) {
				values.put(cl.webinc.benderand.provider.Valor_nutricional.nombre_valor, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Valor_nutricional.valor_diario_total) == false) {
				values.put(cl.webinc.benderand.provider.Valor_nutricional.valor_diario_total, now);
			}
			rowId = db.insert(VALOR_NUTRICIONAL_TABLE_NAME,
					Valor_nutricional.valor_diario_total, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris
						.withAppendedId(
								cl.webinc.benderand.provider.Valor_nutricional.CONTENT_URI_VALOR_NUTRICIONAL,
								rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}

		if (sUriMatcher.match(uri) == VENTA) {
			if (values.containsKey(cl.webinc.benderand.provider.Venta.id_carro) == false) {
				values.put(cl.webinc.benderand.provider.Venta.id_carro, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Venta.id_envio) == false) {
				values.put(cl.webinc.benderand.provider.Venta.id_envio, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Venta.num_articulos) == false) {
				values.put(cl.webinc.benderand.provider.Venta.num_articulos, now);
			}
			if (values.containsKey(cl.webinc.benderand.provider.Venta.total) == false) {
				values.put(cl.webinc.benderand.provider.Venta.total, now);
			}
			rowId = db.insert(VENTA_TABLE_NAME, Venta.total, values);
			db.close();
			if (rowId > 0) {
				noteUri = ContentUris.withAppendedId(cl.webinc.benderand.provider.Venta.CONTENT_URI_VENTA,
						rowId);
				context.getContentResolver().notifyChange(noteUri, null);
				return noteUri;
			}
		}
		boolean foo = sUriMatcher.match(uri) == CARRO_COMPRAS;
		Log.w("match ", "es carrocompra " + foo);
		Log.w("match ", "es urimatcher " + sUriMatcher.match(uri));
		db.close();
		if(sUriMatcher.match(uri) == UriMatcher.NO_MATCH)
		{
			throw new SQLException("Failed to insert row into " + uri);
		}else
		{			
			return null;
		}
	}
	static {
    	sUriMatcher = Uris.Creauri();
        Log.w("sUriMatcher ", "STATIC Creauri");

        Mapper.ProductoMap();
        sCarro_comprasProjectionMap = Mapper.Carro_comprasMap();
    }
}
*/