package entity;

import java.util.ArrayList;

import dbsql.Dbsql;

public class MessageList {
private ArrayList<Message> messagelist;
private int count;
public MessageList() {
	messagelist=new ArrayList<>();
	count=0;
}
public ArrayList<Message> getMessagelist() {
	return messagelist;
}
public void setMessagelist(ArrayList<Message> messagelist) {
	this.messagelist = messagelist;
	count=messagelist.size();
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

public void removemessage(String Sno,String Tno){
	for(int i=0;i<messagelist.size();i++)
	{
		if(messagelist.get(i).getStudent().getSno().equals(Sno)&&
				messagelist.get(i).getTeacher().getTno().equals(Tno)
				)
		{
			messagelist.remove(i);
			count--;
			break;
		}
	}
}

public void RemoveAll(){
	Dbsql db=new Dbsql();
	for(int i=0;i<count;i++)
	{
		
		int key=3;
		db.EditFlagFromMessage(messagelist.get(i).getID(), key);
	}
	
	messagelist.clear();
	count=0;
	
	
}

}
