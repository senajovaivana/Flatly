import React from 'react';
import {Table} from 'reactstrap';
import '../css/ListOfReservations.css'
import * as moment from 'moment';

const ListOfReservations  = ({
                                 reservations,
                                 forCurrentFlat,
                                 nameOfFlat
                             }) => {
    let header = forCurrentFlat === 0 ? "List of reservations" : "Reservations for " + nameOfFlat;
    return (
        <div>
            <h2 className='nameOfPage'>
                {header}
            </h2>
            <br/>
            <Table responsive bordered className='tableOfReservations'>
                <thead>
                <tr>
                    {forCurrentFlat === 0 && <th>Name of the offer</th>}
                    <th>Date of arrival</th>
                    <th>Date of leaving</th>
                    <th>Number of nights</th>
                    <th>Login of guest</th>
                </tr>
                </thead>
                <tbody>
                {reservations.map(r =>
                    <tr key={r.id_booking}>
                        <>
                            {forCurrentFlat === 0 && <td> {r.name_of_offer} </td>}
                            <td> {moment(r.start_date).format('YYYY-MM-DD')} </td>
                            <td> {moment(r.end_date).format('YYYY-MM-DD')} </td>

                            <td> {moment.duration(moment(r.end_date,"YYYY-MM-DD").
                                                   diff(moment(r.start_date,"YYYY-MM-DD"))).asDays()} </td>
                            <td> {r.owner_of_booking} </td>
                        </>
                    </tr>)
                }
                </tbody>
            </Table>
        </div>
    );
};

export default ListOfReservations;