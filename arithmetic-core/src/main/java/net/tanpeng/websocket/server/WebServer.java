package net.tanpeng.websocket.server;

import io.netty.channel.Channel;

import java.util.*;

/**
 * Created by peng.tan on 2018/11/10.
 */
public class WebServer {
    private Map<String, Channel> bossChannels = new HashMap<>();

    public int numUniqueEmails(String[] emails) {
        Set<String> useEmails = new HashSet<>();
        for (String emial : emails) {
            String tail = emial.split("@")[1];
            String head = emial.split("@")[0];
            head.split("\\.|\\+");
        }
        return useEmails.size();
    }

    public static void main(String[] args) {
//        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
