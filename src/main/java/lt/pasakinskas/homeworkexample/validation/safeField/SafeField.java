package lt.pasakinskas.homeworkexample.validation.safeField;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SafeFieldValidator.class)
public @interface SafeField {
  String message() default "must not contain special characters";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
