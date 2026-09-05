package in.saurabh;

import in.saurabh.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private final PaymentService paymentService ;

    // ---------=> using construction injection (spring framework me agar apke pass ek hi construction haii to Autowired likhne ki need nhi haii)
    @Autowired
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    // --------------------=>  using seter injection
//    @Autowired
//    public void setPaymentService(PaymentService paymentService){
//        this.paymentService = paymentService;
//    }

    // ----------------=> using field injection
//    @Autowired
//    PaymentService paymentService;
    // but field injection not recommended



    public void orderPlaced(){
        paymentService.pay();
        System.out.println(" Order Placed !! ");
    }
}
