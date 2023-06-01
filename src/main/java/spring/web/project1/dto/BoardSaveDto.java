package spring.web.project1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.web.project1.entity.Board;

@Getter
@NoArgsConstructor
public class BoardSaveDto {

    private String title;
    private String content;
    private String writer;

    @Builder
    public BoardSaveDto(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
