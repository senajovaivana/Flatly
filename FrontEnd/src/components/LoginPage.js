import React, {Component} from 'react';
import "../css/Login.css";
import { Container, Row, Col, Input, Button, FormGroup, Label}
    from 'reactstrap';
import {withRouter} from "react-router";
import AuthHelperMethods from "./AuthHelperMethods";
// AuthenticationLogin from "./AuthenticationLogin";
import Alert from "reactstrap/es/Alert";
const Auth = new AuthHelperMethods();

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            login: "",
            password: "",
            loginfailed: false,
            error: false
        };
        this.handleChangeLogin = this.handleChangeLogin.bind(this);
        this.handleChangePassword = this.handleChangePassword.bind(this);
        this.formvalid = this.formvalid.bind(this);
        // this.SubmitButton=this.SubmitButton.bind(this);
        this.logIn = this.logIn.bind(this);
    }

    formvalid() {
        return this.state.login.length > 0 && this.state.password.length > 0
    }

    render() {
        return (
            <div className='login-page'>
                <div>
                    <Container className="main-layout-page-wrapper themed-container">
                        <Row>
                            <Col className="content" sm="12" md={{size: 6, offset: 3}}>
                                <form className='form' onSubmit={this.logIn}>
                                    {this.state.loginfailed &&
                                    <Alert variant="danger" show={true}>
                                        Incorrect Username or Password!! try again
                                    </Alert>}
                                    <FormGroup>
                                        <h2 className='nameOfPage'>
                                            Sign in
                                        </h2>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label>Login
                                            <Input type="text" value={this.state.login}
                                                   onChange={this.handleChangeLogin}/>
                                        </Label>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label>Password
                                            <Input type="password" value={this.state.password}
                                                   onChange={this.handleChangePassword}/>
                                        </Label>
                                    </FormGroup>
                                    <Button color="success" size="lg" disabled={!this.formvalid()}> Submit </Button>
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

    logIn(e) {
        e.preventDefault();
        Auth.login(this.state.login, this.state.password)
            .then(res => {
                if (res === false) {
                    return alert("Sorry those credentials don't exist!");
                }
             //   this.props.history.replace("/");
                // Auth.loggedIn(this.state.login , this.state.password,res.data.token)

                this.props.history.push("/home");
            })

            .catch(() => {
                this.setState({error: false})
                this.setState({loginfailed: true})

            });

    }
}
export default (withRouter(LoginPage));