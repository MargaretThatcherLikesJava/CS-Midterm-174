/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package People;
import java.util.*;
import Interactions.*;

/**
 *
 * @author chee
 */
public class Person implements Messagable, Friendable {
    
    private String _firstName;
    private String _lastName;
    private static int _id;
    protected ArrayList<Person> _friendsList;
    protected ArrayList<String> _messagesList;
    protected ArrayList<Person> _blockedList;
    
    public Person(String firstName, String lastName) {
        _firstName = firstName;
        _lastName = lastName;
        _id++;  
        _friendsList = new ArrayList<Person>();
        _messagesList = new ArrayList<String>();
        _blockedList = new ArrayList<Person>();
    }
    
    public String getFirstName() {
        return _firstName;
    }
    public String getLastName() {
        return _lastName;
    }
    public ArrayList<Person> getFriendsList() {
        return _friendsList;
    }
    
    /**
     * Compares two people objects based on their first and last name
     * @param p
     * @return true if equal
     */
    public boolean equals(Person p) {
        boolean isEquals = this._firstName.equals(p._firstName) && this._lastName.equals(p._lastName);
        return isEquals;
    }
    
    /**
     * Check if the person is blocked. Return true if so.
     * @param p
     * @return true if blocked
     */
    public boolean isBlocked(Person p) {
        boolean isBlocked = this._blockedList.contains(p) || p._blockedList.contains(this);
        return isBlocked;
    }
    
    /**
     * Check if the person is a duplicate on friends list. Return true if so.
     * @param p
     * @return true if duplicate
     */
    public boolean isDuplicate(Person p) {
        boolean isDuplicate = isDuplicate = this._friendsList.contains(p) || p._friendsList.contains(this);
        return isDuplicate;
    }
    
    /* Recursion test
    public boolean isSame(Person p, int n) {
        boolean same = false;
        if (n == 0) {
            same = this._firstName.equals(p._firstName) && this._lastName.equals(p._lastName);
        }
        return same;
    }
    */
    
 
    /**
     * Person adds another person to friends list. Reciprocates, and message sent.
     * @param p
     * @return true if friend added
     */

    public boolean addFriend(Person p, int n) {
        boolean addedFriend = false;
        if (n == 0) {
            System.out.println("Done");
        } else if (!this.equals(p) && !isDuplicate(p) && !isBlocked(p)) {
            this._friendsList.add(p);
            p.addFriend(this, n);
            addedFriend = true;
            System.out.println("added");
            n--;
        }
        return addedFriend;
    }
    
    /**
     * Removes one person from anothers friends list
     * @param p
     * @return true if unfriended
     */
    public boolean unfriend(Person p) {
        boolean unfriended = false;
        if (this._friendsList.contains(p)) {
            this._friendsList.remove(p);
            p._friendsList.remove(this);
            unfriended = true;
        } else {
            unfriended = false;
        }
        return unfriended;
    }
    
    /**
     * Adds one person object to another person's blocked list
     * @param p 
     * @return true if blocked 
     */
    public boolean addBlock(Person p) {
        boolean hasBlocked = false;
        if(!isBlocked(p) && !isDuplicate(p)) {
            this._blockedList.add(p);
        } else {
            hasBlocked = false;
        }
        return hasBlocked;
    }
    
    /**
     * Sends message from sender to recipient
     * @param m
     * @return true if received message
     */
    public boolean receiveMessage(String m) {
        boolean receivedMessage = false;
        this._messagesList.add(m);
        return receivedMessage;
    }
    
    @Override
    public String toString() {
        String displayFirstName = _firstName;
        String displayLastName = _lastName;
        String displayId = "ID: " + _id;
        String displayFList = "Friends List: " + _friendsList.toString();
        String displayMList = "Message List: " + _messagesList.toString();
        String displayBList = "Blocked List: " + _blockedList.toString();
        
        return displayFirstName + " " + displayLastName  + "\n" + displayId + "\n"+ displayFList + "\n" + displayMList + "\n"
                + displayBList + "\n";
    }
    
}
