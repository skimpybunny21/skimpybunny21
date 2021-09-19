import React from 'react';
import { Redirect } from "react-router-dom";
import Home from '../Home';

const Logout = () => {
    localStorage.removeItem('loginId');
    <Redirect to= {Home} />
    console.log("User logged out!")
}

export default Logout;