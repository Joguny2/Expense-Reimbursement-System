import React, { Component } from 'react'
import axios from 'axios'
import { useHistory, Link } from 'react-router-dom';
import Welcome from './Welcome';


const EmployeeLogin = () => {
    const username = React.useRef(null);
    const password = React.useRef(null);
    const history = useHistory()

    const handleLogin = e => {
        e.preventDefault();

        const user = {
            username: username.current.value,
            password: password.current.value,
        }

        axios.post('http://localhost:7777/EmployeeLogin', user)
            .then(response => {
                console.log(response.data)
                localStorage.setItem('user', JSON.stringify(response.data))
                history.push('/EmployeeHome')
            })
            .catch(error => {
                console.log(error)
            })
    };

    return (
        <div>
            <div><Welcome></Welcome></div>
            <div><h2>Login as an Employee</h2></div>
            <div>
                <form onSubmit={handleLogin}>
                    <div><input type="text" placeholder="username" ref={username} /></div>
                    <div><input type="password" placeholder="password" ref={password} /></div>
                    <button type="submit" className="myButton">Login</button>
                </form>
            </div>
            <div>
                <h3>Not an Employee?</h3>
                <Link to="/ManagerLogin">Click to Login as Manager</Link>
            </div>
        </div>
    );
}

export default EmployeeLogin