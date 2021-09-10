import React, { useState } from 'react';
import { Modal, Button } from 'antd';
import LoginForm from './LoginForm';
import {Redirect} from "react-router-dom";

import MainUserPage from '../UserPage/MainUserPage';

const Popup = () => {
  const [isModalVisible, setIsModalVisible] = useState(false);

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    setIsModalVisible(false);
    <Redirect to= { MainUserPage} />
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  return (
    <>
      <Button type="primary" onClick={showModal}>
        LogIn
      </Button>
      <Modal title="Login" visible={isModalVisible} onOk={handleOk} onCancel={handleCancel}>
      <LoginForm></LoginForm>
      </Modal>
    </>
  );
};

export default Popup;
