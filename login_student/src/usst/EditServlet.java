package usst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
     int n;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<Student> students=(ArrayList<Student>) request.getSession().getAttribute("students");
		n=Integer.valueOf(request.getParameter("sno")) ;
		PrintWriter out=response.getWriter();
		out.println("<html><head>");
		out.println("<tile>编辑学生个人信息</tile></head>");
		out.println("<body><form action=EditServlet method=post");
		out.println("<p>学号：<input type=text name=sno value="+students.get(n).getSno()+">");
		out.println("<p>姓名：<input type=text name=sname value="+students.get(n).getSname()+">");
		out.println("<p><input type=submit value=确认修改>");
		out.println("</form></body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String sno,sname;
		sno=request.getParameter("sno");
		sname=request.getParameter("sname");
		ArrayList<Student> students=(ArrayList<Student>) request.getSession().getAttribute("students");
		students.get(n).setSname(sname);
		students.get(n).setSno(sno);
		 RequestDispatcher rd=request.getRequestDispatcher("/SecondServlet");
		 rd.forward(request, response);
		
		
	}

}
