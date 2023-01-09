package org.example.javaer;

import com.alibaba.fastjson.JSONObject;
import com.sun.codemodel.internal.JCatchBlock;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.concurrent.Executor;

/**
 * @author: liuxuan
 * @date: 2022-04-30 13:46
 **/
public class JsonTest {
    @Test
    public void TestJ(){
        try{
            File jsonFile = ResourceUtils.getFile("classpath:hello.json");
            String s = FileUtils.readFileToString(jsonFile);
            System.out.println("s:"+s);
        } catch(Exception e) {
            System.out.println("error:"+e);
        }
    }

    @Test
    public void test2() {
        JSONObject json = new JSONObject();
        json.put("key","11");
        System.out.println(json.getInteger("key"));
    }
}
