package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.ClassRoomList;
import entity.CoursesList;

/**
 * Servlet implementation class EditCourse
 */
@WebServlet("/EditCourse")
public class EditCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	String Cname,Rno,Ctime,Cno;
	String Rname;
	Cname=request.getParameter("Cname");
	Ctime=request.getParameter("Ctime");
	Rname=request.getParameter("Rname");
	Cno=request.getParameter("Cno");
	ClassRoomList classroomlist=(ClassRoomList) request.getSession().getAttribute("classroomlist");
	Rno=classroomlist.getRnoByRname(Rname);
	Dbsql db=new Dbsql();
	db.EditCourses(Cno, Cname, Ctime, Rno);
	
	CoursesList courseslist=(CoursesList) request.getSession().getAttribute("courseslist");
	courseslist.editCourseeByCno(Cno, Cname, Ctime, Rno);
    request.getSession().setAttribute("courseslist", courseslist);
    response.sendRedirect("HandelCourses.jsp");
	
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
