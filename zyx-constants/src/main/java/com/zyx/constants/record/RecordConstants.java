package com.zyx.constants.record;

import com.zyx.constants.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by MrDeng on 2016/11/9.
 */
public interface RecordConstants extends Constants{

    public static int NOT_EXIST_LEVEL=60000;
    public  static String MSG_NOT_EXIST_LEVEL="not exist level";


    Map<String, Integer> LEVEL_SCORE = new ConcurrentHashMap() {{
        put("5.1",1);
        put("5.2",2);
        put("5.3",3);
        put("5.4",4);
        put("5.5",5);
        put("5.6",6);
        put("5.7",7);
        put("5.8",8);
        put("5.9",15);
        put("5.10a",25);
        put("5.10b",28);
        put("5.10c",31);
        put("5.10d",35);
        put("5.11a",40);
        put("5.11b",44);
        put("5.11c",48);
        put("5.11d",52);
        put("5.12a",60);
        put("5.12b",65);
        put("5.12c",70);
        put("5.12d",75);
        put("5.13a",82);
        put("5.13b",90);
        put("5.13c",95);
        put("5.13d",100);
        put("5.14a",110);
        put("5.14b",120);
        put("5.14c",130);
        put("5.14d",150);
        put("5.15a",180);
        put("5.15b",200);
    }};
}
