package spring.web.project1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseTimeEntity {

    @Id
    @Column(name = "board_nno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nno;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer ;

    @Column(columnDefinition = "integer default 0" ,nullable = true)
    private int view;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Comment> commentList = new ArrayList<>();

//    @Builder
//    public Board(String title, String content, String writer, int view){
//        this.title = title;
//        this.content = content;
//        this.writer = writer;
//        this.view = view;
//    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
