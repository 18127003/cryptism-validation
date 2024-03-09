package dang.micro.cryptism.validation.builder;

import dang.micro.cryptism.validation.violation.handler.ViolationHandler;
import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.validator.ValidatorHolder;

public interface ValidateHolderBuilder<T> {
    ValidatorHolder<T> buildValidatable();
    ValidateHolderBuilder<T> applyConstraint();
    ValidateHolderBuilder<T> applyConstraint(String field);
    ValidateHolderBuilder<T> applyPojoConstraint();
    ValidateHolderBuilder<T> applyPojoConstraint(String field);
    ValidateHolderBuilder<T> applyCollectionInternalConstraint();
    ValidateHolderBuilder<T> applyCollectionInternalConstraint(String field);
    ValidateHolderBuilder<T> applyCollectionConstraint();
    ValidateHolderBuilder<T> applyCollectionConstraint(String field);
    ValidateHolderBuilder<T> endCompositeConstraint();
    ValidateHolderBuilder<T> max(int max);
    ValidateHolderBuilder<T> handler(ViolationHandler handler);
    ValidateHolderBuilder<T> notEmpty();
    ValidateHolderBuilder<T> length(int min, int max);
    ValidateHolderBuilder<T> length(int max);
    ValidateHolderBuilder<T> addCustomValidator(Validator validator);
}
