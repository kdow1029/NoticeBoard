package spring.web.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.web.project1.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
