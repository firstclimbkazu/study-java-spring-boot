package demo.domain.adapter;

import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncProcessAdapter {
    protected final static Logger log = LoggerFactory.getLogger(AsyncProcessAdapter.class);

    @Async("Thread2")
    public CompletableFuture<String> findName(String name, Long sleepTime) throws InterruptedException {
        log.warn("Async function started. processName: " + name + "sleepTime: " + sleepTime);
        Thread.sleep(sleepTime);

        // 非同期処理のハンドリングができるようにCompletableFutureに実際に使いたい返却値をぶっこんで利用する
        return CompletableFuture.completedFuture(name);
    }

}