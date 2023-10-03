import javax.naming.ldap.*;
import javax.naming.*;

/*
 *  Shows ways of comparing LDAP names
 */
public class CompareLdapNames {
    public static void main(String args[]) {
        try {
            LdapName one = new LdapName("cn=Vincent Ryan, ou=People, o=JNDITutorial");
            LdapName two = new LdapName("cn=Vincent Ryan");
            LdapName three = new LdapName("o=JNDITutorial");
            LdapName four = new LdapName("");
       
            System.out.println(one.equals(two)); 	    // false
            System.out.println(one.startsWith(three));  // true
            System.out.println(one.endsWith(two));      // true
            System.out.println(one.startsWith(four));   // true
            System.out.println(one.endsWith(four));     // true
            System.out.println(one.endsWith(three));    // false
            System.out.println(one.isEmpty());	    // false
            System.out.println(four.isEmpty());	    // true
            System.out.println(four.size() == 0);	    // true
         }  catch (InvalidNameException e) {
            e.printStackTrace();
         }
    }
}
