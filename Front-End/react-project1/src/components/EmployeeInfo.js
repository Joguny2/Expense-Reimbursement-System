import React from 'react'
import { useHistory } from 'react-router-dom'
import axios from 'axios'
import {useState, useEffect} from 'react'
import { useGoBackTo } from '../util/useGoBackTo'

function EmployeeInfo(props) {
    const [locationKeys, setLocationKeys] = useState([])
    const history = useHistory()

    useGoBackTo(history, '/EmployeeHome')

    const localStor = JSON.parse(localStorage.getItem('user'))
    const [user, setUser] = useState(localStor)
    console.log(user)

    const info = {
            username: user.username,
            email: user.email,
            phonenumber: user.phonenumber
    }

    const info2 = {
        email: localStor.email,
        phonenumber: localStor.phonenumber

    }

    async function postChange(path) {
        localStorage.setItem('user', JSON.stringify(user))
        console.log(info.phonenumber)
        await axios.post(path, info)
            .then(response => {
                localStorage.setItem('user', JSON.stringify(user))
                history.push('/EmployeeInfo', user)
            })
            .catch(error => {
                console.log(error)
            })
    }

    const handleChangeEmail = (event) => {     
        event.preventDefault()
        postChange('http://localhost:7777/EmployeeHome/Info/UpdateEmail')
    }

    const handleChangePhone = (event) => {
        event.preventDefault()
        postChange('http://localhost:7777/EmployeeHome/Info/UpdatePhone')
    }
    
    return (
        <div>
            <br></br><br></br> 
            Email: {info2.email} 
                <form onSubmit={handleChangeEmail}>
                    <input type="email" placeholder="newemail@domain.com" onChange={e => setUser({...user, email:e.target.value})} />
                    <button type="submit" >update</button>
                </form> <br></br>
            phonenumber: {info2.phonenumber}
                <form onSubmit={handleChangePhone}>
                    <input type="tel" placeholder="new phonenumber" onChange={e => setUser({...user, phonenumber:e.target.value})} />
                    <button type="submit" >update</button>
                </form> <br></br>
        </div>
    )
}

export default EmployeeInfo
