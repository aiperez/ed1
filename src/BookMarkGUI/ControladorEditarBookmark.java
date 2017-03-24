package BookMarkGUI;

import Modelo.BookMark;
import Modelo.Repositorio;

/**
 *
 * @author <David Heredia>
 */
public class ControladorEditarBookmark {
    
    private EditarBookmark miEditarBookmark;
    
    public ControladorEditarBookmark(EditarBookmark editarBookmark){
        miEditarBookmark = editarBookmark;
    }
    
    public void guardarBookmark(){
        BookMark b = new BookMark(miEditarBookmark.getjTextFieldNombre().getText(), miEditarBookmark.getjTextFieldDireccion().getText());
        Repositorio.miRepositorio().añadir(b);
        miEditarBookmark.dispose();
    }
}
