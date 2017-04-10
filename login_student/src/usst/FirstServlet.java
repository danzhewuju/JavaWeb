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
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	int flag;
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    	flag=0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<Student> students = null;
		String sno=request.getParameter("sno");
		String sname=request.getParameter("sname");
		Student s=new Student();
		s.setSno(sno);
		s.setSname(sname);
		if(flag==0) 
		{
		students=new ArrayList<Student>();
			flag=1;
		}
		else{
		 students=(ArrayList<Student>) request.getSession().getAttribute("students");
		}
		students.add(s);
		request.getSession().setAttribute("students", students);
		RequestDispatcher rd=request.getRequestDispatcher("/SecondServlet");
		rd.forward(request, response);
		
	}

}
