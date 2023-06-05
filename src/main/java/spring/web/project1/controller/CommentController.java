package spring.web.project1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.web.project1.dto.BoardResDto;
import spring.web.project1.dto.CommentResDto;
import spring.web.project1.service.BoardService;
import spring.web.project1.service.CommentService;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final BoardService boardService;

    @GetMapping(value = "/board/post/{nno}/comment")
    public String boardDtl(@PathVariable Long nno, Model model){
        BoardResDto resDto = boardService.findById(nno);
        model.addAttribute("board", resDto);
        return "/board/comment";
    }

    @GetMapping(value = "/board/post/{nno}/comment/{id}")
    public String commentUpdate(@PathVariable Long nno, @PathVariable Long id, Model model){
        BoardResDto resDto = boardService.findById(nno);
        CommentResDto commentResDto = commentService.findById(id);
        model.addAttribute("board", resDto);
        model.addAttribute("comment", commentResDto);
        return  "/board/commentUpdate";
    }
}
