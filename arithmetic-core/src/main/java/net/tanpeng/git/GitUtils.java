package net.tanpeng.git;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GitUtils {
    private static final Log LOG = LogFactory.getLog(GitUtils.class);

    public static Git gitInit(String gitFolderName, String httpUri, UsernamePasswordCredentialsProvider credentialsProvider) {
        try {
            if (!Files.exists(Paths.get(gitFolderName))) {
                Git git = Git.cloneRepository()
                        .setURI(httpUri)
                        .setCredentialsProvider(credentialsProvider)
                        .setDirectory(new File(gitFolderName))
                        .call();
                git.close();
            }
            return Git.open(new File(gitFolderName));
        } catch (Exception e) {
            LOG.error("Oops!! Got error when initialize git repo", e);
            throw new RuntimeException("initialize git repo failed", e);
        }
    }

    public static void gitPull(Git git, UsernamePasswordCredentialsProvider credentialsProvider) {
        try {
            git.pull().setCredentialsProvider(credentialsProvider).call();
            if (!git.status().call().isClean()) {
                LOG.error("git pull merge conflict, git status not clean after git pull");
                throw new RuntimeException("git pull merge conflict, git status not clean after git pull");
            }
        } catch (Exception e) {
            LOG.error("git pull failed", e);
            throw new RuntimeException(e);
        }
    }

    public static void gitAdd(Git git, String filePattern) {
        try {
            git.add().addFilepattern(filePattern).call();
        } catch (Exception ex) {
            LOG.error("git add fail", ex);
            throw new RuntimeException(ex);
        }
    }

    public static void gitCommit(Git git, String msg, String authorName, String authorEmail) {
        try {
            git.commit().setAll(true).setAuthor(authorName, authorEmail).setMessage(msg).call();
        } catch (Exception ex) {
            LOG.error("git add fail", ex);
            throw new RuntimeException(ex);
        }
    }

    public static void gitPush(Git git, UsernamePasswordCredentialsProvider credentialsProvider) {
        try {
            git.push().setCredentialsProvider(credentialsProvider).setAtomic(true).call();
        } catch (Exception ex) {
            LOG.error("git add fail", ex);
            throw new RuntimeException(ex);
        }
    }

}
