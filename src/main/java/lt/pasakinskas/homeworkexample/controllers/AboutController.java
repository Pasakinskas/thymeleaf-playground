package lt.pasakinskas.homeworkexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

  @GetMapping("/about")
  public String getComments(Model model) {
    return "/pages/about";
  }
}
