package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;

/**
 * Servlet implementation class AjaxUsername
 */
@WebServlet("/AjaxUsername")
public class AjaxUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxUsername() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		String ID=request.getParameter("ID");
		Dbsql db=new Dbsql();
		boolean flag=db.IsManagerExist(ID);
		boolean flag1=db.isStudentExist(ID);
		boolean flag2=db.isTeacherExist(ID);
		String message;
		if(flag||flag1||flag2)
			 message="用户存在！";
		else message="用户不存在";
		PrintWriter out=response.getWriter();
		out.println("<response>");
		out.println("<message>"+message+"</message>");
		out.println("</response>");
	   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
