package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**  The webserver that should behave as following:
 *   When it receives the request to /greet, it will check if there is a "username"
 *   cookie for this client.
 *   If yes, it will get the username from the cookie and display
 *   Welcome, username!
 *   If there is no cookie with the name "username", it should show the form that asks
 *   the user to enter the name (you need to use Velocity to display form.html - you need to fill in some HTML code inside form.html first).
 *   Then it saves it in the "username" cookie and redirects to /greet.
 *
 *   When the webserver receives the request to /clear, it should clear the "username" cookie.
 */
public class GreetingServer {

	public static final int PORT = 9000;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		// FILL IN CODE:
		// Use the handler to map "/greet" to GreetingServlet
		// Use the handler to map "/clear" to ClearCookieServlet

		// FILL IN CODE:
		// Initialize a VelocityEngine and set it as an attribute of the handler
		server.setHandler(handler);
		server.start();
		server.join();

	}
}