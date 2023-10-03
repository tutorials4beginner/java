import javax.naming.ldap.*;
import javax.naming.*;

/*
 * Shows how to format DNs with special characters by escaping
 * the values
 */

public class EscapingDNs {
    
    public static void main(String args[]) {
        try {
            // DN with ',' (comma) in its attribute value
            String unformatted = "Juicy, Fruit";
            String formatted = Rdn.escapeValue(unformatted);
            LdapName dn = new LdapName("cn=" + formatted);
            System.out.println("dn:" + dn);

             // DN with a '+' (plus) in its attribute value
            unformatted = "true+false";
            formatted = Rdn.escapeValue(unformatted); 
            dn = new LdapName("cn=" + formatted);
            System.out.println("dn:" + dn);

            // DN with a binary value as its attribute value
            byte[] bytes = new byte[] {1, 2, 3, 4};
            formatted = Rdn.escapeValue(bytes);
            System.out.println("Orig val: " + bytes +
                    " Escaped val: " + formatted);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    } 
}
