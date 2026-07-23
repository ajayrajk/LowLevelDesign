package org.designpattern.creational.factory.ecommerce;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * OCP-compliant factory for {@link ShippingMethod} instances.
 *
 * <p><b>Design decisions:</b></p>
 * <ul>
 *   <li><b>No if/else/switch</b> — dispatch is driven entirely by the {@code REGISTRY} map.
 *       The {@code createShipping()} method body contains zero branching logic.</li>
 *   <li><b>Supplier&lt;ShippingMethod&gt; values</b> — method references to constructors
 *       (e.g., {@code StandardShipping::new}) are stored, not pre-built instances.
 *       Each {@code createShipping()} call returns a <em>fresh</em> object, avoiding
 *       shared mutable state if concrete classes ever acquire fields.</li>
 *   <li><b>EnumMap</b> — backed by an array indexed by ordinal, giving O(1) lookup
 *       with no boxing overhead; the idiomatic Java collection for enum-keyed maps.</li>
 *   <li><b>Private constructor</b> — utility class; instantiation is prevented.</li>
 * </ul>
 *
 * <p><b>Extending the factory (OCP):</b> To add {@code DroneShipping}, create that class,
 * add {@code DRONE} to {@link ShippingType}, and add one line:
 * {@code map.put(ShippingType.DRONE, DroneShipping::new);} in the static initialiser below.
 * The body of {@code createShipping()} is never touched.</p>
 */
public final class ShippingFactory {

    /**
     * Registry mapping every {@link ShippingType} to a factory {@code Supplier}.
     * Concrete class names appear <em>only</em> inside this static initialiser block.
     */
    private static final Map<ShippingType, Supplier<ShippingMethod>> REGISTRY;

    static {
        Map<ShippingType, Supplier<ShippingMethod>> map = new EnumMap<>(ShippingType.class);
        map.put(ShippingType.STANDARD,      StandardShipping::new);
        map.put(ShippingType.EXPRESS,       ExpressShipping::new);
        map.put(ShippingType.OVERNIGHT,     OvernightShipping::new);
        map.put(ShippingType.INTERNATIONAL, InternationalShipping::new);
        REGISTRY = Collections.unmodifiableMap(map);
    }

    /** Utility class — not instantiable. */
    private ShippingFactory() {}

    /**
     * Returns a fresh {@link ShippingMethod} instance for the requested shipping type.
     *
     * @param type the desired shipping tier; must not be {@code null}
     * @return a new {@code ShippingMethod} implementation for the given type
     * @throws IllegalArgumentException if {@code type} is {@code null} or
     *         not found in the registry (guards against incomplete registry)
     */
    public static ShippingMethod createShipping(ShippingType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                "ShippingType must not be null. Valid values: " +
                java.util.Arrays.toString(ShippingType.values()));
        }
        Supplier<ShippingMethod> supplier = REGISTRY.get(type);
        if (supplier == null) {
            throw new IllegalArgumentException(
                "No ShippingMethod registered for type: " + type +
                ". Ensure a Supplier is added to ShippingFactory.REGISTRY.");
        }
        return supplier.get();
    }
}
