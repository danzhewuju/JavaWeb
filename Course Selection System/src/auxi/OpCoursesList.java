package auxi;

import java.util.ArrayList;

import dbsql.Dbsql;
import entity.Courses;

public class OpCoursesList {//全部的可选课程
 private ArrayList<OpCourses>  opcourseslist;
 private int count;
 private Schedule schedule;
 
 
 public OpCoursesList(Schedule Schedule){
	 opcourseslist=new ArrayList<OpCourses>();
	 count=opcourseslist.size();
	 schedule=Schedule;
	 setOpcourseslistByT_courses();
 }
public ArrayList<OpCourses> getOpcourseslist() {
	return opcourseslist;
}
public void setOpcourseslist(ArrayList<OpCourses> opcourses) {
	this.opcourseslist = opcourses;
	count=opcourses.size();
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
 
public void setOpcourseslistByT_courses(){//获得可选的课程列表
	Dbsql db=new Dbsql();
	ArrayList<String> Ai=db.getT_Courses();
	String tem;
	for(int i=0;i<Ai.size();i++)
	{
		tem=Ai.get(i);
	String[] info=tem.split(","); 
	OpCourses opcourses=new OpCourses();
	Courses course=db.getCourses(info[1]);
	
	if(schedule.isTimeAllow(course.getCtime()))
	{
		opcourses.setTeacher(db.getTeacher(info[0]));
		opcourses.setCourses(course);
		opcourses.setClassroom(db.getClassRoom(course.getRno()));
		opcourseslist.add(opcourses);
		count++;
	}
	
	
	}
}
public Schedule getSchedule() {
	return schedule;
}
public void setSchedule(Schedule schedule) {
	this.schedule = schedule;

	
}
public void  updateSchedule(Courses courses){
	

	schedule.setTimeCourse(courses.getCtime());
	count--;
	for(int i=0;i<opcourseslist.size();i++)
	{
		if(opcourseslist.get(i).getCourses().getCno().equals(courses.getRno()))
		{
			opcourseslist.remove(i);
			break;
		}
	}
}



}
