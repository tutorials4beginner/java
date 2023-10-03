import javax.naming.*;
import java.io.File;
import java.util.Hashtable;

/**
  * Demonstrates how to rename an object.
  *
  * usage: java Rename
  */

class Rename {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL,
		"ldap://localhost:389/ou=People,o=JNDITutorial");

	try {
	    // Create the initial context
	    Context ctx = new InitialContext(env);

	    // Rename to Scott S
	    ctx.rename("cn=Scott Seligman", "cn=Scott S");

	    // Check that it is there using new name
	    Object obj = ctx.lookup("cn=Scott S");
	    System.out.println(obj);

	    // Rename back to Scott Seligman
	    ctx.rename("cn=Scott S", "cn=Scott Seligman");

	    // Check that it is there with original name
	    obj = ctx.lookup("cn=Scott Seligman");
	    System.out.println(obj);

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("Rename failed: " + e);
	}
    }
}
