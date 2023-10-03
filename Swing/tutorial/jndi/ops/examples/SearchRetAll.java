import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to perform a search by specifying a set of
 * attributes to be matched. Returns all attributes of objects
 * that contain those matching attributes.
 *
 * usage: java SearchRetAll
 */
class SearchRetAll {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Specify the attributes to match
	    // Ask for objects with the surname ("sn") attribute
	    // with the value "Geisel"
	    // and the "mail" attribute.
	    Attributes matchAttrs = new BasicAttributes(true); // ignore case
	    matchAttrs.put(new BasicAttribute("sn", "Geisel"));
	    matchAttrs.put(new BasicAttribute("mail"));

	    // Search for objects that have those matching attributes
	    NamingEnumeration answer = ctx.search("ou=People", matchAttrs);

	    // Print the answer
	    Search.printSearchEnumeration(answer);

	    // Close the context when we're done
	    ctx.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
