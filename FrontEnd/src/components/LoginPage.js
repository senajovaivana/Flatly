import React, {Component} from 'react';
import "../css/Login.css";
import { Container, Row, Col, Input, Button, FormGroup, Label}
    from 'reactstrap';
import {withRouter} from "react-router";
import AuthHelperMethods from "./AuthHelperMethods";

const Auth = new AuthHelperMethods();

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            login: "",
            password: ""
        };
        this.handleChangeLogin = this.handleChangeLogin.bind(this);
        this.handleChangePassword = this.handleChangePassword.bind(this);
        this.logIn = this.logIn.bind(this);
    }

    render() {
        return (
            <div className='login-page'>
                <div>
                    <Container className="main-layout-page-wrapper themed-container">
                        <Row>
                            <Col className="content" sm="12" md={{ size: 6, offset: 3 }}>
                                <form className='form'>
                                    <FormGroup>
                                        <h2 className='nameOfPage'>
                                            Sign in
                                        </h2>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label>Email
                                            <Input type="text" value={this.state.login} onChange={this.handleChangeLogin}/>
                                        </Label>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label>Password
                                            <Input type="password" value={this.state.password} onChange={this.handleChangePassword}/>
                                        </Label>
                                    </FormGroup>
                                    <Button color="success" size="lg" onClick={this.logIn}> Submit </Button>
                                </form>
                            </Col>
                        </Row>
                    </Container>
                </div>
            </div>
        )
    }

    handleChangeLogin(e) {
        this.setState({
            login: e.target.value
        })
    }

    handleChangePassword(e) {
        this.setState({
            password: e.target.value
        })
    }

    logIn() {
        //TODO - not working, also need to be changed to more secure - add token also
    //     let user = {login: this.state.login,  password: this.state.password}
    //     fetch("http://localhost:8080/users", {
    //         method: 'POST',
    //         headers: {
    //             Accept: 'application/json',
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(user)
    //     })
    //         .then(res => {
    //                 if (res.status === 200) {
    //                     this.props.history.push("/home");
    //                 }
    //             }
    //         );
    //
        Auth.login(this.state.login, this.state.password)
            .then(res => {
                if (res === false) {
                    return alert("Sorry those credentials don't exist!");
                }
                this.props.history.replace("/");
            })
            .catch(err => {
                alert(err);
            });
        this.props.history.push("/home");
    }

}

export default (withRouter(LoginPage));
