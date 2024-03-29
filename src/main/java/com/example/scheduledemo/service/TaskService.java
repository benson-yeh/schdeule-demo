package com.example.scheduledemo.service;

import com.example.scheduledemo.aspect.MeasuringExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;

@Service
@Component("123")
public class TaskService {

  public static final Logger log = LoggerFactory.getLogger(TaskService.class);
  @Autowired TaskScheduler scheduler1;

  @Autowired TaskScheduler scheduler2;

  @PostConstruct
  public void registerTask() {

    Runnable task =
        () -> {
          log.info(Thread.currentThread().getName());
          log.info("task1 start");
          try {
            Thread.sleep(10000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          log.info("task1 end");
        };
    scheduler1.scheduleWithFixedDelay(task, Duration.ofSeconds(10));
  }

  @MeasuringExecution(taskName = "123")
  @Scheduled(fixedDelay = 1000L)
  public void defaultTask() {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log.info("defaultTask");
  }

  @MeasuringExecution(taskName = "456")
  @Scheduled(fixedDelay = 1000L)
  public void defaultTask2() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log.info("defaultTask");
  }
}
