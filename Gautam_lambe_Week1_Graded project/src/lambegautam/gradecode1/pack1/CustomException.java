package lambegautam.gradecode1.pack1;

//this is custom exception class used for when customer provide inappropriate inputs

public class CustomException extends Exception{
	public CustomException() {
		super("Invalid input");
	}

}
