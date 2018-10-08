/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * @author Andres
 */
public class Libro {
    private String nombre;
    private String tema;
    private Editorial editorial;
    private double precio;
    private boolean segundaMan;

    public Libro(String nombre, String tema, Editorial editorial,double precio,boolean segundaMan) {
        this.nombre = nombre;
        this.tema = tema;
        this.editorial = editorial;
        this.precio =precio;
        this.segundaMan =segundaMan;
        
        
    }

    public boolean isSegundaMan() {
        return segundaMan;
    }

    public void setSegundaMan(boolean segundaMan) {
        this.segundaMan = segundaMan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
