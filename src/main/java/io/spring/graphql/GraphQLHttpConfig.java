package io.spring.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.server.WebGraphQlHandler;
import org.springframework.graphql.server.webmvc.GraphQlHttpHandler;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class GraphQLHttpConfig {

  // The REST API enables UNWRAP_ROOT_VALUE globally ({"user": {...}}), which would make
  // Spring GraphQL reject standard {"query": ...} request bodies, so /graphql gets its own mapper.
  @Bean
  public GraphQlHttpHandler graphQlHttpHandler(WebGraphQlHandler webGraphQlHandler) {
    return new GraphQlHttpHandler(
        webGraphQlHandler,
        new MappingJackson2HttpMessageConverter(Jackson2ObjectMapperBuilder.json().build()));
  }
}
