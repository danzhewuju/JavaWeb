package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.Teacher;

/**
 * Servlet implementation class DelTeacher
 */
@WebServlet("/DelTeacher")
public class DelTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		String E=request.getParameter("E");
		Dbsql db=new Dbsql();
		Teacher teacher=db.getTeacher(E);
		request.getSession().setAttribute("delteacher",teacher);
		if(teacher!=null)
		{
			response.sendRedirect("DelTeachers.jsp");	
		}
		else {
			request.getSession().setAttribute("message", "Teacher");
			response.sendRedirect("DelTeachersTitle.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		Teacher teacher=(Teacher) request.getSession().getAttribute("delteacher");
		Dbsql db=new Dbsql();
		db.delTeachertBySno(teacher.getTno());
		response.sendRedirect("DelTeachersTitle.jsp");
		
	}

}
