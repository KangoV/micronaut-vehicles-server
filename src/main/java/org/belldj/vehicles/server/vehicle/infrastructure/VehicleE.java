package org.belldj.vehicles.server.vehicle.infrastructure;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;

@Entity
@Table(name = "vehicle")
public final class VehicleE {

  @Id
  @TypeDef(type = DataType.OBJECT)
  @Column(columnDefinition = "uuid", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "name", nullable = true)
  private String name;

  @Column(name = "created", nullable = false, updatable = false)
  private LocalDateTime createdDate;

  /*
   * ### ### getters/ setters ###
   */

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime created) {
    this.createdDate = created;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
