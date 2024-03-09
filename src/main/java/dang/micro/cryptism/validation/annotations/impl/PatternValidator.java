package dang.micro.cryptism.validation.annotations.impl;


import dang.micro.cryptism.validation.annotations.MatchPattern;
import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.validator.impl.BaseValidator;

import java.util.regex.Pattern;

public class PatternValidator extends BaseValidator<MatchPattern, String> {
    String pattern;

    @Override
    public void onInit(MatchPattern pattern) {
        this.pattern = pattern.pattern();
    }

    public PatternValidator() {
    }

    public PatternValidator(String pattern) {
        this.pattern = pattern;
    }

    public PatternValidator(PatternValidator other) {
        super(other);
        this.pattern = other.pattern;
    }

    @Override
    public boolean isValid(String value) {
        return value == null ||
                Pattern.matches(
                        this.pattern,
                        value);
    }

    @Override
    public Validator<String> cloneValidator() {
        return new PatternValidator(this);
    }
}
