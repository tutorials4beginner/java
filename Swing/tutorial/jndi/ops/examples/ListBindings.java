import javax.naming.*;
import java.util.Hashtable;

/**
 * Demonstrates how to list the bindings in a context.
 *
 * usage: java ListBindings
 */
class ListBindings {
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
	    NamingEnumeration bindings = ctx.listBindings("ou=People");

	    // Go through each item in list
	    while (bindings.hasMore()) {
		Binding bd = (Binding)bindings.next();
		System.out.println(bd.getName() + ": " + bd.getObject());
	    }

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("List Bindings failed: " + e);
	}
    }
}
