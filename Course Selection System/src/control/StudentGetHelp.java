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
import entity.Teacher;

/**
 * Servlet implementation class StudentGetHelp
 */
@WebServlet("/StudentGetHelp")
public class StudentGetHelp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGetHelp() {
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
		request.getSession().setAttribute("studentschedule", studentschedule);
		response.sendRedirect("StudentGetHelp.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message,CTname;
		message=request.getParameter("message");
		CTname=request.getParameter("CTname");
		String[] split=CTname.split(":");
		String Tname=split[1];
		
		Dbsql db=new Dbsql();
		Teacher teacher=db.getTeacher(Tname);
		Student student=(Student) request.getSession().getAttribute("student");
		boolean flag= db.setStudentMessage(message, teacher.getTno(),student.getSno());
	String result=null;
	if(flag)
	{
		result="success";
	}
	else
	{
		result="faild";
	}
		
	request.getSession().setAttribute("result", result);
	response.sendRedirect("StudentGetHelp.jsp");
	}

}
