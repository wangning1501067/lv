package com.lv.system.util;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

/**
 * 生成静态页面
 * @author Administrator
 */
public class HtmlUtil {
    public static void mHtml(String oldFileStr, String oldJson, String newFileStr) throws IOException {
        File oldFile = ResourceUtils.getFile(oldFileStr);

        //读取文件
        FileReader fileReader = new FileReader(oldFile);
        String result = fileReader.readString();

        JSONObject jsonObject = JSONUtil.parseObj(oldJson);
        for (String str:jsonObject.keySet()) {
            result = result.replace("$[{"+str+"}]", jsonObject.get(str) + "");
        }

        //写入文件
        String path =System.getProperty("user.dir") + "/src/main/resources";
        File newFile = ResourceUtils.getFile(path + newFileStr);
        if(!newFile.exists()){
            newFile.createNewFile();
        }
        FileWriter writer = new FileWriter(newFile);
        writer.write(result);

        //target
        String path2 =System.getProperty("user.dir") + "/target/classes";
        File newFile2 = ResourceUtils.getFile(path2 + newFileStr);
        if(!newFile2.exists()){
            newFile2.createNewFile();
        }
        FileWriter writer2 = new FileWriter(newFile2);
        writer2.write(result);
    }
}