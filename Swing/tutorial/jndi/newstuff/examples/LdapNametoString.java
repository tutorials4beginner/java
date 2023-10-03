import javax.naming.ldap.*;
import javax.naming.*;

/*
 * Shows how LdapName to String conversion works
 */
public class LdapNametoString {
    public static void main(String args[]) {
        String name = "cn=JuicyFruit, ou=Fruits";
        try {
            LdapName dn = new LdapName(name);
            String str = dn.toString();
            System.out.println(str);
            LdapName dn2 = new LdapName(str);
            System.out.println(dn.equals(dn2));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }
}
