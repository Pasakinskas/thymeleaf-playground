package lt.pasakinskas.homeworkexample.comments;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name ="comments")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull
  @NotBlank
  private String name;
  @NotNull
  @NotBlank
  private String surname;
  @Email
  private String email;
  @Size(max = 500)
  private String content;
}
