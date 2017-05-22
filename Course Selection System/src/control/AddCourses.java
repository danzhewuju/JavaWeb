package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.ClassRoomList;
import entity.Courses;
import entity.CoursesList;
import entity.TeacherList;

/**
 * Servlet implementation class AddCourses
 */
@WebServlet("/AddCourses")
public class AddCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    //request.setCharacterEncoding("Utf-8");
		String Cname,Ctime,Rno=null;
		ClassRoomList classroomlist=(ClassRoomList) request.getSession().getAttribute("classroomlist");
		Cname=request.getParameter("Cname");
		Ctime=request.getParameter("Ctime");
		String roomname=request.getParameter("Rno");
		String Tname=request.getParameter("Tno");
		for(int i=0;i<classroomlist.getCount();i++)
		{
			if(classroomlist.getRoomlist().get(i).getRname().equals(roomname))
			{
				Rno=classroomlist.getRoomlist().get(i).getRno();
				break;
			}
		}
		Dbsql db=new Dbsql();
		db.addCourses(Cname, Ctime, Rno);
	
		CoursesList courseslist=(CoursesList) request.getSession().getAttribute("courseslist");
		Courses courses=db.getCourses(Cname);
		if(courses!=null)
		{
			courseslist.addCourse(courses);
			request.getSession().setAttribute("courseslist", courseslist);
			TeacherList teacherlist=new TeacherList();
			teacherlist.setTeacherlist(db.getAllTeacher());
			for(int i=0;i<teacherlist.getCount();i++)
			{
				if(Tname.equals(teacherlist.getTeacherlist().get(i).getTname()))
				{
					db.addT_courses(teacherlist.getTeacherlist().get(i).getTno(), courses.getCno());
				}
			}
			
		}
		response.sendRedirect("HandelCourses.jsp");
		
		
	}

}
