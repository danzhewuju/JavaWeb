package entity;

import java.util.ArrayList;

public class TeacherList {
private ArrayList<Teacher> teacherlist;
private int count;
public ArrayList<Teacher> getTeacherlist() {
	return teacherlist;
}
public void setTeacherlist(ArrayList<Teacher> teacherlist) {
	this.teacherlist = teacherlist;
	count=teacherlist.size();
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

}
