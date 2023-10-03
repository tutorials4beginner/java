/* 
 */

import javax.naming.*;
import java.util.Hashtable;
import java.awt.Button;

/**
  * Demonstrates how to bind a Serializable object to a directory.
  * (Use Unbind to remove binding.)
  *
  * usage: java SerObj
  */

class SerObj {
    public static void main(String[] args) {

	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create the initial context
	    Context ctx = new InitialContext(env);

	    // Create object to be bound
	    Button b = new Button("Push me");

	    // Perform bind
	    ctx.bind("cn=Button", b);

	    // Check that it is bound
	    Button b2 = (Button)ctx.lookup("cn=Button");
	    System.out.println(b2);

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("Operation failed: " + e);
	}
    }
}
