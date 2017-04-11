package usst;

import java.util.ArrayList;

public class Students {
private ArrayList<Student>students;
private int sum;

public Students(){
	students=new ArrayList<Student>();
	sum=0;
}

public ArrayList<Student> getStudents() {
	return students;
}

public void setStudents(ArrayList<Student> students) {
	this.students = students;
}

public void addstudent(Student student){
	students.add(student);
	sum++;
}
public void delstudent(int index){
	students.remove(index);
	sum--;
}

public int getSum() {
	return sum;
}

public void setSum(int sum) {
	this.sum = sum;
}


}
