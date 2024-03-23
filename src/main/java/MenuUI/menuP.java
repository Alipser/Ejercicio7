package MenuUI;

import javax.swing.*;
import static  MenuUI.AuthorMenu.*;
import static  MenuUI.BookMenu.*;

public class menuP {



    public static void showMenu(){
        JOptionPane.showMessageDialog(null, "No olvide correr en local la base de datos y ejecutar el main de Database");
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = { "Books", "Authors"};
        String initialSelection = "Books";
        Object selection = JOptionPane.showInputDialog(null, "Please, Select one option to Administrate",
                "Administration System", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        System.out.println(selection);
        if (selection == "Books"){
            System.out.println("books");
            showMenuBookMenu();
        } else if (selection == null) {
            return;
        } else{
            System.out.println("Author");
            showMenuAutores();
        }
    }
}
