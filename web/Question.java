package web;

public class Question {

	/*public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpA() {
		return opA;
	}

	public void setOpB(String opA) {
		this.opA = opA;
	}

	
	public String getOpB() {
		return opB;
	}

	public void setOpA(String opB) {
		this.opB = opB;
	}*/
	
	public int tid;
	public String question;
	public String opA;
	public String opB;
	public String opC;
	public String opD;
	public String answer;
	
	public Question() {
		
	}
	public Question(int tid, 
			String question, String opA, 
			String opB, String opC,String opD,String answer) {
		this.tid = tid;
		this.question = question;
		this.opA = opA;
		this.opB = opB;
		this.opC = opC;
		this.opD = opD;
		this.answer = answer;
	}
	public static void main(String[] args) {
		

	}

}
