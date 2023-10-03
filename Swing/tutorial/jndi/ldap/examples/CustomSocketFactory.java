import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

/*
 * A custom socket factory used to override the default socket factory.
 * It prints out debugging information before using default Socket creation
 * methods. This class is required for the UseFactory example.
 */
public class CustomSocketFactory extends SocketFactory {

    public CustomSocketFactory() {
	System.out.println("[creating a custom socket factory]");
    }

    public static SocketFactory getDefault() {

	System.out.println("[acquiring the default socket factory]");
	return new CustomSocketFactory();
    }

    public Socket createSocket(String host, int port)
	throws IOException, UnknownHostException {

	System.out.println("[creating a custom socket (method 1)]");
	return new Socket(host, port);
    }

    public Socket createSocket(String host, int port, InetAddress localHost,
	int localPort) throws IOException, UnknownHostException {

	System.out.println("[creating a custom socket (method 2)]");
	return new Socket(host, port, localHost, localPort);
    }

    public Socket createSocket(InetAddress host, int port) throws IOException {

	System.out.println("[creating a custom socket (method 3)]");
	return new Socket(host, port);
    }

    public Socket createSocket(InetAddress address, int port,
	InetAddress localAddress, int localPort) throws IOException {

	System.out.println("[creating a custom socket (method 4)]");
	return new Socket(address, port, localAddress, localPort);
    }
}

