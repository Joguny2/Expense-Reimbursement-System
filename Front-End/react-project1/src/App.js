import logo from './logo.svg';
import EmployeeLogin from './components/EmployeeLogin';
import Welcome from './components/Welcome'
import ManagerLogin from './components/ManagerLogin'
import EmployeeInfo from './components/EmployeeInfo'
import './App.css';
import {
  BrowserRouter as Router,
  Route,
  Switch,
} from 'react-router-dom';
import EmployeeHome from './components/EmployeeHome';
import EmployeeReimbursementForm from './components/EmployeeReimbursementForm';
import EmployeeViewReimbursements from './components/EmployeeViewReimbursements';
import ManagerHome from './components/ManagerHome';
import ManagerViewEmployees from './components/ManagerViewEmployees';
import ManagerViewPendingRequests from './components/ManagerViewPendingRequests';


function App() {
  return (
    <Router>
    <div className="App">
      <Switch>
        <Route exact path="/" component={EmployeeLogin} />
        <Route exact path="/ManagerLogin" component={ManagerLogin} />
        <Route exact path="/Welcome" component={Welcome} />
        <Route exact path="/EmployeeHome" component={EmployeeHome} />
        <Route exact path="/EmployeeInfo" component={EmployeeInfo} />
        <Route exact path="/EmployeeReiumbursementForm" component={EmployeeReimbursementForm} />
        <Route exact path="/EmployeeViewReimbursements" component={EmployeeViewReimbursements} />
        <Route exact path="/ManagerHome" component={ManagerHome} />
        <Route exact path="/ManagerViewEmployees" component={ManagerViewEmployees} />
        <Route exact path="/ManagerViewPendingRequests" component={ManagerViewPendingRequests} />
        
      </Switch>
    </div>
    
    </Router>
  );
}

export default App;
