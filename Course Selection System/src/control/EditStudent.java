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
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
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
		request.getSession().setAttribute("editstudent", stu);
		if(stu!=null)
		{
			response.sendRedirect("EditStudents.jsp");	
		}
		else {
			request.getSession().setAttribute("message", "Student");
			response.sendRedirect("EditStudentsTitle.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		Student stu=(Student) request.getSession().getAttribute("editstudent");
		Dbsql db=new Dbsql();
	String Scode,Sname,Sex,Stel,Sclass;
	Scode=request.getParameter("Scode");
	Sname=request.getParameter("Sname");
	Sex=request.getParameter("Sex");
	Stel=request.getParameter("Stel");
	Sclass=request.getParameter("Sclass");
	db.EditStudentBySno(stu.getSno(), Scode, Sname, Sex, Stel, Sclass);	
	response.sendRedirect("EditStudentsTitle.jsp");
	
	}

}
