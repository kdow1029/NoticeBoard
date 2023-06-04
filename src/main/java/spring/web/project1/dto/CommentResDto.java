package spring.web.project1.dto;

import lombok.Getter;
import spring.web.project1.entity.Comment;

@Getter
public class CommentResDto {

    private Long id;
    private String comment;
    private String commentWriter;
    private Long nno;

    public CommentResDto(Comment comment){
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.commentWriter = comment.getCommentWriter();
        this.nno = comment.getBoard().getNno();
    }
}
