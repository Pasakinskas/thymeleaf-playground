package lt.pasakinskas.homeworkexample.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lt.pasakinskas.homeworkexample.models.Comment;
import lt.pasakinskas.homeworkexample.persistence.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Slf4j
@SessionAttributes({"comments"})
public class CommentsController {

  private CommentsRepository repository;

  public CommentsController(@Autowired CommentsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/")
  public String getComments(
    HttpSession session,
    Model model,
    SessionStatus status
  ) {
    var comments = repository.findAll();

    model.addAttribute("comments", comments);
    model.addAttribute("comment", new Comment());

    return "/pages/index";
  }

  @PostMapping("/comments")
  public String createComment(
    @Valid Comment comment,
    BindingResult errors,
    HttpSession session
    ) {
    if (errors.hasErrors()) {
      return "/pages/index";
    }
    repository.save(comment);
    return "redirect:/";
  }

  @DeleteMapping("/comments/{id}")
  public String createComment(@PathVariable Long id) {
    repository.deleteById(id);
    return "redirect:/";
  }
}
