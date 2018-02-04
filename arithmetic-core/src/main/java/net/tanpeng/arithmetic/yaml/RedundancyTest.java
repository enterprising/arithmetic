package net.tanpeng.arithmetic.yaml;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * 测试SnackYaml解析yaml时，yaml有冗余字段时是否会报错
 * 测试结果：会有影响
 * Created by peng.tan on 18/1/31.
 */
public class RedundancyTest {
    public static List<Schema> schemas = new ArrayList<>();

    public static void main(String[] args) {
        loadCfg("./arithmetic-core/src/main/java/yaml/test.yaml");
        for (Schema s : schemas) {
            System.out.println(s);
        }
        System.out.println();

    }

    public static List<Schema> load(InputStream fileInputStream) {
        Yaml yaml = new Yaml(new Constructor(Schema.class));
        Iterator<Object> iterator = yaml.loadAll(fileInputStream).iterator();
        List<Schema> schemas = new LinkedList<>();

        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(iterator.next());
            Schema schema = (Schema) iterator.next();
            schemas.add(schema);
        }
        return schemas;
    }

    public static void loadCfg(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                return;
            }
            if (!file.canRead()) {
                return;
            }
            schemas = load(new FileInputStream(file));
            System.out.println();
        } catch (Exception e) {
        }
    }


    public static class Schema {
        private String group = "";
        private List<String> allow = Collections.emptyList();

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public List<String> getAllow() {
            return allow;
        }

        public void setAllow(List<String> allow) {
            if (Objects.isNull(allow)) {
                return;
            }
            //snake yaml会把list中的空字符串解析为null装入ArrayList
            //ArrayList不拒绝null值,在此处需要过滤掉null避免使用方产生NPE
            allow.removeIf(Objects::isNull);
            this.allow = allow;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Schema{");
            sb.append("group='").append(group).append('\'');
            sb.append(", allow=").append(allow);
            sb.append('}');
            return sb.toString();
        }
    }
}
