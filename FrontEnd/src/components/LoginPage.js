import React, {Component} from 'react';
import "../css/Login.css";
import { Container, Row, Col, Input, Button, FormGroup, Label}
    from 'reactstrap';

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            login: undefined,
            password: undefined
        }
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
                                            <Input type="text" value={this.state.login} onChange={this.handleUserChange}/>
                                        </Label>
                                    </FormGroup>
                                    <FormGroup>
                                        <Label>Password
                                            <Input type="text" value={this.state.password} onChange={this.handleUserChange}/>
                                        </Label>
                                    </FormGroup>
                                    <Button color="success" size="lg"> Submit </Button>
                                </form>
                            </Col>
                        </Row>
                    </Container>
                </div>
            </div>
        )
    }
}
export default LoginPage;
