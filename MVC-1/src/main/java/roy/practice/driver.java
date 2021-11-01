package roy.practice;

import java.io.IOException;
import java.io.File;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class driver
 */
@WebServlet("/driver")
public class driver extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public driver() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String val = request.getParameter("page");
		if (val == null) {
			response.getWriter().print("No Page");
		}
		else {
			File f = new File(val + ".jsp");
			if (f.exists() && !f.isDirectory()) {
				getServletContext().getRequestDispatcher("/" + val + ".jsp").forward(request, response);
			}
			else {
				response.getWriter().print("Invalid Param");
			}
		}
	}

}
