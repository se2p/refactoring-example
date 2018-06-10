package example;

public abstract class MovieState {
    public abstract int getPriceCode();
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
