package net.tanpeng.java.yaml;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.util.*;

/**
 * Created by peng.tan on 18/1/30.
 */
public class SnakeYamlTest {
    public static List<Schema> schemas = new ArrayList<>();

    public static void main(String[] args) {
        loadCfg("./arithmetic-core/src/main/java/net/tanpeng/arithmetic/yaml/test.yaml");
        for (Schema s : schemas) {
            System.out.println(s);
        }
    }

    // 写入文件
    public void testDumpWriter() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Silenthand Olleander");
        data.put("race", "Human");
        data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });

        Yaml yaml = new Yaml();
        FileWriter writer = new FileWriter("/path/to/file.yaml");
        yaml.dump(data, writer);
    }


    public static List<Schema> load(InputStream fileInputStream) {
        Yaml yaml = new Yaml(new Constructor(Schema.class));
        Iterator<Object> iterator = yaml.loadAll(fileInputStream).iterator();
        List<Schema> schemas = new LinkedList<>();

        while (iterator.hasNext()) {
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
        private boolean skip = false;
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

        public boolean isSkip() {
            return skip;
        }

        public void setSkip(boolean skip) {
            this.skip = skip;
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
            sb.append(",skip=").append(skip).append("\'");
            sb.append(", allow=").append(allow);
            sb.append('}');
            return sb.toString();
        }
    }

}
