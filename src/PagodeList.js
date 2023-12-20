// src/PagodeList.js


import React from 'react';
import PagodeDoc from './PagodeDoc';

function PagodeList() {
  return (
    
    <div className="PagodeList">
      <PagodeDoc
        name="50 California Street"
        address="50 California St."
        image="50-california-st.jpg"
      />
      <PagodeDoc  name="100 Pine Street"
        address="100 Pine St."
        image="100-pine.jpg"/>
      <PagodeDoc  name="101 California Street"
        address="101 California"
        image="101-california.jpg" />
      <PagodeDoc  name="343 Sansome Roof Garden"
        address="343 Sansome St."
        image="343-sansome-roof-garden.jpg"/>
      <PagodeDoc name="525 Market Street Plaza"
        address="525 Market St."
        image="525-market-street-plaza.jpg" />
      <PagodeDoc name="Citigroup Center"
        address="1 Sansome St."
        image="citigroup-center.jpg"/>
    </div>
  )
}

export default PagodeList