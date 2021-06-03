package com.lv.system.common;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class Load {
    public static Map<String, String> accountMap = Maps.newHashMap();

    @PostConstruct
    public void loadAccount(){
        accountMap.put("admin", "123456");
    }
}
