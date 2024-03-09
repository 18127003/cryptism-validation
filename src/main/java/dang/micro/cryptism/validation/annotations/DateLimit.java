package dang.micro.cryptism.validation.annotations;


import dang.micro.cryptism.validation.annotations.impl.DateLimitValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatedBy(clazz = DateLimitValidator.class)
public @interface DateLimit {
    String start() default "";
    String end() default "";
    String message() default "Date is beyond LIMIT";
}
