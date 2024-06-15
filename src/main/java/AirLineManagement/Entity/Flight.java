package AirLineManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String flightNumber;
	    private String destination;

	    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	    @JoinColumn(name = "airline_id",referencedColumnName = "id")
	    @JsonIgnoreProperties("flights")
	    private Airline airline;

		public Flight() {
			super();
		}

		public Flight(Long id, String flightNumber, String destination, Airline airline) {
			super();
			this.id = id;
			this.flightNumber = flightNumber;
			this.destination = destination;
			this.airline = airline;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public Airline getAirline() {
			return airline;
		}

		public void setAirline(Airline airline) {
			this.airline = airline;
		}
	    
	    

}
