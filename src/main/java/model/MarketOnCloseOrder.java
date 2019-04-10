package model;

public class MarketOnCloseOrder extends Order {
    private String buySellType;

    public String getBuySellType() {
        return buySellType;
    }

    public void setBuySellType(String buySellType) {
        this.buySellType = buySellType;
    }
}

