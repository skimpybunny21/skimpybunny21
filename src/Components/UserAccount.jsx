import React from "react";
import { Modal, Button } from 'antd';

const UserAccountModal = () => {
    const [visible, setVisible] = React.useState(false);
    const [confirmLoading, setConfirmLoading] = React.useState(false);
    const [modalText, setModalText] = React.useState('Content of the modal');

    const showModal = () => {
        setVisible(true);
    };

    const handleOk = () => {
        setModalText('Saving');
        setConfirmLoading(true);
        setTimeout(() => {
        setVisible(false);
        setConfirmLoading(false);
        }, 1000);
    };

    const handleCancel = () => {
        console.log('Cancel');
        setVisible(false);
    };

    return (
        <>
        <Button type="ghost" onClick={showModal}>
            Account
        </Button>
        <Modal
            title="Title"
            visible={visible}
            onOk={handleOk}
            confirmLoading={confirmLoading}
            onCancel={handleCancel}
        >
            <p>{modalText}</p>
        </Modal>
        </>
    );
};

export default UserAccountModal;