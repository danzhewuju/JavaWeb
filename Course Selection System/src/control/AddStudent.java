package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
	  response.setContentType("text/html;charset=UTF-8");
	  request.setCharacterEncoding("UTF-8");
	  String Scode,Sname,Sex,Stel,Sclass;
	  Scode=request.getParameter("Scode");
	  Sname=request.getParameter("Sname");
	  Sex=request.getParameter("Sex");
	  Stel=request.getParameter("Stel");
	  Sclass=request.getParameter("Sclass");
	  Dbsql db=new Dbsql();
	  db.setStudent(Scode, Sname, Sex, Stel, Sclass);
	  response.sendRedirect("AddStudents.jsp");
	
	  
	}

}
