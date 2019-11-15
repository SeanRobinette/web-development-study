import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';

function FancyBorder(props) {
    return (
        <div className="FancyBorder">
            {props.children}
        </div>
    );
}
function Dialog(props) {
    return (
        <FancyBorder>
            <h1 className="Dialog-title">{props.title}</h1>
            <div>{props.children}</div>
        </FancyBorder>
    );
}
function WelcomeDialog(props) {
    return (
        <Dialog title="Welcome!">
            <p>This is some pretty cool content!</p>
        </Dialog>
    );
}
class SignUpDialog extends React.Component {
    constructor(props) {
        super(props);
        this.state = {login: ''};
        this.handleChange = this.handleChange.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
    }
    handleChange(e) {
        this.setState({login: e.target.value});
    }
    handleLogin() {
        console.log(this.state.login + ' logged in!');
    }
    render() {
        const login = this.state.login;
        return (
            <Dialog title="Sign Up!">
                <input type="text" value={login} onChange={this.handleChange} />
                <button onClick={this.handleLogin}>Log In</button>
            </Dialog>
        );
    }
}
function SplitPane(props) {
    return (
        <div class="SplitPane">
            <div class="SplitPane-left">{props.left}</div>
            <div class="SplitPane-right">{props.right}</div>
        </div>
    );
}
function Contacts(props) {
    return (
        <div className="Contacts">{props.children}</div>
    );
}
function Chat(props) {
    return (
        <div className="Chat">{props.children}</div>
    );
}
const body = (
    <div style={{width:'100%', height:'100%'}}>
        <h1>Composition vs Inheritance</h1>
        <WelcomeDialog />
        <SignUpDialog />
        <SplitPane
            left={<Contacts />}
            right={<Chat />} 
            />
    </div>
);

ReactDOM.render(body, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
