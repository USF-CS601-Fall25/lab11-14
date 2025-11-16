package solution;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@SuppressWarnings("serial")
public class ClearCookieServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		clearUsernameCookie(request, response);
		PrintWriter out = response.getWriter();
		out.printf("<p>The username cookie for this site has been deleted.</p>%n%n");
	}


	public void clearUsernameCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie("username", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}