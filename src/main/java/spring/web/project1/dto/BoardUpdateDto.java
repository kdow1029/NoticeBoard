package spring.web.project1.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class BoardUpdateDto {

    private String title;
    private String content;

    @Builder
    public BoardUpdateDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
