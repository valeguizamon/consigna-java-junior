package com.company;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int codigo;
    private List<Producto> productos = new ArrayList<>();

    public Venta() {
    }

    public Venta(int codigo, List<Producto> productos) {
        this.codigo = codigo;
        this.productos = productos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Producto> getDetalle() {
        return productos;
    }

    public void setDetalle(List<Producto> detalle) {
        this.productos = detalle;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    //PROCEDIMIENTOS DE LA CLASE VENTA
    public void addProducto(Producto producto){
        this.productos.add(producto);
    }

    public double getComision(){
        double acum = 0;
        try{
            for (Producto p : this.getProductos()) {
                acum += p.getPrecio();
            }
            acum = (this.getProductos().size() > 2) ? acum * 0.10 : acum * 0.05;
            return acum;
        } catch(Exception e) {
            System.out.println("Error en el metodo de calculo de comision. Error: " + e.getMessage());
            return 0;
        }
    }
}
