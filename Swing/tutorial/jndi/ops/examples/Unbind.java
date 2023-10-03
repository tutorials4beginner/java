import javax.naming.*;
import java.io.File;
import java.util.Hashtable;

/**
  * Demonstrates how to remove a binding.
  * (Use after Bind or Rebind example).
  * 
  * usage: java Unbind
  */
class Unbind {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create the initial context
	    Context ctx = new InitialContext(env);

	    // Remove the binding
	    ctx.unbind("cn=Favorite Fruit");

	    // Check that it is gone
	    Object obj = null;
	    try {
		obj = ctx.lookup("cn=Favorite Fruit");
	    } catch (NameNotFoundException ne) {
		System.out.println("unbind successful");
		return;
	    }

	    System.out.println("unbind failed; object still there: " + obj);

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("Operation failed: " + e);
	}
    }
}
