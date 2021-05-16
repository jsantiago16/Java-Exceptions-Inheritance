public class InvalidNameException extends RuntimeException {
    public InvalidNameException(){
        super("Invalid name: Name input should not contain letters.");
    }

}