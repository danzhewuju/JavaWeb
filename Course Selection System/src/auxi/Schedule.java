package auxi;

import java.util.HashMap;

public class Schedule {
private int[][] schedule;//0表示时间空闲，1表示没有时间
private HashMap<String, Integer> Week;
private HashMap<String, Integer> Day;

public Schedule(){
	String[] weekstring={"MON","TUE","WED","THU","FRI"};
	String[] daystring={"9:00~12:00","13:00~16:00","18:00~21:00"};
	schedule=new int[3][5];
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<5;j++)
		{
			schedule[i][j]=0;
		}
	}
	
	
	Day=new HashMap<>();
	Week=new HashMap<>();
	
	
	
for(int i=0;i<weekstring.length;i++)
{
	Week.put(weekstring[i], i);
}

for(int i=0;i<daystring.length;i++)
{
	Day.put(daystring[i], i);
}

}


public int[][] getSchedule() {
	return schedule;
}
public void setSchedule(int[][] schedule) {
	this.schedule = schedule;
}

public boolean isTimeAllow(String time){
	boolean flag=false;
	
	String [] s=time.split("-");
	
	int i,j;
	i=Day.get(s[1]);
	j=Week.get(s[0]);
	if(schedule[i][j]==0)
	{
	
		flag=true;
	}
	else
	{
		flag=false;
	}
	return flag;
}

public void setTimeCourse(String time){
	if(isTimeAllow(time))
	{
		String [] s=time.split("-");
		int i,j;
		i=Day.get(s[1]);
		j=Week.get(s[0]);
		schedule[i][j]=1;
	}
}

}
