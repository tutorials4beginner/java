/* 
 */

import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
  * Demonstrates how to bind a Serializable object to a directory
  * with a codebase.
  * (Use Unbind to remove binding.)
  *
  * usage: java SerObjWithCodebase <codebase URL>
  */

class SerObjWithCodebase {
    public static void main(String[] args) {

	if (args.length != 1) {
	    System.err.println("usage: java SerObjWithCodebase <codebase URL>");
	    System.exit(-1);
	}

	String codebase = args[0];

	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create the initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Create object to be bound
	    Flower f = new Flower("rose", "pink");

	    // Perform bind and specify codebase
	    ctx.bind("cn=Flower", f, new BasicAttributes("javaCodebase", codebase));

	    // Check that it is bound
	    Flower f2 = (Flower)ctx.lookup("cn=Flower");
	    System.out.println(f2);

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("Operation failed: " + e);
	}
    }
}
