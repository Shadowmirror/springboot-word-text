package top.kmirror.word.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Kmirror
 * @version 1.0
 * @className word
 * @description //TODO
 * @date 2021/6/25 18:48
 **/
@Entity
public class WordText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String wordTextName;
    private String wordTextDes;
    private String wordTableName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordTextName() {
        return wordTextName;
    }

    public void setWordTextName(String wordTextName) {
        this.wordTextName = wordTextName;
    }

    public String getWordTextDes() {
        return wordTextDes;
    }

    public void setWordTextDes(String wordTextDes) {
        this.wordTextDes = wordTextDes;
    }

    public String getWordTableName() {
        return wordTableName;
    }

    public void setWordTableName(String wordTableName) {
        this.wordTableName = wordTableName;
    }
}
