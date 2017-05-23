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
 * Servlet implementation class TeacherAnswerBackMsn
 */
@WebServlet("/TeacherAnswerBackMsn")
public class TeacherAnswerBackMsn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAnswerBackMsn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
		String Sno,Backmsn;
		int ID=Integer.valueOf(request.getParameter("ID"));
		Sno=request.getParameter("Sno");
		Backmsn=request.getParameter("Backmsn");
		Dbsql db=new Dbsql();
		db.addBackmsn(ID, Backmsn);
		db.EditFlagFromMessage(ID, 2);//修改数据库的状态
		MessageList messagelist=(MessageList) request.getSession().getAttribute("messagelist");
		messagelist.removemessage(Sno, teacher.getTno());
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
