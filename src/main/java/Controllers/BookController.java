package Controllers;
import Entity.Book;
import Model.AuthorModel;
import Model.BookModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;



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
        JOptionPane.showMessageDialog(null,stringBooks);
    }


    public void listarLibrosAuthor(){
        StringBuilder stringBooks = new StringBuilder();

        List<Object>  listaLibros =  bookModel.getAllWithAuthors();
        if (listaLibros != null && !listaLibros.isEmpty()){
            stringBooks = new StringBuilder("Books in Inventory:  \n");
            for (Object temp: listaLibros){
                Book libro  = (Book) temp;
                stringBooks.append(libro.toString()).append(" ").append(libro.getAuthor().toString()).append("\n");
            }
        }else {
            stringBooks.append("There are no Books to show");
        }
        JOptionPane.showMessageDialog(null,stringBooks);
    }

    public void crearLibro(){
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna

        JTextField tituloLibro = new JTextField();
        JTextField nombreAutor = new JTextField();
        JTextField fechaPublicacion = new JTextField();
        JTextField precio = new JTextField();
        JTextField IdAutor = new JTextField();

        panel.add(new JLabel("Titulo del libro:"));
        panel.add(tituloLibro);

        panel.add(new JLabel("Nombre del autor:"));
        panel.add(nombreAutor);

        panel.add(new JLabel("Fecha de publicacion:"));
        panel.add(fechaPublicacion);

        panel.add(new JLabel("Precio:"));
        panel.add(precio);

        panel.add(new JLabel("ID del autor:"));
        panel.add(IdAutor);

        int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese los datos del libro", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String titulo = tituloLibro.getText();
            String fecha = fechaPublicacion.getText();
            String valor = precio.getText();
            String id = IdAutor.getText();

            Book newBook = new Book(titulo,fecha, Double.parseDouble(valor), Integer.parseInt(id));
            bookModel.insert(newBook);

        }


    }

}






