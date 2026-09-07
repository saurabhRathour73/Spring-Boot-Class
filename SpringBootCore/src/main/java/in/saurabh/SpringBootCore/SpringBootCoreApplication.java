package in.saurabh.SpringBootCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {

       ApplicationContext context = SpringApplication.run(SpringBootCoreApplication.class, args);
       OrderService orderService= context.getBean(OrderService.class);
       orderService.placeOrder();
	}

    @Bean
    public UserService getUserServiveBean(){
        return  new UserService();
    }

}


