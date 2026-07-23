package org.designpattern.creational.factory.ecommerce;

/**
 * Next-day guaranteed shipping tier.
 *
 * <p>Registered in {@link ShippingFactory} under {@link ShippingType#OVERNIGHT}.
 * Cost: $29.99 flat. Estimated delivery: 1 business day.</p>
 */
public class OvernightShipping implements ShippingMethod {

    private static final double COST          = 29.99;
    private static final int    DELIVERY_DAYS = 1;

    /** {@inheritDoc} */
    @Override
    public void ship(String orderId) {
        System.out.println("[Overnight Shipping] Order " + orderId +
            " dispatched — next-day guaranteed, estimated " + DELIVERY_DAYS + " day.");
    }

    /** @return {@code 29.99} — the flat rate for overnight shipping */
    @Override
    public double getCost() { return COST; }

    /** @return {@code 1} — next-day delivery */
    @Override
    public int getEstimatedDeliveryDays() { return DELIVERY_DAYS; }
}
