package lt.pasakinskas.homeworkexample.controllers;

import lt.pasakinskas.homeworkexample.persistence.CommentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CommentsController.class)
public class CommentsControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CommentsRepository commentsRepository;

  @Test
  public void shouldDisplayComments() throws Exception {
    mockMvc.perform(get("/"))
      .andExpect(status().is2xxSuccessful())
      .andExpect(view().name("/pages/index"))
      .andExpect(model().attributeExists("comments", "comment"));

    Mockito.verify(commentsRepository).findAll();
  }

  @Test
  public void shouldDisplayErrorPage() throws Exception {
    mockMvc.perform(get("/easdasd"))
      .andExpect(status().is(404));
  }

  @Test
  public void shouldCreateComment() throws Exception {
    mockMvc.perform(post("/comments")
      .param("name", "name")
      .param("surname", "surname")
      .param("email", "email@email.com")
      .param("repeatedEmail", "email@email.com")
      .param("content", "some content")
    )
      .andExpect(status().is3xxRedirection())
      .andExpect(header().string("Location", "/"));


    Mockito.verify(commentsRepository).save(any());
  }
}
