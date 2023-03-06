package cn.cuiper.cronjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@Slf4j
// 多线程定时任务
public class MultiThreadScheduleTask {

    @Async
    @Scheduled(cron = "0/2 * * * * ?")
    public void first() {
        log.info("任务1每隔两秒执行一次");
    }

    @Async
    @Scheduled(cron = "0/3 * * * * ?")
    public void second() {
        log.info("任务2每隔三秒执行一次");
    }
}
