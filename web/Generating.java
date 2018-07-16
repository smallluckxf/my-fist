package web;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


public class Generating extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		//String student_id = request.getParameter("id");
		//System.out.println("id:" + student_id);
		/*String student_name = request.getParameter("name");
		System.out.println("name:" + student_name);*/
		
		try {
			////////////
			// do something
			////////////
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from ask");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			int tid = 0;
			String question = "";
			String opA= "";
			String opB = "";
			String opC = "";
			String opD = "";
			String answer = "";
			JSONObject obj = new JSONObject();
			ArrayList<Question> list = new ArrayList();
			//获取全部题目
			while(rs.next()){
				tid=rs.getInt(1);
				question = rs.getString(2);
			    opA = rs.getString(3);
				opB = rs.getString(4);
			    opC = rs.getString(5);
		        opD = rs.getString(6);
			    answer = rs.getString(7);
			    Question q = new Question(tid, question, opA, opB, opC,opD,answer);
			    list.add(q);
			}
			db.close();
			
			//获取随机数
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
			}
			//第一个问题	
			JSONObject obj1 = new JSONObject();
			Question q1=list.get(ques[0]);
			obj1.put("tid", q1.tid);
			obj1.put("question", q1.question);
			obj1.put("opA", q1.opA);
			obj1.put("opB", q1.opB);
			obj1.put("opC", q1.opC);
			obj1.put("opD", q1.opD);
			obj1.put("answer", q1.answer);
			obj.put("question1",obj1);
			
			//第二个问题
			JSONObject obj2 = new JSONObject();
			Question q2=list.get(ques[1]);
			obj2.put("tid", q2.tid);
			obj2.put("question", q2.question);
			obj2.put("opA", q2.opA);
			obj2.put("opB", q2.opB);
			obj2.put("opC", q2.opC);
			obj2.put("opD", q2.opD);
			obj2.put("answer", q2.answer);
			obj.put("question2",obj2);
			//第三个问题
			JSONObject obj3 = new JSONObject();
			Question q3=list.get(ques[2]);
			obj3.put("tid", q3.tid);
			obj3.put("question", q3.question);
			obj3.put("opA", q3.opA);
			obj3.put("opB", q3.opB);
			obj3.put("opC", q3.opC);
			obj3.put("opD", q3.opD);
			obj3.put("answer", q3.answer);
			obj.put("question3",obj3);
			//第四个问题
			JSONObject obj4 = new JSONObject();
			Question q4=list.get(ques[3]);
			obj4.put("tid", q4.tid);
			obj4.put("question", q4.question);
			obj4.put("opA", q4.opA);
			obj4.put("opB", q4.opB);
			obj4.put("opC", q4.opC);
			obj4.put("opD", q4.opD);
			obj4.put("answer", q4.answer);
			obj.put("question4",obj4);
			
			System.out.println(obj.toString());
			out.print(obj.toString());
			
			out.flush();
			out.close();
	
			}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public static void doSearch(String student_name) {
		try {
			////////////
			// do something
			////////////
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from ask");
			
			int tid = 0;
			String question = "";
			String opA= "";
			String opB = "";
			String opC = "";
			String opD = "";
			String answer = "";
			JSONObject obj = new JSONObject();
			ArrayList<Question> list = new ArrayList();
			//获取全部题目
			while(rs.next()){
				tid=rs.getInt(1);
				question = rs.getString(2);
			    opA = rs.getString(3);
				opB = rs.getString(4);
			    opC = rs.getString(5);
		        opD = rs.getString(6);
			    answer = rs.getString(7);
			    Question q = new Question(tid, question, opA, opB, opC,opD,answer);
			    list.add(q);
			}
			db.close();
			
			//获取随机数
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
			//第一个问题	
			JSONObject obj1 = new JSONObject();
			Question q1=list.get(ques[0]);
			obj1.put("tid", q1.tid);
			obj1.put("question", q1.question);
			obj1.put("opA", q1.opA);
			obj1.put("opB", q1.opB);
			obj1.put("opC", q1.opC);
			obj1.put("opD", q1.opD);
			obj1.put("answer", q1.answer);
			obj.put("question1",obj1);
			
			//第二个问题
			JSONObject obj2 = new JSONObject();
			Question q2=list.get(ques[1]);
			obj2.put("tid", q2.tid);
			obj2.put("question", q2.question);
			obj2.put("opA", q2.opA);
			obj2.put("opB", q2.opB);
			obj2.put("opC", q2.opC);
			obj2.put("opD", q2.opD);
			obj2.put("answer", q2.answer);
			obj.put("question2",obj2);
			//第三个问题
			JSONObject obj3 = new JSONObject();
			Question q3=list.get(ques[2]);
			obj3.put("tid", q3.tid);
			obj3.put("question", q3.question);
			obj3.put("opA", q3.opA);
			obj3.put("opB", q3.opB);
			obj3.put("opC", q3.opC);
			obj3.put("opD", q3.opD);
			obj3.put("answer", q3.answer);
			obj.put("question3",obj3);
			//第四个问题
			JSONObject obj4 = new JSONObject();
			Question q4=list.get(ques[3]);
			obj4.put("tid", q4.tid);
			obj4.put("question", q4.question);
			obj4.put("opA", q4.opA);
			obj4.put("opB", q4.opB);
			obj4.put("opC", q4.opC);
			obj4.put("opD", q4.opD);
			obj4.put("answer", q4.answer);
			obj.put("question4",obj4);
			
			System.out.println(obj.toString());
			
			
			}catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		doSearch("1605050228");
		
	}

}
