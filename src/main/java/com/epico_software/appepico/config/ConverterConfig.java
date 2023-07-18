package com.epico_software.appepico.config;
import com.epico_software.appepico.converters.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
    public class ConverterConfig implements WebMvcConfigurer {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new CategoryDTOToCategory());
            registry.addConverter(new CategoryToCategoryDTOConverter());
            registry.addConverter(new ItemDTOFindToItemConverter());
            registry.addConverter(new ItemDTOToItemConverter());
            registry.addConverter(new ItemToItemDTOConverter());
        }
    }

