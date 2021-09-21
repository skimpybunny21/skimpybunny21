import React, { Component } from 'react';
import { enquireScreen } from 'enquire-js';
import Footer from '../Home/Footer1';
import Header from '../Home/Nav3'
import Chart1 from './chart1';

import { Footer10DataSource, UserNavDataSource } from '../Home/data.source.js'
import UserCalendar from './userCalendar';
import Chart2 from './chart2';


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
          <div>
            <Chart1 isMobile={this.isMobile}></Chart1>
          </div>
          <div>
            <UserCalendar isMobile={this.isMobile}></UserCalendar>
          </div>
          <div>
            <Chart2 isMobile={this.isMobile}></Chart2>
          </div>
          <Footer dataSource={Footer10DataSource} isMobile={this.isMobile}/>
        </div>
      )
    }

  }

  export default MainUserPage;