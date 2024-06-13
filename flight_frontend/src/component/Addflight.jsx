import axios from 'axios'
import React,{useState,useEffect} from 'react'
import {Link,useNavigate,useParams} from 'react-router-dom'
export const Addflight=()=>{
     
    const [flightnumber,setflightnumber]=useState("");
    const [airline,setairline]=useState("");
    const [departureairport,setdepartureairport]=useState("");
    const [arrivalairport,setarrivalairport]=useState("");
    const [departuredatetime,setdeparturedatetime]=useState("");
    const [arrivaldatetime,setarrivaldatetime]=useState("");
    const [ticketprice,setticketprice]=useState(0);
    const navigate=useNavigate();
    const {fnumber}=useParams();

    const handleSubmit= async(e)=>{
        e.preventDefault();
        const flight={flightnumber,airline,departureairport,arrivalairport,departuredatetime,arrivaldatetime,ticketprice};
        if(fnumber)
            {
                 const result=await axios.put("http://localhost:8080/api/flights/updateflight?flightnumber="+fnumber,flight);
                 navigate("/");
            }
            else{
                const result=await axios.post("http://localhost:8080/api/flights/createflight",flight);
                navigate("/");
            }
    }

    useEffect(()=>{
             if(fnumber)
                {
                    const getflightbyid= async()=>{
                           const result=await axios.get("http://localhost:8080/api/flights/getflightByid?flightnumber="+fnumber);
                           setflightnumber(result.data.flightnumber);
                           setairline(result.data.airline);
                           setdepartureairport(result.data.departureairport);
                           setarrivalairport(result.data.arrivalairport);
                           setdeparturedatetime(result.data.departuredatetime);
                           setarrivaldatetime(result.data.arrivaldatetime);
                           setticketprice(result.data.ticketprice);
                    }

                    getflightbyid();
                }
    },[])

    return(
      <div>
         <form className="border p-4 rounded" onSubmit={handleSubmit}>
              <div className="form-group  mb-2">
                   <label className="form-label">flightnumber</label>
                   <input type="text" classNmae="form-control" value={flightnumber} onChange={(e)=>setflightnumber(e.target.value)}/>
              </div>
              <div className="form-group  mb-2">
                   <label className="form-label">airline </label>
                   <input type="text" classNmae="form-control" value={airline} onChange={(e)=>setairline(e.target.value)}/>
              </div>
              <div className="form-group  mb-2">
                   <label>departure airport</label>
                   <input type="text" classNmae="form-control" value={departureairport} onChange={(e)=>setdepartureairport(e.target.value)}/>
              </div>
              <div className="form-group  mb-2">
                   <label  className="form-label">arrival airport</label>
                   <input type="text" classNmae="form-control" value={arrivalairport} onChange={(e)=>setarrivalairport(e.target.value)}/>
              </div>
              <div className="form-group  mb-2">
                   <label  className="form-label">departure date</label>
                   <input type="datetime-local" classNmae="form-control" value={departuredatetime} onChange={(e)=>setdeparturedatetime(e.target.value)}/>
              </div>
              <div className="form-group  mb-2">
                   <label  className="form-label">arrival date</label>
                   <input type="datetime-local" classNmae="form-control" value={arrivaldatetime} onChange={(e)=>setarrivaldatetime(e.target.value)}/>
              </div>
              <div className="form-group  mb-2">
                   <label  className="form-label">Ticket price</label>
                   <input type="text" classNmae="form-control" value={ticketprice} onChange={(e)=>setticketprice(e.target.value)}/>
              </div>
              <button type="submit" className="btn btn-success">Submit</button>
              <Link to="/">
                 <button className="btn btn-danger">Cancel</button>
              </Link>
         </form>
      </div>

    )
}