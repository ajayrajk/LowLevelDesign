# Implementation Plan: ecommerce-shipping-factory

## Overview

Implement the Factory Design Pattern with OCP compliance in the `org.designpattern.creational.factory.ecommerce`
package of the existing `LowLevelDesign` Maven project. The plan proceeds in dependency order:
test infrastructure first, then the product interface and supporting types, then the four concrete
classes, then the factory and demo, and finally tests and documentation.

---

## Tasks

- [ ] 1. Add test dependencies to `pom.xml`
  - [ ] 1.1 Add JUnit Jupiter and jqwik dependencies to `pom.xml`
    - Add `junit-jupiter` 5.10.2 and `jqwik` 1.8.4 as `<scope>test</scope>` dependencies
    - Add the `maven-surefire-plugin` (version 3.x) with `<includes>` for both `**/*Test.java`
      and `**/*PropertyTest.java` so jqwik `@Property` methods are discovered by `mvn test`
    - Verify the project still compiles: `mvn compile -q`
    - _Requirements: Testing Strategy (design.md §Testing Strategy)_

- [ ] 2. Create the `ShippingMethod` interface and `ShippingType` enum
  - [ ] 2.1 Create `ShippingMethod.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/ShippingMethod.java`
    - Declare `void ship(Order order)`, `int getEstimatedDeliveryDays()`, `String getDescription()`
    - Add Javadoc per design §Components and Interfaces §1
    - _Requirements: 1.1, 1.3, 1.4_

  - [ ] 2.2 Create `ShippingType.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/ShippingType.java`
    - Declare exactly four constants: `STANDARD`, `EXPRESS`, `OVERNIGHT`, `DRONE`
    - Implement `public static ShippingType fromString(String value)` with case-insensitive
      matching; throw `IllegalArgumentException` for null input and for unrecognised strings
      (message must contain the input value)
    - _Requirements: 3.1, 3.2, 3.3, 3.4_

- [ ] 3. Create the `Order` value object
  - [ ] 3.1 Create `Order.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/Order.java`
    - Declare the class `final` with three private fields: `String orderId`, `String destination`,
      `double weightKg`
    - Implement the constructor with eager validation:
      - `orderId` null/blank → `IllegalArgumentException("orderId must not be null or blank")`
      - `destination` null/blank → `IllegalArgumentException("destination must not be null or blank")`
      - `weightKg <= 0 || weightKg > 1000.0` → `IllegalArgumentException("weightKg out of range (0, 1000]: <value>")`
    - Provide `getOrderId()`, `getDestination()`, `getWeightKg()` — no setters
    - Override `toString()` to return:
      `Order{orderId='<id>', destination='<dest>', weightKg=<weight>}`
    - _Requirements: 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8_

- [ ] 4. Create the four concrete shipping classes
  - [ ] 4.1 Create `StandardShipping.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/StandardShipping.java`
    - `implements ShippingMethod` directly (no abstract base)
    - `getEstimatedDeliveryDays()` returns `5`
    - `getDescription()` returns `"Standard Shipping - Economy (5 business days)"`
    - `ship(order)`: guard-throw `IllegalArgumentException` if `order == null`; print
      `[Standard Shipping] Shipping order <orderId> to <destination>`
    - `calculateCost(order)`: guard-throw if null; return `50.0 + 10.0 * order.getWeightKg()`
    - _Requirements: 4.1, 4.5, 4.6, 4.7, 4.8, 4.9, 1.2, 1.5, 1.6_

  - [ ] 4.2 Create `ExpressShipping.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/ExpressShipping.java`
    - `implements ShippingMethod` directly (no abstract base)
    - `getEstimatedDeliveryDays()` returns `2`
    - `getDescription()` returns `"Express Shipping - 2-Day Delivery"`
    - `ship(order)`: guard-throw for null; print `[Express Shipping] Shipping order <orderId> to <destination>`
    - `calculateCost(order)`: guard-throw if null; return `100.0 + 20.0 * order.getWeightKg()`
    - _Requirements: 4.2, 4.5, 4.6, 4.7, 4.8, 4.9, 1.2, 1.5, 1.6_

  - [ ] 4.3 Create `OvernightShipping.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/OvernightShipping.java`
    - `implements ShippingMethod` directly (no abstract base)
    - `getEstimatedDeliveryDays()` returns `1`
    - `getDescription()` returns `"Overnight Shipping - Next-Day Guaranteed"`
    - `ship(order)`: guard-throw for null; print `[Overnight Shipping] Shipping order <orderId> to <destination>`
    - `calculateCost(order)`: guard-throw if null; return `200.0 + 30.0 * order.getWeightKg()`
    - _Requirements: 4.3, 4.5, 4.6, 4.7, 4.8, 4.9, 1.2, 1.5, 1.6_

  - [ ] 4.4 Create `DroneShipping.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/DroneShipping.java`
    - `implements ShippingMethod` directly (no abstract base)
    - `getEstimatedDeliveryDays()` returns `0`
    - `getDescription()` returns `"Drone Shipping - Same-Day Autonomous Delivery"`
    - `ship(order)`: guard-throw for null; print `[Drone Shipping] Shipping order <orderId> to <destination>`
    - `calculateCost(order)`: guard-throw if null; return `300.0 + 50.0 * order.getWeightKg()`
    - Include a Javadoc comment stating this class was added as an OCP extension without modifying
      `ShippingFactory` or any pre-existing shipping class
    - _Requirements: 4.4, 4.5, 4.6, 4.7, 4.8, 4.9, 1.2, 1.5, 1.6, 6.3_

- [ ] 5. Checkpoint — compile the production code
  - [ ] 5.1 Verify all production classes compile: `mvn compile -q`. Fix any compilation errors
    before proceeding. Ask the user if any design ambiguity arises.

- [ ] 6. Create `ShippingFactory.java`
  - [ ] 6.1 Create `ShippingFactory.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/ShippingFactory.java`
    - Declare a `private static final Map<ShippingType, Supplier<ShippingMethod>> REGISTRY`
      backed by `EnumMap`
    - Populate the registry in a `static {}` block using constructor method references:
      `STANDARD → StandardShipping::new`, `EXPRESS → ExpressShipping::new`,
      `OVERNIGHT → OvernightShipping::new`, `DRONE → DroneShipping::new`
    - Wrap with `Collections.unmodifiableMap`
    - Implement `public static ShippingMethod getShippingMethod(ShippingType type)`: guard-throw
      `IllegalArgumentException("ShippingType must not be null")` for null; look up and invoke
      supplier; throw for missing registry entry
    - Private constructor — not instantiable (Req 5.8)
    - Add an in-code comment naming the registry as the OCP-compliant extension point
    - Confirm there are zero `if`/`else if`/`switch` branches referencing concrete class names
      outside the static initialiser block
    - _Requirements: 5.1, 5.2, 5.3, 5.4, 5.5, 5.6, 5.7, 5.8, 6.1, 6.2_

  - [ ] 6.2 Verify OCP compliance by text search
    - Run: `grep -n "StandardShipping\|ExpressShipping\|OvernightShipping\|DroneShipping" ShippingFactory.java`
    - Confirm all matches fall exclusively inside the `static {}` initialiser block
    - Run: `grep -n "if\|else\|switch" ShippingFactory.java` and confirm zero matches in the
      `getShippingMethod` method body
    - _Requirements: 6.2_

- [ ] 7. Create `Main.java` demo
  - [ ] 7.1 Create `Main.java`
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/Main.java`
    - Use a `LinkedHashMap<ShippingType, Order>` to pair each `ShippingType` with its `Order`
      explicitly — do NOT use array index pairing (`types[i]` / `orders[i]`)
    - For each entry, obtain `ShippingMethod` via `ShippingFactory.getShippingMethod`, then
      print description, ETA, and `calculateCost()` result, then call `ship(order)`
    - No concrete shipping class name (`StandardShipping`, `ExpressShipping`, etc.) may appear
      anywhere in this file
    - _Requirements: 7.1, 7.2, 7.3, 7.4, 7.5_

- [ ] 8. Checkpoint — full production build and smoke test
  - [ ] 8.1 Run `mvn compile -q` to verify zero compilation errors across all production files.
    Ask the user if any question arises.

- [ ] 9. Write property-based tests
  - [ ] 9.1 Create `OrderPropertyTest.java`
    - File: `src/test/java/org/designpattern/creational/factory/ecommerce/OrderPropertyTest.java`
    - **Property 3: Order constructor round-trip** — for any valid `orderId`, `destination`,
      `weightKg` in `(0.0, 1000.0]`, getters return the exact supplied values
      - **Validates: Requirements 2.1, 2.2, 2.3**
    - **Property 4: Order rejects blank string fields** — for any null/blank `orderId` or
      `destination`, constructor throws `IllegalArgumentException` whose message names the field
      - **Validates: Requirements 2.5, 2.6**
    - **Property 5: Order rejects out-of-range weight** — for any `weightKg <= 0` or `> 1000`,
      constructor throws `IllegalArgumentException` whose message contains the value
      - **Validates: Requirements 2.7**
    - Use `@Provide` methods for `validWeights`, `invalidWeights`, `blankStrings` arbitraries

  - [ ] 9.2 Create `ShippingTypePropertyTest.java`
    - File: `src/test/java/org/designpattern/creational/factory/ecommerce/ShippingTypePropertyTest.java`
    - **Property 6: fromString case-insensitive round-trip** — for any `ShippingType` constant
      and any mixed-case permutation of its name, `fromString` returns that constant
      - **Validates: Requirements 3.2**
    - **Property 7: fromString rejects unknown values** — for any string that matches no constant
      (case-insensitively), `fromString` throws `IllegalArgumentException` containing the input
      - **Validates: Requirements 3.4**
    - Use a `@Provide` method for `unknownShippingStrings` arbitrary

  - [ ] 9.3 Create `ShippingMethodPropertyTest.java`
    - File: `src/test/java/org/designpattern/creational/factory/ecommerce/ShippingMethodPropertyTest.java`
    - **Property 1: ShippingMethod interface contract** — for every `ShippingType`, the factory
      returns a method where `getEstimatedDeliveryDays() >= 0` and `getDescription()` is
      non-null and non-blank
      - **Validates: Requirements 1.3, 1.4**
    - **Property 2: ship(null) always throws** — for every `ShippingType`, calling `ship(null)`
      throws `IllegalArgumentException` with a non-blank message
      - **Validates: Requirements 1.2**
    - **Property 9: ship(order) output contains required tokens** — for any valid `Order` and
      any `ShippingType`, `ship(order)` writes to `System.out` a line containing the tier name,
      `orderId`, and `destination`; capture stdout with `ByteArrayOutputStream` before each test
      - **Validates: Requirements 4.5**
    - **Property 10: calculateCost returns positive value for all valid orders** — for any
      `ShippingType` and any valid `Order`, `calculateCost(order)` returns a value `> 0`, and
      a heavier order always costs more than a lighter order for the same tier
      - **Validates: Requirements 1.5, 4.8**
    - **Property 11: calculateCost(null) always throws** — for every `ShippingType`, calling
      `calculateCost(null)` throws `IllegalArgumentException` with a non-blank message
      - **Validates: Requirements 1.6, 4.9**

  - [ ] 9.4 Create `ShippingFactoryPropertyTest.java`
    - File: `src/test/java/org/designpattern/creational/factory/ecommerce/ShippingFactoryPropertyTest.java`
    - **Property 8: Factory returns correct concrete type for every ShippingType** — for each
      `ShippingType` constant, `getShippingMethod` returns an instance of exactly the registered
      concrete class (`STANDARD` → `StandardShipping.class`, etc.)
      - **Validates: Requirements 5.2, 5.3, 5.4, 5.5**

- [ ] 10. Write example-based unit tests
  - [ ] 10.1 Create `ShippingFactoryUnitTest.java`
    - File: `src/test/java/org/designpattern/creational/factory/ecommerce/ShippingFactoryUnitTest.java`
    - `@Test` — `StandardShipping.getEstimatedDeliveryDays()` returns `5` (Req 4.1)
    - `@Test` — `ExpressShipping.getEstimatedDeliveryDays()` returns `2` (Req 4.2)
    - `@Test` — `OvernightShipping.getEstimatedDeliveryDays()` returns `1` (Req 4.3)
    - `@Test` — `DroneShipping.getEstimatedDeliveryDays()` returns `0` (Req 4.4)
    - `@Test` — `StandardShipping.calculateCost(order)` == `50.0 + 10.0 * weight` (Req 4.8)
    - `@Test` — `ExpressShipping.calculateCost(order)` == `100.0 + 20.0 * weight` (Req 4.8)
    - `@Test` — `OvernightShipping.calculateCost(order)` == `200.0 + 30.0 * weight` (Req 4.8)
    - `@Test` — `DroneShipping.calculateCost(order)` == `300.0 + 50.0 * weight` (Req 4.8)
    - `@Test` — `getShippingMethod(null)` throws `IllegalArgumentException` with exact message
      `"ShippingType must not be null"` (Req 5.6)
    - `@Test` — `ShippingType.fromString(null)` throws `IllegalArgumentException` (Req 3.3)
    - `@Test` — `ShippingType.values().length == 4` (Req 3.1)
    - `@Test` — each concrete class has `Object.class` as its superclass via reflection (Req 4.6)
    - `@Test` — `Order` has no public methods whose name starts with `"set"` via reflection (Req 2.4)
    - `@Test` — `Order.toString()` contains orderId, destination, and weightKg (Req 2.8)
    - `@Test` — `ShippingFactory` cannot be instantiated (constructor is private, reflection check) (Req 5.8)
    - `@Test` — `Main.main(new String[]{})` produces exactly four non-empty output blocks
      (capture stdout, assert four method blocks) (Req 7.2, 7.3, 7.4)
    - _Requirements: 4.1–4.4, 4.8, 5.6, 5.8, 3.3, 3.1, 4.6, 2.4, 2.8, 7.2, 7.3, 7.4_

- [ ] 11. Checkpoint — run the full test suite
  - [ ] 11.1 Run `mvn test`. All tests must pass with zero failures. Fix any failures before
    proceeding. Ask the user if any question arises.

- [ ] 12. Write `README.md` documentation
  - [ ] 12.1 Create `README.md` in the ecommerce package documentation folder
    - File: `src/main/java/org/designpattern/creational/factory/ecommerce/README.md`
    - Include the PlantUML class diagram fenced code block (` ```plantuml `) with `@startuml` /
      `@enduml` markers; diagram must show the interface, four concrete classes (realisation
      arrows), `ShippingFactory` (dependency arrows to `ShippingType` and `ShippingMethod`),
      and `Order` (dependency from `ShippingMethod.ship()`)
    - Include a prose section with at least two paragraphs: (1) Factory pattern intent —
      centralised creation, decoupling callers from concrete types; (2) OCP application —
      extension by adding a new class + registry entry, zero modification to existing files
    - _Requirements: 8.1, 8.2, 8.3, 8.4, 8.5, 8.6_

- [ ] 13. Final checkpoint — verify and confirm
  - [ ] 13.1 Run `mvn test` one final time to confirm all tests pass after documentation is added.
    Ensure all tasks are complete. Ask the user if any question arises.

---

## Notes

- Tasks marked with `*` are optional and can be skipped for faster MVP
- Each task references specific requirements for full traceability
- Checkpoints (tasks 5, 8, 11, 13) enforce incremental validation at natural phase boundaries
- The four concrete shipping classes (tasks 4.1–4.4) have no shared abstract base — this is a
  deliberate design choice per Requirement 4.6
- The `EnumMap` registry in `ShippingFactory` (task 6.1) must contain zero `if`/`else`/`switch`
  branches that reference concrete class names outside the static initialiser — enforced by
  Requirements 5.7 and 6.2
- Property tests (tasks 9.1–9.4) use jqwik `@Property` / `@ForAll`; each property corresponds
  to a numbered correctness property in the design document
- Unit tests (task 10.1) use JUnit Jupiter `@Test` and complement the property tests with
  concrete example-based assertions
- The `maven-surefire-plugin` configuration added in task 1.1 must include both `junit-platform`
  engine and `jqwik` engine discovery so `mvn test` picks up all test classes

---

## Task Dependency Graph

```json
{
  "waves": [
    { "id": 0, "tasks": ["1.1"] },
    { "id": 1, "tasks": ["2.1", "2.2"] },
    { "id": 2, "tasks": ["3.1"] },
    { "id": 3, "tasks": ["4.1", "4.2", "4.3", "4.4"] },
    { "id": 4, "tasks": ["5.1"] },
    { "id": 5, "tasks": ["6.1"] },
    { "id": 6, "tasks": ["6.2"] },
    { "id": 7, "tasks": ["7.1"] },
    { "id": 8, "tasks": ["8.1"] },
    { "id": 9, "tasks": ["9.1", "9.2", "9.3", "9.4", "10.1"] },
    { "id": 10, "tasks": ["11.1"] },
    { "id": 11, "tasks": ["12.1"] },
    { "id": 12, "tasks": ["13.1"] }
  ]
}
```
