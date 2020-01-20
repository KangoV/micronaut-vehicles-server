package org.belldj.vehicles.server.vehicle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.UUID;
import org.belldj.vehicles.server.vehicle.domain.Vehicle;
import org.belldj.vehicles.server.vehicle.web.VehicleAddCommandT;
import org.belldj.vehicles.server.vehicle.web.VehicleController;
import org.belldj.vehicles.server.vehicle.web.VehicleT;
import org.junit.jupiter.api.Test;

class VehicleTest {

  private UUID VEHICLE_ID = UUID.randomUUID();
  private LocalDateTime NOW = LocalDateTime.now();
  
  @Test
  void test_AddVehicleCommand() {

    var vehicle = VehicleAddCommandT.builder()
      .name("Cherry")
      .build();
    
    assertThat(vehicle).isNotNull();
    
  }

  @Test
  void testVehicle() {
    var vehicle = VehicleT.builder()
      .id(VEHICLE_ID)
      .name("Cherry")
      .createdDate(LocalDateTime.now())
      .build();
    assertThat(vehicle).isNotNull();
  }

  @Test
  void test_map_from_Vehicle_to_VehicleT() {

    var vehicle = Vehicle.builder()
      .id(VEHICLE_ID)
      .name("darren")
      .createdDate(NOW)
      .build();
    assertThat(vehicle).isNotNull();

    var vehicle_t = VehicleController.mapper.map(vehicle);
    
    assertThat(vehicle_t).isEqualTo(VehicleT.builder()
      .id(VEHICLE_ID)
      .name("darren")
      .createdDate(NOW).build());

  }


}
