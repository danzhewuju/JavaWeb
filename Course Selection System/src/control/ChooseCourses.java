package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auxi.OpCoursesList;
import auxi.StudentSchedule;
import dbsql.Dbsql;
import entity.Courses;

/**
 * Servlet implementation class ChooseCourses
 */
@WebServlet("/ChooseCourses")
public class ChooseCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Sno,Cno,Tno;
		Sno=request.getParameter("Sno");
		Cno=request.getParameter("Cno");

		Tno=request.getParameter("Tno");
		Dbsql db=new Dbsql();
		Courses courses=db.getCourses(Cno);
		OpCoursesList opcourseslist=(OpCoursesList) request.getSession().getAttribute("opcourseslist");
		StudentSchedule studentschedule=(StudentSchedule) request.getSession().getAttribute("studentschedule");
	     studentschedule.AddCourses(Cno, Sno, Tno);
	     opcourseslist.updateSchedule(courses);
	     
	     request.getSession().setAttribute("opcourseslist", opcourseslist);
	     request.getSession().setAttribute("studentschedule", studentschedule);
		response.sendRedirect("Stu_CurriculaVariable.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
