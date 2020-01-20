package org.belldj.vehicles.server.vehicle.domain;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.belldj.vehicles.server.vehicle.infrastructure.VehicleDao;
import org.belldj.vehicles.server.vehicle.infrastructure.VehicleE;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class VehicleRespository {

  @Mapper
  public interface VehicleRepositoryMapper {
    Vehicle map(VehicleE src);
    VehicleE map(Vehicle src);
    VehicleE map(Vehicle src, @MappingTarget VehicleE target);
  }

  public static final VehicleRepositoryMapper mapper = Mappers.getMapper(VehicleRepositoryMapper.class);

  private final VehicleDao vehicleDao;
  private final ApplicationEventPublisher eventBus;

  @Inject
  public VehicleRespository(VehicleDao vehicleDao, ApplicationEventPublisher eventBus) {
    this.vehicleDao = vehicleDao;
    this.eventBus = eventBus;
  }

  @Transactional
  public Vehicle create(Vehicle vehicle) {
    if (vehicleDao.existsById(vehicle.getId())) {
      throw new VehicleException(String.format("Vehicle with id \"%s\" already exists", vehicle.getId()));
    }
    var saved = vehicleDao.save(mapper.map(vehicle));
    var result = mapper.map(saved);
    eventBus.publishEvent(VehicleCreatedEvent.of(result));
    System.out.println("create: " + result);
    return result;
  }

  public List<Vehicle> all() {
    var list = vehicleDao.findAll();
    System.out.println("list :" + list);
    return list.stream().map(mapper::map).collect(Collectors.toList());
  }

}
