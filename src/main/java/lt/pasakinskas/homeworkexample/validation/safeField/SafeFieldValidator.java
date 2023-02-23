package lt.pasakinskas.homeworkexample.validation.safeField;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class SafeFieldValidator implements ConstraintValidator<SafeField, String> {

  @Override
  public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
    return field.matches("[a-zA-Z_\s]+");
  }
}
