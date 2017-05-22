package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.*;

/**
 * Servlet implementation class StartCourses
 */
@WebServlet("/StartCourses")
public class StartCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		Dbsql db=new Dbsql();
		CoursesList courseslist=new CoursesList();
		courseslist.setCourselist(db.getAllCourses());
		request.getSession().setAttribute("courseslist", courseslist);
		ClassRoomList classroomlist=new ClassRoomList();
		classroomlist.setRoomlist(db.getAllClassRoom());
		request.getSession().setAttribute("classroomlist", classroomlist);
		TeacherList teacherlist =new TeacherList();
		teacherlist.setTeacherlist(db.getAllTeacher());
		request.getSession().setAttribute("teacherlist", teacherlist);
		
		response.sendRedirect("HandelCourses.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
