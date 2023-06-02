package spring.web.project1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.web.project1.dto.BoardResDto;
import spring.web.project1.dto.CommentReqDto;
import spring.web.project1.dto.CommentResDto;
import spring.web.project1.entity.Board;
import spring.web.project1.entity.Comment;
import spring.web.project1.repository.CommentRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardService boardService;

    public Long commentSave(Long nno, CommentReqDto reqDto){
        boardService.findById(nno);
        return   commentRepository.save(reqDto.toEntity()).getId();
    }

    public CommentResDto findById(Long id) {
        Comment comment =  commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없음"));

        return new CommentResDto(comment);
    }
}
