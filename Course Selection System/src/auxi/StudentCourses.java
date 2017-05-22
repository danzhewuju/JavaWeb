package auxi;

import entity.Courses;
import entity.Student;

public class StudentCourses {
private Student student;
private Courses courses;
private int grade;
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Courses getCourses() {
	return courses;
}
public void setCourses(Courses courses) {
	this.courses = courses;
}
public int getGrade() {
	return this.grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}




}
