package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auxi.Teacherupdate;
import dbsql.Dbsql;

/**
 * Servlet implementation class TeacherUpdateScore
 */
@WebServlet("/TeacherUpdateScore")
public class TeacherUpdateScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdateScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Sno,Cno;
		int Grade;
		Sno=request.getParameter("Sno");
		Cno=request.getParameter("Cno");
		Grade=Integer.valueOf(request.getParameter("Grade"));
		Dbsql db=new Dbsql();
		db.updategrade(Sno, Cno, Grade);
	
		Teacherupdate teacherupdate=(Teacherupdate) request.getSession().getAttribute("teacherupdate");
		teacherupdate.check();
		request.getSession().setAttribute("teacherupdate", teacherupdate);
		response.sendRedirect("TeacherScoreReistration.jsp");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
