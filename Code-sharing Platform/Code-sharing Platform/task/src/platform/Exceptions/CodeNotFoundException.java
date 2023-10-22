package platform.Exceptions;

public class CodeNotFoundException extends RuntimeException {
    public CodeNotFoundException() {
        super("Code not found");
    }
}
