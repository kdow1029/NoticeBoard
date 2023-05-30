package spring.web.project1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.web.project1.dto.BoardResDto;
import spring.web.project1.entity.Board;
import spring.web.project1.service.BoardService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "/")
    public String main(){
        return "main";
    }


    @GetMapping(value = "/board")
    public String board(Model model){
        List<Board> boardList = boardService.getList();
        model.addAttribute("boardList",boardList);

        return "board/board";
    }

    @GetMapping(value = "/board/post/{nno}")
    public String boardDetail(@PathVariable Long nno, Model model){
        BoardResDto resDto = boardService.findById(nno);
        boardService.updateView(nno);
        model.addAttribute("boards", resDto);

        return "/board/update";
    }

    @GetMapping(value = "/board/post")
    public String boardPost(){
        return "/board/post";
    }
}
