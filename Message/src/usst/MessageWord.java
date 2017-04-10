package usst;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageWord {
private String name;
private String title;
private String text;
private String gender;
private String  date;


public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public void setDate() {
	Calendar c=Calendar.getInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	date=sdf.format(c.getTime());
}
public String getName() {
	return name;
 
}
public void setName(String name) {
	this.name = name;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}
public String getDate() {
	return date;
}
}
