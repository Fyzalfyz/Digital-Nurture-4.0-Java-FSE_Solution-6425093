package DesignPatterns;

class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor gpayAdapter = new GPayAdapter(new GPayGateway());
        gpayAdapter.processPayment(500);

        PaymentProcessor paytmAdapter = new PaytmAdapter(new PaytmGateway());
        paytmAdapter.processPayment(750);
    }
}

interface PaymentProcessor {
    void processPayment(int amountInRupees);
}

class GPayGateway {
    public void payUsingGPay(int amount) {
        System.out.println("GPay processed payment of Rs." + amount);
    }
}

class PaytmGateway {
    public void doPaytmPayment(int amount) {
        System.out.println("Paytm processed payment of Rs." + amount);
    }
}

class GPayAdapter implements PaymentProcessor {
    private GPayGateway gpay;

    public GPayAdapter(GPayGateway gpay) {
        this.gpay = gpay;
    }

    public void processPayment(int amountInRupees) {
        gpay.payUsingGPay(amountInRupees);
    }
}

class PaytmAdapter implements PaymentProcessor {
    private PaytmGateway paytm;

    public PaytmAdapter(PaytmGateway paytm) {
        this.paytm = paytm;
    }

    public void processPayment(int amountInRupees) {
        paytm.doPaytmPayment(amountInRupees);
    }
}

