package com.cashbang.orderserviceprovider.jsonloader;

import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * 使用application.json文件
 * 基于springboot中的spi机制
 * @Author: huangdj
 * @Date: 2021/1/21
 */
public class JsonPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        //配置文件格式扩展格式
        return new String[]{"json"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        //处理机制参考PropertiesPropertySourceLoader
        //无论profile有没有值，底层都会尝试先执行 load(String name,Resource resource,null)
        Map<String,Object> result = mapPropertySource(resource);
        return Collections
                .singletonList(new OriginTrackedMapPropertySource(name, Collections.unmodifiableMap(result), true));

    }

    private Map<String, Object> mapPropertySource(Resource resource) throws IOException {
        if(resource == null){
            return null;
        }
        String fileResult = readFile(resource);
        Map<String,Object> result = new HashMap<>();
        JsonParser parser = JsonParserFactory.getJsonParser();
        Map<String,Object> map = parser.parseMap(fileResult);
        nestMap("",result,map);
        return result;
    }

    /**
     * 处理map（map中可能还嵌套map，递归处理），最终输出一个非嵌套的map
     * @param prefix
     * @param result
     * @param map
     */
    private void nestMap(String prefix, Map<String, Object> result, Map<String, Object> map) {
        if(prefix.length() > 0){
            prefix += ".";
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if(entry.getValue() instanceof Map){
                nestMap(prefix+entry.getKey(),result, (Map<String, Object>) entry.getValue());
            }else {
                result.put(prefix+entry.getKey(),entry.getValue());
            }
        }
    }

    private String readFile(Resource resource) throws IOException {
        FileInputStream fis = new FileInputStream(resource.getFile());
        List<Byte> bytes = new LinkedList<Byte>();
        byte[] readByte = new byte[1024];
        int length;
        while ((length = fis.read(readByte)) > 0){
            for (int i = 0; i < length; i++) {
                bytes.add(readByte[i]);
            }
        }
        byte[] allBytes = new byte[bytes.size()];
        int index = 0;
        for (Byte aByte : bytes) {
            allBytes[index] = aByte;
            index += 1;
        }
        return new String(allBytes,"UTF-8");
    }
}
