package org.belldj.vehicles.server.vehicle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import javax.inject.Inject;
import org.belldj.vehicles.server.vehicle.domain.Vehicle;
import org.belldj.vehicles.server.vehicle.domain.VehicleService;
import org.belldj.vehicles.server.vehicle.web.VehicleAddCommandT;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class VehicleServiceTest {

  @Inject
  private VehicleService service;

  @Test
  void testAdd() {

    var cmd = VehicleAddCommandT.builder()
      .name("main")
      .build();

    var vehicle = service.create(cmd);

    assertThat(vehicle).isNotNull();
  }

  @Test
  void testAll() {
    var vehicles = service.findAll();
    assertThat(vehicles).isNotNull();
  }

}
