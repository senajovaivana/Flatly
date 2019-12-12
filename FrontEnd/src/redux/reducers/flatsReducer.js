import { FLATS_LOADED, FLAT_DETAIL, UNLOAD_FLAT_DETAIL, DELETE_FLAT } from '../constants/appConstaints';

export const initialState = {
    flats: undefined,
    flatDetail: undefined
};

const flatsReducer = (state = initialState, action) => {
    switch (action.type) {
        case FLATS_LOADED: {
            const { flats } = action.payload;
            return Object.assign({}, state, { flats });
        }
        case FLAT_DETAIL: {
            const { flatDetail } = action.payload;
            return Object.assign({}, state, { flatDetail });
        }
        case UNLOAD_FLAT_DETAIL:
            return Object.assign({}, state, { undefined });
        case DELETE_FLAT:
            return Object.assign({}, state, { undefined });
        default:
            return state
    }
};

export default flatsReducer;