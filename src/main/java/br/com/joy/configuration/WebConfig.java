package br.com.joy.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> customCharacterEncodingFilter() {
        FilterRegistrationBean<CharacterEncodingFilter> registrationBean = new FilterRegistrationBean<>();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding(StandardCharsets.ISO_8859_1.name());
        filter.setForceEncoding(true);
        registrationBean.setFilter(filter);
        return registrationBean;
    }
}
