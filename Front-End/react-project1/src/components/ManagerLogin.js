import React, { Component } from 'react'
import axios from 'axios'
import { useHistory, Link } from 'react-router-dom';
import Welcome from './Welcome';


const ManagerLogin = () => {
    const username = React.useRef(null);
    const password = React.useRef(null);
    const history = useHistory()

    const handleLogin = e => {
        e.preventDefault();

        const data = {
            username: username.current.value,
            password: password.current.value,
        }

        axios.post('http://localhost:7777/ManagerLogin', data)
            .then(response => {
                console.log(response.data)
                localStorage.setItem('user', JSON.stringify(response.data))
                history.push('/ManagerHome')
            })
            .catch(error => {
                console.log(error)
            })
    };

    return (
        <div>
            <div><Welcome></Welcome></div>
            <div><h2>Login as a Manager</h2></div>
            <div>
                <form onSubmit={handleLogin}>
                    <div><input type="text" placeholder="username" ref={username} /></div>
                    <div><input type="password" placeholder="password" ref={password} /></div>
                    <button type="submit" className="myButton">Login</button>
                </form>
            </div>
            <div>
                <h3>Not a Manager?</h3>
                <Link to="/">Click to Login an Employee</Link>
            </div>
        </div>
    );
}

export default ManagerLogin