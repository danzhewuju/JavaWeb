package usst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/AddItem")
@MultipartConfig(location="D:\\",fileSizeThreshold=1024)
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		Part p=request.getPart("image");
		//out.println(p.getHeader("content-disposition"));
		String[] ss=p.getHeader("content-disposition").split("image\\\\");
		//String s=name[1].replace("\"", "");
		String s=ss[1].substring(0, ss[1].indexOf("\""));
		s="image/"+s;
	//	out.println("<p>"+s);
		String name=request.getParameter("name");
		Float price= Float.valueOf(request.getParameter("price"));
		Goods good=new Goods();
		ArrayList<Goods> goods=(ArrayList<Goods>) getServletContext().getAttribute("goods");
		good.setName(name);
		good.setPrice(price);
		good.setImage(s);
		goods.add(good);
		getServletContext().setAttribute("goods", goods);
	RequestDispatcher rd=request.getRequestDispatcher("manager.jsp");
	rd.forward(request, response);
		
	}

}
