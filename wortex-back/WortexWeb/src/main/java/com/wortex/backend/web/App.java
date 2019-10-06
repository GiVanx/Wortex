package com.wortex.backend.web;

import com.wortex.backend.web.translator.service.TranslationService;
import com.wortex.backend.web.translator.service.TranslationServiceImpl;
import com.wortex.backend.web.translator.service.db.DbService;
import com.wortex.backend.web.translator.service.db.DbServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import yandextranslate.TranslateApiIface;
import yandextranslate.TranslationApi;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public TranslateApiIface yandexTranslateApi() {
        return TranslationApi.translateApi("//TRANSLATE API KEY");
    }

    @Bean
    public DbService dbService() {
        return new DbServiceImpl();
    }

    @Bean
    public TranslationService translationService() {
        return new TranslationServiceImpl();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        };
    }
}
