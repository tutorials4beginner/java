import javax.naming.ldap.*;
import javax.naming.InvalidNameException;
import java.util.*;
import javax.naming.directory.*;
import java.io.*;

/**
 * Shows ways of accessing the type/value pair(s)
 * from an RDN
 */
public class RdnGetters {

    public static void main(String args[])
		throws Exception {
	Attributes attrs = new BasicAttributes();
	attrs.put("o", "Yellow");
	attrs.put("cn", "Mango");

	byte[] mangoJuice = new byte[6];
	for (int i = 0; i < mangoJuice.length; i++) {
	    mangoJuice[i] = (byte) i;
	}
	attrs.put("ou", mangoJuice);
	Rdn rdn = new Rdn(attrs);

	System.out.println();
	System.out.println("size:" + rdn.size());
	System.out.println("getType(): " + rdn.getType());
	System.out.println("getValue(): " + rdn.getValue());

        // test toAttributes
	System.out.println();
	System.out.println("toAttributes(): " + rdn.toAttributes());
    }
}
