package be.intecbrussel.sellers;

public class NoMoreIceCreamException extends Exception {
    public NoMoreIceCreamException(){

    }

    public NoMoreIceCreamException(String message){
        super(message);
    }
}
