
/**
 *
 * @author Fyzal
 */
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment("Fyzal", "4111-1111-1111-1111"));
        context.pay(250.0);

        context.setStrategy(new UpiPayment("fyzal@upi"));
        context.pay(120.5);
    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardHolderName;
    private String cardNumber;

    public CreditCardPayment(String cardHolderName, String cardNumber) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card by " + cardHolderName);
    }
}

class UpiPayment implements PaymentStrategy {
    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    public void pay(double amount) {
        System.out.println("Paid Rs" + amount + " using UPI ID " + upiId);
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.pay(amount);
    }
}

