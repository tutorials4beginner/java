import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to make modifications to an object's attributes.
 * It remove an attribute, adds an attribute value, and replaces
 * an attribute value.
 * After making the modifications, it replaces the object's attributes
 * with its original attributes.
 *
 * usage: java ModAttrs
 */

class ModAttrs {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create the initial context
	    DirContext ctx = new InitialDirContext(env);
	    String name = "cn=Ted Geisel, ou=People";

	    // Save original attributes
	    Attributes orig = ctx.getAttributes(name, 
		new String[]{"mail", "telephonenumber", "jpegphoto"});

	    // Specify the changes to make
	    ModificationItem[] mods = new ModificationItem[3];

	    // Replace the "mail" attribute with a new value
	    mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
		new BasicAttribute("mail", "geisel@wizards.com"));

	    // Add additional value to "telephonenumber"
	    mods[1] = new ModificationItem(DirContext.ADD_ATTRIBUTE,
		new BasicAttribute("telephonenumber", "+1 555 555 5555"));

	    // Remove the "jpegphoto" attribute
	    mods[2] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE,
		new BasicAttribute("jpegphoto"));
	    
	    // Perform the requested modifications on the named object
	    ctx.modifyAttributes(name, mods);

	    // Check attributes
	    System.out.println("**** new attributes *****");
	    printAttrs(ctx.getAttributes(name));

	    // Revert changes
	    ctx.modifyAttributes(name, DirContext.REPLACE_ATTRIBUTE, orig);

	    // Check that the attributes got restored
	    System.out.println("**** reverted to original attributes *****");
	    printAttrs(ctx.getAttributes(name));

	    // Close the context when we're done
	    ctx.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    static void printAttrs(Attributes attrs) {
	if (attrs == null) {
	    System.out.println("No attributes");
	} else {
	    /* Print each attribute */
	    try {
		for (NamingEnumeration ae = attrs.getAll();
		     ae.hasMore();) {
		    Attribute attr = (Attribute)ae.next();
		    System.out.println("attribute: " + attr.getID());

		    /* print each value */
		    for (NamingEnumeration e = attr.getAll();
			 e.hasMore();
			 System.out.println("value: " + e.next()))
			;
		}
	    } catch (NamingException e) {
		e.printStackTrace();
	    }
	}
    }

}
