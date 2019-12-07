import React from 'react';
import './App.css';
import{Link,withRouter} from "react-router-dom";
import logo from './logo.svg';
import { Container, Row, Col } from 'reactstrap';

class UserHome extends React.Component {

  render() {

    return (
      <div className="App-header">
       <span >
        <label><Link to="/home">Home</Link></label> 
        <label> |</label> 
        <label><Link to="/home">About</Link></label> 
        <label> |</label> 
        <label><Link to="/home">My Profile</Link></label> 
        <label> |</label> 
        <label><Link to="/home">My Offers</Link></label> 
         
       </span> 
     
<Container>
  <Row>
    <Col>  <img src={logo} /></Col>
    <Col>  
    <span >
     <h3>My Profile</h3>
     <h3>Earn Report</h3>
     <h3>Check logs</h3>
     </span></Col>
     <Col> <img src={logo} /></Col>
  </Row>
 
</Container>
       <span >
        <Link to="/home"><button >Added a new offer</button></Link> 
        <label> |</label> 
        <Link to="/home"><button >Modify offer</button></Link> 
        <label> |</label> 
        <Link to="/home"><button >Delete a offer</button></Link> 
        <label> |</label> 
        <Link to="/home"><button >My Offers</button></Link> 
         
       </span> 

      </div>
    );
  }
}

export default withRouter(UserHome);