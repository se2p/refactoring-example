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
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";
        for(Rental each : rentals) {

            double thisAmount = each.getCharge();

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        // creates html output with all available information about given customer
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "<h1>Rental Record for " + getName() + "</h1><ul>\n";

        for(Rental each : rentals) {
            double thisAmount = each.getCharge();

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "<li>\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "</li>\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "<ul>\n<p>Amount owed is " + String.valueOf(totalAmount) + "</p>\n";
        result += "<p>You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points</p>";
        return result;
    }
}
