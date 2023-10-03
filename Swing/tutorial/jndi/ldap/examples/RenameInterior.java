import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to rename an interior node.
 *
 * usage: java RenameInterior
 */
class RenameInterior {
    public static void main(String[] args) {

	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Perform rename
	    ctx.rename("ou=NewHires", "ou=OldHires");

	    // Check that it worked
	    System.out.println(ctx.lookup("ou=OldHires"));

	    // Revert change
	    ctx.rename("ou=OldHires", "ou=NewHires");

	    // Check that we are back at our original setup
	    System.out.println(ctx.lookup("ou=NewHIres"));

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
