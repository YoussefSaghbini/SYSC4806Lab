package Lab4;
/**
 * @name Controller.BuddyInfo
 * @author Youssef Saghbini
 * @studentnumber 100996459
 */

import javax.persistence.*;


@Entity
public class BuddyInfo{

    private String name;
    private String phoneNumber;

    // Added ID
    @Id
    @GeneratedValue(generator = "buddy", strategy = GenerationType.IDENTITY)
    long id;

    /**
     * Default Constructor
     */
    public BuddyInfo() {
        this.name = null;
        this.phoneNumber = null;
    }

    /**
     * Setting the Object with their variables
     * @param name Name of Buddy
     * @param phoneNumber Phone Number of Buddy
     */
    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getting Buddy Name
     * @return Buddy Name
     */
    public String getName() {
        return name;
    }

    /**
     * Setting Buddy Name
     * @param name Buddy Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getting Phone Number of Buddy
     * @return Phone Number of Buddy
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setting Phone Number of Buddy
     * @param phoneNumber Phone Number of Buddy
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * String implementation of the buddy depending on gender
     * @return String of buddy information
     */
    public String toString(){
        return "Name: " + getName() + "\t\tPhone Number: " + getPhoneNumber();
    }


    /**
     * Getting id of Buddy
     * @return id of Buddy
     */
    public long getId() {
        return id;
    }

    /**
     * Setting id of Buddy
     * @param id of Buddy
     */
    public void setId(long id) {
        this.id = id;
    }

}
