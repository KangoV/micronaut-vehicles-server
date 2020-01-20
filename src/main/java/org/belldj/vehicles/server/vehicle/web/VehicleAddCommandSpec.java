package org.belldj.vehicles.server.vehicle.web;

import org.belldj.vehicles.server.vehicle.domain.VehicleApi;
import org.belldj.vehicles.server.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = VehicleAddCommandT.class)
@JsonDeserialize(as = VehicleAddCommandT.class)
@Schema(name = "AddVehicleCommand", description = "The vehicle to be added")
public interface VehicleAddCommandSpec extends VehicleApi.VehicleAddCommand {
}