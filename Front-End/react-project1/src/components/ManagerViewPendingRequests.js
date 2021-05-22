import axios from 'axios'
import React, { useEffect, useState } from 'react'

const ManagerViewPendingRequests = () => {

    const [requests, setRequests] = useState([])

    useEffect(() => {
        axios.get('http://localhost:7777/ManagerViewPendingRequests')
            .then(response => {
                setRequests(response.data)
                alert("form submitted")
                console.log(requests.length)
                console.log(response.data)
            })
            .catch(error => {
                console.log(error)
            })
    }, []) 

    return (
        <div>
            <ul>
                {requests.map(request => (
                    <li key={request.ID}>Request for ${request.amount} | By: {request.username}<br></br>
                                         Reason: {request.type}<br></br>
                                         {request.description}<br></br>
                                         Status: {request.status
                                         }<br></br><br></br></li>
                    ))}
            </ul>
        </div>
    )
}

export default ManagerViewPendingRequests
