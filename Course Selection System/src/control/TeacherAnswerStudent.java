package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.MessageList;
import entity.Teacher;

/**
 * Servlet implementation class TeacherAnswerStudent
 */
@WebServlet("/TeacherAnswerStudent")
public class TeacherAnswerStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAnswerStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
		Dbsql db=new Dbsql();
		MessageList messagelist=db.getAllMessageForTeacher(teacher.getTno());
		request.getSession().setAttribute("messagelist", messagelist);
		response.sendRedirect("TeacherAnswerStudent.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
