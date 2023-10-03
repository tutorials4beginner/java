import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to create an initial context to an LDAP server
 * using a custom socket factory. Requires use of the CustomSocketFactory class.
 *
 * usage: java UseFactory
 */
class UseFactory {
    public static void main(String[] args) {
	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	// Specify the socket factory
	env.put("java.naming.ldap.factory.socket", "CustomSocketFactory");

	// Authenticate as S. User and password "mysecret"
	env.put(Context.SECURITY_AUTHENTICATION, "simple");
	env.put(Context.SECURITY_PRINCIPAL, 
	    "cn=S. User, ou=NewHires, o=JNDITutorial");
	env.put(Context.SECURITY_CREDENTIALS, "mysecret");


	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    System.out.println(ctx.lookup("ou=NewHires"));

	    // ... do something useful with ctx

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
