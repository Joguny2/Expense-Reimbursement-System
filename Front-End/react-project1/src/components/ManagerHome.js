import React from 'react'
import { Link } from 'react-router-dom';

const ManagerHome = (props) => {
    const localStor = JSON.parse(localStorage.getItem('user'))
    console.log(localStor)

    // handle click event of logout button
    const handleLogout = () => {
        //removeUserSession();
        props.history.push('/');
        localStorage.removeItem('user')
    }

    return (
        <div>

            Welcome {localStor.firstname}!<br /><br />

            <div>
                <Link to="/ManagerViewEmployees">View all Employees</Link>
                <br></br>
                <br></br>
            </div>
            <div>
                <Link to="/ManagerViewPendingRequests">View Pending requests from all employees</Link>
                <br></br>
                <br></br>
            </div>
            <div>
                <Link to="/ManagerViewRequestForOne">View Requests for one employee</Link>
                <br></br>
                <br></br>
            </div>

            <input type="button" onClick={handleLogout} value="Logout" />

        </div>
    );
}

export default ManagerHome
