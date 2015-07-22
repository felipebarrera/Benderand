/*package cl.webinc.benderand.movidos;


import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import cl.webinc.benderand.provider.base.Actividad;
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

public class WebListMap 
{
	public String TAG = "WebListMap";
	public ArrayList<HashMap<String, String>> jsonToHashMap(JSONObject json, String funcion) throws JSONException
	{
		Log.e(TAG, funcion);
		JSONArray jArray;
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		if(funcion.equals("spinneractividad"))
		{
			jArray = json.getJSONArray("actividad");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Actividad.id_actividad, e.getString(Actividad.id_actividad));
				map.put(Actividad.nombre_actividad, e.getString(Actividad.nombre_actividad));
				map.put(Actividad.codigo_actividad, e.getString(Actividad.codigo_actividad));
				mylist.add(map);
			}
		}
		if(funcion.equals("actividad"))
		{
			jArray = json.getJSONArray("actividad");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Actividad.afectoiva_actividad, e.getString(Actividad.afectoiva_actividad));
				map.put(Actividad.categoria_actividad, e.getString(Actividad.categoria_actividad));
				map.put(Actividad.codigo_actividad, e.getString(Actividad.codigo_actividad));
				map.put(Actividad.disponible_internet_actividad, e.getString(Actividad.disponible_internet_actividad));
				map.put(Actividad.id_actividad, e.getString(Actividad.id_actividad));
				map.put(Actividad.nombre_actividad, e.getString(Actividad.nombre_actividad));
				map.put(Actividad.subrubro_id_subrubro, e.getString(Actividad.subrubro_id_subrubro));
				mylist.add(map);
			}
		}
		if(funcion.equals("caracteristica"))
		{
			jArray = json.getJSONArray("caracteristica");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Caracteristica.carac, e.getString(Caracteristica.carac));
				map.put(Caracteristica.id_caract, e.getString(Caracteristica.id_caract));
				map.put(Caracteristica.num_carac, e.getString(Caracteristica.num_carac));
				map.put(Caracteristica.valor_carac, e.getString(Caracteristica.valor_carac));
				mylist.add(map);
			}
		}
		if(funcion.equals("carro_compras"))
		{
			jArray = json.getJSONArray("carro_compras");
			Long total = Long.valueOf(0);
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				Long subtotal = e.getLong(carro_compras.cant_carro) * e.getLong(carro_compras.precio_carro) ;
				total = total + subtotal;
				map.put("total", total.toString());
				map.put("subtotal", subtotal.toString());
				map.put(carro_compras.cant_carro, e.getString(carro_compras.cant_carro));
				map.put(carro_compras.id_carro, e.getString(carro_compras.id_carro));
				map.put(carro_compras.empresa_id_empre, e.getString(carro_compras.empresa_id_empre));
				map.put(carro_compras.producto_id_prod, e.getString(carro_compras.producto_id_prod));
				map.put(carro_compras.carne_id_usuario, e.getString(carro_compras.carne_id_usuario));
				map.put(carro_compras.mayor, e.getString(carro_compras.mayor));
				map.put(carro_compras.precio_carro, e.getString(carro_compras.precio_carro));
				map.put(carro_compras.tienda, e.getString(carro_compras.tienda));
				map.put(carro_compras.usado, e.getString(carro_compras.usado));
				map.put(carro_compras.carne_empresa_id_carne_empresa, e.getString(carro_compras.carne_empresa_id_carne_empresa));
				map.put("alto_cm", e.getString("alto_cm"));
				map.put("ancho_cm", e.getString("ancho_cm"));
				map.put("clase_prod", e.getString("clase_prod"));
				map.put("cod_prod", e.getString("cod_prod"));
				map.put("contenido", e.getString("contenido"));
				map.put("cont_uni", e.getString("cont_uni"));
				map.put("cont_uni_med", e.getString("cont_uni_med"));
				map.put("descrip_prod", e.getString("descrip_prod"));
				map.put("fabr", e.getString("fabr"));
				map.put("fam_nec", e.getString("fam_nec"));
				map.put("fam_prod", e.getString("fam_prod"));
				map.put("fondo_cm", e.getString("fondo_cm"));
				map.put("id_prod", e.getString("id_prod"));
				map.put("id_subcat", e.getString("subcategoria_id_subcat"));
				map.put("linea_prod", e.getString("linea_prod"));
				map.put("marca_prod", e.getString("marca_prod"));
				map.put("mod_prod", e.getString("mod_prod"));
				map.put("nom_prod", e.getString("nom_prod"));
				map.put("num_serie", e.getString("num_serie"));
				map.put("peso_neto", e.getString("peso_neto"));
				map.put("tipo_prod", e.getString("tipo_prod"));
				map.put("uni_min", e.getString("uni_min"));
				map.put(Precio.empresa_id_empre, e.getString(Precio.empresa_id_empre));
				map.put(Precio.id_precio, e.getString(Precio.id_precio));
				map.put(Precio.producto_id_prod, e.getString(Precio.producto_id_prod));
				map.put(Precio.p_pes_ch, e.getString(Precio.p_pes_ch));
				map.put(Precio.p_us, e.getString(Precio.p_us));
				map.put(Precio.p_mayor_p_ch, e.getString(Precio.p_mayor_p_ch));
				map.put(Precio.cant_mayor, e.getString(Precio.cant_mayor));
				Log.e(TAG, e.getString(carro_compras.id_carro));
				mylist.add(map);
			}
		}
		if(funcion.equals("carro_venta"))
		{
			jArray = json.getJSONArray("carro_venta");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Carro_venta.cant, e.getString(Carro_venta.cant));
				map.put(Carro_venta.id_carro, e.getString(Carro_venta.id_carro));
				map.put(Carro_venta.id_carventa, e.getString(Carro_venta.id_carventa));
				map.put(Carro_venta.id_empre, e.getString(Carro_venta.id_empre));
				map.put(Carro_venta.id_prod, e.getString(Carro_venta.id_prod));
				map.put(Carro_venta.id_usuario, e.getString(Carro_venta.id_usuario));
				map.put(Carro_venta.precio, e.getString(Carro_venta.precio));
				mylist.add(map);
			}
		}
		if(funcion.equals("categoria"))
		{
			jArray = json.getJSONArray("categoria");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Categoria.Id_categoria, e.getString(Categoria.Id_categoria));
				map.put(Categoria.nom_categoria, e.getString(Categoria.nom_categoria));
				mylist.add(map);
			}
		}
		if(funcion.equals("cliente"))
		{
			jArray = json.getJSONArray("cliente");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Cliente.actividad, e.getString(Cliente.actividad));
				map.put(Cliente.ano_fecnac, e.getString(Cliente.ano_fecnac));
				map.put(Cliente.apelli2_cliente, e.getString(Cliente.apelli2_cliente));
				map.put(Cliente.apelli_cliente, e.getString(Cliente.apelli_cliente));
				map.put(Cliente.area_activ, e.getString(Cliente.area_activ));
				map.put(Cliente.calle_res, e.getString(Cliente.calle_res));
				map.put(Cliente.celfono, e.getString(Cliente.celfono));
				map.put(Cliente.ciudad_cliente, e.getString(Cliente.ciudad_cliente));
				map.put(Cliente.comuna_res, e.getString(Cliente.comuna_res));
				map.put(Cliente.dia_fecnac, e.getString(Cliente.dia_fecnac));
				map.put(Cliente.dig_ver, e.getString(Cliente.dig_ver));
				map.put(Cliente.edad, e.getString(Cliente.edad));
				map.put(Cliente.email, e.getString(Cliente.email));
				map.put(Cliente.id_cliente, e.getString(Cliente.id_cliente));
				map.put(Cliente.mes_fecnac, e.getString(Cliente.mes_fecnac));
				map.put(Cliente.nacionalidad, e.getString(Cliente.nacionalidad));
				map.put(Cliente.nom2_cliente, e.getString(Cliente.nom2_cliente));
				map.put(Cliente.nom_cliente, e.getString(Cliente.nom_cliente));
				map.put(Cliente.numerodp, e.getString(Cliente.numerodp));
				map.put(Cliente.num_res, e.getString(Cliente.num_res));
				map.put(Cliente.rut_cliente, e.getString(Cliente.rut_cliente));
				map.put(Cliente.sector, e.getString(Cliente.sector));
				map.put(Cliente.telefono, e.getString(Cliente.telefono));
				mylist.add(map);
			}
		}
		if(funcion.equals("comuna"))
		{
			jArray = json.getJSONArray("comuna");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Comuna.id_comuna, e.getString(Comuna.id_comuna));
				map.put(Comuna.nom_comuna, e.getString(Comuna.nom_comuna));
				mylist.add(map);
			}
		}
		if(funcion.equals("empresa"))
		{
			jArray = json.getJSONArray("empresa");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Empresa.alcance_empre, e.getString(Empresa.alcance_empre));
				map.put(Empresa.cargo_cont_empre, e.getString(Empresa.cargo_cont_empre));
				map.put(Empresa.dig_verifi_empre, e.getString(Empresa.dig_verifi_empre));
				map.put(Empresa.email_empre, e.getString(Empresa.email_empre));
				map.put(Empresa.actividad_id_actividad, e.getString(Empresa.actividad_id_actividad));
				map.put(Empresa.id_empre, e.getString(Empresa.id_empre));
				map.put(Empresa.nombre_empre, e.getString(Empresa.nombre_empre));
				map.put(Empresa.nom_cont_empre, e.getString(Empresa.nom_cont_empre));
				map.put(Empresa.rut_empre, e.getString(Empresa.rut_empre));
				map.put(Empresa.telefono_empre, e.getString(Empresa.telefono_empre));
				mylist.add(map);
			}
		}
		if(funcion.equals("envio"))
		{
			jArray = json.getJSONArray("envio");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Envio.alt_dir, e.getString(Envio.alt_dir));
				map.put(Envio.fec_entre, e.getString(Envio.fec_entre));
				map.put(Envio.hor_entr, e.getString(Envio.hor_entr));
				map.put(Envio.id_envio, e.getString(Envio.id_envio));
				map.put(Envio.id_venta, e.getString(Envio.id_venta));
				mylist.add(map);
			}
		}
		if(funcion.equals("factura"))
		{
			jArray = json.getJSONArray("factura");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Factura.ano, e.getString(Factura.ano));
				map.put(Factura.dia, e.getString(Factura.dia));
				map.put(Factura.id_empresa, e.getString(Factura.id_empresa));
				map.put(Factura.id_factura, e.getString(Factura.id_factura));
				map.put(Factura.mes, e.getString(Factura.mes));
				map.put(Factura.rol, e.getString(Factura.rol));
				mylist.add(map);
			}
		}
		if(funcion.equals("item_factura"))
		{
			jArray = json.getJSONArray("item_factura");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Item_factura.cant, e.getString(Item_factura.cant));
				map.put(Item_factura.id_factura, e.getString(Item_factura.id_factura));
				map.put(Item_factura.id_itemfactura, e.getString(Item_factura.id_itemfactura));
				map.put(Item_factura.id_prod, e.getString(Item_factura.id_prod));
				map.put(Item_factura.precio, e.getString(Item_factura.precio));
				mylist.add(map);
			}
		}
		if(funcion.equals("precio"))
		{
			jArray = json.getJSONArray("precio");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Precio.empresa_id_empre, e.getString(Precio.empresa_id_empre));
				map.put(Precio.id_precio, e.getString(Precio.id_precio));
				map.put(Precio.producto_id_prod, e.getString(Precio.producto_id_prod));
				map.put(Precio.p_pes_ch, e.getString(Precio.p_pes_ch));
				map.put(Precio.p_us, e.getString(Precio.p_us));
				mylist.add(map);
			}
		}
		if(funcion.equals("productocompleto"))
		{
			jArray = json.getJSONArray("producto");
			for(int i=0;i < jArray.length();i++){ 
				HashMap<String, String> map = new HashMap<String, String>();
				JSONObject e = jArray.getJSONObject(i);
				map.put("alto_cm", e.getString("alto_cm"));
				map.put("ancho_cm", e.getString("ancho_cm"));
				map.put("clase_prod", e.getString("clase_prod"));
				map.put("cod_prod", e.getString("cod_prod"));
				map.put("contenido", e.getString("contenido"));
				map.put("cont_uni", e.getString("cont_uni"));
				map.put("uni_min", e.getString("uni_min"));
				map.put("cont_uni_med", e.getString("cont_uni_med"));
				map.put("descrip_prod", e.getString("descrip_prod"));
				map.put("fabr", e.getString("fabr"));
				map.put("fam_nec", e.getString("fam_nec"));
				map.put("fam_prod", e.getString("fam_prod"));
				map.put("fondo_cm", e.getString("fondo_cm"));
				map.put("id_prod", e.getString("id_prod"));
				map.put("id_subcat", e.getString("subcategoria_id_subcat"));
				map.put("linea_prod", e.getString("linea_prod"));
				map.put("marca_prod", e.getString("marca_prod"));
				map.put("mod_prod", e.getString("mod_prod"));
				map.put("nom_prod", e.getString("nom_prod"));
				map.put("num_serie", e.getString("num_serie"));
				map.put("peso_neto", e.getString("peso_neto"));
				map.put("tipo_prod", e.getString("tipo_prod"));
				map.put("SKU", e.getString("SKU"));
				map.put("imagen", e.getString("urlimagenprod"));
				map.put("hot", e.getString("hot"));
				map.put(Precio.empresa_id_empre, e.getString(Precio.empresa_id_empre));
				map.put(Precio.id_precio, e.getString(Precio.id_precio));
				map.put(Precio.producto_id_prod, e.getString(Precio.producto_id_prod));
				map.put(Precio.p_pes_ch, e.getString(Precio.p_pes_ch));
				map.put(Precio.p_us, e.getString(Precio.p_us));
				map.put(Stock.id_prod, e.getString(Stock.id_prod));
				map.put(Stock.id_stock, e.getString(Stock.id_stock));
				map.put(Stock.last_update, e.getString(Stock.last_update));
				map.put(Stock.stock_ideal, e.getString(Stock.stock_ideal));
				map.put(Stock.stock_minimo, e.getString(Stock.stock_minimo));
				map.put(Stock.stock_real, e.getString(Stock.stock_real));
				map.put(Stock.stock_tienda, e.getString(Stock.stock_tienda));
				map.put(Stock.stock_vendido, e.getString(Stock.stock_vendido));
				map.put(Stock.stock_virtual, e.getString(Stock.stock_virtual));
				mylist.add(map);
			}
		}
		if(funcion.equals("producto"))
		{
			jArray = json.getJSONArray("producto");
			for(int i=0;i < jArray.length();i++){ 
				HashMap<String, String> map = new HashMap<String, String>();
				JSONObject e = jArray.getJSONObject(i);
				map.put("alto_cm", e.getString("alto_cm"));
				map.put("ancho_cm", e.getString("ancho_cm"));
				map.put("clase_prod", e.getString("clase_prod"));
				map.put("cod_prod", e.getString("cod_prod"));
				map.put("contenido", e.getString("contenido"));
				map.put("cont_uni", e.getString("cont_uni"));
				map.put("cont_uni_med", e.getString("cont_uni_med"));
				map.put("descrip_prod", e.getString("descrip_prod"));
				map.put("fabr", e.getString("fabr"));
				map.put("fam_nec", e.getString("fam_nec"));
				map.put("fam_prod", e.getString("fam_prod"));
				map.put("fondo_cm", e.getString("fondo_cm"));
				map.put("id_prod", e.getString("id_prod"));
				map.put("id_subcat", e.getString("subcategoria_id_subcat"));
				map.put("linea_prod", e.getString("linea_prod"));
				map.put("marca_prod", e.getString("marca_prod"));
				map.put("mod_prod", e.getString("mod_prod"));
				map.put("nom_prod", e.getString("nom_prod"));
				map.put("num_serie", e.getString("num_serie"));
				map.put("peso_neto", e.getString("peso_neto"));
				map.put("tipo_prod", e.getString("tipo_prod"));
				map.put("uni_min", e.getString("uni_min"));
				mylist.add(map);
			}
		}
		if(funcion.equals("stock"))
		{
			jArray = json.getJSONArray("stock");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Stock.id_prod, e.getString(Stock.id_prod));
				map.put(Stock.id_stock, e.getString(Stock.id_stock));
				map.put(Stock.last_update, e.getString(Stock.last_update));
				map.put(Stock.stock_ideal, e.getString(Stock.stock_ideal));
				map.put(Stock.stock_minimo, e.getString(Stock.stock_minimo));
				map.put(Stock.stock_real, e.getString(Stock.stock_real));
				map.put(Stock.stock_tienda, e.getString(Stock.stock_tienda));
				map.put(Stock.stock_vendido, e.getString(Stock.stock_vendido));
				map.put(Stock.stock_virtual, e.getString(Stock.stock_virtual));
				mylist.add(map);
			}
		}
		if(funcion.equals("subcategoria"))
		{
			jArray = json.getJSONArray("subcategoria");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Subcategoria.id_categoria, e.getString(Subcategoria.id_categoria));
				map.put(Subcategoria.id_subcat, e.getString(Subcategoria.id_subcat));
				map.put(Subcategoria.nom_subcat, e.getString(Subcategoria.nom_subcat));
				mylist.add(map);
			}
		}
		if(funcion.equals("subcategoriaspinner"))
		{
			jArray = json.getJSONArray("subcategorias");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Subcategoria.id_subcat, e.getString(Subcategoria.id_subcat));
				map.put(Subcategoria.nom_subcat, e.getString(Subcategoria.nom_subcat));
				mylist.add(map);
			}
		}
		if(funcion.equals("talla"))
		{
			jArray = json.getJSONArray("talla");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Talla.am_ancho, e.getString(Talla.am_ancho));
				map.put(Talla.am_fondo, e.getString(Talla.am_fondo));
				map.put(Talla.a_largo, e.getString(Talla.a_largo));
				map.put(Talla.eu_ancho, e.getString(Talla.eu_ancho));
				map.put(Talla.eu_fondo, e.getString(Talla.eu_fondo));
				map.put(Talla.eu_largo, e.getString(Talla.eu_largo));
				map.put(Talla.id_prod, e.getString(Talla.id_prod));
				map.put(Talla.id_talla, e.getString(Talla.id_talla));
				map.put(Talla.num_ancho, e.getString(Talla.num_ancho));
				map.put(Talla.num_fondo, e.getString(Talla.num_fondo));
				map.put(Talla.num_largo, e.getString(Talla.num_largo));
				mylist.add(map);
			}
		}
		if(funcion.equals("usuario"))
		{
			jArray = json.getJSONArray("usuario");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Usuario.clave, e.getString(Usuario.clave));
				map.put(Usuario.id_cliente, e.getString(Usuario.id_cliente));
				map.put(Usuario.id_usuario, e.getString(Usuario.id_usuario));
				map.put(Usuario.nom_usuario, e.getString(Usuario.nom_usuario));
				map.put(Usuario.tipo_usuario, e.getString(Usuario.tipo_usuario));
				mylist.add(map);
			}
		}
		if(funcion.equals("valor_nutricional"))
		{
			jArray = json.getJSONArray("valor_nutricional");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Valor_nutricional._requerimientos, e.getString(Valor_nutricional._requerimientos));
				map.put(Valor_nutricional.cantidad, e.getString(Valor_nutricional.cantidad));
				map.put(Valor_nutricional.id_prod, e.getString(Valor_nutricional.id_prod));
				map.put(Valor_nutricional.id_val_nutri, e.getString(Valor_nutricional.id_val_nutri));
				map.put(Valor_nutricional.nombre_valor, e.getString(Valor_nutricional.nombre_valor));
				map.put(Valor_nutricional.valor_diario_total, e.getString(Valor_nutricional.valor_diario_total));
				mylist.add(map);
			}
		}
		if(funcion.equals("venta"))
		{
			jArray = json.getJSONArray("venta");
			for(int i=0;i < jArray.length();i++)
			{
				JSONObject e = jArray.getJSONObject(i);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(Venta.id_carro, e.getString(Venta.id_carro));
				map.put(Venta.id_envio, e.getString(Venta.id_envio));
				map.put(Venta.id_venta, e.getString(Venta.id_venta));
				map.put(Venta.num_articulos, e.getString(Venta.num_articulos));
				map.put(Venta.total, e.getString(Venta.total));
				mylist.add(map);
			}
		}
		Log.e(TAG, "return mylist");
		return mylist;
	}
}
*/