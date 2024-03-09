package dang.micro.cryptism.validation.validator;


import dang.micro.cryptism.validation.utils.ValidateObject;
import dang.micro.cryptism.validation.utils.exceptions.UnexpectedTypeException;
import dang.micro.cryptism.validation.violation.ViolationContext;

public interface Validator<T> {
    boolean isValid(T value);
    void processValidation(ValidateObject<T> object, ViolationContext context) throws UnexpectedTypeException;
    boolean isValidType(Class<T> clazz);

    Validator<T> cloneValidator();
    Validator<T> setNext(Validator<T> next);
    Validator<T> getNext();
}
