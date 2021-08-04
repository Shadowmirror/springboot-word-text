package top.kmirror.word.service;

import top.kmirror.word.entity.DailyData;

import java.util.List;


public interface DailyDataService {
//    DailyData updateDailyData(Date time, int finishWordCount, int wrongWordCount);
    Boolean saveDailyData(DailyData dailyData);
    List<DailyData> getAll();
}
