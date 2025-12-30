package org.solid.principle.structural.mixin.withmixin;

public interface LoggingMixin {
    default void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
