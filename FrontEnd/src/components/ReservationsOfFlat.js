import React from 'react';
import {Table} from 'reactstrap';
import '../css/ListOfReservations.css'
import * as moment from 'moment';
import {flatDeleted, flatsLoaded} from "../redux/actions/flatsActions";
import {connect} from "react-redux";
import {withRouter} from "react-router";
import ListOfReservations from "./ListOfReservations";
import {bookingsLoaded} from "../redux/actions/bookingsActions";

class ReservationsOfFlat extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        let id = this.props.match.params.id;
        fetch(`http://localhost:8080/bookings/flat/${id}`)
            .then((data) => data.json())
            .then((reservations) => {
                console.log(reservations)
                this.props.bookingsLoaded(reservations);
            });
    }

    render() {
        const bookings = this.props.bookings;
        let nameOfFlat = this.props.nameOfFlat;
        return (
            <div>
                {bookings && <ListOfReservations reservations={bookings}
                                                 forCurrentFlat={1}
                                                 nameOfFlat={nameOfFlat}/>}
            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        bookings: state.bookings
    }
};

const mapDispatchToProps = (dispatch) => ({
    bookingsLoaded: bookings => dispatch(bookingsLoaded(bookings)),
});

export default connect(mapStateToProps, mapDispatchToProps)(withRouter(ReservationsOfFlat))
