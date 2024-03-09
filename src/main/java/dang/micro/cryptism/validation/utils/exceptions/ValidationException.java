package dang.micro.cryptism.validation.utils.exceptions;

/***
 * Don't use this
 */
public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
