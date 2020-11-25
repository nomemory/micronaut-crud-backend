package net.andreinc.mn.crud.backend;
import io.micronaut.context.annotation.Bean;
import io.micronaut.runtime.Micronaut;
import org.modelmapper.ModelMapper;

import javax.inject.Singleton;

public class Application {

    @Singleton
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
