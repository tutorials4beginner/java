import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
  * Demonstrates how to create a new subcontext called "ou=NewOu" with some 
  * attributes.
  * (Run Destroy after this to remove the subcontext).
  *
  * usage: java Create
  */
class Create {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create the initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Create attributes to be associated with the new context
	    Attributes attrs = new BasicAttributes(true); // case-ignore
	    Attribute objclass = new BasicAttribute("objectclass");
	    objclass.add("top");
	    objclass.add("organizationalUnit");
	    attrs.put(objclass);

	    // Create the context
	    Context result = ctx.createSubcontext("ou=NewOu", attrs);

	    // Check that it was created by listing its parent
	    NamingEnumeration list = ctx.list("");

	    // Go through each item in list
	    while (list.hasMore()) {
		NameClassPair nc = (NameClassPair)list.next();
		System.out.println(nc);
	    }

	    // Close the contexts when we're done
	    result.close();
	    ctx.close();
	} catch (NamingException e) {
	    System.out.println("Create failed: " + e);
	}
    }
}
