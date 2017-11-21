package org.java.learn.util.json;

import com.alibaba.fastjson.JSON;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 作用: 使用Jackson包实现驼峰命名和下划线命名的转换
 * User: duqi Date: 2017/11/21 Time: 10:50
 */
public class JacksonCAMELTest {

    public static void main(String[] args) {
        UserInfo userInfo1 = new UserInfo(111L, "test1");
        UserInfo userInfo2 = new UserInfo(222L, "test2");
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo1);
        userInfoList.add(userInfo2);
        System.out.println(JSON.toJSONString(userInfoList));

        //驼峰命名转成下划线命名
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
            String underStr = obj2json(userInfoList);
            System.out.println(underStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //下划线JSON字符串转驼峰命名对象
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
            JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, UserInfo.class);
            String underStr = obj2json(userInfoList);
            List<UserInfo> userInfoListWithCAMEL = mapper.readValue(underStr, type);
            System.out.println(JSON.toJSONString(userInfoListWithCAMEL));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 驼峰对象转成下划线的JSON字符串
     * @param obj
     * @return
     * @throws IOException
     */
    public static String obj2json(Object obj) throws IOException {
        StringWriter writer = null;
        JsonGenerator gen = null;

        String var4;
        try {
            writer = new StringWriter();
            gen = (new JsonFactory()).createJsonGenerator(writer);
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
            mapper.writeValue(gen, obj);
            var4 = writer.toString();
        } finally {
            if (gen != null) {
                gen.close();
            }

            if (writer != null) {
                writer.close();
            }

        }

        return var4;
    }

    /**
     * 带下划线的JSON字符串，转成驼峰命名的对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T json2obj(String json, Class<T> clazz) throws IOException {
        if (json == null) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            T obj = mapper.readValue(json, clazz);
            return obj;
        }
    }
}
