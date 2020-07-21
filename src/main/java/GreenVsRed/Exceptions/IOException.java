package main.java.GreenVsRed.Exceptions;

public class IOException extends Exception {
    public IOException(){
        super();
    }

    public IOException(String message){
        super(message + "\nPress enter to exit.");
    }
}
