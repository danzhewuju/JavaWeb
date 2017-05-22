package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auxi.StudentSchedule;
import dbsql.Dbsql;
import entity.Student;

/**
 * Servlet implementation class StudentScoreinqure
 */
@WebServlet("/StudentScoreinquiry")
public class StudentScoreinquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScoreinquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      
		Student student=(Student) request.getSession().getAttribute("student");
		StudentSchedule studentschedule=new  StudentSchedule(student.getSno());
		Dbsql db=new Dbsql();
	
		for(int i=0;i<studentschedule.getCount();i++)
		{
			String Sno,Cno;
			Sno=student.getSno();
			int grade;
			Cno=studentschedule.getStudentschedule().get(i).getCourses().getCno();
			grade=db.getgradeBySCno(Sno, Cno);
			
			studentschedule.getStudentschedule().get(i).setGrade(grade);
			
		}
		request.getSession().setAttribute("studentschedule", studentschedule);
		response.sendRedirect("StudentScoreinquiry.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
