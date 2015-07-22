
package cl.webinc.benderand.util;

import java.util.HashMap;
import cl.webinc.benderand.util.Constantes;
import cl.webinc.benderand.provider.Base.*;

public class ProjectionMaper 

{
public HashMap<String, String> ActividadMap()
{

			Constantes.sActividadProjectionMap = new HashMap<String, String>();

				Constantes.sActividadProjectionMap.put(actividad.id_actividad, actividad.id_actividad);

				Constantes.sActividadProjectionMap.put(actividad.nombre_actividad, actividad.nombre_actividad);

				Constantes.sActividadProjectionMap.put(actividad.codigo_actividad, actividad.codigo_actividad);

				Constantes.sActividadProjectionMap.put(actividad.categoria_actividad, actividad.categoria_actividad);

				Constantes.sActividadProjectionMap.put(actividad.afectoiva_actividad, actividad.afectoiva_actividad);

				Constantes.sActividadProjectionMap.put(actividad.disponible_internet_actividad, actividad.disponible_internet_actividad);

				Constantes.sActividadProjectionMap.put(actividad.subrubro_id_subrubro, actividad.subrubro_id_subrubro);

				return Constantes.sActividadProjectionMap;

			}
public HashMap<String, String> CalleMap()
{

			Constantes.sCalleProjectionMap = new HashMap<String, String>();

				Constantes.sCalleProjectionMap.put(calle.id_calle, calle.id_calle);

				Constantes.sCalleProjectionMap.put(calle.nombre_calle, calle.nombre_calle);

				Constantes.sCalleProjectionMap.put(calle.comuna_id_comuna, calle.comuna_id_comuna);

				return Constantes.sCalleProjectionMap;

			}
public HashMap<String, String> CaracteristicaMap()
{

			Constantes.sCaracteristicaProjectionMap = new HashMap<String, String>();

				Constantes.sCaracteristicaProjectionMap.put(caracteristica.id_caracteristica, caracteristica.id_caracteristica);

				Constantes.sCaracteristicaProjectionMap.put(caracteristica.numero_caracteristica, caracteristica.numero_caracteristica);

				Constantes.sCaracteristicaProjectionMap.put(caracteristica.caracteristica, caracteristica.caracteristica);

				Constantes.sCaracteristicaProjectionMap.put(caracteristica.valor_caracteristica, caracteristica.valor_caracteristica);

				Constantes.sCaracteristicaProjectionMap.put(caracteristica.producto_id_producto, caracteristica.producto_id_producto);

				return Constantes.sCaracteristicaProjectionMap;

			}
public HashMap<String, String> Carne_empresaMap()
{

			Constantes.sCarne_empresaProjectionMap = new HashMap<String, String>();

				Constantes.sCarne_empresaProjectionMap.put(carne_empresa.id_carne_empresa, carne_empresa.id_carne_empresa);

				Constantes.sCarne_empresaProjectionMap.put(carne_empresa.nombre_usuario, carne_empresa.nombre_usuario);

				Constantes.sCarne_empresaProjectionMap.put(carne_empresa.clave_usuario, carne_empresa.clave_usuario);

				Constantes.sCarne_empresaProjectionMap.put(carne_empresa.empresa_id_empresa, carne_empresa.empresa_id_empresa);

				Constantes.sCarne_empresaProjectionMap.put(carne_empresa.persona_id_persona, carne_empresa.persona_id_persona);

				Constantes.sCarne_empresaProjectionMap.put(carne_empresa.tipo_usuario_id_tipo_usuario, carne_empresa.tipo_usuario_id_tipo_usuario);

				return Constantes.sCarne_empresaProjectionMap;

			}
public HashMap<String, String> Carne_empresacompletoMap()
{

			Constantes.sCarne_empresacompletoProjectionMap = new HashMap<String, String>();

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.id_carne_empresa, carne_empresacompleto.id_carne_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.nombre_usuario, carne_empresacompleto.nombre_usuario);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.clave_usuario, carne_empresacompleto.clave_usuario);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.tipo_usuario_id_tipo_usuario, carne_empresacompleto.tipo_usuario_id_tipo_usuario);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.id_empresa, carne_empresacompleto.id_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.rut_empresa, carne_empresacompleto.rut_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.digito_verificador_empresa, carne_empresacompleto.digito_verificador_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.nombre_empresa, carne_empresacompleto.nombre_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.nombre_contacto_empresa, carne_empresacompleto.nombre_contacto_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.cargo_contacto_empresa, carne_empresacompleto.cargo_contacto_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.email_empresa, carne_empresacompleto.email_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.alcance_empresa, carne_empresacompleto.alcance_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.telefono_empresa, carne_empresacompleto.telefono_empresa);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.actividad_id_actividad, carne_empresacompleto.actividad_id_actividad);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.id_persona, carne_empresacompleto.id_persona);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.rut_persona, carne_empresacompleto.rut_persona);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.digito_verificador, carne_empresacompleto.digito_verificador);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.nombre_persona, carne_empresacompleto.nombre_persona);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.segundo_nombre_persona, carne_empresacompleto.segundo_nombre_persona);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.apellido_persona, carne_empresacompleto.apellido_persona);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.segundo_apellido_persona, carne_empresacompleto.segundo_apellido_persona);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.actividad, carne_empresacompleto.actividad);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.area_actividad, carne_empresacompleto.area_actividad);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.dia_fecha_nacimiento, carne_empresacompleto.dia_fecha_nacimiento);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.mes_fecha_nacimiento, carne_empresacompleto.mes_fecha_nacimiento);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.ano_fecha_nacimiento, carne_empresacompleto.ano_fecha_nacimiento);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.edad, carne_empresacompleto.edad);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.email, carne_empresacompleto.email);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.celular, carne_empresacompleto.celular);

				Constantes.sCarne_empresacompletoProjectionMap.put(carne_empresacompleto.telefono, carne_empresacompleto.telefono);

				return Constantes.sCarne_empresacompletoProjectionMap;

			}
public HashMap<String, String> Carro_comprasMap()
{

			Constantes.sCarro_comprasProjectionMap = new HashMap<String, String>();

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.id_carro_compras, carro_compras.id_carro_compras);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.cantidad_carro, carro_compras.cantidad_carro);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.precio_carro, carro_compras.precio_carro);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.mayor, carro_compras.mayor);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.tienda, carro_compras.tienda);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.usuario_id_usuario, carro_compras.usuario_id_usuario);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.producto_id_producto, carro_compras.producto_id_producto);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.empresa_id_empresa, carro_compras.empresa_id_empresa);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.usado, carro_compras.usado);

				Constantes.sCarro_comprasProjectionMap.put(carro_compras.carne_empresa_id_carne_empresa, carro_compras.carne_empresa_id_carne_empresa);

				return Constantes.sCarro_comprasProjectionMap;

			}
public HashMap<String, String> Carro_comprascompletoMap()
{

			Constantes.sCarro_comprascompletoProjectionMap = new HashMap<String, String>();

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.id_carro_compras, carro_comprascompleto.id_carro_compras);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.cantidad_carro, carro_comprascompleto.cantidad_carro);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.precio_carro, carro_comprascompleto.precio_carro);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.mayor, carro_comprascompleto.mayor);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.tienda, carro_comprascompleto.tienda);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.usuario_id_usuario, carro_comprascompleto.usuario_id_usuario);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.usado, carro_comprascompleto.usado);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.carne_empresa_id_carne_empresa, carro_comprascompleto.carne_empresa_id_carne_empresa);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.id_precio, carro_comprascompleto.id_precio);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.precio_CLP, carro_comprascompleto.precio_CLP);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.precio_us, carro_comprascompleto.precio_us);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.precio_mayor_CLP, carro_comprascompleto.precio_mayor_CLP);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.precio_mayor_us, carro_comprascompleto.precio_mayor_us);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.precio_actual, carro_comprascompleto.precio_actual);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.descuento_promocion, carro_comprascompleto.descuento_promocion);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.cantidad_mayor, carro_comprascompleto.cantidad_mayor);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.id_producto, carro_comprascompleto.id_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.codigo_producto, carro_comprascompleto.codigo_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.numero_serie, carro_comprascompleto.numero_serie);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.descripcion_producto, carro_comprascompleto.descripcion_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.nombre_producto, carro_comprascompleto.nombre_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.marca_producto, carro_comprascompleto.marca_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.modelo_producto, carro_comprascompleto.modelo_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.contenido_unidad, carro_comprascompleto.contenido_unidad);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.unidad_minima, carro_comprascompleto.unidad_minima);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida, carro_comprascompleto.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.contenido, carro_comprascompleto.contenido);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.peso_neto, carro_comprascompleto.peso_neto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.alto_cm, carro_comprascompleto.alto_cm);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.ancho_cm, carro_comprascompleto.ancho_cm);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.fondo_cm, carro_comprascompleto.fondo_cm);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.fabricante, carro_comprascompleto.fabricante);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.familia_necesidad_id_familia_necesidad, carro_comprascompleto.familia_necesidad_id_familia_necesidad);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.familia_producto_id_familia_producto, carro_comprascompleto.familia_producto_id_familia_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.clase_producto, carro_comprascompleto.clase_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.linea_producto, carro_comprascompleto.linea_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.tipo_producto_id_tipo_producto, carro_comprascompleto.tipo_producto_id_tipo_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.hot, carro_comprascompleto.hot);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.subcategoria_id_subcategoria, carro_comprascompleto.subcategoria_id_subcategoria);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.SKU, carro_comprascompleto.SKU);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.formato_producto_id_formato_producto, carro_comprascompleto.formato_producto_id_formato_producto);

				Constantes.sCarro_comprascompletoProjectionMap.put(carro_comprascompleto.stock_tienda, carro_comprascompleto.stock_tienda);

				return Constantes.sCarro_comprascompletoProjectionMap;

			}
public HashMap<String, String> Carro_egresosMap()
{

			Constantes.sCarro_egresosProjectionMap = new HashMap<String, String>();

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.id_carro_egresos, carro_egresos.id_carro_egresos);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.cantidad_carro, carro_egresos.cantidad_carro);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.precio_carro, carro_egresos.precio_carro);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.mayor, carro_egresos.mayor);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.tienda, carro_egresos.tienda);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.usado, carro_egresos.usado);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.producto_id_producto, carro_egresos.producto_id_producto);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.usuario_id_usuario, carro_egresos.usuario_id_usuario);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.empresa_id_empresa, carro_egresos.empresa_id_empresa);

				Constantes.sCarro_egresosProjectionMap.put(carro_egresos.carne_empresa_id_carne_empresa, carro_egresos.carne_empresa_id_carne_empresa);

				return Constantes.sCarro_egresosProjectionMap;

			}
public HashMap<String, String> Carro_egresoscompletoMap()
{

			Constantes.sCarro_egresoscompletoProjectionMap = new HashMap<String, String>();

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.id_carro_egresos, carro_egresoscompleto.id_carro_egresos);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.cantidad_carro, carro_egresoscompleto.cantidad_carro);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.precio_carro, carro_egresoscompleto.precio_carro);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.mayor, carro_egresoscompleto.mayor);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.tienda, carro_egresoscompleto.tienda);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.usuario_id_usuario, carro_egresoscompleto.usuario_id_usuario);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.usado, carro_egresoscompleto.usado);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.carne_empresa_id_carne_empresa, carro_egresoscompleto.carne_empresa_id_carne_empresa);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.id_producto, carro_egresoscompleto.id_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.codigo_producto, carro_egresoscompleto.codigo_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.numero_serie, carro_egresoscompleto.numero_serie);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.descripcion_producto, carro_egresoscompleto.descripcion_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.nombre_producto, carro_egresoscompleto.nombre_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.marca_producto, carro_egresoscompleto.marca_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.modelo_producto, carro_egresoscompleto.modelo_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.contenido_unidad, carro_egresoscompleto.contenido_unidad);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.unidad_minima, carro_egresoscompleto.unidad_minima);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida, carro_egresoscompleto.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.contenido, carro_egresoscompleto.contenido);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.peso_neto, carro_egresoscompleto.peso_neto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.alto_cm, carro_egresoscompleto.alto_cm);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.ancho_cm, carro_egresoscompleto.ancho_cm);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.fondo_cm, carro_egresoscompleto.fondo_cm);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.fabricante, carro_egresoscompleto.fabricante);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.familia_necesidad_id_familia_necesidad, carro_egresoscompleto.familia_necesidad_id_familia_necesidad);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.familia_producto_id_familia_producto, carro_egresoscompleto.familia_producto_id_familia_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.clase_producto, carro_egresoscompleto.clase_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.linea_producto, carro_egresoscompleto.linea_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.tipo_producto_id_tipo_producto, carro_egresoscompleto.tipo_producto_id_tipo_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.hot, carro_egresoscompleto.hot);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.subcategoria_id_subcategoria, carro_egresoscompleto.subcategoria_id_subcategoria);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.SKU, carro_egresoscompleto.SKU);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.formato_producto_id_formato_producto, carro_egresoscompleto.formato_producto_id_formato_producto);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.stock_tienda, carro_egresoscompleto.stock_tienda);

				Constantes.sCarro_egresoscompletoProjectionMap.put(carro_egresoscompleto.precio_CLP, carro_egresoscompleto.precio_CLP);

				return Constantes.sCarro_egresoscompletoProjectionMap;

			}
public HashMap<String, String> Carro_egresosproductoMap()
{

			Constantes.sCarro_egresosproductoProjectionMap = new HashMap<String, String>();

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.id_carro_egresos, carro_egresosproducto.id_carro_egresos);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.cantidad_carro, carro_egresosproducto.cantidad_carro);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.precio_carro, carro_egresosproducto.precio_carro);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.mayor, carro_egresosproducto.mayor);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.tienda, carro_egresosproducto.tienda);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.usuario_id_usuario, carro_egresosproducto.usuario_id_usuario);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.usado, carro_egresosproducto.usado);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.carne_empresa_id_carne_empresa, carro_egresosproducto.carne_empresa_id_carne_empresa);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.id_producto, carro_egresosproducto.id_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.codigo_producto, carro_egresosproducto.codigo_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.numero_serie, carro_egresosproducto.numero_serie);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.descripcion_producto, carro_egresosproducto.descripcion_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.nombre_producto, carro_egresosproducto.nombre_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.marca_producto, carro_egresosproducto.marca_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.modelo_producto, carro_egresosproducto.modelo_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.contenido_unidad, carro_egresosproducto.contenido_unidad);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.unidad_minima, carro_egresosproducto.unidad_minima);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida, carro_egresosproducto.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.contenido, carro_egresosproducto.contenido);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.peso_neto, carro_egresosproducto.peso_neto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.alto_cm, carro_egresosproducto.alto_cm);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.ancho_cm, carro_egresosproducto.ancho_cm);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.fondo_cm, carro_egresosproducto.fondo_cm);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.fabricante, carro_egresosproducto.fabricante);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.familia_necesidad_id_familia_necesidad, carro_egresosproducto.familia_necesidad_id_familia_necesidad);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.familia_producto_id_familia_producto, carro_egresosproducto.familia_producto_id_familia_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.clase_producto, carro_egresosproducto.clase_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.linea_producto, carro_egresosproducto.linea_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.tipo_producto_id_tipo_producto, carro_egresosproducto.tipo_producto_id_tipo_producto);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.hot, carro_egresosproducto.hot);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.subcategoria_id_subcategoria, carro_egresosproducto.subcategoria_id_subcategoria);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.SKU, carro_egresosproducto.SKU);

				Constantes.sCarro_egresosproductoProjectionMap.put(carro_egresosproducto.formato_producto_id_formato_producto, carro_egresosproducto.formato_producto_id_formato_producto);

				return Constantes.sCarro_egresosproductoProjectionMap;

			}
public HashMap<String, String> Carro_ventaMap()
{

			Constantes.sCarro_ventaProjectionMap = new HashMap<String, String>();

				Constantes.sCarro_ventaProjectionMap.put(carro_venta.id_carro_venta, carro_venta.id_carro_venta);

				Constantes.sCarro_ventaProjectionMap.put(carro_venta.cantidad, carro_venta.cantidad);

				Constantes.sCarro_ventaProjectionMap.put(carro_venta.precio, carro_venta.precio);

				Constantes.sCarro_ventaProjectionMap.put(carro_venta.carro_compras_id_carro_compras, carro_venta.carro_compras_id_carro_compras);

				Constantes.sCarro_ventaProjectionMap.put(carro_venta.venta_id_venta, carro_venta.venta_id_venta);

				return Constantes.sCarro_ventaProjectionMap;

			}
public HashMap<String, String> Carro_ventacompletoMap()
{

			Constantes.sCarro_ventacompletoProjectionMap = new HashMap<String, String>();

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.id_carro_venta, carro_ventacompleto.id_carro_venta);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.cantidad, carro_ventacompleto.cantidad);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.precio, carro_ventacompleto.precio);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.venta_id_venta, carro_ventacompleto.venta_id_venta);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.id_carro_compras, carro_ventacompleto.id_carro_compras);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.cantidad_carro, carro_ventacompleto.cantidad_carro);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.precio_carro, carro_ventacompleto.precio_carro);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.mayor, carro_ventacompleto.mayor);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.tienda, carro_ventacompleto.tienda);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.usuario_id_usuario, carro_ventacompleto.usuario_id_usuario);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.usado, carro_ventacompleto.usado);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.carne_empresa_id_carne_empresa, carro_ventacompleto.carne_empresa_id_carne_empresa);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.id_precio, carro_ventacompleto.id_precio);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.precio_CLP, carro_ventacompleto.precio_CLP);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.precio_us, carro_ventacompleto.precio_us);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.precio_mayor_CLP, carro_ventacompleto.precio_mayor_CLP);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.precio_mayor_us, carro_ventacompleto.precio_mayor_us);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.precio_actual, carro_ventacompleto.precio_actual);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.descuento_promocion, carro_ventacompleto.descuento_promocion);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.cantidad_mayor, carro_ventacompleto.cantidad_mayor);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.id_producto, carro_ventacompleto.id_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.codigo_producto, carro_ventacompleto.codigo_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.numero_serie, carro_ventacompleto.numero_serie);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.descripcion_producto, carro_ventacompleto.descripcion_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.nombre_producto, carro_ventacompleto.nombre_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.marca_producto, carro_ventacompleto.marca_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.modelo_producto, carro_ventacompleto.modelo_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.contenido_unidad, carro_ventacompleto.contenido_unidad);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.unidad_minima, carro_ventacompleto.unidad_minima);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida, carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.contenido, carro_ventacompleto.contenido);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.peso_neto, carro_ventacompleto.peso_neto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.alto_cm, carro_ventacompleto.alto_cm);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.ancho_cm, carro_ventacompleto.ancho_cm);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.fondo_cm, carro_ventacompleto.fondo_cm);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.fabricante, carro_ventacompleto.fabricante);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.familia_necesidad_id_familia_necesidad, carro_ventacompleto.familia_necesidad_id_familia_necesidad);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.familia_producto_id_familia_producto, carro_ventacompleto.familia_producto_id_familia_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.clase_producto, carro_ventacompleto.clase_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.linea_producto, carro_ventacompleto.linea_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.tipo_producto_id_tipo_producto, carro_ventacompleto.tipo_producto_id_tipo_producto);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.hot, carro_ventacompleto.hot);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.subcategoria_id_subcategoria, carro_ventacompleto.subcategoria_id_subcategoria);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.SKU, carro_ventacompleto.SKU);

				Constantes.sCarro_ventacompletoProjectionMap.put(carro_ventacompleto.formato_producto_id_formato_producto, carro_ventacompleto.formato_producto_id_formato_producto);

				return Constantes.sCarro_ventacompletoProjectionMap;

			}
public HashMap<String, String> CategoriaMap()
{

			Constantes.sCategoriaProjectionMap = new HashMap<String, String>();

				Constantes.sCategoriaProjectionMap.put(categoria.id_categoria, categoria.id_categoria);

				Constantes.sCategoriaProjectionMap.put(categoria.nombre_categoria, categoria.nombre_categoria);

				return Constantes.sCategoriaProjectionMap;

			}
public HashMap<String, String> Categoria_empresaMap()
{

			Constantes.sCategoria_empresaProjectionMap = new HashMap<String, String>();

				Constantes.sCategoria_empresaProjectionMap.put(categoria_empresa.id_categoria_empresa, categoria_empresa.id_categoria_empresa);

				Constantes.sCategoria_empresaProjectionMap.put(categoria_empresa.nombre_categoria_empresa, categoria_empresa.nombre_categoria_empresa);

				return Constantes.sCategoria_empresaProjectionMap;

			}
public HashMap<String, String> Ci_sessionsMap()
{

			Constantes.sCi_sessionsProjectionMap = new HashMap<String, String>();

				Constantes.sCi_sessionsProjectionMap.put(ci_sessions.session_id, ci_sessions.session_id);

				Constantes.sCi_sessionsProjectionMap.put(ci_sessions.ip_address, ci_sessions.ip_address);

				Constantes.sCi_sessionsProjectionMap.put(ci_sessions.user_agent, ci_sessions.user_agent);

				Constantes.sCi_sessionsProjectionMap.put(ci_sessions.id_user, ci_sessions.id_user);

				Constantes.sCi_sessionsProjectionMap.put(ci_sessions.nombre_apellido, ci_sessions.nombre_apellido);

				Constantes.sCi_sessionsProjectionMap.put(ci_sessions.email_user, ci_sessions.email_user);

				Constantes.sCi_sessionsProjectionMap.put(ci_sessions.last_activity, ci_sessions.last_activity);

				Constantes.sCi_sessionsProjectionMap.put(ci_sessions.user_data, ci_sessions.user_data);

				return Constantes.sCi_sessionsProjectionMap;

			}
public HashMap<String, String> ClienteMap()
{

			Constantes.sClienteProjectionMap = new HashMap<String, String>();

				Constantes.sClienteProjectionMap.put(cliente.id_cliente, cliente.id_cliente);

				Constantes.sClienteProjectionMap.put(cliente.rut_cliente, cliente.rut_cliente);

				Constantes.sClienteProjectionMap.put(cliente.digito_verificador, cliente.digito_verificador);

				Constantes.sClienteProjectionMap.put(cliente.nombre_cliente, cliente.nombre_cliente);

				Constantes.sClienteProjectionMap.put(cliente.segundo_nombre_cliente, cliente.segundo_nombre_cliente);

				Constantes.sClienteProjectionMap.put(cliente.apellido_cliente, cliente.apellido_cliente);

				Constantes.sClienteProjectionMap.put(cliente.segundo_apellido_cliente, cliente.segundo_apellido_cliente);

				Constantes.sClienteProjectionMap.put(cliente.actividad, cliente.actividad);

				Constantes.sClienteProjectionMap.put(cliente.area_actividad, cliente.area_actividad);

				Constantes.sClienteProjectionMap.put(cliente.dia_fecha_nacimiento, cliente.dia_fecha_nacimiento);

				Constantes.sClienteProjectionMap.put(cliente.mes_fecha_nacimiento, cliente.mes_fecha_nacimiento);

				Constantes.sClienteProjectionMap.put(cliente.ano_fecha_nacimiento, cliente.ano_fecha_nacimiento);

				Constantes.sClienteProjectionMap.put(cliente.edad, cliente.edad);

				Constantes.sClienteProjectionMap.put(cliente.email, cliente.email);

				Constantes.sClienteProjectionMap.put(cliente.celular, cliente.celular);

				Constantes.sClienteProjectionMap.put(cliente.telefono, cliente.telefono);

				return Constantes.sClienteProjectionMap;

			}
public HashMap<String, String> Cliente_empresaMap()
{

			Constantes.sCliente_empresaProjectionMap = new HashMap<String, String>();

				Constantes.sCliente_empresaProjectionMap.put(cliente_empresa.id_cliente_empresa, cliente_empresa.id_cliente_empresa);

				Constantes.sCliente_empresaProjectionMap.put(cliente_empresa.rut_cliente_empresa, cliente_empresa.rut_cliente_empresa);

				Constantes.sCliente_empresaProjectionMap.put(cliente_empresa.digito_verificador, cliente_empresa.digito_verificador);

				Constantes.sCliente_empresaProjectionMap.put(cliente_empresa.nombre, cliente_empresa.nombre);

				Constantes.sCliente_empresaProjectionMap.put(cliente_empresa.email_cliente_empresa, cliente_empresa.email_cliente_empresa);

				Constantes.sCliente_empresaProjectionMap.put(cliente_empresa.actividad_id_actividad, cliente_empresa.actividad_id_actividad);

				Constantes.sCliente_empresaProjectionMap.put(cliente_empresa.empresa_id_empresa, cliente_empresa.empresa_id_empresa);

				return Constantes.sCliente_empresaProjectionMap;

			}
public HashMap<String, String> CompracompletaMap()
{

			Constantes.sCompracompletaProjectionMap = new HashMap<String, String>();

				Constantes.sCompracompletaProjectionMap.put(compracompleta.id_factura, compracompleta.id_factura);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.rol_factura, compracompleta.rol_factura);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.dia_factura, compracompleta.dia_factura);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.mes_factura, compracompleta.mes_factura);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.ano_factura, compracompleta.ano_factura);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.fecha_factura, compracompleta.fecha_factura);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.empresa_id_empresa, compracompleta.empresa_id_empresa);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.carne_empresa_id_carne_empresa, compracompleta.carne_empresa_id_carne_empresa);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.rut_proveedor, compracompleta.rut_proveedor);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.nombre_proveedor, compracompleta.nombre_proveedor);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.telefono_proveedor, compracompleta.telefono_proveedor);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.tipo_documento_id_tipo_documento, compracompleta.tipo_documento_id_tipo_documento);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.tipo_pago_id_tipo_pago, compracompleta.tipo_pago_id_tipo_pago);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.total_factura, compracompleta.total_factura);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.id_tipo_pago, compracompleta.id_tipo_pago);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.nombre_tipo_pago, compracompleta.nombre_tipo_pago);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.comision_tipo_pago, compracompleta.comision_tipo_pago);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.id_tipo_documento, compracompleta.id_tipo_documento);

				Constantes.sCompracompletaProjectionMap.put(compracompleta.nombre_tipo_documento, compracompleta.nombre_tipo_documento);

				return Constantes.sCompracompletaProjectionMap;

			}
public HashMap<String, String> ComunaMap()
{

			Constantes.sComunaProjectionMap = new HashMap<String, String>();

				Constantes.sComunaProjectionMap.put(comuna.id_comuna, comuna.id_comuna);

				Constantes.sComunaProjectionMap.put(comuna.codigo_comuna, comuna.codigo_comuna);

				Constantes.sComunaProjectionMap.put(comuna.nombre_comuna, comuna.nombre_comuna);

				Constantes.sComunaProjectionMap.put(comuna.provincia_id_provincia, comuna.provincia_id_provincia);

				return Constantes.sComunaProjectionMap;

			}
public HashMap<String, String> Contenido_unidad_medidaMap()
{

			Constantes.sContenido_unidad_medidaProjectionMap = new HashMap<String, String>();

				Constantes.sContenido_unidad_medidaProjectionMap.put(contenido_unidad_medida.id_contenido_unidad_medida, contenido_unidad_medida.id_contenido_unidad_medida);

				Constantes.sContenido_unidad_medidaProjectionMap.put(contenido_unidad_medida.nombre_contenido_unidad_medida, contenido_unidad_medida.nombre_contenido_unidad_medida);

				return Constantes.sContenido_unidad_medidaProjectionMap;

			}
public HashMap<String, String> DiaMap()
{

			Constantes.sDiaProjectionMap = new HashMap<String, String>();

				Constantes.sDiaProjectionMap.put(dia.iddia, dia.iddia);

				Constantes.sDiaProjectionMap.put(dia.dia, dia.dia);

				Constantes.sDiaProjectionMap.put(dia.mes, dia.mes);

				Constantes.sDiaProjectionMap.put(dia.anno, dia.anno);

				Constantes.sDiaProjectionMap.put(dia.fecha, dia.fecha);

				Constantes.sDiaProjectionMap.put(dia.egreso, dia.egreso);

				Constantes.sDiaProjectionMap.put(dia.ingreso, dia.ingreso);

				Constantes.sDiaProjectionMap.put(dia.impuesto, dia.impuesto);

				return Constantes.sDiaProjectionMap;

			}
public HashMap<String, String> EmpresaMap()
{

			Constantes.sEmpresaProjectionMap = new HashMap<String, String>();

				Constantes.sEmpresaProjectionMap.put(empresa.id_empresa, empresa.id_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.rut_empresa, empresa.rut_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.digito_verificador_empresa, empresa.digito_verificador_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.nombre_empresa, empresa.nombre_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.nombre_contacto_empresa, empresa.nombre_contacto_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.cargo_contacto_empresa, empresa.cargo_contacto_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.email_empresa, empresa.email_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.alcance_empresa, empresa.alcance_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.telefono_empresa, empresa.telefono_empresa);

				Constantes.sEmpresaProjectionMap.put(empresa.actividad_id_actividad, empresa.actividad_id_actividad);

				Constantes.sEmpresaProjectionMap.put(empresa.tipo_empresa_id_tipo_empresa, empresa.tipo_empresa_id_tipo_empresa);

				return Constantes.sEmpresaProjectionMap;

			}
public HashMap<String, String> EnvioMap()
{

			Constantes.sEnvioProjectionMap = new HashMap<String, String>();

				Constantes.sEnvioProjectionMap.put(envio.id_envio, envio.id_envio);

				Constantes.sEnvioProjectionMap.put(envio.direccion_alternativa, envio.direccion_alternativa);

				Constantes.sEnvioProjectionMap.put(envio.fecha_entrega, envio.fecha_entrega);

				Constantes.sEnvioProjectionMap.put(envio.hora_entrega, envio.hora_entrega);

				Constantes.sEnvioProjectionMap.put(envio.venta_id_venta, envio.venta_id_venta);

				Constantes.sEnvioProjectionMap.put(envio.enviado, envio.enviado);

				return Constantes.sEnvioProjectionMap;

			}
public HashMap<String, String> FacturaMap()
{

			Constantes.sFacturaProjectionMap = new HashMap<String, String>();

				Constantes.sFacturaProjectionMap.put(factura.id_factura, factura.id_factura);

				Constantes.sFacturaProjectionMap.put(factura.rol_factura, factura.rol_factura);

				Constantes.sFacturaProjectionMap.put(factura.dia_factura, factura.dia_factura);

				Constantes.sFacturaProjectionMap.put(factura.mes_factura, factura.mes_factura);

				Constantes.sFacturaProjectionMap.put(factura.ano_factura, factura.ano_factura);

				Constantes.sFacturaProjectionMap.put(factura.fecha_factura, factura.fecha_factura);

				Constantes.sFacturaProjectionMap.put(factura.empresa_id_empresa, factura.empresa_id_empresa);

				Constantes.sFacturaProjectionMap.put(factura.carne_empresa_id_carne_empresa, factura.carne_empresa_id_carne_empresa);

				Constantes.sFacturaProjectionMap.put(factura.rut_proveedor, factura.rut_proveedor);

				Constantes.sFacturaProjectionMap.put(factura.nombre_proveedor, factura.nombre_proveedor);

				Constantes.sFacturaProjectionMap.put(factura.telefono_proveedor, factura.telefono_proveedor);

				Constantes.sFacturaProjectionMap.put(factura.tipo_documento_id_tipo_documento, factura.tipo_documento_id_tipo_documento);

				Constantes.sFacturaProjectionMap.put(factura.tipo_pago_id_tipo_pago, factura.tipo_pago_id_tipo_pago);

				Constantes.sFacturaProjectionMap.put(factura.total_factura, factura.total_factura);

				return Constantes.sFacturaProjectionMap;

			}
public HashMap<String, String> Familia_necesidadMap()
{

			Constantes.sFamilia_necesidadProjectionMap = new HashMap<String, String>();

				Constantes.sFamilia_necesidadProjectionMap.put(familia_necesidad.id_familia_necesidad, familia_necesidad.id_familia_necesidad);

				Constantes.sFamilia_necesidadProjectionMap.put(familia_necesidad.nombre_familia_necesidad, familia_necesidad.nombre_familia_necesidad);

				return Constantes.sFamilia_necesidadProjectionMap;

			}
public HashMap<String, String> Familia_productoMap()
{

			Constantes.sFamilia_productoProjectionMap = new HashMap<String, String>();

				Constantes.sFamilia_productoProjectionMap.put(familia_producto.id_familia_producto, familia_producto.id_familia_producto);

				Constantes.sFamilia_productoProjectionMap.put(familia_producto.nombre_familia_producto, familia_producto.nombre_familia_producto);

				return Constantes.sFamilia_productoProjectionMap;

			}
public HashMap<String, String> Formato_productoMap()
{

			Constantes.sFormato_productoProjectionMap = new HashMap<String, String>();

				Constantes.sFormato_productoProjectionMap.put(formato_producto.id_formato_producto, formato_producto.id_formato_producto);

				Constantes.sFormato_productoProjectionMap.put(formato_producto.nombre_formato_producto, formato_producto.nombre_formato_producto);

				return Constantes.sFormato_productoProjectionMap;

			}
public HashMap<String, String> GastoMap()
{

			Constantes.sGastoProjectionMap = new HashMap<String, String>();

				Constantes.sGastoProjectionMap.put(gasto.id_gasto, gasto.id_gasto);

				Constantes.sGastoProjectionMap.put(gasto.nombre_gasto, gasto.nombre_gasto);

				Constantes.sGastoProjectionMap.put(gasto.id_usuario, gasto.id_usuario);

				Constantes.sGastoProjectionMap.put(gasto.monto_gasto, gasto.monto_gasto);

				Constantes.sGastoProjectionMap.put(gasto.fecha_gasto, gasto.fecha_gasto);

				Constantes.sGastoProjectionMap.put(gasto.empresa_id_empre, gasto.empresa_id_empre);

				return Constantes.sGastoProjectionMap;

			}
public HashMap<String, String> Geocode_cacheMap()
{

			Constantes.sGeocode_cacheProjectionMap = new HashMap<String, String>();

				Constantes.sGeocode_cacheProjectionMap.put(geocode_cache.id, geocode_cache.id);

				Constantes.sGeocode_cacheProjectionMap.put(geocode_cache.lng, geocode_cache.lng);

				Constantes.sGeocode_cacheProjectionMap.put(geocode_cache.lat, geocode_cache.lat);

				Constantes.sGeocode_cacheProjectionMap.put(geocode_cache.query, geocode_cache.query);

				return Constantes.sGeocode_cacheProjectionMap;

			}
public HashMap<String, String> ImagenprodMap()
{

			Constantes.sImagenprodProjectionMap = new HashMap<String, String>();

				Constantes.sImagenprodProjectionMap.put(imagenprod.id_imagenprod, imagenprod.id_imagenprod);

				Constantes.sImagenprodProjectionMap.put(imagenprod.urlimagenprod, imagenprod.urlimagenprod);

				Constantes.sImagenprodProjectionMap.put(imagenprod.producto_id_producto, imagenprod.producto_id_producto);

				return Constantes.sImagenprodProjectionMap;

			}
public HashMap<String, String> ImpuestoMap()
{

			Constantes.sImpuestoProjectionMap = new HashMap<String, String>();

				Constantes.sImpuestoProjectionMap.put(impuesto.id_impuesto, impuesto.id_impuesto);

				Constantes.sImpuestoProjectionMap.put(impuesto.nombre_impuesto, impuesto.nombre_impuesto);

				Constantes.sImpuestoProjectionMap.put(impuesto.valor_impuesto, impuesto.valor_impuesto);

				return Constantes.sImpuestoProjectionMap;

			}
public HashMap<String, String> IngresosegresosMap()
{

			Constantes.sIngresosegresosProjectionMap = new HashMap<String, String>();

				Constantes.sIngresosegresosProjectionMap.put(ingresosegresos.dia, ingresosegresos.dia);

				Constantes.sIngresosegresosProjectionMap.put(ingresosegresos.mes, ingresosegresos.mes);

				Constantes.sIngresosegresosProjectionMap.put(ingresosegresos.anno, ingresosegresos.anno);

				Constantes.sIngresosegresosProjectionMap.put(ingresosegresos.fecha, ingresosegresos.fecha);

				Constantes.sIngresosegresosProjectionMap.put(ingresosegresos.totalingreso, ingresosegresos.totalingreso);

				Constantes.sIngresosegresosProjectionMap.put(ingresosegresos.totalgasto, ingresosegresos.totalgasto);

				Constantes.sIngresosegresosProjectionMap.put(ingresosegresos.impuestoegreso, ingresosegresos.impuestoegreso);

				Constantes.sIngresosegresosProjectionMap.put(ingresosegresos.impuestoingreso, ingresosegresos.impuestoingreso);

				return Constantes.sIngresosegresosProjectionMap;

			}
public HashMap<String, String> Item_facturaMap()
{

			Constantes.sItem_facturaProjectionMap = new HashMap<String, String>();

				Constantes.sItem_facturaProjectionMap.put(item_factura.id_itemfactura, item_factura.id_itemfactura);

				Constantes.sItem_facturaProjectionMap.put(item_factura.cantidad, item_factura.cantidad);

				Constantes.sItem_facturaProjectionMap.put(item_factura.precio, item_factura.precio);

				Constantes.sItem_facturaProjectionMap.put(item_factura.producto_id_producto, item_factura.producto_id_producto);

				Constantes.sItem_facturaProjectionMap.put(item_factura.factura_id_factura, item_factura.factura_id_factura);

				Constantes.sItem_facturaProjectionMap.put(item_factura.carro_egresos_id_carro_egresos, item_factura.carro_egresos_id_carro_egresos);

				return Constantes.sItem_facturaProjectionMap;

			}
public HashMap<String, String> Item_facturacompletoMap()
{

			Constantes.sItem_facturacompletoProjectionMap = new HashMap<String, String>();

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.id_itemfactura, item_facturacompleto.id_itemfactura);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.cantidad, item_facturacompleto.cantidad);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.precio, item_facturacompleto.precio);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.producto_id_producto, item_facturacompleto.producto_id_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.factura_id_factura, item_facturacompleto.factura_id_factura);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.id_producto, item_facturacompleto.id_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.codigo_producto, item_facturacompleto.codigo_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.numero_serie, item_facturacompleto.numero_serie);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.descripcion_producto, item_facturacompleto.descripcion_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.nombre_producto, item_facturacompleto.nombre_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.marca_producto, item_facturacompleto.marca_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.modelo_producto, item_facturacompleto.modelo_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.contenido_unidad, item_facturacompleto.contenido_unidad);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida, item_facturacompleto.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.unidad_minima, item_facturacompleto.unidad_minima);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.contenido, item_facturacompleto.contenido);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.peso_neto, item_facturacompleto.peso_neto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.alto_cm, item_facturacompleto.alto_cm);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.ancho_cm, item_facturacompleto.ancho_cm);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.fondo_cm, item_facturacompleto.fondo_cm);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.fabricante, item_facturacompleto.fabricante);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.clase_producto, item_facturacompleto.clase_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.linea_producto, item_facturacompleto.linea_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.hot, item_facturacompleto.hot);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.SKU, item_facturacompleto.SKU);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.subcategoria_id_subcategoria, item_facturacompleto.subcategoria_id_subcategoria);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.tipo_producto_id_tipo_producto, item_facturacompleto.tipo_producto_id_tipo_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.formato_producto_id_formato_producto, item_facturacompleto.formato_producto_id_formato_producto);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.familia_necesidad_id_familia_necesidad, item_facturacompleto.familia_necesidad_id_familia_necesidad);

				Constantes.sItem_facturacompletoProjectionMap.put(item_facturacompleto.familia_producto_id_familia_producto, item_facturacompleto.familia_producto_id_familia_producto);

				return Constantes.sItem_facturacompletoProjectionMap;

			}
public HashMap<String, String> MapaMap()
{

			Constantes.sMapaProjectionMap = new HashMap<String, String>();

				Constantes.sMapaProjectionMap.put(mapa.id, mapa.id);

				Constantes.sMapaProjectionMap.put(mapa.name, mapa.name);

				Constantes.sMapaProjectionMap.put(mapa.direccion, mapa.direccion);

				Constantes.sMapaProjectionMap.put(mapa.lat, mapa.lat);

				Constantes.sMapaProjectionMap.put(mapa.lng, mapa.lng);

				Constantes.sMapaProjectionMap.put(mapa.tipo, mapa.tipo);

				Constantes.sMapaProjectionMap.put(mapa.imagen, mapa.imagen);

				return Constantes.sMapaProjectionMap;

			}
public HashMap<String, String> PaisMap()
{

			Constantes.sPaisProjectionMap = new HashMap<String, String>();

				Constantes.sPaisProjectionMap.put(pais.id_pais, pais.id_pais);

				Constantes.sPaisProjectionMap.put(pais.nombre_pais, pais.nombre_pais);

				Constantes.sPaisProjectionMap.put(pais.iso_code_2_pais, pais.iso_code_2_pais);

				Constantes.sPaisProjectionMap.put(pais.iso_code_3_pais, pais.iso_code_3_pais);

				Constantes.sPaisProjectionMap.put(pais.address_format, pais.address_format);

				Constantes.sPaisProjectionMap.put(pais.iso_code_number, pais.iso_code_number);

				return Constantes.sPaisProjectionMap;

			}
public HashMap<String, String> PersonaMap()
{

			Constantes.sPersonaProjectionMap = new HashMap<String, String>();

				Constantes.sPersonaProjectionMap.put(persona.id_persona, persona.id_persona);

				Constantes.sPersonaProjectionMap.put(persona.rut_persona, persona.rut_persona);

				Constantes.sPersonaProjectionMap.put(persona.digito_verificador, persona.digito_verificador);

				Constantes.sPersonaProjectionMap.put(persona.nombre_persona, persona.nombre_persona);

				Constantes.sPersonaProjectionMap.put(persona.segundo_nombre_persona, persona.segundo_nombre_persona);

				Constantes.sPersonaProjectionMap.put(persona.apellido_persona, persona.apellido_persona);

				Constantes.sPersonaProjectionMap.put(persona.segundo_apellido_persona, persona.segundo_apellido_persona);

				Constantes.sPersonaProjectionMap.put(persona.actividad, persona.actividad);

				Constantes.sPersonaProjectionMap.put(persona.area_actividad, persona.area_actividad);

				Constantes.sPersonaProjectionMap.put(persona.dia_fecha_nacimiento, persona.dia_fecha_nacimiento);

				Constantes.sPersonaProjectionMap.put(persona.mes_fecha_nacimiento, persona.mes_fecha_nacimiento);

				Constantes.sPersonaProjectionMap.put(persona.ano_fecha_nacimiento, persona.ano_fecha_nacimiento);

				Constantes.sPersonaProjectionMap.put(persona.edad, persona.edad);

				Constantes.sPersonaProjectionMap.put(persona.email, persona.email);

				Constantes.sPersonaProjectionMap.put(persona.celular, persona.celular);

				Constantes.sPersonaProjectionMap.put(persona.telefono, persona.telefono);

				return Constantes.sPersonaProjectionMap;

			}
public HashMap<String, String> PrecioMap()
{

			Constantes.sPrecioProjectionMap = new HashMap<String, String>();

				Constantes.sPrecioProjectionMap.put(precio.id_precio, precio.id_precio);

				Constantes.sPrecioProjectionMap.put(precio.precio_CLP, precio.precio_CLP);

				Constantes.sPrecioProjectionMap.put(precio.precio_us, precio.precio_us);

				Constantes.sPrecioProjectionMap.put(precio.precio_mayor_CLP, precio.precio_mayor_CLP);

				Constantes.sPrecioProjectionMap.put(precio.precio_mayor_us, precio.precio_mayor_us);

				Constantes.sPrecioProjectionMap.put(precio.precio_actual, precio.precio_actual);

				Constantes.sPrecioProjectionMap.put(precio.descuento_promocion, precio.descuento_promocion);

				Constantes.sPrecioProjectionMap.put(precio.cantidad_mayor, precio.cantidad_mayor);

				Constantes.sPrecioProjectionMap.put(precio.empresa_id_empresa, precio.empresa_id_empresa);

				Constantes.sPrecioProjectionMap.put(precio.producto_id_producto, precio.producto_id_producto);

				return Constantes.sPrecioProjectionMap;

			}
public HashMap<String, String> ProductoMap()
{

			Constantes.sProductoProjectionMap = new HashMap<String, String>();

				Constantes.sProductoProjectionMap.put(producto.id_producto, producto.id_producto);

				Constantes.sProductoProjectionMap.put(producto.codigo_producto, producto.codigo_producto);

				Constantes.sProductoProjectionMap.put(producto.numero_serie, producto.numero_serie);

				Constantes.sProductoProjectionMap.put(producto.descripcion_producto, producto.descripcion_producto);

				Constantes.sProductoProjectionMap.put(producto.nombre_producto, producto.nombre_producto);

				Constantes.sProductoProjectionMap.put(producto.marca_producto, producto.marca_producto);

				Constantes.sProductoProjectionMap.put(producto.modelo_producto, producto.modelo_producto);

				Constantes.sProductoProjectionMap.put(producto.contenido_unidad, producto.contenido_unidad);

				Constantes.sProductoProjectionMap.put(producto.contenido_unidad_medida_id_contenido_unidad_medida, producto.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sProductoProjectionMap.put(producto.unidad_minima, producto.unidad_minima);

				Constantes.sProductoProjectionMap.put(producto.contenido, producto.contenido);

				Constantes.sProductoProjectionMap.put(producto.peso_neto, producto.peso_neto);

				Constantes.sProductoProjectionMap.put(producto.alto_cm, producto.alto_cm);

				Constantes.sProductoProjectionMap.put(producto.ancho_cm, producto.ancho_cm);

				Constantes.sProductoProjectionMap.put(producto.fondo_cm, producto.fondo_cm);

				Constantes.sProductoProjectionMap.put(producto.fabricante, producto.fabricante);

				Constantes.sProductoProjectionMap.put(producto.clase_producto, producto.clase_producto);

				Constantes.sProductoProjectionMap.put(producto.linea_producto, producto.linea_producto);

				Constantes.sProductoProjectionMap.put(producto.hot, producto.hot);

				Constantes.sProductoProjectionMap.put(producto.SKU, producto.SKU);

				Constantes.sProductoProjectionMap.put(producto.subcategoria_id_subcategoria, producto.subcategoria_id_subcategoria);

				Constantes.sProductoProjectionMap.put(producto.tipo_producto_id_tipo_producto, producto.tipo_producto_id_tipo_producto);

				Constantes.sProductoProjectionMap.put(producto.formato_producto_id_formato_producto, producto.formato_producto_id_formato_producto);

				Constantes.sProductoProjectionMap.put(producto.familia_necesidad_id_familia_necesidad, producto.familia_necesidad_id_familia_necesidad);

				Constantes.sProductoProjectionMap.put(producto.familia_producto_id_familia_producto, producto.familia_producto_id_familia_producto);

				return Constantes.sProductoProjectionMap;

			}
public HashMap<String, String> ProductocompletoMap()
{

			Constantes.sProductocompletoProjectionMap = new HashMap<String, String>();

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_producto, productocompleto.id_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.codigo_producto, productocompleto.codigo_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.numero_serie, productocompleto.numero_serie);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.descripcion_producto, productocompleto.descripcion_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.nombre_producto, productocompleto.nombre_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.marca_producto, productocompleto.marca_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.modelo_producto, productocompleto.modelo_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.contenido_unidad, productocompleto.contenido_unidad);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.unidad_minima, productocompleto.unidad_minima);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.contenido_unidad_medida_id_contenido_unidad_medida, productocompleto.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.contenido, productocompleto.contenido);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.peso_neto, productocompleto.peso_neto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.alto_cm, productocompleto.alto_cm);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.ancho_cm, productocompleto.ancho_cm);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.fondo_cm, productocompleto.fondo_cm);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.fabricante, productocompleto.fabricante);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.familia_necesidad_id_familia_necesidad, productocompleto.familia_necesidad_id_familia_necesidad);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.familia_producto_id_familia_producto, productocompleto.familia_producto_id_familia_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.clase_producto, productocompleto.clase_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.linea_producto, productocompleto.linea_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.tipo_producto_id_tipo_producto, productocompleto.tipo_producto_id_tipo_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.hot, productocompleto.hot);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.subcategoria_id_subcategoria, productocompleto.subcategoria_id_subcategoria);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.SKU, productocompleto.SKU);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.formato_producto_id_formato_producto, productocompleto.formato_producto_id_formato_producto);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_caracteristica, productocompleto.id_caracteristica);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.numero_caracteristica, productocompleto.numero_caracteristica);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.caracteristica, productocompleto.caracteristica);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.valor_caracteristica, productocompleto.valor_caracteristica);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_categoria, productocompleto.id_categoria);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.nombre_categoria, productocompleto.nombre_categoria);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_empresa, productocompleto.id_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.rut_empresa, productocompleto.rut_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.digito_verificador_empresa, productocompleto.digito_verificador_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.nombre_empresa, productocompleto.nombre_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.nombre_contacto_empresa, productocompleto.nombre_contacto_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.cargo_contacto_empresa, productocompleto.cargo_contacto_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.email_empresa, productocompleto.email_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.alcance_empresa, productocompleto.alcance_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.telefono_empresa, productocompleto.telefono_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.actividad_id_actividad, productocompleto.actividad_id_actividad);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_imagenprod, productocompleto.id_imagenprod);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.urlimagenprod, productocompleto.urlimagenprod);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_precio, productocompleto.id_precio);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.precio_CLP, productocompleto.precio_CLP);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.precio_us, productocompleto.precio_us);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.precio_mayor_CLP, productocompleto.precio_mayor_CLP);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.precio_mayor_us, productocompleto.precio_mayor_us);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.precio_actual, productocompleto.precio_actual);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.descuento_promocion, productocompleto.descuento_promocion);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.cantidad_mayor, productocompleto.cantidad_mayor);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_reciclado, productocompleto.id_reciclado);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.reciclable, productocompleto.reciclable);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.reciclado, productocompleto.reciclado);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.valor_reciclaje, productocompleto.valor_reciclaje);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.empresa_id_empresa, productocompleto.empresa_id_empresa);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_stock, productocompleto.id_stock);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.stock_real, productocompleto.stock_real);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.stock_minimo, productocompleto.stock_minimo);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.stock_ideal, productocompleto.stock_ideal);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.stock_tienda, productocompleto.stock_tienda);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.stock_virtual, productocompleto.stock_virtual);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.stock_vendido, productocompleto.stock_vendido);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.last_update, productocompleto.last_update);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_subcategoria, productocompleto.id_subcategoria);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.nombre_subcategoria, productocompleto.nombre_subcategoria);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.descripcion_subcategoria, productocompleto.descripcion_subcategoria);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.categoria_id_categoria, productocompleto.categoria_id_categoria);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_talla, productocompleto.id_talla);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.am_largo, productocompleto.am_largo);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.am_ancho, productocompleto.am_ancho);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.am_fondo, productocompleto.am_fondo);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.eu_largo, productocompleto.eu_largo);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.eu_ancho, productocompleto.eu_ancho);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.eu_fondo, productocompleto.eu_fondo);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.num_largo, productocompleto.num_largo);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.num_ancho, productocompleto.num_ancho);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.num_fondo, productocompleto.num_fondo);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.id_valor_nutricional, productocompleto.id_valor_nutricional);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.nombre_valor, productocompleto.nombre_valor);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.cantidad, productocompleto.cantidad);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.valor_diario_total, productocompleto.valor_diario_total);

				Constantes.sProductocompletoProjectionMap.put(productocompleto.porcentaje_requerimientos, productocompleto.porcentaje_requerimientos);

				return Constantes.sProductocompletoProjectionMap;

			}
public HashMap<String, String> ProductocompraMap()
{

			Constantes.sProductocompraProjectionMap = new HashMap<String, String>();

				Constantes.sProductocompraProjectionMap.put(productocompra.id_producto, productocompra.id_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.codigo_producto, productocompra.codigo_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.numero_serie, productocompra.numero_serie);

				Constantes.sProductocompraProjectionMap.put(productocompra.descripcion_producto, productocompra.descripcion_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.nombre_producto, productocompra.nombre_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.marca_producto, productocompra.marca_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.modelo_producto, productocompra.modelo_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.contenido_unidad, productocompra.contenido_unidad);

				Constantes.sProductocompraProjectionMap.put(productocompra.unidad_minima, productocompra.unidad_minima);

				Constantes.sProductocompraProjectionMap.put(productocompra.contenido_unidad_medida_id_contenido_unidad_medida, productocompra.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sProductocompraProjectionMap.put(productocompra.contenido, productocompra.contenido);

				Constantes.sProductocompraProjectionMap.put(productocompra.peso_neto, productocompra.peso_neto);

				Constantes.sProductocompraProjectionMap.put(productocompra.alto_cm, productocompra.alto_cm);

				Constantes.sProductocompraProjectionMap.put(productocompra.ancho_cm, productocompra.ancho_cm);

				Constantes.sProductocompraProjectionMap.put(productocompra.fondo_cm, productocompra.fondo_cm);

				Constantes.sProductocompraProjectionMap.put(productocompra.fabricante, productocompra.fabricante);

				Constantes.sProductocompraProjectionMap.put(productocompra.familia_necesidad_id_familia_necesidad, productocompra.familia_necesidad_id_familia_necesidad);

				Constantes.sProductocompraProjectionMap.put(productocompra.familia_producto_id_familia_producto, productocompra.familia_producto_id_familia_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.clase_producto, productocompra.clase_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.linea_producto, productocompra.linea_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.tipo_producto_id_tipo_producto, productocompra.tipo_producto_id_tipo_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.hot, productocompra.hot);

				Constantes.sProductocompraProjectionMap.put(productocompra.subcategoria_id_subcategoria, productocompra.subcategoria_id_subcategoria);

				Constantes.sProductocompraProjectionMap.put(productocompra.SKU, productocompra.SKU);

				Constantes.sProductocompraProjectionMap.put(productocompra.formato_producto_id_formato_producto, productocompra.formato_producto_id_formato_producto);

				Constantes.sProductocompraProjectionMap.put(productocompra.id_caracteristica, productocompra.id_caracteristica);

				Constantes.sProductocompraProjectionMap.put(productocompra.numero_caracteristica, productocompra.numero_caracteristica);

				Constantes.sProductocompraProjectionMap.put(productocompra.caracteristica, productocompra.caracteristica);

				Constantes.sProductocompraProjectionMap.put(productocompra.valor_caracteristica, productocompra.valor_caracteristica);

				Constantes.sProductocompraProjectionMap.put(productocompra.id_categoria, productocompra.id_categoria);

				Constantes.sProductocompraProjectionMap.put(productocompra.nombre_categoria, productocompra.nombre_categoria);

				Constantes.sProductocompraProjectionMap.put(productocompra.id_reciclado, productocompra.id_reciclado);

				Constantes.sProductocompraProjectionMap.put(productocompra.reciclable, productocompra.reciclable);

				Constantes.sProductocompraProjectionMap.put(productocompra.reciclado, productocompra.reciclado);

				Constantes.sProductocompraProjectionMap.put(productocompra.valor_reciclaje, productocompra.valor_reciclaje);

				Constantes.sProductocompraProjectionMap.put(productocompra.empresa_id_empresa, productocompra.empresa_id_empresa);

				Constantes.sProductocompraProjectionMap.put(productocompra.id_stock, productocompra.id_stock);

				Constantes.sProductocompraProjectionMap.put(productocompra.stock_real, productocompra.stock_real);

				Constantes.sProductocompraProjectionMap.put(productocompra.stock_minimo, productocompra.stock_minimo);

				Constantes.sProductocompraProjectionMap.put(productocompra.stock_ideal, productocompra.stock_ideal);

				Constantes.sProductocompraProjectionMap.put(productocompra.stock_tienda, productocompra.stock_tienda);

				Constantes.sProductocompraProjectionMap.put(productocompra.stock_virtual, productocompra.stock_virtual);

				Constantes.sProductocompraProjectionMap.put(productocompra.stock_vendido, productocompra.stock_vendido);

				Constantes.sProductocompraProjectionMap.put(productocompra.last_update, productocompra.last_update);

				Constantes.sProductocompraProjectionMap.put(productocompra.id_subcategoria, productocompra.id_subcategoria);

				Constantes.sProductocompraProjectionMap.put(productocompra.nombre_subcategoria, productocompra.nombre_subcategoria);

				Constantes.sProductocompraProjectionMap.put(productocompra.descripcion_subcategoria, productocompra.descripcion_subcategoria);

				Constantes.sProductocompraProjectionMap.put(productocompra.categoria_id_categoria, productocompra.categoria_id_categoria);

				Constantes.sProductocompraProjectionMap.put(productocompra.id_talla, productocompra.id_talla);

				Constantes.sProductocompraProjectionMap.put(productocompra.am_largo, productocompra.am_largo);

				Constantes.sProductocompraProjectionMap.put(productocompra.am_ancho, productocompra.am_ancho);

				Constantes.sProductocompraProjectionMap.put(productocompra.am_fondo, productocompra.am_fondo);

				Constantes.sProductocompraProjectionMap.put(productocompra.eu_largo, productocompra.eu_largo);

				Constantes.sProductocompraProjectionMap.put(productocompra.eu_ancho, productocompra.eu_ancho);

				Constantes.sProductocompraProjectionMap.put(productocompra.eu_fondo, productocompra.eu_fondo);

				Constantes.sProductocompraProjectionMap.put(productocompra.num_largo, productocompra.num_largo);

				Constantes.sProductocompraProjectionMap.put(productocompra.num_ancho, productocompra.num_ancho);

				Constantes.sProductocompraProjectionMap.put(productocompra.num_fondo, productocompra.num_fondo);

				Constantes.sProductocompraProjectionMap.put(productocompra.id_valor_nutricional, productocompra.id_valor_nutricional);

				Constantes.sProductocompraProjectionMap.put(productocompra.nombre_valor, productocompra.nombre_valor);

				Constantes.sProductocompraProjectionMap.put(productocompra.cantidad, productocompra.cantidad);

				Constantes.sProductocompraProjectionMap.put(productocompra.valor_diario_total, productocompra.valor_diario_total);

				Constantes.sProductocompraProjectionMap.put(productocompra.porcentaje_requerimientos, productocompra.porcentaje_requerimientos);

				return Constantes.sProductocompraProjectionMap;

			}
public HashMap<String, String> ProductoprecioMap()
{

			Constantes.sProductoprecioProjectionMap = new HashMap<String, String>();

				Constantes.sProductoprecioProjectionMap.put(productoprecio.id_producto, productoprecio.id_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.codigo_producto, productoprecio.codigo_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.numero_serie, productoprecio.numero_serie);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.descripcion_producto, productoprecio.descripcion_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.nombre_producto, productoprecio.nombre_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.marca_producto, productoprecio.marca_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.modelo_producto, productoprecio.modelo_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.contenido_unidad, productoprecio.contenido_unidad);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.contenido_unidad_medida_id_contenido_unidad_medida, productoprecio.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.unidad_minima, productoprecio.unidad_minima);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.contenido, productoprecio.contenido);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.peso_neto, productoprecio.peso_neto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.alto_cm, productoprecio.alto_cm);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.ancho_cm, productoprecio.ancho_cm);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.fondo_cm, productoprecio.fondo_cm);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.fabricante, productoprecio.fabricante);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.clase_producto, productoprecio.clase_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.linea_producto, productoprecio.linea_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.hot, productoprecio.hot);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.SKU, productoprecio.SKU);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.subcategoria_id_subcategoria, productoprecio.subcategoria_id_subcategoria);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.tipo_producto_id_tipo_producto, productoprecio.tipo_producto_id_tipo_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.formato_producto_id_formato_producto, productoprecio.formato_producto_id_formato_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.familia_necesidad_id_familia_necesidad, productoprecio.familia_necesidad_id_familia_necesidad);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.familia_producto_id_familia_producto, productoprecio.familia_producto_id_familia_producto);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.id_precio, productoprecio.id_precio);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.precio_CLP, productoprecio.precio_CLP);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.precio_us, productoprecio.precio_us);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.precio_mayor_CLP, productoprecio.precio_mayor_CLP);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.precio_mayor_us, productoprecio.precio_mayor_us);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.precio_actual, productoprecio.precio_actual);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.descuento_promocion, productoprecio.descuento_promocion);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.cantidad_mayor, productoprecio.cantidad_mayor);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.id_stock, productoprecio.id_stock);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.stock_real, productoprecio.stock_real);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.stock_minimo, productoprecio.stock_minimo);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.stock_ideal, productoprecio.stock_ideal);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.stock_tienda, productoprecio.stock_tienda);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.stock_virtual, productoprecio.stock_virtual);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.stock_vendido, productoprecio.stock_vendido);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.last_update, productoprecio.last_update);

				Constantes.sProductoprecioProjectionMap.put(productoprecio.empresa_id_empresa, productoprecio.empresa_id_empresa);

				return Constantes.sProductoprecioProjectionMap;

			}
public HashMap<String, String> ProvinciaMap()
{

			Constantes.sProvinciaProjectionMap = new HashMap<String, String>();

				Constantes.sProvinciaProjectionMap.put(provincia.id_provincia, provincia.id_provincia);

				Constantes.sProvinciaProjectionMap.put(provincia.nombre_provincia, provincia.nombre_provincia);

				Constantes.sProvinciaProjectionMap.put(provincia.codigo_provincia, provincia.codigo_provincia);

				Constantes.sProvinciaProjectionMap.put(provincia.region_id_region, provincia.region_id_region);

				return Constantes.sProvinciaProjectionMap;

			}
public HashMap<String, String> RecicladoMap()
{

			Constantes.sRecicladoProjectionMap = new HashMap<String, String>();

				Constantes.sRecicladoProjectionMap.put(reciclado.id_reciclado, reciclado.id_reciclado);

				Constantes.sRecicladoProjectionMap.put(reciclado.reciclable, reciclado.reciclable);

				Constantes.sRecicladoProjectionMap.put(reciclado.reciclado, reciclado.reciclado);

				Constantes.sRecicladoProjectionMap.put(reciclado.valor_reciclaje, reciclado.valor_reciclaje);

				Constantes.sRecicladoProjectionMap.put(reciclado.empresa_id_empresa, reciclado.empresa_id_empresa);

				Constantes.sRecicladoProjectionMap.put(reciclado.producto_id_producto, reciclado.producto_id_producto);

				return Constantes.sRecicladoProjectionMap;

			}
public HashMap<String, String> RegionMap()
{

			Constantes.sRegionProjectionMap = new HashMap<String, String>();

				Constantes.sRegionProjectionMap.put(region.id_region, region.id_region);

				Constantes.sRegionProjectionMap.put(region.nombre_region, region.nombre_region);

				Constantes.sRegionProjectionMap.put(region.codigo_region, region.codigo_region);

				Constantes.sRegionProjectionMap.put(region.pais_id_pais, region.pais_id_pais);

				return Constantes.sRegionProjectionMap;

			}
public HashMap<String, String> RubroMap()
{

			Constantes.sRubroProjectionMap = new HashMap<String, String>();

				Constantes.sRubroProjectionMap.put(rubro.id_rubro, rubro.id_rubro);

				Constantes.sRubroProjectionMap.put(rubro.nombre_rubro, rubro.nombre_rubro);

				return Constantes.sRubroProjectionMap;

			}
public HashMap<String, String> SincrodateMap()
{

			Constantes.sSincrodateProjectionMap = new HashMap<String, String>();

				Constantes.sSincrodateProjectionMap.put(sincrodate.id_sincrodate, sincrodate.id_sincrodate);

				Constantes.sSincrodateProjectionMap.put(sincrodate.date, sincrodate.date);

				return Constantes.sSincrodateProjectionMap;

			}
public HashMap<String, String> StockMap()
{

			Constantes.sStockProjectionMap = new HashMap<String, String>();

				Constantes.sStockProjectionMap.put(stock.id_stock, stock.id_stock);

				Constantes.sStockProjectionMap.put(stock.stock_real, stock.stock_real);

				Constantes.sStockProjectionMap.put(stock.stock_minimo, stock.stock_minimo);

				Constantes.sStockProjectionMap.put(stock.stock_ideal, stock.stock_ideal);

				Constantes.sStockProjectionMap.put(stock.stock_tienda, stock.stock_tienda);

				Constantes.sStockProjectionMap.put(stock.stock_virtual, stock.stock_virtual);

				Constantes.sStockProjectionMap.put(stock.stock_vendido, stock.stock_vendido);

				Constantes.sStockProjectionMap.put(stock.last_update, stock.last_update);

				Constantes.sStockProjectionMap.put(stock.producto_id_producto, stock.producto_id_producto);

				Constantes.sStockProjectionMap.put(stock.empresa_id_empresa, stock.empresa_id_empresa);

				return Constantes.sStockProjectionMap;

			}
public HashMap<String, String> StockcompletoMap()
{

			Constantes.sStockcompletoProjectionMap = new HashMap<String, String>();

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.id_producto, stockcompleto.id_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.codigo_producto, stockcompleto.codigo_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.numero_serie, stockcompleto.numero_serie);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.descripcion_producto, stockcompleto.descripcion_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.nombre_producto, stockcompleto.nombre_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.marca_producto, stockcompleto.marca_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.modelo_producto, stockcompleto.modelo_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.contenido_unidad, stockcompleto.contenido_unidad);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida, stockcompleto.contenido_unidad_medida_id_contenido_unidad_medida);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.unidad_minima, stockcompleto.unidad_minima);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.contenido, stockcompleto.contenido);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.peso_neto, stockcompleto.peso_neto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.alto_cm, stockcompleto.alto_cm);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.ancho_cm, stockcompleto.ancho_cm);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.fondo_cm, stockcompleto.fondo_cm);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.fabricante, stockcompleto.fabricante);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.clase_producto, stockcompleto.clase_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.linea_producto, stockcompleto.linea_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.hot, stockcompleto.hot);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.SKU, stockcompleto.SKU);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.subcategoria_id_subcategoria, stockcompleto.subcategoria_id_subcategoria);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.tipo_producto_id_tipo_producto, stockcompleto.tipo_producto_id_tipo_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.formato_producto_id_formato_producto, stockcompleto.formato_producto_id_formato_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.familia_necesidad_id_familia_necesidad, stockcompleto.familia_necesidad_id_familia_necesidad);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.familia_producto_id_familia_producto, stockcompleto.familia_producto_id_familia_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.id_stock, stockcompleto.id_stock);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.stock_real, stockcompleto.stock_real);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.stock_minimo, stockcompleto.stock_minimo);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.stock_ideal, stockcompleto.stock_ideal);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.stock_tienda, stockcompleto.stock_tienda);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.stock_virtual, stockcompleto.stock_virtual);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.stock_vendido, stockcompleto.stock_vendido);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.last_update, stockcompleto.last_update);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.producto_id_producto, stockcompleto.producto_id_producto);

				Constantes.sStockcompletoProjectionMap.put(stockcompleto.empresa_id_empresa, stockcompleto.empresa_id_empresa);

				return Constantes.sStockcompletoProjectionMap;

			}
public HashMap<String, String> SubcategoriaMap()
{

			Constantes.sSubcategoriaProjectionMap = new HashMap<String, String>();

				Constantes.sSubcategoriaProjectionMap.put(subcategoria.id_subcategoria, subcategoria.id_subcategoria);

				Constantes.sSubcategoriaProjectionMap.put(subcategoria.nombre_subcategoria, subcategoria.nombre_subcategoria);

				Constantes.sSubcategoriaProjectionMap.put(subcategoria.descripcion_subcategoria, subcategoria.descripcion_subcategoria);

				Constantes.sSubcategoriaProjectionMap.put(subcategoria.categoria_id_categoria, subcategoria.categoria_id_categoria);

				return Constantes.sSubcategoriaProjectionMap;

			}
public HashMap<String, String> SubrubroMap()
{

			Constantes.sSubrubroProjectionMap = new HashMap<String, String>();

				Constantes.sSubrubroProjectionMap.put(subrubro.id_subrubro, subrubro.id_subrubro);

				Constantes.sSubrubroProjectionMap.put(subrubro.nombre_subrubro, subrubro.nombre_subrubro);

				Constantes.sSubrubroProjectionMap.put(subrubro.rubro_id_rubro, subrubro.rubro_id_rubro);

				return Constantes.sSubrubroProjectionMap;

			}
public HashMap<String, String> TallaMap()
{

			Constantes.sTallaProjectionMap = new HashMap<String, String>();

				Constantes.sTallaProjectionMap.put(talla.id_talla, talla.id_talla);

				Constantes.sTallaProjectionMap.put(talla.am_largo, talla.am_largo);

				Constantes.sTallaProjectionMap.put(talla.am_ancho, talla.am_ancho);

				Constantes.sTallaProjectionMap.put(talla.am_fondo, talla.am_fondo);

				Constantes.sTallaProjectionMap.put(talla.eu_largo, talla.eu_largo);

				Constantes.sTallaProjectionMap.put(talla.eu_ancho, talla.eu_ancho);

				Constantes.sTallaProjectionMap.put(talla.eu_fondo, talla.eu_fondo);

				Constantes.sTallaProjectionMap.put(talla.num_largo, talla.num_largo);

				Constantes.sTallaProjectionMap.put(talla.num_ancho, talla.num_ancho);

				Constantes.sTallaProjectionMap.put(talla.num_fondo, talla.num_fondo);

				Constantes.sTallaProjectionMap.put(talla.producto_id_producto, talla.producto_id_producto);

				return Constantes.sTallaProjectionMap;

			}
public HashMap<String, String> Tipo_documentoMap()
{

			Constantes.sTipo_documentoProjectionMap = new HashMap<String, String>();

				Constantes.sTipo_documentoProjectionMap.put(tipo_documento.id_tipo_documento, tipo_documento.id_tipo_documento);

				Constantes.sTipo_documentoProjectionMap.put(tipo_documento.nombre_tipo_documento, tipo_documento.nombre_tipo_documento);

				return Constantes.sTipo_documentoProjectionMap;

			}
public HashMap<String, String> Tipo_empresaMap()
{

			Constantes.sTipo_empresaProjectionMap = new HashMap<String, String>();

				Constantes.sTipo_empresaProjectionMap.put(tipo_empresa.id_tipo_empresa, tipo_empresa.id_tipo_empresa);

				Constantes.sTipo_empresaProjectionMap.put(tipo_empresa.nombre_tipo_empresa, tipo_empresa.nombre_tipo_empresa);

				Constantes.sTipo_empresaProjectionMap.put(tipo_empresa.categoria_empresa_id_categoria_empresa, tipo_empresa.categoria_empresa_id_categoria_empresa);

				return Constantes.sTipo_empresaProjectionMap;

			}
public HashMap<String, String> Tipo_pagoMap()
{

			Constantes.sTipo_pagoProjectionMap = new HashMap<String, String>();

				Constantes.sTipo_pagoProjectionMap.put(tipo_pago.id_tipo_pago, tipo_pago.id_tipo_pago);

				Constantes.sTipo_pagoProjectionMap.put(tipo_pago.nombre_tipo_pago, tipo_pago.nombre_tipo_pago);

				Constantes.sTipo_pagoProjectionMap.put(tipo_pago.comision_tipo_pago, tipo_pago.comision_tipo_pago);

				return Constantes.sTipo_pagoProjectionMap;

			}
public HashMap<String, String> Tipo_productoMap()
{

			Constantes.sTipo_productoProjectionMap = new HashMap<String, String>();

				Constantes.sTipo_productoProjectionMap.put(tipo_producto.id_tipo_producto, tipo_producto.id_tipo_producto);

				Constantes.sTipo_productoProjectionMap.put(tipo_producto.nombre_tipo_producto, tipo_producto.nombre_tipo_producto);

				return Constantes.sTipo_productoProjectionMap;

			}
public HashMap<String, String> Tipo_usuarioMap()
{

			Constantes.sTipo_usuarioProjectionMap = new HashMap<String, String>();

				Constantes.sTipo_usuarioProjectionMap.put(tipo_usuario.id_tipo_usuario, tipo_usuario.id_tipo_usuario);

				Constantes.sTipo_usuarioProjectionMap.put(tipo_usuario.nombre_tipo_usuario, tipo_usuario.nombre_tipo_usuario);

				return Constantes.sTipo_usuarioProjectionMap;

			}
public HashMap<String, String> UbicacionMap()
{

			Constantes.sUbicacionProjectionMap = new HashMap<String, String>();

				Constantes.sUbicacionProjectionMap.put(ubicacion.id_ubicacion, ubicacion.id_ubicacion);

				Constantes.sUbicacionProjectionMap.put(ubicacion.numero_ubicacion, ubicacion.numero_ubicacion);

				Constantes.sUbicacionProjectionMap.put(ubicacion.numero_interior, ubicacion.numero_interior);

				Constantes.sUbicacionProjectionMap.put(ubicacion.telefono_ubicacion, ubicacion.telefono_ubicacion);

				Constantes.sUbicacionProjectionMap.put(ubicacion.default_ubicacion, ubicacion.default_ubicacion);

				Constantes.sUbicacionProjectionMap.put(ubicacion.calle_id_calle, ubicacion.calle_id_calle);

				Constantes.sUbicacionProjectionMap.put(ubicacion.empresa_id_empresa, ubicacion.empresa_id_empresa);

				Constantes.sUbicacionProjectionMap.put(ubicacion.usuario_id_usuario, ubicacion.usuario_id_usuario);

				return Constantes.sUbicacionProjectionMap;

			}
public HashMap<String, String> UsuarioMap()
{

			Constantes.sUsuarioProjectionMap = new HashMap<String, String>();

				Constantes.sUsuarioProjectionMap.put(usuario.id_usuario, usuario.id_usuario);

				Constantes.sUsuarioProjectionMap.put(usuario.tipo_usuario, usuario.tipo_usuario);

				Constantes.sUsuarioProjectionMap.put(usuario.nombre_usuario, usuario.nombre_usuario);

				Constantes.sUsuarioProjectionMap.put(usuario.clave, usuario.clave);

				Constantes.sUsuarioProjectionMap.put(usuario.cliente_id_cliente, usuario.cliente_id_cliente);

				Constantes.sUsuarioProjectionMap.put(usuario.cliente_empresa_id_cliente_empresa, usuario.cliente_empresa_id_cliente_empresa);

				return Constantes.sUsuarioProjectionMap;

			}
public HashMap<String, String> UsuariocompletoMap()
{

			Constantes.sUsuariocompletoProjectionMap = new HashMap<String, String>();

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.id_persona, usuariocompleto.id_persona);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.rut_persona, usuariocompleto.rut_persona);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.digito_verificador, usuariocompleto.digito_verificador);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.nombre_persona, usuariocompleto.nombre_persona);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.segundo_nombre_persona, usuariocompleto.segundo_nombre_persona);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.apellido_persona, usuariocompleto.apellido_persona);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.segundo_apellido_persona, usuariocompleto.segundo_apellido_persona);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.actividad, usuariocompleto.actividad);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.area_actividad, usuariocompleto.area_actividad);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.dia_fecha_nacimiento, usuariocompleto.dia_fecha_nacimiento);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.mes_fecha_nacimiento, usuariocompleto.mes_fecha_nacimiento);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.ano_fecha_nacimiento, usuariocompleto.ano_fecha_nacimiento);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.edad, usuariocompleto.edad);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.email, usuariocompleto.email);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.celular, usuariocompleto.celular);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.telefono, usuariocompleto.telefono);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.id_carne_empresa, usuariocompleto.id_carne_empresa);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.nombre_usuario, usuariocompleto.nombre_usuario);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.clave_usuario, usuariocompleto.clave_usuario);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.empresa_id_empresa, usuariocompleto.empresa_id_empresa);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.persona_id_persona, usuariocompleto.persona_id_persona);

				Constantes.sUsuariocompletoProjectionMap.put(usuariocompleto.tipo_usuario_id_tipo_usuario, usuariocompleto.tipo_usuario_id_tipo_usuario);

				return Constantes.sUsuariocompletoProjectionMap;

			}
public HashMap<String, String> Valor_nutricionalMap()
{

			Constantes.sValor_nutricionalProjectionMap = new HashMap<String, String>();

				Constantes.sValor_nutricionalProjectionMap.put(valor_nutricional.id_valor_nutricional, valor_nutricional.id_valor_nutricional);

				Constantes.sValor_nutricionalProjectionMap.put(valor_nutricional.nombre_valor, valor_nutricional.nombre_valor);

				Constantes.sValor_nutricionalProjectionMap.put(valor_nutricional.cantidad, valor_nutricional.cantidad);

				Constantes.sValor_nutricionalProjectionMap.put(valor_nutricional.valor_diario_total, valor_nutricional.valor_diario_total);

				Constantes.sValor_nutricionalProjectionMap.put(valor_nutricional.porcentaje_requerimientos, valor_nutricional.porcentaje_requerimientos);

				Constantes.sValor_nutricionalProjectionMap.put(valor_nutricional.producto_id_producto, valor_nutricional.producto_id_producto);

				return Constantes.sValor_nutricionalProjectionMap;

			}
public HashMap<String, String> VentaMap()
{

			Constantes.sVentaProjectionMap = new HashMap<String, String>();

				Constantes.sVentaProjectionMap.put(venta.id_venta, venta.id_venta);

				Constantes.sVentaProjectionMap.put(venta.numero_articulos, venta.numero_articulos);

				Constantes.sVentaProjectionMap.put(venta.total, venta.total);

				Constantes.sVentaProjectionMap.put(venta.dia_fecha_venta, venta.dia_fecha_venta);

				Constantes.sVentaProjectionMap.put(venta.mes_fecha_venta, venta.mes_fecha_venta);

				Constantes.sVentaProjectionMap.put(venta.anno_fecha_venta, venta.anno_fecha_venta);

				Constantes.sVentaProjectionMap.put(venta.hora_fecha_venta, venta.hora_fecha_venta);

				Constantes.sVentaProjectionMap.put(venta.usuario_id_usuario, venta.usuario_id_usuario);

				Constantes.sVentaProjectionMap.put(venta.carne_empresa_id_carne_empresa, venta.carne_empresa_id_carne_empresa);

				Constantes.sVentaProjectionMap.put(venta.tipo_pago_id_tipo_pago, venta.tipo_pago_id_tipo_pago);

				Constantes.sVentaProjectionMap.put(venta.tipo_documento_id_tipo_documento, venta.tipo_documento_id_tipo_documento);

				return Constantes.sVentaProjectionMap;

			}
public HashMap<String, String> VentacompletaMap()
{

			Constantes.sVentacompletaProjectionMap = new HashMap<String, String>();

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.id_venta, ventacompleta.id_venta);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.numero_articulos, ventacompleta.numero_articulos);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.total, ventacompleta.total);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.dia_fecha_venta, ventacompleta.dia_fecha_venta);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.mes_fecha_venta, ventacompleta.mes_fecha_venta);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.anno_fecha_venta, ventacompleta.anno_fecha_venta);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.hora_fecha_venta, ventacompleta.hora_fecha_venta);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.usuario_id_usuario, ventacompleta.usuario_id_usuario);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.carne_empresa_id_carne_empresa, ventacompleta.carne_empresa_id_carne_empresa);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.tipo_pago_id_tipo_pago, ventacompleta.tipo_pago_id_tipo_pago);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.tipo_documento_id_tipo_documento, ventacompleta.tipo_documento_id_tipo_documento);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.id_tipo_pago, ventacompleta.id_tipo_pago);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.nombre_tipo_pago, ventacompleta.nombre_tipo_pago);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.comision_tipo_pago, ventacompleta.comision_tipo_pago);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.id_tipo_documento, ventacompleta.id_tipo_documento);

				Constantes.sVentacompletaProjectionMap.put(ventacompleta.nombre_tipo_documento, ventacompleta.nombre_tipo_documento);

				return Constantes.sVentacompletaProjectionMap;

			}

		}
