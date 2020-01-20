package org.belldj.vehicles.server.vehicle.infrastructure;

import java.util.List;
import java.util.UUID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface VehicleDao extends CrudRepository<VehicleE, UUID> {

  @Override
  @Query(value = "select * from vehicle")
  List<VehicleE> findAll(); // empty

}

