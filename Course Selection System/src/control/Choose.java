package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dbsql.Dbsql;
import entity.Manager;
import entity.MessageList;
import entity.Student;
import entity.Teacher;

/**
 * Servlet implementation class KeyManager
 */
@WebServlet("/Choose")
public class Choose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Choose() {
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
		
		
		
		
		String ID,Code;
		ID=request.getParameter("ID");
		Code=request.getParameter("password");
		Dbsql db=new Dbsql();
		String radio;
		radio=request.getParameter("radio");
		switch(radio)
		{
		case "1":
		{
			Student student=db.getStudent(ID);
			if(student!=null){
				String sample_code=student.getScode();
				if(sample_code.equals(Code))
				{
					request.getSession().setAttribute("student", student);
					MessageList messagelist=db.getAllMessageForStudent(student.getSno());
					request.getSession().setAttribute("messagelist", messagelist);
					response.sendRedirect("Stu_StudentMenu.jsp");
				}
				else
				{
					response.sendRedirect("Login.html");
				}
			}
		}
		break;
		case "2":
			{
				Teacher teacher=db.getTeacher(ID);
				if(teacher!=null)
				{
					String sample_code=teacher.getTcode();
					if(sample_code.equals(Code))
					{
						request.getSession().setAttribute("teacher", teacher);
						MessageList messagelist=db.getAllMessageForTeacher(teacher.getTno());
						request.getSession().setAttribute("messagelist", messagelist);
						response.sendRedirect("TeacherMenu.jsp");
					}
					else
					{
						response.sendRedirect("Login.html");
					}
				}
			}break;
		case "3":{
			String sample_code=db.getManagerCode(ID);
			
			if(Code.equals(sample_code))
			{
				Manager manager=db.getManagerById(ID);
				request.getSession().setAttribute("manager", manager);
				response.sendRedirect("ManagerMenu.jsp");
			}
			else{
				response.sendRedirect("Login.html");
			}
			
		}break;
		}
		
		
		
		
	}

}
