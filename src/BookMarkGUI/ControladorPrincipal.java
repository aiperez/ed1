package BookMarkGUI;

import Modelo.BookMark;
import Modelo.Repositorio;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author <David Heredia>
 */
public class ControladorPrincipal {
    private VentanPrincipal miVentana;
    private BookMark miBookmark;
    private Repositorio miRepositorio;
    
    public ControladorPrincipal (VentanPrincipal miVentana) throws IOException{
        this.miVentana=miVentana;
        Repositorio.miRepositorio().leerFichero();
    }
    
    public void rellenarTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Dirección");
        BookMark[] bookMarks = Repositorio.miRepositorio().listar();
        if(bookMarks != null){
            for(int i = 0; i < bookMarks.length; i++){
                String[] fila = { bookMarks[i].getTitulo(), bookMarks[i].getUrl() };
                dtm.addRow(fila);
            }
            
        }
        miVentana.getjTableBookmark().setModel(dtm);
    }
    
    public void abrirEditarBookmark() throws IOException{
        EditarBookmark miEditar = new EditarBookmark(miVentana, true);
        miEditar.setVisible(true);
        Repositorio.miRepositorio().salvar();
        rellenarTabla();
        
    }
    
    public void borrarBookmark(int filaSeleccionada){
        Repositorio.miRepositorio().borrar(filaSeleccionada);
        rellenarTabla();
    }
    
}
