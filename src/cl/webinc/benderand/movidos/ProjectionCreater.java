/*package cl.webinc.benderand.movidos;

import cl.webinc.benderand.provider.base.Usuario;

import com.ncwebinc.producto.provider.base.Caracteristica;
import com.ncwebinc.producto.provider.base.Carro_compras;
import com.ncwebinc.producto.provider.base.Carro_venta;
import com.ncwebinc.producto.provider.base.Categoria;
import com.ncwebinc.producto.provider.base.Cliente;
import com.ncwebinc.producto.provider.base.Comuna;
import com.ncwebinc.producto.provider.base.Empresa;
import com.ncwebinc.producto.provider.base.Envio;
import com.ncwebinc.producto.provider.base.Factura;
import com.ncwebinc.producto.provider.base.Item_factura;
import com.ncwebinc.producto.provider.base.Precio;
import com.ncwebinc.producto.provider.base.Stock;
import com.ncwebinc.producto.provider.base.Subcategoria;
import com.ncwebinc.producto.provider.base.Talla;
import com.ncwebinc.producto.provider.base.Valor_nutricional;
import com.ncwebinc.producto.provider.base.Venta;
import com.ncwebinc.producto.provider.base.productos;

public final class ProjectionCreater 
{
	public static final String[] caracteristica =
			new String[] {
			Caracteristica.carac,
			Caracteristica.id_caract,
			Caracteristica.num_carac,
			Caracteristica.valor_carac,
			};
			public static final String[] carro_compras =
			new String[] {
			carro_compras.cant,
			carro_compras.id_carro,
			carro_compras.id_empre,
			carro_compras.id_prod,
			carro_compras.id_usuario,
			carro_compras.precio,
			};
			public static final String[] carro_venta =
			new String[] {
			Carro_venta.cant,
			Carro_venta.id_carro,
			Carro_venta.id_carventa,
			Carro_venta.id_empre,
			Carro_venta.id_prod,
			Carro_venta.id_usuario,
			Carro_venta.precio,
			};
			public static final String[] categoria =
			new String[] {
			Categoria.Id_categoria,
			Categoria.nom_categoria,
			};
			public static final String[] cliente =
			new String[] {
			Cliente.actividad,
			Cliente.ano_fecnac,
			Cliente.apelli2_cliente,
			Cliente.apelli_cliente,
			Cliente.area_activ,
			Cliente.calle_res,
			Cliente.celfono,
			Cliente.ciudad_cliente,
			Cliente.comuna_res,
			Cliente.dia_fecnac,
			Cliente.dig_ver,
			Cliente.edad,
			Cliente.email,
			Cliente.id_cliente,
			Cliente.mes_fecnac,
			Cliente.nacionalidad,
			Cliente.nom2_cliente,
			Cliente.nom_cliente,
			Cliente.numerodp,
			Cliente.num_res,
			Cliente.rut_cliente,
			Cliente.sector,
			Cliente.telefono,
			};
			public static final String[] comuna =
			new String[] {
			Comuna.id_comuna,
			Comuna.nom_comuna,
			};
			public static final String[] empresa =
			new String[] {
			Empresa.alcance_empre,
			Empresa.calle_empre,
			Empresa.cargo_cont_empre,
			Empresa.comuna_empre,
			Empresa.dig_verifi_empre,
			Empresa.email_empre,
			Empresa.giro_empre,
			Empresa.id_empre,
			Empresa.nombre_empre,
			Empresa.nom_cont_empre,
			Empresa.numero_empre,
			Empresa.rut_empre,
			Empresa.sector_empre,
			Empresa.telefono_empre,
			};
			public static final String[] envio =
			new String[] {
			Envio.alt_dir,
			Envio.fec_entre,
			Envio.hor_entr,
			Envio.id_envio,
			Envio.id_venta,
			};
			public static final String[] factura =
			new String[] {
			Factura.ano,
			Factura.dia,
			Factura.id_empresa,
			Factura.id_factura,
			Factura.mes,
			Factura.rol,
			};
			public static final String[] item_factura =
			new String[] {
			Item_factura.cant,
			Item_factura.id_factura,
			Item_factura.id_itemfactura,
			Item_factura.id_prod,
			Item_factura.precio,
			};
			public static final String[] precio =
			new String[] {
			Precio.id_empre,
			Precio.id_precio,
			Precio.id_prod,
			Precio.p_pes_ch,
			Precio.p_us,
			};
			public static final String[] producto =
			new String[] {
			productos.alto_cm,
			productos.ancho_cm,
			productos.clase_prod,
			productos.cod_prod,
			productos.contenido,
			productos.cont_uni,
			productos.cont_uni_med,
			productos.descrip_prod,
			productos.fabr,
			productos.fam_nec,
			productos.fam_prod,
			productos.fondo_cm,
			productos.id_prod,
			productos.id_subcat,
			productos.imagen,
			productos.linea_prod,
			productos.marca_prod,
			productos.mod_prod,
			productos.nom_prod,
			productos.num_serie,
			productos.peso_neto,
			productos.tipo_prod,
			productos.uni_min,
			};
			public static final String[] stock =
			new String[] {
			Stock.id_prod,
			Stock.id_stock,
			Stock.last_update,
			Stock.stock_ideal,
			Stock.stock_minimo,
			Stock.stock_real,
			Stock.stock_tienda,
			Stock.stock_vendido,
			Stock.stock_virtual,
			};
			public static final String[] subcategoria =
			new String[] {
			Subcategoria.id_categoria,
			Subcategoria.id_subcat,
			Subcategoria.nom_subcat,
			};
			public static final String[] talla =
			new String[] {
			Talla.am_ancho,
			Talla.am_fondo,
			Talla.a_largo,
			Talla.eu_ancho,
			Talla.eu_fondo,
			Talla.eu_largo,
			Talla.id_prod,
			Talla.id_talla,
			Talla.num_ancho,
			Talla.num_fondo,
			Talla.num_largo,
			};
			public static final String[] usuario =
			new String[] {
			Usuario.clave,
			Usuario.id_cliente,
			Usuario.id_usuario,
			Usuario.nom_usuario,
			Usuario.tipo_usuario,
			};
			public static final String[] valor_nutricional =
			new String[] {
			Valor_nutricional._requerimientos,
			Valor_nutricional.cantidad,
			Valor_nutricional.id_prod,
			Valor_nutricional.id_val_nutri,
			Valor_nutricional.nombre_valor,
			Valor_nutricional.valor_diario_total,
			};
			public static final String[] venta =
			new String[] {
			Venta.id_carro,
			Venta.id_envio,
			Venta.id_venta,
			Venta.num_articulos,
			Venta.total,
			};
}
*/