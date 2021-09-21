import React, { useState } from 'react';
import { Modal, Button } from 'antd';
import LoginForm from './LoginForm';


const Popup = () => {
  const [isModalVisible, setIsModalVisible] = useState(false);

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  return (
    <>
      <Button type="primary" onClick={showModal}>
        LogIn
      </Button>
      <Modal title="Login" visible={isModalVisible} onOk={handleOk} onCancel={handleCancel} footer={null}>
      <LoginForm></LoginForm>
      </Modal>
    </>
  );
};

export default Popup;
