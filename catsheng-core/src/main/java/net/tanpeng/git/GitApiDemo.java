package net.tanpeng.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

/**
 * Created by peng.tan on 2019/8/26.
 */
public class GitApiDemo {
    public static void main(String[] args) {
        // 支持gitlab v3，这里输入private token就好了，username是用户名，不带邮箱后缀
        UsernamePasswordCredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider("xx","xx");
        Git git = GitUtils.gitInit("rebalance-prod","http://xxxx/rebalance-prod.git",
                credentialsProvider);
        GitUtils.gitPull(git,credentialsProvider);
    }
}
