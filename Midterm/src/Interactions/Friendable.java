/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interactions;
import People.*;

/**
 *
 * @author chee
 */
public interface Friendable {
    
    public boolean addFriend(Person p, int n);
    public boolean unfriend(Person p);
    
}
