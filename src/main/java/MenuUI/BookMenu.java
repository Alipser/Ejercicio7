package MenuUI;

import Controllers.AuthorController;
import Controllers.BookController;

import javax.swing.*;

public class BookMenu {

    static public BookController bookController = new BookController();
    public static void showMenuBookMenu (){
        String opcionesMenu = " 1. Show Books with Autos \n 2. Show Book By Id. \n 3. Delete Book. \n 4.Create new Book. \n 5.Exit";
        int select = 0;
        try {
            while (select <1 || select >5 ){
                select = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesMenu));
                if(select <1 || select >5 ){
                    JOptionPane.showMessageDialog(null, "Please Enter a number between 1 and 5");
                }
            }

            switch (select){
                case 1:
                    bookController.listarLibrosAuthor();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    JOptionPane.showInternalMessageDialog(null, "You have exit Succesfully");
                    return;

            }

            showMenuBookMenu ();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            showMenuBookMenu();
        }

    }
}
