package org.belldj.vehicles.server.vehicle.domain;

import java.util.List;

public interface VehicleApi {

  public interface VehicleAddCommand {
    String getName();
  }

  Vehicle create(VehicleAddCommand build);
  
  List<Vehicle> findAll();

}
