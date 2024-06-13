package com.hexa.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.flight.entity.flight;

@Repository
public interface flightrepository extends JpaRepository<flight,String>
{

}
