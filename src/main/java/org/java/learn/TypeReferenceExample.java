package org.java.learn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * 作用: User: duqi Date: 2017/10/25 Time: 13:42
 */
public class TypeReferenceExample {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        System.out.println(JSON.toJSONString(map));

        String jsonStr = JSON.toJSONString(map);

        Map<String, String> map2 = JSON.parseObject(jsonStr, new TypeReference<Map<String, String>>() {
        });
        System.out.println(JSON.toJSONString(map2));
    }
}
