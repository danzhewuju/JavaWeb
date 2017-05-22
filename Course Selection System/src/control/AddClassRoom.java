package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbsql.Dbsql;
import entity.ClassRoomList;

/**
 * Servlet implementation class AjaxAddClassRoom
 */
@WebServlet("/AddClassRoom")
public class AddClassRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/xml;charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		String Rname=request.getParameter("Rname");
//		Dbsql db=new Dbsql();
//		db.addClassRoom(Rname);
//		ClassRoom cr=db.getClassRoom(Rname);
//		ClassRoomList classroomlist=new ClassRoomList();
//		classroomlist.setRoomlist(db.getAllClassRoom());
//		request.getSession().setAttribute("classroomlist", classroomlist);
//		
//		PrintWriter out=response.getWriter();
//		String message=null;
//		if(cr!=null)
//		{
//			message="Success  ID :"+cr.getRno();
//		}
//		else
//		{
//			message="Wrong";
//		}
//		out.println("<response>");
//		out.println("<message>"+message+"</message>");
//		out.println("</response>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String Rname=request.getParameter("Rname");
		Dbsql db=new Dbsql();
		db.addClassRoom(Rname);
		
		ClassRoomList classroomlist=new ClassRoomList();
		classroomlist.setRoomlist(db.getAllClassRoom());
		request.getSession().setAttribute("classroomlist", classroomlist);
		response.sendRedirect("HandelClassRoom.jsp");
		
	}

}
