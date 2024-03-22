package Controllers;

import Entity.Book;
import Model.AuthorModel;

import java.util.List;

public class AuthorController {

    AuthorModel authorModel = new AuthorModel();

    public void listarAutores(){
        StringBuilder stringBooks = new StringBuilder();

        List<Object> listaLibros =  authorModel.getAll();
        if (listaLibros != null && !listaLibros.isEmpty()){
            stringBooks = new StringBuilder("Authors List:  \n");
            for (Object temp: listaLibros){
                Book libro  = (Book) temp;
                stringBooks.append(libro.toString()).append("\n");
            }
        }else {
            stringBooks.append("There are no Books to show");
        }
    }
}
