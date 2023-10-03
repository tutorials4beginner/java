import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to use different authentication information
 * for one context.
 *
 * usage: java UseDiff
 */
class UseDiff {
    public static void main(String[] args) {

	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	// Authenticate as S. User and password "mysecret"
	env.put(Context.SECURITY_AUTHENTICATION, "simple");
	env.put(Context.SECURITY_PRINCIPAL, "cn=S. User, ou=NewHires, o=JNDITutorial");
	env.put(Context.SECURITY_CREDENTIALS, "mysecret");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // do something useful with ctx
	    System.out.println(ctx.lookup("ou=NewHires"));

	    // Change to using no authentication
	    ctx.addToEnvironment(Context.SECURITY_AUTHENTICATION, "none");

	    System.out.println(ctx.lookup("ou=NewHires"));

	    // do something useful with ctx

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
