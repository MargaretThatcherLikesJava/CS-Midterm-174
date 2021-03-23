/**
* A pared down social network
* @author Evan Chee
* @version 1.0, March 2021
* Note that this version is not thread safe.
*/

package midterm;
import People.*;
import Structure.*;

/**
 *
 * @author chee
 */
public class Midterm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SocialNetwork socialNet = new SocialNetwork();
        boolean result1 = socialNet.createPerson("John", "Smith");
        socialNet.createPerson("John", "Doe");
        socialNet.createPerson("Jane", "Doe");

        System.out.println(result1);
        
        System.out.println(socialNet);
        
    }
    
}
