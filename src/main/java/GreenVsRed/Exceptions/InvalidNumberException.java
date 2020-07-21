package main.java.GreenVsRed.Exceptions;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(){
        super();
    }

    public InvalidNumberException(String message){
        super(message + "\nPress enter to exit.");
    }
}
