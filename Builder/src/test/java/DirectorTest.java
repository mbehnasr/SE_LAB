import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectorTest {

    @Test
    void testDirector() {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructCar(builder);
        Car car = builder.getResult();
        assertEquals(car.getType(), VehicleType.CAR);
        BusBuilder busBuilder = new BusBuilder();
        director.constructBus(busBuilder);
        Bus bus = busBuilder.getResult();
        assertEquals(bus.getType(), VehicleType.BUS);
    }


}