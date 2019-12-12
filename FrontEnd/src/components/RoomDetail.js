import React, {Component} from 'react';
import "../css/RoomDetail.css";
import { ButtonGroup, Input, Button, FormGroup, Label, CustomInput}
from 'reactstrap';
import {flatDetailLoaded} from "../redux/actions/flatsActions";
import {connect} from "react-redux";

class RoomDetail extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name_of_room: undefined,
            description: undefined,
            start_date: undefined,
            price: undefined,
            limit_of_quests: undefined,
            check_in_from: undefined,
            check_in_to: undefined,
            check_out: undefined,
            payment_methods: ['card', 'cash', 'viamo'],
            country: undefined,
            city: undefined,
            street: undefined,
            number_of_street: undefined,
            zip_code: undefined,
            image: undefined
        };
    }

    componentDidMount() {
        //fetch roomdetail if edit
        if (this.props.mode === "edit") {
            let id = this.props.id;
            fetch(`http://localhost:8080/flats/${id}`)
                .then((data) => data.json())
                .then((flat) => {
                    this.props.flatDetailLoaded(flat);
                });
        }
        //fetch payment methods
    }

    render() {
        const { flatDetail, mode } = this.props;
        const isEdit = mode === 'edit';
        const blockTitle =
            (isEdit && 'Editing of existing offer') || 'Adding new offer';
        let initials = {};
        if (!isEdit) {
            initials = {
                name_of_room: undefined,
                description: undefined,
                start_date: undefined,
                price: undefined,
                limit_of_quests: undefined,
                check_in_from: undefined,
                check_in_to: undefined,
                check_out: undefined,
                payment_methods: ['card', 'cash', 'viamo'],
                country: undefined,
                city: undefined,
                street: undefined,
                number_of_street: undefined,
                zip_code: undefined,
                image: undefined
            };
        } else {
            initials = {...flatDetail};
        }

        return (
            <form className='form'>
                <FormGroup>
                    <h2 className='nameOfPage'>
                        {blockTitle}
                    </h2>
                </FormGroup>
                <FormGroup>
                    <Label>Name of offer
                        <Input type="text" value={initials.name_of_room}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Description of offer
                        <Input type="textarea" name="text" value={initials.description}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Available from
                        <Input type="date" value={initials.start_date}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Price per night [€]
                        <Input type="number" value={initials.price}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Limit of guests
                        <Input type="number" value={initials.limit_of_quests}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Check in from
                        <Input
                            type="time"
                            value={initials.check_in_from}
                        />
                   </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Check in to
                        <Input
                            type="time"
                            value={initials.check_in_to}
                        />
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Check out
                        <Input
                            type="time"
                            value={initials.check_out}
                        />
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Payment method
                        <Input type="select" multiple>
                            {this.state.payment_methods.map(method =>
                                <option key={method}>{method}</option>
                            )}
                        </Input>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Country
                        <Input type="text" value={initials.country}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Town
                        <Input type="text" value={initials.city}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Street
                        <Input type="text" value={initials.street}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Street No.
                        <Input type="text" value={initials.number_of_street}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Zip code
                        <Input type="text" value={initials.zip_code}/>
                    </Label>
                </FormGroup>
                <FormGroup>
                    <Label>Room image
                    <CustomInput id="file" type="file" />
                    </Label>
                </FormGroup>
                {isEdit &&
                <FormGroup>
                    {/*TODO change link to /idOfFlat/reservations*/}
                    <Button href="/reservations" color="success" block size="lg"> Reservations </Button>
                </FormGroup>
                }
                <FormGroup className='btns'>
                <ButtonGroup>
                    <Button className='btn-green-hover'> Save </Button>
                    <Button href='/home' className='btn-green-hover'> Cancel </Button>
                </ButtonGroup>
                </FormGroup>
            </form>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        flatDetail: state.flatDetail
    }
};

const mapDispatchToProps = (dispatch) => ({
    flatDetailLoaded: flatDetail => dispatch(flatDetailLoaded(flatDetail)),

});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(RoomDetail)
