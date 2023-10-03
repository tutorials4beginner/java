import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to perform a search and limit the number of
 * results returned.
 *
 * usage: java SearchCountLimit
 */
class SearchCountLimit {
    static int expected = 1;
    public static void printSearchEnumeration(NamingEnumeration srhEnum) {
	int count = 0;
	try {
	    while (srhEnum.hasMore()) {
		SearchResult sr = (SearchResult) srhEnum.next();
		System.out.println(">>>" + sr.getName());
		++count;
	    }
	    System.out.println("number of answers: " + count);
	} catch (SizeLimitExceededException e) {
	    if (count == expected)
		System.out.println("number of answers: " + count);
	    else
		e.printStackTrace();
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

	    // Set search controls to limit count to 'expected'
	    SearchControls ctls = new SearchControls();
	    ctls.setCountLimit(expected);

	    // Search for objects with those matching attributes
	    NamingEnumeration answer = 
		ctx.search("ou=People","(sn=M*)", ctls );

	    // Print the answer
	    printSearchEnumeration(answer);

	    // Close the context when we're done
	    ctx.close();
	} catch (Exception e) {
	    System.err.println(e);
	}
    }
}
