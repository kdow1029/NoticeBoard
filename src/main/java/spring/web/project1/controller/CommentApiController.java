package spring.web.project1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.web.project1.dto.CommentReqDto;
import spring.web.project1.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping(value = "/api/post/{nno}/comment")
    public Long save(@PathVariable Long nno, @RequestBody CommentReqDto commentReqDto){
        return commentService.commentSave(nno, commentReqDto);
    }
}
