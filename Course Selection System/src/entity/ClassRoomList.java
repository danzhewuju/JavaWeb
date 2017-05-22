package entity;

import java.util.ArrayList;

public class ClassRoomList {
private ArrayList<ClassRoom> roomlist;
private int count;

public ClassRoomList(){
	roomlist=new ArrayList<ClassRoom>();
	count=roomlist.size();
}
public ArrayList<ClassRoom> getRoomlist() {
	return roomlist;
}

public void setRoomlist(ArrayList<ClassRoom> roomlist) {
	this.roomlist = roomlist;
	count=roomlist.size();
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

public void removeClassRoom(String ID){//参数教室
for(int i=0;i<roomlist.size();i++)
{
	if(roomlist.get(i).getRno().equals(ID))
	{
		roomlist.remove(i);
		break;
	}

}
count=roomlist.size();
	
}
public void EditClassRoom(String Rno,String Rname){//修改教室的名字
	for(int i=0;i<roomlist.size();i++)
	{
		if(roomlist.get(i).getRno().equals(Rno))
		{
			roomlist.get(i).setRname(Rname);
			break;
		}

}
}

public String getRnoByRname(String Rname)
{
	String Rno=null;
	for(int i=0;i<roomlist.size();i++)
	{
		if(roomlist.get(i).getRname().equals(Rname))
		{
			Rno=roomlist.get(i).getRno();
			break;
		}
	}
	return Rno;
}

}
