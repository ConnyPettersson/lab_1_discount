package org.example;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 20, 8);
        Product bread = new Product("Bread", 30, 2);

        Discount discountChain = new FridayDiscount(
                new MilkDiscount(
                        new QuantityDiscount(null)
                )
        );

        System.out.println("\nMilk discounts:");
        System.out.println(discountChain.getDescription(milk));
        double milkDiscount = discountChain.apply(milk);
        System.out.println("\nTotal discount for milk: " + milkDiscount + " kr.");

        System.out.println("\nBread discounts:");
        System.out.println(discountChain.getDescription(bread));
        double breadDiscount = discountChain.apply(bread);
        System.out.println("Total discount for bread: " + breadDiscount + " kr.");
    }
}