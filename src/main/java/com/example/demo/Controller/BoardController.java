package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/")
    public String index(){
        return "Web/index.html";
    }

    @GetMapping("/join")
    public String join(){
        return "Web/join.html";
    }

    @GetMapping("/board")
    public String board(){
        return "Web/board.html";
    }

    @GetMapping("/posting")
    public String post(){
        return "Web/posting.html";
    }

    @GetMapping("/userPost")
    public String userPost(){
        return "Web/userPost.html";
    }

    @GetMapping("/help")
    public String help(){
        return "Web/help.html";
    }
}
