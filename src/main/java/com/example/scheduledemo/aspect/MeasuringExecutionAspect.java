package com.example.scheduledemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeasuringExecutionAspect {
  public static final Logger log = LoggerFactory.getLogger(MeasuringExecutionAspect.class);

  @Around("@annotation(measuringExecution)")
  public Object point(ProceedingJoinPoint joinPoint, MeasuringExecution measuringExecution)
      throws Throwable {
    final String logFormat = "Task-{}:use {} ms";
    String taskName = measuringExecution.taskName();
    long start = System.currentTimeMillis();
    Object obj = joinPoint.proceed();
    long end = System.currentTimeMillis();

    log.info(logFormat, taskName, end - start);

    return obj;
  }
}
