package spring.web.project1.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "comment")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseTimeEntity {

    @Id
    @Column(name = "comments_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "board_nno")
    private Board board;

}
