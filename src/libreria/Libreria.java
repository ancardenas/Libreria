/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Andres
 */
public class Libreria {
private ArrayList<Libro> libros;
private ArrayList<Editorial> editorial;
private ArrayList<Libro> libSolicitado;
private Scanner sc =new Scanner(System.in);

    public Libreria() {
        this.libros = new ArrayList<Libro>() ;
        this.editorial = new ArrayList<Editorial>();
        this.libSolicitado = new ArrayList<Libro>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Libro libro, int i) {
        this.libros.set(i, libro);
    }

    public Editorial getEditorial(int i) {
        return editorial.get(i);
    }

    public void setEditorial(ArrayList<Editorial> editorial) {
        this.editorial = editorial;
    }
    public void addLibro(Libro libro){
        this.libros.add(libro);
    }
    public void addEditorial(Editorial editorial){
        this.editorial.add(editorial);
    }
    /**
     * Se supone que este metodo permitira buscar los libros por nombre sin embargo
     * por falta de conocimiento no logro hacer de manera correcta esta busqueda
     * @return Libro buscado 
     */
    public Libro buscarLibroNom(){
        String nombre = sc.nextLine();
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i).getNombre().equals(nombre)){
                return libros.get(i);}
        }
        return null;
    }
    /**
     * Metodo que expone todas las editoriales registradas y muestra una lista de los
     * libros pertenecientes a una editorial seleccionada 
     *  
     */
    public void buscarLibroEd(){
        System.out.println("Las editoriales en inventario son las siguientes");
        for (int i = 0; i < editorial.size(); i++) {
            System.out.println((i+1)+" "+this.editorial.get(i).getNombre());
        }
        int a =sc.nextInt();
        
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i).getEditorial().getNombre().equals(editorial.get(a-1).getNombre())){
                System.out.println((i+1)+libros.get(i).getNombre());}
        }
        
    }
    /**
     * Expone todos los temas añadidos y permite elegir entre uno de ellos 
     *  
     */
    public void buscarLibroTem(){
        
        System.out.println("Los temas disponibles son:");
        System.out.println("1 Matematica");
        System.out.println("2 Fisica");
        System.out.println("3 Linguistica");
        System.out.println("4 Programacion");
        
        String tem=new String();
        int a=sc.nextInt();
        switch (a){
            case 1: tem="Matematicas";break;
            case 2: tem="Fisica";break;
            case 3: tem="Liguistica";break;
            case 4: tem="Programacion";break;
        }
        
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i).getTema().equals(tem)){
                System.out.println((i+1)+" "+this.libros.get(i).getNombre());}
        }
        
    }
    /**
     * permite al ussuario solicitar un libro que no encuentra
     */
    public void solicitarLibro(){
        System.out.println("Ingrese el nombre del libro que desea solicitar");
        String nombre=sc.next();
        
        Libro libro=new Libro(nombre, "", null, 0, true);
        this.libSolicitado.add(libro);
    }

    public ArrayList<Libro> getLibSolicitado() {
        return libSolicitado;
    }
    /**
     * la funcion que permite al cliente hacer una venta de un libro de segunda
     * esta parte es para uso del propietario que ya ha realizado la compra
     */
    public void comprarLib(){
        System.out.println("Que libro desea vender");
        System.out.println("Ingrese el nombre");
        String nombre = sc.next();
        System.out.println("Ingrese el tema");
        System.out.println("1 Matematica");
        System.out.println("2 Fisica");
        System.out.println("3 Linguistica");
        System.out.println("4 Programacion");
        String tema=new String();
        int a=sc.nextInt();
        switch (a){
            case 1: tema="Matematicas";break;
            case 2: tema="Fisica";break;
            case 3: tema="Liguistica";break;
            case 4: tema="Programacion";break;
        }
        System.out.println("Las editoriales en inventario son las siguientes");
        for (int i = 0; i < editorial.size(); i++) {
            System.out.println((i+1)+" "+this.editorial.get(i).getNombre());
        }
        int b =sc.nextInt();
        
        this.libros.add(new Libro(nombre, tema, this.editorial.get(b-1), 0, true));
    }
    /**
     * muestra todos los libros en inventario con su identificador
     */
    public void invLib(){
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i+1)+" "+this.libros.get(i).getNombre());
        }
    }
    /**
     * la funcion principal que permite vender un libro al cliente este tiene varias formas de 
     * localizarlo se le da el precio, esta pensado para una vez hecho el pago con el metodo
     * decidido la compra se pueda realizar exitosamene
     * @return el exito de la venta
     */
    public boolean venderLibro(){
        System.out.println("Bienvenido que libro desea comprar?");
        System.out.println("Localice el libro que busca");
        System.out.println("1 Lista por tema");
        System.out.println("2 Lista por editorial");
        System.out.println("3 Lista de segunda mano");
        int a =sc.nextInt();
        switch (a){
            case 1: this.buscarLibroTem();break;
            case 2: this.buscarLibroEd();break;
            case 3: this.segMano();break;
            }
        System.out.println("Ingresa el numero del libro deseado");
        Libro comp = new Libro("", "", null,0,false);
        int i = sc.nextInt();
        comp=libros.get(i-1);
        System.out.println("Esta seguro de comprar "+ libros.get(i-1).getNombre()+" y/n");
        String b=sc.next();
        switch (b){
            case "y":this.libros.get(i-1).getEditorial().libroVen();this.libros.remove(i-1);System.out.println("Compra exitosa"); return true;
            case "n": System.out.println("Compra cancelada"); return false;
        }return false;
    }
    public void segMano(){
        for (int i = 0; i < libros.size(); i++) {
            if (this.libros.get(i).isSegundaMan()==true) {
                System.out.println((i+1)+" "+this.libros.get(i).getNombre());
            }
        }
    }
    /**
     * permite buscar un libro segun su tema o editorial se permitira tambien ver 
     * los libros de primera o de segunda mano
     */
    public void busquedaLib(){
        
        System.out.println("Desea consultar por tema o por");
               System.out.println("1 Consultar por tema");
               System.out.println("2 Consultar por editorial");
               System.out.println("3 Lista de segunda mano");
               int b =sc.nextInt();
               switch(b){
                   case 1: this.buscarLibroTem();break;
                   case 2: this.buscarLibroEd();break;
                   case 3: this.segMano();break;
               }
    }/**
     * el menu principal que permite al cliente interactuar con la libreria
     * 
     */
    public void startLibreria(){
        System.out.println("Bienvenido a la libreria Ruiz");
           System.out.println("Que desea?");
           System.out.println("1 Comprar libro");
           System.out.println("2 Consultar Libros");
           System.out.println("3 Solicitar libro no encontrado ");
           System.out.println("4 Vender libro");
           System.out.println("5 Todos los libros disponibles");
           int a =sc.nextInt();
           switch (a){
               case 1: this.venderLibro();break;
               case 2: this.busquedaLib();break;
               case 3: this.solicitarLibro();break;
               case 4: this.comprarLib();break;
               case 5: this.invLib();
           }
    }



    
}
