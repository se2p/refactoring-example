package example;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private MovieState movieState;

    // regular movie or for children or ...
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return movieState.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch(priceCode) {
            case REGULAR:
                movieState = new RegularMovie();
                break;
            case NEW_RELEASE:
                movieState = new NewMovie();
                break;
            case CHILDREN:
                movieState = new ChildrenMovie();
                break;
            default:
                throw new IllegalArgumentException("Illegal pricecode");
        }
    }

    public String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return movieState.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

}
