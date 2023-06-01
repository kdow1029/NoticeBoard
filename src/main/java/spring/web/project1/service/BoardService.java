package spring.web.project1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.web.project1.dto.BoardResDto;
import spring.web.project1.dto.BoardSaveDto;
import spring.web.project1.dto.BoardUpdateDto;
import spring.web.project1.entity.Board;
import spring.web.project1.repository.BoardRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public Long save(BoardSaveDto boardSaveDto){
        return boardRepository.save(boardSaveDto.toEntity()).getNno();
    }

    public List<Board> getList (){
        return boardRepository.findAll();
    }


    public Long update(Long nno, BoardUpdateDto boardUpdateDto){
        Board board = boardRepository.findById(nno)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"));
        board.update(boardUpdateDto.getTitle(), boardUpdateDto.getContent());

        return nno;
    }

    public void delete(Long nno){
        Board board = boardRepository.findById(nno).orElseThrow(
                () -> new IllegalStateException("해당 게시글 없음")
        );
        boardRepository.delete(board);
    }

    public BoardResDto findById(Long nno) {
        Board board = boardRepository.findById(nno).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글 없음")
                );
        return new BoardResDto(board);
    }

    public int updateView(Long nno){
        return boardRepository.updateView(nno);
    }
}
