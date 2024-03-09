package dang.micro.cryptism.validation.validator.impl;

import dang.micro.cryptism.validation.violation.handler.ViolationHandler;
import dang.micro.cryptism.validation.utils.ValidateObject;
import dang.micro.cryptism.validation.validator.ChainPrototype;
import dang.micro.cryptism.validation.validator.ValidatorHolder;
import dang.micro.cryptism.validation.violation.Violation;
import dang.micro.cryptism.validation.violation.ViolationContext;

import java.util.Collection;

public class BaseValidatorHolder<T> extends ValidatorHolder<T> {
    private ChainPrototype<T> chain;

    public void setChain(ChainPrototype<T> chain) {
        this.chain = chain;
    }

    public BaseValidatorHolder(ChainPrototype<T> chain, ViolationHandler handler){
        super(handler);
        this.chain = chain;
    }

    public BaseValidatorHolder(ViolationHandler handler){
        super(handler);
        this.chain = new PojoValidatorChain<>();
    }

    @Override
    public Collection<Violation> validate(T value) {
        ValidateObject<T> validateObject;
        if (value == null) {
            validateObject = new ValidateObject(Object.class, null);
        } else {
            validateObject = new ValidateObject(value.getClass(), value);
        }
        ViolationContext context = new ViolationContext().root(value);
        chain.processValidation(validateObject, context);
        context.getViolations().forEach(handler::notify);
        return context.getViolations();
    }
}
