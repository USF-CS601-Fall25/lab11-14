package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/** A servlet that processes the get request coming to the "/clear"
 * endpoint. Clears the "username" cookie.
 */
@SuppressWarnings("serial")
public class ClearCookieServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// FILL IN CODE
		// Clear the "username" cookie

		// Output to the response that the cookie has been cleared

	}
}