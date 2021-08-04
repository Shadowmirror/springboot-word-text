package top.kmirror.word.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Kmirror
 * @version 1.0
 * @className WordTable
 * @description //TODO
 * @date 2021/6/27 11:08
 **/
@Entity
public class WordTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String wordTableName;
    private String wordTablePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordTableName() {
        return wordTableName;
    }

    public void setWordTableName(String wordTableName) {
        this.wordTableName = wordTableName;
    }

    public String getWordTablePath() {
        return wordTablePath;
    }

    public void setWordTablePath(String wordTablePath) {
        this.wordTablePath = wordTablePath;
    }
}

