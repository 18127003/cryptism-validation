package dang.micro.cryptism.validation.annotations;


import dang.micro.cryptism.validation.annotations.impl.FutureValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatedBy(clazz = FutureValidator.class)
public @interface Future {
    String message() default "Date is not in the future";
}