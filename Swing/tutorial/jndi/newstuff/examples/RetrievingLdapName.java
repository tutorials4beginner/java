import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.*;
import java.util.Hashtable;

/**
 * Shows how an LdapName can be obtained from the search results.
 */
class RetrievingLdapName {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    NamingEnumeration answer = 
		ctx.search("ou=People", null);

	    // Print the answer
	    while (answer.hasMore()) {
		SearchResult sr = (SearchResult) answer.next();
		String name = sr.getNameInNamespace();
		System.out.println(name);
		LdapName dn = new LdapName(name);

		// do something with the dn
	    }

	    // Close the context when we're done
	    ctx.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
