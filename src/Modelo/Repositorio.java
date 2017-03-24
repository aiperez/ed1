package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author <David Heredia>
 */
public class Repositorio {

    private ArrayList<BookMark> listaBookmark;
    File fichero = new File("Datos.txt");

    private static Repositorio mirep=null; 
    
    
    public static Repositorio miRepositorio(){
        if (mirep==null) mirep=new Repositorio();
        return mirep;
    }
    private Repositorio(){
        
    }

    public void añadir(BookMark br) {
        if (listaBookmark == null) {
            listaBookmark = new ArrayList<>();
        }
        listaBookmark.add(br);

    }
    
    public void borrar(int bookmark){
        listaBookmark.remove(bookmark);
    }

    public BookMark[] listar() {
        BookMark[] resultado = null;
        if (listaBookmark != null) {
            resultado = new BookMark[listaBookmark.size()];
            for (int i = 0; i < listaBookmark.size(); i++) {
                resultado[i] = listaBookmark.get(i);
            }
        }
        return resultado;
    }

    public void salvar() throws IOException {
        PrintWriter pr = new PrintWriter(new FileWriter(fichero));
        for (BookMark br : listaBookmark) {
            pr.println(br);
        }
        pr.close();
    }

    public void leerFichero() throws IOException {

        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        BufferedReader brr = new BufferedReader(new FileReader(fichero));
        String linea = null;
        while ((linea = brr.readLine()) != null) {
            
            String campos [] = linea.split(",");
            BookMark br = new BookMark (campos[0], campos[1]);
            añadir(br);
        }

    }
}
