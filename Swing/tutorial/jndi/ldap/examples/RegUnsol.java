import javax.naming.*;
import javax.naming.ldap.*;
import javax.naming.event.*;

import java.util.Hashtable;

/**
  * Demonstrates how to register a listener for Unsolicited Notifications.
  * In order for the listener to receive a notification, you must
  * prod the directory server to send an Unsolicited Notification.
  * The procedure for doing so is directory-dependent.
  *
  * usage: java RegUnsol
  */
class RegUnsol {
    public static void main(String[] args) {

	// Set up environment for creating initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDItutorial");

	try {
	    // Get event context for registering listener
	    EventContext ctx = (EventContext)
		(new InitialContext(env).lookup("ou=People"));

	    // Create listener
	    NamingListener listener = new UnsolListener();

	    // Register listener with context (all targets equivalent)
	    ctx.addNamingListener("", EventContext.ONELEVEL_SCOPE, listener);

	    // Wait 1 minutes for listener to receive events
	    try {
		Thread.sleep(60000);
	    } catch (InterruptedException e) {
		System.out.println("sleep interrupted");
	    }

	    // Not strictly necessary if we're going to close context anyhow
	    ctx.removeNamingListener(listener);

	    // Close context when we're done
	    ctx.close();

	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }

    /**
     * A sample UnsolicitedNotificationListener.
     */
    static class UnsolListener implements UnsolicitedNotificationListener {
	public void notificationReceived(UnsolicitedNotificationEvent evt) {
	    System.out.println("received: " + evt);
	}

	public void namingExceptionThrown(NamingExceptionEvent evt) {
	    System.out.println(">>> UnsolListener got an exception");
	    evt.getException().printStackTrace();
	}
    }
}

