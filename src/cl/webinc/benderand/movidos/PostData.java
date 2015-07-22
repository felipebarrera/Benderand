/*package cl.webinc.benderand.movidos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;
import cl.webinc.benderand.provider.base.Empresa;

public class PostData 
{
	public List<NameValuePair> postdataready(HashMap<String, String> map, String type)
	{
    	Log.e("postdata", "" + type);
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        if(type.equals("empresa"))
        {
        	nameValuePairs.add(new BasicNameValuePair(Empresa.alcance_empre, map.get(Empresa.alcance_empre)));
        	nameValuePairs.add(new BasicNameValuePair(Empresa.cargo_cont_empre, map.get(Empresa.cargo_cont_empre)));
        	nameValuePairs.add(new BasicNameValuePair(Empresa.dig_verifi_empre, map.get(Empresa.dig_verifi_empre)));
        	nameValuePairs.add(new BasicNameValuePair(Empresa.email_empre, map.get(Empresa.email_empre)));
        	nameValuePairs.add(new BasicNameValuePair(Empresa.actividad_id_actividad, map.get(Empresa.actividad_id_actividad)));
        	nameValuePairs.add(new BasicNameValuePair(Empresa.id_empre, map.get(Empresa.id_empre)));
        	nameValuePairs.add(new BasicNameValuePair(Empresa.nombre_empre, map.get(Empresa.nombre_empre))); 
        	nameValuePairs.add(new BasicNameValuePair(Empresa.nom_cont_empre, map.get(Empresa.nom_cont_empre)));
        	nameValuePairs.add(new BasicNameValuePair(Empresa.rut_empre, map.get(Empresa.rut_empre)));
        	nameValuePairs.add(new BasicNameValuePair(Empresa.telefono_empre, map.get(Empresa.telefono_empre)));
        }
        if(type.equals("prodcarro"))
        {
        	Log.e("postdata", "" + map.get(carro_compras.id_carro));
	         	nameValuePairs.add(new BasicNameValuePair(base.carro_compras.cant_carro, map.get(carro_compras.cant_carro)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.id_carro, map.get(carro_compras.id_carro)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.empresa_id_empre, map.get(carro_compras.empresa_id_empre)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.producto_id_prod, map.get(carro_compras.producto_id_prod)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.carne_id_usuario, map.get(carro_compras.carne_id_usuario)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.mayor, map.get(carro_compras.mayor)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.precio_carro, map.get(carro_compras.precio_carro)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.tienda, map.get(carro_compras.tienda)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.usado, map.get(carro_compras.usado)));
				nameValuePairs.add(new BasicNameValuePair(base.carro_compras.carne_empresa_id_carne_empresa, map.get(carro_compras.carne_empresa_id_carne_empresa)));
        }
		if(type.equals("productocompleto"))
		{

	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.cant_mayor, map.get(cl.webinc.benderand.provider.Precio.cant_mayor)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.empresa_id_empre, map.get(cl.webinc.benderand.provider.Precio.empresa_id_empre)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.id_precio, map.get(cl.webinc.benderand.provider.Precio.id_precio)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.producto_id_prod, map.get(cl.webinc.benderand.provider.Precio.producto_id_prod)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.p_mayor_p_ch, map.get(cl.webinc.benderand.provider.Precio.p_mayor_p_ch)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.p_mayor_p_ch_ant, map.get(cl.webinc.benderand.provider.Precio.p_mayor_p_ch_ant)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.p_mayor_us, map.get(cl.webinc.benderand.provider.Precio.p_mayor_us)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.p_pes_ch, map.get(cl.webinc.benderand.provider.Precio.p_pes_ch)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.p_pes_ch_ant, map.get(cl.webinc.benderand.provider.Precio.p_pes_ch_ant)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.p_us, map.get(cl.webinc.benderand.provider.Precio.p_us)));
	         nameValuePairs.add(new BasicNameValuePair(cl.webinc.benderand.provider.Precio.v_mayor, map.get(cl.webinc.benderand.provider.Precio.v_mayor)));

	         nameValuePairs.add(new BasicNameValuePair(base.productos.alto_cm, map.get(base.productos.alto_cm)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.ancho_cm, map.get(base.productos.ancho_cm)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.clase_prod, map.get(base.productos.clase_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.cod_prod, map.get(base.productos.cod_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.contenido, map.get(base.productos.contenido)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.cont_uni, map.get(base.productos.cont_uni)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.cont_uni_med, map.get(base.productos.cont_uni_med)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.descrip_prod, map.get(base.productos.descrip_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.fabr, map.get(base.productos.fabr)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.fam_nec, map.get(base.productos.fam_nec)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.fam_prod, map.get(base.productos.fam_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.fondo_cm, map.get(base.productos.fondo_cm)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.hot, map.get(base.productos.hot)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.id_prod, map.get(base.productos.id_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.linea_prod, map.get(base.productos.linea_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.marca_prod, map.get(base.productos.marca_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.mod_prod, map.get(base.productos.mod_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.nom_prod, map.get(base.productos.nom_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.num_serie, map.get(base.productos.num_serie)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.peso_neto, map.get(base.productos.peso_neto)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.SKU, map.get(base.productos.SKU)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.subcategoria_id_subcat, map.get(base.productos.subcategoria_id_subcat)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.tipo_prod, map.get(base.productos.tipo_prod)));
	         nameValuePairs.add(new BasicNameValuePair(base.productos.uni_min, map.get(base.productos.uni_min)));

	         nameValuePairs.add(new BasicNameValuePair(base.imagenprod.id_imagenprod, map.get(base.imagenprod.id_imagenprod)));		
	         nameValuePairs.add(new BasicNameValuePair(base.imagenprod.producto_id_prod, map.get(base.imagenprod.producto_id_prod)));		
	         nameValuePairs.add(new BasicNameValuePair(base.imagenprod.urlimagenprod, map.get(base.imagenprod.urlimagenprod)));
		}
		return nameValuePairs;	
	}

}
*/