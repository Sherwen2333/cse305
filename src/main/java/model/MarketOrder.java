package model;

public class MarketOrder extends Order {
    private String buySellType;

    public String getBuySellType() {
        return buySellType;
    }

    public void setBuySellType(String buySellType) {
        this.buySellType = buySellType;
    }
}

