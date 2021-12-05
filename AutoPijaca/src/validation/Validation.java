package validation;

public class Validation {
	
	// Writing parameters.
	
	public void WriteParameters(String UserName, String Password, String RepeatedPassword, String UserType) {
		
		System.out.println("Parameters are: ");
		System.out.println("UserName: " + UserName);
		System.out.println("Password: " + Password);
		System.out.println("RepeatedPassword: " + RepeatedPassword);
		System.out.println("UserType: " + UserType);
		
	}
	
	// Method that checks password.
	public boolean IsThePasswordOkay(String password) {
		
		int LengthOfThePassword = password.length();
		
		if(LengthOfThePassword < 8) {
			System.out.println("Password is incorrect!");
	    return false;
		
		}
		
		int DigitCounter = 0;
		int UpperCaseCounter = 0;
		
		// going trough String --> line of chars.
		for(int i = 0; i < LengthOfThePassword; i++) {
			
			// 
			char character = password.charAt(i);
			if(Character.isDigit(character)) {
				DigitCounter ++;
			}
			
			if(Character.isUpperCase(character)) {
				UpperCaseCounter ++;
			}
		}
		
		if(DigitCounter >= 2 && UpperCaseCounter >= 1) {
			System.out.println("Password is correct!");
		    return true;
		}else {
			System.out.println("Password is incorrect!");
		    return false;
		}
		
		
		
	}

	public boolean validateUserAndPasswordFromTheDatabase(String userName, String password) {
		
		if((userName == null || userName.isEmpty()) || (password == null || password.isEmpty())){
			System.out.println("User name or password are empty or null!");
			return false;
		}else {
			System.out.println("User name and password are not empty or null.");
			return true;
		}
		
	}
	
}