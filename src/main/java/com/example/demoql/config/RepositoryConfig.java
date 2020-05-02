package com.example.demoql.config;

import com.example.demoql.entity.Book;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestHandlerAdapter;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Book.class);
    }

}
