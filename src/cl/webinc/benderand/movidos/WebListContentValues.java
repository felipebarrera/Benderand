/*package cl.webinc.benderand.movidos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cl.webinc.benderand.provider.base.Caracteristica;
import cl.webinc.benderand.provider.base.Carro_venta;
import cl.webinc.benderand.provider.base.Categoria;
import cl.webinc.benderand.provider.base.Cliente;
import cl.webinc.benderand.provider.base.Comuna;
import cl.webinc.benderand.provider.base.Empresa;
import cl.webinc.benderand.provider.base.Envio;
import cl.webinc.benderand.provider.base.Factura;
import cl.webinc.benderand.provider.base.Item_factura;
import cl.webinc.benderand.provider.base.Precio;
import cl.webinc.benderand.provider.base.Stock;
import cl.webinc.benderand.provider.base.Subcategoria;
import cl.webinc.benderand.provider.base.Talla;
import cl.webinc.benderand.provider.base.Usuario;
import cl.webinc.benderand.provider.base.Valor_nutricional;
import cl.webinc.benderand.provider.base.Venta;
import android.content.ContentValues;

public class WebListContentValues
	{
		public ContentValues caracteristica(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("caracteristica");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Caracteristica.carac, e.getString(Caracteristica.carac));
				values.put(Caracteristica.id_caract, e.getString(Caracteristica.id_caract));
				values.put(Caracteristica.num_carac, e.getString(Caracteristica.num_carac));
				values.put(Caracteristica.valor_carac, e.getString(Caracteristica.valor_carac));
			}
			return values;
		}
		public ContentValues carro_compras(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("carro_compras");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(carro_compras.cant_carro, e.getString(carro_compras.cant_carro));
				values.put(carro_compras.id_carro, e.getString(carro_compras.id_carro));
				values.put(carro_compras.empresa_id_empre, e.getString(carro_compras.empresa_id_empre));
				values.put(carro_compras.producto_id_prod, e.getString(carro_compras.producto_id_prod));
				values.put(carro_compras.carne_id_usuario, e.getString(carro_compras.carne_id_usuario));
				values.put(carro_compras.mayor, e.getString(carro_compras.mayor));
				values.put(carro_compras.precio_carro, e.getString(carro_compras.precio_carro));
				values.put(carro_compras.tienda, e.getString(carro_compras.tienda));
				values.put(carro_compras.usado, e.getString(carro_compras.usado));
				values.put(carro_compras.carne_empresa_id_carne_empresa, e.getString(carro_compras.carne_empresa_id_carne_empresa));
			}
			return values;
		}
		public ContentValues carro_venta(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("carro_venta");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Carro_venta.cant, e.getString(Carro_venta.cant));
				values.put(Carro_venta.id_carro, e.getString(Carro_venta.id_carro));
				values.put(Carro_venta.id_carventa, e.getString(Carro_venta.id_carventa));
				values.put(Carro_venta.id_empre, e.getString(Carro_venta.id_empre));
				values.put(Carro_venta.id_prod, e.getString(Carro_venta.id_prod));
				values.put(Carro_venta.id_usuario, e.getString(Carro_venta.id_usuario));
				values.put(Carro_venta.precio, e.getString(Carro_venta.precio));
			}
			return values;
		}
		public ContentValues categoria(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("categoria");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Categoria.Id_categoria, e.getString(Categoria.Id_categoria));
				values.put(Categoria.nom_categoria, e.getString(Categoria.nom_categoria));
			}
			return values;
		}
		public ContentValues cliente(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("cliente");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Cliente.actividad, e.getString(Cliente.actividad));
				values.put(Cliente.ano_fecnac, e.getString(Cliente.ano_fecnac));
				values.put(Cliente.apelli2_cliente, e.getString(Cliente.apelli2_cliente));
				values.put(Cliente.apelli_cliente, e.getString(Cliente.apelli_cliente));
				values.put(Cliente.area_activ, e.getString(Cliente.area_activ));
				values.put(Cliente.calle_res, e.getString(Cliente.calle_res));
				values.put(Cliente.celfono, e.getString(Cliente.celfono));
				values.put(Cliente.ciudad_cliente, e.getString(Cliente.ciudad_cliente));
				values.put(Cliente.comuna_res, e.getString(Cliente.comuna_res));
				values.put(Cliente.dia_fecnac, e.getString(Cliente.dia_fecnac));
				values.put(Cliente.dig_ver, e.getString(Cliente.dig_ver));
				values.put(Cliente.edad, e.getString(Cliente.edad));
				values.put(Cliente.email, e.getString(Cliente.email));
				values.put(Cliente.id_cliente, e.getString(Cliente.id_cliente));
				values.put(Cliente.mes_fecnac, e.getString(Cliente.mes_fecnac));
				values.put(Cliente.nacionalidad, e.getString(Cliente.nacionalidad));
				values.put(Cliente.nom2_cliente, e.getString(Cliente.nom2_cliente));
				values.put(Cliente.nom_cliente, e.getString(Cliente.nom_cliente));
				values.put(Cliente.numerodp, e.getString(Cliente.numerodp));
				values.put(Cliente.num_res, e.getString(Cliente.num_res));
				values.put(Cliente.rut_cliente, e.getString(Cliente.rut_cliente));
				values.put(Cliente.sector, e.getString(Cliente.sector));
				values.put(Cliente.telefono, e.getString(Cliente.telefono));
			}
			return values;
		}
		public ContentValues comuna(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("comuna");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Comuna.id_comuna, e.getString(Comuna.id_comuna));
				values.put(Comuna.nom_comuna, e.getString(Comuna.nom_comuna));
			}
			return values;
		}
		public ContentValues empresa(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("empresa");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Empresa.alcance_empre, e.getString(Empresa.alcance_empre));
				values.put(Empresa.cargo_cont_empre, e.getString(Empresa.cargo_cont_empre));
				values.put(Empresa.dig_verifi_empre, e.getString(Empresa.dig_verifi_empre));
				values.put(Empresa.email_empre, e.getString(Empresa.email_empre));
				values.put(Empresa.id_empre, e.getString(Empresa.id_empre));
				values.put(Empresa.nombre_empre, e.getString(Empresa.nombre_empre));
				values.put(Empresa.nom_cont_empre, e.getString(Empresa.nom_cont_empre));
				values.put(Empresa.rut_empre, e.getString(Empresa.rut_empre));
				values.put(Empresa.telefono_empre, e.getString(Empresa.telefono_empre));
			}
			return values;
		}
		public ContentValues envio(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("envio");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Envio.alt_dir, e.getString(Envio.alt_dir));
				values.put(Envio.fec_entre, e.getString(Envio.fec_entre));
				values.put(Envio.hor_entr, e.getString(Envio.hor_entr));
				values.put(Envio.id_envio, e.getString(Envio.id_envio));
				values.put(Envio.id_venta, e.getString(Envio.id_venta));
			}
			return values;
		}
		public ContentValues factura(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("factura");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Factura.ano, e.getString(Factura.ano));
				values.put(Factura.dia, e.getString(Factura.dia));
				values.put(Factura.id_empresa, e.getString(Factura.id_empresa));
				values.put(Factura.id_factura, e.getString(Factura.id_factura));
				values.put(Factura.mes, e.getString(Factura.mes));
				values.put(Factura.rol, e.getString(Factura.rol));
			}
			return values;
		}
		public ContentValues item_factura(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("item_factura");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Item_factura.cant, e.getString(Item_factura.cant));
				values.put(Item_factura.id_factura, e.getString(Item_factura.id_factura));
				values.put(Item_factura.id_itemfactura, e.getString(Item_factura.id_itemfactura));
				values.put(Item_factura.id_prod, e.getString(Item_factura.id_prod));
				values.put(Item_factura.precio, e.getString(Item_factura.precio));
			}
			return values;
		}
		public ContentValues precio(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("precio");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Precio.empresa_id_empre, e.getString(Precio.empresa_id_empre));
				values.put(Precio.id_precio, e.getString(Precio.id_precio));
				values.put(Precio.producto_id_prod, e.getString(Precio.producto_id_prod));
				values.put(Precio.p_pes_ch, e.getString(Precio.p_pes_ch));
				values.put(Precio.p_us, e.getString(Precio.p_us));
			}
			return values;
		}
		public ContentValues producto(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("producto");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(productos.alto_cm, e.getString(productos.alto_cm));
				values.put(productos.ancho_cm, e.getString(productos.ancho_cm));
				values.put(productos.clase_prod, e.getString(productos.clase_prod));
				values.put(productos.cod_prod, e.getString(productos.cod_prod));
				values.put(productos.contenido, e.getString(productos.contenido));
				values.put(productos.cont_uni, e.getString(productos.cont_uni));
				values.put(productos.cont_uni_med, e.getString(productos.cont_uni_med));
				values.put(productos.descrip_prod, e.getString(productos.descrip_prod));
				values.put(productos.fabr, e.getString(productos.fabr));
				values.put(productos.fam_nec, e.getString(productos.fam_nec));
				values.put(productos.fam_prod, e.getString(productos.fam_prod));
				values.put(productos.fondo_cm, e.getString(productos.fondo_cm));
				values.put(productos.id_prod, e.getString(productos.id_prod));
				values.put(productos.subcategoria_id_subcat, e.getString(productos.subcategoria_id_subcat));
				values.put(productos.linea_prod, e.getString(productos.linea_prod));
				values.put(productos.marca_prod, e.getString(productos.marca_prod));
				values.put(productos.mod_prod, e.getString(productos.mod_prod));
				values.put(productos.nom_prod, e.getString(productos.nom_prod));
				values.put(productos.num_serie, e.getString(productos.num_serie));
				values.put(productos.peso_neto, e.getString(productos.peso_neto));
				values.put(productos.tipo_prod, e.getString(productos.tipo_prod));
				values.put(productos.uni_min, e.getString(productos.uni_min));
			}
			return values;
		}
		public ContentValues stock(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("stock");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Stock.id_prod, e.getString(Stock.id_prod));
				values.put(Stock.id_stock, e.getString(Stock.id_stock));
				values.put(Stock.last_update, e.getString(Stock.last_update));
				values.put(Stock.stock_ideal, e.getString(Stock.stock_ideal));
				values.put(Stock.stock_minimo, e.getString(Stock.stock_minimo));
				values.put(Stock.stock_real, e.getString(Stock.stock_real));
				values.put(Stock.stock_tienda, e.getString(Stock.stock_tienda));
				values.put(Stock.stock_vendido, e.getString(Stock.stock_vendido));
				values.put(Stock.stock_virtual, e.getString(Stock.stock_virtual));
			}
			return values;
		}
		public ContentValues subcategoria(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("subcategoria");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Subcategoria.id_categoria, e.getString(Subcategoria.id_categoria));
				values.put(Subcategoria.id_subcat, e.getString(Subcategoria.id_subcat));
				values.put(Subcategoria.nom_subcat, e.getString(Subcategoria.nom_subcat));
			}
			return values;
		}
		public ContentValues talla(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("talla");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Talla.am_ancho, e.getString(Talla.am_ancho));
				values.put(Talla.am_fondo, e.getString(Talla.am_fondo));
				values.put(Talla.a_largo, e.getString(Talla.a_largo));
				values.put(Talla.eu_ancho, e.getString(Talla.eu_ancho));
				values.put(Talla.eu_fondo, e.getString(Talla.eu_fondo));
				values.put(Talla.eu_largo, e.getString(Talla.eu_largo));
				values.put(Talla.id_prod, e.getString(Talla.id_prod));
				values.put(Talla.id_talla, e.getString(Talla.id_talla));
				values.put(Talla.num_ancho, e.getString(Talla.num_ancho));
				values.put(Talla.num_fondo, e.getString(Talla.num_fondo));
				values.put(Talla.num_largo, e.getString(Talla.num_largo));
			}
			return values;
		}
		public ContentValues usuario(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("usuario");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Usuario.clave, e.getString(Usuario.clave));
				values.put(Usuario.id_cliente, e.getString(Usuario.id_cliente));
				values.put(Usuario.id_usuario, e.getString(Usuario.id_usuario));
				values.put(Usuario.nom_usuario, e.getString(Usuario.nom_usuario));
				values.put(Usuario.tipo_usuario, e.getString(Usuario.tipo_usuario));
			}
			return values;
		}
		public ContentValues valor_nutricional(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("valor_nutricional");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Valor_nutricional._requerimientos, e.getString(Valor_nutricional._requerimientos));
				values.put(Valor_nutricional.cantidad, e.getString(Valor_nutricional.cantidad));
				values.put(Valor_nutricional.id_prod, e.getString(Valor_nutricional.id_prod));
				values.put(Valor_nutricional.id_val_nutri, e.getString(Valor_nutricional.id_val_nutri));
				values.put(Valor_nutricional.nombre_valor, e.getString(Valor_nutricional.nombre_valor));
				values.put(Valor_nutricional.valor_diario_total, e.getString(Valor_nutricional.valor_diario_total));
			}
			return values;
		}
		public ContentValues venta(JSONObject json) throws JSONException
		{
			JSONArray jArray;
			jArray = json.getJSONArray("venta");
			ContentValues values;
			values = new ContentValues();
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				values.put(Venta.id_carro, e.getString(Venta.id_carro));
				values.put(Venta.id_envio, e.getString(Venta.id_envio));
				values.put(Venta.id_venta, e.getString(Venta.id_venta));
				values.put(Venta.num_articulos, e.getString(Venta.num_articulos));
				values.put(Venta.total, e.getString(Venta.total));
			}
			return values;
		}

	}
*/