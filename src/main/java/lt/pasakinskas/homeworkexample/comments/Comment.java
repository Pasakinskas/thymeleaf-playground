package lt.pasakinskas.homeworkexample.comments;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lt.pasakinskas.homeworkexample.validation.repeatEmail.RepeatedEmail;
import lt.pasakinskas.homeworkexample.validation.safeField.SafeField;

@Entity
@Table(name ="comments")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@RepeatedEmail
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @NotBlank
  @SafeField
  private String name;

  @NotNull
  @NotBlank
  @SafeField
  private String surname;

  @Email
  private String email;

  @Email
  private String repeatedEmail;

  @Size(max = 500)
  private String content;
}
