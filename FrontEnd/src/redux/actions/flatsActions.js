import { FLATS_LOADED, FLAT_DETAIL, DELETE_FLAT } from '../constants/appConstaints';

export const flatsLoaded = (flats) => {
    return {
        type: FLATS_LOADED,
        payload: {
            flats
        }
    };
};

export const flatDetailLoaded = (flatDetail) => {
    return {
        type: FLAT_DETAIL,
        payload: {
            flatDetail
        }
    };
};

export const deleteFlat = (id) => {
    return {
        type: DELETE_FLAT,
        id: id
    }
};