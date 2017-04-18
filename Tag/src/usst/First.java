package usst;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class First extends SimpleTagSupport {
 private String user;
 public void setUser(String user){
	 this.user=user;
 }
@Override
public void doTag() throws JspException, IOException {
	// TODO Auto-generated method stub
	JspWriter out=getJspContext().getOut();
	if(user==null){
		out.print("Welcome,Guest<br>");
	}else{
		out.print("Welcome"+user+"<br>");
	}
}
 
}
