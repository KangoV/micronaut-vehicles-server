package org.belldj.vehicles.server.vehicle.web;

import java.time.LocalDateTime;
import java.util.UUID;
import org.belldj.vehicles.server.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = VehicleT.class)
@JsonDeserialize(as = VehicleT.class)
@JsonInclude(Include.NON_NULL)
@Schema(name = "RegisteredBuild", description = "The registered Build")
public interface VehicleSpec {

  UUID getId();

  String getName();

  LocalDateTime getCreatedDate();

}