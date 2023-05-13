public class Bus {
    private final VehicleType type;
    private final int seats;
    private final Engine engine;

    public Bus(VehicleType type, int seats, Engine engine) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }
}
