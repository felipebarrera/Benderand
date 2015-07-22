/*package cl.webinc.benderand.movidos;

import cl.webinc.benderand.provider.base.*;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper 
{

    private static final String DATABASE_NAME = "com_ncwebinc_vender_data.db";
    private static final int DATABASE_VERSION = 1;
    private static final String PRODUCTO_TABLE_NAME = "producto";
    private static final String CARRO_COMPRA_TABLE_NAME = "carro_compras";
    private static final String CARACTERISTICA_TABLE_NAME = "caracteristica";
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
    private static DBHelper dbh;
        private DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public static DBHelper getinstance(Context context) 
        {
        	if(dbh == null)
        	{
        		dbh = new DBHelper(context);
        	}
			return dbh;       	
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        	Log.w("data path", "dta" + db.getPath());
            db.execSQL("CREATE TABLE " + PRODUCTO_TABLE_NAME + " ("
                    + productos.id_prod + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + productos.cod_prod + " TEXT,"
                    + productos.num_serie + " TEXT,"
                    + productos.descrip_prod + " TEXT,"
                    + productos.subcategoria_id_subcat + " INTEGER,"
                    + productos.nom_prod + " TEXT,"
                    + productos.marca_prod + " TEXT,"
                    + productos.mod_prod + " TEXT,"
                    + productos.cont_uni + " TEXT,"
                    + productos.uni_min + " TEXT,"
                    + productos.cont_uni_med + " TEXT,"
                    + productos.contenido + " INTEGER,"
                    + productos.peso_neto + " INTEGER,"
                    + productos.alto_cm + " INTEGER,"
                    + productos.ancho_cm + " INTEGER,"
                    + productos.fondo_cm + " INTEGER,"
                    + productos.fabr + " TEXT,"
                    + productos.fam_nec + " TEXT,"
                    + productos.fam_prod + " TEXT,"
                    + productos.clase_prod + " TEXT,"
                    + productos.linea_prod + " TEXT,"
                    + productos.tipo_prod + " TEXT,"
                    + productos.SKU + " INTEGER,"
                    + productos.hot + " INTEGER"
                    + ");");
            db.execSQL("CREATE TABLE " + CARRO_COMPRA_TABLE_NAME + " ("
                    + carro_compras.id_carro + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + carro_compras.carne_id_usuario + " INTEGER,"
                    + carro_compras.producto_id_prod + " INTEGER,"
                    + carro_compras.empresa_id_empre + " INTEGER,"
                    + carro_compras.precio_carro + " INTEGER,"
                    + carro_compras.cant_carro + " INTEGER"
                    + ");");
            db.execSQL("CREATE TABLE " + CARACTERISTICA_TABLE_NAME + " ("
            		+ Caracteristica.id_caract + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Caracteristica.carac + " TEXT,"
            		+ Caracteristica.num_carac + " INTEGER,"
            		+ Caracteristica.valor_carac + " TEXT"
            		+ ");");
            		db.execSQL("CREATE TABLE " + CARRO_VENTA_TABLE_NAME + " ("
            		+ Carro_venta.id_carventa + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Carro_venta.cant + " INTEGER,"
            		+ Carro_venta.id_carro + " INTEGER,"
            		+ Carro_venta.id_empre + " INTEGER,"
            		+ Carro_venta.id_prod + " INTEGER,"
            		+ Carro_venta.id_usuario + " INTEGER,"
            		+ Carro_venta.precio + " INTEGER"
            		+ ");");
            		db.execSQL("CREATE TABLE " + CATEGORIA_TABLE_NAME + " ("
            		+ Categoria.Id_categoria + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Categoria.nom_categoria + " TEXT"
            		+ ");");
            		db.execSQL("CREATE TABLE " + CLIENTE_TABLE_NAME + " ("
            		+ Cliente.id_cliente + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Cliente.actividad + " TEXT,"
            		+ Cliente.ano_fecnac + " INTEGER,"
            		+ Cliente.apelli2_cliente + " TEXT,"
            		+ Cliente.apelli_cliente + " TEXT,"
            		+ Cliente.area_activ + " TEXT,"
            		+ Cliente.calle_res + " TEXT,"
            		+ Cliente.celfono + " TEXT,"
            		+ Cliente.ciudad_cliente + " TEXT,"
            		+ Cliente.comuna_res + " TEXT,"
            		+ Cliente.dia_fecnac + " INTEGER,"
            		+ Cliente.dig_ver + " INTEGER,"
            		+ Cliente.edad + " TEXT,"
            		+ Cliente.email + " TEXT,"
            		+ Cliente.mes_fecnac + " INTEGER,"
            		+ Cliente.nacionalidad + " INTEGER,"
            		+ Cliente.nom2_cliente + " TEXT,"
            		+ Cliente.nom_cliente + " TEXT,"
            		+ Cliente.numerodp + " INTEGER,"
            		+ Cliente.num_res + " INTEGER,"
            		+ Cliente.rut_cliente + " TEXT,"
            		+ Cliente.sector + " TEXT,"
            		+ Cliente.telefono + " TEXT"
            		+ ");");
            		db.execSQL("CREATE TABLE " + COMUNA_TABLE_NAME + " ("
            		+ Comuna.id_comuna + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Comuna.nom_comuna + " TEXT"
            		+ ");");
            		db.execSQL("CREATE TABLE " + EMPRESA_TABLE_NAME + " ("
            		+ Empresa.alcance_empre + " TEXT,"
            		+ Empresa.cargo_cont_empre + " TEXT,"
            		+ Empresa.dig_verifi_empre + " TEXT,"
            		+ Empresa.email_empre + " TEXT,"
            		+ Empresa.id_empre + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Empresa.nombre_empre + " TEXT,"
            		+ Empresa.nom_cont_empre + " TEXT,"
            		+ Empresa.rut_empre + " TEXT,"
            		+ Empresa.actividad_id_actividad + " TEXT,"
            		+ Empresa.telefono_empre + " TEXT"
            		+ ");");
            		db.execSQL("CREATE TABLE " + ENVIO_TABLE_NAME + " ("
            		+ Envio.alt_dir + " TEXT,"
            		+ Envio.fec_entre + " TEXT,"
            		+ Envio.hor_entr + " TEXT,"
            		+ Envio.id_envio + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Envio.id_venta + " INTEGER"
            		+ ");");
            		db.execSQL("CREATE TABLE " + FACTURA_TABLE_NAME + " ("
            		+ Factura.ano + " INTEGER,"
            		+ Factura.dia + " INTEGER,"
            		+ Factura.id_empresa + " INTEGER,"
            		+ Factura.id_factura + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Factura.mes + " INTEGER,"
            		+ Factura.rol + " INTEGER"
            		+ ");");
            		db.execSQL("CREATE TABLE " + GASTO_TABLE_NAME + " ("
            		+ Gasto.id_gasto + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Gasto.fecha_gasto + " TEXT,"
            		+ Gasto.id_usuario + " INTEGER,"
            		+ Gasto.monto_gasto + " INTEGER,"
            		+ Gasto.nombre_gasto + " TEXT"
            		+ ");");
            		db.execSQL("CREATE TABLE " + ITEM_FACTURA_TABLE_NAME + " ("
            		+ Item_factura.cant + " INTEGER,"
            		+ Item_factura.id_factura + " INTEGER,"
            		+ Item_factura.id_itemfactura + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Item_factura.id_prod + " INTEGER,"
            		+ Item_factura.precio + " INTEGER"
            		+ ");");
            		db.execSQL("CREATE TABLE " + PRECIO_TABLE_NAME + " ("
            		+ Precio.empresa_id_empre + " INTEGER,"
            		+ Precio.id_precio + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Precio.producto_id_prod + " INTEGER,"
            		+ Precio.p_pes_ch + " INTEGER,"
                    + Precio.p_pes_ch_ant + " INTEGER,"
                    + Precio.p_us + " INTEGER,"
                    + Precio.cant_mayor + " INTEGER,"
                    + Precio.p_mayor_p_ch + " INTEGER,"
                    + Precio.p_mayor_p_ch_ant + " INTEGER,"
                    + Precio.p_mayor_us + " INTEGER,"
            		+ Precio.v_mayor + " INTEGER"
            		+ ");");
            		db.execSQL("CREATE TABLE " + STOCK_TABLE_NAME + " ("
            		+ Stock.id_prod + " INTEGER,"
            		+ Stock.id_stock + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Stock.last_update + " TEXT,"
            		+ Stock.stock_ideal + " INTEGER,"
            		+ Stock.stock_minimo + " INTEGER,"
            		+ Stock.stock_real + " INTEGER,"
            		+ Stock.stock_tienda + " INTEGER,"
            		+ Stock.stock_vendido + " INTEGER,"
            		+ Stock.stock_virtual + " INTEGER"
            		+ ");");
            		db.execSQL("CREATE TABLE " + SUBCATEGORIA_TABLE_NAME + " ("
            		+ Subcategoria.id_categoria + " INTEGER,"
            		+ Subcategoria.id_subcat + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Subcategoria.nom_subcat + " TEXT"
            		+ ");");
            		db.execSQL("CREATE TABLE " + TALLA_TABLE_NAME + " ("
            		+ Talla.am_ancho + " TEXT,"
            		+ Talla.am_fondo + " TEXT,"
            		+ Talla.a_largo + " INTEGER,"
            		+ Talla.eu_ancho + " TEXT,"
            		+ Talla.eu_fondo + " TEXT,"
            		+ Talla.eu_largo + " TEXT,"
            		+ Talla.id_prod + " INTEGER,"
            		+ Talla.id_talla + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Talla.num_ancho + " TEXT,"
            		+ Talla.num_fondo + " TEXT,"
            		+ Talla.num_largo + " TEXT"
            		+ ");");
            		db.execSQL("CREATE TABLE " + USUARIO_TABLE_NAME + " ("
            		+ Usuario.clave + " TEXT,"
            		+ Usuario.id_cliente + " INTEGER,"
                    + Usuario.id_empre + " INTEGER,"
            		+ Usuario.id_usuario + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Usuario.nom_usuario + " TEXT,"
            		+ Usuario.tipo_usuario + " INTEGER"
            		+ ");");
            		db.execSQL("CREATE TABLE " + VALOR_NUTRICIONAL_TABLE_NAME + " ("
            		+ Valor_nutricional._requerimientos + " TEXT,"
            		+ Valor_nutricional.cantidad + " INTEGER,"
            		+ Valor_nutricional.id_prod + " INTEGER,"
            		+ Valor_nutricional.id_val_nutri + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Valor_nutricional.nombre_valor + " TEXT,"
            		+ Valor_nutricional.valor_diario_total + " INTEGER"
            		+ ");");
            		db.execSQL("CREATE TABLE " + VENTA_TABLE_NAME + " ("
            		+ Venta.id_carro + " INTEGER,"
            		+ Venta.id_envio + " INTEGER,"
            		+ Venta.id_venta + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            		+ Venta.num_articulos + " INTEGER,"
            		+ Venta.total + " INTEGER"
            		+ ");");
            
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("database helper", "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + PRODUCTO_TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + CARRO_COMPRA_TABLE_NAME);
            onCreate(db);
        }
}
*/