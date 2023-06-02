package spring.web.project1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.web.project1.dto.BoardResDto;
import spring.web.project1.entity.Board;
import spring.web.project1.entity.Comment;
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
    public String boardUpdate(@PathVariable Long nno, Model model){
        BoardResDto resDto = boardService.findById(nno);
        model.addAttribute("board", resDto);

        return "/board/update";
    }

    @GetMapping(value = "/board/post/view/{nno}")
    public String boardDtl(@PathVariable Long nno, Model model){
        BoardResDto resDto = boardService.findById(nno);
        List<Comment> comments = resDto.getCommentList();

        if (comments != null && !comments.isEmpty())
        {
            model.addAttribute("comments", comments);
        }
        boardService.updateView(nno);
        model.addAttribute("board", resDto);

        return "/board/boardDtl";
    }

    @GetMapping(value = "/board/post")
    public String boardPost(){
        return "/board/post";
    }
}
