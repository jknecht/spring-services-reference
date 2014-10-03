package example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    public static final String INDEX_PAGE = "index";

    @RequestMapping("/")
    public String index() {
        return INDEX_PAGE;
    }
}
