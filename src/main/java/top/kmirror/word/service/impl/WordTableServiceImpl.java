package top.kmirror.word.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kmirror.word.entity.WordTable;
import top.kmirror.word.entity.WordText;
import top.kmirror.word.repository.WordTableRepository;
import top.kmirror.word.service.WordTableService;

/**
 * @author Kmirror
 * @version 1.0
 * @className WordTableServiceImpl
 * @description //TODO
 * @date 2021/6/27 11:17
 **/
@Service
public class WordTableServiceImpl implements WordTableService {
    @Autowired
    private WordTableRepository wordTableRepository;

    @Override
    public String sendWordTablePath(String wordTableName) {
        WordTable wordTable = wordTableRepository.findWordTableByWordTableName(wordTableName);
        return wordTable != null ? wordTable.getWordTablePath() : null;
    }

    @Override
    public Boolean saveWordTable(WordTable wordTable) {
        wordTableRepository.save(wordTable);
        return true;
    }

    @Transactional
    @Override
    public Integer deleteWordTable(String wordTableName) {
        return wordTableRepository.deleteByWordTableName(wordTableName);
    }
}
