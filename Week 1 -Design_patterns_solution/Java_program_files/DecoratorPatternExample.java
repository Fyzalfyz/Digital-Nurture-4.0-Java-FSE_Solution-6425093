package DesignPatterns;
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier notifier = new SMSNotifier(new EmailNotifier());
        notifier.send("Your OTP is 839201");
    }
}

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        notifier.send(message);
        System.out.println("SMS: " + message);
    }
}
