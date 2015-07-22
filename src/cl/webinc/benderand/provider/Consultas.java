package cl.webinc.benderand.provider;

import cl.webinc.benderand.AppMy;
import cl.webinc.benderand.datos.Database;
import cl.webinc.benderand.provider.Base.imagenprod;
import cl.webinc.benderand.provider.Base.precio;
import cl.webinc.benderand.provider.Base.producto;
import cl.webinc.benderand.provider.Base.stock;
import cl.webinc.benderand.provider.Base.subcategoria;
import cl.webinc.benderand.util.Constantes;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;


public final class Consultas {
	public static final int PRODUCTOS2 = 100;
	public static final int PRODUCTOS2_ID = 101;
	public static final int CARRO_COMPRAS2 = 102;
	public static final int PROD_SERIAL = 103;
	public static final int SERIAL = 104;
	public static final int PRODUCTOSCOMPLETOS = 105;
	public static final int PRODUCTOSCOMPLETOS_ID = 106;
	public static final int CARNE_USER = 107;
	public static final int CARACTERISTICA = 108;
	public static final int CARACTERISTICA_ID = 109;
	private static Cursor c;
	private static AppMy app = AppMy.getinstance(); 
	private Consultas() {}
	public static class consultaProducto
	{
		public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/productospre");

		public static final String PRODUCTOSRAW = "SELECT * FROM producto p INNER JOIN precio " +
				" on precio.producto_id_producto = p._id";
		public static final String PRODUCTOSRAW_ID = "SELECT * FROM producto p INNER JOIN precio " +
				" on precio.producto_id_producto = p._id WHERE p._id = ";
		public static final String RAWQUERYSERIAL = "SELECT * FROM producto p INNER JOIN precio " +
				" on precio.producto_id_producto = p._id WHERE p.num_serie = ";

		public static final String CARROCOMPRASRAW = "SELECT (select sum(carro_compras.precio)from carro_compras)as total, carro_compras.*, producto.nom_prod FROM carro_compras INNER JOIN producto" +
				" on carro_compras.producto_id_prod = producto._id";
		public static final String PRODUCTOCOMPLETOMODEL_GETPRODUCTODROID = "SELECT * FROM producto p " +
				"left join subcategoria su on su._id = p.subcategoria_id_subcategoria "+
				"left join stock s on s.producto_id_producto = p._id "+
				"left join precio pr on pr.producto_id_producto = p._id "+
				"LEFT JOIN imagenprod i ON i.producto_id_producto = p._id "+
				"WHERE pr.precio_actual = 1 AND pr.empresa_id_empresa = ?"+
				"order by marca_producto,nombre_subcategoria";
		
		public static final String PRODUCTOCOMPLETO_ID = "SELECT * FROM producto po "+
		"INNER JOIN precio p on p.producto_id_producto = po._id "+
		"LEFT JOIN reciclado r on r.producto_id_producto = po._id "+
		"left join stock s on s.producto_id_producto = po._id "+
		"INNER JOIN subcategoria sc on sc._id = po.subcategoria_id_subcategoria "+
		"INNER JOIN categoria c on c._id = sc.categoria_id_categoria "+
		"LEFT JOIN imagenprod i ON i.producto_id_producto = po._id "+
		"WHERE po._id = ? AND pr.empresa_id_empresa = ? "+
		"and  p.precio_actual = 1";
	}
	public static Cursor matcher(Uri uri, Context context) {
		UriMatcher sUriMatcher;
		Database mOpenHelper = Database.getinstance(context);
		sUriMatcher = Creaurilocal();
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		Log.e("CursorDb", "QUERY... match " + uri + " " + sUriMatcher.match(uri));
		switch (sUriMatcher.match(uri)) 
		{			
		case PRODUCTOSCOMPLETOS:
			c = db.rawQuery(Consultas.consultaProducto.PRODUCTOCOMPLETOMODEL_GETPRODUCTODROID, new String[] { app.getCarneEmpresa().getId_empresa() });
			Log.e("CursorDb", "prodprecio............."+ uri.getLastPathSegment());
			break;
			
		case PRODUCTOSCOMPLETOS_ID:
			c = db.rawQuery(Consultas.consultaProducto.PRODUCTOCOMPLETO_ID, new String[] {uri.getLastPathSegment(), app.getCarneEmpresa().getId_empresa() });
			Log.e("CursorDb", "prodprecio............."+ uri.getLastPathSegment());
			break;
			
		case PRODUCTOS2:
			c = db.rawQuery(Consultas.consultaProducto.PRODUCTOSRAW, null);
			Log.e("CursorDb", "prodprecio............."+ uri.getLastPathSegment());
			break;
	        
	    case PRODUCTOS2_ID:
		    c = db.rawQuery(Consultas.consultaProducto.PRODUCTOSRAW_ID + uri.getLastPathSegment(), null);
	    	Log.e("CursorDb", "prodprecioid............."+ uri.getLastPathSegment());
	        break;

		case CARRO_COMPRAS2:
		    c = db.rawQuery(Consultas.consultaProducto.CARROCOMPRASRAW, null);
	    	Log.e("CursorDb", "Carro_compras............."+ uri.getLastPathSegment());
	    	break;
	        
	    case PROD_SERIAL:
		    c = db.rawQuery(Consultas.consultaProducto.RAWQUERYSERIAL + uri.getLastPathSegment(), null);
	    	Log.e("CursorDb", "prodprecio............."+ uri.getLastPathSegment());
	        break;
	        
	    case SERIAL:
		    c = db.rawQuery(Consultas.consultaProducto.RAWQUERYSERIAL + uri.getLastPathSegment(), null);
	    	Log.e("CursorDb", "prodprecio............."+ uri.getLastPathSegment());
	        break;
		}
		return c;
	}

	public static UriMatcher Creaurilocal()
	{
		UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(Constantes.AUTHORITY, "productospre", PRODUCTOS2);
		sUriMatcher.addURI(Constantes.AUTHORITY, "productospre/#", PRODUCTOS2_ID);
        sUriMatcher.addURI(Constantes.AUTHORITY, "productos/num_serie/#", PROD_SERIAL);
        sUriMatcher.addURI(Constantes.AUTHORITY, "productos/num_serie", SERIAL);
		sUriMatcher.addURI(Constantes.AUTHORITY, "productoscompleto", PRODUCTOSCOMPLETOS);
		sUriMatcher.addURI(Constantes.AUTHORITY, "productoscompleto/#", PRODUCTOSCOMPLETOS_ID);
		return sUriMatcher;
	}
	public static String[] projectionCreater(String tipo){
		final String[] productocompleto = new String[] {
			 producto.alto_cm,
			 producto.ancho_cm,
			 producto.clase_producto,
			 producto.codigo_producto,
			 producto.contenido,
			 producto.contenido_unidad,
			 producto.descripcion_producto,
			 producto.fabricante,
			 producto.fondo_cm,
			 producto.hot,
			 producto.id_producto,
			 producto.linea_producto,
			 producto.marca_producto,
			 producto.modelo_producto,
			 producto.nombre_producto,
			 producto.numero_serie,
			 producto.peso_neto,
			 producto.SKU,
			 producto.subcategoria_id_subcategoria,
			 producto.unidad_minima,
			 subcategoria.categoria_id_categoria,
			 subcategoria.descripcion_subcategoria,
			 subcategoria.id_subcategoria,
			 subcategoria.nombre_subcategoria,
			 stock.empresa_id_empresa,
			 stock.id_stock,
			 stock.last_update,
			 stock.producto_id_producto,
			 stock.stock_ideal,
			 stock.stock_minimo,
			 stock.stock_real,
			 stock.stock_tienda,
			 stock.stock_vendido,
			 stock.stock_virtual,
			 precio.cantidad_mayor,
			 precio.descuento_promocion,
			 precio.empresa_id_empresa,
			 precio.id_precio,
			 precio.precio_actual,
			 precio.producto_id_producto,
			 precio.precio_mayor_CLP,
			 precio.precio_mayor_us,
			 precio.precio_CLP,
			 precio.precio_us,
			 imagenprod.id_imagenprod,
			 imagenprod.producto_id_producto,
			 imagenprod.urlimagenprod
		};
		if(tipo.equals("productocompleto")){
			return productocompleto;
		}else
		{
			return productocompleto;
		}		
	}
}



