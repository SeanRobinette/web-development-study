import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

// Combine the user's name into one string
function formatUser(user) {
    return user.firstName + ' ' + user.lastName;
}

// Get a greeting, given a user
function getGreeting(user) {
    if(user)
        return 'Hello, ' + formatUser(user) + '!';
    else
        return 'Hello, nobody. I\'m lonely. :('
}

// Me!
const sean = {
    firstName: 'Sean',
    lastName: 'Robinette'
}

// An element showing two greetings, using JSX
const element = (
    <div>
        <h1>
            {getGreeting(sean)}
        </h1>
        <h1>
            {getGreeting(null)}
        </h1>
    </div>
    );

// The same element using React.createElement()
const sameElement = React.createElement(
    'div', {},
    React.createElement(
        'h1', {},
        getGreeting(sean)
    ),
    React.createElement(
        'h1', {},
        getGreeting(null)
    ),
)

// Combining elements
const body = (
    <div>
        <h2>JSX</h2>
        {element}
        <h2>React.createElement()</h2>
        {sameElement}
    </div>
    )

ReactDOM.render(
    body, 
    document.getElementById('root')
    );

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
