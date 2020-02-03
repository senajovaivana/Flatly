import React, {Component} from 'react';
import Layout from "./layout/Layout";
import RoomDetail from "./RoomDetail";

class RoomDetailPage extends Component {

    render() {
        return(
            <RoomDetail mode={this.props.mode} id={this.props.match.params.id}/>
        );
    }
}

export default RoomDetailPage;
