public class BusBuilder implements Builder {
    private VehicleType type;
    private int seats;
    private Engine engine;

    @Override
    public void setVehicleType(VehicleType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Bus getResult(){
        return new Bus(type, seats, engine);
    }
}
