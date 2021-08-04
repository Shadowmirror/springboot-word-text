package top.kmirror.word.service;

import top.kmirror.word.entity.WordText;

import java.util.List;

public interface WordTextService {
    List<WordText> sendWordText();
    Boolean saveWordText(WordText wordText);
    Integer deleteWordText(String wordTableName);

}
