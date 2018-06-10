package example;

public abstract class MovieState {
    public abstract int getPriceCode();

    double getCharge(int daysRented) {
        double result = 0;
        // determine amounts for each line

        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if(daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }
}

class RegularMovie extends MovieState {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}

class NewMovie extends MovieState {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}

class ChildrenMovie extends MovieState {
    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }
}
