import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to rename an entry to another part of the namespace.
 *
 * usage: java RenameDiffParent
 */
class RenameDiffParent {
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
	    ctx.rename("cn=C. User, ou=NewHires", "cn=C. User, ou=People");

	    // Check that it worked
	    System.out.println(ctx.lookup("cn=C. User, ou=People"));

	    // Revert change
	    ctx.rename("cn=C. User, ou=People", "cn=C. User, ou=NewHires");

	    // Check that we are back at our original setup
	    System.out.println(ctx.lookup("cn=C. User, ou=NewHires"));

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
