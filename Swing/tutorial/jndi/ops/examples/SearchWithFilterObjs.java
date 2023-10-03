import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to perform a search by specifying a search filter,
 * objects to fill in filter, andsearch controls. 
 * Functionally identical to Search.java.
 *
 * usage: java SearchWithFilterObjs
 */
class SearchWithFilterObjs {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Specify the ids of the attributes to return
	    String[] attrIDs = {"sn", "telephonenumber", "golfhandicap", "mail"};
	    SearchControls ctls = new SearchControls();
	    ctls.setReturningAttributes(attrIDs);

	    // Specify the search filter to match
	    // Ask for objects with attribute sn == Geisel and which have
	    // the "mail" attribute.
	    String filter = "(&(sn={0})(mail=*))";

	    // Search for objects using filter
	    NamingEnumeration answer = 
		ctx.search("ou=People", filter, 
		    new Object[] {"Geisel"},ctls);

	    // Print the answer
	    Search.printSearchEnumeration(answer);

	    // Close the context when we're done
	    ctx.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
