package auxi;

import java.util.ArrayList;

import dbsql.Dbsql;
import entity.ClassRoom;
import entity.Courses;
import entity.Teacher;

public class StudentSchedule {//学生的已选课程
	 private ArrayList<OpCourses>  studentschedule;
	 int count;
	  Schedule schedule;
	 
	 
	public StudentSchedule(String Sno){
		 studentschedule=new ArrayList<OpCourses>();
		 
		 count=0;
		 schedule=new Schedule();
		 Dbsql db=new Dbsql();
		 ArrayList<String> finishedChoose=db.getStudentSchedule(Sno);
		 if(finishedChoose.size()!=0)
		 {
			 for(int i=0;i<finishedChoose.size();i++){
				 schedule.setTimeCourse(db.getCourses(finishedChoose.get(i)).getCtime());
				 Courses courses=db.getCourses(finishedChoose.get(i));//未完待续
				 ClassRoom classroom=db.getClassRoom(courses.getRno());
				 Teacher teacher=db.getTeacher(db.getTnofromT_courseByCno(courses.getCno()));
				 OpCourses opcourses=new OpCourses();
				 opcourses.setCourses(courses);
				 opcourses.setTeacher(teacher);
				 opcourses.setClassroom(classroom);
				 studentschedule.add(opcourses);
				 count++;
				 
			 }
			 
		 }
	 }
	public ArrayList<OpCourses> getStudentschedule() {
		return studentschedule;
	}
	public void setStudentschedule(ArrayList<OpCourses> studentschedule) {
		this.studentschedule = studentschedule;
		count=studentschedule.size();
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void getStudentScheduleFromDb(String Sno){
		
	}
	public  void  AddCourses(String Cno,String Sno,String Tno){//通过Cno Sno 来进行加课
		Dbsql db=new Dbsql();
		OpCourses opcourses=new OpCourses();
		Courses courses=db.getCourses(Cno);
		ClassRoom classroom=db.getClassRoom(courses.getRno());
		Teacher teacher=db.getTeacher(Tno);
		
		opcourses.setCourses(courses);
		opcourses.setTeacher(teacher);
		opcourses.setClassroom(classroom);
		studentschedule.add(opcourses);
		
		schedule.setTimeCourse(courses.getCtime());//设置学生的时间表
		db.AddS_CoursesByStudent(Sno, Cno, classroom.getRno());//实现数据库的写回
		count++;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	
}
