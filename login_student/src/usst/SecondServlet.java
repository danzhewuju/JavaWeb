package usst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<Student> students=(ArrayList<Student>) request.getSession().getAttribute("students");
		PrintWriter out=response.getWriter();
		out.println("<html><head>");
		out.println("<tile></欢迎同学></head>");
		out.println("<body>");
	//	out.println("<p>该学生的学号："+s.getSno()+"<p>该学生的姓名:"+s.getSname());
		//out.println("<p><a href="+"http://localhost:8080/login_student/login.html"+">跳转页面请点击这</a>");
		out.println("<table border=1><caption>学生信息</caption>");
		out.println("<tr><td>学号</td><td>姓名</td><td>操作</td><td>操作</td></tr>");
	for(int i=0;i<students.size();i++){
		out.println("<tr><td>"+students.get(i).getSno()+"</td><td>"+students.get(i).getSname()+
				" </td><td><a href=EditServlet?sno="+i+">编辑</a></td> <td><a href=DeleteServlet?sno="+i+">删除</a> </td></tr>");
	}
		out.println("</table>");
		out.println("<p><a href=login.html><input type=button value=登记学生></a>");
	out.println("<p><h4>当前有学生人数:"+students.size());	
		out.println("</body></html>");
	}

}
