import Main from './Components/Main/Main'
import {Provider} from 'react-redux'
import {BrowserRouter} from 'react-router-dom'
import {ConfigureStore} from './Redux/configureStore'
import React, { Component } from 'react';
import './App.css';

const store = ConfigureStore();

function App() {
  


  return (
    <div>

    <Provider store={store}>
      <BrowserRouter>
        <Main/>
      </BrowserRouter>
    </Provider>
    </div>
  );


}

export default App;
