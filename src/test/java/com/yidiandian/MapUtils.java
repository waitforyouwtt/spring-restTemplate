package com.yidiandian;


import org.junit.platform.commons.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static Date date = new Date();
    private static StringBuilder buf = new StringBuilder();
    private static int seq = 0;
    private static final int ROTATION = 99999;

    public static synchronized long next() {
        if (seq > ROTATION)
            seq = 0;
        buf.delete(0, buf.length());
        date.setTime(System.currentTimeMillis());
        String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);
        return Long.parseLong(str);
    }

    private MapUtils(){

    }

    public static String randomUUID() {
        return java.util.UUID.randomUUID().toString();
    }

    public static String fyFormatDate() {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMDDHHmmddSSS");
        String sDate = f.format(new Date());
        return sDate;
    }
}
