package org.belldj.vehicles.server.vehicle.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import com.fasterxml.uuid.Generators;

public final class Vehicle {

  public static Vehicle.Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private UUID id;
    private String name;
    private LocalDateTime createdDate;
    public Vehicle.Builder id(UUID id)                                { this.id = id; return this; }
    public Vehicle.Builder name(String name)                          { this.name = name; return this; }
    public Vehicle.Builder createdDate(LocalDateTime created)         { this.createdDate = created; return this; }
    public Vehicle build() {
      return new Vehicle(this);
    }
  }

  private final UUID id;
  private final String name;
  private final LocalDateTime createdDate;

  private Vehicle(Vehicle.Builder b) {
    this.id          = (b.id == null) ? Generators.timeBasedGenerator().generate() : b.id;
    this.name        = b.name;
    this.createdDate = (b.createdDate == null) ? LocalDateTime.now() : b.createdDate;
  }

  public UUID getId()                       { return this.id; }
  public String getName()                   { return this.name;  }
  public LocalDateTime getCreatedDate()     { return this.createdDate; }

}
