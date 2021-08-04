package top.kmirror.word.service;

import top.kmirror.word.entity.WordTable;

public interface WordTableService {
    String  sendWordTablePath(String wordTableName);
    Boolean saveWordTable(WordTable wordTable);
    Integer deleteWordTable(String wordTableName);

}
