package com.lv.system.common;

import com.lv.system.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Set;

@Slf4j
public class BaseController {

    /**
     * 获取用户
     */
    public boolean verUser(LoginUser loginUser){
        Map<String, String> accountMap = Load.accountMap;
        Set<String> usernameSet = accountMap.keySet();
        if(!usernameSet.contains(loginUser.getUsername())){
            log.info("===用户名错误===");
            return false;
        }
        if(StringUtils.isEmpty(accountMap.get(loginUser.getUsername()) + "")){
            log.info("===密码错误===");
            return false;
        }
        return true;
    }
}
