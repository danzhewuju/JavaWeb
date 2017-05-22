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
 * Servlet implementation class EditTeacher
 */
@WebServlet("/EditTeacher")
public class EditTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeacher() {
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
		request.getSession().setAttribute("editteacher", teacher);
		if(teacher!=null)
		{
			response.sendRedirect("EditTeacher.jsp");	
		}
		else {
			request.getSession().setAttribute("message", "Teacher");
			response.sendRedirect("EditTeachersTitle.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("Utf-8");
		Teacher teacher=(Teacher) request.getSession().getAttribute("editteacher");
		String ID,Tcode,Tname,Tsex,Ttel;
		ID=teacher.getTno();
		Tcode=request.getParameter("code");
		Tname=request.getParameter("name");
		Tsex=request.getParameter("sex");
		Ttel=request.getParameter("tel");
		Dbsql db=new Dbsql();
		db.EditTeacherByTno(ID, Tcode, Tname, Tsex, Ttel);
		response.sendRedirect("EditTeachersTitle.jsp");
		
	}

}
