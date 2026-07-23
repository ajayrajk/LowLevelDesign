package org.designpattern.creational.factory.ecommerce;

/**
 * Type-safe enumeration of all supported shipping modes.
 *
 * <p>Using an enum eliminates raw-string comparisons and prevents typos at call sites.
 * When a new shipping variant is needed, add a constant here and register a
 * {@code Supplier<ShippingMethod>} in {@link ShippingFactory} — that is the only
 * file, besides the new concrete class itself, that ever needs to change.</p>
 */
public enum ShippingType {

    /** Economy ground shipping. Cost: $5.99. Delivery: 5–7 days. */
    STANDARD,

    /** Accelerated shipping. Cost: $15.99. Delivery: 2–3 days. */
    EXPRESS,

    /** Next-day guaranteed delivery. Cost: $29.99. Delivery: 1 day. */
    OVERNIGHT,

    /** Cross-border shipping. Cost: $49.99. Delivery: 10–15 days. */
    INTERNATIONAL
}
