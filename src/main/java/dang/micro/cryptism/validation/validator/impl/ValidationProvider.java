package dang.micro.cryptism.validation.validator.impl;


import dang.micro.cryptism.validation.builder.ValidateHolderBuilder;
import dang.micro.cryptism.validation.builder.impl.BaseValidateHolderBuilder;
import dang.micro.cryptism.validation.violation.handler.ViolationHandler;
import dang.micro.cryptism.validation.violation.handler.ViolationListener;
import dang.micro.cryptism.validation.utils.AnnotationResolver;
import dang.micro.cryptism.validation.utils.exceptions.ValidationException;
import dang.micro.cryptism.validation.validator.ValidatorHolder;

//Singleton
public class ValidationProvider {
    private static final ValidationProvider INSTANCE = new ValidationProvider();
    private final ViolationHandler violationHandler;
    private final AnnotationResolver resolver;

    // NOTE: SINGLETON PATTERN
    private ValidationProvider() {
        violationHandler = new ViolationHandler();
        resolver = new AnnotationResolver();
    }

    public static ValidationProvider getInstance() {
        return INSTANCE;
    }



    public ValidatorHolder wrapChain(Class<?> objectClass){
        var chain = resolver.resolve(objectClass);
        if (chain==null){
            throw new ValidationException("Cannot construct chain");
        }
        return new BaseValidatorHolder<>(chain, violationHandler);
    }



    public void registerViolationListener(ViolationListener listener){
        violationHandler.subscribe(listener);
    }

    public ViolationHandler getHandler(){
        return violationHandler;
    }

    public void removeViolationListener(ViolationListener listener){violationHandler.unsubscribe(listener);}

    public <T> ValidateHolderBuilder<T> createValidatorBuilder(){
        return new BaseValidateHolderBuilder<T>(violationHandler);
    }
}
