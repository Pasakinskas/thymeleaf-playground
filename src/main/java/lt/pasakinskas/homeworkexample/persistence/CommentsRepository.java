package lt.pasakinskas.homeworkexample.persistence;

import lt.pasakinskas.homeworkexample.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
