package com.cn.validator;

import com.cn.validator.impl.NotEmptyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyValidator.class)
public @interface NotEmpty {

    String message() default "NOT_EMPTY";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
