package AirLineManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirLineManagement.Entity.Airline;
import AirLineManagement.Entity.Flight;
import AirLineManagement.Exception.FlightNotAvailableException;
import AirLineManagement.Repository.AirlineRepository;
import AirLineManagement.Repository.FlightRepository;

@Service
public class AirlineService {
	
	 

	    @Autowired
	    private AirlineRepository airlineRepository;

	    @Autowired
	    private FlightRepository flightRepository;
	   
		
	   
	    public Airline saveAirlineWithFlights(Airline airline){	       
	        for (Flight flight : airline.getFlights()) {
	            if (flightRepository.existsByFlightNumber(flight.getFlightNumber())) {
	                throw new FlightNotAvailableException("Flight not available: " + flight.getFlightNumber());
	            }
	            flight.setAirline(airline);
	           
	        }
	        return airlineRepository.save(airline);
	    }
	        

	    public List<Airline> getAllAirlines() {
	        return airlineRepository.findAll();
	    }

	    public Airline getAirlineById(Long id) {
	        return airlineRepository.findById(id).get();
	    }
	    
	    public Optional<Flight> getFlightById(Long id) {
	        return flightRepository.findById(id);
	    }

	    public Airline updateAirline(Long id, Airline airlineDetails) {
	        Airline airline = airlineRepository.findById(id).orElseThrow(() -> new FlightNotAvailableException("Flight not found"));
	        airline.setName(airlineDetails.getName());
	        return airlineRepository.save(airline);
	    }
	    
	    
	    public Flight updateFlight(Long id, Flight flightDetails) {
	        Flight flight = flightRepository.findById(id).orElseThrow(() -> new FlightNotAvailableException("Flight not found"));
	        flight.setFlightNumber(flightDetails.getFlightNumber());
	        flight.setDestination(flightDetails.getDestination());
	        flight.setAirline(flightDetails.getAirline());
	        return flightRepository.save(flight);
	    }


	    public void deleteFlight(Long id) {
	        Flight flight = flightRepository.findById(id).orElseThrow(() -> new FlightNotAvailableException("Flight not found"));
	        flightRepository.delete(flight);
	    }
}
