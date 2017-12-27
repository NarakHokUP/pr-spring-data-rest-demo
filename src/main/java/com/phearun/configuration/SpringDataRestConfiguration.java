package com.phearun.configuration;

import com.phearun.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public ResourceProcessor<Resource<Book>> bookProcessor(){
        return new ResourceProcessor<Resource<Book>>() {
            @Override
            public Resource<Book> process(Resource<Book> bookResource) {
                bookResource.add();
                return bookResource;
            }
        };
    }
}
