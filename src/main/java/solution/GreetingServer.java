package solution;

import org.apache.velocity.app.VelocityEngine;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/** An example that demonstrates how to process HTML forms with servlets.
 *  Run this server, then go to the browser, type localhost:8080/form  */
public class GreetingServer {

	public static final int PORT = 9000;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(GreetingServlet.class, "/greet");
		handler.addServlet(ClearCookieServlet.class, "/clear");

		// initialize Velocity and set as an attribute
		VelocityEngine velocity = new VelocityEngine();
		velocity.init();
		handler.setAttribute("templateEngine", velocity);
		server.setHandler(handler);
		server.start();
		server.join();
	}
}