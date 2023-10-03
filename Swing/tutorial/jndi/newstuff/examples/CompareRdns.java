import javax.naming.ldap.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InvalidNameException;

/**
 * Demonstrates RDN comparison
 */
public class CompareRdns {

    public static void main(String args[])
		throws Exception {

	/**
	 * Compare:
	 * 1) same RDN sequence with an type/value pairs ordered differently.
	 * 2) RDN sequence of different length.
	 * 3) RDN sequence of different Case.
	 */
	Rdn one = new Rdn("ou=Sales+cn=Bob");
	Rdn two = new Rdn("cn=Bob+ou=Sales");
 	Rdn three = new Rdn("ou=Sales+cn=Bob+c=US");	
 	Rdn four = new Rdn("cn=lowercase");
 	Rdn five = new Rdn("cn=LowerCASE");
	System.out.println(one.equals(two));  // true
	System.out.println(two.equals(three));  // false
	System.out.println(one.equals(three));  // false
	System.out.println(four.equals(five));  // true
    }
}
