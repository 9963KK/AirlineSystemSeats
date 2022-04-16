public enum Price {
    FIRST_CLASS(1000),
    SECOND_CLASS(500);

    private int price;

    Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
