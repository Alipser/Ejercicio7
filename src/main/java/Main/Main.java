package Main;
import static Database.conectionDB.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        closeconnection();
        connectToDataBase();
        createSchemaInConection("Ejercicio7");
        closeconnection();
    }
}