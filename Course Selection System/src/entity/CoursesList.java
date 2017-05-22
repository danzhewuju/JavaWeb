package entity;

import java.util.ArrayList;

public class CoursesList {
private ArrayList<Courses> courselist;
private int count;
public CoursesList(){
	courselist=new ArrayList<Courses>();
	count=courselist.size();
}
public ArrayList<Courses> getCourselist() {
	return courselist;
}
public void setCourselist(ArrayList<Courses> courselist) {
	this.courselist = courselist;
	count=courselist.size();
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

public void addCourse(Courses courses)//增加课程
{
	courselist.add(courses);
	count++;
}
public void delCoursesByCno(String Cno){//通过Sno删除课程
	for(int i=0;i<courselist.size();i++)
	{
		if(courselist.get(i).getCno().equals(Cno))
		{
			courselist.remove(i);
		}
	}
	count--;
}

public void editCourseeByCno(String Cno,String Cname,String Ctime,String Rno){//通过Sno编辑课程
	for(int i=0;i<courselist.size();i++)
	{
		if(courselist.get(i).getCno().equals(Cno))
		{
			courselist.get(i).setCname(Cname);
			courselist.get(i).setCtime(Ctime);
			courselist.get(i).setRno(Rno);
			
		}
	}
}

public void check(ArrayList<String> Cno)
{
	for(int i=0;i<Cno.size();i++)
	{
		for(int j=0;j<courselist.size();j++)
		{
			if(Cno.get(i).equals(courselist.get(j).getCno()))
			{
				courselist.remove(j);
				count--;
			}
		}
	}
}

}
