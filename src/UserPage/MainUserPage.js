import React, { Component } from 'react';
import { enquireScreen } from 'enquire-js';
import Footer from '../Home/Footer1';
import Header from '../Home/Nav3'
import Chart1 from './chart1';

import { Footer10DataSource, UserNavDataSource } from '../Home/data.source.js'


let isMobile;
enquireScreen((b) => {
  isMobile = b;
});

class MainUserPage extends Component {
    constructor(props) {
      super(props);
      this.state = {
        isMobile,
      };
    }
    render (){
      return(
        <div>
          <Header dataSource={UserNavDataSource} isMobile={this.isMobile} />
          <Chart1></Chart1>
          <Footer dataSource={Footer10DataSource} isMobile={this.isMobile}/>
        </div>
      )
    }

  }

  export default MainUserPage;