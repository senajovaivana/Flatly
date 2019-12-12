import React from 'react';
import {Table} from 'reactstrap';
import '../css/ListOfReservations.css'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPen} from "@fortawesome/free-solid-svg-icons";

const ListOfReservations  = ({
                                 reservations
                             }) => {

    return (
        <div>
            <h2 className='nameOfPage'>
                List of reservations
            </h2>
            <br/>
            <Table responsive bordered className='tableOfReservations'>
                <thead>
                <tr>
                    <th>Name of your offer</th>
                    <th>Date of arrival</th>
                    <th>Date of leaving</th>
                    <th>Login of guest</th>
                    <th>Detail</th>
                </tr>
                </thead>
                <tbody>
                {reservations.map(r =>
                    <tr key={r.id_booking}>
                        <>
                            <td> {r.name_of_offer} </td>
                            <td> {r.start_date} </td>
                            <td> {r.end_date} </td>
                            <td> {r.name_of_quests} </td>
                            <td>
                                <a>
                                    <FontAwesomeIcon icon={faPen} /> &nbsp;
                                </a>
                            </td>
                        </>
                    </tr>)
                }
                </tbody>
            </Table>
        </div>
    );
};

export default ListOfReservations;