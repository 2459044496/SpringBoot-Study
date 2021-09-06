package com.example.demo.cronjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Slf4j
@Component
// 动态配置定时任务，基于SchedulingConfigurer接口
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                () -> {
                    log.info("模块启动。。。");
                    // do XXX
                },
                triggerContext -> {
                    // 这里可以从数据库获取cron表达式
                    return new CronTrigger("0/7 * * * * ?").nextExecutionTime(triggerContext);
                }
        );
    }
}
