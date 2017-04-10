package usst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Message
 */
@WebServlet("/WriteMessage")
public class WriteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
  	int ID;
  	boolean first=true;
    public WriteMessage() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		response.setContentType("text/html ;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<Visitor> visitors=(ArrayList<Visitor>) request.getSession().getAttribute("visitors");
		Visitor v=(Visitor)request.getSession().getAttribute("user");
		String name=v.getName();
	
		for(int i=0;i<visitors.size();i++)
		{
			if(visitors.get(i).getName().equals(name))
				{ID=i;
				break;
				}
		}
		PrintWriter out=response.getWriter();
		out.println("<html><head>");
		out.println("欢迎"+name+"来到留言簿");
		out.println("<script></script>");
		out.println("</head><body>");
		out.println("<form action=WriteMessage method=post>");
		out.println("<p><input type=text name=title value=请输入你的标题>"
				+ "<p><textarea name=content   style=width:300px;height:300px>请输入你的内容</textarea>"
				+ "<p><input type=submit onclick=alert("+"提交成功"+") value=提交> &nbsp <input type=reset value=取消>  "
				+ "</form>");
		out.println("</body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.setContentType("text/html;UTF-8");
	response.setContentType("text/html ;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	ArrayList<Visitor> visitors=(ArrayList<Visitor>) request.getSession().getAttribute("visitors");
	ArrayList<MessageWord> book;
	if(first)
	{
		first=false;
		book=new ArrayList<MessageWord>();
	}
	else
	{
		book=(ArrayList<MessageWord>) getServletContext().getAttribute("book");
	}
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	MessageWord mw=new MessageWord();
	mw.setDate();
	mw.setGender(visitors.get(ID).getGender());
	mw.setName(visitors.get(ID).getName());
	mw.setTitle(title);
	mw.setText(content);
	book.add(mw);
	getServletContext().setAttribute("book", book); 
	RequestDispatcher rd=request.getRequestDispatcher("MessageBook");
	rd.forward(request, response);
	}
}
