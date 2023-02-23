package lt.pasakinskas.homeworkexample.validation.repeatEmail;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.pasakinskas.homeworkexample.comments.Comment;

public class RepeatedEmailValidator implements ConstraintValidator<RepeatedEmail, Comment> {
  @Override
  public boolean isValid(Comment comment, ConstraintValidatorContext constraintValidatorContext) {
    return comment.getEmail().equals(comment.getRepeatedEmail());
  }
}
