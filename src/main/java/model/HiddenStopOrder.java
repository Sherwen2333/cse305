package model;

public class HiddenStopOrder extends Order {
    private double pricePerShare;

    public double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }
}
