import React, { useState, useEffect } from 'react';
import { Line } from '@ant-design/charts';

const Chart1 = () => {
  const [data, setData] = useState([]);
  useEffect(() => {
    Fetch();
  }, []);
  const Fetch = () => {
    fetch('data.json'
    ,{
      headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json'
       }
    }
    )
      .then((response) => response.json())
      .then((json) => setData(json))
      .catch((error) => {
        console.log('fetch data failed', error);
      });
  };
  var config = {
    data: data,
    padding: 'auto',
    xField: 'Date',
    yField: 'scales',
    xAxis: { tickCount: 5 },
    smooth: true,
  };
  return <Line {...config} />;
};

export default Chart1;