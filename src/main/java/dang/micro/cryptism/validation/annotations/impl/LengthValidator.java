package dang.micro.cryptism.validation.annotations.impl;

import dang.micro.cryptism.validation.annotations.Length;
import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.validator.impl.BaseValidator;

public class LengthValidator extends BaseValidator<Length,String> {
    int min;
    int max;

    @Override
    public void onInit(Length length) {
        this.max = length.max();
        this.min = length.min();
    }

    public LengthValidator(){}

    public LengthValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public LengthValidator(LengthValidator other){
        super(other);
        this.min = other.min;
        this.max = other.max;
    }

    @Override
    public boolean isValid(String value) {
        return value==null || (value.length() >= min && value.length() <= max);
    }


    @Override
    public Validator<String> cloneValidator() {
        return new LengthValidator(this);
    }
}
