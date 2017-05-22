package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auxi.OpCoursesList;
import auxi.Schedule;
import auxi.StudentSchedule;
import dbsql.Dbsql;
import entity.ClassRoomList;
import entity.CoursesList;
import entity.Student;

/**
 * Servlet implementation class Stu_CurriculaVariable
 */
@WebServlet("/Stu_CurriculaVariable")
public class Stu_CurriculaVariable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stu_CurriculaVariable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
		Dbsql db=new Dbsql();
		CoursesList courseslist=new CoursesList();
		courseslist.setCourselist(db.getAllCourses());
		request.getSession().setAttribute("courseslist", courseslist);
		
		ClassRoomList classroomlist=new ClassRoomList();
		classroomlist.setRoomlist(db.getAllClassRoom());
		request.getSession().setAttribute("classroomlist", classroomlist);
		
		Student student=(Student) request.getSession().getAttribute("student");
		
		StudentSchedule studentschedule=new  StudentSchedule(student.getSno());
		
		Schedule schedule=studentschedule.getSchedule();
		
		OpCoursesList opcourseslist=new OpCoursesList(schedule);
		 
		request.getSession().setAttribute("opcourseslist",opcourseslist );
		request.getSession().setAttribute("studentschedule",studentschedule );
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
