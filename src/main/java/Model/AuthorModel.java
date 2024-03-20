package Model;

import Entity.Author;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static Database.conectionDB.*;

public class AuthorModel implements IsCrudable {

    @Override
    public List<Object> getAll() {
        List<Object> authorsList = new ArrayList<>();
        try {
            connectToDataBase();
            String query = "use Ejercicio7";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            query = "SELECET * FROM Authors ";
            pstm = databaseConnection.prepareStatement(query);
            ResultSet resultadoSet = (ResultSet) pstm.executeQuery();

            while (resultadoSet.next()) {
                Author addableAuthor = new Author();
                addableAuthor.setId(resultadoSet.getInt("id"));
                addableAuthor.setName(resultadoSet.getString("name"));
                addableAuthor.setNationality(resultadoSet.getString("nationality"));
                authorsList.add(addableAuthor);
            }
            pstm.close();
            databaseConnection.close();

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        return authorsList;
    };

    @Override
    public Object getbyId(int id) {
        try {
            connectToDataBase();
            String query = "use Ejercicio7";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            query = "SELECT * FROM Authors WHERE id = " + id;
            pstm = databaseConnection.prepareStatement(query);
            ResultSet resultadoSet = (ResultSet) pstm.executeQuery();
            Author addableAuthor = new Author();
            addableAuthor.setId(resultadoSet.getInt("id"));
            addableAuthor.setName(resultadoSet.getString("name"));
            addableAuthor.setNationality(resultadoSet.getString("nationality"));
            pstm.close();
            databaseConnection.close();
            return (Object) addableAuthor;
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            return null;
        }
    };

    @Override
    public Object insert(Object objeto) {
        Author objeto1 = (Author) objeto;
        try {
            connectToDataBase();
            String query = "use Ejercio7";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            query = "INSERT INTO Authors ( name, nationality) VALUES (" + objeto1.getId() + "," + objeto1.getName() +"," + objeto1.getNationality() + " )";
            System.out.println(query);
            pstm = databaseConnection.prepareStatement(query);
            pstm.executeQuery();
            pstm.close();
            databaseConnection.close();
            
            return objeto;
            
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            return null;
        }
        
    };

    @Override
    public Boolean update(Object objeto) {
        Author prueba = (Author) objeto;
        try {
            connectToDataBase();
            String query = "use Ejercio7";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            query = "UPDATE Authors SET id =" + prueba.getId() + "," + "name = " + prueba.getName() +"," + "nationality = " + prueba.getNationality() + "WHERE id = " + prueba.getId();
            System.out.println(query);
            pstm = databaseConnection.prepareStatement(query);
            pstm.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            return null;
        }
        
    };

    @Override
    public Boolean delete(Object objeto) {
        Integer id = (Integer) objeto;
        try {
            connectToDataBase();
            String query = "use Ejercicio7";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            query = "DELETE * FROM Authors WHERE id = " + id;
            pstm = databaseConnection.prepareStatement(query);
            pstm.executeQuery();
            pstm.close();
            databaseConnection.close();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            return false;
        }
    }

}
