package com.hexa.flight.service;

import java.util.List;

import com.hexa.flight.dto.flightDTO;

public interface flightservice {
     public List<flightDTO> getallflights();
     public flightDTO getflightbyid(String flightnumber);
     public flightDTO createflight(flightDTO flightdto);
     public flightDTO updateflight(flightDTO flightdto,String flightnumber);
     public String deleteflight(String flightnumber);
     
}
