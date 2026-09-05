package in.saurabh;

public class CardPaymentMode implements PaymentMode {
    @Override
    public void pay() {
        System.out.println("Paying via Card !! ");
    }
}
