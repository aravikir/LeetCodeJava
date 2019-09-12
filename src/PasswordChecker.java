import java.util.ArrayList;

//Leetcode passoword strength check
//must be between 6 and 20 character
//must have 1 uppercase, 1 lowercase and 1 digit
//must not contain 3 repeating consecutive digits

public class PasswordChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa111";
		System.out.println("Changes required to be made to " + s + " are: " + strongPasswordChecker(s));
		s = "";
		System.out.println("Changes required to be made to " + s + " are: " + strongPasswordChecker(s));
		s = "a";
		System.out.println("Changes required to be made to " + s + " are: " + strongPasswordChecker(s));
		s = "aaa123";
		System.out.println("Changes required to be made to " + s + " are: " + strongPasswordChecker(s));
		s = "abc123";
		System.out.println("Changes required to be made to " + s + " are: " + strongPasswordChecker(s));
		s = "1111111111";
		System.out.println("Changes required to be made to " + s + " are: " + strongPasswordChecker(s));

	}
	
	public static int strongPasswordChecker(String s) {
		char[] ca = s.toCharArray();
		int change = 0;
		ArrayList digit = new ArrayList();
		
		//Incase string is empty
//		if(ca.length==0) {
//			return 9;
//		}
		
		//To check for length of the password
		if (ca.length<6 || ca.length>20) {
			change = Math.min(Math.abs(6-ca.length),Math.abs(ca.length-20));
			return change;
		}
		
		//To check if 3 consecutive characters are repeating
		if (ca.length>2) {
			for (int i=0; i<ca.length-2; i++) {
				if (ca[i]==ca[i+1] && ca[i]==ca[i+2]) {
					change++;
					i+=2;
					//return change;
				}
			}
		}
		
		//if there are repeating by now
		if (change>0) {
			return change;
		}
		
		//To check for 1 lower case, 1 upper case
		if(s==s.toLowerCase()) {
			change++;
			return change;
		}
		if (s==s.toUpperCase()) {
			change++;
		}
		
		//To check for digits
		for(char c: ca) {
			if (Character.isDigit(c)) {
				digit.add(c);
			}
		}
		if(!(digit.size()>0)) {
			change++;
			return change;
		}
		
		return change;
	}

}
