package spring.web.project1.dto;

import lombok.Getter;
import spring.web.project1.entity.Comment;

@Getter
public class CommentResDto {

    private Long id;
    private String comments;
    private String writer;
    private Long nno;

    public CommentResDto(Comment comment){
        this.id = comment.getId();
        this.comments = comment.getComment();
        this.writer = comment.getBoard().getWriter();
        this.nno = comment.getBoard().getNno();
    }
}
