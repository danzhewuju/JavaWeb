package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.EvaluationList;
import entity.Teacher;

/**
 * Servlet implementation class TeacherCheckComment
 */
@WebServlet("/TeacherCheckComment")
public class TeacherCheckComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherCheckComment() {
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
		EvaluationList evaluationList=db.getAllEvaluationByTno(teacher.getTno());
		request.getSession().setAttribute("evaluationList", evaluationList);
		response.sendRedirect("TeacherCheckComment.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
