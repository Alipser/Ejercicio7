package Database;

import java.sql.PreparedStatement;

import static Database.conectionDB.*;

public class MainDB {

    public static void main (String[] args){
        /** *
         * Creacion de La base de datos en caso de no existir o mover el proyecto de cliente
         */

        closeconnection();
        connectToDataBase();
        createSchemaInConection("Ejercicio7");
        createTableAuthors();
        createTableBooks();
        closeconnection();

    }
}
