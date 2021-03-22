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
public class Person implements Messagable {
    
    private String _firstName;
    private String _lastName;
    private static int _id;
    protected ArrayList<Person> _friendsList;
    protected ArrayList<Message> _messagesList;
    protected ArrayList<Person> _blockedList;
    
    public Person(String firstName, String lastName) {
        _firstName = firstName;
        _lastName = lastName;
        _id++;  
        _friendsList = new ArrayList<Person>();
        _messagesList = new ArrayList<Message>();
        _blockedList = new ArrayList<Person>();
    }
    
    public String getFirstName() {
        return _firstName;
    }
    public String getLastName() {
        return _lastName;
    }
    
    /**
     * Compares two people objects based on their first and last name
     * @param p
     * @return boolean
     */
    public boolean equals(Person p) {
        boolean isEquals = this._firstName.equals(p._firstName) && this._lastName.equals(p._lastName);
        return isEquals;
    }
    
    /**
     * Check if the person is blocked. Return true if so.
     * @param p
     * @return 
     */
    public boolean isBlocked(Person p) {
        boolean blocked = this._blockedList.contains(p) || p._blockedList.contains(this);
        return blocked;
    }
    
    /**
     * Check if the person is a duplicate on friends list. Return true if so.
     * @param p
     * @return 
     */
    public boolean isDuplicate(Person p) {
        boolean duplicate = this._friendsList.contains(p) || p._friendsList.contains(this);
        return duplicate;
    }
    
    /**
     * Person adds another person to friends list. Reciprocates, and message sent.
     * @param p
     * @return 
     */
    public boolean addFriend(Person p) {
        boolean addedFriend = false;    
        if (!isBlocked(p) && !isDuplicate(p)) { // check blocked, duplicate
            addedFriend = true;
            this._friendsList.add(p);
            // ADD OTHER FRIEND
            // MESSAGE OTHER FRIEND
        } else {
            addedFriend = false;
        }
        return addedFriend;
    }
    
    /**
     * Adds one person object to another person's blocked list
     * @param p
     * @return boolean 
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
    
    public boolean receiveMessage(Message m) {
        boolean receivedMessage = false;
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
