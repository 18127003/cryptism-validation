package dang.micro.cryptism.validation.annotations.impl;

import dang.micro.cryptism.validation.annotations.NotNull;
import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.validator.impl.BaseValidator;

public class NotNullValidator extends BaseValidator<NotNull, Object> {
    public NotNullValidator(){}

    @Override
    public void onInit(NotNull notNull) {}

    @Override
    public boolean isValid(Object value) {
        return value!=null;
    }

    @Override
    public Validator<Object> cloneValidator() {
        return new NotNullValidator(this);
    }

    protected NotNullValidator(NotNullValidator other) {
        super(other);
    }
}
