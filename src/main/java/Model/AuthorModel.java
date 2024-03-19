package Model;

import java.util.List;
import static Database.conectionDB.*;



public class AuthorModel implements IsCrudable{

    public List<Object> getAll(){
        connectToDataBase();
        try {
            String query = "SELECET * FROM ";


        }catch (Exception e){
            System.out.println( "ERROR " + e.getMessage());
        }


        return null;
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

