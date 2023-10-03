import javax.naming.*;
import javax.naming.ldap.*;

/*
 * Retrieve's an LdapName's suffix and prefix
 */
public class LdapNameSuffixPrefix {
    public static void main(String args[]) {
        String name = "cn=Mango, ou=Fruits, o=Food";
        try {
            LdapName dn = new LdapName(name);
            Name suffix = dn.getSuffix(1);  // 1 <= index < cn.size()
            Name prefix = dn.getPrefix(1);  // 0 <= index < 1
            System.out.println(suffix);
            System.out.println(prefix);
        } catch (InvalidNameException e) {
            System.out.println("Cannot parse name: " + name);
        }
    }
}
