package spring.web.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.web.project1.entity.Board;
import spring.web.project1.entity.Comment;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentReqDto {

    private String comment;
    private Board board;

    public Comment toEntity(){
        return Comment.builder()
                .comment(comment)
                .board(board)
                .build();
    }

}
