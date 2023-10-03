import javax.naming.ldap.*;
import javax.naming.*;

/*
 * Shows how values in the RDN can be retrieved
 * from their string representation.
 */

public class UnescapingValues {
    
    public static void main(String args[]) {
         // DN with ',' (comma)
        String unformatted = "Juicy, Fruit";
        String formatted = Rdn.escapeValue(unformatted);
        System.out.println("Formatted:" + formatted);
        Object original = Rdn.unescapeValue(formatted);
        System.out.println("Original:" +  original);  

        // DN with a '+' (plus)
        unformatted = "true+false";
        formatted = Rdn.escapeValue(unformatted); 
        System.out.println("Formatted:" + formatted);
        original = Rdn.unescapeValue(formatted);
        System.out.println("Original:" +  original);  

        // DN with a binary value as one one of its attribute value
        byte[] bytes = new byte[] {1, 2, 3, 4};
        formatted = Rdn.escapeValue(bytes);
        System.out.println("Formatted:" + formatted);
        original = Rdn.unescapeValue(formatted);
        System.out.println("Original:" +  original);  
    }   
}
