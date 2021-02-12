package Lab4;
/**
 * @name Controller.AddressBook
 * @author Youssef Saghbini
 * @studentnumber 100996459
 */

import javax.persistence.*;
import java.util.*;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(generator = "address", strategy = GenerationType.IDENTITY)
    long id;

    /**
     * Making a LinkedList of Controller.BuddyInfo
     */
    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyList;

    /**
     * Default Constructor of this class
     */
    public AddressBook() {
        buddyList = new ArrayList<>();
    }

    /**
     * This method is to add a buddy to the LinkedList
     * @param aBuddy A buddy that will be added
     */
    public void addBuddy(BuddyInfo aBuddy) {
        if(aBuddy != null)
            buddyList.add(aBuddy);
    }

    /**
     * Removing Buddy in the LinkedList at specified index
     * @param index Locating Buddy in the LinkedList
     */
    public void removeBuddy(int index) {
        if( index >= 0 && index < buddyList.size())
            buddyList.remove(index);
    }

    /**
     * Removes all Buddies in the Controller.AddressBook
     */
    public void clear(){
        buddyList.clear();
    }

    /**
     * Getting the Buddy in the LinkedList
     * @param index Locating Buddy in the LinkedList
     * @return The Buddy in the specified Index
     */
    public BuddyInfo getBuddy(int index) {
        return buddyList.get(index);
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

    public List<BuddyInfo> getBuddyList() {
        return buddyList;
    }

    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.buddyList = buddyList;
    }

    public int size(){
        return buddyList.size();
    }

    public String toString(){
        String buddies = "";
        for (BuddyInfo buddyInfo: buddyList){
            buddies += buddyInfo.toString() + "\n";
        }
        return buddies;
    }

}
