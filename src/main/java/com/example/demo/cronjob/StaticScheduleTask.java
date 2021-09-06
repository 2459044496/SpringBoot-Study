package com.example.demo.cronjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
// 静态 基于注解
public class StaticScheduleTask {

/*    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        log.info("当前时间" + new Date());
    }*/

    /*@Scheduled(fixedRate = 1000)
    public void test() {
        log.info("当前时间" + new Date());
        System.out.println("执行定时任务" + new Date());
    }*/
}
