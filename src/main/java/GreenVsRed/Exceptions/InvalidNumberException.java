package main.java.GreenVsRed.Exceptions;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(){
        super("Invalid number or/and separator.\nPress enter to exit.\"");
    }

    public InvalidNumberException(String message){
        super(message + "\nPress enter to exit.");
    }
}
