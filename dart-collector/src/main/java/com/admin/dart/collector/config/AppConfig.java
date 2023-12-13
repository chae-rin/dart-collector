package com.admin.dart.collector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

  @Bean
  public WebClient webClientForBatchAPI(WebClient.Builder webClientBuilder) {
    return webClientBuilder
      .clone()
      .baseUrl(AppConstant.APP_BATCH_BASE_URL)
      .defaultHeader(HttpHeaders.CONTENT_TYPE, AppConstant.APP_API_MIME_TYPE)
      .build();
  }

}
