import React from 'react';
import { Button } from 'antd';

const RegistrationForm = () => {

    const handleButtonClick = () => {
        window.location.replace('https://dev-58368863.okta.com/signin/register')
        console.log("Wokring!");
    }

    return (
        <Button type="primary" onClick={ handleButtonClick }>
            SignIn
        </Button>
    );
};

export default RegistrationForm;