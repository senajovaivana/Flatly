import React from 'react';
import './App.css';
import{Link,withRouter} from "react-router-dom";


class LoginPage extends React.Component {
  constructor() {
    super();
    this.state = {
      email: '',
      password: '',
      remeber:false
    };

    this.handlePassChange = this.handlePassChange.bind(this);
    this.handleUserChange = this.handleUserChange.bind(this);
    this.remeberMeChange = this.remeberMeChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);

  }


  handleSubmit(event){
    event.preventDefault();
    const data = new FormData(event.target);

    /*fetch('http://localhost:8080', {
      method: "POST",
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({  
        email: data.get("email"),
        password: data.get("password") 
      })
    })*/
    fetch('http://localhost:8080/developer')
    .then(result => {
      ///do something in backend to match password
      if (result.status === 200) {
        this.props.history.push("/home")
      } 
    });


    }  
    
    
  handleUserChange(event) {
    this.setState({
      email: event.target.value,
    });
  };

  handlePassChange(event) {
    this.setState({
      password: event.target.value,
    });
  }
  remeberMeChange(event) {
    this.setState({
      remeber: event.target.checked,
    });

  }
 
  render() {
    return (  
      <div className="App-header" >
      <h2>Login</h2>
      <div className="Login" style={{display: 'flex',  justifyContent:'center', alignItems:'center', height: '30vh' ,width: '70vh' , borderStyle: 'solid', borderWidth: 5 }}>
        
        <form onSubmit={this.handleSubmit} >
          <label>Email</label>
          <input type="text" name="email"  value={this.state.email} onChange={this.handleUserChange} />
          <br/>
          <label>Password</label>
          <input type="password" name="password"  value={this.state.password} onChange={this.handlePassChange} />
          <br/>
          <input disabled={!this.state.email.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i)||this.state.password.length<1} value="Sign in" type="submit" />
          
          <label>Remeber me</label><input type="checkbox" value={this.state.remeber} onChange={this.remeberMeChange}/>

        </form>
      </div></div>
    );
  }
}

export default withRouter(LoginPage);