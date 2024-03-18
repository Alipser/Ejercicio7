package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conectionDB {

    public static Connection databaseConnection = null;
    public static Statement stmt = null;

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


}
