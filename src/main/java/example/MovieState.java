package example;

public abstract class MovieState {
    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);
}

class RegularMovie extends MovieState {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if(daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}

class NewMovie extends MovieState {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}

class ChildrenMovie extends MovieState {
    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if(daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
