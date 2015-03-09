package network.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.utils.Array;

public class Network {
	private Label labelMessage;
	private TextArea textIPAddress;
	private TextArea textMessage;

	// labelMessage = new Label("Hello world", skin);

	public void scanningNIC() throws SocketException {
		Array<String> addresses = new Array<String>();

		Enumeration<NetworkInterface> interfaces = NetworkInterface
				.getNetworkInterfaces();

		for (NetworkInterface ni : Collections.list(interfaces)) {
			for (InetAddress address : Collections.list(ni.getInetAddresses())) {
				if (address instanceof Inet4Address) {
					addresses.add(address.getHostAddress());
				}
			}
		}
		printContent(addresses);

	}

	public void printContent(Array<String> addresses) {
		String ipAddress = new String("");

		for (String str : addresses) {
			ipAddress = ipAddress + str + "\n";
		}
	}

	public void startSocket() throws IOException {
		ServerSocketHints serverSocketHint = new ServerSocketHints();
		// 0 means no timeout. Probably not the greatest idea in
		// production!
		serverSocketHint.acceptTimeout = 0;

		// Create the socket server using TCP protocol and listening on
		// 9021
		// Only one app can listen to a port at a time, keep in mind
		// many ports are reserved
		// especially in the lower numbers ( like 21, 80, etc )
		ServerSocket serverSocket = Gdx.net.newServerSocket(Protocol.TCP, 9021,
				serverSocketHint);

		listenToSignals(serverSocket);
	}

	public void listenToSignals(ServerSocket serverSocket) throws IOException {
		while (true) {
			// Create a socket
			Socket socket = serverSocket.accept(null);

			// Read data from the socket into a BufferedReader
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			// Read to the next newline (\n) and display that text
			// on labelMessage
			labelMessage.setText(buffer.readLine());
		}
	}

	// textMessage = new TextArea("", skin);
	// textIPAddress = new TextArea("", skin);
	public void listeningForSomeoneWhoHasMadeAMove() {
		SocketHints socketHints = new SocketHints();
		// Socket will time our in 4 seconds
		socketHints.connectTimeout = 4000;
		// create the socket and connect to the server entered in the
		// text box ( x.x.x.x format ) on port 9021
		Socket socket = Gdx.net.newClientSocket(Protocol.TCP,
				textIPAddress.getText(), 9021, socketHints);

		// When the button is clicked, get the message text or create a
		// default string value
		String textToSend = new String();
		if (textMessage.getText().length() == 0) {
			textToSend = "Doesn't say much but likes clicking buttons\n";
		} else {
			textToSend = textMessage.getText() + ("\n"); // Brute for a
															// newline
															// so
															// readline
															// gets a
															// line
		}

		try {
			// write our entered message to the stream
			socket.getOutputStream().write(textToSend.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
