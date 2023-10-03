import javax.naming.ldap.*;
import javax.naming.*;

/*
 * Creates an LdapName and prints its components
 * 
 */
public class ConstructLdapName {
    
    public static void main(String args[]) {
        String name = "cn=Mango, ou=Fruits, o=Food";
        try {
            LdapName dn = new LdapName(name);
            System.out.println(dn + " has " + dn.size() + " RDNs: ");
            for (int i = 0; i < dn.size(); i++) {
                System.out.println(dn.get(i));
            }
        } catch (InvalidNameException e) {
            System.out.println("Cannot parse name: " + name);
        }
    }
}
