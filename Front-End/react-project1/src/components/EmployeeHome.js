import getUser from "../util/userSession";
import { Link, useHistory } from 'react-router-dom'

function EmployeeHome(props) {

    const localStor = JSON.parse(localStorage.getItem('user'))

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
                <Link to="/EmployeeInfo">View your and update your info</Link>
            </div>
            <div>
                <Link to="/EmployeeReiumbursementForm">Submit a Reimbursement Request</Link>
            </div>
            <div>
                <Link to="/EmployeeViewReimbursements">View your Reimbursement Requests</Link>
            </div>

            <input type="button" onClick={handleLogout} value="Logout" />

        </div>
    );
}

export default EmployeeHome;