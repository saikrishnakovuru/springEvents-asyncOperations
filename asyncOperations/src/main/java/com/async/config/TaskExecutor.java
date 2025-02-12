package com.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class TaskExecutor {

  @Bean("asyncTaskExecutor")
  public Executor asyncTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(4);
    executor.setQueueCapacity(150);
    executor.setMaxPoolSize(4);
    executor.setThreadNamePrefix("asyncThread - ");
    executor.initialize();
    return executor;
  }
}
