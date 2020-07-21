package main.java.GreenVsRed.Exceptions;

public class InputMismatchException  extends Exception{
    public InputMismatchException(){
        super("Not an integer, please try again. Press enter key to exit.");
    }
    public InputMismatchException(String message){
        super(message);
    }
}
