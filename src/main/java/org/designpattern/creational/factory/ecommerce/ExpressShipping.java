package org.designpattern.creational.factory.ecommerce;

/**
 * Accelerated 2–3 day shipping tier.
 *
 * <p>Registered in {@link ShippingFactory} under {@link ShippingType#EXPRESS}.
 * Cost: $15.99 flat. Estimated delivery: 2–3 business days.</p>
 */
public class ExpressShipping implements ShippingMethod {

    private static final double COST          = 15.99;
    private static final int    DELIVERY_DAYS = 2;

    /** {@inheritDoc} */
    @Override
    public void ship(String orderId) {
        System.out.println("[Express Shipping] Order " + orderId +
            " dispatched — express delivery, estimated " + DELIVERY_DAYS + " days.");
    }

    /** @return {@code 15.99} — the flat rate for express shipping */
    @Override
    public double getCost() { return COST; }

    /** @return {@code 2} — representative lower bound of the 2–3 day window */
    @Override
    public int getEstimatedDeliveryDays() { return DELIVERY_DAYS; }
}
