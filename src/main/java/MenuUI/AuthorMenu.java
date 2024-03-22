package MenuUI;

import Controllers.AuthorController;

import javax.swing.*;

public class AuthorMenu {

    public AuthorController autorController = new AuthorController();

    public static void showMenuAutores (){
        String opcionesMenu = " 1. Show Authors \n 2. Update Author. \n 3. Delete Author. \n 4.Create new Author.";
        int select = 0;
        try {
            while (select <0 || select >5 ){
                select = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesMenu));
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Solo son permitidos numeros en el input");
            showMenuAutores();
        }

    }

}
