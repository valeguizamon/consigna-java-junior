package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {

    private int codigo;
    private String nombre;
    private float sueldo;
    private List<Venta> ventas = new ArrayList<>();

    public Vendedor() {
    }

    public Vendedor(int codigo, String nombre, float sueldo, List<Venta> ventas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.ventas = ventas;
    }

    public void addVenta(Venta venta){
        this.ventas.add(venta);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    //PROCEDIMIENTOS DE LA CLASE VENDEDOR
    public void mostrarVentas(){
        System.out.println("Ventas del vendedor " + this.getCodigo() + ": " + this.getNombre() + "\n");
        for (Venta v : this.getVentas()) {
            float total = 0f;
            System.out.println("Codigo de venta " + v.getCodigo());
            System.out.println("La comision de esta venta es: " + v.getComision());
            for (Producto prod : v.getProductos()) {
                System.out.println("Codigo: " + prod.getCodigo() + " - Nombre: " + prod.getNombre() + " - Precio: " + prod.getPrecio() + " - Categoria: " + prod.getCategoria());
                total += prod.getPrecio();
            }
            System.out.println("Total de la venta: " + total + "\n");
            System.out.println( "============== \n" );
        }
    }

}
