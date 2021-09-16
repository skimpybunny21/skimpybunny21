import React, { useState, useEffect } from 'react';
import { Pie } from '@ant-design/charts';

const Chart2 = () => {
  const [data, setData] = useState([]);
  useEffect(() => {
    Fetch();
  }, []);
  const Fetch = () => {
    fetch('data2.json'
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
    appendPadding: 10,
    data: data,
    angleField: 'value',
    colorField: 'type',
    radius: 0.8,
    label: {
      type: 'outer',
      content: '{name} {percentage}',
    },
    interactions: [{ type: 'pie-legend-active' }, { type: 'element-active' }],
  };
  return <Pie {...config} />;
};

export default Chart2;