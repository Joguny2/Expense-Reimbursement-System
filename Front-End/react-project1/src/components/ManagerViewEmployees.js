import axios from 'axios'
import React, { useEffect, useState } from 'react'

const ManagerViewEmployees = () => {
    const localStor = JSON.parse(localStorage.getItem('user'))
    const [employees, setEmployees] = useState([])

    useEffect(() => {
        axios.get('http://localhost:7777/ManagerViewEmployees')
            .then(response => {
                setEmployees(response.data)
                console.log(employees.length)
                console.log(response.data)
            })
            .catch(error => {
                console.log(error)
            })
    }, [])

    return (
        <div>
            <ul>
                {employees.map(employee => (
                    <li key={employee.username}>{employee.firstname} {employee.lastname}<br></br>
                                         Username: {employee.username}<br></br>
                        {employee.email}<br></br>
                        {employee.phonenumber}
                        <br></br><br></br></li>
                ))}
            </ul>
        </div>
    )
}

export default ManagerViewEmployees
