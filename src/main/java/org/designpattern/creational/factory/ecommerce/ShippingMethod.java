package org.designpattern.creational.factory.ecommerce;

/**
 * Product interface for the Factory pattern.
 *
 * <p>Every concrete shipping strategy implements this interface.
 * Client code ({@link ShippingDemo}) and {@link ShippingFactory} depend only on
 * this abstraction — never on any concrete class. This is the "closed" half of OCP:
 * the interface contract never changes when new shipping variants are added.</p>
 */
public interface ShippingMethod {

    /**
     * Executes the shipment for the given order identifier and prints a confirmation.
     *
     * @param orderId the identifier of the order being shipped; must not be null or blank
     */
    void ship(String orderId);

    /**
     * Returns the flat shipping cost in USD for this tier.
     *
     * @return a positive double representing the cost (e.g., 5.99 for Standard)
     */
    double getCost();

    /**
     * Returns the estimated delivery time in days for this tier.
     *
     * @return a non-negative integer representing delivery days
     */
    int getEstimatedDeliveryDays();
}
