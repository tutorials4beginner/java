import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to create an initial context to an LDAP server
 * using anonymous authentication (i.e. none).
 *
 * usage: java None
 */
class None {
    public static void main(String[] args) {

	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);

	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	// Use anonymous authentication
	env.put(Context.SECURITY_AUTHENTICATION, "none");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    System.out.println(ctx.lookup("ou=NewHires"));

	    // do something useful with ctx

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
