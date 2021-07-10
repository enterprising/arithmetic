package net.tanpeng.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by peng.tan on 2021/7/10 8:00 下午
 */
public class JackSonUtil {

    public void toModuleOrList() throws IOException {
        // 根据字符串
        String appJson = "{}";
        ObjectMapper objectMapper = new ObjectMapper();
        UserTemp user = objectMapper.readValue(appJson, UserTemp.class);
        List<UserTemp> users = objectMapper.readValue(appJson, new TypeReference<List<UserTemp>>() {
        });


        // 根据文件
        UserTemp user2 = objectMapper.readValue(new File("a.json"), UserTemp.class);
        List<UserTemp> users2 = objectMapper.readValue(new File("a.json"), new TypeReference<List<UserTemp>>() {
        });
    }


    public void getJSONNode() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("xx.json"));

        for (JsonNode cur : rootNode) {
            if ("true".equalsIgnoreCase(cur.get("status").asText())) {
                continue;
            }
            if (cur.get("cause").asText().contains("xxx")) {
                continue;
            }
        }
    }

    @Data
    private class UserTemp {
        // add param
    }
}
