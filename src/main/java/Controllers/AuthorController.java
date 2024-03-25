package Controllers;

import Entity.Author;
import Entity.Book;
import Model.AuthorModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AuthorController {

    AuthorModel authorModel = new AuthorModel();

    public void listarAutores(){
        StringBuilder stringBooks = new StringBuilder();

        List<Object> listaAutores =  authorModel.getAll();
        if (listaAutores != null && !listaAutores.isEmpty()){
            stringBooks = new StringBuilder("Authors List:  \n");
            for (Object temp: listaAutores){
                Author autor  = (Author) temp;
                stringBooks.append(autor.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null,stringBooks);
        }else {
            stringBooks.append("There are no Autors to show");
            JOptionPane.showMessageDialog(null,stringBooks);
        }
    }

    public void crearAutor(){
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna

        JTextField name = new JTextField();
        JTextField nationality = new JTextField();


// Añadimos los componentes al panel
        panel.add(new JLabel("Autor's name"));
        panel.add(name);

        panel.add(new JLabel("Nacionality"));
        panel.add(nationality);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);


        if (result == JOptionPane.OK_OPTION) {
            String nameString = name.getText();
            String nationalityString = nationality.getText();
            Author autorCreado = new Author(nameString, nationalityString);
            System.out.println(autorCreado.toString());
            authorModel.insert(autorCreado);
        }


    }

    public void buscarAutorById(){
        this.listarAutores();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Author findedAuthor = (Author)  authorModel.getbyId(id);
        JOptionPane.showMessageDialog(null, findedAuthor.toString());
    }

    public void deleteAutor(){
        this.listarAutores();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to Eliminate"));
        authorModel.delete(id);
    }

    public void updateAutores(){
        this.listarAutores();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to Update"));
        Author findedAuthor = (Author)  authorModel.getbyId(id);

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField name = new JTextField();
        JTextField nationality = new JTextField();

        panel.add(new JLabel("Autor's name"));
        panel.add(name);
        panel.add(new JLabel("Nacionality"));
        panel.add(nationality);

        name.setText(findedAuthor.getName());
        nationality.setText(findedAuthor.getNationality());

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Author's Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String inputname = name.getText();
            String inputnationality = nationality.getText();
            findedAuthor.setName(inputname);
            findedAuthor.setNationality(inputnationality);
            authorModel.update(findedAuthor);



        }



    }


}
