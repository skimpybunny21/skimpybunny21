import React from 'react';
import { Button } from 'antd';
import { useHistory } from "react-router-dom";


const Logout = () => {
    const history = useHistory();

    const handleClick = () => {
        localStorage.removeItem('loginId');
        history.push("/");
        console.log("User logged out!")
    }

    return (
        <Button type="primary" onClick={ handleClick }>
            LogOut
        </Button>
    );
};

export default Logout;