package entity;

import dbsql.Dbsql;

public class Courses {
private String  Cno ;
private String ClassRoomName;
private String  Cname  ;
private String  Ctime ;
private String  Rno ;
private String  Cmax ;

public String getCno() {
	return Cno;
}
public void setCno(String cno) {
	Cno = cno;
	
	
}
public String getCname() {
	return Cname;
}
public void setCname(String cname) {
	Cname = cname;
}
public String getCtime() {
	return Ctime;
}
public void setCtime(String ctime) {
	Ctime = ctime;
}
public String getRno() {
	return Rno;
}
public void setRno(String rno) {
	Rno = rno;
	Dbsql db=new Dbsql();
	ClassRoom classroom=db.getClassRoom(rno);
	setClassRoomName(classroom.getRname());
}
public String getCmax() {
	return Cmax;
}
public void setCmax(String cmax) {
	Cmax = cmax;
}
public String getClassRoomName() {
	return ClassRoomName;
}
public void setClassRoomName(String classRoomName) {
	ClassRoomName = classRoomName;
}


}
