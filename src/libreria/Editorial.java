/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *Se usa para identificar los las editoriales a las cuales pertenece cada libro
 * @author Andres
 */
public class Editorial {
    private String nombre;
    private int librosVen;
    
    /**
    *El constructor de la clase 
     * @param nombre
     * @param librosVen
    */
    public Editorial(String nombre, int librosVen) {
        this.nombre = nombre;
        this.librosVen = librosVen;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLibrosVen() {
        return librosVen;
    }

    public void setLibrosVen(int librosVen) {
        this.librosVen = librosVen;
    }
    /**
    *Este metodos suma al contador de libros vendidos de cada editorial
    */
    public void libroVen(){
    this.librosVen++;
}


    
}
