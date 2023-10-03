import javax.naming.ldap.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InvalidNameException;
import javax.naming.directory.*;

/**
 * Shows different ways of constructing an Rdn
 */
public class RdnConstructors {

    public static void main(String args[])
		throws Exception {
	/**
	 * There are four ways of constructing an Rdn
	 */
	Rdn rdn1 = new Rdn("ou= Juicy\\, Fruit");
	System.out.println("rdn1:" + rdn1.toString());

	Rdn rdn2 = new Rdn(rdn1);
	System.out.println("rdn2:" + rdn2.toString());

	Attributes attrs = new BasicAttributes();
	attrs.put("ou", "Juicy, Fruit");
	attrs.put("cn", "Mango");
	Rdn rdn3 = new Rdn(attrs);
	System.out.println("rdn3:" + rdn3.toString());

	Rdn rdn4 = new Rdn("ou", "Juicy, Fruit");
	System.out.println("rdn4:" + rdn4.toString());
    }
}
