package org.example;

public class QuantityDiscount extends BaseDiscount {
    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getQuantity() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        int quantityDiscount = 5;
        return 10.0 * product.getQuantity();
    }

    @Override
    protected String getCurrentDescription(Product product) {
        return "10 kr per product for quantity of 5 or more";
    }
}
