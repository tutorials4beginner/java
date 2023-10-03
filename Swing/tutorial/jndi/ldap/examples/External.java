import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to create an initial context to an LDAP server
 * using External authentication & SSL.
 *
 * usage: java -Djavax.net.ssl.keyStore=MyKeystoreFile \
 * 	       -Djavax.net.ssl.keyStorePassword=mysecret \
 *     External
 */
class External {
    public static void main(String[] args) {
	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:636/o=JNDITutorial");

	// Principal & credentials will be obtained from the connection
	env.put(Context.SECURITY_AUTHENTICATION, "EXTERNAL");

	// Specify SSL
	env.put(Context.SECURITY_PROTOCOL, "ssl");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    System.out.println(ctx.lookup("ou=NewHires"));

	    // do something useful with ctx

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
