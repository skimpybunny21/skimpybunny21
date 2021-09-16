import React from 'react';
import { Redirect } from "react-router-dom";
import MainUserPage from "../UserPage/MainUserPage";

const Logout = () => {
    localStorage.removeItem('loginId');
    <Redirect to= {MainUserPage} />
    alert("LOL")
}

export default Logout;