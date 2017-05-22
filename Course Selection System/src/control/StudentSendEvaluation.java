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
 * Servlet implementation class StudentSendEvaluation
 */
@WebServlet("/StudentSendEvaluation")
public class StudentSendEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSendEvaluation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String Cno,Eva,Tno,Sno;
	int Score,i;
	i=Integer.valueOf(request.getParameter("Indox"));
	Cno=request.getParameter("Cno");
	Eva=request.getParameter("Eva");
    Score= Integer.valueOf(request.getParameter("Score"));
    Tno=request.getParameter("Tno");
    Student student=(Student) request.getSession().getAttribute("student");
    Sno=student.getSno();
    
    
    int[]key=(int[]) request.getSession().getAttribute("key");
    key[i]=0;
    request.getSession().setAttribute("key", key);
    Dbsql db=new Dbsql();
    db.addEvaluation(Sno, Tno, Cno, Eva, Score);
    response.sendRedirect("StudentEvaluation.jsp");

    
    
    
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
