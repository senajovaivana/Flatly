import React from 'react';
import {Table} from 'reactstrap';
import '../css/ListOfReservations.css'
import * as moment from 'moment';
import BootstrapTable from 'react-bootstrap-table-next';
import filterFactory, { textFilter } from 'react-bootstrap-table2-filter';
import  { dateFilter } from 'react-bootstrap-table2-filter';
import { selectFilter } from 'react-bootstrap-table2-filter';

const ListOfReservations  = ({
                                 reservations,
                                 forCurrentFlat,
                                 nameOfFlat
                             }) => {
    let header = forCurrentFlat === 0 ? "List of reservations" : "Reservations for " + nameOfFlat;
    const headerStyle = {
        color: '#e2e3e5',
        backgroundColor: '#343a40'
    };
    const selectOptions = {
        'T': 'No',
        'F': 'Yes'
    };

    function activeFormatter(cell, row) {
        if (cell === "F") {
            return (
                <p>Yes</p>
            );
        }
        return (
            <p>No</p>
        );

    }
    function dateFormatter(cell, row) {
        return (
            <p>{moment(cell).format('DD-MM-YYYY')}</p>
        );
    }
    const columns = [{
        dataField: 'item_id',
        text: 'Flat',
        headerStyle: headerStyle,
        filter: textFilter(),
    }, {
        dataField: 'start_date',
        text: 'Date of arrival',
        headerStyle: headerStyle,
        filter: dateFilter(),
        formatter: dateFormatter
    }, {
        dataField: 'end_date',
        text: 'Date of leaving',
        headerStyle: headerStyle,
        filter: dateFilter(),
        formatter: dateFormatter
    }, {
        dataField: 'active',
        text: 'Cancelled',
        headerStyle: headerStyle,
        filter: selectFilter({
            options: selectOptions
        }),
        formatter: activeFormatter
    }];
    const expandRow = {
        renderer: row => (
            <div className={'tableExpandRow'}>
                <p>{ `Number of nights - ${moment.duration(moment(row.end_date,"YYYY-MM-DD").
                                    diff(moment(row.start_date,"YYYY-MM-DD"))).asDays()}` }</p>
                <p>{`Login of main guest - ${row.owner_of_booking}`}  </p>
            </div>
        ),
    };
    const rowStyle = () => {
        const style = {};
        style.border_color='#818182';
        style.color = '#e2e3e5';
        return style;
    };

    const defaultSorted = [{
        dataField: 'start_date',
        order: 'desc'
    }];

    return (
        <div>
            <h2 className='nameOfPage'>
                {header}
            </h2>
            <br/>
            <BootstrapTable keyField='id' data={ reservations } defaultSorted={ defaultSorted } columns={ columns }
                            filter={ filterFactory() } rowStyle={ rowStyle }  expandRow={ expandRow } />
            {/*<Table responsive bordered className='tableOfReservations'>*/}
            {/*    <thead>*/}
            {/*    <tr>*/}
            {/*        {forCurrentFlat === 0 && <th>Name of the offer</th>}*/}
            {/*        <th>Date of arrival</th>*/}
            {/*        <th>Date of leaving</th>*/}
            {/*        <th>Number of nights</th>*/}
            {/*        <th>Login of guest</th>*/}
            {/*    </tr>*/}
            {/*    </thead>*/}
            {/*    <tbody>*/}
            {/*    {reservations.map(r =>*/}
            {/*        <tr key={r.id_booking}>*/}
            {/*            <>*/}
            {/*                {forCurrentFlat === 0 && <td> {r.name_of_offer} </td>}*/}
            {/*                <td> {moment(r.start_date).format('YYYY-MM-DD')} </td>*/}
            {/*                <td> {moment(r.end_date).format('YYYY-MM-DD')} </td>*/}

            {/*                <td> {moment.duration(moment(r.end_date,"YYYY-MM-DD").*/}
            {/*                                       diff(moment(r.start_date,"YYYY-MM-DD"))).asDays()} </td>*/}
            {/*                <td> {r.owner_of_booking} </td>*/}
            {/*            </>*/}
            {/*        </tr>)*/}
            {/*    }*/}
            {/*    </tbody>*/}
            {/*</Table>*/}
        </div>
    );
};

export default ListOfReservations;