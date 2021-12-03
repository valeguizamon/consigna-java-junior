package com.company;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Creo las listas necesarias para la ejecucion del proyecto
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        List<Venta> ventasVendedorA = new ArrayList<Venta>();
        List<Venta> ventasVendedorB = new ArrayList<Venta>();
        List<Producto> inventario = new ArrayList<Producto>();

        //Creo unos productos
        Producto remera = new Producto(1,"Remera Nike", 100f, "Remeras");
        Producto boxer = new Producto(2,"Boxer Americanino", 70f, "Boxers");
        Producto campera = new Producto(3,"Campera Everlast", 300f, "Camperas");
        Producto pantalon = new Producto(4,"short Nike", 200f, "Pantalon");

        //Agrego todos los productos al array inventario, que despues sera utilizado en la busqueda por nombre o categoria
        inventario.add(remera);
        inventario.add(boxer);
        inventario.add(pantalon);
        inventario.add(campera);

        //Creo 2 vendedores
        Vendedor vendedorA = new Vendedor(1, "Sergio", 10000f, ventasVendedorA);
        Vendedor vendedorB = new Vendedor(2, "Lucas", 10050f, ventasVendedorB);

        //Creo array de Venta vacios, que contendran productos gracias al metod addProduct
        Venta venta = new Venta();
        Venta venta2 = new Venta();
        Venta venta3 = new Venta();
        Venta venta4 = new Venta();
        Venta venta5 = new Venta();

        //Utilizo addProduct para llenar los arrays de venta
        venta.addProducto(remera);
        venta.addProducto(pantalon);
        venta.addProducto(campera);
        venta.setCodigo(1);

        venta2.addProducto(boxer);
        venta2.setCodigo(2);

        venta3.addProducto(boxer);
        venta3.setCodigo(3);

        venta4.addProducto(remera);
        venta4.setCodigo(4);

        venta5.addProducto(pantalon);
        venta5.addProducto(campera);
        venta5.setCodigo((5));

        //Agrego las ventas sueltas en una lista de ventas de cada vendedor
        ventasVendedorA.add(venta);
        ventasVendedorA.add(venta2);

        ventasVendedorB.add(venta3);
        ventasVendedorB.add(venta4);
        ventasVendedorB.add(venta5);

        //Utilizo el metodo mostrar ventas de la clase Vendedor
        vendedorA.mostrarVentas();
        vendedorB.mostrarVentas();

        //Utilizo el metodo de busqueda en la lista inventario
        searchByNameOrCategory("pantalon", inventario);
        searchByNameOrCategory("campera", inventario);
        searchByNameOrCategory("e", inventario);
    }

    //Toma como parametros el array y una query, que sera comparada con el nombre y la categoria de todos los objetos la lista
    public static void searchByNameOrCategory(String query, List<Producto> productos){
        try{
            List<Producto> resultado = new ArrayList<Producto>();
            for (Producto p : productos) {
                if (p.getNombre().toLowerCase().matches(".*" + query.toLowerCase() + ".*") || p.getCategoria().toLowerCase().matches(".*" + query.toLowerCase() + ".*")) {
                    resultado.add(p);
                }
            }
            System.out.println("BUSQUEDA\nEl resultado de su busqueda de " + "'" + query + "' es:");
            for (Producto p : resultado) {
                System.out.println(p.getCodigo() + " - " + p.getNombre() + " - " + p.getPrecio() + " - " + p.getCategoria() + "\n");

            }
        } catch(Exception e) {
            System.out.println("Error en el metodo de busqueda. Error: " + e.getMessage());
        }
    }

}
