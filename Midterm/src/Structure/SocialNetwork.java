/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;
import java.util.*;

import People.*;

/**
 *
 * @author chee
 */
public class SocialNetwork {
    
    
    static ArrayList<Person> _members = new ArrayList<Person>();    // List that holds all people
    
    public SocialNetwork() {
        
    }
    
    /**
     * Create new person and add them to the network
     * @param first
     * @param last
     * @return 
     */
    public boolean createPerson(String first, String last) {
        boolean createdPerson = false;
        Person newPerson = new Person(first, last);
        createdPerson = _members.add(newPerson);
        return createdPerson;
    }
    
    /**
     * Send message from one user to another
     * @param message
     * @return 
     */
    public boolean sendMessage(Person recipient, String message) {
        boolean sentMessage = false;
        
        return sentMessage;
    }
    
    public String toString() {
        return _members.toString() + "\n";
    }
    
}
