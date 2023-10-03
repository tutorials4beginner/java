import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Shows contexts that originally shared the same connection using different
 * connection.
 *
 * usage: java NewConn
 */
class NewConn {
    public static void main(String[] args) {
	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context (first connection)
	    DirContext ctx = new InitialDirContext(env);

	    // Get a copy of the same context
	    DirContext ctx2 = (DirContext)ctx.lookup("");

	    // Change authentication properties in ctx2
	    ctx2.addToEnvironment(Context.SECURITY_PRINCIPAL, 
		"cn=C. User, ou=NewHires, o=JNDITutorial");
	    ctx2.addToEnvironment(Context.SECURITY_CREDENTIALS, "mysecret");

	    // Method on ctx2 will use new connection
	    System.out.println(ctx2.getAttributes("ou=NewHires"));

	    // Close the contexts when we're done
	    ctx.close();
	    ctx2.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
