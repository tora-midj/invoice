package jp.co.systena.tora.webjava.mid.api.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import jp.co.systena.tora.webjava.mid.api.interceptor.InvoiceRequestInterceptor;

/**
 * The Class InvoiceConfing.
 */
@Configuration
public class InvoiceConfing extends WebMvcConfigurerAdapter {

    /**
     * Invoice request interceptor.
     *
     * @return the invoice request interceptor
     */
    @Bean
    public InvoiceRequestInterceptor invoiceRequestInterceptor() {
        return new InvoiceRequestInterceptor();
    }

    /**
     * Interceptor.
     *
     * @return the mapped interceptor
     */
    @Bean
    public MappedInterceptor interceptor() {
        return new MappedInterceptor(new String[] { "/**" },
                invoiceRequestInterceptor());
    }

    /**
     * Mapping jackson 2 http message converter.
     * RestControllerで返却するJSONフォーマットを設定.
     *
     * @return the mapping jackson 2 http message converter
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder //
                .json()
                .indentOutput(true)
                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .build();

        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

    /* (非 Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#extendMessageConverters(java.util.List)
     */
    @Override
    public void extendMessageConverters(
            final List<HttpMessageConverter<?>> converters) {
        converters.add(0, mappingJackson2HttpMessageConverter());
    }

}
