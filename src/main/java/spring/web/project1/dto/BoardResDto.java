package spring.web.project1.dto;

import lombok.Getter;
import spring.web.project1.entity.Board;

@Getter
public class BoardResDto {

    private Long nno;
    private String title;
    private String content;
    private String writer;
    private int view;

    public BoardResDto(Board entity){
        this.nno = entity.getNno();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.view = entity.getView();
    }
}
