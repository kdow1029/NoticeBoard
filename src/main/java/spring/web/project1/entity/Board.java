package spring.web.project1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nno;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Builder
    public Board(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
