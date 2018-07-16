package web;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class DBTest {

	public static void main(String[] args) {
		try {
			DBConnection b =new DBConnection();
			//String sql = "insert into student(id,name,age,dept,address) values('1507','Tom',20,'璁＄畻鏈�,'婀栧崡')";
			
			//b.execute(sql);
			ResultSet rs = b.executeQuery("select * from ask");
			
			ArrayList<Question> list = new ArrayList();
			while(rs.next()){
				int tid = rs.getInt(1);
				String question = rs.getString(2);
				String opA = rs.getString(3);
				String opB = rs.getString(4);
				String opC = rs.getString(5);
				String opD = rs.getString(6);
				String answer = rs.getString(7);
				Question t = new Question(tid, question, opA, opB, opC,opD,answer);
				list.add(t);
			}
			b.close();
			Random r = new Random();
			int j=0;
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				int k=0;
				while(k<4){
					if(randnumber==ques[k])
						break;
					k++;
				}
				if(k==4){
					ques[j] = randnumber;
					j++;
					System.out.println(randnumber);
				}
				
				//if not exist 
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
