import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to retrieve selected attributes of a named object.
 *
 * usage: java GetAttrs
 */
class GetAttrs {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Specify the ids of the attributes to return
	    String[] attrIDs = {"sn", "telephonenumber", "golfhandicap", "mail"};

	    // Get the attributes requested
	    Attributes answer = 
		ctx.getAttributes("cn=Ted Geisel, ou=People", attrIDs);

	    // Print the answer
	    printAttrs(answer);

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
