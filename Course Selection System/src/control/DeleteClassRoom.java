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
 * Servlet implementation class DeleteClassRoom
 */
@WebServlet("/DeleteClassRoom")
public class DeleteClassRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClassRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String Rno=request.getParameter("Rno");
		Dbsql db=new Dbsql();
		db.delClassRoom(Rno);
		ClassRoomList classroomlist=(ClassRoomList) request.getSession().getAttribute("classroomlist");
		classroomlist.removeClassRoom(Rno);
		request.getSession().setAttribute("classroomlist", classroomlist);
		response.sendRedirect("HandelClassRoom.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
