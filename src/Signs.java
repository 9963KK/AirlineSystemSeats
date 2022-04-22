public enum Signs {
    PAYMENT("PRICE"),
    SEATS("SEAT");
    private String sign;

    Signs(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
