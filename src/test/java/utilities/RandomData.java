package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class RandomData {
	
	 public static String randomString() {
	        String Name = RandomStringUtils.randomAlphabetic(5);
	        return Name;
	    }
	 public static String randomnumber() {
	        String Number = RandomStringUtils.randomNumeric(8);
	        return Number;
	    }
	 
	 public static String randomStringPass() {
	        String Pass = RandomStringUtils.randomAlphanumeric(5, 5);
	        return Pass;
	    }
	 
	 public static String randomPhoneNumber() {
		  Random rand = new Random();
		    int firstDigit = 6 + rand.nextInt(4);
		    int remaining = rand.nextInt(1000000000);

		    return firstDigit + String.format("%09d", remaining);
	 }
	 public static String customPassword() {
		    String[] names = {"Admin", "Test", "User", "QA", "Demo"};
		    
		    Random rand = new Random();
		    
		    String name = names[rand.nextInt(names.length)];
		    int number = 100 + rand.nextInt(900); // 100–999

		    return name + "@" + number;
		}
	 public static void main(String[] args) {
	String pass = customPassword();
	System.out.println(pass);
	}
}
