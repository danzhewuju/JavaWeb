package usst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageBook
 */
@WebServlet("/MessageBook")
public class MessageBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	boolean first;
    public MessageBook() {
        super();
        first=true;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html ;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
		String name = null;
		String gender=null;
		Cookie[]cookies=request.getCookies();
		if(cookies!=null)
		{
			for(int i=0;i<cookies.length;i++)
			{
				if(cookies[i].getName().equals("name"))
					name=cookies[i].getValue();
				if(cookies[i].getName().equals("gender"))
					gender=cookies[i].getValue();
			}
		  
		}
		out.println("<html><head><title>欢迎登录</title><meta charset=UTF-8>");
		out.println("</head><body>"
				+ "<form action=Login method=post>"

+"<table>"
		+ "<tr> <td width=5%>姓名:</td><td width=80%><input id=name type=text name=n1 value="+name+"> </td></tr>");
		if(gender.equals("男"))
		{
			out.println("<tr><td width=5%>性别:</td><td width=80%><input id=gender type=radio name=n2 checked=true value=男>男     <input type=radio name=n2 value=女>女</td></tr>");
		}
		else
		{
			out.println("<tr><td width=5%>性别:</td><td width=80%><input id=gender type=radio name=n2  value=男>男     <input type=radio name=n2 checked=true value=女>女</td></tr>");
		}
		out.println(
		
         "</table>"
		+ "<input type=checkbox name=n3 value=true>记住我的密码"
		+ "<p><input type=submit value=登录>"
+"<input type=reset value=取消>"
		+ "</form>"
		+ "</body>"
		 );
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html ;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        ArrayList<MessageWord> book=null;
        Visitor user=(Visitor) request.getSession().getAttribute("user");
        if(first)
        {
        	book=new ArrayList<MessageWord>();
        	first=false;
        }
        else{
        	book=(ArrayList<MessageWord>) getServletContext().getAttribute("book");
        }
        
		out.println("</html></head>");
		out.println("<title>欢迎来到留言簿</title></head>");
		out.println("<body>");
		if(book.size()==0)
		out.println("<p>当前的留言本为空，赶紧来留言吧！");
		else
		{
			out.println("<table border=3>");
			for(int i=0;i<book.size();i++)
			{
				
				out.println("<tr><td><p>"+book.get(i).getName()+"   "+book.get(i).getDate()
						+"<p>标 题:"+book.get(i).getTitle()+"<p>内容:"+book.get(i).getText()+"</td></tr>");
			}
			out.println("</table>");
		}
		out.println("<h4>总计"+book.size()+"条留言");
		
		out.println("<p><a href=WriteMessage><input type=button value=留言></a> <a href=login.html><input type=button value=返回登录></a>");
		out.println("</body></html>");
		
		
	}

}
