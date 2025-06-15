

/**
 *
 * @author Fyzal
 */
import java.util.*;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setPrice("TATA", 840.5);
        stockMarket.setPrice("RELIANCE", 2512.3);

        stockMarket.deregister(webApp);

        stockMarket.setPrice("INFY", 1540.0);
    }
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers(String stock, double price);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private Map<String, Double> stockPrices = new HashMap<>();

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String stock, double price) {
        for (Observer o : observers) {
            o.update(stock, price);
        }
    }

    public void setPrice(String stock, double price) {
        stockPrices.put(stock, price);
        notifyObservers(stock, price);
    }
}

interface Observer {
    void update(String stock, double price);
}

class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    public void update(String stock, double price) {
        System.out.println(name + " received update: " + stock + " = " + price);
    }
}

class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    public void update(String stock, double price) {
        System.out.println(name + " received update: " + stock + " = " + price);
    }
}
