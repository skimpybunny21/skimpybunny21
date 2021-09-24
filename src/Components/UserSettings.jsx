import React from "react";
import { Modal, Form, Input, Checkbox,
    Menu, Dropdown, Button, message } from 'antd';
import { DownOutlined, UserOutlined } from '@ant-design/icons';


const UserAccountSettings = () => {
    const [visible, setVisible] = React.useState(false);
    const [confirmLoading, setConfirmLoading] = React.useState(false);
    const setModalText = React.useState('Content of the modal');

    const showModal = () => {
        setVisible(true);
    };

    const handleOk = () => {
        setModalText('Saving...');
        setConfirmLoading(true);
        setTimeout(() => {
        setVisible(false);
        setConfirmLoading(false);
        }, 1500);
    };

    const handleCancel = () => {
        console.log('Clicked cancel button');
        setVisible(false);
    };

    function handleMenuClick(e) {
        message.info('Click on menu item.');
        console.log('click', e);
      }

    const menu1 = (
        <Menu onClick={handleMenuClick}>
          <Menu.Item key="1" icon={<UserOutlined />}>
            Theme 1
          </Menu.Item>
          <Menu.Item key="2" icon={<UserOutlined />}>
            Theme 2
          </Menu.Item>
          <Menu.Item key="3" icon={<UserOutlined />}>
            Theme 3
          </Menu.Item>
        </Menu>
      );

    const menu2 = (
        <Menu onClick={handleMenuClick}>
        <Menu.Item key="1" icon={<UserOutlined />}>
          English
        </Menu.Item>
        <Menu.Item key="2" icon={<UserOutlined />}>
          Polish
        </Menu.Item>
      </Menu>
    );

    return (
        <>
        <Button type="ghost" onClick={showModal}>
            Settings
        </Button>
        <Modal
            title="Settings"
            visible={visible}
            onOk={handleOk}
            confirmLoading={confirmLoading}
            onCancel={handleCancel}
        >
        <p>
        <Form
            name="basic"
            labelCol={{ span: 8 }}
            wrapperCol={{ span: 8 }}
            initialValues={{ remember: true }}
            //onFinish={onFinish} //action TO DO on success
            //onFinishFailed={onFinishFailed} // action TO DO on fail
            autoComplete="off"
            >
            <Form.Item
                label="Change username"
                name="username"
                rules={[{ required: true, message: 'Please input your username!' }]}
            >
                <Input />
            </Form.Item>

            <Form.Item
                label="Change password"
                name="password"
                rules={[{ required: true, message: 'Please input your password!' }]}
            >
                <Input.Password />
            </Form.Item>

            <Form.Item name="languageSelector" valuePropName="language" wrapperCol={{ offset: 8, span: 16 }}>
                <Dropdown overlay={menu2}>
                    <Button>
                        Language <DownOutlined />
                    </Button>
                </Dropdown>
            </Form.Item>

            <Form.Item name="themeChenge" valuePropName="theme" wrapperCol={{ offset: 8, span: 16 }}>
                <Dropdown overlay={menu1}>
                    <Button>
                        Theme <DownOutlined />
                    </Button>
                </Dropdown>
            </Form.Item>

            <Form.Item name="darkMode" valuePropName="checked" wrapperCol={{ offset: 8, span: 16 }}>
                <Checkbox>Dark mode</Checkbox>
            </Form.Item>

            </Form>
        </p>
        </Modal>
        </>
    );
};

export default UserAccountSettings;