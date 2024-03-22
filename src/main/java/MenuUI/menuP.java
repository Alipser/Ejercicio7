package MenuUI;

import javax.swing.*;
import static  MenuUI.AuthorMenu.*;

public class menuP {



    public static void showMenu(){
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = { "Books", "Authors"};
        String initialSelection = "Books";
        Object selection = JOptionPane.showInputDialog(null, "Please, Select one option to Administrate",
                "Administration System", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        System.out.println(selection);
        if (selection == "Books"){
            System.out.println("books");

        }else{
            System.out.println("Author");
            showMenuAutores();
        }


    }
}
