package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auxi.StudentSchedule;
import entity.Student;

/**
 * Servlet implementation class StudentEvaluation
 */
@WebServlet("/StudentEvaluation")
public class StudentEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	int  first;
    public StudentEvaluation() {
        super();
        first=0;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		Student student=(Student) request.getSession().getAttribute("student");
		StudentSchedule studentschedule=new  StudentSchedule(student.getSno());
		int[] key=new int[100];
		for(int i=0;i<studentschedule.getCount();i++)
		{
			key[i]=1;
		}
		request.getSession().setAttribute("key", key);
		studentschedule.Check();
		request.getSession().setAttribute("studentschedule", studentschedule);
		request.getSession().setAttribute("first", first);
		response.sendRedirect("StudentEvaluation.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
