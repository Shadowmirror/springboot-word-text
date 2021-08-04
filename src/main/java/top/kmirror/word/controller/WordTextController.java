package top.kmirror.word.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.kmirror.word.entity.Result;
import top.kmirror.word.entity.WordTable;
import top.kmirror.word.entity.WordText;
import top.kmirror.word.service.WordTableService;
import top.kmirror.word.service.WordTextService;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

/**
 * @author Kmirror
 * @version 1.0
 * @className WordTextController
 * @description //TODO
 * @date 2021/6/26 0:59
 **/
@RestController
@RequestMapping("/word-text")
public class WordTextController {

    private static final Logger log = LoggerFactory.getLogger(WordTextController.class);
    @Autowired
    private WordTextService wordTextService;
    @Autowired
    private WordTableService wordTableService;

    @Value("${word-text.csv-dir}")
    private String saveDir;


    @GetMapping("/all")
    public Result wordTextAll() {
        List<WordText> wordTexts = wordTextService.sendWordText();
        return new Result("成功", true, wordTexts);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @PostMapping("/upload-csv")
    public Result upload(MultipartFile file, @RequestParam String name, String des) {
        checkDirectoryIsOK();

        String randomName = UUID.randomUUID().toString();
        String csvPath = saveDir + File.separator + randomName + ".csv";
        File csv = new File(csvPath);

        try (FileOutputStream fos = new FileOutputStream(csv); InputStream inputStream = file.getInputStream()) {
            csv.createNewFile();
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            fos.write(bytes);

            //这里 可以将 文件名/对应单词表名字(fileName)/ 之类的 入库

            WordText wordText = new WordText();
            wordText.setWordTextName(name);
            wordText.setWordTextDes(des);
            wordText.setWordTableName(randomName);
            wordTextService.saveWordText(wordText);

            WordTable wordTable = new WordTable();
            wordTable.setWordTableName(randomName);
            wordTable.setWordTablePath(csvPath);
            wordTableService.saveWordTable(wordTable);

            return new Result("成功", true, randomName);
        } catch (IOException e) {
            log.error("文件保存失败", e);
            return new Result("读取保存失败", false, null);
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @GetMapping("/get-csv")
    public Result getCsv(String wordTableName) {
        String pathName = wordTableService.sendWordTablePath(wordTableName);
        if (pathName != null) {
            File file = new File(pathName);
            if (file.exists()) {
                try (FileInputStream stream = new FileInputStream(file)) {
                    byte[] bytes = new byte[stream.available()];
                    stream.read(bytes);
                    return new Result("成功", true, new String(bytes, StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                    return new Result("读取文件失败", false, null);
                }
            }
        }
        return new Result("未找到该文件", false, null);
    }

    @PostMapping("/delete-csv")
    public Result delete(@RequestParam String wordTableName) {
        String path = wordTableService.sendWordTablePath(wordTableName);
        File file = new File(path);
        Boolean isOK = file.exists();
        if (isOK) {
            file.delete();
            wordTextService.deleteWordText(wordTableName);
            wordTableService.deleteWordTable(wordTableName);
            return new Result("成功", true, "删除成功");
        }else{
            return new Result("失败", false, "未找到该文件");
        }
    }

    private void checkDirectoryIsOK() {
        File dir = new File(saveDir);
        Assert.isTrue(dir.exists(), "目录不存在");
        Assert.isTrue(dir.isDirectory(), "目录不是一个文件夹");
    }

}
