import React, {Component} from 'react';
import logo from './logo.svg';
import "./App.css";
import LoginPage from './LoginPage';
import UserHome from './UserHome';
import{
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            developerbb: [],
            isLoading: false
        };
    }

    componentDidMount() {

    }


    render() {
        return (
            <Router>
                  <img src={logo} className="App-logo" alt="logo"/>
            <Switch>
                <Route  exact path="/">
                <LoginPage/>
                </Route>
                <Route exact path="/home">
                <UserHome/>
                </Route>
            </Switch>
        </Router>

              
 
    )
    }
}

export default App;
