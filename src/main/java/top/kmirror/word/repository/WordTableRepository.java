package top.kmirror.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.kmirror.word.entity.WordTable;

public interface WordTableRepository extends JpaRepository<WordTable, Integer> {
    WordTable findWordTableByWordTableName(String wordTableName);
    Integer deleteByWordTableName(String wordTableName);
}
