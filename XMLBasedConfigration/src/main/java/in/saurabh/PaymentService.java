package in.saurabh;

public class PaymentService {



    public   String type;

  public PaymentService(String type){
        System.out.println("Payment in Process !!");
        this.type =type;
    }
    public void pay(){
        System.out.println("payment done !!");
    }
}
