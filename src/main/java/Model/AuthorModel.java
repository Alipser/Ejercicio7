package Model;

import Entity.Author;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static Database.conectionDB.*;

public class AuthorModel implements IsCrudable {


    public AuthorModel(){}
    @Override
    public List<Object> getAll() {
        List<Object> authorsList = new ArrayList<>();
        try {
            connectToDataBase();
            String query = "SELECT * FROM authors ";
            pstm = databaseConnection.prepareStatement(query);
            ResultSet resultadoSet = pstm.executeQuery();

            while (resultadoSet.next()) {
                Author addableAuthor = new Author();
                addableAuthor.setId(resultadoSet.getInt("id"));
                addableAuthor.setName(resultadoSet.getString("name"));
                addableAuthor.setNationality(resultadoSet.getString("nationality"));
                authorsList.add(addableAuthor);
            }


        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        return authorsList;
    }

    @Override
    public Object getbyId(int id) {
        try {
            connectToDataBase();
            String query = "SELECT * FROM authors WHERE id = ?";
            pstm = databaseConnection.prepareStatement(query);
            pstm.setInt(1,id);
            ResultSet resultadoSet = (ResultSet) pstm.executeQuery();
            Author addableAuthor = addableAuthor= new Author();
            while (resultadoSet.next()) {
                addableAuthor.setId(resultadoSet.getInt("id"));
                addableAuthor.setName(resultadoSet.getString("name"));
                addableAuthor.setNationality(resultadoSet.getString("nationality"));
            }
            return addableAuthor;
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            return null;
        }
    }

    @Override
    public Object insert(Object objeto) {
        Author objeto1 = (Author) objeto;
        try {
            connectToDataBase();
            String query = "INSERT INTO authors(name, nationality) VALUES(?, ?);";
            System.out.println(query);
            pstm = databaseConnection.prepareStatement(query);
            pstm.setString(1, objeto1.getName());
            pstm.setString(2, objeto1.getNationality());
            pstm.execute();
            return objeto;            
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public Boolean update(Object objeto) {
        Author prueba = (Author) objeto;
        try {
            connectToDataBase();
            String query = "UPDATE authors SET id =" + prueba.getId() + "," + "name = " + prueba.getName() +"," + "nationality = " + prueba.getNationality() + "WHERE id = " + prueba.getId();
            System.out.println(query);
            pstm = databaseConnection.prepareStatement(query);
            pstm.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public Boolean delete(Object objeto) {
        Integer id = (Integer) objeto;
        try {
            connectToDataBase();
            String query = "DELETE FROM authors WHERE id = ?;";
            pstm = databaseConnection.prepareStatement(query);
            pstm.setInt(1,id);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Has been eliminated");
            return true;
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            return false;
        }
    }

}
