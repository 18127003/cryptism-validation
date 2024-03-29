package dang.micro.cryptism.validation.annotations.impl;


import dang.micro.cryptism.validation.annotations.Email;
import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.validator.impl.BaseValidator;

import java.util.regex.Pattern;

public class EmailFormatValidator extends BaseValidator<Email, String> {
    public EmailFormatValidator(){}

    public EmailFormatValidator(EmailFormatValidator other){
        super(other);
    }

    @Override
    public boolean isValid(String value) {
        return value==null||
                Pattern.matches(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
                value);
    }

    @Override
    public Validator<String> cloneValidator() {
        return new EmailFormatValidator(this);
    }

    @Override
    public void onInit(Email email) {

    }
}
