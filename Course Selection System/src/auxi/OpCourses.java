package auxi;

import entity.ClassRoom;
import entity.Courses;
import entity.Teacher;

public class OpCourses {
private Courses courses;
private Teacher teacher;//整体形成课程信息
private ClassRoom classroom;
private int Grade;
private float GPA;



public Courses getCourses() {
	return courses;
}
public void setCourses(Courses courses) {
	this.courses = courses;
}
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
public ClassRoom getClassroom() {
	return classroom;
}
public void setClassroom(ClassRoom classroom) {
	this.classroom = classroom;
}
public int getGrade() {
	return Grade;
}
public void setGrade(int grade) {
	Grade = grade;
	
	if(grade<=100&&grade>=95){
		GPA=(float) 4.5;
	}
	if(grade<95&&grade>=90){
		GPA=(float) 4.0;
	}

	if(grade<90&&grade>=85){
		GPA=(float) 3.5;
	}
	if(grade<85&&grade>=80){
		GPA=(float) 3.0;
	}
	if(grade<80&&grade>=75){
		GPA=(float) 2.5;
	}
	if(grade<75&&grade>=70){
		GPA=(float) 2.0;
	}
	if(grade<70&&grade>=65){
		GPA=(float) 1.5;
	}
	if(grade<65&&grade>=60){
		GPA=(float) 1.0;
	}
	if(grade<60){
		GPA=(float) 0.0;
	}
}
public float getGPA() {
	return GPA;
}


}
