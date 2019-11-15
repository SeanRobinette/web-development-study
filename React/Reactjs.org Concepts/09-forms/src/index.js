import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';

class EssayForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value.toUpperCase()});
    }
    handleSubmit(event) {
        console.log('An essay: ' + this.state.value);
        event.preventDefault();
    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <h2>Write an Essay</h2>
                <label>
                    Essay:
                    <textarea type="text" value={this.state.value} onChange={this.handleChange} />
                </label>
                <input type="submit">
                </input>
            </form>
        );
    }
}

class FlavorForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            value: ['coconut','lime']
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(event) {
        const values = [];
        for(let i=0;i<event.target.options.length;i++) {
            const opt = event.target.options[i];
            if(opt.selected)
                values.push(opt.value);
        };
        this.setState({value: values});
    }
    handleSubmit(event) {
        console.log(this.state.value);
        event.preventDefault();
    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <h2>Choose some Flavors</h2>
                <label>
                    Pick your favorite flavor(s):
                    <select multiple={true} value={this.state.value} onChange={this.handleChange}>
                        <option value="grapefruit">Grapefruit</option>
                        <option value="lime">Lime</option>
                        <option value="coconut">Coconut</option>
                        <option value="mango">Mango</option>
                    </select>
                </label>
                <input type="submit" value="Submit" />
            </form>
        );
    }
}

class Reservation extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isGoing: true,
            numberOfGuests: 2
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value; // use "checked" for checkboxes
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    handleSubmit(event) {
        console.log(this.state);
        event.preventDefault();
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <h2>Reservation</h2>
                <label>
                    Is going:
                    <input
                        type="checkbox"
                        name="isGoing"
                        checked={this.state.isGoing}
                        onChange={this.handleChange} />
                    <br />
                    <input 
                        type="number" 
                        name="numberOfGuests"
                        value={this.state.numberOfGuests}
                        onChange={this.handleChange} />
                    <input type="submit" value="Submit" />
                </label>
            </form>
        );
    }
}
const body = (
    <div>
        <EssayForm />
        <FlavorForm />
        <Reservation />
    </div>
);

ReactDOM.render(body, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
