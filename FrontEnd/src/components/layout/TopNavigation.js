import React, { Component } from 'react';
import {
    Collapse,
    Nav,
    Container,
    NavItem,
    NavLink,
    Navbar,
    NavbarBrand,
    NavbarToggler,
} from 'reactstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHome } from '@fortawesome/free-solid-svg-icons'

class TopNavigation extends Component {

    render() {
        return(
            <Container fluid={true} className="top-navigation-container">
                <div className='nav-bar'>
                    <Navbar light expand="md">
                        <NavbarBrand href="/home">
                            <FontAwesomeIcon className='icon-home' icon={faHome} /> &nbsp;
                            Flatly
                        </NavbarBrand>
                        <NavbarToggler />
                        <Collapse navbar>
                            <Nav className="ml-auto" navbar>
                                <NavItem>
                                    <NavLink className='top-nav-link' href="/home"> Home &nbsp; | &nbsp;</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink className='top-nav-link' href="/offers"> My offers &nbsp; | &nbsp;</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink className='top-nav-link' href="/profile"> My profile &nbsp; | &nbsp;</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink className='top-nav-link' href="/"> Logout </NavLink>
                                </NavItem>
                            </Nav>
                        </Collapse>
                    </Navbar>
                </div>
            </Container>
        );
    }
}

export default TopNavigation;
