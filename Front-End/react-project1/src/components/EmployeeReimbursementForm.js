import React, { useState } from 'react'
import axios from 'axios'
import { useHistory } from 'react-router'
import { useAlert } from 'react-alert'

function EmployeeReimbursementForm() {
    
    const localStor = JSON.parse(localStorage.getItem('user'))
    const [amount, setAmount] = useState(0)
    const [type, setType] = useState('')
    const [description, setDescription] = useState('')
    const history = useHistory()

    const data = {
        amount: amount,
        type: type,
        description: description,
        username: localStor.username
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        axios.post('http://localhost:7777/EmployeeReimbursement', data)
            .then(response => {
                alert("form submitted")
                history.push('/EmployeeHome')
            })
            .catch(error => {
                console.log(error)
            })

    };
    
    return (
        <div>
            <div><h2>Submit a Reimbursement Request</h2></div>
            <div>
                <form onSubmit={handleSubmit}>
                    <div>Amount: $<input type="text" placeholder="e.g 1000" onChange={e => setAmount(e.target.value)} /></div>
                    <div>Type: <input type="text" placeholder="Travel, Housing, etc.." onChange={e => setType(e.target.value)} /></div>
                    <div>Description: <input type="text" style={{ width:"400px" }} placeholder="e.g. Plane ticket to Hawaii for meeting" onChange={e => setDescription(e.target.value)} /></div>
                    <br></br>
                    <button type="submit" className="myButton">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default EmployeeReimbursementForm
