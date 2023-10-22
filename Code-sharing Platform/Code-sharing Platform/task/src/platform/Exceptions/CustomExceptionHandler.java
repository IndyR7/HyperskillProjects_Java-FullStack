package platform.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CodeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleCodeNotFoundException() {
    }
}
