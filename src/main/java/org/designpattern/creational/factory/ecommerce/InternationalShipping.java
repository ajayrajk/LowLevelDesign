package org.designpattern.creational.factory.ecommerce;

/**
 * Cross-border international shipping tier.
 *
 * <p>Registered in {@link ShippingFactory} under {@link ShippingType#INTERNATIONAL}.
 * Cost: $49.99 flat. Estimated delivery: 10–15 business days.</p>
 */
public class InternationalShipping implements ShippingMethod {

    private static final double COST          = 49.99;
    private static final int    DELIVERY_DAYS = 10;  // representative lower bound of 10–15

    /** {@inheritDoc} */
    @Override
    public void ship(String orderId) {
        System.out.println("[International Shipping] Order " + orderId +
            " dispatched — international cross-border, estimated " +
            DELIVERY_DAYS + " days.");
    }

    /** @return {@code 49.99} — the flat rate for international shipping */
    @Override
    public double getCost() { return COST; }

    /** @return {@code 10} — representative lower bound of the 10–15 day window */
    @Override
    public int getEstimatedDeliveryDays() { return DELIVERY_DAYS; }
}
