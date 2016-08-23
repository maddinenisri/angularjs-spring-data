package com.mdstech.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Srini on 8/23/16.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.mdstech.sample"})
public class SpringDataJpaConfig {
}
