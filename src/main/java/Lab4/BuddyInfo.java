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
    private int addressID;

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
        this.addressID = 0;
    }



    /**
     * Setting the Object with their variables
     * @param name Name of Buddy
     * @param phoneNumber Phone Number of Buddy
     */
    public BuddyInfo(int addressID, String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressID = addressID;
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

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    /**
     * String implementation of the buddy depending on gender
     * @return String of buddy information
     */
    @Override
    public String toString() {
        return String.format(
                "[id=%d, firstName='%s', lastName='%s']", id, name, phoneNumber);
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
