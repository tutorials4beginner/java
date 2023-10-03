import javax.naming.ldap.*;
import javax.naming.InvalidNameException;
import java.util.*;
import javax.naming.directory.*;
import java.io.*;

/**
 * Converts an RDN to its String representation and
 * vice-versa
 */
public class RdntoString {

    public static void main(String args[])
		throws Exception {
	Rdn rdn = new Rdn("cn=Juicy\\,Fruit");
	String str = rdn.toString();
    	System.out.println(str);
    	Rdn rdn2 = new Rdn(str);
    	System.out.println(rdn.equals(rdn2));               // true
    }
}
