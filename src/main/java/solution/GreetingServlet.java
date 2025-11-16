package solution;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


/** An example that demonstrates how to process HTML forms with servlets.
 */
public class GreetingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println();
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();

		// Is there a name cookie?
		// If yes, show Welcome, <name>!
		// If no, show the form
		String value = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					value = cookie.getValue();
					break; //  found the cookie
				}
			}
		}
		if (value.equals(""))
			printForm(request, response);
		else {
			out.println("Welcome, " + value + "!");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		String nameParam = request.getParameter("username");
		nameParam = StringEscapeUtils.escapeHtml4(nameParam);

		// Save to the cookie
		response.addCookie(new Cookie("username", nameParam));
		response.sendRedirect("/greet");

	}

	private void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		VelocityEngine ve = (VelocityEngine) getServletContext().getAttribute("templateEngine");
		Template template = ve.getTemplate("templates/formSolution.html");
		VelocityContext context = new VelocityContext();
		StringWriter sw = new StringWriter();
		template.merge(context, sw);
		out.println(sw);
	}

}