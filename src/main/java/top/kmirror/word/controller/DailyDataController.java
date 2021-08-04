package top.kmirror.word.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kmirror.word.entity.DailyData;
import top.kmirror.word.entity.Result;
import top.kmirror.word.service.DailyDataService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

/**
 * @author Kmirror
 * @version 1.0
 * @className DailyDataController
 * @description //TODO
 * @date 2021/6/29 9:13
 **/
@RestController
@RequestMapping("/dailyData")
public class DailyDataController {
    @Autowired
    DailyDataService dailyDataService;

    @GetMapping("/all")
    public Result all() {
        List<DailyData> all = dailyDataService.getAll();

        return new Result("成功", true, all);
    }

    @PostMapping("/update")
    public Result dailyData(long time, int finishWordsCount, int wrongWordsCount) {
        DailyData dailyData = new DailyData();
        dailyData.setTime(time);
        dailyData.setFinishWordsCount(finishWordsCount);
        dailyData.setWrongWordsCount(wrongWordsCount);
        Boolean isOK = dailyDataService.saveDailyData(dailyData);
        return new Result("成功", isOK, dailyData);
    }
}
