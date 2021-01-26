package com.cashbang.orderserviceprovider.sourceloader;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huangdj
 * @Date: 2021/1/21
 */
public class JsonPropertySourceLocator implements PropertySourceLocator {

    private final static String DEFAULT_LOCATION = "classpath:app.json";

    private final ResourceLoader resourceLoader = new DefaultResourceLoader(this.getClass().getClassLoader());

    @Override
    public PropertySource<?> locate(Environment environment) {
        JsonPropertySource jsonPropertySource =
                new JsonPropertySource("jsonPropertyConfig",mapPropertySource());
        return jsonPropertySource;
    }

    private Map<String, Object> mapPropertySource() {
        Resource resource = this.resourceLoader.getResource(DEFAULT_LOCATION);
        if(resource == null){
            return null;
        }
        Map<String,Object> result = new HashMap<>();
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String,Object> fileMap = jsonParser.parseMap(readFile(resource));
        processorMap("",result,fileMap);
        return result;
    }

    private void processorMap(String prefix, Map<String, Object> result, Map<String, Object> fileMap) {
        if(prefix.length() > 0){
            prefix += ".";
        }
        for(Map.Entry<String,Object> entrySet:fileMap.entrySet()){
            if(entrySet.getValue() instanceof Map){
                processorMap(prefix+entrySet.getKey(),result, (Map<String, Object>) entrySet.getValue());
            }else{
                result.put(prefix+entrySet.getKey(),entrySet.getValue());
            }
        }
    }

    /**
     * Json格式
     * @param resource
     * @return
     */
    private String readFile(Resource resource) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(resource.getFile());
            byte[] readByte = new byte[(int) resource.getFile().length()];
            fis.read(readByte);
            return new String(readByte,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
