package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.Student;

/**
 * Servlet implementation class DelStudent
 */
@WebServlet("/DelStudent")
public class DelStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelStudent() {
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
		Student stu=db.getStudent(E);
		request.getSession().setAttribute("delstudent", stu);
		if(stu!=null)
		{
			response.sendRedirect("DelStudents.jsp");	
		}
		else {
			request.getSession().setAttribute("message", "Student");
			response.sendRedirect("DelStudentsTitle.jsp");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Student stu=(Student) request.getSession().getAttribute("delstudent");
	Dbsql db=new Dbsql();
	db.delStudentBySno(stu.getSno());
	response.sendRedirect("DelStudentsTitle.jsp");
	}

}
