package main.java.GreenVsRed.Exceptions;

public class ArrayIndexOutOfBoundsException extends Exception{
    public ArrayIndexOutOfBoundsException(){
        super("Board must be initialized as 2D grid.");
    }

    public ArrayIndexOutOfBoundsException(String message){
        super(message);
    }
}
