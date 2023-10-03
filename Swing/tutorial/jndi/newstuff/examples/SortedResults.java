import java.util.Hashtable;
import java.io.*;

import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.*;

/**
 * Shows how sorted search results can be obtained
 * using SortControl API
 */
class SortedResults {

    public static void main(String[] args) throws IOException {

	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL,
	    "ldap://localhost:389/ou=People,o=JNDITutorial");

	try {
	    // Create initial context with no connection request controls
	    LdapContext ctx = new InitialLdapContext(env, null);

	    // Create a sort control that sorts based on CN
	    String sortKey = "cn";
     	    ctx.setRequestControls(new Control[]{
		 new SortControl(sortKey, Control.CRITICAL) });

	    // Perform a search
     	    NamingEnumeration results =
         		ctx.search("", "(objectclass=*)", new SearchControls());

	    // Iterate over search results
	    System.out.println("---->sort by cn");
	    while (results != null && results.hasMore()) {
         	// Display an entry
         	SearchResult entry = (SearchResult) results.next();
         	System.out.println(entry.getName());

         	// Handle the entry's response controls (if any)
         	if (entry instanceof HasControls) {
             	    // ((HasControls)entry).getControls();
         	}
     	    }
	    // Examine the sort control response 
	    Control[] controls = ctx.getResponseControls();
     	    if (controls != null) {
         	for (int i = 0; i < controls.length; i++) {
             	    if (controls[i] instanceof SortResponseControl) {
                 	SortResponseControl src = (SortResponseControl)controls[i];
                 	if (! src.isSorted()) {
                     	    throw src.getException();
                        }
             	    } else {
                 	// Handle other response controls (if any)
             	    }
         	}
     	    }

	    // Close when no longer needed
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
