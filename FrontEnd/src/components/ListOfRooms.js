import React, {Component} from 'react';
import '../css/ListOfOffers.css';
import {Container, Row, Col, ButtonGroup, Button} from 'reactstrap';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTrash, faPen} from "@fortawesome/free-solid-svg-icons";
import logo from '../flat.jpg';
import { connect } from 'react-redux'
import {deleteFlat, flatsLoaded} from '../redux/actions/flatsActions'
import {Link} from "react-router-dom";
import {UNLOAD_FLAT_DETAIL} from "../redux/constants/appConstaints";
import {commonUnloadAction} from "../redux/actions/commonActions";

class ListOfRooms extends Component {
    constructor(props) {
        super(props);
        //this.onDetailClick = this.onDetailClick.bind(this);
        this.onDeleteClick = this.onDeleteClick.bind(this);
    }

    componentDidMount() {
        fetch('http://localhost:8080/flats')
            .then((data) => data.json())
            .then((flats) => {
                this.props.flatsLoaded(flats);
            });
    }

    componentWillUnmount() {
        this.props.dispatchUnload();
    }

    render() {
        const { flats } = this.props;
        return (
            <div className="App-header">
                <h2 className='nameOfPage'>My Offers</h2>
                <br/>
                <Container>
                    <Row>
                        {flats && flats.map(r =>
                            <>
                                <Col className='container-offer' key={r.id}>
                                    <div className='small'>{r.name_of_room}</div>
                                    <Row>
                                         <img src={logo} className="offer-pic"/>
                                    </Row>
                                    <Row>
                                        <ButtonGroup className={'icon-offer-box'}>
                                            <Link to={`/offers/edit/${r.id}`}>
                                                <Button value={r.id} className='icon-offer-manage'>
                                                     <FontAwesomeIcon icon={faPen }/>
                                                </Button>
                                            </Link>
                                            <Button value={r.id} onClick={this.onDeleteClick} className='icon-offer-manage'>
                                                 <FontAwesomeIcon icon={faTrash}/>
                                            </Button>
                                        </ButtonGroup>
                                    </Row>
                                </Col>
                            </>
                            )}
                        </Row>
                    </Container>
                </div>
            );
        }

    onDeleteClick(e) {
        let id = e.target.value;
      //  this.props.dispatchDelete(id);
        fetch(`http://localhost:8080/flats/${id}`, {
            method: 'DELETE',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({id: id})
        }).then((data) => data.json())
            .then((flat) => {
                this.props.dispatchDelete(flat);
            });
    }

}


const mapStateToProps = (state) => {
    return {
        flats: state.flats
    }
};

const mapDispatchToProps = (dispatch) => ({
    flatsLoaded: flats => dispatch(flatsLoaded(flats)),
    dispatchDelete: (id) =>
        dispatch(deleteFlat(id)),
    dispatchUnload: () =>
        dispatch(commonUnloadAction(UNLOAD_FLAT_DETAIL)),
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ListOfRooms)