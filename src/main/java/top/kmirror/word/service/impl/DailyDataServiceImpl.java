package top.kmirror.word.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kmirror.word.entity.DailyData;
import top.kmirror.word.repository.DailyDataRepository;
import top.kmirror.word.service.DailyDataService;

import java.util.List;


/**
 * @author Kmirror
 * @version 1.0
 * @className DailyDataServiceImpl
 * @description //TODO
 * @date 2021/6/29 9:03
 **/
@Service
public class DailyDataServiceImpl implements DailyDataService {
    @Autowired
    private DailyDataRepository dailyDataRepository;

    @Override
    public List<DailyData> getAll() {
        return dailyDataRepository.findAll();
    }

    @Override
    public Boolean saveDailyData(DailyData dailyData) {
        DailyData data = dailyDataRepository.findByTime(dailyData.getTime());
        if(data != null){
            data.setFinishWordsCount(dailyData.getFinishWordsCount());
            data.setWrongWordsCount(dailyData.getWrongWordsCount());
            return dailyDataRepository.save(data) != null ;
        }else {

            return dailyDataRepository.save(dailyData) != null;
        }

    }
}
