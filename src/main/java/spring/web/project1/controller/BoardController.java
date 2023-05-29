package spring.web.project1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.web.project1.service.BoardService;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "/board")
    public String board(Model model){
        model.addAttribute("board", boardService.getList());

        return "board/board";
    }

    @GetMapping(value = "/board/post")
    public String boardPost(){
        return "/board/post";
    }
}
