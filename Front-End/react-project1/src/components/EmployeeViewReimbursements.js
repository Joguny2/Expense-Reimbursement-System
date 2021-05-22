import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { useAlert } from 'react-alert'

const EmployeeViewReimbursements = () => {
    const localStor = JSON.parse(localStorage.getItem('user'))
    const [requests, setRequests] = useState([])

    useEffect(() => {
        axios.post('http://localhost:7777/EmployeeViewReimbursements', {username: localStor.username})
            .then(response => {
                setRequests(response.data)
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
                    <li key={request.ID}>${request.amount}<br></br>
                                         For: {request.type}<br></br>
                                         {request.description}<br></br>
                                         Status: {request.status
                                         }<br></br><br></br></li>
                    ))}
            </ul>
        </div>
    )
}

export default EmployeeViewReimbursements
