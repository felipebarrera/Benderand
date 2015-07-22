
package cl.webinc.benderand.entidad;

import android.database.Cursor;

import java.util.ArrayList;

import cl.webinc.benderand.provider.Base;

public class VentaConArticulos
{
    private String id_venta = "";
    private String numero_articulos = "";
    private String total = "";
    private String dia_fecha_venta = "";
    private String mes_fecha_venta = "";
    private String anno_fecha_venta = "";
    private String hora_fecha_venta = "";
    private String usuario_id_usuario = "";
    private String carne_empresa_id_carne_empresa = "";
    private String tipo_pago_id_tipo_pago = "";
    private String tipo_documento_id_tipo_documento = "";
    private String id_tipo_pago = "";
    private String nombre_tipo_pago = "";
    private String comision_tipo_pago = "";
    private String id_tipo_documento = "";
    private String nombre_tipo_documento = "";
    private ArrayList articulos = new ArrayList<>();


    public VentaConArticulos(String id_venta, String numero_articulos, ArrayList articulos,String total, String dia_fecha_venta, String mes_fecha_venta, String anno_fecha_venta, String hora_fecha_venta, String usuario_id_usuario, String carne_empresa_id_carne_empresa, String tipo_pago_id_tipo_pago, String tipo_documento_id_tipo_documento, String id_tipo_pago, String nombre_tipo_pago, String comision_tipo_pago, String id_tipo_documento, String nombre_tipo_documento)
    {
        this.id_venta = id_venta;
        this.articulos = articulos;
        this.numero_articulos = numero_articulos;
        this.total = total;
        this.dia_fecha_venta = dia_fecha_venta;
        this.mes_fecha_venta = mes_fecha_venta;
        this.anno_fecha_venta = anno_fecha_venta;
        this.hora_fecha_venta = hora_fecha_venta;
        this.usuario_id_usuario = usuario_id_usuario;
        this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;
        this.tipo_pago_id_tipo_pago = tipo_pago_id_tipo_pago;
        this.tipo_documento_id_tipo_documento = tipo_documento_id_tipo_documento;
        this.id_tipo_pago = id_tipo_pago;
        this.nombre_tipo_pago = nombre_tipo_pago;
        this.comision_tipo_pago = comision_tipo_pago;
        this.id_tipo_documento = id_tipo_documento;
        this.nombre_tipo_documento = nombre_tipo_documento;

    }
    public VentaConArticulos(){

    }
    public String getId_venta()
    {
        return id_venta;
    }
    public String getNumero_articulos()
    {
        return numero_articulos;
    }
    public String getTotal()
    {
        return total;
    }
    public String getDia_fecha_venta()
    {
        return dia_fecha_venta;
    }
    public String getMes_fecha_venta()
    {
        return mes_fecha_venta;
    }
    public String getAnno_fecha_venta()
    {
        return anno_fecha_venta;
    }
    public String getHora_fecha_venta()
    {
        return hora_fecha_venta;
    }
    public String getUsuario_id_usuario()
    {
        return usuario_id_usuario;
    }
    public String getCarne_empresa_id_carne_empresa()
    {
        return carne_empresa_id_carne_empresa;
    }
    public String getTipo_pago_id_tipo_pago()
    {
        return tipo_pago_id_tipo_pago;
    }
    public String getTipo_documento_id_tipo_documento()
    {
        return tipo_documento_id_tipo_documento;
    }
    public String getId_tipo_pago()
    {
        return id_tipo_pago;
    }
    public String getNombre_tipo_pago()
    {
        return nombre_tipo_pago;
    }
    public String getComision_tipo_pago()
    {
        return comision_tipo_pago;
    }
    public String getId_tipo_documento()
    {
        return id_tipo_documento;
    }
    public String getNombre_tipo_documento()
    {
        return nombre_tipo_documento;
    }
    public void setId_venta(String id_venta) {this.id_venta = id_venta;}
    public void setNumero_articulos(String numero_articulos){this.numero_articulos = numero_articulos;}
    public void setTotal(String total) {this.total = total;}
    public void setDia_fecha_venta(String dia_fecha_venta){ this.dia_fecha_venta = dia_fecha_venta;}
    public void setMes_fecha_venta(String mes_fecha_venta){this.mes_fecha_venta = mes_fecha_venta;}
    public void setAnno_fecha_venta(String anno_fecha_venta){this.anno_fecha_venta = anno_fecha_venta;}
    public void setHora_fecha_venta(String hora_fecha_venta){this.hora_fecha_venta = hora_fecha_venta;}
    public void setUsuario_id_usuario(String usuario_id_usuario){this.usuario_id_usuario = usuario_id_usuario;}
    public void setCarne_empresa_id_carne_empresa(String carne_empresa_id_carne_empresa){this.carne_empresa_id_carne_empresa = carne_empresa_id_carne_empresa;}
    public void setTipo_pago_id_tipo_pago(String tipo_pago_id_tipo_pago){this.tipo_pago_id_tipo_pago = tipo_pago_id_tipo_pago;}
    public void setTipo_documento_id_tipo_documento(String tipo_documento_id_tipo_documento){ this.tipo_documento_id_tipo_documento = tipo_documento_id_tipo_documento;}
    public void setId_tipo_pago(String id_tipo_pago) { this.id_tipo_pago = id_tipo_pago; }
    public void setNombre_tipo_pago(String nombre_tipo_pago) { this.nombre_tipo_pago = nombre_tipo_pago;}
    public void setComision_tipo_pago(String comision_tipo_pago) {this.comision_tipo_pago = comision_tipo_pago; }
    public void setId_tipo_documento(String id_tipo_documento){ this.id_tipo_documento = id_tipo_documento;}
    public void setNombre_tipo_documento(String nombre_tipo_documento) {this.nombre_tipo_documento = nombre_tipo_documento;}
    public ArrayList getArticulos() {return articulos;}
    public void setArticulos(ArrayList articulos) {this.articulos = articulos;}


    public void VentaConArticulos(Cursor c){
        c.moveToFirst();
        while(!c.isAfterLast()) {
            this.id_venta = c.getString(c.getColumnIndex(Base.ventacompleta.id_venta));
            this.numero_articulos = c.getString(c.getColumnIndex(Base.ventacompleta.numero_articulos));
            this.total = c.getString(c.getColumnIndex(Base.ventacompleta.total));
            this.dia_fecha_venta = c.getString(c.getColumnIndex(Base.ventacompleta.dia_fecha_venta));
            this.mes_fecha_venta = c.getString(c.getColumnIndex(Base.ventacompleta.mes_fecha_venta));
            this.anno_fecha_venta = c.getString(c.getColumnIndex(Base.ventacompleta.anno_fecha_venta));
            this.hora_fecha_venta = c.getString(c.getColumnIndex(Base.ventacompleta.hora_fecha_venta));
            this.usuario_id_usuario = c.getString(c.getColumnIndex(Base.ventacompleta.usuario_id_usuario));
            this.carne_empresa_id_carne_empresa = c.getString(c.getColumnIndex(Base.ventacompleta.carne_empresa_id_carne_empresa));
            this.tipo_pago_id_tipo_pago = c.getString(c.getColumnIndex(Base.ventacompleta.tipo_pago_id_tipo_pago));
            this.tipo_documento_id_tipo_documento = c.getString(c.getColumnIndex(Base.ventacompleta.tipo_documento_id_tipo_documento));
            this.id_tipo_pago = c.getString(c.getColumnIndex(Base.ventacompleta.id_tipo_pago));
            this.nombre_tipo_pago = c.getString(c.getColumnIndex(Base.ventacompleta.nombre_tipo_pago));
            this.comision_tipo_pago = c.getString(c.getColumnIndex(Base.ventacompleta.comision_tipo_pago));
            this.id_tipo_documento = c.getString(c.getColumnIndex(Base.ventacompleta.id_tipo_documento));
            this.nombre_tipo_documento = c.getString(c.getColumnIndex(Base.ventacompleta.nombre_tipo_documento));
            c.moveToNext();
        }
        c.close();
    }

    public void carro_ventacompleto(Cursor c) {
        c.moveToFirst();
        while (!c.isAfterLast()) {
            this.articulos.add(
                    new Carro_ventacompleto(
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.id_carro_venta)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.cantidad)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.precio)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.venta_id_venta)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.id_carro_compras)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.cantidad_carro)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.precio_carro)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.mayor)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.tienda)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.usuario_id_usuario)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.usado)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.carne_empresa_id_carne_empresa)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.id_precio)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.precio_CLP)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.precio_us)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.precio_mayor_CLP)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.precio_mayor_us)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.precio_actual)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.descuento_promocion)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.cantidad_mayor)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.id_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.codigo_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.numero_serie)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.descripcion_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.nombre_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.marca_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.modelo_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.contenido_unidad)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.unidad_minima)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.contenido_unidad_medida_id_contenido_unidad_medida)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.contenido)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.peso_neto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.alto_cm)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.ancho_cm)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.fondo_cm)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.fabricante)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.familia_necesidad_id_familia_necesidad)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.familia_producto_id_familia_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.clase_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.linea_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.tipo_producto_id_tipo_producto)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.hot)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.subcategoria_id_subcategoria)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.SKU)),
                            c.getString(c.getColumnIndex(Base.carro_ventacompleto.formato_producto_id_formato_producto))
                    )
            );
            c.moveToNext();
        }
        c.close();
    }
}