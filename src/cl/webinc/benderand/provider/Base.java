
package cl.webinc.benderand.provider;

import cl.webinc.benderand.util.Constantes;
import android.net.Uri;
import android.provider.BaseColumns;

public final class Base {
	private Base() {}
			public static class actividad implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/actividad");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.actividad";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.actividad";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_actividad = "_id";
				public static final String nombre_actividad = "nombre_actividad";
				public static final String codigo_actividad = "codigo_actividad";
				public static final String categoria_actividad = "categoria_actividad";
				public static final String afectoiva_actividad = "afectoiva_actividad";
				public static final String disponible_internet_actividad = "disponible_internet_actividad";
				public static final String subrubro_id_subrubro = "subrubro_id_subrubro";
			}
			
			public static class calle implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/calle");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.calle";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.calle";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_calle = "_id";
				public static final String nombre_calle = "nombre_calle";
				public static final String comuna_id_comuna = "comuna_id_comuna";
			}
			
			public static class caracteristica implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/caracteristica");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.caracteristica";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.caracteristica";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_caracteristica = "_id";
				public static final String numero_caracteristica = "numero_caracteristica";
				public static final String caracteristica = "caracteristica";
				public static final String valor_caracteristica = "valor_caracteristica";
				public static final String producto_id_producto = "producto_id_producto";
			}
			
			public static class carne_empresa implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carne_empresa");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carne_empresa";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carne_empresa";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_carne_empresa = "_id";
				public static final String nombre_usuario = "nombre_usuario";
				public static final String clave_usuario = "clave_usuario";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String persona_id_persona = "persona_id_persona";
				public static final String tipo_usuario_id_tipo_usuario = "tipo_usuario_id_tipo_usuario";
			}
			
			public static class carne_empresacompleto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carne_empresacompleto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carne_empresacompleto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carne_empresacompleto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_carne_empresa = "_id";
				public static final String nombre_usuario = "nombre_usuario";
				public static final String clave_usuario = "clave_usuario";
				public static final String tipo_usuario_id_tipo_usuario = "tipo_usuario_id_tipo_usuario";
				public static final String id_empresa = "id_empresa";
				public static final String rut_empresa = "rut_empresa";
				public static final String digito_verificador_empresa = "digito_verificador_empresa";
				public static final String nombre_empresa = "nombre_empresa";
				public static final String nombre_contacto_empresa = "nombre_contacto_empresa";
				public static final String cargo_contacto_empresa = "cargo_contacto_empresa";
				public static final String email_empresa = "email_empresa";
				public static final String alcance_empresa = "alcance_empresa";
				public static final String telefono_empresa = "telefono_empresa";
				public static final String actividad_id_actividad = "actividad_id_actividad";
				public static final String id_persona = "id_persona";
				public static final String rut_persona = "rut_persona";
				public static final String digito_verificador = "digito_verificador";
				public static final String nombre_persona = "nombre_persona";
				public static final String segundo_nombre_persona = "segundo_nombre_persona";
				public static final String apellido_persona = "apellido_persona";
				public static final String segundo_apellido_persona = "segundo_apellido_persona";
				public static final String actividad = "actividad";
				public static final String area_actividad = "area_actividad";
				public static final String dia_fecha_nacimiento = "dia_fecha_nacimiento";
				public static final String mes_fecha_nacimiento = "mes_fecha_nacimiento";
				public static final String ano_fecha_nacimiento = "ano_fecha_nacimiento";
				public static final String edad = "edad";
				public static final String email = "email";
				public static final String celular = "celular";
				public static final String telefono = "telefono";
			}
			
			public static class carro_compras implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carro_compras");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carro_compras";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carro_compras";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_carro_compras = "_id";
				public static final String cantidad_carro = "cantidad_carro";
				public static final String precio_carro = "precio_carro";
				public static final String mayor = "mayor";
				public static final String tienda = "tienda";
				public static final String usuario_id_usuario = "usuario_id_usuario";
				public static final String producto_id_producto = "producto_id_producto";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String usado = "usado";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
			}
			
			public static class carro_comprascompleto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carro_comprascompleto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carro_comprascompleto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carro_comprascompleto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_carro_compras = "_id";
				public static final String cantidad_carro = "cantidad_carro";
				public static final String precio_carro = "precio_carro";
				public static final String mayor = "mayor";
				public static final String tienda = "tienda";
				public static final String usuario_id_usuario = "usuario_id_usuario";
				public static final String usado = "usado";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
				public static final String id_precio = "id_precio";
				public static final String precio_CLP = "precio_CLP";
				public static final String precio_us = "precio_us";
				public static final String precio_mayor_CLP = "precio_mayor_CLP";
				public static final String precio_mayor_us = "precio_mayor_us";
				public static final String precio_actual = "precio_actual";
				public static final String descuento_promocion = "descuento_promocion";
				public static final String cantidad_mayor = "cantidad_mayor";
				public static final String id_producto = "id_producto";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String hot = "hot";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String SKU = "SKU";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
				public static final String stock_tienda = "stock_tienda";
			}
			
			public static class carro_egresos implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carro_egresos");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carro_egresos";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carro_egresos";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_carro_egresos = "_id";
				public static final String cantidad_carro = "cantidad_carro";
				public static final String precio_carro = "precio_carro";
				public static final String mayor = "mayor";
				public static final String tienda = "tienda";
				public static final String usado = "usado";
				public static final String producto_id_producto = "producto_id_producto";
				public static final String usuario_id_usuario = "usuario_id_usuario";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
			}
			
			public static class carro_egresoscompleto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carro_egresoscompleto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carro_egresoscompleto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carro_egresoscompleto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_carro_egresos = "_id";
				public static final String cantidad_carro = "cantidad_carro";
				public static final String precio_carro = "precio_carro";
				public static final String mayor = "mayor";
				public static final String tienda = "tienda";
				public static final String usuario_id_usuario = "usuario_id_usuario";
				public static final String usado = "usado";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
				public static final String id_producto = "id_producto";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String hot = "hot";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String SKU = "SKU";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
				public static final String stock_tienda = "stock_tienda";
				public static final String precio_CLP = "precio_CLP";
			}
			
			public static class carro_egresosproducto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carro_egresosproducto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carro_egresosproducto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carro_egresosproducto";
				public static final String id_carro_egresos = "id_carro_egresos";
				public static final String cantidad_carro = "cantidad_carro";
				public static final String precio_carro = "precio_carro";
				public static final String mayor = "mayor";
				public static final String tienda = "tienda";
				public static final String usuario_id_usuario = "usuario_id_usuario";
				public static final String usado = "usado";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
				public static final String id_producto = "id_producto";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String hot = "hot";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String SKU = "SKU";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
			}
			
			public static class carro_venta implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carro_venta");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carro_venta";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carro_venta";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_carro_venta = "_id";
				public static final String cantidad = "cantidad";
				public static final String precio = "precio";
				public static final String carro_compras_id_carro_compras = "carro_compras_id_carro_compras";
				public static final String venta_id_venta = "venta_id_venta";
			}
			
			public static class carro_ventacompleto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/carro_ventacompleto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.carro_ventacompleto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.carro_ventacompleto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_carro_venta = "_id";
				public static final String cantidad = "cantidad";
				public static final String precio = "precio";
				public static final String venta_id_venta = "venta_id_venta";
				public static final String id_carro_compras = "id_carro_compras";
				public static final String cantidad_carro = "cantidad_carro";
				public static final String precio_carro = "precio_carro";
				public static final String mayor = "mayor";
				public static final String tienda = "tienda";
				public static final String usuario_id_usuario = "usuario_id_usuario";
				public static final String usado = "usado";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
				public static final String id_precio = "id_precio";
				public static final String precio_CLP = "precio_CLP";
				public static final String precio_us = "precio_us";
				public static final String precio_mayor_CLP = "precio_mayor_CLP";
				public static final String precio_mayor_us = "precio_mayor_us";
				public static final String precio_actual = "precio_actual";
				public static final String descuento_promocion = "descuento_promocion";
				public static final String cantidad_mayor = "cantidad_mayor";
				public static final String id_producto = "id_producto";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String hot = "hot";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String SKU = "SKU";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
			}
			
			public static class categoria implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/categoria");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.categoria";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.categoria";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_categoria = "_id";
				public static final String nombre_categoria = "nombre_categoria";
			}
			
			public static class categoria_empresa implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/categoria_empresa");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.categoria_empresa";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.categoria_empresa";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_categoria_empresa = "_id";
				public static final String nombre_categoria_empresa = "nombre_categoria_empresa";
			}
			
			public static class ci_sessions implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/ci_sessions");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.ci_sessions";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.ci_sessions";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String session_id = "session_id";
				public static final String ip_address = "ip_address";
				public static final String user_agent = "user_agent";
				public static final String id_user = "_id";
				public static final String nombre_apellido = "nombre_apellido";
				public static final String email_user = "email_user";
				public static final String last_activity = "last_activity";
				public static final String user_data = "user_data";
			}
			
			public static class cliente implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/cliente");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.cliente";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.cliente";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_cliente = "_id";
				public static final String rut_cliente = "rut_cliente";
				public static final String digito_verificador = "digito_verificador";
				public static final String nombre_cliente = "nombre_cliente";
				public static final String segundo_nombre_cliente = "segundo_nombre_cliente";
				public static final String apellido_cliente = "apellido_cliente";
				public static final String segundo_apellido_cliente = "segundo_apellido_cliente";
				public static final String actividad = "actividad";
				public static final String area_actividad = "area_actividad";
				public static final String dia_fecha_nacimiento = "dia_fecha_nacimiento";
				public static final String mes_fecha_nacimiento = "mes_fecha_nacimiento";
				public static final String ano_fecha_nacimiento = "ano_fecha_nacimiento";
				public static final String edad = "edad";
				public static final String email = "email";
				public static final String celular = "celular";
				public static final String telefono = "telefono";
			}
			
			public static class cliente_empresa implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/cliente_empresa");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.cliente_empresa";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.cliente_empresa";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_cliente_empresa = "_id";
				public static final String rut_cliente_empresa = "rut_cliente_empresa";
				public static final String digito_verificador = "digito_verificador";
				public static final String nombre = "nombre";
				public static final String email_cliente_empresa = "email_cliente_empresa";
				public static final String actividad_id_actividad = "actividad_id_actividad";
				public static final String empresa_id_empresa = "empresa_id_empresa";
			}
			
			public static class compracompleta implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/compracompleta");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.compracompleta";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.compracompleta";
				public static final String id_factura = "id_factura";
				public static final String rol_factura = "rol_factura";
				public static final String dia_factura = "dia_factura";
				public static final String mes_factura = "mes_factura";
				public static final String ano_factura = "ano_factura";
				public static final String fecha_factura = "fecha_factura";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
				public static final String rut_proveedor = "rut_proveedor";
				public static final String nombre_proveedor = "nombre_proveedor";
				public static final String telefono_proveedor = "telefono_proveedor";
				public static final String tipo_documento_id_tipo_documento = "tipo_documento_id_tipo_documento";
				public static final String tipo_pago_id_tipo_pago = "tipo_pago_id_tipo_pago";
				public static final String total_factura = "total_factura";
				public static final String id_tipo_pago = "id_tipo_pago";
				public static final String nombre_tipo_pago = "nombre_tipo_pago";
				public static final String comision_tipo_pago = "comision_tipo_pago";
				public static final String id_tipo_documento = "id_tipo_documento";
				public static final String nombre_tipo_documento = "nombre_tipo_documento";
			}
			
			public static class comuna implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/comuna");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.comuna";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.comuna";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_comuna = "_id";
				public static final String codigo_comuna = "codigo_comuna";
				public static final String nombre_comuna = "nombre_comuna";
				public static final String provincia_id_provincia = "provincia_id_provincia";
			}
			
			public static class contenido_unidad_medida implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/contenido_unidad_medida");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.contenido_unidad_medida";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.contenido_unidad_medida";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_contenido_unidad_medida = "_id";
				public static final String nombre_contenido_unidad_medida = "nombre_contenido_unidad_medida";
			}
			
			public static class dia implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/dia");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.dia";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.dia";
				public static final String iddia = "iddia";
				public static final String dia = "dia";
				public static final String mes = "mes";
				public static final String anno = "anno";
				public static final String fecha = "fecha";
				public static final String egreso = "egreso";
				public static final String ingreso = "ingreso";
				public static final String impuesto = "impuesto";
			}
			
			public static class empresa implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/empresa");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.empresa";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.empresa";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_empresa = "_id";
				public static final String rut_empresa = "rut_empresa";
				public static final String digito_verificador_empresa = "digito_verificador_empresa";
				public static final String nombre_empresa = "nombre_empresa";
				public static final String nombre_contacto_empresa = "nombre_contacto_empresa";
				public static final String cargo_contacto_empresa = "cargo_contacto_empresa";
				public static final String email_empresa = "email_empresa";
				public static final String alcance_empresa = "alcance_empresa";
				public static final String telefono_empresa = "telefono_empresa";
				public static final String actividad_id_actividad = "actividad_id_actividad";
				public static final String tipo_empresa_id_tipo_empresa = "tipo_empresa_id_tipo_empresa";
			}
			
			public static class envio implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/envio");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.envio";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.envio";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_envio = "_id";
				public static final String direccion_alternativa = "direccion_alternativa";
				public static final String fecha_entrega = "fecha_entrega";
				public static final String hora_entrega = "hora_entrega";
				public static final String venta_id_venta = "venta_id_venta";
				public static final String enviado = "enviado";
			}
			
			public static class factura implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/factura");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.factura";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.factura";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_factura = "_id";
				public static final String rol_factura = "rol_factura";
				public static final String dia_factura = "dia_factura";
				public static final String mes_factura = "mes_factura";
				public static final String ano_factura = "ano_factura";
				public static final String fecha_factura = "fecha_factura";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
				public static final String rut_proveedor = "rut_proveedor";
				public static final String nombre_proveedor = "nombre_proveedor";
				public static final String telefono_proveedor = "telefono_proveedor";
				public static final String tipo_documento_id_tipo_documento = "tipo_documento_id_tipo_documento";
				public static final String tipo_pago_id_tipo_pago = "tipo_pago_id_tipo_pago";
				public static final String total_factura = "total_factura";
			}
			
			public static class familia_necesidad implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/familia_necesidad");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.familia_necesidad";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.familia_necesidad";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_familia_necesidad = "_id";
				public static final String nombre_familia_necesidad = "nombre_familia_necesidad";
			}
			
			public static class familia_producto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/familia_producto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.familia_producto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.familia_producto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_familia_producto = "_id";
				public static final String nombre_familia_producto = "nombre_familia_producto";
			}
			
			public static class formato_producto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/formato_producto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.formato_producto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.formato_producto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_formato_producto = "_id";
				public static final String nombre_formato_producto = "nombre_formato_producto";
			}
			
			public static class gasto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/gasto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.gasto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.gasto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_gasto = "id_gasto";
				public static final String nombre_gasto = "nombre_gasto";
				public static final String id_usuario = "_id";
				public static final String monto_gasto = "monto_gasto";
				public static final String fecha_gasto = "fecha_gasto";
				public static final String empresa_id_empre = "empresa_id_empre";
			}
			
			public static class geocode_cache implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/geocode_cache");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.geocode_cache";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.geocode_cache";
				public static final String id = "id";
				public static final String lng = "lng";
				public static final String lat = "lat";
				public static final String query = "query";
			}
			
			public static class imagenprod implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/imagenprod");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.imagenprod";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.imagenprod";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_imagenprod = "_id";
				public static final String urlimagenprod = "urlimagenprod";
				public static final String producto_id_producto = "producto_id_producto";
			}
			
			public static class impuesto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/impuesto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.impuesto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.impuesto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_impuesto = "_id";
				public static final String nombre_impuesto = "nombre_impuesto";
				public static final String valor_impuesto = "valor_impuesto";
			}
			
			public static class ingresosegresos implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/ingresosegresos");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.ingresosegresos";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.ingresosegresos";
				public static final String dia = "dia";
				public static final String mes = "mes";
				public static final String anno = "anno";
				public static final String fecha = "fecha";
				public static final String totalingreso = "totalingreso";
				public static final String totalgasto = "totalgasto";
				public static final String impuestoegreso = "impuestoegreso";
				public static final String impuestoingreso = "impuestoingreso";
			}
			
			public static class item_factura implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/item_factura");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.item_factura";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.item_factura";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_itemfactura = "_id";
				public static final String cantidad = "cantidad";
				public static final String precio = "precio";
				public static final String producto_id_producto = "producto_id_producto";
				public static final String factura_id_factura = "factura_id_factura";
				public static final String carro_egresos_id_carro_egresos = "carro_egresos_id_carro_egresos";
			}
			
			public static class item_facturacompleto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/item_facturacompleto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.item_facturacompleto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.item_facturacompleto";
				public static final String id_itemfactura = "id_itemfactura";
				public static final String cantidad = "cantidad";
				public static final String precio = "precio";
				public static final String producto_id_producto = "producto_id_producto";
				public static final String factura_id_factura = "factura_id_factura";
				public static final String id_producto = "id_producto";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String hot = "hot";
				public static final String SKU = "SKU";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
			}
			
			public static class mapa implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/mapa");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.mapa";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.mapa";
				public static final String id = "id";
				public static final String name = "name";
				public static final String direccion = "direccion";
				public static final String lat = "lat";
				public static final String lng = "lng";
				public static final String tipo = "tipo";
				public static final String imagen = "imagen";
			}
			
			public static class pais implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/pais");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.pais";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.pais";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_pais = "_id";
				public static final String nombre_pais = "nombre_pais";
				public static final String iso_code_2_pais = "iso_code_2_pais";
				public static final String iso_code_3_pais = "iso_code_3_pais";
				public static final String address_format = "address_format";
				public static final String iso_code_number = "iso_code_number";
			}
			
			public static class persona implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/persona");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.persona";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.persona";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_persona = "_id";
				public static final String rut_persona = "rut_persona";
				public static final String digito_verificador = "digito_verificador";
				public static final String nombre_persona = "nombre_persona";
				public static final String segundo_nombre_persona = "segundo_nombre_persona";
				public static final String apellido_persona = "apellido_persona";
				public static final String segundo_apellido_persona = "segundo_apellido_persona";
				public static final String actividad = "actividad";
				public static final String area_actividad = "area_actividad";
				public static final String dia_fecha_nacimiento = "dia_fecha_nacimiento";
				public static final String mes_fecha_nacimiento = "mes_fecha_nacimiento";
				public static final String ano_fecha_nacimiento = "ano_fecha_nacimiento";
				public static final String edad = "edad";
				public static final String email = "email";
				public static final String celular = "celular";
				public static final String telefono = "telefono";
			}
			
			public static class precio implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/precio");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.precio";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.precio";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_precio = "_id";
				public static final String precio_CLP = "precio_CLP";
				public static final String precio_us = "precio_us";
				public static final String precio_mayor_CLP = "precio_mayor_CLP";
				public static final String precio_mayor_us = "precio_mayor_us";
				public static final String precio_actual = "precio_actual";
				public static final String descuento_promocion = "descuento_promocion";
				public static final String cantidad_mayor = "cantidad_mayor";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String producto_id_producto = "producto_id_producto";
			}
			
			public static class producto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/producto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.producto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.producto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_producto = "_id";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String hot = "hot";
				public static final String SKU = "SKU";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
			}
			
			public static class productocompleto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/productocompleto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.productocompleto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.productocompleto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_producto = "_id";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String hot = "hot";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String SKU = "SKU";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
				public static final String id_caracteristica = "id_caracteristica";
				public static final String numero_caracteristica = "numero_caracteristica";
				public static final String caracteristica = "caracteristica";
				public static final String valor_caracteristica = "valor_caracteristica";
				public static final String id_categoria = "id_categoria";
				public static final String nombre_categoria = "nombre_categoria";
				public static final String id_empresa = "id_empresa";
				public static final String rut_empresa = "rut_empresa";
				public static final String digito_verificador_empresa = "digito_verificador_empresa";
				public static final String nombre_empresa = "nombre_empresa";
				public static final String nombre_contacto_empresa = "nombre_contacto_empresa";
				public static final String cargo_contacto_empresa = "cargo_contacto_empresa";
				public static final String email_empresa = "email_empresa";
				public static final String alcance_empresa = "alcance_empresa";
				public static final String telefono_empresa = "telefono_empresa";
				public static final String actividad_id_actividad = "actividad_id_actividad";
				public static final String id_imagenprod = "id_imagenprod";
				public static final String urlimagenprod = "urlimagenprod";
				public static final String id_precio = "id_precio";
				public static final String precio_CLP = "precio_CLP";
				public static final String precio_us = "precio_us";
				public static final String precio_mayor_CLP = "precio_mayor_CLP";
				public static final String precio_mayor_us = "precio_mayor_us";
				public static final String precio_actual = "precio_actual";
				public static final String descuento_promocion = "descuento_promocion";
				public static final String cantidad_mayor = "cantidad_mayor";
				public static final String id_reciclado = "id_reciclado";
				public static final String reciclable = "reciclable";
				public static final String reciclado = "reciclado";
				public static final String valor_reciclaje = "valor_reciclaje";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String id_stock = "id_stock";
				public static final String stock_real = "stock_real";
				public static final String stock_minimo = "stock_minimo";
				public static final String stock_ideal = "stock_ideal";
				public static final String stock_tienda = "stock_tienda";
				public static final String stock_virtual = "stock_virtual";
				public static final String stock_vendido = "stock_vendido";
				public static final String last_update = "last_update";
				public static final String id_subcategoria = "id_subcategoria";
				public static final String nombre_subcategoria = "nombre_subcategoria";
				public static final String descripcion_subcategoria = "descripcion_subcategoria";
				public static final String categoria_id_categoria = "categoria_id_categoria";
				public static final String id_talla = "id_talla";
				public static final String am_largo = "am_largo";
				public static final String am_ancho = "am_ancho";
				public static final String am_fondo = "am_fondo";
				public static final String eu_largo = "eu_largo";
				public static final String eu_ancho = "eu_ancho";
				public static final String eu_fondo = "eu_fondo";
				public static final String num_largo = "num_largo";
				public static final String num_ancho = "num_ancho";
				public static final String num_fondo = "num_fondo";
				public static final String id_valor_nutricional = "id_valor_nutricional";
				public static final String nombre_valor = "nombre_valor";
				public static final String cantidad = "cantidad";
				public static final String valor_diario_total = "valor_diario_total";
				public static final String porcentaje_requerimientos = "porcentaje_requerimientos";
			}
			
			public static class productocompra implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/productocompra");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.productocompra";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.productocompra";
				public static final String id_producto = "id_producto";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String hot = "hot";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String SKU = "SKU";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
				public static final String id_caracteristica = "id_caracteristica";
				public static final String numero_caracteristica = "numero_caracteristica";
				public static final String caracteristica = "caracteristica";
				public static final String valor_caracteristica = "valor_caracteristica";
				public static final String id_categoria = "id_categoria";
				public static final String nombre_categoria = "nombre_categoria";
				public static final String id_reciclado = "id_reciclado";
				public static final String reciclable = "reciclable";
				public static final String reciclado = "reciclado";
				public static final String valor_reciclaje = "valor_reciclaje";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String id_stock = "id_stock";
				public static final String stock_real = "stock_real";
				public static final String stock_minimo = "stock_minimo";
				public static final String stock_ideal = "stock_ideal";
				public static final String stock_tienda = "stock_tienda";
				public static final String stock_virtual = "stock_virtual";
				public static final String stock_vendido = "stock_vendido";
				public static final String last_update = "last_update";
				public static final String id_subcategoria = "id_subcategoria";
				public static final String nombre_subcategoria = "nombre_subcategoria";
				public static final String descripcion_subcategoria = "descripcion_subcategoria";
				public static final String categoria_id_categoria = "categoria_id_categoria";
				public static final String id_talla = "id_talla";
				public static final String am_largo = "am_largo";
				public static final String am_ancho = "am_ancho";
				public static final String am_fondo = "am_fondo";
				public static final String eu_largo = "eu_largo";
				public static final String eu_ancho = "eu_ancho";
				public static final String eu_fondo = "eu_fondo";
				public static final String num_largo = "num_largo";
				public static final String num_ancho = "num_ancho";
				public static final String num_fondo = "num_fondo";
				public static final String id_valor_nutricional = "id_valor_nutricional";
				public static final String nombre_valor = "nombre_valor";
				public static final String cantidad = "cantidad";
				public static final String valor_diario_total = "valor_diario_total";
				public static final String porcentaje_requerimientos = "porcentaje_requerimientos";
			}
			
			public static class productoprecio implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/productoprecio");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.productoprecio";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.productoprecio";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_producto = "_id";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String hot = "hot";
				public static final String SKU = "SKU";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
				public static final String id_precio = "id_precio";
				public static final String precio_CLP = "precio_CLP";
				public static final String precio_us = "precio_us";
				public static final String precio_mayor_CLP = "precio_mayor_CLP";
				public static final String precio_mayor_us = "precio_mayor_us";
				public static final String precio_actual = "precio_actual";
				public static final String descuento_promocion = "descuento_promocion";
				public static final String cantidad_mayor = "cantidad_mayor";
				public static final String id_stock = "id_stock";
				public static final String stock_real = "stock_real";
				public static final String stock_minimo = "stock_minimo";
				public static final String stock_ideal = "stock_ideal";
				public static final String stock_tienda = "stock_tienda";
				public static final String stock_virtual = "stock_virtual";
				public static final String stock_vendido = "stock_vendido";
				public static final String last_update = "last_update";
				public static final String empresa_id_empresa = "empresa_id_empresa";
			}
			
			public static class provincia implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/provincia");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.provincia";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.provincia";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_provincia = "_id";
				public static final String nombre_provincia = "nombre_provincia";
				public static final String codigo_provincia = "codigo_provincia";
				public static final String region_id_region = "region_id_region";
			}
			
			public static class reciclado implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/reciclado");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.reciclado";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.reciclado";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_reciclado = "_id";
				public static final String reciclable = "reciclable";
				public static final String reciclado = "reciclado";
				public static final String valor_reciclaje = "valor_reciclaje";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String producto_id_producto = "producto_id_producto";
			}
			
			public static class region implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/region");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.region";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.region";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_region = "_id";
				public static final String nombre_region = "nombre_region";
				public static final String codigo_region = "codigo_region";
				public static final String pais_id_pais = "pais_id_pais";
			}
			
			public static class rubro implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/rubro");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.rubro";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.rubro";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_rubro = "_id";
				public static final String nombre_rubro = "nombre_rubro";
			}
			
			public static class sincrodate implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/sincrodate");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.sincrodate";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.sincrodate";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_sincrodate = "_id";
				public static final String date = "date";
			}
			
			public static class stock implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/stock");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.stock";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.stock";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_stock = "_id";
				public static final String stock_real = "stock_real";
				public static final String stock_minimo = "stock_minimo";
				public static final String stock_ideal = "stock_ideal";
				public static final String stock_tienda = "stock_tienda";
				public static final String stock_virtual = "stock_virtual";
				public static final String stock_vendido = "stock_vendido";
				public static final String last_update = "last_update";
				public static final String producto_id_producto = "producto_id_producto";
				public static final String empresa_id_empresa = "empresa_id_empresa";
			}
			
			public static class stockcompleto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/stockcompleto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.stockcompleto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.stockcompleto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_producto = "id_producto";
				public static final String codigo_producto = "codigo_producto";
				public static final String numero_serie = "numero_serie";
				public static final String descripcion_producto = "descripcion_producto";
				public static final String nombre_producto = "nombre_producto";
				public static final String marca_producto = "marca_producto";
				public static final String modelo_producto = "modelo_producto";
				public static final String contenido_unidad = "contenido_unidad";
				public static final String contenido_unidad_medida_id_contenido_unidad_medida = "contenido_unidad_medida_id_contenido_unidad_medida";
				public static final String unidad_minima = "unidad_minima";
				public static final String contenido = "contenido";
				public static final String peso_neto = "peso_neto";
				public static final String alto_cm = "alto_cm";
				public static final String ancho_cm = "ancho_cm";
				public static final String fondo_cm = "fondo_cm";
				public static final String fabricante = "fabricante";
				public static final String clase_producto = "clase_producto";
				public static final String linea_producto = "linea_producto";
				public static final String hot = "hot";
				public static final String SKU = "SKU";
				public static final String subcategoria_id_subcategoria = "subcategoria_id_subcategoria";
				public static final String tipo_producto_id_tipo_producto = "tipo_producto_id_tipo_producto";
				public static final String formato_producto_id_formato_producto = "formato_producto_id_formato_producto";
				public static final String familia_necesidad_id_familia_necesidad = "familia_necesidad_id_familia_necesidad";
				public static final String familia_producto_id_familia_producto = "familia_producto_id_familia_producto";
				public static final String id_stock = "_id";
				public static final String stock_real = "stock_real";
				public static final String stock_minimo = "stock_minimo";
				public static final String stock_ideal = "stock_ideal";
				public static final String stock_tienda = "stock_tienda";
				public static final String stock_virtual = "stock_virtual";
				public static final String stock_vendido = "stock_vendido";
				public static final String last_update = "last_update";
				public static final String producto_id_producto = "producto_id_producto";
				public static final String empresa_id_empresa = "empresa_id_empresa";
			}
			
			public static class subcategoria implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/subcategoria");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.subcategoria";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.subcategoria";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_subcategoria = "_id";
				public static final String nombre_subcategoria = "nombre_subcategoria";
				public static final String descripcion_subcategoria = "descripcion_subcategoria";
				public static final String categoria_id_categoria = "categoria_id_categoria";
			}
			
			public static class subrubro implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/subrubro");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.subrubro";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.subrubro";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_subrubro = "_id";
				public static final String nombre_subrubro = "nombre_subrubro";
				public static final String rubro_id_rubro = "rubro_id_rubro";
			}
			
			public static class talla implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/talla");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.talla";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.talla";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_talla = "_id";
				public static final String am_largo = "am_largo";
				public static final String am_ancho = "am_ancho";
				public static final String am_fondo = "am_fondo";
				public static final String eu_largo = "eu_largo";
				public static final String eu_ancho = "eu_ancho";
				public static final String eu_fondo = "eu_fondo";
				public static final String num_largo = "num_largo";
				public static final String num_ancho = "num_ancho";
				public static final String num_fondo = "num_fondo";
				public static final String producto_id_producto = "producto_id_producto";
			}
			
			public static class tipo_documento implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/tipo_documento");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.tipo_documento";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.tipo_documento";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_tipo_documento = "_id";
				public static final String nombre_tipo_documento = "nombre_tipo_documento";
			}
			
			public static class tipo_empresa implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/tipo_empresa");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.tipo_empresa";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.tipo_empresa";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_tipo_empresa = "_id";
				public static final String nombre_tipo_empresa = "nombre_tipo_empresa";
				public static final String categoria_empresa_id_categoria_empresa = "categoria_empresa_id_categoria_empresa";
			}
			
			public static class tipo_pago implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/tipo_pago");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.tipo_pago";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.tipo_pago";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_tipo_pago = "_id";
				public static final String nombre_tipo_pago = "nombre_tipo_pago";
				public static final String comision_tipo_pago = "comision_tipo_pago";
			}
			
			public static class tipo_producto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/tipo_producto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.tipo_producto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.tipo_producto";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_tipo_producto = "_id";
				public static final String nombre_tipo_producto = "nombre_tipo_producto";
			}
			
			public static class tipo_usuario implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/tipo_usuario");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.tipo_usuario";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.tipo_usuario";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_tipo_usuario = "_id";
				public static final String nombre_tipo_usuario = "nombre_tipo_usuario";
			}
			
			public static class ubicacion implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/ubicacion");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.ubicacion";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.ubicacion";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_ubicacion = "_id";
				public static final String numero_ubicacion = "numero_ubicacion";
				public static final String numero_interior = "numero_interior";
				public static final String telefono_ubicacion = "telefono_ubicacion";
				public static final String default_ubicacion = "default_ubicacion";
				public static final String calle_id_calle = "calle_id_calle";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String usuario_id_usuario = "usuario_id_usuario";
			}
			
			public static class usuario implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/usuario");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.usuario";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.usuario";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_usuario = "_id";
				public static final String tipo_usuario = "tipo_usuario";
				public static final String nombre_usuario = "nombre_usuario";
				public static final String clave = "clave";
				public static final String cliente_id_cliente = "cliente_id_cliente";
				public static final String cliente_empresa_id_cliente_empresa = "cliente_empresa_id_cliente_empresa";
			}
			
			public static class usuariocompleto implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/usuariocompleto");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.usuariocompleto";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.usuariocompleto";
				public static final String id_persona = "id_persona";
				public static final String rut_persona = "rut_persona";
				public static final String digito_verificador = "digito_verificador";
				public static final String nombre_persona = "nombre_persona";
				public static final String segundo_nombre_persona = "segundo_nombre_persona";
				public static final String apellido_persona = "apellido_persona";
				public static final String segundo_apellido_persona = "segundo_apellido_persona";
				public static final String actividad = "actividad";
				public static final String area_actividad = "area_actividad";
				public static final String dia_fecha_nacimiento = "dia_fecha_nacimiento";
				public static final String mes_fecha_nacimiento = "mes_fecha_nacimiento";
				public static final String ano_fecha_nacimiento = "ano_fecha_nacimiento";
				public static final String edad = "edad";
				public static final String email = "email";
				public static final String celular = "celular";
				public static final String telefono = "telefono";
				public static final String id_carne_empresa = "id_carne_empresa";
				public static final String nombre_usuario = "nombre_usuario";
				public static final String clave_usuario = "clave_usuario";
				public static final String empresa_id_empresa = "empresa_id_empresa";
				public static final String persona_id_persona = "persona_id_persona";
				public static final String tipo_usuario_id_tipo_usuario = "tipo_usuario_id_tipo_usuario";
			}
			
			public static class valor_nutricional implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/valor_nutricional");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.valor_nutricional";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.valor_nutricional";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_valor_nutricional = "_id";
				public static final String nombre_valor = "nombre_valor";
				public static final String cantidad = "cantidad";
				public static final String valor_diario_total = "valor_diario_total";
				public static final String porcentaje_requerimientos = "porcentaje_requerimientos";
				public static final String producto_id_producto = "producto_id_producto";
			}
			
			public static class venta implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/venta");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.venta";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.venta";
				public static final String DEFAULT_ORDEN = "_id ASC";
				public static final String id_venta = "_id";
				public static final String numero_articulos = "numero_articulos";
				public static final String total = "total";
				public static final String dia_fecha_venta = "dia_fecha_venta";
				public static final String mes_fecha_venta = "mes_fecha_venta";
				public static final String anno_fecha_venta = "anno_fecha_venta";
				public static final String hora_fecha_venta = "hora_fecha_venta";
				public static final String usuario_id_usuario = "usuario_id_usuario";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
				public static final String tipo_pago_id_tipo_pago = "tipo_pago_id_tipo_pago";
				public static final String tipo_documento_id_tipo_documento = "tipo_documento_id_tipo_documento";
			}
			
			public static class ventacompleta implements BaseColumns
			{
				public static final Uri CONTENT_URI = Uri.parse("content://" + Constantes.AUTHORITY + "/ventacompleta");
				public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.ncwebinc.ventacompleta";
				public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.ncwebinc.ventacompleta";
				public static final String id_venta = "id_venta";
				public static final String numero_articulos = "numero_articulos";
				public static final String total = "total";
				public static final String dia_fecha_venta = "dia_fecha_venta";
				public static final String mes_fecha_venta = "mes_fecha_venta";
				public static final String anno_fecha_venta = "anno_fecha_venta";
				public static final String hora_fecha_venta = "hora_fecha_venta";
				public static final String usuario_id_usuario = "usuario_id_usuario";
				public static final String carne_empresa_id_carne_empresa = "carne_empresa_id_carne_empresa";
				public static final String tipo_pago_id_tipo_pago = "tipo_pago_id_tipo_pago";
				public static final String tipo_documento_id_tipo_documento = "tipo_documento_id_tipo_documento";
				public static final String id_tipo_pago = "id_tipo_pago";
				public static final String nombre_tipo_pago = "nombre_tipo_pago";
				public static final String comision_tipo_pago = "comision_tipo_pago";
				public static final String id_tipo_documento = "id_tipo_documento";
				public static final String nombre_tipo_documento = "nombre_tipo_documento";
			}
			
		}