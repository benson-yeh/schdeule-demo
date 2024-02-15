package com.example.scheduledemo;

import com.example.scheduledemo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ScheduleDemoApplicationTests {

  @Autowired AnnotationConfigApplicationContext context;

  @Test
  void contextLoads() {
    var bean = context.getBean(TaskService.class);
    assertNotNull(bean);
  }
}
