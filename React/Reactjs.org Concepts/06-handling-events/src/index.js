import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

class ActionLink extends React.Component {
    handleClick(e) {
        e.preventDefault();
        console.log('The link was clicked!');
    }
    render() {
        return(
            <a href="#" onClick={this.handleClick}>Click me!</a>
        );
    }
}
class Toggle extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isToggleOn: true};

        // Bind the handler so that `this` always refers to this object and 
        // not the handler's caller
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        this.setState(state => ({
            isToggleOn: !state.isToggleOn
        }));
    }

    render() {
        return(
            <button onClick={this.handleClick}>
                {this.state.isToggleOn ? 'ON' : 'OFF'}
            </button>
        );
    }
}
// Using an arrow function ensures `this` binding, but creates the function for every new instance
class LoggingButton extends React.Component {
    handleClick() {
        console.log('this is:' + this);
    }

    render() {
        return(
            <button onClick={(e) => this.handleClick(e)}>Test</button>
        )
    }
}

const body = (
    <div>
        <ActionLink /><br/>
        <Toggle /><br/>
        <LoggingButton />
    </div>
)
ReactDOM.render(body, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
