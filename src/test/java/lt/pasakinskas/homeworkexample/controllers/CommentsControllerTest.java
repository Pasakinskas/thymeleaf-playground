package lt.pasakinskas.homeworkexample.controllers;

import jakarta.servlet.http.HttpSession;
import lt.pasakinskas.homeworkexample.persistence.CommentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CommentsControllerTest {

  @Test
  public void shouldDisplayComments() {
    var repository = mock(CommentsRepository.class);
    var httpSession = mock(HttpSession.class);
    var model = mock(Model.class);
    var status = mock(SessionStatus.class);

    var commentsController = new CommentsController(repository);
    when(repository.findAll()).thenReturn(new ArrayList<>());

    var result = commentsController.getComments(httpSession, model, status);

    Mockito.verify(repository).findAll();
    assertEquals("/pages/index", result);
  }
}