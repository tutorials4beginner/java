import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
 * Retrieves the DN from the search results
 */
class FullName {
    public static void printSearchEnumeration(NamingEnumeration retEnum) {
	try {
	    while (retEnum.hasMore()) {
		SearchResult sr = (SearchResult) retEnum.next();
		System.out.println(">>" + sr.getNameInNamespace());
	    }
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    NamingEnumeration answer = ctx.search("ou=People", null);

	    // Print the answer
	    printSearchEnumeration(answer);

	    // Close the context when we're done
	    ctx.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
