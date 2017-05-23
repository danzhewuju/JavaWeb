package entity;

public class Message {
private int ID;
private Student student;
private Teacher teacher;
private int flag;
private String Msn;
private String Backmsn;
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public String getMsn() {
	return Msn;
}
public void setMsn(String msn) {
	Msn = msn;
}
public String getBackmsn() {
	return Backmsn;
}
public void setBackmsn(String backmsn) {
	Backmsn = backmsn;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}


}
