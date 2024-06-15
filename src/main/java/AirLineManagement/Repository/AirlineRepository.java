package AirLineManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import AirLineManagement.Entity.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

}
