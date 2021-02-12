package Lab4;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JFrame frame;
    private TextArea textArea;
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem createItem, displayItem, closeItem, addItem, clearList;


    public View(){
        frame = new JFrame();
        textArea = new TextArea();
        this.initializeGUI();
    }

    /**
     *  Setting boundaries of the frame,
     *  Adding textArea and drop-down menu into the frame
     *  and making frame visible for the user
     */
    public void initializeGUI() {
        frame.setBounds(100, 100, 730, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea.setEditable(false);
        frame.add(textArea);
        createMenuBar();
        frame.setVisible(true);
    }

    /**
     *  Generating a JMenuBar and adding all JMenuItem on it.
     */
    public void createMenuBar(){

        /*
            Menu Titles on the JMenuBar
         */
        JMenu fileMenu = new JMenu("Book");
        JMenu buddyMenu = new JMenu("Buddy");

        /*
            Menu Item, the drop-down item, in each menu title
         */
        createItem = new JMenuItem("Create");
        displayItem = new JMenuItem("Display");
        clearList = new JMenuItem("Clear");
        closeItem = new JMenuItem("Close");
        addItem = new JMenuItem("Add");

        /*
            Disabling some functions, until new address book is made and or new buddy
         */
        addItem.setEnabled(false);

        /*
            Adding menu items to menu
         */
        fileMenu.add(createItem);
        fileMenu.add(displayItem);
        fileMenu.add(clearList);
        fileMenu.add(closeItem);
        buddyMenu.add(addItem);

        /*
            Adding the Menu Titles onto the MenuBar
         */
        menuBar.add(fileMenu);
        menuBar.add(buddyMenu);

        /*
            Setting the JMenuBar onto the frame
         */
        frame.setJMenuBar(menuBar);
    }

    /*
        Getters and Setters for all the functionality happening on the GUIs
     */
    public JMenuItem getCreateItem() {
        return createItem;
    }

    public JMenuItem getDisplayItem() {
        return displayItem;
    }

    public JMenuItem getCloseItem() {
        return closeItem;
    }

    public JMenuItem getAddItem() {
        return addItem;
    }

    public JMenuItem getClearList() {
        return clearList;
    }

    public TextArea getTextArea() {
        return textArea;
    }

}
