package fsd;

import java.util.*;

public class Equation {
	private static HashMap<String, Integer> sets(){
		HashMap<String, Integer> set = new HashMap<>();
		set.put("+",2);
		set.put("-",2);
		set.put("*",1);
		set.put("x",1);
		set.put("X",1);
		set.put("/",1);
		set.put("(",0);
		set.put(")",0);
		return set;
	};

	public static double eq(String str) {
		double res = 0;
		Stack<Double> st = new Stack<>();

		ArrayList<String> eq = Eq(str);
		if(!validEq(eq)) {
			System.out.println("잘못된 수식");
			return 0;
		}
		ArrayList<String> post = postFix(eq);
		for(String s:post){
			if(sets().keySet().contains(s)){
				st.push(mathE(st.pop(), st.pop(), s));
			}
			else{
				st.push(Double.parseDouble(s));
			}
		}
		if(!st.isEmpty())
			res = st.pop();
		return res;
	}
	
	//후위 표기법 전환
	private static ArrayList<String> postFix(ArrayList<String> str){
		ArrayList<String> post = new ArrayList<>();
		Stack<String> st = new Stack<>();
		for(String s:str){
			if(isNum(s, 1)){
				post.add(s);
				continue;
			}
			if(s.equals(")")){
				while (!st.peek().equals("(")) {
					post.add(st.pop());
				}
				st.pop();
				continue;
			}
			if(sets().keySet().contains(s)){
				if(st.isEmpty()){}
				else if(st.peek().equals("(")){}
				else if(sets().get(s)>=sets().get(st.peek())){
					post.add(st.pop());
				}
				st.push(s);
				continue;
			}
		}
		while (!st.isEmpty()) {
			post.add(st.pop());
		}
		return post;
	}
	
	public static String onlyEq(String str) {
		String res = "";
		ArrayList<String> eq = Eq(str);
		for(String r: eq) {res+=r;}
		return res;
	}
	//수식 String을 기호와 그 외의 것으로 분리해 ArrayList에 저장 후 반환. 숫자 혹은 기호가 아니면 반영 안함.
	private static ArrayList<String> Eq(String str){
		String r="";
		ArrayList<String> eq = new ArrayList<>();
		for(int i=0;i<str.length();i++) {
			String temp = Character.toString(str.charAt(i));
			if(sets().keySet().contains(temp)) {
				if(!r.equals("")) {
					eq.add(r);
					r="";
				}
				eq.add(temp);
			}
			else {
				r = isNum(temp,0)? r+temp: r; 
			}
		}
		if(!r.equals("")) {
			eq.add(r);
		}
		return eq;
	}
	
	//숫자인지 검사
	public static boolean isNum(String s, int f) {
		if (sets().keySet().contains(s) && f==0) return true;
		if (s.equals(".") && f==0) return true;
		try {
			double n = Double.parseDouble(s);
			return true;
		} catch (Exception e) {}
		return false;
	}
	
	//올바른 수식인지 검사
	private static boolean validEq(ArrayList<String> eq) {
		Stack<String> br = new Stack<>();
		int flag = 1;
		for(int i=0;i<eq.size();i++) {
			String temp = eq.get(i);
			if(temp.equals(")")) {
				if(flag == 1) return false;
				if (br.isEmpty()) return false;
				else {
					br.pop();
					flag=0;
					continue;
				}
			}
			if(temp.equals("(")) {
				if(flag==0) return false;
				br.push(temp);
				flag=1;
				continue;
			}
			if(sets().keySet().contains(temp)) {
				if(flag == 1) {return false;}
				else flag = 1;
			}
			else if(!isNum(temp,1)) return false;
			else {
				if(flag == 0) return false;
				flag = 0;
			}
		}
		if(flag==1)return false;
		return true;
	}
	public static boolean validEq(String str) {
		ArrayList<String> eq = Eq(str);
		Stack<String> br = new Stack<>();
		int flag = 1;
		for(int i=0;i<eq.size();i++) {
			String temp = eq.get(i);
			if(temp.equals(")")) {
				if(flag == 1) return false;
				if (br.isEmpty()) return false;
				else {
					br.pop();
					flag=0;
					continue;
				}
			}
			if(temp.equals("(")) {
				if(flag==0) return false;
				br.push(temp);
				flag=1;
				continue;
			}
			if(sets().keySet().contains(temp)) {
				if(flag == 1) {return false;}
				else flag = 1;
			}
			else if(!isNum(temp,1)) return false;
			else {
				if(flag == 0) return false;
				flag = 0;
			}
		}
		if(flag==1)return false;
		return true;
	}
	//사칙연산
	private static double mathE(double A, double B, String s){
		if(s.equals("+")){
			return B+A;
		}
		else if(s.equals("-")){
			return B-A;
		}
		else if(s.equals("*")||s.equals("x")||s.equals("X")){
			return B*A;
		}
		else if(s.equals("/")){
			return B/A;
		}
		return 0;
	}
}