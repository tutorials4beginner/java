import javax.naming.*;
import java.util.Hashtable;

/**
  * Demonstrates how to destroy a subcontext called "ou=NewOu".
  * (Run this after running Create)
  *
  * usage: java Destroy
  */
class Destroy {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create the initial context
	    Context ctx = new InitialContext(env);

	    // Destroy the context
	    ctx.destroySubcontext("ou=NewOu");

	    // Check that it has been destroyed by listing its parent
	    NamingEnumeration list = ctx.list("");

	    // Go through each item in list
	    while (list.hasMore()) {
		NameClassPair nc = (NameClassPair)list.next();
		System.out.println(nc);
	    }

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("destroy failed: " + e);
	}
    }
}
