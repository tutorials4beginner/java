import javax.naming.*;
import javax.naming.ldap.*;
import java.util.Hashtable;
import java.awt.Button;

/**
  * Demonstrates how to look up an object.
  *
  * usage: java Lookup
  */
class Lookup {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create the initial context
	    Context ctx = new InitialContext(env);

	    // Perform lookup and cast to target type
	    LdapContext b = (LdapContext) ctx.lookup(
			"cn=Rosanna Lee,ou=People");

	    System.out.println(b);

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("Lookup failed: " + e);
	}
    }
}
