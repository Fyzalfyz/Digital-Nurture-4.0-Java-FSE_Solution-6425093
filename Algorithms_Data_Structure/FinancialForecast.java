/**
 *
 * @author Fyzal
 */
public class FinancialForecast {

    public static double forecast(double amount, double rate, int year) {
        if (year == 0) {
            return amount;
        } else {
            double updated = amount * (1 + rate);
            return forecast(updated, rate, year - 1);
        }
    }

    public static void main(String[] args) {
        double value = 10000;
        double growth = 0.3;
        int years = 7;

        double result = forecast(value, growth, years);
        System.out.println("After " + years + " years: Rs." + (int)result);
    }
}
