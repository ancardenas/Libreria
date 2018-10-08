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
public class main {
    public static void main(String[] args) {
       Libreria Ruiz=new Libreria();
       Editorial cenage = new Editorial("CENGAGE", 0);
       Ruiz.addEditorial(cenage);
       Editorial unNacional = new Editorial("Universidad Nacional",0);
       Ruiz.addEditorial(unNacional);
       Editorial ecoe = new Editorial("ECOE", 0);
       Ruiz.addEditorial(ecoe);
       Editorial pearson= new Editorial("Pearson", 0);
       Ruiz.addEditorial(pearson);
       Ruiz.addLibro(new Libro(" Modelos de optimización de la gestión logística ", "Matematicas", ecoe, 50000, false));
       Ruiz.addLibro(new Libro("Stewart", "Matematicas", cenage,100000,false));
       Ruiz.addLibro(new Libro(" Administración de operaciones (1st ed.). ", "Matematicas", cenage, 50000, false));
       Ruiz.addLibro(new Libro("Probabilidad y estadística para ingenieros", "Matematicas", pearson, 0, true));
       Ruiz.addLibro(new Libro("Fundamentos de F´ısica Experimental " +
"Mec´anica", "Fisica", unNacional, 0, true));
       while(true){
           Ruiz.startLibreria();
           
       }
    }
}
