package dang.micro.cryptism.validation.validator;


import dang.micro.cryptism.validation.utils.AddChainRequest;
import dang.micro.cryptism.validation.utils.ValidateObject;
import dang.micro.cryptism.validation.violation.ViolationContext;

public interface ChainPrototype<T> {
    //Clone method
    ChainPrototype<T> cloneChain();

    //Chain methods
    default ChainPrototype<T> insert(Validator<T> validator) throws NoSuchMethodException {
        throw new NoSuchMethodException("Add validator on composite chain not available");
    }

    default ChainPrototype<T> appendValidator(Validator<T> validator) throws NoSuchMethodException {
        throw new NoSuchMethodException("Add validator on composite chain not available");
    }

    default ChainPrototype<T> addChain(AddChainRequest<T> chainRequest) throws NoSuchMethodException {
        throw new NoSuchMethodException("Add chain on single chain not available");
    }

    boolean isNotEmpty();

    //Business logic method
    void processValidation(ValidateObject<T> value, ViolationContext context);
    void validateAndThrow(T value);
}
