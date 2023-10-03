import java.net.*;

public class BlacklistCookiePolicy implements CookiePolicy
{
    String[] blacklist;

    public BlacklistCookiePolicy(String[] list) {
        blacklist = list;
    }

    public boolean shouldAccept(URI uri, HttpCookie cookie)  {
        String host;
        try {
            host =  InetAddress.getByName(uri.getHost()).getCanonicalHostName();
        } catch (UnknownHostException e) {
            host = uri.getHost();
        }

        for (int i=0; i<blacklist.length; i++) {
	    if (HttpCookie.domainMatches(blacklist[i], host)) {
                return false;
            }
        }

        return CookiePolicy.ACCEPT_ORIGINAL_SERVER.shouldAccept(uri, cookie);
    }
}
