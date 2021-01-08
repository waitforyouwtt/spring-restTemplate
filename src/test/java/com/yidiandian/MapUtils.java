package com.yidiandian;


import org.junit.platform.commons.util.StringUtils;

import java.util.Map;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
public class MapUtils {

    public static String getStringByMap(Map<String, String> map) {
        StringBuffer content = new StringBuffer();

        for (Map.Entry<String, String> entity : map.entrySet()) {
            if (StringUtils.isBlank(entity.getKey())) {
                continue;
            }
            content.append("&").append(entity.getKey()).append("=").append(entity.getValue());
        }
        return content.substring(1);
    }
}
