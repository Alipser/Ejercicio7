package Database;

import java.sql.*;


public class conectionDB {

    public static Connection databaseConnection = null;
    public static Statement stmt = null;

    public static PreparedStatement pstm = null;

    public static Connection connectToDataBase(){
     try{


         if (databaseConnection == null){
             String user = "root";
             String pass = "Rlwl2023.";
             String url ="jdbc:mysql://localhost:3306/";
             databaseConnection= DriverManager.getConnection(url, user, pass);
             System.out.println("te has conectado");
         }else {
             System.out.println("Ya hay una Conexion Activa");
         }

     }catch (Exception e){
         System.out.println(e.toString());

     }
        return databaseConnection;
    }

    public static void closeconnection(){
        try {
            if (databaseConnection != null ){
                databaseConnection.close();
                System.out.println("Desconectado con Exito");
            }else{
                System.out.println("La conexion aun no se ha establecido");
            }

        }catch (Exception e){
            System.out.println("Error" + e.toString());
        }
    }


    public static void createSchemaInConection(String nombreSchema) {
        try {
            System.out.println("Creating Schema...");
            stmt = databaseConnection.createStatement();
            String dbName = nombreSchema; // or get it from command line
            String sql = "CREATE SCHEMA " + dbName;
            stmt.executeUpdate(sql);
            System.out.println("Schema created successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception se2) {
                System.out.println("Error");
            }

        }
    }


    public static void createTableAuthors(){
        try{
            String query = "use Ejercicio7;";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            System.out.println("using Ejercicio7");

            System.out.println("Creating Atuhors Table");
             query = "CREATE TABLE IF NOT EXISTS Authors ( id int auto_increment, name varchar(30), nationality varchar(30), CONSTRAINT PK_IdAuthors PRIMARY KEY (id))";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            pstm.close();

        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }


    public static void createTableBooks(){
        try{
            String query = "use Ejercicio7;";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            System.out.println("using Ejercicio7");

            System.out.println("Creating Book Table");
            query = "CREATE TABLE IF NOT EXISTS Books ( \n" +
                    "id int AUTO_INCREMENT,  \n" +
                    "idAuthor int, title VARCHAR(30), \n" +
                    "yearPublication VARCHAR(30), \n" +
                    "price FLOAT, \n" +
                    "CONSTRAINT PK_IdBooks PRIMARY KEY (id), \n" +
                    "constraint FK_AuthorId foreign key (idAuthor) \n" +
                    "REFERENCES Authors(id)\n" +
                    ");";
            pstm = databaseConnection.prepareStatement(query);
            pstm.execute();
            pstm.close();

        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }






}
