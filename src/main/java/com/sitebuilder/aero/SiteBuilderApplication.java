package com.sitebuilder.aero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * @author pbonansea
 *
 */
@ComponentScan
@EnableMongoRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class SiteBuilderApplication {

    /**
     * @param args Application arguments
     */
    public static void main(final String[] args) {

        SpringApplication.run(SiteBuilderApplication.class, args);

    }

    /**
     * Return app name.
     * @return App name
     */
    public String getName() {
        return "sitebuilder";
    }

}
