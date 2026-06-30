public class Main {
     public static void main(String[] args) {
        System.out.println("=== INITIALIZING FLIGHT TELEMETRY SIMULATION ===");

        // 1. Create a rocket object
        // Mass = 10.0kg, Initial Velocity = 350.0 m/s (Mach 1.02), Drag Co = 0.2
        Flight rocket = new Flight(10.0, 350.0, 0.2);

        // 2. Create the tracking station and link it to our rocket object reference
        Telemetry station = new Telemetry("STATION_ALPHA", rocket);

        // 3. Print initial boot configuration states
        System.out.println("Rocket Starting Velocity: " + rocket.getVelocity() + " m/s");
        System.out.println("Station Connection Lost Flag: " + station.isLost());

        // 4. Execute Step 1 (Low Air Density - High Altitude Flight)
        System.out.println("\n--- RUNNING TELEMETRY STEP 1 (High Altitude Thick Air) ---");
        station.processFlightStep(0.05);
        System.out.println("Updated Velocity: " + rocket.getVelocity() + " m/s");
        System.out.println("Global Max Kinetic Energy Tracked: " + Telemetry.maxEnergy + " Joules");
        System.out.println("Station Connection Lost Flag: " + station.isLost());

        // 5. Execute Step 2 (High Air Density - Rocket entering dense air pockets)
        // This will trigger your complex multi-object boundary failure thresholds!
        System.out.println("\n--- RUNNING TELEMETRY STEP 2 (Dense Re-entry Atmosphere) ---");
        station.processFlightStep(0.95);
        System.out.println("Final Rocket Velocity: " + rocket.getVelocity() + " m/s");
        System.out.println("Global Max Kinetic Energy Tracked: " + Telemetry.maxEnergy + " Joules");
        System.out.println("Station Connection Lost Flag: " + station.isLost());
    }
}
