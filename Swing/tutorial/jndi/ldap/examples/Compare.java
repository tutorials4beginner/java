import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
 * Demonstrates how to do the equivalent of an LDAP "compare".
 *
 * usage: java Compare
 */
class Compare {
    public static void main(String[] args) {


	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Value of attribute
	    byte[] key = {(byte)0x61, (byte)0x62, (byte)0x63, (byte)0x64, 
			  (byte)0x65, (byte)0x66, (byte)0x67};

	    // Set up search controls
	    SearchControls ctls = new SearchControls();
	    ctls.setReturningAttributes(new String[0]);       // return no attrs
	    ctls.setSearchScope(SearchControls.OBJECT_SCOPE); // search object only

	    // Invoke search method that will use the LDAP "compare" operation
	    NamingEnumeration answer = ctx.search("cn=S. User, ou=NewHires", 
		"(mySpecialKey={0})", new Object[]{key}, ctls);
		
	    // Print the answer
	    FilterArgs.printSearchEnumeration(answer);

	    // Close the context when we're done
	    ctx.close();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
