# Implementation Plan: ecommerce-shipping

## Overview

Implement the Factory Design Pattern + Open/Closed Principle demo in the existing Maven project.
All source files go under `src/main/java/org/designpattern/creational/factory/ecommerce/` and
test files under `src/test/java/org/designpattern/creational/factory/ecommerce/`.
The plan is structured in five epics: build setup → abstractions → factory + demo → tests →
final verification. Each epic ends with a compile or test checkpoint so errors are caught early.

---

## Tasks

- [x] 1. Add test dependencies to pom.xml
  - [x] 1.1 Add jqwik 1.8.4, JUnit Jupiter 5.10.2, and maven-surefire-plugin 3.2.5 to pom.xml
    - Open `pom.xml` and append the following inside `<dependencies>`:
      ```xml
      <dependency>
          <groupId>net.jqwik</groupId>
          <artifactId>jqwik</artifactId>
          <version>1.8.4</version>
          <scope>test</scope>
      </dependency>
      <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter</artifactId>
          <version>5.10.2</version>
          <scope>test</scope>
      </dependency>
      ```
    - Add (or update) the `maven-surefire-plugin` entry inside `<build><plugins>`:
      ```xml
      <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>3.2.5</version>
          <configuration>
              <includes>
                  <include>**/*Test.java</include>
                  <include>**/*Properties.java</include>
              </includes>
          </configuration>
      </plugin>
      ```
    - _Requirements: 7.2 (project remains compilable); Testing Strategy section of design_

- [x] 2. Create core abstractions
  - [x] 2.1 Create `ShippingMethod.java` interface
    - Package: `org.designpattern.creational.factory.ecommerce`
    - Declare `void ship(String orderId)`, `double getCost()`, `int getEstimatedDeliveryDays()`
    - Include Javadoc as shown in the design document
    - _Requirements: 1.1, 1.2, 1.3_

  - [x] 2.2 Create `ShippingType.java` enum
    - Package: `org.designpattern.creational.factory.ecommerce`
    - Constants: `STANDARD`, `EXPRESS`, `OVERNIGHT`, `INTERNATIONAL`
    - Include Javadoc per-constant with cost and delivery window
    - _Requirements: 3.1, 4.4, 7.3_

- [x] 3. Implement concrete shipping classes
  - [x] 3.1 Create `StandardShipping.java`
    - Implements `ShippingMethod`; `COST = 5.99`, `DELIVERY_DAYS = 5`
    - `ship()` prints `[Standard Shipping] Order <orderId> dispatched…` including the orderId
    - _Requirements: 2.1, 2.5_

  - [x] 3.2 Create `ExpressShipping.java`
    - Implements `ShippingMethod`; `COST = 15.99`, `DELIVERY_DAYS = 2`
    - `ship()` prints `[Express Shipping] Order <orderId> dispatched…` including the orderId
    - _Requirements: 2.2, 2.5_

  - [x] 3.3 Create `OvernightShipping.java`
    - Implements `ShippingMethod`; `COST = 29.99`, `DELIVERY_DAYS = 1`
    - `ship()` prints `[Overnight Shipping] Order <orderId> dispatched…` including the orderId
    - _Requirements: 2.3, 2.5_

  - [x] 3.4 Create `InternationalShipping.java`
    - Implements `ShippingMethod`; `COST = 49.99`, `DELIVERY_DAYS = 10`
    - `ship()` prints `[International Shipping] Order <orderId> dispatched…` including the orderId
    - _Requirements: 2.4, 2.5_

- [x] 4. Checkpoint — compile all production sources
  - Run `mvn compile -q` and confirm zero errors before proceeding to the factory and demo.
  - Ensure all tests pass, ask the user if questions arise.

- [ ] 5. Implement factory and demo
  - [ ] 5.1 Create `ShippingFactory.java`
    - Package: `org.designpattern.creational.factory.ecommerce`
    - Private constructor (utility class)
    - `private static final Map<ShippingType, Supplier<ShippingMethod>> REGISTRY` backed by `EnumMap`; populated in a `static` initialiser with all four constructor references
    - `public static ShippingMethod createShipping(ShippingType type)`: null guard throws `IllegalArgumentException` with descriptive message; dispatches via `REGISTRY.get(type).get()`; missing-registration guard throws `IllegalArgumentException`
    - **Zero `if/else/switch` statements in the `createShipping()` method body**
    - Wrap map in `Collections.unmodifiableMap` after population
    - _Requirements: 3.1, 3.2, 3.3, 3.4, 4.2_

  - [ ] 5.2 Create `ShippingDemo.java`
    - Package: `org.designpattern.creational.factory.ecommerce`
    - Class-level Javadoc explaining Factory Pattern intent and OCP benefit (see design §5)
    - `main()` loops over all four `ShippingType` constants; obtains each `ShippingMethod` via `ShippingFactory.createShipping()`; prints method name, cost, delivery days, and calls `ship()`
    - Private helper `printShippingInfo(ShippingMethod, String)` for the output block
    - Commented-out block showing how `DroneShipping` would be added (see design §5)
    - `ShippingDemo` imports only `ShippingMethod`, `ShippingFactory`, and `ShippingType` — **no concrete class imports**
    - _Requirements: 6.1, 6.2, 6.3, 6.4, 7.3_

- [ ] 6. Checkpoint — compile after factory and demo
  - Run `mvn compile -q` and confirm zero errors.
  - Ensure all tests pass, ask the user if questions arise.

- [ ] 7. Write property-based tests
  - [ ] 7.1 Create `ShippingMethodContractProperties.java` in the test package
    - File: `src/test/java/org/designpattern/creational/factory/ecommerce/ShippingMethodContractProperties.java`
    - Annotate class with `@net.jqwik.api.Label("ecommerce-shipping contract properties")`
    - **Property 1: Factory routing and interface contract** — `@ForAll ShippingType type` → assert returned `ShippingMethod` is non-null, `getCost() > 0`, `getEstimatedDeliveryDays() >= 0`
      - **Validates: Requirements 1.2, 1.3, 3.1, 3.2, 4.3**
    - **Property 2: `createShipping(null)` throws with descriptive message** — `@Property(tries = 1)` → assert `IllegalArgumentException` thrown with non-blank message
      - **Validates: Requirement 3.3**
    - **Property 3: `ship()` output always contains the orderId** — `@ForAll ShippingType type`, `@ForAll @NotBlank String orderId` → capture `System.out` with `ByteArrayOutputStream`, assert output contains `orderId`
      - **Validates: Requirement 2.5**
    - **Property 4: Factory returns exact registered concrete type** — `@ForAll ShippingType type` → assert runtime class matches expected concrete class per enum constant (use `switch` expression)
      - **Validates: Requirements 3.2, 5.2**
    - **Property 5: Cost values are exact for all registered types** — `@ForAll ShippingType type` → assert `getCost()` equals documented flat rate via `switch` expression
      - **Validates: Requirements 2.1, 2.2, 2.3, 2.4**
    - **Property 6: Delivery days are non-negative for all registered types** — `@ForAll ShippingType type` → assert `getEstimatedDeliveryDays() >= 1`
      - **Validates: Requirements 1.3, 2.1, 2.2, 2.3, 2.4**
    - _Requirements: 1.2, 1.3, 2.1–2.5, 3.1–3.3, 4.3_

- [ ] 8. Write example-based unit tests
  - [ ] 8.1 Create `ShippingFactoryTest.java` in the test package
    - File: `src/test/java/org/designpattern/creational/factory/ecommerce/ShippingFactoryTest.java`
    - Use JUnit Jupiter `@Test` annotations; assert with JUnit `Assertions` or AssertJ
    - `standardShipping_cost` — `new StandardShipping().getCost() == 5.99`
    - `expressShipping_cost` — `new ExpressShipping().getCost() == 15.99`
    - `overnightShipping_cost` — `new OvernightShipping().getCost() == 29.99`
    - `internationalShipping_cost` — `new InternationalShipping().getCost() == 49.99`
    - `standardShipping_deliveryDays` — `getEstimatedDeliveryDays() == 5`
    - `expressShipping_deliveryDays` — `getEstimatedDeliveryDays() == 2`
    - `overnightShipping_deliveryDays` — `getEstimatedDeliveryDays() == 1`
    - `internationalShipping_deliveryDays` — `getEstimatedDeliveryDays() == 10`
    - `factory_null_throws` — `createShipping(null)` throws `IllegalArgumentException` with non-blank message
    - `factory_is_not_instantiable` — verify `ShippingFactory` constructor is `private` via reflection
    - `demo_exercises_all_types` — redirect `System.out`, call `ShippingDemo.main(new String[]{})`, assert output contains identifiers for all four shipping types
    - _Requirements: 2.1–2.4, 3.3, 6.2, 6.3, 7.2_

- [ ] 9. Checkpoint — run full test suite
  - Run `mvn test` and confirm all property tests (Properties 1–6) and all unit tests pass.
  - Ensure all tests pass, ask the user if questions arise.

- [ ] 10. Final verification
  - [ ] 10.1 Run `mvn test` (full clean build + all tests)
    - Confirm `BUILD SUCCESS`, zero failures, zero errors
    - Confirm the test report includes both `ShippingMethodContractProperties` and `ShippingFactoryTest`
    - _Requirements: 7.1, 7.2, 7.3_

---

## Notes

- Tasks marked with `*` are optional and can be skipped for faster MVP
- Each task references specific requirements from `requirements.md` for traceability
- Checkpoints (tasks 4, 6, 9) provide incremental validation — fix any errors before proceeding
- Property tests (task 7.1) validate universal invariants using jqwik (1000 iterations per property by default)
- Unit tests (task 8.1) validate specific constants and error conditions
- `ShippingDemo` must **never** import a concrete shipping class — only `ShippingMethod`, `ShippingFactory`, `ShippingType`
- `ShippingFactory.createShipping()` method body must contain **zero `if/else/switch`** statements

## Task Dependency Graph

```json
{
  "waves": [
    { "id": 0, "tasks": ["1.1"] },
    { "id": 1, "tasks": ["2.1", "2.2"] },
    { "id": 2, "tasks": ["3.1", "3.2", "3.3", "3.4"] },
    { "id": 3, "tasks": ["5.1"] },
    { "id": 4, "tasks": ["5.2"] },
    { "id": 5, "tasks": ["7.1", "8.1"] },
    { "id": 6, "tasks": ["10.1"] }
  ]
}
```
