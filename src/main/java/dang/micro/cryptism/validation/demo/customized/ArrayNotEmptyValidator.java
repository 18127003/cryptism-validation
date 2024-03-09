package dang.micro.cryptism.validation.demo.customized;


import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.validator.impl.BaseValidator;

import java.util.Collection;

public class ArrayNotEmptyValidator extends BaseValidator<ArrayNotEmpty, Collection> {
    @Override
    public void onInit(ArrayNotEmpty arrayNotEmpty) {}

    @Override
    public boolean isValid(Collection value) {
        return value.size() > 0;
    }

    @Override
    public Validator<Collection> cloneValidator() {
        return new ArrayNotEmptyValidator();
    }
}
