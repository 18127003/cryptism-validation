package dang.micro.cryptism.validation.annotations;

import dang.micro.cryptism.validation.annotations.impl.EmailFormatValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatedBy(clazz = EmailFormatValidator.class)
public @interface Email {
    String message() default "Invalid email format";
}
