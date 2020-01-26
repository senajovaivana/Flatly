import React, {Component} from 'react';
import "../css/App.css";
import{
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";
import Layout from "./layout/Layout";
import MyProfile from "./MyProfile";
import ListOfReservations from "./ListOfReservations";
import HomePage from "./HomePage";
import LoginPage from "./LoginPage";
import ListOfOffers from "./ListOfRooms";
import { Provider } from 'react-redux'
import { createStore } from 'redux'
import { composeWithDevTools } from "redux-devtools-extension";
import rootReducer from '../redux/reducers/reducer'
import PublicRoute from "./PublicRoute";
import RoomDetailPage from "./RoomDetailPage";
import ReservationsOfFlat from "./ReservationsOfFlat";
import AllReservations from "./AllReservations";

const store = createStore(rootReducer, {}, composeWithDevTools());

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            developers: [],
            isLoading: false
        };
    }

    render() {
        let reservations = [
            {
                "name_of_offer": 'Bed and Breakfast',
                "id_booking": 1,
                "start_date": '2019-10-02',
                "end_date": '2019-10-04',
                "name_of_quests": 'Anna'
            },
            {
                "name_of_offer": 'Nice apartment in Warsaw',
                "id_booking": 2,
                "start_date": '2019-10-14',
                "end_date": '2019-10-17',
                "name_of_quests": 'Peter'
            },
            {
                "name_of_offer": 'Junckers Hotel',
                "id_booking": 3,
                "start_date": '2019-11-01',
                "end_date": '2019-11-02',
                "name_of_quests": 'Jozef'
            },
            {
                "name_of_offer": 'Amsterdam Downtown Hotel',
                "id_booking": 4,
                "start_date": '2019-12-04',
                "end_date": '2019-12-09',
                "name_of_quests": 'Paul'
            }
        ];
        return (
            <Provider store={store}>
            <Router>
                <Switch>
                    <Route  exact path="/">
                        <LoginPage/>
                    </Route>
                    <Route exact path="/home">
                        <Layout>
                            <HomePage/>
                        </Layout>
                    </Route>
                    <Route exact path="/profile">
                        <Layout>
                            <MyProfile/>
                        </Layout>
                    </Route>
                    <Route exact path="/reservations/flat/:id">
                        <Layout>
                            <ReservationsOfFlat nameOfFlat={"fdf"}/>
                        </Layout>
                    </Route>

                    <Route exact path="/reservations/">
                        <Layout>
                            <AllReservations/>
                        </Layout>
                    </Route>
                    <Route exact path="/offers">
                        <Layout>
                            <ListOfOffers/>
                        </Layout>
                    </Route>

                    <PublicRoute component={RoomDetailPage}
                                 path="/offers/edit/:id" mode={'edit'}/>

                    <PublicRoute component={RoomDetailPage}
                                 path="/offers/create" mode={'create'}/>

                </Switch>
            </Router>
            </Provider>
        );
    }
}

export default App;
