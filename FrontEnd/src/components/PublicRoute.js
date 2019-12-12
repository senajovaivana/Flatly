import React from 'react';
import { Route } from 'react-router-dom';

//component used for pages in which you need to distinguish the mode - f.e. mode="edit" or mode="create"
const PublicRoute = ({ component: Component, mode, ...rest }) => {
    return (
        <Route {...rest} render={props => <Component {...props} mode={mode} />} />
    );
};
export default PublicRoute;