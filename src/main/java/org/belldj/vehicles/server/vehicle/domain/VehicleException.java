package org.belldj.vehicles.server.vehicle.domain;

public class VehicleException extends RuntimeException {

	public VehicleException() {
		super();
	}

	public VehicleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VehicleException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehicleException(String message) {
		super(message);
	}

	public VehicleException(Throwable cause) {
		super(cause);
	}

}
