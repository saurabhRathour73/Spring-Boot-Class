package in.saurabh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    // mujhe iski koiii need nhi haii
//    @Autowired
//    private  OrderService orderService;


//    public PaymentService(OrderService orderService){
//        this.orderService = orderService;
//    }

    public void pay(){
        System.out.println("Payment Done Successfully !! ");
        // not its responsiblity
//        orderService.getOrderDetails();

        // iska kam sirf payment handle karna haii
    }
}
