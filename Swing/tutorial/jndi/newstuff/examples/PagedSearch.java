import java.util.Hashtable;
import java.util.Enumeration;
import java.io.IOException;

import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.*;

/**
 * Shows how a paged search can be performed using the
 * PagedResultsControl API
 */

class PagedSearch {

public static void main(String[] args) {

    Hashtable<String, Object> env = new Hashtable<String, Object>(11);
    env.put(Context.INITIAL_CONTEXT_FACTORY,
	"com.sun.jndi.ldap.LdapCtxFactory");

    /* Specify host and port to use for directory service */
    env.put(Context.PROVIDER_URL,
		"ldap://localhost:389/ou=People,o=JNDITutorial");

    try {
        LdapContext ctx = new InitialLdapContext(env, null);

	// Activate paged results
	int pageSize = 5; 
	byte[] cookie = null;
        ctx.setRequestControls(new Control[]{
		new PagedResultsControl(pageSize, Control.NONCRITICAL) });
	int total;

	do {
	    /* perform the search */
            NamingEnumeration results =
		ctx.search("", "(objectclass=*)", new SearchControls());

            /* for each entry print out name + all attrs and values */
            while (results != null && results.hasMore()) {
		SearchResult entry = (SearchResult) results.next();
		System.out.println(entry.getName());
	    }

	    // Examine the paged results control response
	    Control[] controls = ctx.getResponseControls();
	    if (controls != null) {
		for (int i = 0; i < controls.length; i++) {
		    if (controls[i] instanceof PagedResultsResponseControl) {
			PagedResultsResponseControl prrc =
                         	 (PagedResultsResponseControl)controls[i];
			total = prrc.getResultSize();
			if (total != 0) {
			    System.out.println("***************** END-OF-PAGE " +
				"(total : " + total +
				") *****************\n");
			} else {
			    System.out.println("***************** END-OF-PAGE " +
			    "(total: unknown) ***************\n");
			}
			cookie = prrc.getCookie();
		    }
		}
	    } else {
		System.out.println("No controls were sent from the server");
	    }
            // Re-activate paged results
            ctx.setRequestControls(new Control[]{
		new PagedResultsControl(pageSize, cookie, Control.CRITICAL) });

	} while (cookie != null);

	ctx.close();

    } catch (NamingException e) {
        System.err.println("PagedSearch failed.");
        e.printStackTrace();
    } catch (IOException ie) {
        System.err.println("PagedSearch failed.");
        ie.printStackTrace();
    }
}
}
