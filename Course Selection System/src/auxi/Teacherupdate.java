package auxi;

import java.util.ArrayList;

import dbsql.Dbsql;
import entity.Courses;
import entity.Student;

public class Teacherupdate {
	private ArrayList<StudentCourses> studentcourses;
	private int count;
	
	public Teacherupdate(String Tno){
		studentcourses=new ArrayList<>();
		count=0;
		Dbsql db=new Dbsql();
		ArrayList<String>Cno=db.getCnofromt_coursesByTno(Tno);
		for(int i=0;i<Cno.size();i++)
		{
			Courses courses=db.getCourses(Cno.get(i));
		ArrayList<String> Sno=db.getSnoFroms_coursesByCno(Cno.get(i));
			for(int j=0;j<Sno.size();j++)
			{
				Student student=db.getStudent(Sno.get(j));
				StudentCourses tc=new StudentCourses();
				tc.setCourses(courses);
				tc.setStudent(student);
				studentcourses.add(tc);
				count++;
			}
			
		}
		
		check();
		
		
		
	}
	public ArrayList<StudentCourses> getStudentcourses() {
		return studentcourses;
	}
	public void setStudentcourses(ArrayList<StudentCourses> studentcourses) {
		this.studentcourses = studentcourses;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void check(){
		  Dbsql db=new Dbsql();
		for(int i=0;i<studentcourses.size();i++)
		{
			String xSno,xCno;
			xCno=studentcourses.get(i).getCourses().getCno();
			xSno=studentcourses.get(i).getStudent().getSno();
			if(db.getgradeBySCno(xSno, xCno)!=-1)
			{
				studentcourses.remove(i);
				count--;
			}
		}
	}

}
