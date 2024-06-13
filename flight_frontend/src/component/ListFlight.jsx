import React,{useState,useEffect} from 'react'
import axios from 'axios'
import {Link} from 'react-router-dom'
export const ListFlight = () => {
    const [flightList,setflightlist]=useState([])
    
    const getflightList = async ()=>{
          const result = await axios.get("http://localhost:8080/api/flights/getallflight");
          setflightlist(result.data);

    }
    const deleteflight= async(flightnumber)=>{
        const result= await axios.delete("http://localhost:8080/api/flights/deleteflight?flightnumber="+flightnumber);
        getflightList();
    }

    useEffect(()=>{
        getflightList();
    },[])

  return (
    <div className="table table-striped table-bordered">
         <Link to="/add">
           <div className="btn btn-success">Add</div>
         </Link>
         <thead>
             <tr>
                <td>flightnumber</td>
                <td>airline</td>
                <td>departureairport</td>
                <td>arrivalairport</td>
                <td>departuredatetime</td>
                <td>arrivaldatetime</td>
                <td>ticketprice</td>
                <td>Update</td>
                <td>delete</td>
             </tr>
         </thead>
         <tbody>
            {
                flightList.map(flight=>{
                    const fnumber = flight.flightnumber;
                    return (
                    <tr>
                      <td>{flight.flightnumber}</td>
                      <td>{flight.airline}</td>
                      <td>{flight.departureairport}</td>
                      <td>{flight.arrivalairport}</td>
                      <td>{flight.departuredatetime}</td>
                      <td>{flight.arrivaldatetime}</td>
                      <td>{flight.ticketprice}</td>
                      <td>
                         <Link to={`/update/${fnumber}`}>
                              <div className="btn btn-primary">Update</div>
                         </Link>
                      </td>
                      <td>
                      <div className="btn btn-danger" onClick={(e)=>{deleteflight(flight.flightnumber)}}>Delete</div>
                      </td>
                    </tr>
                )})
            }
         </tbody>
    </div>
  )
}
