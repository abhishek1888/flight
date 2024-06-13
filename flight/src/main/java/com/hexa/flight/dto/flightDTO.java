package com.hexa.flight.dto;

import java.time.LocalDateTime;


public class flightDTO {
    private String flightnumber;
    private String airline;
    private String departureairport;
    private String arrivalairport;
    private LocalDateTime departuredatetime;
    private LocalDateTime arrivaldatetime;
    private double ticketprice;
	public flightDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public flightDTO(String flightnumber, String airline, String departureairport, String arrivalairport,
			LocalDateTime departuredatetime, LocalDateTime arrivaldatetime, double ticketprice) {
		super();
		this.flightnumber = flightnumber;
		this.airline = airline;
		this.departureairport = departureairport;
		this.arrivalairport = arrivalairport;
		this.departuredatetime = departuredatetime;
		this.arrivaldatetime = arrivaldatetime;
		this.ticketprice = ticketprice;
	}
	public String getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDepartureairport() {
		return departureairport;
	}
	public void setDepartureairport(String departureairport) {
		this.departureairport = departureairport;
	}
	public String getArrivalairport() {
		return arrivalairport;
	}
	public void setArrivalairport(String arrivalairport) {
		this.arrivalairport = arrivalairport;
	}
	public LocalDateTime getDeparturedatetime() {
		return departuredatetime;
	}
	public void setDeparturedatetime(LocalDateTime departuredatetime) {
		this.departuredatetime = departuredatetime;
	}
	public LocalDateTime getArrivaldatetime() {
		return arrivaldatetime;
	}
	public void setArrivaldatetime(LocalDateTime arrivaldatetime) {
		this.arrivaldatetime = arrivaldatetime;
	}
	public double getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	@Override
	public String toString() {
		return "flight [flightnumber=" + flightnumber + ", Airline=" + airline + ", departureairport="
				+ departureairport + ", arrivalairport=" + arrivalairport + ", departuredatetime=" + departuredatetime
				+ ", arrivaldatetime=" + arrivaldatetime + ", ticketprice=" + ticketprice + "]";
	}
}
