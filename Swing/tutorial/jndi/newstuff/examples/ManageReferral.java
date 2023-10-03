import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.*;

import java.util.Hashtable;

/**
 * Demonstrates how to search the directory that ignores referrals
 * returned by the server.
 */
class ManageReferral {
    public static void main(String[] args) {


	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:489/o=JNDITutorial");
	//env.put(Context.REFERRAL, "follow");
	env.put(Context.REFERRAL, "ignore");

	try {
	    // Create initial context
	    LdapContext ctx = (LdapContext) new InitialLdapContext(env, null);
	    //ctx.setRequestControls(new Control[] {
		// new ManageReferralControl() });

	    // Set controls for performing subtree search
	    SearchControls ctls = new SearchControls();
	    ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

	    // Perform search
	    NamingEnumeration answer = ctx.search("", "(objectclass=*)", ctls);

	    // Print the answer
	    while (answer.hasMore()) {
		System.out.println(">>>" + ((SearchResult)answer.next()).getName());
	    }

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
