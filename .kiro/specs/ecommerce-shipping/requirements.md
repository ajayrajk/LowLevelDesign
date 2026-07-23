# Requirements Document

## Introduction

This document defines requirements for a dummy e-commerce shipping application built in Java. The application demonstrates two key software engineering concepts working together:

1. **Factory Pattern** — a `ShippingFactory` encapsulates the creation logic for different shipping methods, so client code never calls `new ConcreteShipping()` directly.
2. **Open/Closed Principle (OCP)** — the system is open for extension (adding new shipping methods) but closed for modification (no existing class changes when a new method is introduced).

The application includes intent explanation, a class diagram (Mermaid), and skeleton Java code placed under the existing Maven project at `src/main/java/org/designpattern/creational/factory/ecommerce/`.

---

## Glossary

- **ShippingMethod**: The common abstraction (interface) that every concrete shipping type implements.
- **ShippingFactory**: The factory class (or registry) responsible for instantiating the correct `ShippingMethod` at runtime.
- **ShippingType**: An enum or string constant that identifies a shipping variant (e.g., STANDARD, EXPRESS, OVERNIGHT, INTERNATIONAL).
- **ConcreteShipping**: Any class that implements `ShippingMethod` for a specific shipping variant.
- **OCP**: Open/Closed Principle — software entities should be open for extension but closed for modification.
- **Factory Pattern**: A creational design pattern that delegates object instantiation to a dedicated factory class.
- **Client**: Any class that uses `ShippingFactory` to obtain a `ShippingMethod` without depending on concrete types.
- **ShippingDemo**: The entry-point class with a `main` method that exercises the factory and prints output.

---

## Requirements

### Requirement 1: Shipping Method Abstraction

**User Story:** As a developer, I want a well-defined `ShippingMethod` interface, so that all concrete shipping implementations share a common contract that the `Client` and `ShippingFactory` can depend on.

#### Acceptance Criteria

1. THE `ShippingMethod` interface SHALL declare a `ship(String orderId)` method that concrete classes must implement.
2. THE `ShippingMethod` interface SHALL declare a `getCost()` method returning a `double` that concrete classes must implement.
3. THE `ShippingMethod` interface SHALL declare a `getEstimatedDeliveryDays()` method returning an `int` that concrete classes must implement.

---

### Requirement 2: Concrete Shipping Implementations

**User Story:** As a developer, I want concrete shipping classes for Standard, Express, Overnight, and International shipping, so that the application demonstrates multiple variants that can be used interchangeably through the `ShippingMethod` interface.

#### Acceptance Criteria

1. THE `StandardShipping` class SHALL implement `ShippingMethod` and print a confirmation message, a cost of 5.99, and 5–7 delivery days when `ship()` is called.
2. THE `ExpressShipping` class SHALL implement `ShippingMethod` and print a confirmation message, a cost of 15.99, and 2–3 delivery days when `ship()` is called.
3. THE `OvernightShipping` class SHALL implement `ShippingMethod` and print a confirmation message, a cost of 29.99, and 1 delivery day when `ship()` is called.
4. THE `InternationalShipping` class SHALL implement `ShippingMethod` and print a confirmation message, a cost of 49.99, and 10–15 delivery days when `ship()` is called.
5. WHEN `ship(String orderId)` is called on any `ConcreteShipping`, THE `ConcreteShipping` SHALL include the `orderId` in its output message.

---

### Requirement 3: Shipping Factory

**User Story:** As a developer, I want a `ShippingFactory` that creates `ShippingMethod` instances from a `ShippingType` enum, so that client code does not depend on concrete classes and new shipping methods can be added without modifying the factory's core dispatch logic.

#### Acceptance Criteria

1. THE `ShippingFactory` SHALL expose a static `createShipping(ShippingType type)` method that returns a `ShippingMethod`.
2. WHEN `createShipping` is called with a valid `ShippingType`, THE `ShippingFactory` SHALL return an instance of the corresponding `ConcreteShipping` class.
3. WHEN `createShipping` is called with a `null` argument, THE `ShippingFactory` SHALL throw an `IllegalArgumentException` with a descriptive message.
4. THE `ShippingFactory` SHALL use a registration mechanism (e.g., a `Map<ShippingType, Supplier<ShippingMethod>>`) so that adding a new `ShippingType` requires only registering a new entry — no `if/else` or `switch` statements in the dispatch logic.

---

### Requirement 4: Open/Closed Principle Compliance

**User Story:** As a developer, I want the design to enforce OCP, so that adding a new shipping method (e.g., `DroneShipping`) requires only creating a new class and registering it — without touching `ShippingMethod`, `ShippingFactory`, or any existing `ConcreteShipping`.

#### Acceptance Criteria

1. THE `ShippingMethod` interface SHALL NOT be modified when a new shipping variant is added.
2. THE `ShippingFactory` dispatch logic SHALL NOT be modified when a new `ConcreteShipping` is added.
3. WHEN a new `ConcreteShipping` class is registered with the `ShippingFactory`, THE `ShippingFactory` SHALL instantiate it correctly without any change to the factory's existing code.
4. THE `ShippingType` enum SHALL serve as the only file that requires a change (adding a new constant) to support a new shipping variant, demonstrating minimal modification scope.

---

### Requirement 5: Class Diagram Documentation

**User Story:** As a learner, I want a Mermaid class diagram in the design document, so that I can visually understand the relationships between `ShippingMethod`, `ShippingFactory`, `ShippingType`, and all concrete classes.

#### Acceptance Criteria

1. THE design document SHALL include a Mermaid `classDiagram` showing the `ShippingMethod` interface, all `ConcreteShipping` classes, `ShippingFactory`, and `ShippingType`.
2. THE class diagram SHALL indicate `implements` relationships between each `ConcreteShipping` and `ShippingMethod`.
3. THE class diagram SHALL indicate the `uses` (dependency) relationship between `ShippingFactory` and `ShippingMethod`.
4. THE class diagram SHALL indicate the `uses` relationship between `ShippingDemo` (client) and `ShippingFactory`.

---

### Requirement 6: Intent Explanation and Demo Entry Point

**User Story:** As a learner, I want in-code comments explaining the Factory Pattern and OCP intent, plus a runnable `ShippingDemo` class, so that the code is self-explanatory and I can run it immediately.

#### Acceptance Criteria

1. THE `ShippingDemo` class SHALL contain a Javadoc comment or block comment explaining the Factory Pattern intent and the OCP benefit in context of shipping methods.
2. THE `ShippingDemo.main()` method SHALL exercise all four shipping variants by calling `ShippingFactory.createShipping()` with each `ShippingType` constant.
3. WHEN `ShippingDemo.main()` runs, THE `ShippingDemo` SHALL print the shipping method name, cost, estimated delivery days, and the ship confirmation for each variant.
4. THE `ShippingDemo` SHALL demonstrate extensibility by including a commented-out block showing how a hypothetical `DroneShipping` would be added without modifying existing classes.

---

### Requirement 7: Package and Project Structure

**User Story:** As a developer maintaining the existing Maven project, I want the new code placed in a dedicated package following the project's naming convention, so that it integrates cleanly without disrupting existing examples.

#### Acceptance Criteria

1. THE new shipping classes SHALL be placed in the package `org.designpattern.creational.factory.ecommerce`.
2. THE Maven project structure SHALL remain valid (compilable with `mvn compile`) after the new files are added.
3. THE new package SHALL contain exactly these files: `ShippingMethod.java`, `ShippingType.java`, `ShippingFactory.java`, `StandardShipping.java`, `ExpressShipping.java`, `OvernightShipping.java`, `InternationalShipping.java`, and `ShippingDemo.java`.
