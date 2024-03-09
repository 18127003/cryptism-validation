package dang.micro.cryptism.validation.annotations.impl;

import dang.micro.cryptism.validation.annotations.NotEmpty;
import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.validator.impl.BaseValidator;

public class NotEmptyValidator extends BaseValidator<NotEmpty, String> {
    public NotEmptyValidator(){}

    @Override
    public void onInit(NotEmpty notEmpty) {}

    @Override
    public boolean isValid(String value) {
        return value==null || !value.isEmpty();
    }

    @Override
    public Validator<String> cloneValidator() {
        return new NotEmptyValidator(this);
    }

    protected NotEmptyValidator(NotEmptyValidator other) {
        super(other);
    }
}
