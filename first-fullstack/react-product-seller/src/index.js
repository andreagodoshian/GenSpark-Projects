import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// when we describe components in index.js,
// we can reach them globally
import 'bootstrap/dist/css/bootstrap.min.css';
// npm install --save bootstrap react-bootstrap
// npm install @fortawesome/react-fontawesome @fortawesome/fontawesome-svg-core @fortawesome/free-solid-svg-icons

// npm install axios
// npm install react-router-dom
// npm install redux react-redux
import { Provider } from 'react-redux';
import store from './store';
import { handleResponseWithLoginCheck } from './services/base.service';

handleResponseWithLoginCheck();


//////////////////////////////////////
// Provider components connect our global store/state 
// to the entire app... that's why <App /> is
// wrapped INSIDE of the Provider
ReactDOM.render(
  <React.StrictMode>
      <Provider store={store}>
          <App />
      </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
