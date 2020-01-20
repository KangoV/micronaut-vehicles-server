/**
 *
 */
package org.belldj.vehicles.server.vehicle.domain;

import org.belldj.vehicles.server.util.Event;
import org.immutables.value.Value;

@Event
@Value.Immutable(builder = false)
public interface VehicleCreatedEventSpec { 
  @Value.Parameter(order = 1)
  Vehicle getVehicle();
}
