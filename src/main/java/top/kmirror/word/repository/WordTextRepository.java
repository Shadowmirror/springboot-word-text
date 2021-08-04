package top.kmirror.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.kmirror.word.entity.WordTable;
import top.kmirror.word.entity.WordText;

import java.util.List;

public interface WordTextRepository extends JpaRepository<WordText, Integer> {
    List<WordText> findAll();
    Integer deleteByWordTableName(String wordTableName);
}
