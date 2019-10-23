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
ReactDOM.render(<ActionLink />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
