import javax.naming.*;
import java.util.Hashtable;

/**
 * Demonstrates how to list the name and class of objects in a context.
 *
 * usage: java List
 */
class List {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create the initial context
	    Context ctx = new InitialContext(env);

	    // Get listing of context
	    NamingEnumeration list = ctx.list("ou=People");

	    // Go through each item in list
	    while (list.hasMore()) {
		NameClassPair nc = (NameClassPair)list.next();
		System.out.println(nc);
	    }

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("List failed: " + e);
	}
    }
}
