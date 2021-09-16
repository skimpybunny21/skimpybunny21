import React, { useState } from 'react';
import { OktaAuth } from '@okta/okta-auth-js';

import { Form, Input, Button, Alert, Row, Col } from 'antd';

const LoginForm = () => {

  const [sessionToken, setSessionToken] = useState();
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();
  const [error, setError] = useState();
  const baseDomain = "https://dev-58368863.okta.com/";
  const issuer = baseDomain + '/oauth2/default'

  const handleSubmit = (e) => {
    e.preventDefault();

    const oktaAuth2 = new OktaAuth({ url: baseDomain, issuer: issuer });
    oktaAuth2
    .signInWithCredentials({ username, password })
      .then(res => { handleSessionToken(res);})
        .catch(err => setError(err));
  };

  const handleSessionToken = (res) => {
    setSessionToken(res.sessionToken);
      const userId = res.user.id;
      localStorage.setItem('loginId', userId);
  };

  const layout = {
    labelCol: { span: 8 },
    wrapperCol: { span: 8 },
  };

  const tailLayout = {
    wrapperCol: { offset: 8, span: 16 },
  };

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  if (localStorage.getItem('loginId')) {
    return (      
    <Row>
      <Col span="8"></Col>
      <Col span="8"><p>Already logged in!</p></Col>
    </Row>);
  }

  const errorAlert = error ? <Row>
    <Col span="8"></Col>
    <Col span="8">
      <Alert message="Authentication Failed" type="warning"></Alert>
    </Col>
  </Row> : ''

  return (
    <Form
      {...layout}
      onSubmit={handleSubmit}
    >

      <Row>
        <Col span="8"></Col>
        <Col span="8"><p>Please Login:</p></Col>
      </Row>

      <Form.Item
        label="Username"
        name="username"
        value={username}
        onChange={handleUsernameChange}
        rules={[{ required: true, message: 'Please input your username!' }]}
      >
        <Input />
      </Form.Item>

      <Form.Item
        label="Password"
        name="password"
        value={password}
        onChange={handlePasswordChange}
        rules={[{ required: true, message: 'Please input your password!' }]}
      >
        <Input.Password />
      </Form.Item>

      <Form.Item {...tailLayout}>
        <Button type="primary" htmlType="submit" onClick={handleSubmit}>
          Login
        </Button>
      </Form.Item>

      { errorAlert }

    </Form>
  );
};
export default LoginForm;