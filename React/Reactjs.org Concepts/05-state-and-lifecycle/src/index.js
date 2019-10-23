import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

// Component to show the date in a formatted <span>
// Does not care how the prop is set
class FormattedDate extends React.Component {
    render() {
        return <span>{this.props.date.toLocaleTimeString()}</span>
    }
}

// Component that fully encapsulates the features of a Clock object
class Clock extends React.Component {
    constructor(props) {
        super(props);

        // Assigning state here is okay because this is the constructor
        this.state = {
            date: new Date(),
            count: 0
        }
    }

    // Lifecycle hooks -- set up the timer and clear it on mount/unmount
    componentDidMount() {
        this.timerID = setInterval(() => this.tick(), 1000);
    }
    componentWillUnmount() {
        clearInterval(this.timerID);
    }

    // State logic
    tick() {
        // Always use this.setState, never this.state.XXXX =
        // Here we're using (state,props) => to increment the count because it depends
        // on the existing state and props. These values may change asynchronously,
        // but this notation ensures that the correct previous state and props are used
        this.setState((state, props) => ({
            date: new Date(),
            count: state.count + props.increment
        }));
    }

    // Render
    render() {
        return (
            <div>
                <h1>Hello, world!</h1>
                <h2>It is <FormattedDate date={this.state.date}/></h2>
            </div>
        );
    }
}

// Render our Clock object!
ReactDOM.render(<Clock />, document.getElementById('root'))

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
