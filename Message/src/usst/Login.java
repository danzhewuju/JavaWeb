package usst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    boolean point=true; 
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    	
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("n1");
		if(name.length()==0)
		{
			response.sendRedirect("login.html");
		}
		else
		{	String gender=request.getParameter("n2");
		    String flag=request.getParameter("n3");
			Visitor v=new Visitor();
			v.setName(name);
			v.setGender(gender);
			ArrayList<Visitor> visitors=null;
			if(point)
			{
				point=false;
				 visitors=new ArrayList<Visitor>();
			}
			else
			{
			  visitors=(ArrayList<Visitor>) request.getSession().getAttribute("visitors");
			}
			visitors.add(v);
			request.getSession().setAttribute("visitors", visitors);
			request.getSession().setAttribute("user", v);
			if(flag!=null)
			{
				Cookie username=new Cookie("name",name);
				Cookie usergender=new Cookie("gender", gender);
				username.setMaxAge(60*60);//一个小时
				response.addCookie(username);
				usergender.setMaxAge(60*60);
				response.addCookie(usergender);
			}
		 RequestDispatcher rd=request.getRequestDispatcher("/MessageBook");
		 rd.forward(request, response);
		}
		
		
		
	}

}
