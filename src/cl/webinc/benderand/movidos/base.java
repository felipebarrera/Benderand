package cl.webinc.benderand.movidos;

import android.net.Uri;
import android.provider.BaseColumns;

public final class base {
	public static final String AUTHORITY = "com.ncwebinc.provider.base";

    // This class cannot be instantiated
    private base() {}

	public static class productos implements BaseColumns{
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/productos");
		public static final Uri CONTENT_URI_PROPRE = Uri.parse("content://" + AUTHORITY + "/productospre");
		public static final Uri CONTENT_URI_SERIAL = Uri.parse("content://" + AUTHORITY + "/productos/num_serie");
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
		public static final String DEFAULT_ORDEN = "nom_prod DESC";
		public static final String id_prod = "_id";
        public static final String cod_prod  = "cod_prod";
        public static final String num_serie = "num_serie";
        public static final String descrip_prod  = "descrip_prod";
        public static final String id_subcat = "subcategoria_id_subcat";
        public static final String nom_prod = "nom_prod";
        public static final String marca_prod = "marca_prod";
        public static final String mod_prod = "mod_prod";
        public static final String cont_uni = "cont_uni";
        public static final String uni_min = "uni_min";
        public static final String cont_uni_med = "cont_uni_med";
        public static final String contenido = "contenido";
        public static final String peso_neto = "peso_neto";
        public static final String alto_cm = "alto_cm";
        public static final String ancho_cm = "ancho_cm";
        public static final String fondo_cm = "fondo_cm";
        public static final String fabr = "fabr";
        public static final String fam_nec = "fam_nec";
        public static final String fam_prod = "fam_prod";
        public static final String clase_prod = "clase_prod";
        public static final String linea_prod = "linea_prod";
        public static final String tipo_prod = "tipo_prod";
        public static final String imagen = "imagen";
        public static final String hot = "hot";
	}
    
    public static class Caracteristica implements BaseColumns{
	    public static final Uri CONTENT_URI_CARACTERISTICA = Uri.parse("content://" + AUTHORITY + "/caracteristica");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "valor_carac DESC";
	    public static final String carac = "carac";
	    public static final String id_caract = "_id";
	    public static final String num_carac = "num_carac";
	    public static final String valor_carac = "valor_carac";
	}

	public static class Carro_compras implements BaseColumns{
		public static final Uri CONTENT_URI_CARRO_COMPRAS = Uri.parse("content://" + AUTHORITY + "/carrocompras");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "producto_id_prod DESC";
	    public static final String cant = "cant";
	    public static final String id_carro = "_id";
	    public static final String id_empre = "empresa_id_empre";
	    public static final String id_prod = "producto_id_prod";
	    public static final String id_usuario = "usuario_id_usuario";
	    public static final String precio = "precio";
	}

	public static class Carro_venta implements BaseColumns{
	    public static final Uri CONTENT_URI_CARRO_VENTA = Uri.parse("content://" + AUTHORITY + "/carro_venta");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "id_prod DESC";
	    public static final String cant = "cant";
	    public static final String id_carro = "carro_compra_id_carro";
	    public static final String id_carventa = "_id";
	    public static final String id_empre = "empresa_id_empre";
	    public static final String id_prod = "producto_id_prod";
	    public static final String id_usuario = "usuario_id_usuario";
	    public static final String precio = "precio";
	}

	public static class Categoria implements BaseColumns{
	    public static final Uri CONTENT_URI_CATEGORIA = Uri.parse("content://" + AUTHORITY + "/categoria");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "nom_categoria DESC";
	    public static final String Id_categoria = "_id";
	    public static final String nom_categoria = "nom_categoria";
	}

	public static class Cliente implements BaseColumns{
	    public static final Uri CONTENT_URI_CLIENTE = Uri.parse("content://" + AUTHORITY + "/cliente");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "apelli_cliente DESC";
	    public static final String actividad = "actividad";
	    public static final String ano_fecnac = "ano_fecnac";
	    public static final String apelli2_cliente = "apelli2_cliente";
	    public static final String apelli_cliente = "apelli_cliente";
	    public static final String area_activ = "area_activ";
	    public static final String calle_res = "calle_res";
	    public static final String celfono = "celfono";
	    public static final String ciudad_cliente = "ciudad_cliente";
	    public static final String comuna_res = "comuna_res";
	    public static final String dia_fecnac = "dia_fecnac";
	    public static final String dig_ver = "dig_ver";
	    public static final String edad = "edad";
	    public static final String email = "email";
	    public static final String id_cliente = "_id";
	    public static final String mes_fecnac = "mes_fecnac";
	    public static final String nacionalidad = "nacionalidad";
	    public static final String nom2_cliente = "nom2_cliente";
	    public static final String nom_cliente = "nom_cliente";
	    public static final String numerodp = "numerodp";
	    public static final String num_res = "num_res";
	    public static final String rut_cliente = "rut_cliente";
	    public static final String sector = "sector";
	    public static final String telefono = "telefono";
	}

	public static class Comuna implements BaseColumns{
	    public static final Uri CONTENT_URI_COMUNA = Uri.parse("content://" + AUTHORITY + "/comuna");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "nom_comuna DESC";
	    public static final String id_comuna = "_id";
	    public static final String nom_comuna = "nom_comuna";
	}

	public static class Empresa implements BaseColumns{
	    public static final Uri CONTENT_URI_EMPRESA = Uri.parse("content://" + AUTHORITY + "/empresa");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "rut_empre DESC";
	    public static final String alcance_empre = "alcance_empre";
	    public static final String calle_empre = "calle_empre";
	    public static final String cargo_cont_empre = "cargo_cont_empre";
	    public static final String comuna_empre = "comuna_empre";
	    public static final String dig_verifi_empre = "dig_verifi_empre";
	    public static final String email_empre = "email_empre";
	    public static final String giro_empre = "giro_empre";
	    public static final String id_empre = "_id";
	    public static final String nombre_empre = "nombre_empre";
	    public static final String nom_cont_empre = "nom_cont_empre";
	    public static final String numero_empre = "numero_empre";
	    public static final String rut_empre = "rut_empre";
	    public static final String sector_empre = "sector_empre";
	    public static final String telefono_empre = "telefono_empre";
	}

	public static class Envio implements BaseColumns{
	    public static final Uri CONTENT_URI_ENVIO = Uri.parse("content://" + AUTHORITY + "/envio");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "fec_entre DESC";
	    public static final String alt_dir = "alt_dir";
	    public static final String fec_entre = "fec_entre";
	    public static final String hor_entr = "hor_entr";
	    public static final String id_envio = "_id";
	    public static final String id_venta = "venta_id_venta";
	}

	public static class Factura implements BaseColumns{
	    public static final Uri CONTENT_URI_FACTURA = Uri.parse("content://" + AUTHORITY + "/factura");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "rol DESC";
	    public static final String ano = "ano";
	    public static final String dia = "dia";
	    public static final String id_empresa = "empresa_id_empresa";
	    public static final String id_factura = "_id";
	    public static final String mes = "mes";
	    public static final String rol = "rol";
	}

	public static class Gasto implements BaseColumns{
	    public static final Uri CONTENT_URI_GASTO = Uri.parse("content://" + AUTHORITY + "/gasto");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "fecha_gasto DESC";
	    public static final String id_gasto = "_id";
	    public static final String nombre_gasto = "nombre_gasto";
	    public static final String monto_gasto = "monto_gasto";
	    public static final String id_usuario = "carne.id_usuario";
	    public static final String fecha_gasto = "fecha_gasto";
	}

	public static class Item_factura implements BaseColumns{
	    public static final Uri CONTENT_URI_ITEM_FACTURA = Uri.parse("content://" + AUTHORITY + "/item_factura");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "id_itemfactura DESC";
	    public static final String cant = "cant";
	    public static final String id_factura = "factura_id_factura";
	    public static final String id_itemfactura = "_id";
	    public static final String id_prod = "producto_id_prod";
	    public static final String precio = "precio";
	}

	public static class Precio implements BaseColumns{
	    public static final Uri CONTENT_URI_PRECIO = Uri.parse("content://" + AUTHORITY + "/precio");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "id_precio DESC";
	    public static final String id_empre = "empresa_id_empre";
	    public static final String id_precio = "_id";
	    public static final String id_prod = "producto_id_prod";
	    public static final String p_pes_ch = "p_pes_ch";
	    public static final String p_us = "p_us";
	}

	public static class Stock implements BaseColumns{
	    public static final Uri CONTENT_URI_STOCK = Uri.parse("content://" + AUTHORITY + "/stock");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "last_update DESC";
	    public static final String id_prod = "producto_id_prod";
	    public static final String id_stock = "_id";
	    public static final String last_update = "last_update";
	    public static final String stock_ideal = "stock_ideal";
	    public static final String stock_minimo = "stock_minimo";
	    public static final String stock_real = "stock_real";
	    public static final String stock_tienda = "stock_tienda";
	    public static final String stock_vendido = "stock_vendido";
	    public static final String stock_virtual = "stock_virtual";
	}

	public static class Subcategoria implements BaseColumns{
	    public static final Uri CONTENT_URI_SUBCATEGORIA = Uri.parse("content://" + AUTHORITY + "/subcategoria");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "nom_subcat DESC";
	    public static final String id_categoria = "categoria_id_categoria";
	    public static final String id_subcat = "_id";
	    public static final String nom_subcat = "nom_subcat";
	}

	public static class Talla implements BaseColumns{
	    public static final Uri CONTENT_URI_TALLA = Uri.parse("content://" + AUTHORITY + "/talla");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "id_talla DESC";
	    public static final String am_ancho = "am_ancho";
	    public static final String am_fondo = "am_fondo";
	    public static final String a_largo = "a_ largo";
	    public static final String eu_ancho = "eu_ancho";
	    public static final String eu_fondo = "eu_fondo";
	    public static final String eu_largo = "eu_largo";
	    public static final String id_prod = "producto_id_prod";
	    public static final String id_talla = "_id";
	    public static final String num_ancho = "num_ancho";
	    public static final String num_fondo = "num_fondo";
	    public static final String num_largo = "num_largo";
	}

	public static class Usuario implements BaseColumns{
	    public static final Uri CONTENT_URI_USUARIO = Uri.parse("content://" + AUTHORITY + "/usuario");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "tipo_usuario DESC";
	    public static final String clave = "clave";
	    public static final String id_cliente = "cliente_id_cliente";
	    public static final String id_usuario = "_id";
	    public static final String nom_usuario = "nom_usuario";
	    public static final String tipo_usuario = "tipo_usuario";
	    public static final String id_empre = "empresa_id_empresa";
	}

	public static class Valor_nutricional implements BaseColumns{
	    public static final Uri CONTENT_URI_VALOR_NUTRICIONAL = Uri.parse("content://" + AUTHORITY + "/valor_nutricional");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "id_val_nutri DESC";
	    public static final String _requerimientos = "_requerimientos";
	    public static final String cantidad = "cantidad";
	    public static final String id_prod = "producto_id_prod";
	    public static final String id_val_nutri = "_id";
	    public static final String nombre_valor = "nombre_valor";
	    public static final String valor_diario_total = "valor_diario_total";
	}

	public static class Venta implements BaseColumns{
	    public static final Uri CONTENT_URI_VENTA = Uri.parse("content://" + AUTHORITY + "/venta");
	    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
	    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
	    public static final String DEFAULT_ORDEN = "id_carro DESC";
	    public static final String id_carro = "carro_venta_id_carro";
	    public static final String id_envio = "envio_id_envio";
	    public static final String id_venta = "_id";
	    public static final String num_articulos = "num_articulos";
	    public static final String total = "total";
	}

}
