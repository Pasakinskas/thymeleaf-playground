package lt.pasakinskas.homeworkexample.persistence;

import lt.pasakinskas.homeworkexample.models.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentsRepositoryIT {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private CommentsRepository repository;

  @Test
  public void whenCreatingComments_theyArePersisted() {
    var comment = new Comment(
      0L,
      "name",
      "surname",
      "some@email.com",
      "some@email.com",
      "content"
    );

    var savedComment = repository.save(comment);
    var persistedComment = entityManager.find(Comment.class, savedComment.getId());
    assertEquals(persistedComment, savedComment);
  }

  @Test
  public void whenGettingAllComments_itRetrievesSavedComments() {

  }
}
