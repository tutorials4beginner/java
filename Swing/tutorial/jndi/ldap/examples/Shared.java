import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Shows contexts that share the same connection.
 *
 * usage: java Shared
 */
class Shared {
    public static void main(String[] args) {
	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Get a copy of the same context
	    Context ctx2 = (Context)ctx.lookup("");

	    // Get a child context
	    Context ctx3 = (Context) ctx.lookup("ou=NewHires");

	    // do something useful with ctx, ctx2, ctx3

	    // Close the contexts when we're done
	    ctx.close();
	    ctx2.close();
	    ctx3.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
