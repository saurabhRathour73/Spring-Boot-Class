package in.saurabh;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class OrderService {
 public   OrderService(){
        System.out.println("Order Service Created !! ");
    }
    public  void placeOrder(){

        System.out.println("Placed Order !! ");
    }
}
