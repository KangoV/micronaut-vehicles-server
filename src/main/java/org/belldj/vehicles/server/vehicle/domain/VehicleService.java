package org.belldj.vehicles.server.vehicle.domain;

import java.util.List;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import io.micronaut.context.event.ApplicationEventPublisher;

@Singleton
public class VehicleService implements VehicleApi {

  @Mapper
  public interface VehicleServiceMappers {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    Vehicle map(VehicleAddCommand command);
  }

  public static final VehicleServiceMappers mapper = Mappers.getMapper(VehicleServiceMappers.class);
  private final VehicleRespository repository;
  private ApplicationEventPublisher publisher;

  public VehicleService(VehicleRespository respository, ApplicationEventPublisher publisher) {
    this.repository = respository;
    this.publisher = publisher;
  }

  @Override
  public List<Vehicle> findAll() {
    return repository.all();
  }

  @Transactional
  @Override
  public Vehicle create(VehicleAddCommand command) {
    var vehicle = mapper.map(command);
    vehicle = repository.create(vehicle);
    publisher.publishEvent(VehicleCreatedEvent.of(vehicle));
    return vehicle;
  }

}
