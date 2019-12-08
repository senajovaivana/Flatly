import React, {Component} from 'react';
import logo from './FlatyLogo.png';
import "./App.css";
import LoginPage from './LoginPage';
import UserHome from './UserHome';
import{
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import MyOffers from "./MyOffers";
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
                <Route exact path="/myoffers">
                    <MyOffers/>
                </Route>
            </Switch>
        </Router>

              
 
    )
    }
}

export default App;
