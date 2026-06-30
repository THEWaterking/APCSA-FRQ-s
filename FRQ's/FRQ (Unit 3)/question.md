# AP CSA Unit 3 Challenge: Aerodynamic Projectile Tracker

## Class 1 of 2: The FlightProfile Class

Manages the physics calculations of the tracking flight loop.

* **Instance Variables (Private):**
  * `double mass` — Current mass of the projectile in kilograms.
  * `double velocity` — Current forward velocity in meters per second.
  * `double dragCoefficient` — Aerodynamic structural surface drag multiplier.
* **Constructor:**
  * Accepts `mass`, `velocity`, and `dragCoefficient`. Must use `this` keyword to map them.
* **Accessor Methods:**
  * `getVelocity()` -> returns `velocity`
  * `getMass()` -> returns `mass`
* **Math Methods:**
  * `calculateKineticEnergy()` -> Returns a `double`. Formula: 0.5 *mass* velocity^2
  * `applyAerodynamicDrag(double airDensity)` -> Mutator method:
        1. Calculate Drag Force: Fd = 0.5 *dragCoefficient* airDensity * velocity^2
        2. Calculate Deceleration: a = Fd / mass
        3. Subtract deceleration from the `velocity` instance variable.
        4. If `velocity` drops below 0.0, clamp it exactly to 0.0.

---

### Class 2 of 2: The TelemetryGateway Class

Manages telemetry processing loops and tracks global simulations.

* **Static Variables (Public):**
  * `static double maxEnergyObserved` — Track highest kinetic energy computed across ALL objects.
* **Instance Variables (Private):**
  * `String hardwareID` — Serial identifier.
  * `FlightProfile activeProfile` — Embedded tracking target reference pointer.
  * `boolean signalLost` — Emergency system disruption state tracker.
* **Constructor:**
  * Accepts `hardwareID` and a `FlightProfile` object. `signalLost` defaults to false.
* **Control Loops:**
  * `processFlightStep(double localAirDensity)` -> High-tier control mutator:
        1. If `signalLost` is true, immediately exit (return).
        2. Call `applyAerodynamicDrag(localAirDensity)` on the attached profile object.
        3. Compute current kinetic energy using the profile's calculation method.
        4. If this step's energy is > `maxEnergyObserved`, update the static variable to match it.
        5. Safety Check: If `velocity` > 343.0 AND current kinetic energy > 1000000.0, set `signalLost` to true.
