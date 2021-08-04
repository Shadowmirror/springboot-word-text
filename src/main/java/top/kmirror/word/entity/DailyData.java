package top.kmirror.word.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.PrintWriter;

/**
 * @author Kmirror
 * @version 1.0
 * @className DailyData
 * @description //TODO
 * @date 2021/6/29 8:35
 **/

@Entity
public class DailyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long time;
    private int finishWordsCount;
    private int wrongWordsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getFinishWordsCount() {
        return finishWordsCount;
    }

    public void setFinishWordsCount(int finishWordsCount) {
        this.finishWordsCount = finishWordsCount;
    }

    public int getWrongWordsCount() {
        return wrongWordsCount;
    }

    public void setWrongWordsCount(int wrongWordsCount) {
        this.wrongWordsCount = wrongWordsCount;
    }
}
