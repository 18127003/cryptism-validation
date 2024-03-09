package dang.micro.cryptism.validation.annotations;

import dang.micro.cryptism.validation.annotations.impl.ArrayLengthValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatedBy(clazz = ArrayLengthValidator.class)
public @interface ArrayLength {
    int min() default 0;
    int max();
    String message() default "Invalid Length";
}
