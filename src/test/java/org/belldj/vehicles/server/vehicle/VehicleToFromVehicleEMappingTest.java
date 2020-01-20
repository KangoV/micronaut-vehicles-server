package org.belldj.vehicles.server.vehicle;

import java.time.LocalDateTime;
import java.util.UUID;
import org.belldj.vehicles.server.vehicle.domain.Vehicle;
import org.belldj.vehicles.server.vehicle.domain.VehicleRespository;
import org.belldj.vehicles.server.vehicle.infrastructure.VehicleE;
import org.junit.jupiter.api.Test;

class VehicleToFromVehicleEMappingTest {

  private UUID VEHICLE_ID = UUID.randomUUID();
  private LocalDateTime NOW = LocalDateTime.now();

  @Test
  void test() {

    var original_vehicle = Vehicle.builder()
      .id(VEHICLE_ID)
      .name("darren")
      .createdDate(NOW)
      .build();

    VehicleE vehicle_e = VehicleRespository.mapper.map(original_vehicle);
    Vehicle vehicle = VehicleRespository.mapper.map(vehicle_e);

//    Assertions.assertThat(vehicle).isEqualTo(original_vehicle);

  }

}
