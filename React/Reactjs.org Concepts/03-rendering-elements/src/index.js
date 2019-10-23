import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

// Update the view once per second
// Note that the entire element is generated once per update, because elements are immutable
// React handles making sure that the DOM is only updated with changes that are actually needed
function tick() {
    const element = (
        <div>
            <h1>Hello, world!</h1>
            <h2>It is {new Date().toLocaleTimeString()}.</h2>
        </div>
        )
    ReactDOM.render(element, document.getElementById('root'));
}

const ticker = setInterval(tick, 1000)

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
