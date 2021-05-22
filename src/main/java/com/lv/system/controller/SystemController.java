package com.lv.system.controller;

import com.lv.system.util.HtmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("system")
@Slf4j
public class SystemController {

    String strJson = "{'userName':'王宁','password':'123456'}";
    String filePath = "classpath:static/temp/aaa.html";
    String newFile = "/static/html/" + System.currentTimeMillis() + ".html";

    @GetMapping("/createHtml")
    public void CreateHtml() throws IOException {
        log.info("================生成开始=============");
        HtmlUtil.mHtml(filePath ,strJson, newFile);
        log.info("================生成结束=============");
    }
}
