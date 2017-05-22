package dbsql;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import entity.*;



public class Dbsql {
 private static DataSource datasource;
private static Context context;
private  Connection con=null;
 public Dbsql(){
	 
	 try {
		context=new InitialContext();
		datasource=(DataSource) context.lookup("java:/comp/env/jdbc/sampleDS");
		
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 public Connection getcon(){//获得链接
	
	try {
		
	con=datasource.getConnection();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("获取链接异常！");
	}
	return con;
 }
 public boolean setManager(String name,String password){//设置管理员

	 boolean flag=false;
	   con=getcon();
	 String sql="insert into managers(Mname,Mcode) values(?,?)";
	 try {
	PreparedStatement pstm= con.prepareStatement(sql);
	pstm.setString(1, name);
	pstm.setString(2, password);
	pstm.executeUpdate();
	con.close();
	return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
		 return flag;
	}
	 	
 }
 
 public Manager getManager(String name)//返回管理员对象
 {
	  con=getcon();
	 Manager manager=null;
	 String sql="select * from  managers where Mname=?";
	 PreparedStatement pstm;
	try {
     
		 pstm= con.prepareStatement(sql);
		    pstm.setString(1, name);
		 ResultSet rs=pstm.executeQuery();
		  manager=new Manager();
		  while(rs.next())
		  {
			     manager.setMno(rs.getString("Mno"));
				 manager.setMcode(rs.getString("Mcode"));
				 manager.setMname(rs.getString("Mname"));
				 manager.setMlimits(rs.getString("Mlimits"));
		  } 
		  con.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("预处理异常");
	}
	 return manager;
 }
 public boolean IsManagerExist(String ID)//判断管理员是否存在
 {   
 con=getcon();
 boolean flag=false;
 String sql="select * from managers where Mno="+ID;
 PreparedStatement pstm;
 try {
	 pstm=con.prepareStatement(sql);
	ResultSet rs=pstm.executeQuery();
	if(rs.next())
	{
		flag=true;
	}
	else
		flag= false;
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	 return flag;
 }
 
 public String getManagerCode(String Sno){//通过账号获得管理员的密码
	 
	 String Code=null;
	  con=getcon();
	 String sql="select * from managers where Mno="+Sno;
	 PreparedStatement pstm;
	 try {
		pstm=con.prepareStatement(sql);
		 ResultSet rs=pstm.executeQuery();
		 rs.next();
		 Code=rs.getString(2);
		 
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Code;
 }
 
 
 
 public Manager getManagerById(String ID)//返回管理员对象
 {
	   con=getcon();
	 Manager manager=null;
	 String sql="select * from  managers where Mname=?";
	 PreparedStatement pstm;
	try {
     
		 pstm= con.prepareStatement(sql);
		    pstm.setString(1, ID);
		 ResultSet rs=pstm.executeQuery();
		  manager=new Manager();
		  while(rs.next())
		  {
			     manager.setMno(rs.getString("Mno"));
				 manager.setMcode(rs.getString("Mcode"));
				 manager.setMname(rs.getString("Mname"));
				 manager.setMlimits(rs.getString("Mlimits"));
		  } 
		  con.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("预处理异常");
	}
	 return manager;
 }
 
 
 public boolean setStudent(String password,String Sname,String Sex,String Stel,String Sclass){//增加学生

	 boolean flag=false;
	  con=getcon();
	 String sql="insert into students(Scode,Sname,Sex,Stel,Sclass) values(?,?,?,?,?)";
	 try {
	PreparedStatement pstm= con.prepareStatement(sql);
	pstm.setString(1, password);
	pstm.setString(2, Sname);
	pstm.setString(3, Sex);
	pstm.setString(4, Stel);
	pstm.setString(5, Sclass);
	pstm.executeUpdate();
	
	flag=true;
	con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		flag=false;
		System.out.println("学生数据插入异常");
	}
	 return flag;	
 }
 
 public  Student getStudent(String E)//通过姓名或者学号查找并返回student
 {
	 con=getcon();
	 Student stu=null;
	 String sql1="select * from  students where Sno=?";
	 String sql="select * from  students where Sname=?";
	 PreparedStatement pstm;
	try {
  
		 pstm= con.prepareStatement(sql);
		    pstm.setString(1, E);
		 ResultSet rs=pstm.executeQuery();
	
	if(rs.next())
	{
	
		stu=new Student();
		stu.setSno(rs.getString(1));
		stu.setScode(rs.getString(2));
		stu.setSname(rs.getString(3));
		stu.setSex(rs.getString(4));
		stu.setStel(rs.getString(5));
		stu.setSclass(rs.getString(6));
	}
	else{
		pstm= con.prepareStatement(sql1);
		  pstm.setString(1, E);
		   rs=pstm.executeQuery();
		   if(rs.next())
		   {
			  
			   stu=new Student();
				stu.setSno(rs.getString(1));
				stu.setScode(rs.getString(2));
				stu.setSname(rs.getString(3));
				stu.setSex(rs.getString(4));
				stu.setStel(rs.getString(5));
				stu.setSclass(rs.getString(6)); 
			}
		 
	}
		 
	con.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("预处理异常");
	}
	 return stu;
 }
 
 public boolean delStudentBySno(String Sno){//删除学生信息
	 boolean flag=false;
	  con=getcon();
	 String sql="delete from students where Sno=?";
	 
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		 ps.setString(1, Sno);
		 flag=ps.execute();
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 return flag;
	 
 }
 
 public boolean EditStudentBySno(String Sno,String password,String Sname,String Sex,String Stel,String Sclass ){//编辑学生的相关信息
	 boolean flag = false;
	  con=getcon();
	 String sql="update students set Scode=?,Sname=?,Sex=?,Stel=?,Sclass=? where Sno=?";
	 PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		pstm.setString(1, password);
		pstm.setString(2, Sname);
		pstm.setString(3, Sex);
		pstm.setString(4, Stel);
		pstm.setString(5, Sclass);
		pstm.setString(6,Sno );
		int count=pstm.executeUpdate();
		if(count==1)
			flag=true;
		else
			flag=false;
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return flag;
 }
 
 public boolean addTeacher(String password,String Tname,String Tsex,String Ttel){//增加老师

	 boolean flag=false;
	 con=getcon();
	 String sql="insert into teachers(Tcode,Tname,Tsex,Ttel) values(?,?,?,?)";
	 try {
	PreparedStatement pstm= con.prepareStatement(sql);
	pstm.setString(1, password);
	pstm.setString(2, Tname);
	pstm.setString(3, Tsex);
	pstm.setString(4, Ttel);

	pstm.executeUpdate();
	
	flag=true;
	con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		flag=false;
		System.out.println("老师数据插入异常");
		
	}
	 return flag;	
 }
 
 public boolean addT_courses(String Tno,String Cno){
	 boolean flag=false;
	 String sql="insert into t_courses values(?,?)";
	 con=getcon();
	 try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, Tno);
		pstm.setString(2, Cno);
		flag=pstm.execute();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return flag;
 }
 
 public Teacher getTeacher(String E)//通过姓名或者学号查找并返回Teacher
 {
	  con=getcon();
	 Teacher teacher=null;
	 String sql1="select * from  teachers where Tno=?";
	 String sql="select * from  teachers where Tname=?";
	 PreparedStatement pstm;
	try {
  
		 pstm= con.prepareStatement(sql);
		    pstm.setString(1, E);
		 ResultSet rs=pstm.executeQuery();
	
	if(rs.next())
	{
	
		teacher=new Teacher();
		teacher.setTno(rs.getString(1));
		teacher.setTcode(rs.getString(2));
		teacher.setTname(rs.getString(3));
		teacher.setTsex(rs.getString(4));
		teacher.setTtel(rs.getString(5));
		
	}
	else{
		pstm= con.prepareStatement(sql1);
		  pstm.setString(1, E);
		   rs=pstm.executeQuery();
		   if(rs.next())
		   {
			  
			   teacher=new Teacher();
				teacher.setTno(rs.getString(1));
				teacher.setTcode(rs.getString(2));
				teacher.setTname(rs.getString(3));
				teacher.setTsex(rs.getString(4));
				teacher.setTtel(rs.getString(5));
			}
		 
	}
		 
	con.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("老师预处理异常");
	}
	 return teacher;
 }
 
 
 public boolean EditTeacherByTno(String ID,String password,String name,String Sex,String tel ){//编辑老师的相关信息
	 boolean flag = false;
	  con=getcon();
	 String sql="update teachers set Tcode=?,Tname=?,Tsex=?,Ttel=? where Tno=?";
	 PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		pstm.setString(1, password);
		pstm.setString(2, name);
		pstm.setString(3, Sex);
		pstm.setString(4, tel);

		pstm.setString(5,ID );
		int count=pstm.executeUpdate();
		if(count==1)
			flag=true;
		else
			flag=false;
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return flag;
 }
 
 
 public boolean delTeachertBySno(String ID){//删除老师信息
	 boolean flag=false;
	   con=getcon();
	 String sql="delete from teachers where Tno=?";
	 
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		 ps.setString(1, ID);
		 flag=ps.execute();
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 return flag;
	 
 }
 
 public boolean addClassRoom(String name){//增加教室

	 boolean flag=false;
	  con=getcon();
	 String sql="insert into classrooms(Rname) values(?)";
	 try {
	PreparedStatement pstm= con.prepareStatement(sql);
	pstm.setString(1, name);
	pstm.executeUpdate();
	flag=true;
	con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		flag=false;
		System.out.println("老师数据插入异常");
		
	}
	 return flag;	
 }
 
 public boolean delClassRoom(String ID){//删除教室
	 boolean flag=false;
	  con=getcon();
	 String sql="delete from classrooms where Rno=?";
	 
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		 ps.setString(1, ID);
		 flag=ps.execute();
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 return flag;
	 
 }
 
 public boolean EditClassRoom(String Rno,String Rname){//编辑教室的相关信息
	 boolean flag = false;
	  con=getcon();
	 String sql="update classrooms set Rname=? where Rno=?";
	 PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		pstm.setString(1, Rname);
		pstm.setString(2, Rno);
	
		int count=pstm.executeUpdate();
		if(count==1)
			flag=true;
		else
			flag=false;
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return flag;
 }
 
 
 public ArrayList<ClassRoom> getAllClassRoom(){//获得所有教室的列表
	 ArrayList<ClassRoom> Rlist=new ArrayList<ClassRoom>();
	  con=getcon();
	 String sql="select * from classrooms";
	 PreparedStatement pstm;  
	 
	 try {
		pstm=con.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			ClassRoom cr=new ClassRoom();
			cr.setRno(rs.getString(1));
			cr.setRname(rs.getString(2));
			Rlist.add(cr);
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return Rlist;
 }
 
 public ClassRoom getClassRoom(String E)//通过教室名称查找并返回ClassRoom
 {
	 con=getcon();
	 ClassRoom cr=null;
	 String sql1="select * from  classrooms where Rno=?";
	 String sql="select * from   classrooms where Rname=?";
	 PreparedStatement pstm;
	try {
  
		 pstm= con.prepareStatement(sql);
		    pstm.setString(1, E);
		 ResultSet rs=pstm.executeQuery();
	
	if(rs.next())
	{
	
		cr=new ClassRoom();
		cr.setRno(rs.getString(1));
		cr.setRname(rs.getString(2));
		
	}
	else{
		pstm= con.prepareStatement(sql1);
		  pstm.setString(1, E);
		   rs=pstm.executeQuery();
		   if(rs.next())
		   {
			   cr=new ClassRoom();
				cr.setRno(rs.getString(1));
				cr.setRname(rs.getString(2));
				
			}
		 
	}
		 
	con.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("老师预处理异常");
	}
	 return cr;
 }
 
 
 
 
 public boolean addCourses(String Cname,String Ctime,String Rno){//增加课程

	 boolean flag=false;
	  con=getcon();
	 String sql="insert into courses(Cname,Ctime,Rno) values(?,?,?)";
	 try {
	PreparedStatement pstm= con.prepareStatement(sql);
	
	pstm.setString(1, Cname);
	pstm.setString(2, Ctime);
	pstm.setString(3, Rno);

	pstm.executeUpdate();
	
	flag=true;
	con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		flag=false;
		System.out.println("课程数据和插入异常");
		
	}
	 return flag;	
 }
 
 public boolean delCourse(String ID){//删除课程
	 boolean flag=false;
	   con=getcon();
	 String sql="delete from courses where Cno=?";
	 
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement(sql);
		 ps.setString(1, ID);
		 flag=ps.execute();
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 return flag;
	 
 }
 
 public boolean EditCourses(String Cno,String Cname,String Ctime,String Rno){//编辑课程的相关信息
	 boolean flag = false;
	   con=getcon();
	 String sql="update courses set Cname=?,Ctime=?,Rno=? where Cno=?";
	 PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
	pstm.setString(1, Cname);
	pstm.setString(2, Ctime);
	pstm.setString(3, Rno);
    pstm.setString(4,Cno);
		int count=pstm.executeUpdate();
		if(count==1)
			flag=true;
		else
			flag=false;
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return flag;
 }
 
 public ArrayList<Courses> getAllCourses(){//获得所有课程的列表
	 ArrayList<Courses> courselist=new ArrayList<Courses>();
	   con=getcon();
	 String sql="select * from courses";
	 PreparedStatement pstm;  
	 
	 try {
		pstm=con.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Courses courses=new Courses();
			courses.setCno(rs.getString(1));
			courses.setCname(rs.getString(2));
			courses.setCtime(rs.getString(3));
			courses.setRno(rs.getString(4));
			courses.setCmax(rs.getString(5));
			courselist.add(courses);
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 return courselist;
 }
 
 public ArrayList<Teacher> getAllTeacher(){//获得所有课程的列表
	 ArrayList<Teacher> teacherlist=new ArrayList<Teacher>();
	   con=getcon();
	 String sql="select * from teachers";
	 PreparedStatement pstm;  
	 
	 try {
		pstm=con.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			Teacher teacher=new Teacher();
			teacher.setTno(rs.getString(1));
			teacher.setTcode(rs.getString(2));
			teacher.setTname(rs.getString(3));
			teacher.setTsex(rs.getString(4));
			teacher.setTtel(rs.getString(5));
			teacherlist.add(teacher);
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 return teacherlist;
 }
 public  Courses  getCourses(String E)//通过编号或者名称来查找课程
 {
	   con=getcon();
	Courses courses=null;
	 String sql1="select * from  courses where Cno=?";
	 String sql="select * from   courses where Cname=?";
	 PreparedStatement pstm;
	try {
  
		 pstm= con.prepareStatement(sql);
		    pstm.setString(1, E);
		 ResultSet rs=pstm.executeQuery();
	
	if(rs.next())
	{
	
		courses=new Courses();
		courses.setCno(rs.getString(1));
		courses.setCname(rs.getString(2));
		courses.setCtime(rs.getString(3));
		courses.setRno(rs.getString(4));
		courses.setCmax(rs.getString(5));
		
		
	}
	else{
		pstm= con.prepareStatement(sql1);
		  pstm.setString(1, E);
		   rs=pstm.executeQuery();
		   if(rs.next())
		   {
			   courses=new Courses();
				courses.setCno(rs.getString(1));
				courses.setCname(rs.getString(2));
				courses.setCtime(rs.getString(3));
				courses.setRno(rs.getString(4));
				courses.setCmax(rs.getString(5));
				
			}
		 
	}
		 
	con.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("课程查询预处理异常");
	}
	 return courses;
 }
 
 
 public boolean isStudentExist(String Sno){//判断学生是否存在
	 boolean flag;
	 Student student=getStudent(Sno);
	 if(student!=null)
	 {
		 flag=true;
	 }
	 else
		 flag=false;
	 return flag;
 }
 
 public boolean isTeacherExist(String Tno)
 {
	 boolean flag;
	 Teacher teacher=getTeacher(Tno);
			 if(teacher!=null)
				 flag=true;
			 else flag=false;
	 return flag;
 }
 
 public  ArrayList<String> getT_Courses(){//以特点的格式返回可选课程信息
	 ArrayList<String> opco_info=new ArrayList<String>();
	 String copy="";
	  con=getcon();
	 String sql="select * from t_courses";
	 PreparedStatement pstm;
	 try {
		pstm= con.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		
		while(rs.next())
		{
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
			{
				if(i==rs.getMetaData().getColumnCount())
				{
					copy+=rs.getString(i);
				}
				else copy+=rs.getString(i)+",";
				
			}
			opco_info.add(copy);
			copy="";
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return opco_info;
 }
 public String getTnofromT_courseByCno(String Cno){//获得所教课程的老师
	 con=getcon();
	 String sql="select Tno from t_courses";
	 String Tno=null;
	 try {
		PreparedStatement pstm=con.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		if(rs.next())
		{
			Tno=rs.getString(1);
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return Tno;
 }
 public ArrayList<String> getCnofromt_coursesByTno(String Tno)
 {
	 con=getcon();
	 ArrayList<String> Cno=new ArrayList<>();
	 String sql="select * from t_courses where Tno=?";
	 try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, Tno);
		ResultSet rs=pstm.executeQuery();
		
		
		while(rs.next())
		{
			Cno.add(rs.getString(2));
		}
		con.close();
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return Cno;
 }
 public ArrayList<String> getSnoFroms_coursesByCno(String Cno){
	 con=getcon();
	 ArrayList<String> Sno=new ArrayList<>();
	 String sql="select Sno from s_courses where Cno=?";
	 try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, Cno);
		ResultSet rs=pstm.executeQuery();

		while(rs.next())
		{
			Sno.add(rs.getString(1));
			
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return Sno;
 }
 
 public boolean updategrade(String Sno,String Cno,int Grade)
 {
	 con=getcon();
	 String sql="update s_courses set Cgrade=? where Sno=? and Cno=?";
	 boolean flag=false;
	 try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(2, Sno);
		pstm.setString(3, Cno);
		pstm.setInt(1, Grade);
		
	int n=pstm.executeUpdate();
	if(n!=0)
	{
		flag=true;
	}
	else
	{
		flag=false;
	}
	con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return flag;
 }
 public boolean SubMax(String Cno)//最大课余量-1
 {
	 boolean flag=false;
	  con=getcon();
	 String sql="update courses set Cmax=Cmax-1 where Cno=?";
	 try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, Cno);
		flag=pstm.execute();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return flag;
 }
 
 public boolean AddS_CoursesByStudent(String Sno,String Cno ,String Rno){//将学生的选课信息写回
	 boolean flag=false;
	 String sql="insert into s_courses(Sno,Cno,Rno) values(?,?,?)";
	 con=getcon();
	 PreparedStatement pstm;
	 try {
		pstm=con.prepareStatement(sql);
		pstm.setString(1,Sno);
		pstm.setString(2, Cno);
		pstm.setString(3, Rno);
		flag=pstm.execute();
		SubMax(Cno);
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 return flag;
 }
 
 
 public ArrayList<String>getStudentSchedule(String Sno){//从数据库中获取学生已选课程的Cno
	 ArrayList<String > map=new ArrayList<>();
	 String sql="select * from s_courses where Sno=?";
	 con=getcon();
	 PreparedStatement pstm;
	 try {
		pstm=con.prepareStatement(sql);
		pstm.setString(1, Sno);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			map.add(rs.getString(2));
		}
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 return map;
	 
 }
 
 public int getgradeBySCno(String Sno,String Cno){//获得该学生的该课程成绩
	 int grade=-1;
	 con=getcon();
	 String sql="select Cgrade from s_courses where Sno=? and Cno=?";
	PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		pstm.setString(1, Sno);
		pstm.setString(2, Cno);
		 ResultSet rs=pstm.executeQuery();
		 if(rs.next())
		 {
			 grade=rs.getInt(1);
		 }
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 return grade;
	 
 }
 
 public boolean setStudentMessage(String message,String Tno,String Sno){
	boolean flag=false;
	 con=getcon();
	 String sql="insert into  message(Sno,Tno,Msn) values(?,?,?)";
	 try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, Sno);
		pstm.setString(2, Tno);
		pstm.setString(3,message);
		flag=pstm.execute();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return flag;
 }
 

 public boolean addEvaluation(String Sno,String Tno,String Cno,String Eva,int Score)
 {
	 boolean flag=false;
	 con=getcon();
	 String sql="insert into evaluation values(?,?,?,?,?)";
	 try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1,Sno );
		pstm.setString(2,Tno );
		pstm.setString(3,Cno );
		pstm.setString(4,Eva );
		pstm.setInt(5, Score);
		flag=pstm.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return flag;
	 
 }
}

