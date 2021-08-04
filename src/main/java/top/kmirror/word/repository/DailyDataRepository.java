package top.kmirror.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.kmirror.word.entity.DailyData;

import java.util.List;


public interface DailyDataRepository extends JpaRepository<DailyData, Integer> {
    DailyData findByTime(long time);
    List<DailyData> findAll();
}
