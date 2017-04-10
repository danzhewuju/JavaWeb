package usst;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PutCarMarket
 */
@WebServlet("/PutCarMarket")
public class PutCarMarket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	boolean first;
    public PutCarMarket() {
        super();
        first=true;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	   ArrayList<Integer>Car=null;
		if(first)
		{
			first=false;
			Car=new ArrayList<Integer>();
		}
		else
		{
			Car=(ArrayList<Integer>) request.getSession().getAttribute("Car");
		}
		int indox=Integer.valueOf(request.getParameter("indox"));
		Car.add(indox);
		request.getSession().setAttribute("Car", Car);
		RequestDispatcher rd=request.getRequestDispatcher("Buy.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
