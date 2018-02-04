package net.tanpeng.arithmetic.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用 CompletionService，实现页面渲染
 * 使得页面元素在下载完成后立即显示出来
 * <p>
 * CompletionService 由 Executor和 BlockingQueue 组成
 */
public class CompletionServiceDemo {
    private final ExecutorService executor;

    public CompletionServiceDemo(ExecutorService executor) {
        this.executor = executor;
    }

    public void renderPage(CharSequence source) throws InterruptedException, ExecutionException {
        List<Object> infos = getInfo();
        CompletionService completionService = new ExecutorCompletionService(executor);
        infos.forEach(info -> completionService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                return 1;
            }
        }));

        for (int i = 0; i < infos.size(); i++) {
            Future f = completionService.take();
            Object x = f.get();
            // do sth with x
        }

    }

    public List<Object> getInfo() {
        Object info = new Object();
        List list = new ArrayList();
        list.add(info);
        return list;
    }
}