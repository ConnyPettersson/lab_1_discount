package org.example;

public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);

    @Override
    public double apply(Product product) {
        double discount = 0;
        if (isApplicable(product)) {
            discount = calculateDiscount(product);
        }

        if (nextDiscount != null) {
            discount += nextDiscount.apply(product);
        }

        return discount;
    }

    @Override
    public String getDescription(Product product) {
        String description = "";
        if (isApplicable(product)) {
            description = "Discount applies: " + calculateDiscount(product);
        }
        if (nextDiscount != null) {
            description += "\n" + nextDiscount.getDescription(product);
        }
        return description;
    }
}
