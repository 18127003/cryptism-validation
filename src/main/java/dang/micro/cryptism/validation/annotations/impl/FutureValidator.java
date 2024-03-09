package dang.micro.cryptism.validation.annotations.impl;


import dang.micro.cryptism.validation.annotations.Future;
import dang.micro.cryptism.validation.validator.Validator;
import dang.micro.cryptism.validation.validator.impl.BaseValidator;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class FutureValidator extends BaseValidator<Future, ChronoLocalDate> {
    public FutureValidator(){};
    public FutureValidator(FutureValidator futureValidator){
        super(futureValidator);
    }
    @Override
    public boolean isValid(ChronoLocalDate value) {
        return value==null||value.isAfter(LocalDate.now());
    }

    @Override
    public Validator<ChronoLocalDate> cloneValidator() {
        return new FutureValidator(this);
    }

    @Override
    public void onInit(Future future) {

    }
}
