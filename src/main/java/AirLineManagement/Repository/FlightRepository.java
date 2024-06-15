package AirLineManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import AirLineManagement.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	Boolean existsByFlightNumber(String flightNumber);

}
