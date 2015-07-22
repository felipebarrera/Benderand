package cl.webinc.benderand.movidos;

import android.net.Uri;
import android.provider.BaseColumns;

public final class BaseWeb {
	public static final String AUTHORITY = "www.webinc.cl";

	// This class cannot be instantiated
	private BaseWeb() {}

	public static class productos implements BaseColumns{
		public static final String CONTENT_URI = "content://" + AUTHORITY + "/productos";
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
		public static final String DEFAULT_ORDEN = "nom_prod DESC";
		public static final String RAWQUERY = "SELECT * FROM producto p INNER JOIN precio " +
				" on precio.producto_id_prod = p._id";
		public static final String RAWQUERY_ID = "SELECT * FROM producto p INNER JOIN precio " +
				" on precio.producto_id_prod = p._id WHERE p._id = ";
		public static final String RAWQUERYSERIAL = "SELECT * FROM producto p INNER JOIN precio " +
				" on precio.producto_id_prod = p._id WHERE p.num_serie = ";
		public static final String id_prod = "_id";
		public static final String alto_cm = "alto_cm";		
		public static final String ancho_cm = "ancho_cm";
		public static final String clase_prod = "clase_prod";
		public static final String cod_prod = "cod_prod";
		public static final String contenido = "contenido";
		public static final String cont_uni = "cont_uni";
		public static final String cont_uni_med = "cont_uni_med";
		public static final String descrip_prod = "descrip_prod";
		public static final String fabr = "fabr";
		public static final String fam_nec = "fam_nec";
		public static final String fam_prod = "fam_prod";
		public static final String fondo_cm = "fondo_cm";
		public static final String hot = "hot";
		public static final String linea_prod = "linea_prod";
		public static final String marca_prod = "marca_prod";
		public static final String mod_prod = "mod_prod";
		public static final String nom_prod = "nom_prod";
		public static final String num_serie = "num_serie";
		public static final String peso_neto = "peso_neto";
		public static final String SKU = "SKU";
		public static final String subcategoria_id_subcat = "subcategoria_id_subcat";
		public static final String tipo_prod = "tipo_prod";
		public static final String uni_min = "uni_min";
	}

	public static class Precio implements BaseColumns{
		public static final Uri CONTENT_URI_PRECIO = Uri.parse("content://" + AUTHORITY + "/precio");
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.prod";
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.prod";
		public static final String DEFAULT_ORDEN = "_id DESC";
		public static final String id_precio = "id_precio";
		public static final String empresa_id_empre = "empresa_id_empre";
		public static final String cant_mayor = "cant_mayor";
		public static final String producto_id_prod = "producto_id_prod";
		public static final String p_mayor_p_ch = "p_mayor_p_ch";
		public static final String p_mayor_p_ch_ant = "p_mayor_p_ch_ant";
		public static final String p_mayor_us = "p_mayor_us";
		public static final String p_pes_ch = "p_pes_ch";
		public static final String p_pes_ch_ant = "p_pes_ch_ant";
		public static final String p_us = "p_us";
		public static final String v_mayor = "v_mayor";
	}

}
