import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to rename an entry and keep its old RDN as an attribute.
 *
 * usage: java RenameKeepRDN
 */
class RenameKeepRDN {
    public static void main(String[] args) {

	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	// Set property to keep RDN
	env.put("java.naming.ldap.deleteRDN", "false");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Perform rename
	    ctx.rename("cn=C. User, ou=NewHires", "cn=Claude User,ou=NewHires");

	    // Check that it worked
	    System.out.println(ctx.getAttributes("cn=Claude User,ou=NewHires"));

	    // Revert change 
	    // Make sure new name doesn't get converted into attribute

	    ctx.removeFromEnvironment("java.naming.ldap.deleteRDN");
	    ctx.rename("cn=Claude User, ou=NewHires", "cn=C. User,ou=NewHires");

	    // Check that we are back at our original setup
	    System.out.println(ctx.getAttributes("cn=C. User,ou=NewHires"));

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
