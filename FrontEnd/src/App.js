import React, {Component} from 'react';
import logo from './logo.svg';
import "./App.css";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            developerbb: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.load()
    }

    load() {
        this.setState({isLoading: true})
        //alternative to fetch is 'axios' - benefit - add error handling
        fetch('http://localhost:5555/developer')
            .then(response => response.json())
            .then(data => this.setState({developers: data}))
            .then(() => this.setState({isLoading: false}));
    }

    render() {
        return (<div>
            <header className="App-header">
                <hr/>
                <img src={logo} className="App-logo" alt="logo"/>
                <div>
                {this.state.isLoading ? "LOADING" : "LOADED"}
                <hr/>
                Its not loading because of:
                <h4>
                    Access to fetch at 'http://localhost:8080/developer' from origin 'http://localhost:3000' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource. If an opaque response serves your needs, set the request's mode to 'no-cors' to fetch the resource with CORS disabled.
                </h4>
                <p>Added task to Kraken</p>
                </div>
                {/*not working because of above*/}
                {/*{this.state.isLoading ? "LOADING" : */}
                {/*    this.state.developers.map(developer => < li*/}
                {/*    className={`active${developer.active}`} key={developer.id}> {employee.login}</li>)}*/}
                <hr/>
            </header>
        </div>)
    }
}

export default App;
