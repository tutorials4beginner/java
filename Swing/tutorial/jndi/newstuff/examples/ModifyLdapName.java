import javax.naming.ldap.*;
import javax.naming.*;

/*
 * Shows ways of modifying an LdapName
 *
 */
public class ModifyLdapName {
    
   public static void main(String args[]) {
       try {
           LdapName dn = new LdapName("ou=Fruits,o=Food");
           LdapName dn2 = new LdapName("ou=Summer");
           System.out.println(dn.addAll(dn2));           // ou=Summer,ou=Fruits,o=Food 
           System.out.println(dn.add(0, "o=Resources")); // ou=Summer,ou=Fruits,o=Food,o=Resources 
           System.out.println(dn.add("cn=WaterMelon"));  // cn=WaterMelon,ou=Summer,ou=Fruits,o=Food,o=Resources 
           System.out.println(dn.remove(1));             // o=Food
           System.out.println(dn);			 // cn=WaterMelon,ou=Summer,ou=Fruits,o=Resources
    } catch (InvalidNameException e) {
            e.printStackTrace();
        }
   }
}
