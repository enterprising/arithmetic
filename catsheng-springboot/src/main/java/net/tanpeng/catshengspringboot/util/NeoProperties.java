package net.tanpeng.catshengspringboot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: peng.tan
 * @create: 2020/05/17 00:58
 */
@Component
public class NeoProperties {
    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;

    //省略getter settet方法

}