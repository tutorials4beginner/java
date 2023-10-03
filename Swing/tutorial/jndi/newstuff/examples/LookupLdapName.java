import javax.naming.*;
import javax.naming.ldap.*;
import java.util.Hashtable;
import java.awt.Button;

/**
  * Demonstrates how to pass LDAP name to the context methods.
  */
class LookupLdapName {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/");

	try {
	    // Create the initial context
	    Context ctx = new InitialContext(env);

	    // A string representation of an LDAP name
	    LdapName dn = new LdapName("ou=People,o=JNDITutorial");

	    // Perform the lookup using the dn
	    Object obj = ctx.lookup(dn);

	    System.out.println(obj);

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("Lookup failed: " + e);
	}
    }
}
