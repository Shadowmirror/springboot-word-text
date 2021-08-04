package top.kmirror.word.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kmirror.word.entity.WordText;
import top.kmirror.word.repository.WordTextRepository;
import top.kmirror.word.service.WordTextService;

import java.util.List;

/**
 * @author Kmirror
 * @version 1.0
 * @className WordTextServiceImpl
 * @description //TODO
 * @date 2021/6/26 1:11
 **/
@Service
public class WordTextServiceImpl implements WordTextService {
    @Autowired
    private WordTextRepository wordTextRepository;

    @Override
    public List<WordText> sendWordText() {
        List<WordText> wordTexts = wordTextRepository.findAll();
        return wordTexts;
    }
    @Override
    public Boolean saveWordText(WordText wordText){
        wordTextRepository.save(wordText);
        return true;
    }

    @Transactional
    @Override
    public Integer deleteWordText(String wordTableName){
        return wordTextRepository.deleteByWordTableName(wordTableName);
    }


}
