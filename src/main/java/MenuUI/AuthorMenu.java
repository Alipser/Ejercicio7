package MenuUI;

import Controllers.AuthorController;

import javax.swing.*;

import static MenuUI.menuP.showMenu;

public class AuthorMenu {

    static public AuthorController autorController = new AuthorController();

    public static void showMenuAutores (){
        String opcionesMenu = " 1. Show Authors \n 2. Show Author By Id. \n 3. Delete Author. \n 4.Create new Author. \n 5. Update Author \n 6.Exit";
        int select = 0;
        try {
            while (select <1 || select >6 ){
                select = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesMenu));
                if(select <1 || select >6 ){
                    JOptionPane.showMessageDialog(null, "Please Enter a number between 1 and 5");
                }
            }

            switch (select){
                case 1:
                    autorController.listarAutores();
                    break;
                case 2:
                    autorController.buscarAutorById();
                    break;
                case 3:
                    autorController.deleteAutor();
                    break;
                case 4:
                    autorController.crearAutor();
                    break;
                case 5:
                    autorController.updateAutores();
                    break;
                case 6:
                    showMenu();
                    return;

            }

            showMenuAutores ();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            showMenuAutores();
        }

    }

}
