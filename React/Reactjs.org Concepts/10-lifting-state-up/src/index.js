import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';

const scaleNames = {
    c: 'Celsius',
    f: 'Fahrenheit'
};

function toCelsius(fahrenheit) {
  return (fahrenheit - 32) * 5 / 9;
}

function toFahrenheit(celsius) {
  return (celsius * 9 / 5) + 32;
}
function tryConvert(temperature, converter) {
    const input = parseFloat(temperature);
    if(Number.isNaN(input))
        return '';
    const output = converter(temperature);
    const rounded = Math.round(output * 1000) / 1000;
    return rounded.toString();
}
class TemperatureInput extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }
    handleChange(e) {
        this.props.onTemperatureChanged(e.target.value);
    }
    render() {
        const temperature = this.props.temperature;
        const scale = this.props.scale;
        return (
            <fieldset>
                <legend>Enter temperature in {scaleNames[scale]}:</legend>
                <input value={temperature} onChange={this.handleChange} />
            </fieldset>
        );
    }
}
function BoilingVerdict(props) {
    if (props.celsius >= 100)
        return <p>The water would boil.</p>;
    else
        return <p>The water would not boil.</p>;
}

class Calculator extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            temperature: '',
            scale: 'c'
        };
        this.handleCelsuisChange = this.handleCelsuisChange.bind(this);
        this.handleFahrenheitChange = this.handleFahrenheitChange.bind(this);
    }
    handleCelsuisChange(value) {
        this.setState({temperature: value, scale: 'c'});
    }
    handleFahrenheitChange(value) {
        this.setState({temperature: value, scale: 'f'});
    }
    render() {
        const scale = this.state.scale;
        const temperature = this.state.temperature;
        const celsius = scale === 'c' ? temperature : tryConvert(temperature, toCelsius);
        const fahrenheit = scale === 'f' ? temperature : tryConvert(temperature, toFahrenheit);
        console.log(celsius);
        console.log(fahrenheit);
        return (
            <div>
                <TemperatureInput 
                    scale="f"
                    temperature={fahrenheit}
                    onTemperatureChanged={this.handleFahrenheitChange} />
                <TemperatureInput
                    scale="c"
                    temperature={celsius}
                    onTemperatureChanged={this.handleCelsuisChange} />
                <BoilingVerdict celsius={celsius} />
            </div>
        );
    }
}
let body = (
    <div>
    <h1>10) Lifting State Up</h1>
    <Calculator />
    </div>
);

ReactDOM.render(body, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
