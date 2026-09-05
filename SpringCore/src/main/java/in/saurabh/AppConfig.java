package in.saurabh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("in.saurabh")
public class AppConfig {

    @Bean
    public  User createUser(){
        return  new User("Saurabh", 21);
    }

}
