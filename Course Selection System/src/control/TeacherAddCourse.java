package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.CoursesList;
import entity.Teacher;

/**
 * Servlet implementation class TeacherAddCourse
 */
@WebServlet("/TeacherAddCourse")
public class TeacherAddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dbsql db=new Dbsql();
		Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
		CoursesList courseslist=new CoursesList();
		courseslist.setCourselist(db.getAllCourses());
		ArrayList<String> Cnolist=db.getCnofromt_coursesByTno(teacher.getTno());
		courseslist.check(Cnolist);
		request.getSession().setAttribute("courseslist", courseslist);
		response.sendRedirect("TeacherAddCourseMenu.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
