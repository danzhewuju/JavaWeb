package entity;

import java.util.ArrayList;

public class EvaluationList {
private ArrayList<Evaluation> evaluationlist;
private int count;

public EvaluationList() {
	evaluationlist=new ArrayList<>();
	count=0;
}
public ArrayList<Evaluation> getEvaluationlist() {
	return evaluationlist;
}
public void setEvaluationlist(ArrayList<Evaluation> evaluationlist) {
	this.evaluationlist = evaluationlist;
	count=evaluationlist.size();
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}


}
