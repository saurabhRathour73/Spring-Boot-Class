package in.saurabh;

public class UPIpaymentMode implements PaymentMode {
    @Override
    public void pay(){
        System.out.println("Paying UPI !!");
    }
}
