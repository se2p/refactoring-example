package example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        // creates listing (text output) with all available information about given customer
        double totalAmount = getTotalCharge();
        int frequentRenterPoints = getTotalFrequentRenterPoints();

        String result = "Rental Record for " + getName() + "\n";
        for(Rental each : rentals) {
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        // creates html output with all available information about given customer
        double totalAmount = getTotalCharge();
        int frequentRenterPoints = getTotalFrequentRenterPoints();

        String result = "<h1>Rental Record for " + getName() + "</h1><ul>\n";

        for(Rental each : rentals) {
            // show figures for this rental
            result += "<li>\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "</li>\n";
        }

        // add footer lines
        result += "<ul>\n<p>Amount owed is " + String.valueOf(totalAmount) + "</p>\n";
        result += "<p>You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points</p>";
        return result;
    }

    public double getTotalCharge() {
        return rentals.stream().mapToDouble(e -> e.getCharge()).sum();
    }

    public int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(e -> e.getFrequentRenterPoints()).sum();
    }
}
