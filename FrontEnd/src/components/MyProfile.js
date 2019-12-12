import React, {Component} from 'react';
import "../css/MyProfile.css";
import {Row, Input, Button, FormGroup, Label}
    from 'reactstrap';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faUser} from "@fortawesome/free-solid-svg-icons";

class MyProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            login : undefined,
            name : undefined,
            surname : undefined
        };
        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleSurnameChange = this.handleSurnameChange.bind(this);
    }

    render() {
        return (
            <form className='form'>
                 <FormGroup>
                     <h2 className='nameOfPage'>
                         My profile
                     </h2>
                 </FormGroup>
                 <Row form>
                     <FontAwesomeIcon className='icon-user' icon={faUser} />
                     <Label>
                        <br/>
                         Login: {this.state.login}
                     </Label>
                 </Row>
                 <FormGroup>
                     <Label>First name
                         <Input type="text" value={this.state.name} onChange={this.handleNameChange}/>
                     </Label>
                 </FormGroup>
                 <FormGroup>
                     <Label>Last name
                         <Input type="text" value={this.state.surname} onChange={this.handleSurnameChange}/>
                     </Label>
                 </FormGroup>
                <FormGroup className='btns'>
                    <Button className='btn-green-hover'> Change </Button>
                </FormGroup>
            </form>
        )
    }

    handleNameChange(e) {
        this.setState({name: e.target.value});
    }

    handleSurnameChange(e) {
        this.setState({surname: e.target.value});
    }
}

export default MyProfile;
