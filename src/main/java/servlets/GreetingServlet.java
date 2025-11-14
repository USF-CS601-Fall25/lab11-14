package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


/** An example that demonstrates how to process HTML form, cookie, Velocity template engine.
 */
@SuppressWarnings("serial")
public class GreetingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println();
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();

		// FILL IN CODE:
		// Is there a cookie with the name "username"?
		// If yes, get the value of this cookie and show
		// Welcome, username!

		// FILL IN CODE:
		// If no such cookie exists, show the html form that allows the user to enter their name
		// Load the form from Velocity template - see templates/form.html
		// Must add some HTML code to form.html first. The template is incomplete.
		// When the form is submitted, GreetingServlet's doPost method should be invoked
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		// This method should be called when the user submits the form with the name.
		// Extract the name parameter from the request, "clean" it,
		// create a "username" cookie with this name, and add it to the response

		// redirect to the same servlet using the sendRedirect method.
	}
}