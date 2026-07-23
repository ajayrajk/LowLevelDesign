# Requirements Document

## Introduction

This feature demonstrates the **Factory Design Pattern** applied to an e-commerce shipping context,
combined with the **Open/Closed Principle (OCP)** from SOLID design. The application models a
shipping subsystem where an order can be fulfilled via multiple concrete shipping strategies
(Standard, Express, Overnight, Drone). A `ShippingFactory` resolves the correct strategy at
runtime. Because every shipping method is added as a new class that implements the `ShippingMethod`
interface — without touching the factory or any existing class — the codebase remains open for
extension and closed for modification.

The deliverable is a Java skeleton placed under
`org.designpattern.creational.factory.ecommerce` inside the existing `LowLevelDesign` Maven project.
It includes:
- Intent commentary explaining why the Factory pattern is used here
- A PlantUML class diagram (embedded in a README inside the package documentation)
- Four concrete shipping methods: `StandardShipping`, `ExpressShipping`,
  `OvernightShipping`, and `DroneShipping`
- A `ShippingFactory` that resolves a method by shipping type using a registry (no if-else)
- A `Main` demo class showing end-to-end usage

---

## Glossary

- **ShippingMethod**: The product interface that every concrete shipping strategy implements.
  Declares `ship(Order order)`, `getEstimatedDeliveryDays()`, and `getDescription()`.
- **ShippingFactory**: The creator class that encapsulates object-creation logic and returns the
  appropriate `ShippingMethod` implementation given a `ShippingType`. Uses a registry map to
  remain closed for modification.
- **ShippingType**: An enum of exactly four supported shipping modes: `STANDARD`, `EXPRESS`,
  `OVERNIGHT`, `DRONE`.
- **Order**: An immutable value object carrying `orderId`, `destination`, and `weightKg`.
- **StandardShipping**: Concrete `ShippingMethod` — economy tier, 5 business days.
- **ExpressShipping**: Concrete `ShippingMethod` — 2-day delivery.
- **OvernightShipping**: Concrete `ShippingMethod` — next-day guaranteed.
- **DroneShipping**: Concrete `ShippingMethod` — same-day autonomous delivery.
- **OCP (Open/Closed Principle)**: A SOLID principle stating a software entity should be open for
  extension (new shipping types) but closed for modification (existing classes unchanged).

---

## Requirements

### Requirement 1: ShippingMethod Interface

**User Story:** As a developer, I want a stable `ShippingMethod` interface, so that I can program
to an abstraction and swap concrete implementations without altering client code.

#### Acceptance Criteria

1. THE `ShippingMethod` interface SHALL declare a `void ship(Order order)` method.
2. WHEN `ship(null)` is called on any implementation, THE implementation SHALL throw an
   `IllegalArgumentException` with a non-blank message.
3. THE `ShippingMethod` interface SHALL declare an `int getEstimatedDeliveryDays()` method; any
   implementation SHALL return a value greater than or equal to zero.
4. THE `ShippingMethod` interface SHALL declare a `String getDescription()` method; any
   implementation SHALL return a non-null, non-blank string that identifies the shipping tier
   by name.
5. THE `ShippingMethod` interface SHALL declare a `double calculateCost(Order order)` method; any
   implementation SHALL return a value strictly greater than zero for any valid `Order`.
6. WHEN `calculateCost(null)` is called on any implementation, THE implementation SHALL throw an
   `IllegalArgumentException` with a non-blank message.

---

### Requirement 2: Order Value Object

**User Story:** As a developer, I want an `Order` value object, so that shipping methods receive
all the context they need to perform and log a shipment.

#### Acceptance Criteria

1. THE `Order` class SHALL expose a `String getOrderId()` method that returns exactly the value
   passed to the constructor.
2. THE `Order` class SHALL expose a `String getDestination()` method that returns exactly the value
   passed to the constructor.
3. THE `Order` class SHALL expose a `double getWeightKg()` method that returns exactly the value
   passed to the constructor.
4. THE `Order` class SHALL be immutable — it SHALL NOT expose any setter or mutator methods.
5. WHEN an `Order` is constructed with a null or whitespace-only `orderId`, THE `Order` constructor
   SHALL throw an `IllegalArgumentException` with a message identifying `orderId` as the invalid
   field.
6. WHEN an `Order` is constructed with a null or whitespace-only `destination`, THE `Order`
   constructor SHALL throw an `IllegalArgumentException` with a message identifying `destination`
   as the invalid field.
7. WHEN an `Order` is constructed with a `weightKg` value less than or equal to zero, or greater
   than 1000.0, THE `Order` constructor SHALL throw an `IllegalArgumentException` with a message
   that includes the invalid value.
8. THE `Order` class SHALL override `toString()` and return a non-null, non-blank string that
   includes the `orderId`, `destination`, and `weightKg` values.

---

### Requirement 3: ShippingType Enum

**User Story:** As a developer, I want a `ShippingType` enum, so that shipping type selection is
type-safe and avoids raw string comparisons scattered across the codebase.

#### Acceptance Criteria

1. THE `ShippingType` enum SHALL define exactly four constants: `STANDARD`, `EXPRESS`,
   `OVERNIGHT`, and `DRONE`.
2. THE `ShippingType` enum SHALL provide a static `fromString(String value)` method that performs
   a case-insensitive match and returns the matching enum constant.
3. IF `ShippingType.fromString` receives a `null` argument, THEN THE method SHALL throw an
   `IllegalArgumentException` with a non-blank message.
4. IF `ShippingType.fromString` receives a non-null value that does not match any enum constant
   (case-insensitively), THEN THE method SHALL throw an `IllegalArgumentException` whose message
   includes the unrecognised input value.

---

### Requirement 4: Concrete Shipping Implementations

**User Story:** As a developer, I want four concrete shipping classes, so that each shipping tier
encapsulates its own business rules and can be extended independently.

#### Acceptance Criteria

1. THE `StandardShipping` class SHALL implement `ShippingMethod` and return `5` from
   `getEstimatedDeliveryDays()`.
2. THE `ExpressShipping` class SHALL implement `ShippingMethod` and return `2` from
   `getEstimatedDeliveryDays()`.
3. THE `OvernightShipping` class SHALL implement `ShippingMethod` and return `1` from
   `getEstimatedDeliveryDays()`.
4. THE `DroneShipping` class SHALL implement `ShippingMethod` and return `0` from
   `getEstimatedDeliveryDays()`.
5. WHEN `ship(Order order)` is called on any concrete `ShippingMethod`, THE implementation SHALL
   write to `System.out` a line that contains — as distinct, non-adjacent tokens — the shipping
   tier name, `order.getOrderId()`, and `order.getDestination()`.
6. EACH concrete shipping class SHALL implement `ShippingMethod` directly with no shared abstract
   base class, ensuring each class is independently compilable and substitutable.
7. `getDescription()` on each concrete class SHALL return a non-null, non-blank string that
   includes the tier name (e.g., "Standard Shipping", "Express Shipping").
8. `calculateCost(Order order)` on each concrete class SHALL return a positive `double`
   representing the shipping cost in INR based on the order's `weightKg`:
   - `StandardShipping`: base rate ₹50 + ₹10 per kg
   - `ExpressShipping`: base rate ₹100 + ₹20 per kg
   - `OvernightShipping`: base rate ₹200 + ₹30 per kg
   - `DroneShipping`: base rate ₹300 + ₹50 per kg
9. WHEN `calculateCost(null)` is called on any concrete `ShippingMethod`, THE implementation
   SHALL throw an `IllegalArgumentException` with a non-blank message.

---

### Requirement 5: ShippingFactory

**User Story:** As a developer, I want a `ShippingFactory`, so that the creation of `ShippingMethod`
objects is centralised and callers are decoupled from concrete types.

#### Acceptance Criteria

1. THE `ShippingFactory` SHALL provide a static `getShippingMethod(ShippingType type)` method
   whose declared return type is `ShippingMethod`.
2. WHEN `ShippingFactory.getShippingMethod` is called with `ShippingType.STANDARD`, THE factory
   SHALL return an object whose runtime type is `StandardShipping`.
3. WHEN `ShippingFactory.getShippingMethod` is called with `ShippingType.EXPRESS`, THE factory
   SHALL return an object whose runtime type is `ExpressShipping`.
4. WHEN `ShippingFactory.getShippingMethod` is called with `ShippingType.OVERNIGHT`, THE factory
   SHALL return an object whose runtime type is `OvernightShipping`.
5. WHEN `ShippingFactory.getShippingMethod` is called with `ShippingType.DRONE`, THE factory SHALL
   return an object whose runtime type is `DroneShipping`.
6. IF `ShippingFactory.getShippingMethod` receives a `null` argument, THEN THE factory SHALL throw
   an `IllegalArgumentException` with the message `"ShippingType must not be null"`.
7. THE `ShippingFactory` implementation SHALL use a registry (`Map<ShippingType, Supplier<ShippingMethod>>`)
   to resolve instances; THE `ShippingFactory` source file SHALL contain zero `if`, `else if`,
   or `switch` branches that reference concrete shipping class names, making it closed for
   modification when new `ShippingType` values are added.
8. THE `ShippingFactory` class SHALL declare a private constructor so that it cannot be
   instantiated by callers.

---

### Requirement 6: OCP Demonstration — Adding DroneShipping Without Modification

**User Story:** As a developer, I want the design to visibly prove OCP compliance, so that I can
use this example to explain the principle to colleagues.

#### Acceptance Criteria

1. THE `ShippingFactory` class SHALL contain at least one in-code comment of at least one sentence
   that explicitly names the registry as the OCP-compliant extension point and explains that no
   modification is needed to add a new shipping type.
2. THE `ShippingFactory` source file SHALL contain zero occurrences of the class names
   `StandardShipping`, `ExpressShipping`, `OvernightShipping`, or `DroneShipping` outside of the
   registry initialisation block — verifiable by text search.
3. THE `DroneShipping` source file SHALL contain a Javadoc or inline comment of at least one
   sentence explicitly stating that this class was added as an OCP extension without modifying
   `ShippingFactory` or any pre-existing shipping class.
4. EACH of the four concrete shipping classes SHALL compile independently without modification
   when a fifth concrete class implementing `ShippingMethod` is added to the same package.

---

### Requirement 7: Main Demo Class

**User Story:** As a developer, I want a `Main` demo class, so that I can run the application and
observe Factory + OCP behaviour end-to-end with a single `main` method.

#### Acceptance Criteria

1. THE `Main` class SHALL instantiate exactly four `Order` objects — one per `ShippingType` —
   each with a distinct, non-blank `orderId`.
2. WHEN `Main.main` is executed, THE `Main` class SHALL call `ShippingFactory.getShippingMethod`
   for each of the four `ShippingType` values.
3. WHEN `Main.main` is executed, THE `Main` class SHALL call `ship(order)` on the returned
   `ShippingMethod` for each order.
4. WHEN `Main.main` is executed, for each shipping method, THE `Main` class SHALL print the
   method's description and estimated delivery days on the same output line, and this print SHALL
   occur before the corresponding `ship(order)` call for that method.
5. THE `Main` class source file SHALL contain zero direct instantiations of `StandardShipping`,
   `ExpressShipping`, `OvernightShipping`, or `DroneShipping` — all instances SHALL be obtained
   exclusively via `ShippingFactory.getShippingMethod`.

---

### Requirement 8: Class Diagram Documentation

**User Story:** As a developer, I want a PlantUML class diagram, so that the Factory + OCP
structure is immediately clear to anyone reading the codebase.

#### Acceptance Criteria

1. THE `README.md` SHALL contain a PlantUML fenced code block delimited by ` ```plantuml ` and
   ` ``` ` that includes `@startuml` and `@enduml` markers.
2. THE diagram SHALL show `ShippingMethod` as an `interface` with `ship()`,
   `getEstimatedDeliveryDays()`, and `getDescription()` members.
3. THE diagram SHALL show each of the four concrete classes connected to `ShippingMethod` using
   a realisation arrow (`..>` or `--|>`).
4. THE diagram SHALL show `ShippingFactory` connected to `ShippingType` with a dependency arrow
   (`..>`) and connected to `ShippingMethod` with a dependency arrow (`..>`) on its return.
5. THE diagram SHALL show `Order` as a class with `orderId`, `destination`, and `weightKg`
   fields, and SHALL show `ShippingMethod.ship()` depending on `Order` via a dependency arrow.
6. THE `README.md` SHALL contain a prose section of at least two paragraphs: the first explaining
   the Factory pattern intent (why object creation is centralised), and the second explaining how
   OCP is applied (extension by adding a class, no modification of existing code).
