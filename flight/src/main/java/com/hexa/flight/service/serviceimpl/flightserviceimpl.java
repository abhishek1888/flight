package com.hexa.flight.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.flight.dto.flightDTO;
import com.hexa.flight.entity.flight;
import com.hexa.flight.repository.flightrepository;
import com.hexa.flight.service.flightservice;

@Service
public class flightserviceimpl implements flightservice{

	 @Autowired
	 private ModelMapper modelmapper;
	 @Autowired
	 private flightrepository frepository;
	 
	@Override
	public List<flightDTO> getallflights() {
		List<flight> flightlist=frepository.findAll();
		return flightlist.stream().map(flight->modelmapper.map(flight, flightDTO.class)).collect(Collectors.toList());
	}

	@Override
	public flightDTO getflightbyid(String flightnumber) {
		// TODO Auto-generated method stub
		flight newflight=frepository.findById(flightnumber).get();
		return modelmapper.map(newflight, flightDTO.class);
	}

	@Override
	public flightDTO createflight(flightDTO flightdto) {
		// TODO Auto-generated method stub
		flight flight1=modelmapper.map(flightdto, flight.class);
		flight newflight=frepository.save(flight1);
		return modelmapper.map(newflight, flightDTO.class);
	}

	@Override
	public flightDTO updateflight(flightDTO flightdto, String flightnumber) {
		flight newflight=frepository.findById(flightnumber).get();
		if(flightdto.getAirline()!=null)
			newflight.setAirline(flightdto.getAirline());
		if(flightdto.getArrivalairport()!=null)
			newflight.setArrivalairport(flightdto.getArrivalairport());
		if(flightdto.getDepartureairport()!=null)
			newflight.setDepartureairport(flightdto.getDepartureairport());
		if(flightdto.getArrivaldatetime()!=null)
			newflight.setArrivaldatetime(flightdto.getArrivaldatetime());
		if(flightdto.getDeparturedatetime()!=null)
			newflight.setDeparturedatetime(flightdto.getDeparturedatetime());
		if(flightdto.getTicketprice()!=0)
			newflight.setTicketprice(flightdto.getTicketprice());
			
	   flight updatedflight=frepository.save(newflight);
	   return modelmapper.map(updatedflight, flightDTO.class);
			
	}

	@Override
	public String deleteflight(String flightnumber) {
		frepository.deleteById(flightnumber);
		return "flight deleted";
	}

}
