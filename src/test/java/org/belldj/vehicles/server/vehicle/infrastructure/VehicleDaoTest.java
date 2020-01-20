package org.belldj.vehicles.server.vehicle.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.inject.Inject;
import org.belldj.vehicles.server.vehicle.infrastructure.VehicleDao;
import org.belldj.vehicles.server.vehicle.infrastructure.VehicleE;
import org.junit.jupiter.api.Test;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class VehicleDaoTest {

  private static final UUID ID = UUID.randomUUID();
  
  @Inject
  private VehicleDao dao;

  @SuppressWarnings("preview")
  @Test
  void test() {

    var p = new VehicleE();
    
    p.setId(ID);
    p.setCreatedDate(LocalDateTime.now());
    p.setName("Cherry");

    p = dao.save(p);
    
    assertThat(p).isNotNull();
    
    var opt = dao.findById(ID);
    
    assertThat(opt.isPresent()).isTrue();
    
  }

}
