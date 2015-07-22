/*package cl.webinc.benderand.movidos;

import android.content.UriMatcher;
import android.util.Log;

public class Uris 
{
	private static final int PRODUCTO = 1;
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
    private static final int ID_VAL_NUTRI = 40;
    private static final int ID_VENTA = 41;
    private static final int ID_COMUNA = 42;
    private static final int ID_EMPRE = 30;
    private static final int ID_USUARIO = 39;
    private static final int PRODUCTOS2 = 43;
    private static final int PRODUCTOS2_ID = 48;
    private static final int PRECIO_ID = 49;
    
	public static UriMatcher Creauri()
	{
		UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

		sUriMatcher.addURI(base.AUTHORITY, "productos", PRODUCTO);
        sUriMatcher.addURI(base.AUTHORITY, "productos/#", PROD_ID);
		sUriMatcher.addURI(base.AUTHORITY, "productospre", PRODUCTOS2);
		sUriMatcher.addURI(base.AUTHORITY, "productospre/#", PRODUCTOS2_ID);
        sUriMatcher.addURI(base.AUTHORITY, "productos/num_serie/#", PROD_SERIAL);
        sUriMatcher.addURI(base.AUTHORITY, "productos/num_serie", SERIAL);
        sUriMatcher.addURI(base.AUTHORITY, "caracteristica", CARACTERISTICA);
        sUriMatcher.addURI(base.AUTHORITY, "carrocompras", CARRO_COMPRAS);
        sUriMatcher.addURI(base.AUTHORITY, "carroventa", CARRO_VENTA);
        sUriMatcher.addURI(base.AUTHORITY, "categoria", CATEGORIA);
        sUriMatcher.addURI(base.AUTHORITY, "cliente", CLIENTE);
        sUriMatcher.addURI(base.AUTHORITY, "comuna", COMUNA);
        sUriMatcher.addURI(base.AUTHORITY, "empresa", EMPRESA);
        sUriMatcher.addURI(base.AUTHORITY, "empresa/#", ID_EMPRE);
        sUriMatcher.addURI(base.AUTHORITY, "envio", ENVIO);
        sUriMatcher.addURI(base.AUTHORITY, "factura", FACTURA);
        sUriMatcher.addURI(base.AUTHORITY, "gasto", GASTO);
        sUriMatcher.addURI(base.AUTHORITY, "gasto/#", GASTO_ID);
        sUriMatcher.addURI(base.AUTHORITY, "item_factura", ITEM_FACTURA);
        sUriMatcher.addURI(base.AUTHORITY, "precio", PRECIO);
        sUriMatcher.addURI(base.AUTHORITY, "precio/#", PRECIO_ID);
        sUriMatcher.addURI(base.AUTHORITY, "stock", STOCK);
        sUriMatcher.addURI(base.AUTHORITY, "subcategoria", SUBCATEGORIA);
        sUriMatcher.addURI(base.AUTHORITY, "talla", TALLA);
        sUriMatcher.addURI(base.AUTHORITY, "usuario", USUARIO);
        sUriMatcher.addURI(base.AUTHORITY, "usuario/#", ID_USUARIO);
        sUriMatcher.addURI(base.AUTHORITY, "valor_nutricional", VALOR_NUTRICIONAL);
        sUriMatcher.addURI(base.AUTHORITY, "venta", VENTA);
        Log.e("Uris", "created ");
		return sUriMatcher;		
	}
}
*/