package org.belldj.vehicles.server.vehicle.web;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.belldj.vehicles.server.vehicle.domain.Vehicle;
import org.belldj.vehicles.server.vehicle.domain.VehicleService;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller(value = "/vehicles", produces = MediaType.APPLICATION_JSON)
@Tag(name = "vehicles")
@Validated
public class VehicleController {

  @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
  public interface VehicleControllerMapper {
    VehicleT map(Vehicle vehicle);
  }

  public static final VehicleControllerMapper mapper = Mappers.getMapper(VehicleControllerMapper.class);

  private VehicleService service;

  public VehicleController(VehicleService service) {
    this.service = service;
  }

  /**
   * Registers a new build
   *
   * @param build The build to register
   * @return The build that was saved
   */
  @Post(uri = "/")
  public HttpResponse<VehicleT> add(@Body @NotNull final VehicleAddCommandT command) {
    Vehicle vehicle = service.create(command);
    System.out.println("add: "+ vehicle);
    return HttpResponse.created(mapper.map(vehicle));
  }

  /**
   * Returns all registered builds
   *
   * @return all registered builds
   */
  @Get(uri = "/")
  public HttpResponse<List<VehicleT>> all() {
    List<VehicleT> result = service.findAll().stream().map(mapper::map).collect(Collectors.toList());
    return HttpResponse.ok(result);
  }

}
