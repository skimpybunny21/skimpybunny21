import React, { Component } from 'react';
import { enquireScreen } from 'enquire-js';


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
      console.log("test")
      return(
        <div>
          <header>
            <p>Some text</p>
          </header>
        </div>
      )
    }

  }

  export default MainUserPage;