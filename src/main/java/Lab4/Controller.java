package Lab4; /**
 * @Name Controller.Controller
 * @author Youssef Saghbini
 * @studentnumber 100996459
 */


import javax.swing.*;
import java.awt.event.ActionEvent;


public class Controller {

    private AddressBook buddyList;
    private View view;

    public Controller(View view){
        this.buddyList = new AddressBook();
        this.view = view;
    }


    /*
        Adding actionListeners to the GUI
     */
    public void actionListeners(){
        view.getCreateItem().addActionListener((ActionEvent event) -> { createItem(); });
        view.getAddItem().addActionListener((ActionEvent event) -> { addItem(); });
        view.getDisplayItem().addActionListener((ActionEvent event) -> { display(); });
        view.getClearList().addActionListener((ActionEvent event) ->{ clearList(); });
        view.getCloseItem().addActionListener((ActionEvent event) -> { close(); });
    }

    /*
        Creates an address book and enables the function to add buddy
     */
    public void createItem(){
        view.getAddItem().setEnabled(true);
        JOptionPane.showMessageDialog(null,"Address Book has been created.");
    }

    /*
        Generate Model and being added to Controller.AddressBook and enabling more functionality
    */
    public void addItem(){
        String name = JOptionPane.showInputDialog("What is your name?");
        String phone = JOptionPane.showInputDialog("What is your phone number?");
        buddyList.addBuddy(new BuddyInfo(name, phone));
    }



    /*
        Displays all the BuddyInfos that were created, when clicked
    */
    public void display(){
        view.getTextArea().setText("");
        for(int i = 0; i < buddyList.size(); i++){
            view.getTextArea().append(buddyList.getBuddy(i).toString() + "\n");
        }
    }

    /*
        Clears the textArea and list, when clicked
    */
    public void clearList(){
        view.getTextArea().setText("");
        buddyList.clear();
    }

    /*
        Closes the application when clicked
     */
    public void close(){
        System.exit(0);
    }

}