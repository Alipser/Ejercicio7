package Model;

import Entity.Author;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static Database.conectionDB.*;



public class AuthorModel implements IsCrudable{



    @Override
    public List<Object> getAll(){
        List<Object> authorsList = new ArrayList<>();
        try {
            connectToDataBase();
            String query = "use Ejercicio7";
            pstm =  databaseConnection.prepareStatement(query);
            pstm.execute();
            query = "SELECET * FROM Authors ";
            pstm = databaseConnection.prepareStatement(query);
            ResultSet resultadoSet = (ResultSet) pstm.executeQuery();

            while (resultadoSet.next()){
                Author addableAuthor = new Author();
                addableAuthor.setId(resultadoSet.getInt("id"));
                addableAuthor.setName(resultadoSet.getString("name"));
                addableAuthor.setNationality(resultadoSet.getString("nationality"));
                authorsList.add(addableAuthor);
            }

        }catch (Exception e){
            System.out.println( "ERROR " + e.getMessage());
        }
        return authorsList;
    };

    public Object getbyId(int id){
        System.out.println("hola");
        return null;
    };

    public  Object insert(Object objeto){
        System.out.println("hola");
        return null;
    };

    public Boolean update(Object objeto){
        System.out.println("hola");
        return true;
    };

    public Boolean delete(Object delete){
        System.out.println("hola");
        return true;
    };

}

