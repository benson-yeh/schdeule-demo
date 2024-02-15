package com.example.scheduledemo.confg;

import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class SchedulerConfig {

  @Bean
  public TaskScheduler scheduler1() {

   return new TaskSchedulerBuilder().threadNamePrefix("custom-scheduler").build();
  }

  @Bean
  public TaskScheduler scheduler2() {
    return new TaskSchedulerBuilder().threadNamePrefix("scheduler2").build();
  }

  @Bean
  public TaskScheduler taskScheduler() {
    return new TaskSchedulerBuilder().threadNamePrefix("default-scheduler").build();
  }
}
