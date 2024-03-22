package Controllers;
import Entity.Book;
import Model.AuthorModel;
import Model.BookModel;

import java.util.ArrayList;
import java.util.List;


public class BookController {

    BookModel bookModel = new BookModel();

    public void listarLibros(){
        StringBuilder stringBooks = new StringBuilder();

        List<Object>  listaLibros =  bookModel.getAll();
        if (listaLibros != null && !listaLibros.isEmpty()){
            stringBooks = new StringBuilder("Books in Inventory:  \n");
           for (Object temp: listaLibros){
               Book libro  = (Book) temp;
               stringBooks.append(libro.toString()).append("\n");
           }
        }else {
            stringBooks.append("There are no Books to show");
        }
    }


    public void listarLibrosAuthor(){
        StringBuilder stringBooks = new StringBuilder();

        List<Object>  listaLibros =  bookModel.getAll();
        if (listaLibros != null && !listaLibros.isEmpty()){
            stringBooks = new StringBuilder("Books in Inventory:  \n");
            for (Object temp: listaLibros){
                Book libro  = (Book) temp;
                stringBooks.append(libro.toString()).append(" ").append(libro.getAuthor().toString()).append("\n");
            }
        }else {
            stringBooks.append("There are no Books to show");
        }
    }

    public void crearLibro(){

    }





}
