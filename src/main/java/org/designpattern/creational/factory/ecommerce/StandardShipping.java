package org.designpattern.creational.factory.ecommerce;

/**
 * Economy ground shipping tier.
 *
 * <p>Registered in {@link ShippingFactory} under {@link ShippingType#STANDARD}.
 * Cost: $5.99 flat. Estimated delivery: 5–7 business days.</p>
 */
public class StandardShipping implements ShippingMethod {

    private static final double COST          = 5.99;
    private static final int    DELIVERY_DAYS = 5;   // representative lower bound of 5–7

    /**
     * {@inheritDoc}
     * Prints a standard-shipping confirmation that includes the order identifier.
     *
     * @param orderId the order identifier to include in the confirmation; must not be null
     */
    @Override
    public void ship(String orderId) {
        System.out.println("[Standard Shipping] Order " + orderId +
            " dispatched — economy ground, estimated " + DELIVERY_DAYS + " days.");
    }

    /** @return {@code 5.99} — the flat rate for standard shipping */
    @Override
    public double getCost() { return COST; }

    /** @return {@code 5} — representative lower bound of the 5–7 day window */
    @Override
    public int getEstimatedDeliveryDays() { return DELIVERY_DAYS; }
}
