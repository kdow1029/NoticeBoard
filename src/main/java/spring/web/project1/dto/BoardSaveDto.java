package spring.web.project1.dto;

import lombok.*;
import spring.web.project1.entity.Board;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardSaveDto {

    private Long nno;
    private String title;
    private String content;
    private String writer;

    public Board toEntity(){
        return Board.builder()
                .nno(nno)
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
